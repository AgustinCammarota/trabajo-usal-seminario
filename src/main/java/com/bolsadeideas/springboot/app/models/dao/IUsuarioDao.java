package com.bolsadeideas.springboot.app.models.dao;

import com.bolsadeideas.springboot.app.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {

    //Segunda forma de personalizar las consulta mediante palabras claves en el metodo
    Usuario findByUsername(String username);
}
