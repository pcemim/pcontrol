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
public class OutConsultarBaseline implements Serializable{
    
    private Boolean existeAS;
    private Boolean existePR;

    public Boolean getExisteAS() {
        return existeAS;
    }

    public void setExisteAS(Boolean existeAS) {
        this.existeAS = existeAS;
    }

    public Boolean getExistePR() {
        return existePR;
    }

    public void setExistePR(Boolean existePR) {
        this.existePR = existePR;
    }

}
