package edu.upc.dsa;

import edu.upc.dsa.Throws.PedidoNotFoundException;

import java.util.List;

public interface ProjectManager {

    public static final int S = 10;




    public List<Producto> dameProductosOrdenadoPorPrecioDes();
    public Pedido hacerPedido(Pedido pedido);
    public void servirPedido(String Pedido) throws PedidoNotFoundException;
    public List<Pedido> damePedidosRealizadoPorUser(String idUser);
    public List<Producto> dameProductosOrdenadoPorVentasAsc();
    public void addUser(User user);
    public List<Pedido> damePedidos();
    public Producto dameProducto(int pos);





    public void clear();

}
