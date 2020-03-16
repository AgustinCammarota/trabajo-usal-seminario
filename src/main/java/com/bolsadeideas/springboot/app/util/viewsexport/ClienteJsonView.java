package com.bolsadeideas.springboot.app.util.viewsexport;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.Map;

@Component("listar.json")
public class ClienteJsonView extends MappingJackson2JsonView {

    //Permite filtrar o quitar algunos elementos del model que pasamos a la vista
    @Override
    protected Object filterModel(Map<String, Object> model) {
        model.remove("titulo");
        model.remove("page");
        Page<Cliente> clientes = (Page<Cliente>) model.get("clientes");
        model.remove("clientes"); //Vuelvo a pasar la lista de clientes al model, Pero "limpia" sin el paginador
        model.put("clientes", clientes.getContent());
        return super.filterModel(model);
    }
}
