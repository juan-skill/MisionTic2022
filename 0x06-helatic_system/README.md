## Integración de la clase FuncionesProducto al Sistema de HelaTic

La Heladería HelaTic necesita de su ayuda para crear una clase en Java llamada FuncionesProducto que pueda integrar a su sistema.  Como la clase se va a integrar a un sistema ya creado, no debe pedir ningún dato del usuario, sólo va a tener funciones que hagan cosas específicas.   La clase FuncionesProducto debe tener únicamente las siguientes cuatro funciones:

* obtenerProductos(ArrayList<String> lista):  Recibe como parámetro un ArrayList<String> lista que contiene los nombres de los productos vendidos por la heladería.  La función debe generar una lista (ArrayList) con los nombres de los productos sin repetición, y la debe retornar. 
Ejemplo: Si la función recibe estos datos:

  lista = ['CHOCOCONO', 'HELADO DE MANÍ', ‘PALETA DE AGUA’, 'HELADO DE MANI', 'PALETA DE MANGO BICHE',  ’CHOCOCONO’]

  La función debe retornar la siguiente lista:
['CHOCOCONO', 'HELADO DE MANI', ‘PALETA DE AGUA’, 'PALETA DE MANGO BICHE']

* obtenerPosicionesProductosFaltantes(ArrayList<Integer> lPos, ArrayList<String> tipos, String cat): Que recibe como parámetro 3 cosas: ArrayList<Integer> lPos, que contiene las posiciones de los productos que faltan;  un ArrayList<String> tipos que contiene los nombres de los productos faltantes, y un String cat que es el nombre de un producto.  La función debe generar y retornar una lista (ArrayList) de posiciones de los productos faltantes.
Ejemplo: 
Si la función recibe estos datos:

 lPos = [0, 1, 4, 5, 6]
 tipos = [‘HELADO MARACUMANGO’, 'CHOCOCONO', 'PALETA DE AGUA', 'HELADO DE MANI', 'PALETA DE MANGO BICHE', ‘HELADO MARACUMANGO’, 'CHOCOCONO']
 cat = ‘HELADO MARACUMANGO’

 Se debe retornar la siguiente lista: [0, 5]

 que es la coincidencia de la lista de posiciones dadas (lPos) con el dato que tiene cat  (‘HELADO MARACUMANGO’ en este ejemplo) en la lista de tipos recibida.

* obtenerFaltantes(ArrayList<String> lOtro, ArrayList<String> lHelaTic):  Para poder realizar un intercambio de productos, esta función recibe dos listas.  una lista (ArrayList<String> ) de productos que vende otra heladería llamada lOtro, y la lista (ArrayList<String> ) de productos que vende HelaTic actualmente llamada lHelaTic.  Se debe retornar una lista (ArrayList<String>) de productos que les interesa de la otra heladería, es decir aquellos productos que vende la otra heladería y no vende HelaTic.

 Ejemplo: si se tiene como entrada:

 lOtro =[‘BANANA SPLIT’, 'CHOCOCONO', ‘PALETA DE FRESA’, ‘PALETA DE CHOCOLATE’, 'PALETA DE AGUA', 'HELADO DE MANI’]
 lHelaTic = [‘HELADO MARACUMANGO’, 'CHOCOCONO', 'PALETA DE AGUA', 'HELADO DE MANI', 'PALETA DE MANGO BICHE', ‘HELADO MARACUMANGO’, 'CHOCOCONO']

 La función debe retornar una lista que contiene: [' BANANA SPLIT’, ‘PALETA DE FRESA’, 'PALETA DE CHOCOLATE']


* obtenerProductosIntercambiables(ArrayList<String> lOtro, ArrayList<String> lHelaTic): Esta función recibe dos listas lOtro (ArrayList<String>) y ArrayList<String> lHelaTic.  La función debe hallar la lista de productos sobrantes de ambas listas ingresadas (lOtro y lHelaTic)  y debe retornar el número (Integer) de productos que se pueden intercambiar entre sí.

 Ejemplo: si se tiene como entrada
 lOtro  =[‘BANANA SPLIT’, 'CHOCOCONO', ‘PALETA DE FRESA’, ‘PALETA DE CHOCOLATE’, 'PALETA DE AGUA', 'HELADO DE MANI’,’FRESAS EN CREMA’]
 lHelaTic = [‘HELADO MARACUMANGO’, 'CHOCOCONO', 'PALETA DE AGUA', 'HELADO DE MANI', 'PALETA DE MANGO BICHE', ‘HELADO MARACUMANGO’, ‘GUANABANAZO’]

* La función debe retornar: 3.  La otra heladería no vende 3 artículos que Helatic si, que en el ejemplo son:  [‘HELADO MARACUMANGO’,  'PALETA DE MANGO BICHE', ‘GUANABANAZO’]. Y HelaTic no vende 4 productos que la otra heladería si, que en el ejemplo son: [‘BANANA SPLIT’, ‘PALETA DE FRESA’, ‘PALETA DE CHOCOLATE’, ‘FRESAS EN CREMA'] , entonces podrían intercambiar máximo 3 artículos.

 Para que sea evaluada correctamente por HelaTic, la función debe retornar un Integer.



 Entrada:

Este programa no requiere entrada. Ni generará salida. Se requiere que usted genere un archivo con el nombre FuncionesProducto.java y que definan los nombres de las funciones dadas y sus parámetros tal cual está especificado en el enunciado. La clase NO debe tener método main()

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
