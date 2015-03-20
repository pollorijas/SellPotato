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

    private Cliente cliente;

    public ClienteControler(){}

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public boolean ModificarCliente()
    {
        String get = cliente.getData().Update(cliente);
        if(get.equals("SUCCESSFUL")) return true;
        else return false;
    }

    public boolean Registrar()
    {
        String get = cliente.getData().Insert(cliente);
        if(get.equals("SUCCESSFUL")) return true;
        else return false;
    }
}
