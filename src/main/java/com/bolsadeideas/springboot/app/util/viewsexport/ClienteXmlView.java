package com.bolsadeideas.springboot.app.util.viewsexport;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.xml.MarshallingView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component("listar.xml")
public class ClienteXmlView extends MarshallingView {

    @Autowired
    //Para que coincida con la configuracion del MVCConfig Jaxb2Marshaller
    public ClienteXmlView(Jaxb2Marshaller marshaller) {
        super(marshaller);
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //Limpio la vista o model para dejarla totalmente libre para guardar el xml
        model.remove("titulo");
        model.remove("page");
        Page<Cliente> clientes = (Page<Cliente>) model.get("clientes"); //Antes guardo los clientes del model en un Object
        model.remove("clientes");
        //Agregar la lista de cliente al model desde el Wrapper:
        model.put("clienteList", new WrapperClienteXml(clientes.getContent()));
        super.renderMergedOutputModel(model, request, response);
    }

}
