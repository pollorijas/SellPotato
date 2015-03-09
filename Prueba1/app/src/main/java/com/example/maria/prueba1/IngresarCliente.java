package com.example.maria.prueba1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Maria on 15/01/2015.
 */
public class IngresarCliente extends Activity {

    protected EditText rut;
    protected EditText nombre;
    protected EditText apellido;
    protected EditText telefono;
    protected EditText direccion;
    protected EditText descripcion;
    protected EditText password;
    protected Button ingresar_cliente;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingresar_cliente);

        rut = (EditText) findViewById(R.id.rutc);
        nombre = (EditText)findViewById(R.id.nombrec);
        apellido = (EditText)findViewById(R.id.apellidoc);
        telefono = (EditText)findViewById(R.id.telefonoc);
        direccion = (EditText)findViewById(R.id.direccionc);
        password = (EditText) findViewById(R.id.clavec);
        ingresar_cliente = (Button)findViewById(R.id.ingresar_cliente);

        ingresar_cliente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(IngresarCliente.this, "Ingresar", Toast.LENGTH_LONG).show();
            }
        });
    }
}

