package com.bolsadeideas.springboot.app.controllers;

import com.bolsadeideas.springboot.app.models.dao.IClienteDao;
import com.bolsadeideas.springboot.app.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
class ClienteRestController {

    @Autowired
    private IClienteDao clienteService;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public List<Cliente> listarRest() {
        return (List<Cliente>) clienteService.findAll();
    }
}
