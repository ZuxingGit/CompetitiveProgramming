import java.util.ArrayList;
import java.util.Scanner;

public class TowerofTablets {
    // TIME LIMIT EXCEEDED
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // the number of tablets
        int n = scanner.nextInt();
        scanner.nextLine();

        ArrayList<String> tablets = new ArrayList<>();

        // the glyphs of tablets
        for (int i = 0; i < n; i++) {
            String glyph = scanner.nextLine();
            tablets.add(glyph);
        }

        boolean isPossible = false;

        for (int i = 0; i < tablets.size(); i++) {
            ArrayList<String> oldList = new ArrayList<>(tablets);
            ArrayList<String> newList = new ArrayList<>();
            newList.add(tablets.get(i));
            oldList.remove(i);

            if (reorderTablets(oldList, 0, newList) || reorderTablets(oldList, 1, newList)) {
                isPossible = true;
                for (String tablet : newList) {
                    System.out.println(tablet);
                }
                break;
            }
        }

        if (!isPossible) {
            System.out.println(-1);
        }

        scanner.close();
    }

    public static boolean reorderTablets(ArrayList<String> oldList, int position, ArrayList<String> newList) {
        if (oldList.isEmpty()) {
            return true;
        }

        for (int i = 0; i < oldList.size(); i++) {
            String currentTablet = oldList.get(i);
            String lastTablet = newList.get(newList.size() - 1);

            // Check if the glyph at the given position matches
            if (currentTablet.charAt(position) == lastTablet.charAt(position)) {
                ArrayList<String> newOldList = new ArrayList<>(oldList);
                ArrayList<String> newNewList = new ArrayList<>(newList);

                newNewList.add(currentTablet);
                newOldList.remove(i);

                // Try both positions recursively
                if (reorderTablets(newOldList, 1 - position, newNewList)) {
                    newList.clear();
                    newList.addAll(newNewList);
                    return true;
                }
            }
        }

        return false;
    }
}