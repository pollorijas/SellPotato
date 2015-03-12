package com.example.maria.prueba1.capadatos;

import com.example.maria.prueba1.capanegocio.Paquete;
import com.example.maria.prueba1.library.HttpHelpingClass;

/**
 * Created by Freddy on 07-03-2015.
 */
public class PaqueteDB implements BDInterface {
    @Override
    public <T> String Insert(T t) {
        String aux = "ERROR";
        if(t instanceof Paquete)
        {
            //Arreglear SQL de PAQUETE
            HttpHelpingClass http = new HttpHelpingClass();
            try {
                http.httpGetData("http://10.0.2.2/SSPP/paquete_registro.php?id=" + ((Paquete) t).getidPaquete());
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
        return null;
    }

    @Override
    public <T> String Delete(T t) {
        String aux = "ERROR";
        if(t instanceof Paquete)
        {
            //Arreglear SQL de PAQUETE
            HttpHelpingClass http = new HttpHelpingClass();
            try {
                http.httpGetData("http://10.0.2.2/SSPP/paquete_eliminar.php?id=" + ((Paquete) t).getidPaquete());
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
