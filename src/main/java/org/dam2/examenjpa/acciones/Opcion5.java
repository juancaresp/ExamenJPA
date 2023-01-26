package org.dam2.examenjpa.acciones;

import org.dam2.utilidadesmenu.MenuAction;

public class Opcion5 extends AccionesAlmacen implements MenuAction {

	@Override
	public void doMenuAction() {
		// TODO Auto-generated method stub
		productoDAO.findAll().forEach(System.out::println);
	}

}
