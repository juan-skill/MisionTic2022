## Drogueria Tic

La droguería “Droguería Tic” vende productos para el bienestar de la población en general, y ha ampliado la oferta de sus productos, por lo que requiere un programa para tener almacenada la información y poder realizar las búsquedas de una manera más rápida.

Cada Producto tiene un nombre (String), un codigo (int), un precio(double), y una marca (String).  En este momento la droguería vende dos tipos de productos:  Medicamentos y Alimentos no perecederos.  De los Medicamentos les interesa almacenar adicionalmente la concentración(String)(ej: 250mg, 120 ml, 100mg);  Mientras que de los alimentos les interesa almacenar el tipo de presentación (String)(ej: paquete de 30 unidades, 500 gr, 125 gr).

Le han encargado a usted que desarrolle un programa en Java, haciendo uso de la programación Orientada a Objetos, que implemente una solución siguiendo las especificaciones del siguiente diagrama de clases:


Procesar entrada

En la clase DrogueriaTic, se debe definir el método procesarEntrada que realiza las siguientes operaciones:

Agregar Prendas: Opción 1

Se puede añadir un Producto de tipo Medicamento con el siguiente comando:

1&Medicamento&nombre&codigo&precio&marca&concentracion

Ejemplo:

1&Medicamento&Acetaminofen&1234&5000&Bayun&500mg

 Se puede añadir un producto de tipo Alimentos con el siguiente comando:

1&Alimentos&nombre&codigo&precio&marca&presentacion

 

Ejemplo:

1&Alimentos&chocolate&8765&6500&chocoFabri&paquete x 10 unidades

Listar ítems del inventario: Opción 2

Se debe mostrar la frase: “***DrogueriaTic*** “ Seguida por el producto en el orden en el que fueron agregadas.

Si se trata de un Medicamento se mostrará así. Recuerde que \t implica correr el ítem unos espacios a la derecha:

\tProducto Medicamento - codigo: 1234

\tnombre: Acetaminofen

\tprecio: 5000

\tmarca: Bayun

\tconcentracion: 500mg

 

Si se trata de un alimento se mostrará así:

\tProducto Alimentos - codigo: 8765

\tnombre: chocolate

\tprecio: 6500

\tmarca: chocoFabri

\tpresentacion: paquete x 10 unidades



Salir: Opción 3

Nota 1: Observe que el único comando que tiene salida es el listar.

Nota 2: En este ejercicio se requiere subir cuatro archivos. 

Uno correspondiente a la clase Producto llamado Producto.java,
otro correspondiente al medicamento llamado Medicamento.java
otro correspondiente al Alimento llamado Alimentos.java
otro correspondiente a la droguería llamado DrogueriaTic.java (aquí va el main)

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.
