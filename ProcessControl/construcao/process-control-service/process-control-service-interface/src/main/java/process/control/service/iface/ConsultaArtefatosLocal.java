/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process.control.service.iface;

import javax.ejb.Local;
import javax.jws.WebParam;
import process.control.service.bean.*;

/**
 *
 * @author Paolo
 */
@Local
public interface ConsultaArtefatosLocal {
 
    public OutConsultarAprov consultarAprov(@WebParam(name = "InConsultarAprov") InConsultarAprov in);
    
    public OutConsultarEvidTestes consultarEvidTestes(@WebParam(name = "InConsultarEvidTestes") InConsultarEvidTestes in);
    
    public OutConsultarBaseline consultarBaseline(@WebParam(name = "InConsultarBaseline") InConsultarBaseline in);
    
}
