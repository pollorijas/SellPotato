package sellpotato.sellpotato;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


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

    public void login_control(View v)
    {
        String rut = ingreso_rut.getText().toString();
        String pass = ingreso_pass.getText().toString();

        if(rut.length() > 10)
        {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("Dotos Mal Ingresados").setMessage("Su rut o su Contraseña han sido mal ingresadas").setNeutralButton(R.string.aceptar, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            });
            dialog.show();
        }
        else
        {
        }
    }
}
