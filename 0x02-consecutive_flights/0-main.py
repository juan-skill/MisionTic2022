#!/usr/bin/python3

find_frecuency = __import__('consecutive_flights').find_frecuency

print(find_frecuency("C C G G G F F F C C"))
print("---------------------------------------", end="\n")
print(find_frecuency("V V F F F I N X X X J J G K K K K U U A"))
print("---------------------------------------", end="\n")
print(find_frecuency("U U U T E E E E W W W D D U U U V V L L A A A A T"))
print("---------------------------------------", end="\n")
print(find_frecuency("X X S I J V V V V C K K K N N N N W E E E E"))
print("---------------------------------------", end="\n")
print(find_frecuency("I I I C I I I E W W A A A A G G G G E E E U U M M M"))
print("---------------------------------------", end="\n")
