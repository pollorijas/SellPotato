package com.example.maria.prueba1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Maria on 15/01/2015.
 */
public class InterfazRepartidor extends Activity {
    String user;
    TextView logoff;
    ListView lista;
    String[] repartidor = {
            "Ingresar nuevo Camion",
            "Generar Pago",
            "Generar Recorrido",
            "Distribuir los pedido"
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
        lista = (ListView) findViewById(R.id.listView1);
        logoff= (TextView) findViewById(R.id.logoff);
        logoff.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                //'cerrar  sesion' nos regresa a la ventana anterior.
                finish();
            }
        });

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, repartidor);

        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                // Toast.makeText(getApplicationContext(), "posicion " + (i + 1) + personas[i], Toast.LENGTH_SHORT).show();
                switch (i) {
                    case 0:
                        Intent ii = new Intent(getApplicationContext(), IngresarCamion.class);
                        startActivity(ii);
                        break;
                    case 1:
                        Intent im = new Intent(getApplicationContext(), GenerarPago.class);
                        startActivity(im);
                        break;
                    case 2:
                        Intent ip = new Intent(getApplicationContext(), GenerarRecorrido.class);
                        startActivity(ip);
                        break;
                    case 3:
                        Intent id = new Intent(getApplicationContext(), DistribucionPedido.class);
                        startActivity(id);
                        break;
                }
            }
        });
    }
}
