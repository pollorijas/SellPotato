package com.example.maria.prueba1;



import com.example.maria.prueba1.capanegocio.LoginControler;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class login extends Activity {
    /** Called when the activity is first created. */

    EditText user;
    EditText pass;
    Button blogin;
    TextView registrar;

    LoginControler lc;

    // String URL_connect="http://www.scandroidtest.site90.com/acces.php";
    String IP_Server="http://bdremota.besaba.com";//IP DE NUESTRO PC
    String URL_connect="http://bdremota.besaba.com/loginbd/acces.php";//ruta en donde estan nuestros archivos

    boolean result_back;
    private ProgressDialog pDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //post=new Httppostaux();
        lc = new LoginControler();

        user= (EditText) findViewById(R.id.edusuario);
        pass= (EditText) findViewById(R.id.edpassword);
        blogin= (Button) findViewById(R.id.Blogin);

        //Login button action
        blogin.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){
                //Extreamos datos de los EditText
                String usuario=user.getText().toString();
                String passw=pass.getText().toString();

                //verificamos si estan en blanco
                if( checklogindata( usuario , passw )){

                    //si pasamos esa validacion ejecutamos el asynctask pasando el usuario y clave como parametros

                    new asynclogin().execute(usuario,passw);
                  //  Intent nuevoform = new Intent(login.this, InterfazUsuario.class);
                   // startActivity(nuevoform);
                }else{
                    //si detecto un error en la primera validacion vibrar y mostrar un Toast con un mensaje de error.
                    Log.e("Entra Aqui","NOOOOOOOOOOOOOOOOOOOOOOOOOOO");
                    err_login();
                }

            }
        });

        registrar.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){

                //Abre el navegador al formulario adduser.html
                String url = "http://"+IP_Server+"/loginbd/adduser.html";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        });

    }

    //vibra y muestra un Toast
    public void err_login(){
        Vibrator vibrator =(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vibrator.vibrate(200);
        Toast toast1 = Toast.makeText(getApplicationContext(),"Error:Nombre de usuario o password incorrectos", Toast.LENGTH_SHORT);
        toast1.show();
    }


    public boolean LoginIn(String username, String password)
    {
        if(lc.LoginIn(username,password))
            return true;
        return false;
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
            pDialog = new ProgressDialog(login.this);
            pDialog.setMessage("Autenticando....");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(false);
            pDialog.show();
        }

        protected String doInBackground(String... params) {
            //obtnemos usr y pass
            user=params[0];
            pass=params[1];

            //enviamos y recibimos y analizamos los datos en segundo plano.
            if (LoginIn(user,pass)){
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

            if (result.equals("ok")){

                Intent i=new Intent(login.this, InterfazUsuario.class);
                i.putExtra("user",user);
                startActivity(i);

            }else{
                err_login();
            }

        }

    }

}
