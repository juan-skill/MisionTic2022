# Pokemon token

Fernando, nuestro ferviente coleccionista de láminas Pokémon, regresó de su viaje a Japón, y está ansioso de mostrar a sus amigos todas las laminas que compró en el viaje. Todos están impresionados por las laminas adquiridas por Fernando, y naturalmente sus amigos desean intercambiar laminas.

Se listan todas las laminas Pokémon disponibles:

## Colección Completa de laminas Pokémon

ID: Nombre

1: Bulbasaur

2: Ivysaur

3: Venusaur

4: Charmander

5: Charmeleon

6: Charizard

7: Squirtle

8: Wartortle

9: Blastoise

10: Caterpie

11: Metapod

12: Butterfree

13: Weedle

14: Kakuna

15: Beedrill

16: Pidgey

17: Pidgeotto

18: Pidgeot

19: Rattata

20: Raticate

21: Spearow

22: Fearow

23: Ekans

24: Arbok

25: Pikachu

26: Raichu

27: Sandshrew

28: Sandslash

29: Nidoran(Hembra)

30: Nidorina

31: Nidoqueen

32: Nidoran(Macho)

33: Nidorino

34: Nidoking

35: Clefairy

36: Clefable

37: Vulpix

38: Ninetales

39: Jigglypuff

40: Wigglytuff

41: Zubat

42: Golbat

43: Oddish

44: Gloom

45: Vileplume

46: Paras

47: Parasect

48: Venonat

49: Venomoth

50: Diglett

51: Dugtrio

52: Meowth

53: Persian

54: Psyduck

55: Golduck

56: Mankey

57: Primeape

58: Growlithe

59: Arcanine

60: Poliwag

61: Poliwhirl

62: Poliwrath

63: Abra

64: Kadabra

65: Alakazam

66: Machop

67: Machoke

68: Machamp

69: Bellsprout

70: Weepinbell

71: Victreebel

72: Tentacool

73: Tentacruel

74: Geodude

75: Graveler

76: Golem

77: Ponyta

78: Rapidash

79: Slowpoke

80: Slowbro

81: Magnemite

82: Magneton

83: Farfetchd

84: Doduo

85: Dodrio

86: Seel

87: Dewgong

88: Grimer

89: Muk

90: Shellder

91: Cloyster

92: Gastly

93: Haunter

94: Gengar

95: Onix

96: Drowzee

97: Hypno

98: Krabby

99: Kingler

100: Voltorb

101: Electrode

102: Exeggcute

103: Exeggutor

104: Cubone

105: Marowak

106: Hitmonlee

107: Hitmonchan

108: Lickitung

109: Koffing

110: Weezing

111: Rhyhorn

112: Rhydon

113: Chansey

114: Tangela

115: Kangaskhan

116: Horsea

117: Seadra

118: Goldeen

119: Seaking

120: Staryu

121: Starmie

122: MrMime

123: Scyther

124: Jynx

125: Electabuzz

126: Magmar

127: Pinsir

128: Tauros

129: Magikarp

130: Gyarados

131: Lapras

132: Ditto

133: Eevee

134: Vaporeon

135: Jolteon

136: Flareon

137: Porygon

138: Omanyte

139: Omastar

140: Kabuto

141: Kabutops

142: Aerodactyl

143: Snorlax

144: Articuno

145: Zapdos

146: Moltres

147: Dratini

148: Dragonair

149: Dragonite

150: Mewtwo

151: Mew

No todas las laminas son iguales, algunas son mas raras que las demás, así que según su rareza se clasifican en clases, listadas a continuación:

## Clases de láminas Pokémon

Número Identificador: Nombre

1: Diamond

2: Gold

3: Silver

4: Bronze

5: Normal

Fernando está un poco abrumado por todo el tiempo y esfuerzo que requeriría el proceso de intercambio de laminas Pokémon con sus amigos, por que usted se ofrece a ayudarle en el proceso, para ello usted se propone crear un módulo en Python llamado laminas_pokemon, que contenga las siguientes 4 funciones listadas y descritas a continuación. Nota: Por practicidad, las funciones no usarán los nombres de las laminas o clases sino sus números identificadores, tanto en los datos de entrada como los de salida:

## 1. Función lista_clases:
- Dada una lista de las clases de todas las láminas Pokémon de Fernando, la función debe retornar una lista con las clases de láminas que se encuentran en la lista de Fernando, en estricto orden en el que son detectadas las clases si son leídas de la primera a la última.

Ejemplos para la función lista_clases()

Entrada
[3,2,1,1,1,3,2,1,1,1]

Salida
[3,2,1]

## 2. Función laminas_faltantes_por_clase:
- Se tiene la lista de las clases de las laminas disponibles para cambiar que tiene un amigo, Fernando la revisa rápidamente y crea una lista de los índices (el conteo inicia desde 0) de las laminas que no tiene de dicha lista. Dada la lista de índices (el conteo inicia desde 0) de laminas que le faltan a Fernando de la lista del amigo, la lista de clases de las laminas del amigo y una clase particular, la función debe retornar una lista con los índices de las laminas de dicha clase particular que le faltan a Fernando.

Ejemplos para la función laminas_faltantes_por_clase()

Entrada
[1,3,6,8]

[3,2,1,1,1,3,2,1,1,1]

1

Salida
[3,8]

## 3. Función laminas_faltantes:
- Dada una lista con las láminas que tiene un amigo y la lista con las láminas que tiene Fernando, la función debe retornar la lista con las láminas que le interesarían intercambiar a Fernando de la lista su amigo.

Ejemplos para la función laminas_faltantes()

Entrada
[3,5,7,10,15,16]
[4,10,5,8]

Salida
[3,7,15,16]

## 4. Función cantidad_laminas_cambiables:
- Dada la lista de láminas que tiene un amigo y la lista de láminas que tiene Fernando, la función debe retornar el número de láminas que pueden cambiar. La lista que maneja cada persona indica los números de las láminas que tienen para cambiar y aquellos números que no están en dicha lista son los que necesitan.

Ejemplos para la función cantidad_laminas_cambiables()

Entrada
[3,5,7,10,15,16]
[4,10,5,8]

Salida
2

Crear un módulo en lenguaje de programación Python llamado laminas_pokemon que contenga únicamente las 4 funciones listadas antes, las cuales deben tener los nombres indicados. Ninguna de las funciones debe mostrar información en la consola usando print(), en cambio, los datos de salida deben ser retornados por la función. Ninguna de las funciones debe recibir información ingresada por el usuario usando input(), en cambio, los datos de entrada serán almacenados en las variables de entrada de la función. El módulo debe estar contenido en un archivo llamado laminas_pokemon.py
