package com.example.maria.prueba1;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Vibrator;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maria.prueba1.capanegocio.BodegueroControler;
import com.example.maria.prueba1.capanegocio.ClienteControler;
import com.example.maria.prueba1.capanegocio.LoginControler;
import com.example.maria.prueba1.capanegocio.RepartidorControler;
import com.example.maria.prueba1.capanegocio.Traspaso;
import com.example.maria.prueba1.library.Httppostaux;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {
    EditText user;
    EditText pass;
    Button blogin;
    TextView link;

    Httppostaux post;
    LoginControler lc;
    ClienteControler controler;
    BodegueroControler bodegueroControler;
    RepartidorControler repartidorControler;


    // String URL_connect="http://www.scandroidtest.site90.com/acces.php";
    String IP_Server="http://bdsia2.besaba.com";//IP DE NUESTRO PC
    String URL_connect="http://bdsia2.besaba.com/loginbd/acces.php";//ruta en donde estan nuestros archivos
    public String tipo="";


    boolean result_back;
    private ProgressDialog pDialog;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        post=new Httppostaux();
        lc = new LoginControler();

        user= (EditText) findViewById(R.id.edusuario);
        pass= (EditText) findViewById(R.id.edpassword);
        blogin= (Button) findViewById(R.id.Blogin);
       // registrar = (Button) findViewById(R.id.Bregistrar);
        link = (TextView)findViewById(R.id.link);

        //TestingProduct
        //new ProductoDB().Get(new Producto());

        //Login button action
        blogin.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                //Extreamos datos de los EditText
                String usuario=user.getText().toString();
                String passw=pass.getText().toString();

                //verificamos si estan en blanco
                if( checklogindata( usuario , passw )==true){
                    //si pasamos esa validacion ejecutamos el asynctask pasando el usuario y clave como parametros
                    new asynclogin().execute(usuario,passw);
                }else{
                    //si detecto un error en la primera validacion vibrar y mostrar un Toast con un mensaje de error.
                    err_login();
                }
            }
        });


        link.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                Intent ri = new Intent(getApplicationContext(), IngresarCliente.class);
                startActivity(ri);
                }
        });

    }

    //vibra y muestra un Toast
    public void err_login(){
        Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(200);
        Toast toast1 = Toast.makeText(getApplicationContext(),"Error: Nombre de Usuario o Password incorrectos", Toast.LENGTH_SHORT);
        toast1.show();
    }

    public boolean LoginIn(String username, String password)
    {
        if(lc.LoginIn(username,password)) {
            tipo = lc.getUserType();
            return true;
        }
        return false;
    }

    /*Valida el estado del logueo solamente necesita como parametros el usuario y passw*/
    public boolean loginstatus(String username ,String password ) {
        int logstatus=-1;

    	/*Creamos un ArrayList del tipo nombre valor para agregar los datos recibidos por los parametros anteriores
    	 * y enviarlo mediante POST a nuestro sistema para relizar la validacion*/
        ArrayList<NameValuePair> postparameters2send= new ArrayList<NameValuePair>();

        postparameters2send.add(new BasicNameValuePair("usuario",username));
        postparameters2send.add(new BasicNameValuePair("password",password));

        //realizamos una peticion y como respuesta obtenes un array JSON
        JSONArray jdata=post.getserverdata(postparameters2send, URL_connect);

      		/*como estamos trabajando de manera local el ida y vuelta sera casi inmediato
      		 * para darle un poco realismo decimos que el proceso se pare por unos segundos para poder
      		 * observar el progressdialog
      		 * la podemos eliminar si queremos
      		 */
        SystemClock.sleep(950);

        //si lo que obtuvimos no es null
        if (jdata!=null && jdata.length() > 0){

            JSONObject json_data; //creamos un objeto JSON
            JSONObject json_data_tipo;
            try {
                json_data = jdata.getJSONObject(0); //leemos el primer segmento en nuestro caso el unico
                logstatus=json_data.getInt("logstatus");//accedemos al valor
                Log.e("loginstatus", "logstatus= " + logstatus);//muestro por log que obtuvimos
                json_data_tipo = jdata.getJSONObject(0);
                tipo=json_data_tipo.getString("tipo");
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            //validamos el valor obtenido
            if (logstatus==0){// [{"logstatus":"0"}]
                Log.e("loginstatus ", "invalido");
                return false;
            }
            else{// [{"logstatus":"1"}]
                Log.e("loginstatus ", "valido");
                return true;
            }

        }else{	//json obtenido invalido verificar parte WEB.
            Log.e("JSON  ", "ERROR");
            return false;
        }

    }


    //validamos si no hay ningun campo en blanco
    public boolean checklogindata(String username ,String password ){

        if 	(username.equals("") || password.equals("")){
            Log.e("Login ui", "checklogindata user or pass error");
            return false;

        }else{

            return true;
        }

    }

/*		CLASE ASYNCTASK
 *
 * usaremos esta para poder mostrar el dialogo de progreso mientras enviamos y obtenemos los datos
 * podria hacerse lo mismo sin usar esto pero si el tiempo de respuesta es demasiado lo que podria ocurrir
 * si la conexion es lenta o el servidor tarda en responder la aplicacion sera inestable.
 * ademas observariamos el mensaje de que la app no responde.
 */

    class asynclogin extends AsyncTask< String, String, String > {

        String user,pass;
        protected void onPreExecute() {
            //para el progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Autenticando....");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        protected String doInBackground(String... params) {
            //obtnemos usr y pass
            user=params[0];
            pass=params[1];

            //ArrayList<Producto> p = new ArrayList<>();
            //p = new ProductoDB().GetAll(p);
            //Log.e("DATA",p.toString());

            //enviamos y recibimos y analizamos los datos en segundo plano.
            if (LoginIn(user, pass)){
                return "ok"; //login valido
            }else{
                return "err"; //login invalido
            }

        }

        /*Una vez terminado doInBackground segun lo que halla ocurrido
        pasamos a la sig. activity
        o mostramos error*/
        protected void onPostExecute(String result) {

            pDialog.dismiss();//ocultamos progess dialog.
            Log.e("onPostExecute=",""+result);

            if (result.equals("ok") && tipo.equals("CLIENTE")) {

                //Creacion del Controlador de Cliente
                //Es static y singleton asi se podra usar sin ningun problema en la otra activity
                controler = new ClienteControler();
                controler.setCliente(lc.getCliente());

                Log.e("Cliente","Cliente: " +lc.getUserType());
                Log.e("Vista","Cliente: " + controler.getCliente().getnombre());

                Traspaso.setControler(controler);

                Intent iu = new Intent(MainActivity.this, InterfazUsuario.class);
                iu.putExtra("user", user);
                startActivity(iu);
            }else if(result.equals("ok") && tipo.equals("BODEGUERO")) {

                bodegueroControler = new BodegueroControler();
                bodegueroControler.setBodeguero(lc.getBodeguero());

                Traspaso.setBodegueroControler(bodegueroControler);

                Intent ib = new Intent(MainActivity.this, InterfazBodeguero.class);
                ib.putExtra("user", user);
                startActivity(ib);
            }else if(result.equals("ok") && tipo.equals("REPARTIDOR")){

                repartidorControler = new RepartidorControler();
                repartidorControler.setRepartidor(lc.getRepartidor());

                Traspaso.setRepartidorControler(repartidorControler);

                Intent ir = new Intent(MainActivity.this, InterfazRepartidor.class);
                ir.putExtra("user", user);
                startActivity(ir);
            }else{
                err_login();
            }

        }

    }






}
