package com.example.maria.prueba1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegistrarProducto extends ActionBarActivity {

    protected EditText nombre;
    protected EditText precio;
    protected EditText cantidad;
    protected EditText descripcion;
    protected Button ingresar_producto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_producto);
        //initialize
        nombre = (EditText)findViewById(R.id.nombre_producto);
        precio = (EditText)findViewById(R.id.precio_producto);
        cantidad = (EditText)findViewById(R.id.cant_producto);
        descripcion = (EditText)findViewById(R.id.descripcion);
        ingresar_producto = (Button)findViewById(R.id.ingresar);

        ingresar_producto.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(RegistrarProducto.this,"Ingresar",Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_registrar_producto, menu);
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
