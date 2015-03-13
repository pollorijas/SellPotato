package com.example.maria.prueba1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.maria.prueba1.capanegocio.ClienteControler;
import com.example.maria.prueba1.capanegocio.Traspaso;

public class InterfazUsuario extends Activity {

    ImageButton imgeditu;

    ClienteControler controler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interfaz_usuario);

        controler = Traspaso.getControler();

        imgeditu = (ImageButton)findViewById(R.id.imgeditu);

        imgeditu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                Traspaso.setControler(controler);

                Intent ri = new Intent(getApplicationContext(), ModificarCliente.class);
                startActivity(ri);
            }
        });


    }
}
