package sellpotato.sellpotato;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Login_In extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login__in);
        Bundle e = getIntent().getExtras();
        TextView t = (TextView)findViewById(R.id.l_nombre);
        t.setText(e.getString("name"));
        t = (TextView)findViewById(R.id.apellido_l);
        t.setText(e.getString("apellido"));
        t = (TextView)findViewById(R.id.fono_l);
        t.setText(e.getString("fono"));
        t = (TextView)findViewById(R.id.direccion_l);
        t.setText(e.getString("direccion"));
    }

//sdxzxzxzxz
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login__in, menu);
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
}
