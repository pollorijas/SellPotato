package sellpotato.sellpotato;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import sellpotato.sellpotato.helpclass.HelpFuntion;


public class LoginActivity extends Activity {

    EditText ingreso_rut,ingreso_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ingreso_rut = (EditText)findViewById(R.id.ingreso_rut);
        ingreso_pass = (EditText)findViewById(R.id.password);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Funcion en OnClick del boton Sign In
    public void login_control(View v)
    {
        String rut = ingreso_rut.getText().toString();
        String pass = ingreso_pass.getText().toString();

        if(rut.length() == 10)
        {
            if(HelpFuntion.validarRut(rut))
            {
                //verificar rut y pass en la base de datos aun no terminado se hablara mañana de esto
                //tambien falta agregar los datos del cliente
                Intent act = new Intent(this,Login_In.class);

                startActivity(act);
                finish();
            }
            else{
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle("Dotos Mal Ingresados").setMessage("Su Rut o Contraseña han sido mal ingresadas").setNeutralButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                dialog.show();
            }
        }
        else
        {
            //En caso de que el rut no tenga el tamaño adecuado
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("Dotos Mal Ingresados").setMessage("Su Rut o Contraseña han sido mal ingresadas").setNeutralButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            dialog.show();
        }
    }


    //Click en salir de la aplicacion
    public void salir_aplicacion(View v)
    {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Salir");
        dialog.setMessage("¿Esta seguro que desea salir de la Aplicación?");
        dialog.setPositiveButton(R.string.si, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        }).setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });
        dialog.show();
    }

    public void registrar(View v)
    {
        Intent act = new Intent(this, Registro.class);
        startActivity(act);
    }
}
