#!/usr/bin/python3

format_dictionary = __import__('pokemon').format_dictionary


token_store = '{"Ivysaur": 75, "Butterfree": 20, "Blastoise": 42, "Charmander": 66 }'
my_list = "Wartortle Blastoise Charmeleon Squirtle Metapod Charmander"


token_store1 = '{"Butterfree": 28, "Vileplume": 42, "Mankey": 31, "Weezing": 86, "Raichu": 89, "Charizard": 66, "Venomoth": 13, "Golduck": 26, "Porygon": 26, "Victreebel": 27, "Paras": 64, "Hypno": 98, "Scyther": 78, "Spearow": 49, "Magmar": 56, "Weedle": 74, "Pidgeotto": 68, "Mewtwo": 35, "Lickitung": 90, "Jolteon": 47, "Seel": 97, "Kabutops": 26, "Wigglytuff": 66, "Chansey": 34, "Flareon": 92, "Exeggcute": 62, "Pidgey": 27, "Eevee": 99, "Kabuto": 13, "Machop": 65, "Dratini": 88, "Exeggutor": 45, "Diglett": 10, "Electrode": 79, "Raticate": 65, "Alakazam": 58, "Primeape": 82, "Magnemite": 36, "Tauros": 91, "Drowzee": 87, "Graveler": 78, "MrMime": 80, "Kakuna": 70, "Doduo": 21, "Starmie": 45, "Zapdos": 58, "Magneton": 31, "Koffing": 16, "Parasect": 39, "Muk": 86, "Poliwhirl": 54, "Meowth": 97, "Ekans": 93, "Abra": 78, "Fearow": 64}'

my_list1 = "Psyduck Tentacruel Meowth Nidorino Scyther Diglett Poliwhirl Starmie Shellder Haunter Vileplume Primeape Venomoth Magnemite Muk Geodude Butterfree Voltorb Onix Raticate Abra Fearow Sandshrew Tangela Ponyta Graveler Exeggutor Persian Jynx Dugtrio Ekans Farfetchd MrMime Electrode Poliwrath Mew Spearow Ninetales Gastly Doduo Raichu Venonat Pikachu Squirtle Cloyster Parasect Growlithe Victreebel Tentacool Wartortle Gengar Vulpix Goldeen Nidoqueen Ivysaur Charmeleon Weezing Krabby Dodrio Golduck Porygon Drowzee Vaporeon Poliwag"

print("input ------------------------------")
print(token_store)
print(my_list)
print("output -----------------------------")
print(format_dictionary(token_store))
print("---------------------------------------", end="\n")

print("input ------------------------------")
print(token_store1)
print(my_list1)
print("output ------------------------------")
print(format_dictionary(token_store1))
print("---------------------------------------", end="\n")
