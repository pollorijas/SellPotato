package com.example.maria.prueba1;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maria.prueba1.capanegocio.ClienteControler;
import com.example.maria.prueba1.capanegocio.Traspaso;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;


public class ModificarCliente extends ActionBarActivity {

    EditText ettelefono, etdireccion, etdescripcion, etpassword;
    TextView txtrut, txtnombre, txtapellido;
    Button btn_modificar;

    private ClienteControler controler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modificar_cliente);

        controler = Traspaso.getControler();
        Log.e("direccion",controler.getCliente().getdireccion());

        txtrut = (TextView)findViewById(R.id.txtrut);
        txtnombre = (TextView)findViewById(R.id.txtnombre);
        txtapellido= (TextView)findViewById(R.id.txtapellido);
        ettelefono = (EditText)findViewById(R.id.ettelefono);
        etdireccion = (EditText)findViewById(R.id.etdireccion);
        etdescripcion = (EditText)findViewById(R.id.etdescripcion);
        etpassword = (EditText)findViewById(R.id.etpassword);
        btn_modificar = (Button)findViewById(R.id.btn_modificar);

        //Mostrando Datos

        txtrut.setText(controler.getCliente().getrut());
        txtnombre.setText(controler.getCliente().getnombre());
        txtapellido.setText(controler.getCliente().getapellido());
        ettelefono.setText(Double.toString(controler.getCliente().getfono()));
        etdireccion.setText(controler.getCliente().getdireccion());
        etdescripcion.setText(controler.getCliente().getdescripcionHogar());
        etpassword.setText(controler.getCliente().getPassword());

        btn_modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });

    }


}
