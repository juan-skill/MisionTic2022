#!/usr/bin/python3
"""
This is the "compare_token" module.
The pokemon module provide a function, compare_token()
"""


def format_dictionary(json_info):
    """
    converters a string to JSON format in python (dictionary structure)
    """
    store_colection = {}

    # print(json_info)

    items_string = json_info[1:len(json_info) - 1].split(",")

    for item in items_string:
        item_simple = item.split(":")

        store_colection[str(
            item_simple[0].strip(" \"':"))] = int(item_simple[1])

    return store_colection


def compare_token(list_token, **store_colection):
    """
    Comprares my token list with the token store list
    """

    my_tokens = {}
    price_total = 0
    for pokemon_name, price in store_colection.items():
        if pokemon_name in list_token:
            my_tokens[pokemon_name] = price
            price_total += price

    token_buy = []
    for pokemon_name in my_tokens.keys():
        token_buy.append(pokemon_name)

    return "{:d}\n{:s}".format(
        price_total, " ".join(str(item) for item in token_buy))


if __name__ == "__main__":
    import doctest
    doctest.testfile("test.txt")
