package com.example.maria.prueba1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Maria on 15/01/2015.
 */
public class InterfazBodeguero extends Activity {
    String user;
    TextView logoff;
    ListView lista;
    String[] bodeguero = {
            "Ingresar nuevo producto",
            "Actualizar Stock Producto",
            "Procesar pedido"
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interfaz_bodeguero);


    }
}
