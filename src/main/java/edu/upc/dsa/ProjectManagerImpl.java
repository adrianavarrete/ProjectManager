package edu.upc.dsa;

import edu.upc.dsa.Throws.PedidoNotFoundException;
import org.apache.log4j.Logger;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ProjectManagerImpl implements ProjectManager {

    private final static Logger log = Logger.getLogger(ProjectManager.class.getName());
    private static ProjectManagerImpl instance;
    private static HashMap<String, User> users;
    private static Producto[] productos;
    private static HashMap<String,Pedido> pedidos;





    private ProjectManagerImpl() {

        this.users = new HashMap<>();
        this.productos = new Producto[3];

        this.productos[0] = new Producto("1","pan",2,0);
        this.productos[1] = new Producto("2","leche",5,0);
        this.productos[2] = new Producto("3","agua",1,0);

        this.pedidos = new HashMap<>();


    }


    public static ProjectManager getInstance() {
        if (instance == null) instance = new ProjectManagerImpl();
        return instance;
    }


    @Override
    public List<Producto> dameProductosOrdenadoPorPrecioDes() {
        return null;
    }

    @Override
    public Pedido hacerPedido(Pedido pedido) {

        //String id = RandomUtils.getId();
        //Pedido pedido = new Pedido(id,idUser,cantPan,cantLeche,cantAgua);
        this.pedidos.put(pedido.getId(),pedido);
        log.info("++++++++++++++++++++++++++AÑADIDO+++++++++++++++++++++++++");
        this.users.get(pedido.getIdUser()).setPedidoEnLista(pedido);
        log.info("el Usuario " + pedido.getIdUser() +" ha realizado un pedido y esta listo para servirse");

        return pedido;


    }

    @Override
    public void servirPedido(String idPedido) throws PedidoNotFoundException {

        if(this.pedidos.get(idPedido) != null) {
            this.productos[0].setNumVentas(this.productos[0].getNumVentas() + this.pedidos.get(idPedido).getCantPan());
            this.productos[1].setNumVentas(this.productos[1].getNumVentas() + this.pedidos.get(idPedido).getCantLeche());
            this.productos[2].setNumVentas(this.productos[2].getNumVentas() + this.pedidos.get(idPedido).getCantAgua());

            this.pedidos.remove(idPedido);

            log.info("Pedido con id " + idPedido + "del usuario " + this.pedidos.get(idPedido).getIdUser());
        }
        else {
            log.fatal("No existe el pedido con ese id");
            throw new PedidoNotFoundException();


        }


    }

    @Override
    public List<Pedido> damePedidosRealizadoPorUser(String idUser) {

        log.info("Viendo los pedidos del user con id " +idUser);
        return this.users.get(idUser).getListaPedidosRealizados();
    }

    @Override
    public List<Producto> dameProductosOrdenadoPorVentasAsc() {
        return null;
    }



    @Override
    public void clear() {

        this.users.clear();
        this.productos = new Producto[3];
        this.pedidos.clear();

    }

    public void addUser(User user){
        this.users.put(user.getId(),user);
        log.info("Usuario " + user.getNombre() +" (" + user.getId() +") añadido");
    }

    @Override
    public List<Pedido> damePedidos() {
        return new LinkedList<>(this.pedidos.values());
    }

    @Override
    public Producto dameProducto(int pos) {
        return this.productos[pos];
    }


    public int getPosListaById(List<Pedido> lista, String id) throws PedidoNotFoundException {

        int pos = -1;

        for(Pedido pedido: lista)
        {
            int i = 0;

            if(pedido.getId() == id){
                pos = i;
                break;

            }
            else{

                i++;

            }
        }

        if(pos != -1){
            return pos;
        }
        else{

            log.error("Pedido " + id + " no encontrado");
            throw new PedidoNotFoundException();


        }

    }


}
