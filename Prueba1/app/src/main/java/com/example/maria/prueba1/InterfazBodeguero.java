package com.example.maria.prueba1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maria.prueba1.capanegocio.ClienteControler;
import com.example.maria.prueba1.capanegocio.Traspaso;

/**
 * Created by Maria on 15/01/2015.
 */
public class InterfazBodeguero extends Activity {

    ClienteControler controler;
    ImageButton imgproductoadd, imgproductoupd, imgprocesarp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interfaz_bodeguero);


        controler = Traspaso.getControler();
        imgproductoadd = (ImageButton)findViewById(R.id.imgproductoadd);
        imgproductoupd = (ImageButton)findViewById(R.id.imgproductoupd);
        imgprocesarp = (ImageButton)findViewById(R.id.imgprocesarp);


        imgproductoupd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                Traspaso.setControler(controler);

                Intent ri = new Intent(getApplicationContext(), ModificarProducto.class);
                startActivity(ri);
            }
        });

        imgproductoadd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent ri = new Intent(getApplicationContext(), IngresarProducto.class);
                startActivity(ri);
            }
        });

        imgprocesarp.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent ri = new Intent(getApplicationContext(), ProcesarPedido.class);
                startActivity(ri);
            }
        });


    }
}
