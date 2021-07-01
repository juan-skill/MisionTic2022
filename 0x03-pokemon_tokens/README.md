# Pokemon token

Fernando es un ávido coleccionista de láminas Pokémon y se encuentra de viaje en Japón, específicamente se encuentra visitando Tokio. Recorriendo la ciudad encontró un sector con varias tiendas especializadas que venden láminas Pokémon, y luego de una rápida inspección de las tiendas se dio cuenta que algunas de ellas difícilmente las encontraría en Colombia.

A continuación, se lista la colección completa de las láminas Pokémon: 

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

Como buen coleccionista, Fernando carga consigo una lista de las láminas Pokémon que le faltan para completar su colección, y quiere utilizar todo el dinero del que dispone en el momento para comprar tantas láminas como pueda de dicha lista, ya que difícilmente tendría opción de volver a Japón en el corto plazo, sin embargo, el dinero es escaso, así que su idea es optimizar de la mejor manera el uso del dinero, y poder comprar la mayor cantidad de láminas Pokémon con el dinero disponible.

Sin embargo, las tiendas no venden láminas Pokémon al detal, solo al por mayor, lo que obliga a comprarlas todas en una sola tienda, tampoco las venden por internet, la compra debe realizarse de manera presencial, además cada tienda tiene una disponibilidad diferente de láminas Pokémon y usualmente cada lámina es vendida a un precio diferente en cada tienda, precio que depende de su rareza.

El dilema de Fernando es elegir la tienda en la que pueda comprar la mayor cantidad de láminas Pokémon con el dinero disponible, por lo que Fernando procede a preguntar en cada tienda cuales láminas tienen disponibles a la venta y a que precio las venden. A modo de ejemplo, en una de las tiendas, estas son las láminas Pokémon disponibles y su precio en dólares:

Ejemplo: Láminas Pokémon disponibles en una tienda

## Nombre: Precio en dólares

Ivysaur: 75

Butterfree: 20

Blastoise: 42

Charmander: 66


Esta información también puede ser representada como un diccionario en formato JSON así:

{"Ivysaur": 75, "Butterfree": 20, "Blastoise": 42, "Charmander": 66}


Fernando luego compara dicha tabla con su lista de las láminas Pokémon que le faltan para completar su colección, a modo de ejemplo, su lista de láminas faltantes es:

Ejemplo: Láminas Pokémon que faltan para completar la colección

## ID: Nombre

8: Wartortle

9: Blastoise

5: Charmeleon

7: Squirtle

11: Metapod

4: Charmander


Al hacer la comparación se da cuenta que de las laminas Pokémon que le faltan, solo puede comprar 2 en esa tienda: Blastoise y Charmander, y el precio total a pagar seria de 108 dólares:

Ejemplo: Laminas Pokémon que le faltan y que puede conseguir en la tienda

## Nombre: Precio en dólares

Blastoise: 42

Charmander: 66

Precio Total: 108


Se muestra a continuación el ejemplo anterior en formato de Entradas / Salidas:

Entrada

{"Ivysaur": 75, "Butterfree": 20, "Blastoise": 42, "Charmander": 66}
Wartortle Blastoise Charmeleon Squirtle Metapod Charmander

Salida

108
Blastoise Charmander


Crear un programa en lenguaje de programación Python que reciba como datos de entrada un diccionario en formato JSON con las láminas Pokémon disponibles en una tienda y su precio correspondiente, además de la lista de las láminas que le faltan para completar su colección (los nombres deben estar separados por un espacio en blanco), y muestre como resultado las láminas Pokémon disponibles en la tienda y que se encuentran en su lista para completar la colección (también separados por espacio en blanco), así como el precio total si las comprara. Dado que el dato que mas le interesa a Fernando es el precio total que pagaría, este debe ser mostrado en la primera línea.
