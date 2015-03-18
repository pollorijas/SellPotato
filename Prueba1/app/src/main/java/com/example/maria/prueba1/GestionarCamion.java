package com.example.maria.prueba1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import com.example.maria.prueba1.capanegocio.ClienteControler;
import com.example.maria.prueba1.capanegocio.Traspaso;


public class GestionarCamion extends ActionBarActivity {

    ClienteControler controler;
    ImageButton imgcamionadd, imgcamiondel, imgcamionlist, imgcamionupd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gestionar_camion);


    controler = Traspaso.getControler();
    imgcamionadd = (ImageButton)findViewById(R.id.imgcamionadd);
    imgcamiondel= (ImageButton)findViewById(R.id.imgcamiondel);
    imgcamionlist = (ImageButton)findViewById(R.id.imgcamionlist);
    imgcamionupd = (ImageButton)findViewById(R.id.imgcamionupd);

    imgcamionupd.setOnClickListener(new View.OnClickListener(){
        public void onClick(View view){

            Traspaso.setControler(controler);

            Intent ri = new Intent(getApplicationContext(), ModificarCamion.class);
            startActivity(ri);
        }
    });

    imgcamionadd.setOnClickListener(new View.OnClickListener(){
        public void onClick(View view){
            Intent ri = new Intent(getApplicationContext(), IngresarCamion.class);
            startActivity(ri);
        }
    });

        imgcamiondel.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent ri = new Intent(getApplicationContext(), EliminarCamion.class);
                startActivity(ri);
            }
        });

        imgcamionlist.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent ri = new Intent(getApplicationContext(), ListarCamion.class);
                startActivity(ri);
            }
        });

    }

}
