package com.example.maria.prueba1.capadatos;

import com.example.maria.prueba1.capanegocio.Pago;
import com.example.maria.prueba1.library.HttpHelpingClass;

/**
 * Created by Freddy on 07-03-2015.
 */
public class PagoDB implements BDInterface {
    @Override
    public <T> String Insert(T t) {
        String aux = "ERROR";
        if(t instanceof Pago)
        {
            HttpHelpingClass http = new HttpHelpingClass();
            try {
                http.httpGetData("http://10.0.2.2/SSPP/pago_registrar.php?id_pago=" + ((Pago) t).getid_Pago()
                        + "&id_pedido=" + ((Pago) t).getM_Pedido().getidPedido()
                        + "&forma_pago=" + "Arregla Forma de Pago"
                        + "&fecha_pago" + ((Pago) t).getfechadePago()
                        + "monto_pago" + ((Pago) t).gettotal_pagar());
                aux = "SUCCESSFUL";
            }catch(Exception e){
                e.printStackTrace();
                return "ERROR";
            }
        }
        return aux;
    }

    @Override
    public <T> String Update(T t) {
        String aux = "ERROR";
        if(t instanceof Pago)
        {
            HttpHelpingClass http = new HttpHelpingClass();
            try {
                http.httpGetData("http://10.0.2.2/SSPP/pago_actualizar.php?id_pago=" + ((Pago) t).getid_Pago()
                        + "&id_pedido=" + ((Pago) t).getM_Pedido().getidPedido()
                        + "&forma_pago=" + "Arregla Forma de Pago"
                        + "&fecha_pago" + ((Pago) t).getfechadePago()
                        + "monto_pago" + ((Pago) t).gettotal_pagar());
                aux = "SUCCESSFUL";
            }catch(Exception e){
                e.printStackTrace();
                return "ERROR";
            }
        }
        return aux;
    }

    @Override
    public <T> String Delete(T t) {
        return null;
    }

    @Override
    public <T> void Get(T t) {

    }
}
