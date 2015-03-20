package com.example.maria.prueba1.capanegocio;

import java.util.ArrayList;

/**
 * Created by Freddy on 20-03-2015.
 */
public class BodegueroControler {

    private Bodeguero bodeguero;
    private Producto producto;
    private ArrayList<Producto> listaProductos;

    public BodegueroControler() {
        listaProductos = new ArrayList<Producto>();
    }

    public Bodeguero getBodeguero() {
        return bodeguero;
    }

    public void setBodeguero(Bodeguero bodeguero) {
        this.bodeguero = bodeguero;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public boolean IngresarProducto()
    {
        String get = producto.getData().Insert(producto);
        if(get.equals("SUCCESSFUL")) return true;
        else return false;
    }
}
