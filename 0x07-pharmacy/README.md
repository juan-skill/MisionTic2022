## IMPLEMENTACION DE UN MODELO DE DATOS APLICACIÓN DE VENTAS PARA LA DROGUERIA TIC

La Droguería Tic decidió implementar su sistema para manejar las ventas de sus productos, La droguería desea comenzar a implementar el modelo de datos para la aplicación inicial que quiere hacer. 

Para ello quiere implementar la Tabla productos, la cual tiene: un código (int), nombre, precio, marca, tipo (cuyo valor por defecto es: medicamento) y un campo para observaciones en el que coloca información adicional de los productos, por ejemplo: la concentración de un medicamento, o la presentación en la que viene un alimento.

También quiere almacenar la información de sus clientes.  Para ello le interesa almacenar el nombre, la dirección, el teléfono, el barrio y la identificación la cual será la forma de identificar de manera única a un cliente en la base de datos. 

Por último, se desea almacenar la información sobre los proveedores de los productos y la información de la factura. Los campos de identificación para el producto es un valor (int), y cada factura se identifica de manera única con el id del producto, id del cliente y el id de la factura que es un valor int. Un ingeniero les desarrolló el siguiente modelo entidad relación, el cual usted debe implementar en MySql.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
