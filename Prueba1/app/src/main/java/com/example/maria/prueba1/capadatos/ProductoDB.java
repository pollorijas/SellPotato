package com.example.maria.prueba1.capadatos;

import com.example.maria.prueba1.capanegocio.Producto;
import com.example.maria.prueba1.library.HttpHelpingClass;

/**
 * Created by Freddy on 07-03-2015.
 */
public class ProductoDB implements BDInterface {
    @Override
    public <T> String Insert(T t) {
        String aux = "ERROR";
        if(t instanceof Producto)
        {
            //Arreglear SQL de PRODUCTO
            HttpHelpingClass http = new HttpHelpingClass();
            try {
                http.httpGetData("http://vendepapas.esy.es/SQL/producto_registro.php?id_producto=" + ((Producto) t).getidProducto()
                + "&nombre_producto=" + ((Producto) t).getnombreProducto()
                + "&precio_unitario=" + ((Producto) t).getprecio()
                + "&descripcion_producto=" + ((Producto) t).getdescripcion()
                + "&stock_producto=" + ((Producto) t).getstock());
                aux = "SUCCESSFUL";
            }catch (Exception e)
            {
                e.printStackTrace();
                return "ERROR";
            }

        }
        return aux;
    }

    @Override
    public <T> String Update(T t) {
        String aux = "ERROR";
        if(t instanceof Producto)
        {
            //Arreglear SQL de PRODUCTO
            HttpHelpingClass http = new HttpHelpingClass();
            try {
                http.httpGetData("http://vendepapas.esy.es/SQL/producto_actualizar.php?id_producto=" + ((Producto) t).getidProducto()
                        + "&nombre_producto=" + ((Producto) t).getnombreProducto()
                        + "&precio_unitario=" + ((Producto) t).getprecio()
                        + "&descripcion_producto=" + ((Producto) t).getdescripcion()
                        + "&stock_producto=" + ((Producto) t).getstock());
                aux = "SUCCESSFUL";
            }catch (Exception e)
            {
                e.printStackTrace();
                return "ERROR";
            }

        }
        return aux;
    }

    @Override
    public <T> String Delete(T t) {
        String aux = "ERROR";
        if(t instanceof Producto)
        {
            //Arreglear SQL de PRODUCTO
            HttpHelpingClass http = new HttpHelpingClass();
            try {
                http.httpGetData("http://vendepapas.esy.es/SQL/producto_eliminar.php?id_producto=" + ((Producto) t).getidProducto());
                aux = "SUCCESSFUL";
            }catch (Exception e)
            {
                e.printStackTrace();
                return "ERROR";
            }

        }
        return aux;
    }

    @Override
    public <T> void Get(T t) {

    }
}
