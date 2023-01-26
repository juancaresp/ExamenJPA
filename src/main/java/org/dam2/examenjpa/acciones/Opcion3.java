package org.dam2.examenjpa.acciones;

import java.time.LocalDate;

import org.dam2.examenjpa.modelo.Producto;
import org.dam2.examenjpa.modelo.Venta;
import org.dam2.utilidadesmenu.MenuAction;

import daw.com.Teclado;

public class Opcion3 extends AccionesAlmacen implements MenuAction {

	@Override
	public void doMenuAction() {
		
		String nif;
		String idPro;
		int cantidad;
		
		clienteDAO.executeQuery("Select c.nif from Cliente c").forEach(System.out::println);

		nif=Teclado.leerString("Nif del cliente: ");

		if(clienteDAO.findById(nif).isPresent()) {
			
			productoDAO.executeQuery("select p.nombre,p.nrefer from Producto p").forEach(impVarios);
			
			do {
				idPro=Teclado.leerString("Id Producto");
			}while(productoDAO.findById(idPro).isEmpty());
			
			Producto p=productoDAO.findById(idPro).get();
			
			do {
				cantidad=Teclado.leerInt("Cantidad");
			}while(p.getStock()<cantidad);
			
			Venta v=Venta.builder()
					.producto(p)
					.cliente(clienteDAO.findById(nif).get())
					.cantidad(cantidad)
					.fechaCompra(LocalDate.now())
					.build();
			
			ventaDAO.save(v);
			
			p.setStock(p.getStock()-cantidad);
			
			productoDAO.update(p);
			
			System.out.println("Compra Relaizada correctamente");
			System.out.println("Mandar correo a " + p.getProveedor().getEmail()+ "por venta de "+p.getNombre());
			
		}
	}

}
