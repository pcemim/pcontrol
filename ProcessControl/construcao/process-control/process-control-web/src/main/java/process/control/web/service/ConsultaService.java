/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process.control.web.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import process.control.web.vo.RetornoConsultaVO;

/**
 *
 * @author Paolo
 */
@Named
public class ConsultaService implements Serializable{
    
    private static final long serialVersionUID = -1L;
    // SERVICO
    
    public ConsultaService(){
        
    }
    
    public List<RetornoConsultaVO> consultar(String sistema, String item, String branch){
        
        
        
        return new ArrayList<>();
        
    }
    
}
