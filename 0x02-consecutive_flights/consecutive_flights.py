#!/usr/bin/python3
"""
This is the "find_frecuency" module.
The consecutive_flights module provide a function, find_frecuency()
"""


def format_output(list_to_output):
    """
    Preparates the output to print
    """
    return " ".join(str(item) for item in list_to_output)


def find_frecuency(list_flights):
    """
    Determine how often does the consecutive flight's occurrence in a day
    """

    # print(list_flights)

    list_flights = list_flights.split()

    letters = []
    numbers = []
    index = 0
    while index < len(list_flights):

        count = 1
        while (index < len(list_flights) - 1
               and list_flights[index] == list_flights[index + 1]):
            index += 1
            count += 1

        letters.append(list_flights[index])
        numbers.append(count)

        index += 1

    return "{:s}\n{:s}".format(format_output(letters), format_output(numbers))


if __name__ == "__main__":
    import doctest
    doctest.testfile("test.txt")
