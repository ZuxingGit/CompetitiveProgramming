import java.util.Scanner;

public class HelloAdelaide {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // the number of people
        int n = scanner.nextInt();
        scanner.nextLine();

        // the names of people
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            sayHello(name);
        }

        scanner.close();
    }

    public static void sayHello(String name) {
        System.out.println("Hello " + name + "!");
    }
}
