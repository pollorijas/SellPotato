package com.example.maria.prueba1.capadatos;

import com.example.maria.prueba1.capanegocio.DetallePedido;
import com.example.maria.prueba1.library.HttpHelpingClass;

/**
 * Created by Freddy on 07-03-2015.
 */
public class DetallePedidoDB implements BDInterface {
    @Override
    public <T> String Insert(T t) {
        String aux = "ERROR";
        if(t instanceof DetallePedido)
        {
            HttpHelpingClass http = new HttpHelpingClass();
            try {
                http.httpGetData("http://vendepapas.esy.es/SQL/detalle_pedido_registro.php?id_detalle=" + ((DetallePedido) t).getId_detalle()
                + "&id_pedido=" + ((DetallePedido) t).getM_Pedido().getidPedido()
                + "&id_producto=" + ((DetallePedido) t).getM_Producto().getidProducto()
                + "&cantidad_vendida=" + ((DetallePedido) t).getcantidadVedida()
                + "&precio=" + ((DetallePedido) t).getrecioVenta());
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
        if(t instanceof DetallePedido)
        {
            HttpHelpingClass http = new HttpHelpingClass();
            try {
                http.httpGetData("http://vendepapas.esy.es/SQL/detalle_pedido_actualizar.php?id_detalle=" + ((DetallePedido) t).getId_detalle()
                        + "&id_pedido=" + ((DetallePedido) t).getM_Pedido().getidPedido()
                        + "&id_producto=" + ((DetallePedido) t).getM_Producto().getidProducto()
                        + "&cantidad_vendida=" + ((DetallePedido) t).getcantidadVedida()
                        + "&precio=" + ((DetallePedido) t).getrecioVenta());
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
        if(t instanceof DetallePedido)
        {
            HttpHelpingClass http = new HttpHelpingClass();
            try {
                http.httpGetData("http://vendepapas.esy.es/SQL/detalle_pedido_eliminar.php?id_detalle=" + ((DetallePedido) t).getId_detalle());
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
