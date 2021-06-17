#!/usr/bin/python3
"""
Modulo for determing if a coordenate belong to an area
"""


def check_interval(value, interval):
    "check if value is in the interval"
    return value >= interval[0] and value <= interval[1]


def create_interval(value, dimension):
    "create a list of coordenates"
    dimension /= 2
    return ([value - dimension, value + dimension])


if __name__ == "__main__":

    height = int(input("Enter height of the rectagule: "))
    width = int(input("Enter width of the rectagule: "))

    x = int(input("Enter coordenate x: "))
    y = int(input("Enter coordenate y: "))
    point_x = int(input("Enter coordenate x: "))
    point_y = int(input("Enter coordenate y: "))

    values_x = create_interval(x, height)
    values_y = create_interval(y, width)

    print(check_interval(point_x, values_x)
          and check_interval(point_y, values_y))
