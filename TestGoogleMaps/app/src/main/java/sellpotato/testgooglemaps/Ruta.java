package sellpotato.testgooglemaps;

import java.util.ArrayList;

/**
 * Created by Freddy on 15-01-2015.
 */
public class Ruta {

    private ArrayList<Posicion> posicions;
    private Posicion central;
    private ArrayList<Posicion> sur;
    private ArrayList<Posicion> norte;

    public Ruta() {
        posicions = new ArrayList<Posicion>();
        sur = new ArrayList<Posicion>();
        norte = new ArrayList<Posicion>();
    }

    public ArrayList<Posicion> getPosicions() {
        return posicions;
    }

    public void setPosicions(ArrayList<Posicion> posicions) {
        this.posicions = posicions;
    }

    public void ordenarRuta() {
        if (!this.posicions.isEmpty())
        {
            central = posicions.get(0);

            for(int i = 1; i < posicions.size(); i++)
            {
                Posicion aux = posicions.get(i);

                if(this.central.getLongitud() >= aux.getLongitud() )
                {
                    //se hace que esta al sur?
                }
                else{
                    //se hace que esta al norte?
                }

            }

        }
    }
}
