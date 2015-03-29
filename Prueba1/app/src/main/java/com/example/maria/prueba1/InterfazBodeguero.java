package com.example.maria.prueba1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.maria.prueba1.capanegocio.BodegueroControler;
import com.example.maria.prueba1.capanegocio.Traspaso;

/**
 * Created by Maria on 15/01/2015.
 */
public class InterfazBodeguero extends Activity {

    BodegueroControler controler;
    ImageButton imgproductoadd, imgproductoupd, imgprocesarp;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interfaz_bodeguero);

        controler = Traspaso.getBodegueroControler();

        imgproductoadd = (ImageButton)findViewById(R.id.imgproductoadd);
        imgproductoupd = (ImageButton)findViewById(R.id.imgproductocancel);
        imgprocesarp = (ImageButton)findViewById(R.id.imgprocesarp);


        imgproductoupd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                Traspaso.setBodegueroControler(controler);

                Intent ri = new Intent(getApplicationContext(), ModificarProducto.class);
                startActivity(ri);
            }
        });

        imgproductoadd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){

                Traspaso.setBodegueroControler(controler);

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
