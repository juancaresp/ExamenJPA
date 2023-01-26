package org.dam2.examenjpa.acciones;

import java.time.LocalDate;

import org.dam2.examenjpa.modelo.Cliente;
import org.dam2.examenjpa.modelo.Direccion;
import org.dam2.examenjpa.modelo.Formato;
import org.dam2.examenjpa.modelo.Producto;
import org.dam2.examenjpa.modelo.ProductoNoPerecedero;
import org.dam2.examenjpa.modelo.ProductoPerecedero;
import org.dam2.examenjpa.modelo.Proveedor;
import org.dam2.examenjpa.modelo.Venta;
import org.dam2.utilidadesmenu.MenuAction;

public class Opcion1 extends AccionesAlmacen implements MenuAction{

	@Override
	public void doMenuAction() {
		// TODO Auto-generated method stub
		Proveedor pro1,pro2;
		
		pro1=Proveedor.builder()
				.nombre("Cutre Ingles")
				.nif("01")
				.email("cutre@gg.com")
				.direccion(Direccion.builder()
								.calle("Andalucia")
								.portal("7")
								.localidad("Madrid")
								.codPostal("28003")
								.build())
				.build();
		
		pro2=Proveedor.builder()
				.nombre("Agricultores")
				.nif("02")
				.email("agri@nn.es")
				.direccion(Direccion.builder()
								.calle("Real")
								.portal("23")
								.localidad("Soto del Real")
								.codPostal("28791")
								.build())
				.build();
		
		proveedorDAO.save(pro1);
		proveedorDAO.save(pro2);
		
		Producto p1,p2,p3,p4;
		
		p1=ProductoPerecedero.builder()
				.nrefer("00001")
				.nombre("tomates")
				.stock(100)
				.pvp(2.1f)
				.pvd(1.9f)
				.pedidos(40)
				.fechaCad(LocalDate.of(2023, 2, 2))
				.peso(0.25f)
				.proveedor(pro2)
				.build();
	
		p2=ProductoNoPerecedero.builder()
				.nrefer("00002")
				.nombre("Sardinas")
				.stock(20)
				.pvp(0.35f)
				.pvd(0.2f)
				.pedidos(10)
				.formato(Formato.LATA)
				.frio(false)
				.proveedor(pro1)
				.build();
		
		p3=ProductoPerecedero.builder()
				.nrefer("00003")
				.nombre("Naranjas")
				.stock(50)
				.pvp(0.2f)
				.pvd(0.1f)
				.pedidos(30)
				.fechaCad(LocalDate.of(2023, 1, 18))
				.peso(0.15f)
				.proveedor(pro1)
				.build();
		
		p4=ProductoNoPerecedero.builder()
				.nrefer("00004")
				.nombre("Avena")
				.stock(220)
				.pvp(1.2f)
				.pvd(0.8f)
				.pedidos(25)
				.formato(Formato.BOLSA)
				.frio(true)
				.proveedor(pro2)
				.build();
		
		productoDAO.save(p1);
		productoDAO.save(p2);
		productoDAO.save(p3);
		productoDAO.save(p4);
		
		
		
		Cliente cli1,cli2;
		
		cli1 = Cliente.builder()
				.nombre("Miguel")
				.nif("00001A")
				.direccion(Direccion.builder()
						.id(1)
						.calle("Chile")
						.portal("16")
						.localidad("Colmenar Viejo")
						.codPostal("28023")
						.build())
				.build();
		
		cli2 = Cliente.builder()
				.nombre("Dacorsa")
				.nif("00030B")
				.direccion(Direccion.builder()
						.id(2)
						.calle("Antracita")
						.portal("23")
						.localidad("Madrid")
						.codPostal("28003")
						.build())
				.build();
		
		clienteDAO.save(cli1);
		clienteDAO.save(cli2);
		
		Venta v1,v2,v3,v4;
		
		v1=Venta.builder()
				.producto(p1)
				.cliente(cli1)
				.cantidad(5)
				.fechaCompra(LocalDate.of(2022, 12, 1))
				.build();
		
		v2=Venta.builder()
				.producto(p1)
				.cliente(cli2)
				.cantidad(7)
				.fechaCompra(LocalDate.of(2023, 1, 2))
				.build();
		
		v3=Venta.builder()
				.producto(p2)
				.cliente(cli1)
				.cantidad(3)
				.fechaCompra(LocalDate.of(2022, 12, 10))
				.build();
		
		v4=Venta.builder()
				.producto(p3)
				.cliente(cli1)
				.cantidad(4)
				.fechaCompra(LocalDate.of(2023, 11, 1))
				.build();
		

		ventaDAO.save(v1);
		ventaDAO.save(v2);
		ventaDAO.save(v3);
		ventaDAO.save(v4);
	}

}
