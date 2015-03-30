package com.example.maria.prueba1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.maria.prueba1.capanegocio.RepartidorControler;
import com.example.maria.prueba1.capanegocio.Traspaso;

/**
 * Created by Maria on 15/01/2015.
 */
public class InterfazRepartidor extends Activity {

    ImageButton imgcamion, imgordenar, imgpce;

    RepartidorControler controler;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interfaz_repartidor);

        controler = Traspaso.getRepartidorControler();

        imgcamion = (ImageButton)findViewById(R.id.imgwp);
        imgordenar = (ImageButton)findViewById(R.id.imgordenar);
        imgpce = (ImageButton)findViewById(R.id.imgpce);

        imgcamion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Traspaso.setRepartidorControler(controler);
                Intent ri = new Intent(getApplicationContext(), GestionarCamion.class);
                startActivity(ri);
            }
        });

        imgordenar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent or = new Intent(getApplicationContext(), DistribucionPedido.class);
                startActivity(or);
            }
        });

        imgpce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pce = new Intent(getApplicationContext(), MostrarRuta.class);
                startActivity(pce);
            }
        });

    }

}
