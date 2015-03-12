package com.example.maria.prueba1;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

    EditText etrut, etnombre, etapellido, ettelefono, etdireccion, etdescripcion, etpassword;
    TextView jaja;
    Button btn_modificar, btn_consultar;
    JSONArray ja;
    String data;

    Handler h1 = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            Toast.makeText(getApplicationContext(), "Registro Exitoso", 3000).show();
        }
    };

    Handler h = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            try {
                //jaja.setText(ja.getString(0));
                etrut.setText(ja.getString(0));
                etnombre.setText(ja.getString(1));
                etapellido.setText(ja.getString(2));
                ettelefono.setText(ja.getString(3));
                etdireccion.setText(ja.getString(4));
                etdescripcion.setText(ja.getString(5));
                etpassword.setText(ja.getString(6));
            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modificar_cliente);


        etrut = (EditText)findViewById(R.id.et_rut);
        etnombre = (EditText)findViewById(R.id.et_nombre);
        etapellido = (EditText)findViewById(R.id.et_apellido);
        ettelefono = (EditText)findViewById(R.id.et_telefono);
        etdireccion = (EditText)findViewById(R.id.et_direccion);
        etdescripcion = (EditText)findViewById(R.id.et_descripcion);
        etpassword = (EditText)findViewById(R.id.et_password);
        btn_consultar = (Button)findViewById(R.id.btn_consultar);
        btn_modificar = (Button)findViewById(R.id.btn_modificar);
        //jaja = (TextView)findViewById(R.id.jaja);

        btn_modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        httpGetData("http://10.0.2.2/SSPP/cliente_actualizar.php?rut="+etrut.getText()+"&telefono="+ettelefono.getText()
                                +"&direccion="+etdireccion.getText()+"&descripcion="+etdescripcion.getText()+"&password="+etpassword.getText());
                        h1.sendEmptyMessage(1);
                    }
                }).start();
            }
        });
        btn_consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        ja = null;
                        data = httpGetData("http://10.0.2.2/SSPP/cliente_buscar.php?rut="+etrut.getText());
                        if (data.length()>0){
                            try {
                                ja= new  JSONArray(data);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            h.sendEmptyMessage(1);



                        }

                    }
                }).start();
            }
        });
    }

    public String httpGetData(String mURL){
        String response="";
        mURL=mURL.replace(" ", "%20");
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet httpget = new HttpGet(mURL);

        ResponseHandler<String> responsehandler = new BasicResponseHandler();
        try {
            response = httpclient.execute(httpget, responsehandler);

        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return response;
    }

}
