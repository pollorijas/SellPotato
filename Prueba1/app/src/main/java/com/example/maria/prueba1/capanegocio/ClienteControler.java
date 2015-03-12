package com.example.maria.prueba1.capanegocio;

import com.example.maria.prueba1.capadatos.DetallePedidoDB;
import com.example.maria.prueba1.capadatos.PedidoDB;
import com.example.maria.prueba1.capadatos.ProductoDB;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Freddy on 09-03-2015.
 */
public class ClienteControler{

    private static ClienteControler instance;
    private Cliente cliente;

    private ClienteControler()
    {}

    public static ClienteControler getInstance()
    {
        if(instance == null) return new ClienteControler();
        else return instance;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
