package edu.upc.dsa;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Pedido {

    private  String id;
    private  int cantPan;
    private  int cantLeche;
    private  int cantAgua;
    private  String idUser;
    //private static HashMap<Integer,Producto> productos;



    public Pedido(String id,String idUser, int cantPan, int cantLeche, int cantAgua){
        this.id = id;
        this.cantPan = cantPan;
        this.cantLeche = cantLeche;
        this.cantAgua = cantAgua;
        this.idUser = idUser;

    }

   public Pedido(){

        //this.productos = new HashMap<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCantPan() {
        return cantPan;
    }

    public void setCantPan(int cantPan) {
        this.cantPan = cantPan;
    }

    public int getCantLeche() {
        return cantLeche;
    }

    public void setCantLeche(int cantLeche) {
        this.cantLeche = cantLeche;
    }

    public int getCantAgua() {
        return cantAgua;
    }

    public void setCantAgua(int cantAgua) {
        this.cantAgua = cantAgua;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
}
