package org.dam2.examenjpa.acciones;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.dam2.examenjpa.modelo.ProductoPerecedero;
import org.dam2.utilidadesmenu.MenuAction;

public class Opcion4 extends AccionesAlmacen implements MenuAction {

	@Override
	public void doMenuAction() {
		
		//a)
		List<ProductoPerecedero> productos=(List<ProductoPerecedero>) productoDAO.executeQuery("select p from ProductoPerecedero p ").collect(Collectors.toList());
		
		System.out.println(productos.stream().filter(p -> p.getFechaCad().isBefore(LocalDate.now()))
		.mapToDouble(p-> p.getStock()*p.getPvd()).sum());
	
		//b)
		productoDAO.executeQuery("select c.nombre from Venta v join v.cliente c where v.cliente.direccion.codPostal=v.producto.proveedor.direccion.codPostal").forEach(System.out::println);
	}

}
