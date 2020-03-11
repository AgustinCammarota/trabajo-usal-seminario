package com.bolsadeideas.springboot.app.models.dao;

import com.bolsadeideas.springboot.app.models.entity.Factura;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IFacturaDao extends CrudRepository<Factura, Long> {
    //Esto metodo permite simplificar la cantidad de consultas hpql que hace el findById ordinario
    @Query("select f from Factura f join fetch f.cliente c join fetch f.items l join fetch l.producto p where f.id=?1")
    Factura fetchById(Long id);
}
