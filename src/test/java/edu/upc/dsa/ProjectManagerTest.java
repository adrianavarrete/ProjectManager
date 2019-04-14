package edu.upc.dsa;


import edu.upc.dsa.Throws.PedidoNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class ProjectManagerTest {

    private ProjectManager pm;

    @Before
    public void setUp() {

        pm = ProjectManagerImpl.getInstance();

        pm.addUser(new User("user1","Adri","Navarrete"));
        this.pm.hacerPedido(new Pedido("ped1","user1",5,6,2));



    }

    @After
    public void limpiar(){

        this.pm.clear();
    }

    @Test
    public void hacerPedidoTest() {

        this.pm.hacerPedido(new Pedido("ped2","user1",5,1,2));
        this.pm.hacerPedido(new Pedido("ped3","user1",5,1,2));
        assertEquals(3,this.pm.damePedidos().size());


    }

    @Test
    public void servirPedidoTest() throws PedidoNotFoundException {
        this.pm.servirPedido("ped1");
        assertEquals(5,this.pm.dameProducto(0).getNumVentas());
        assertEquals(6,this.pm.dameProducto(1).getNumVentas());
        assertEquals(2,this.pm.dameProducto(2).getNumVentas());
        assertEquals(0,this.pm.damePedidos().size());



    }

    @Test
    public void damePedidosUsuario(){

        List<Pedido> lista = this.pm.damePedidosRealizadoPorUser("user1");
        assertEquals(1, lista.size());


    }




}
