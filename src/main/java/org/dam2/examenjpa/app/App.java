package org.dam2.examenjpa.app;

import org.dam2.examenjpa.acciones.Opcion1;
import org.dam2.examenjpa.acciones.Opcion2;
import org.dam2.examenjpa.acciones.Opcion3;
import org.dam2.examenjpa.acciones.Opcion4;
import org.dam2.examenjpa.acciones.Opcion5;
import org.dam2.examenjpa.acciones.Opcion6;
import org.dam2.utilidadesmenu.AppMenu;
import org.dam2.utilidadesmenu.MenuItem;

/**
 * Los paquetes Utilidadeshibernate y utilidadesmenu,
 * han sido dados por el profesor.
 */
public class App extends AppMenu
{
	public App ()
	{
		// cargar opciones del menu
		addOpcion(new MenuItem("Cargar datos", 1,new Opcion1()));
		addOpcion(new MenuItem("Insertar Producto", 2,new Opcion2()));
		addOpcion(new MenuItem("Realizar Venta", 3,new Opcion3()));
		addOpcion(new MenuItem("Querys", 4,new Opcion4()));
		addOpcion(new MenuItem("Mostrar Productos", 5,new Opcion5()));
		addOpcion(new MenuItem("Mostrar Ventas", 6,new Opcion6()));
		
	}
    public static void main( String[] args )
    {
        App app = new App();
        
        app.run();
    }
}
