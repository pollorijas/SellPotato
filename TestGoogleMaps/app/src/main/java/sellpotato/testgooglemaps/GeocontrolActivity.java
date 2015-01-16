package sellpotato.testgooglemaps;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;


public class GeocontrolActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geocontrol);

        UserTask r = new UserTask();
        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=+Manuel+Rodriguez+2155,+Iquique&region=cl&sensor=false";
        r.execute(url);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_geocontrol, menu);
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

    private ArrayList<Posicion> parsePoints(String strResponse) {

        ArrayList<Posicion> result=new ArrayList<Posicion>();
        try {
            JSONObject obj=new JSONObject(strResponse);
            JSONArray array=obj.getJSONArray("results");
            for(int i=0;i<array.length();i++)
            {
                Posicion point=new Posicion();

                JSONObject item=array.getJSONObject(i);
                ArrayList<HashMap<String, Object>> tblPoints=new ArrayList<HashMap<String,Object>>();
                JSONArray jsonTblPoints=item.getJSONArray("address_components");
                for(int j=0;j<jsonTblPoints.length();j++)
                {
                    JSONObject jsonTblPoint=jsonTblPoints.getJSONObject(j);
                    HashMap<String, Object> tblPoint=new HashMap<String, Object>();
                    Iterator<String> keys=jsonTblPoint.keys();
                    while(keys.hasNext())
                    {
                        String key=(String) keys.next();
                        if(tblPoint.get(key) instanceof JSONArray)
                        {
                            tblPoint.put(key, jsonTblPoint.getJSONArray(key));
                        }
                        tblPoint.put(key, jsonTblPoint.getString(key));
                    }
                    tblPoints.add(tblPoint);
                }
                //point.setAddressFields(tblPoints);
                point.setDireccion(item.getString("formatted_address"));
                JSONObject geoJson=item.getJSONObject("geometry");
                JSONObject locJson=geoJson.getJSONObject("location");
                point.setLatitud(Double.parseDouble(locJson.getString("lat")));
                point.setLongitud(Double.parseDouble(locJson.getString("lng")));
                //point.CreateCoordenada();
                result.add(point);
            }
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }

    private class UserTask extends AsyncTask<String, Integer, ArrayList<Posicion>>{

        //Context context;

        @Override
        protected ArrayList<Posicion> doInBackground(String... params) {

            ArrayList<Posicion> ruta = null;
            HttpConnection http = new HttpConnection();

            try {
                String response = http.readUrl(params[0]);
                ruta = parsePoints(response);

            } catch (IOException e) {
                Log.d("Error en conectarse a google maps", e.toString());
                //e.printStackTrace();
            }
            return ruta;
        }

        @Override
        protected void onPostExecute(ArrayList<Posicion> ruta) {

            Intent act = new Intent(getApplicationContext(),MapsActivity.class);
            act.putExtra("waypoint",ruta.get(0));
            startActivity(act);

        }
    }
}
