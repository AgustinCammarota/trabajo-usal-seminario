package com.bolsadeideas.springboot.app.util.viewsexport;

import com.bolsadeideas.springboot.app.models.entity.Cliente;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "clientes")
public class WrapperClienteXml {

    @XmlElement(name = "cliente")
    public List<Cliente> clientes;

    public WrapperClienteXml() {
    }

    public WrapperClienteXml(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}
