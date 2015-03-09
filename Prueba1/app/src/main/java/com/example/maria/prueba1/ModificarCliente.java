package com.example.maria.prueba1;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.example.maria.prueba1.capanegocio.ClienteControler;

/**
 * Created by Maria on 15/01/2015.
 */
public class ModificarCliente extends Activity {

    private ClienteControler controler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modificar_cliente);

        controler = ClienteControler.getInstance();
        Log.e("Test", "Cliente: " + controler.getCliente().getnombre());
    }

}
