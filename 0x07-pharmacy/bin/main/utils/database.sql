-- -----------------------------------------------------
-- Schema pharmacy
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `pharmacy` ;

-- -----------------------------------------------------
-- Schema pharmacy
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pharmacy` DEFAULT CHARACTER SET utf8 ;
USE `pharmacy` ;

-- -----------------------------------------------------
-- Table `proveedor`
-- -----------------------------------------------------
DROP TABLE IF EXISTS proveedor;
CREATE TABLE proveedor (
	pv_codigo    INT PRIMARY KEY,
	pv_nombre    VARCHAR(45) NOT NULL,
	pv_ciudad    VARCHAR(45),
	pv_direccion VARCHAR(45)
);

INSERT INTO proveedor (pv_codigo, pv_nombre, pv_ciudad, pv_direccion) VALUES 
(3345, 'Bayer', 'Rubieville', '697 Metz Road Fostertown, MN 81279-4569'),
(3346, 'Genfar', 'Marquisfurt', '83153 Stanford Suite 053 North Ezra, TX 29981'),
(3347, 'Tecnoquimicas', 'Nolanside', '291 Windler Ridges Sabinamouth, MN 44057-6247'),
(3348, 'Granero su grano', 'Madelineberg', '56254 Kuhic Mall West Mandy, IN 47659-6002'),
(3349, "Nacional de dulces", "Hettingershire", "652 Rita Plains Apt. 546 Andyport, AR 18400")
;


DROP TABLE IF EXISTS cliente;
CREATE TABLE cliente (
	cl_id int    PRIMARY KEY,
	cl_nombre    VARCHAR(45) NOT NULL,
	cl_direccion VARCHAR(45),
	cl_telefono  VARCHAR(15),--
	cl_barrio    VARCHAR(50)
);



INSERT INTO cliente (cl_id, cl_nombre, cl_direccion, cl_telefono, cl_barrio) VALUES
(12333451, 'Julia María Castro', '527 Cantebury Drive', '6465624577', 'Isla del Príncipe Eduardo'),
(1112876321, 'Bernardo Gutierrez Martinez', '137 Roane Hollow', '11030000', 'Saskatchewan'),
(29876543, 'Juan Esteban Mora', '602 Joes Lake', '2329662720', 'Quebec'),
(33876458, 'Lina Milena Ocampo', '183 Williams River', '3335117350', 'Terranova y Labrador'),
(22345765, 'Josefina Lopez Murillo', '624 Hawks Farm', '6462558814', 'Columbia Británica'),
(98765678, 'Samuel Siachoque Trochez', '374 McDonald Drive', '3338443001', 'Nueva Escocia'),
(54322123, 'Carolina Aguado Velez', '365 Liberty Place', '2428664135', 'Columbia Británica')
;

DROP TABLE IF EXISTS producto;
CREATE TABLE producto (
	pro_id   	    INT PRIMARY KEY,
	pro_nombre          VARCHAR(45) NOT NULL,
	pro_precio          DECIMAL(10,1) NOT NULL, --
	pro_marca           VARCHAR(45) NOT NULL, --
	pro_tipo            VARCHAR(40) DEFAULT 'Medicamento',
	pro_observacion     VARCHAR(100),
	proveedor_pv_codigo INT,
	CONSTRAINT
	    FOREIGN KEY (proveedor_pv_codigo)
	    REFERENCES proveedor (pv_codigo)
	    ON DELETE CASCADE
	    ON UPDATE CASCADE
);

INSERT INTO producto (pro_id, pro_nombre, pro_precio, pro_marca, pro_tipo, pro_observacion, proveedor_pv_codigo) VALUES
(2100, 'acetaminofen', 12000, 'Medlineplus','Medicamento', 'Caja por 20 tabletas', 3345),
(2101, 'Arroz D&D', 35000, 'Diana', 'Alimento', 'Presentación por 25 libras', 3348),
(2102, 'Huevos mi gallina', 18000, 'Kique', 'Alimento', 'Panal por 30 unidades', 3348 ),
(2103, 'Bombones de chocolate', 1500, 'otrol', 'Alimento', 'unidad', 3349),
(2104, 'Vitamina c', 23500, 'Medlineplus','Medicamento', 'Presentación efervescente', 3345),
(2105, 'Sorel loción', 35600, 'Medlineplus', 'Medicamento', 'unidad', 3345),
(2106, 'Bicarbonato de sodio', 4560, 'Medlineplus', 'Medicamento', 'Por 500 gr', 3347),
(2107, 'Algodón', 3500, 'Medlineplus', 'Medicamento', 'paquete', 3346),
(2108, 'Acetaminofen', 13500, 'Medlineplus', 'Medicamento', 'Por 500 miligramos', 3346),
(2109, 'Vitamina c', 22600, 'Medlineplus', 'Medicamento', 'Por 100 ui', 3347),
(2110, 'betametasona', 18900, 'Medlineplus', 'Medicamento', 'Presentación por 20 gr', 3347)
;


DROP TABLE IF EXISTS factura;
CREATE TABLE factura (
	fac_id          int AUTO_INCREMENT, -- considerar AUTO_INCREMENT
	producto_pro_id int,
	cliente_cl_id   int,
	fac_fecha       DATETIME NOT NULL, -- considerar DEFAULT TIMESTAMP
        PRIMARY KEY(fac_id, cliente_cl_id, producto_pro_id),
        CONSTRAINT
	    FOREIGN KEY (cliente_cl_id)
	    REFERENCES cliente (cl_id)
	    ON DELETE CASCADE
	    ON UPDATE CASCADE,
	CONSTRAINT
	    FOREIGN KEY (producto_pro_id)
	    REFERENCES producto (pro_id)
	    ON DELETE CASCADE
	    ON UPDATE CASCADE
);


INSERT INTO factura (cliente_cl_id, producto_pro_id, fac_fecha) VALUES
(29876543, 2100, '2020-10-25 20:00:00'),
(22345765, 2105, '2021-03-15 18:30:00'),
(29876543, 2100, '2021-03-17 15:30:20'),
(1112876321, 2101, '2021-05-20 11:30:00'),
(1112876321, 2102, '2021-05-20 11:30:00'),
(29876543, 2102, '2021-03-17 15:30:20'),
(33876458, 2106, '2021-06-22 21:30:00'),
(29876543, 2105, '2021-03-17 15:30:20'),
(54322123, 2105, '2021-01-20 20:30:00'),
(33876458, 2103, '2021-02-15 20:30:20'),
(29876543, 2104, '2020-10-25 20:00:00'),
(1112876321, 2103, '2021-05-21 11:30:00'),
(1112876321, 2102, '2021-05-21 11:30:00'),
(98765678, 2110, '2021-07-21 11:30:00'),
(98765678, 2108, '2021-06-21 11:30:00'),
(12333451, 2109, '2021-06-21 09:30:00'),
(98765678, 2110, '2021-06-22 12:20:00'),
(98765678, 2105, '2021-06-21 11:30:00')
;