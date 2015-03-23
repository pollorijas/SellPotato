package com.example.maria.prueba1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.maria.prueba1.capanegocio.ClienteControler;
import com.example.maria.prueba1.capanegocio.Traspaso;

public class InterfazUsuario extends Activity {

    ImageButton imgeditu, imggestionar;
    TextView txtcs;

    ClienteControler controler;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interfaz_usuario);

        controler = Traspaso.getControler();

        imgeditu = (ImageButton)findViewById(R.id.imgwp);
        imggestionar = (ImageButton)findViewById(R.id.imggestionar);
        txtcs = (TextView)findViewById(R.id.txtback);

        imgeditu.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                Traspaso.setControler(controler);

                Intent ri = new Intent(getApplicationContext(), ModificarCliente.class);
                startActivity(ri);
            }
        });

        imggestionar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent ri = new Intent(getApplicationContext(), GestionarCompra.class);
                startActivity(ri);
            }
        });

        txtcs.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent ri = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(ri);
            }
        });

        controler = Traspaso.getControler();

        //Log.e("Cliente: ","Nombre: " + controler.getCliente().getnombre());

    }
}
