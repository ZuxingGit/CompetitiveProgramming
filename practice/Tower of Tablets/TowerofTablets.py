def reorder_tablets(old_list, position, new_list):
    if not old_list:
        return True

    for i in range(len(old_list)):
        current_tablet = old_list[i]
        last_tablet = new_list[-1]

        # Check if the glyph at the given position matches
        if current_tablet[position] == last_tablet[position]:
            # Create new lists for backtracking
            new_old_list = old_list[:i] + old_list[i + 1 :]
            new_new_list = new_list + [current_tablet]

            # Try both positions recursively
            if reorder_tablets(new_old_list, 1 - position, new_new_list):
                new_list.clear()
                new_list.extend(new_new_list)
                return True

    return False


def main():
    n = int(input())  # Number of tablets
    tablets = []

    # Read the glyphs of tablets
    for _ in range(n):
        glyph = input().strip()
        tablets.append(glyph)

    is_possible = False

    for i in range(len(tablets)):
        old_list = tablets[:i] + tablets[i + 1 :]
        new_list = [tablets[i]]

        if reorder_tablets(old_list, 0, new_list) or reorder_tablets(
            old_list, 1, new_list
        ):
            is_possible = True
            for tablet in new_list:
                print(tablet)
            break

    if not is_possible:
        print(-1)


if __name__ == "__main__":
    main()
