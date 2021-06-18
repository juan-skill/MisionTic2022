#!/usr/bin/python3
"""
This is the "find_winner" module.
The soccer module provide a function, find_winner()
"""


def find_winner(list_jimena, list_pedro, win_teams):
    """
    find the winner between Jimena and Pedro
    """
    print(list_jimena)
    print(list_pedro)
    print(win_teams)

    counter_two = {"jimena": 0, "pedro": 0}
    compare_list = []
    for team in win_teams:

        counter_jimena = False
        counter_pedro = False

        # print(team)
        if team in list_jimena:
            counter_jimena = True

        if team in list_pedro:
            counter_pedro = True

        if counter_jimena:
            counter_two["jimena"] += 1

        if counter_pedro:
            counter_two["pedro"] += 1

        # print(counter_two)

        if counter_two["jimena"] > counter_two["pedro"]:
            compare_list.append("J")
        elif counter_two["jimena"] < counter_two["pedro"]:
            compare_list.append("P")
        elif counter_two["jimena"] == counter_two["pedro"]:
            compare_list.append("E")

        # print(compare_list)

    print("".join(compare_list), end=" ")

    return counter_two


if __name__ == "__main__":
    import doctest
    doctest.testfile("test.txt")
