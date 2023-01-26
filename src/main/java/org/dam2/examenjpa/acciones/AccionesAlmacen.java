package org.dam2.examenjpa.acciones;

import java.util.Arrays;
import java.util.function.Consumer;

import org.dam2.examenjpa.modelo.Cliente;
import org.dam2.examenjpa.modelo.Direccion;
import org.dam2.examenjpa.modelo.Producto;
import org.dam2.examenjpa.modelo.ProductoNoPerecedero;
import org.dam2.examenjpa.modelo.ProductoPerecedero;
import org.dam2.examenjpa.modelo.Proveedor;
import org.dam2.examenjpa.modelo.Venta;
import org.dam2.utilidadeshibernate.GenericJPADAO;

public class AccionesAlmacen {

	protected static GenericJPADAO<Cliente,String> clienteDAO = new GenericJPADAO<>(Cliente.class,"examenjpa");
	protected static GenericJPADAO<Direccion,String> direccionDAO = new GenericJPADAO<>(Direccion.class,"examenjpa");
	protected static GenericJPADAO<Producto,String> productoDAO = new GenericJPADAO<>(Producto.class,"examenjpa");
	protected static GenericJPADAO<ProductoNoPerecedero,String> prodNoPerDAO = new GenericJPADAO<>(ProductoNoPerecedero.class,"examenjpa");
	protected static GenericJPADAO<ProductoPerecedero,String> prodPerDAO = new GenericJPADAO<>(ProductoPerecedero.class,"examenjpa");
	protected static GenericJPADAO<Proveedor,String> proveedorDAO = new GenericJPADAO<>(Proveedor.class,"examenjpa");
	protected static GenericJPADAO<Venta,String> ventaDAO = new GenericJPADAO<>(Venta.class,"examenjpa");
	
	protected Consumer<Object[]> impVarios= (a)-> System.out.println(Arrays.stream(a).reduce((o1,o2)-> o1+" , "+o2).get());
	protected Runnable noDatos=()-> System.out.println(" No hay Datos");

}
