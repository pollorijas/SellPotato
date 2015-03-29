package com.example.maria.prueba1;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.maria.prueba1.capanegocio.Camion;
import com.example.maria.prueba1.capanegocio.RepartidorControler;
import com.example.maria.prueba1.capanegocio.Traspaso;


public class IngresarCamion extends Activity {
    EditText patente_camion, marca_camion, modelo_camion, tara_camion, dimension_camion;

    Button ingresar_camion;
    public RepartidorControler controler;
    public ProgressDialog pDialog;



    protected  void  onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ingresar_camion);
        controler = Traspaso.getRepartidorControler();

        patente_camion = (EditText) findViewById(R.id.txtpatente);
        marca_camion = (EditText) findViewById(R.id.marca);
        modelo_camion = (EditText) findViewById(R.id.modelo);
        tara_camion = (EditText) findViewById(R.id.tara);
        dimension_camion = (EditText) findViewById(R.id.dimensiones);

        ingresar_camion = (Button) findViewById(R.id.modificar_camion);

        ingresar_camion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                controler.setCamion(new Camion());

                controler.getCamion().setcarga(Integer.parseInt(tara_camion.getText().toString()));
                controler.getCamion().setDimencion(Integer.parseInt(dimension_camion.getText().toString()));
                controler.getCamion().setmodelo(modelo_camion.getText().toString());
                controler.getCamion().setpatente(patente_camion.getText().toString());
                controler.getCamion().setmarca(modelo_camion.getText().toString());
                controler.getCamion().setM_Repartidor(controler.getRepartidor());

                new AsyncIngresarCamion().execute(true);
            }
        });
    }

    class AsyncIngresarCamion extends AsyncTask<Boolean,String,Boolean>
    {

        @Override
        protected void onPreExecute() {
            pDialog = new ProgressDialog(IngresarCamion.this);
            pDialog.setMessage("Registrando...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }


        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);

            pDialog.dismiss();

            boolean result = aBoolean;

            //Log.e("Datos:", "Datos: " + controler.getCliente().getPassword());

            if(result){
                msgShow("El Camion ha sido Registrado correctamente:");
                Intent iu = new Intent(IngresarCamion.this, InterfazRepartidor.class);
                finish();
            }
            else msgShow("Error: Los Datos no han sido Registrados.");

        }

        @Override
        protected Boolean doInBackground(Boolean... params) {
            if(controler.RegistrarCamion()) return true;
            else return false;
        }
    }

    public void msgShow(String msg)
    {
        Toast t = Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_SHORT);
        t.show();
    }

}