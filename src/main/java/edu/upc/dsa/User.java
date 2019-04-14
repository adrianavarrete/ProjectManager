package edu.upc.dsa;

import java.util.LinkedList;
import java.util.List;

public class User {

    private String id;
    private String nombre;
    private String apellido;
    private List<Pedido> listaPedidosRealizados;

    public User(){
        this.listaPedidosRealizados = new LinkedList<>();
    }

    public User(String id, String nombre, String apellido){

        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.listaPedidosRealizados = new LinkedList<>();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public List<Pedido> getListaPedidosRealizados() {
        return listaPedidosRealizados;
    }

    public void setListaPedidosRealizados(List<Pedido> listaPedidosRealizados) {
        this.listaPedidosRealizados = listaPedidosRealizados;
    }

    public void setPedidoEnLista(Pedido pedido){

        this.listaPedidosRealizados.add(pedido);

    }
}
