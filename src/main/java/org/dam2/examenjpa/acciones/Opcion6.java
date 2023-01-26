package org.dam2.examenjpa.acciones;

import org.dam2.utilidadesmenu.MenuAction;

public class Opcion6 extends AccionesAlmacen implements MenuAction {

	@Override
	public void doMenuAction() {
		// TODO Auto-generated method stub
		ventaDAO.findAll().forEach(System.out::println);
	}

}
