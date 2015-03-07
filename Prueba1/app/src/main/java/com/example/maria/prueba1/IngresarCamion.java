package com.example.maria.prueba1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Maria on 09/02/2015.
 */
public class IngresarCamion extends Activity {
    protected EditText patente;
    protected EditText modelo;
    protected EditText marca;
    protected EditText tara;
    protected EditText dimesion;
    protected Button ingresar_camion;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingresar_cliente);

        patente = (EditText) findViewById(R.id.patente_camion);
        modelo = (EditText)findViewById(R.id.modelo_camion);
        marca = (EditText)findViewById(R.id.marca_camion);
        tara = (EditText)findViewById(R.id.tara_camion);
        dimesion = (EditText)findViewById(R.id.dimension_camion);
        ingresar_camion = (Button)findViewById(R.id.ingresar_camion);

        ingresar_camion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Toast.makeText(IngresarCamion.this, "Ingresar", Toast.LENGTH_LONG).show();
            }
        });
    }
}

