package com.example.maria.prueba1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import java.util.Stack;


public class GestionarCompra extends ActionBarActivity {

    ImageButton imgpago, imgproductoadd, imgproductoupd, imgproductocancel, imgstate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gestionar_compra);

        imgpago = (ImageButton)findViewById(R.id.imgpago);
        imgproductoadd = (ImageButton)findViewById(R.id.imgproductoadd);
        imgproductocancel = (ImageButton)findViewById(R.id.imgproductocancel);
        imgstate = (ImageButton)findViewById(R.id.imgstate);

        imgproductoadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent add = new Intent(getApplicationContext(),GenerarPedido.class);
                startActivity(add);
            }
        });

        imgproductoupd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent upd = new Intent(getApplicationContext(),ModificarPedido.class);
                startActivity(upd);
            }
        });

        imgproductocancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent can = new Intent(getApplicationContext(), CancelarPedido.class);
                startActivity(can);
            }
        });

        imgstate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent st = new Intent(getApplicationContext(), EstadoPedido.class);
                startActivity(st);
            }
        });
        imgpago.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent op = new Intent(getApplicationContext(),OpcionPago.class);
                startActivity(op);

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_gestionar_compra, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
