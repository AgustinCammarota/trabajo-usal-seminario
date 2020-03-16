package com.bolsadeideas.springboot.app.util.viewsexport;

import com.bolsadeideas.springboot.app.models.entity.Cliente;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.AbstractView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component("listar.csv")
// Como no hay un abstract para la vista CSV tengo que crear uno basandome en una clase mas abstracta:
public class ClienteCsvView extends AbstractView {

    public ClienteCsvView() {
        //indica el tipo de contenido
        setContentType("text/csv");
    }

    //Ya que es un archivo que se descarga tengo que sobreescribir el metodo:
    @Override
    protected boolean generatesDownloadContent() {
        return true;
    }

    //El extender de AbstractView me obliga de implementar el metodo:
    @Override
    protected void renderMergedOutputModel(Map<String, Object> map, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletResponse.setHeader("Content-Disposition", "attachment; filename=\"clientes.csv\""); //Indicamos la extencion y el nombre del archivo a descargar
        httpServletResponse.setContentType(getContentType());//Pasamos el tipo de contenido especificado en el constructor

        Page<Cliente> clientes = (Page<Cliente>) map.get("clientes"); //Obtengo la lista de clientes que es un paginable
        //Toma un bean ej cliente, con sus atributos y metodos y lo convierte en una linea del archivo plano
        ICsvBeanWriter beanWriter = new CsvBeanWriter(httpServletResponse.getWriter(), CsvPreference.STANDARD_PREFERENCE);

        String[] header = {"id", "nombre", "apellido", "email", "createAt"}; //Para saber que atributos seran parte (nombre columna)
        beanWriter.writeHeader(header);

        //Para llenar el texto plano con los datos del cliente y el nombre de la columna
        for (Cliente cliente : clientes) {
            beanWriter.write(cliente, header);
        }
        beanWriter.close();

    }
}
