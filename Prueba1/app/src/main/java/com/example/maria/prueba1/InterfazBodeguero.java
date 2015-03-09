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

        Bundle extras = getIntent().getExtras();
        //Obtenemos datos enviados en el intent.
        if (extras != null) {
            user  = extras.getString("user");//usuario
        }else{
            user="error";
        }
        logoff= (TextView) findViewById(R.id.logoff);
        lista = (ListView) findViewById(R.id.listView1);
        logoff.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //'cerrar  sesion' nos regresa a la ventana anterior.
                finish();
            }
        });
        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, bodeguero);

        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                // Toast.makeText(getApplicationContext(), "posicion " + (i + 1) + personas[i], Toast.LENGTH_SHORT).show();
                switch (i) {
                    case 0:
                        //Intent ii = new Intent(getApplicationContext(), RegistrarProducto.class);
                        //startActivity(ii);
                        break;
                    case 1:
                        Intent im = new Intent(getApplicationContext(), GenerarPedido.class);
                        startActivity(im);
                        break;
                    case 2:
                        Intent ip = new Intent(getApplicationContext(), ProcesarPedido.class);
                        startActivity(ip);
                        break;
                }
            }
        });
    }
}
