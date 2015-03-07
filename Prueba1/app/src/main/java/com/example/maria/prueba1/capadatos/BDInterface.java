package com.example.maria.prueba1.capadatos;

/**
 * Created by Freddy on 05-03-2015.
 */
public interface BDInterface {

    //Interfaz Generica para uso comun de DB
    public <T> String Insert(T t);
    public <T> String Update(T t);
    public <T> String Delete(T t);
    public <T> void Get(T t);

}
