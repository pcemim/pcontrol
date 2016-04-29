/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process.control.web.mb;

import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import process.control.web.service.ConsultaService;
import process.control.web.vo.RetornoConsultaVO;

/**
 *
 * @author Paolo
 */
@ViewScoped
@ManagedBean(name = "consultaMB")
public class ConsultaMB {
    
    private static final long serialVersionUID = 1L;
    private String sistema,item,branch,projeto;
    private ResourceBundle resourceBundle; // local onde fica as mensagens e labels
    private List<RetornoConsultaVO> resultado;
    
    @Inject
    private ConsultaService consultaService;
    
    @PostConstruct
    public void init() {
        consultaService = new ConsultaService();
    }
    
    
    public void consultar(){
        
        resultado = consultaService.consultar(sistema, item, branch);
        
    }
    
    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public List<RetornoConsultaVO> getResultado() {
        return resultado;
    }

    public String getProjeto() {
        return projeto;
    }

    public void setProjeto(String projeto) {
        this.projeto = projeto;
    }
    
}
