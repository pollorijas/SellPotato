package com.example.maria.prueba1;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Maria on 14/01/2015.
 */
public class InterfazUsuario extends Activity {
    String user;
    ListView lista;
    TextView logoff;
    String[] usuario = {
            "Modificar Datos Personal",
            "Generar Pedido",
            "Modificar Pedido",
            "Ver estado Pedido",
            "Cancelar Pedido",
            "Realizar Pago"
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interfaz_usuario);

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

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1, usuario);

        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long l) {
                // Toast.makeText(getApplicationContext(), "posicion " + (i + 1) + personas[i], Toast.LENGTH_SHORT).show();
                switch (i) {
                    case 0:
                        Intent im = new Intent(getApplicationContext(), ModificarCliente.class);
                        startActivity(im);
                        break;
                    case 1:
                        Intent ig = new Intent(getApplicationContext(), GenerarPedido.class);
                        startActivity(ig);
                        break;
                    case 2:
                        Intent ip = new Intent(getApplicationContext(), ModificarPedido.class);
                        startActivity(ip);
                        break;
                    case 3:
                        Intent iv = new Intent(getApplicationContext(), VerPedido.class);
                        startActivity(iv);
                        break;
                    case 4:
                        Intent ic = new Intent(getApplicationContext(), CancelarPedido.class);
                        startActivity(ic);
                        break;
                    case 5: Intent ir = new Intent(getApplicationContext(), IngresarPago.class);
                        startActivity(ir);
                        break;
                }
            }
        });
    }
}
