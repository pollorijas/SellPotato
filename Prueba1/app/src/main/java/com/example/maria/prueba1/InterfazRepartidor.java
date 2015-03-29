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

    ImageButton imgcamion;

    RepartidorControler controler;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.interfaz_repartidor);

        controler = Traspaso.getRepartidorControler();

        imgcamion = (ImageButton)findViewById(R.id.imgwp);

        imgcamion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Traspaso.setRepartidorControler(controler);
                Intent ri = new Intent(getApplicationContext(), GestionarCamion.class);
                startActivity(ri);
            }
        });

    }

}
