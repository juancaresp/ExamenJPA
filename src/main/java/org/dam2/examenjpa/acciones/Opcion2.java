package org.dam2.examenjpa.acciones;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import org.dam2.examenjpa.modelo.Formato;
import org.dam2.examenjpa.modelo.Producto;
import org.dam2.examenjpa.modelo.ProductoNoPerecedero;
import org.dam2.examenjpa.modelo.ProductoPerecedero;
import org.dam2.utilidadesmenu.MenuAction;

import daw.com.Teclado;

public class Opcion2 extends AccionesAlmacen implements MenuAction {

	Producto p;
	String key;
	@Override
	public void doMenuAction() {
		
		pedirDatos();
		
	}
	
	private void pedirDatos() {
		
		pedirClave();
		pedirDatosEspecificos();
		p.setNrefer(key);
		pedirOtrosDatos();

		productoDAO.save(p);
		
	}

	private void pedirDatosEspecificos() {

		int tipo,formato;
		boolean frio,salir;
		float peso;
		String sfecha;
		LocalDate fecha=LocalDate.now();
		Formato form;
		
		tipo=Teclado.leerInt("Tipo de producto(NoPerecedero =1, Perecedero=2)");
		
		if(tipo==1) {
			
			formato=Teclado.leerInt("Formato(1-lata,2-brick,3-bolsa,4-paquete):");
			form=Formato.LATA;
			
			switch(formato) {
			case 1:
				form=Formato.LATA;
				break;
			case 2:
				form=Formato.BRICK;
				break;
			case 3:
				form=Formato.BOLSA;
				break;
			case 4:
				form=Formato.PAQUETE;
				break;
			}
			
			frio=Teclado.leerString("Frio(s/n)").equalsIgnoreCase("s");
			
			p=ProductoNoPerecedero.builder()
					.formato(form)
					.frio(frio)
					.build();
		}else {
			do {
				peso=Teclado.leerFloat("Peso: ");
			}while(peso<0);
			
			System.out.println("Fecha caducidad:");
			
			do {
				salir=true;
				sfecha=Teclado.leerString("Fecha(YYYY-MM-DD)");
				try {
					fecha=LocalDate.parse(sfecha);
				}catch (DateTimeParseException e) {
					salir=false;
					System.out.println("Fecha en formato invalido");
				}
			}while(!salir);
			
			p=ProductoPerecedero.builder()
					.peso(peso)
					.fechaCad(fecha)
					.build();
		}
	}

	private void pedirOtrosDatos() {
		int n;
		float f;
		String idpro;
		
		p.setNombre(Teclado.leerString("Nombre: "));
		
		do {
			n=Teclado.leerInt("Cuantos se compraran a la vez: ");
		}while(n<0);
		p.setPedidos(n);
		
		do {
			f=Teclado.leerFloat("Precio de compra: ");
		}while(f<0);
		p.setPvd(f);
		
		do {
			f=Teclado.leerFloat("Precio de venta: ");
		}while(f<0);
		p.setPvp(f);
		
		do {
			n=Teclado.leerInt("Cuanto stock hay? ");
		}while(n<0);
		p.setStock(n);
		
		//Leer proveedor
		
		proveedorDAO.findAll().forEach(System.out::println);
		do {
			idpro=Teclado.leerString("Id del proveedor: ");
		}while(proveedorDAO.findById(idpro).isEmpty());
		p.setProveedor(proveedorDAO.findById(idpro).get());
		
	}

	private void pedirClave() {
		do {
			key=Teclado.leerString("Numero de refencia: ");
		}while(productoDAO.findById(key).isPresent());
	}

}
