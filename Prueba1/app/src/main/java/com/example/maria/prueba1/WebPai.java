package com.example.maria.prueba1;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class WebPai extends ActionBarActivity {

    Button btnrc, btntc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_pai);

        btnrc = (Button)findViewById(R.id.btnrc);
        btntc = (Button)findViewById(R.id.btntc);

        btnrc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent rc = new Intent(getApplicationContext(),RedCompra.class);
                startActivity(rc);
            }
        });

        btntc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tc = new Intent(getApplicationContext(),RedCompra.class);
                startActivity(tc);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_web_pai, menu);
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
