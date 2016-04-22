/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process.control.service.bean;

import java.io.Serializable;

/**
 *
 * @author Paolo
 */
public class OutConsultarEvidTestes implements Serializable{
    
    private Boolean existe;

    public Boolean getExiste() {
        return existe;
    }

    public void setExiste(Boolean existe) {
        this.existe = existe;
    }
    
}
