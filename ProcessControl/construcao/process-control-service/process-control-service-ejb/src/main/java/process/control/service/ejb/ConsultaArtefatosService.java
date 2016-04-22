/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package process.control.service.ejb;

import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.ejb.Stateless;
import javax.jws.WebResult;
import javax.jws.WebService;
import org.tmatesoft.svn.core.SVNDirEntry;
import org.tmatesoft.svn.core.SVNException;
import org.tmatesoft.svn.core.SVNNodeKind;
import org.tmatesoft.svn.core.SVNURL;
import org.tmatesoft.svn.core.auth.ISVNAuthenticationManager;
import org.tmatesoft.svn.core.internal.io.dav.DAVRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.fs.FSRepositoryFactory;
import org.tmatesoft.svn.core.internal.io.svn.SVNRepositoryFactoryImpl;
import org.tmatesoft.svn.core.io.SVNRepository;
import org.tmatesoft.svn.core.io.SVNRepositoryFactory;
import org.tmatesoft.svn.core.wc.SVNWCUtil;
import process.control.service.bean.InConsultarAprov;
import process.control.service.bean.InConsultarBaseline;
import process.control.service.bean.InConsultarEvidTestes;
import process.control.service.bean.OutConsultarAprov;
import process.control.service.bean.OutConsultarBaseline;
import process.control.service.bean.OutConsultarEvidTestes;
import process.control.service.iface.ConsultaArtefatosLocal;

/**
 *
 * @author Paolo
 */
@WebService(serviceName = "ConsultaArtefatosService")
@Stateless
public class ConsultaArtefatosService implements ConsultaArtefatosLocal {

    @Override
    @WebResult(name = "OutConsultarAprov")
    public OutConsultarAprov consultarAprov(InConsultarAprov in) {

        OutConsultarAprov out = new OutConsultarAprov();

        DAVRepositoryFactory.setup();
        String sistema = in.getSistema();
        String item = in.getItem();
        String projeto = in.getProjeto();
        String branch = in.getBranch();

        String urlDocs = "http://svn.sicredi.net/sistemas/" + sistema + "/docs/projetos/pj" + projeto + "/";

        String name = "anonymous";
        String password = "anonymous";
        String filePath = "";

        SVNRepository repository = null;
        try {
            repository = SVNRepositoryFactory.create(SVNURL.parseURIEncoded(urlDocs));
        } catch (SVNException ex) {
            Logger.getLogger(ConsultaArtefatosService.class.getName()).log(Level.SEVERE, null, ex);
        }
        ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(name, password);
        repository.setAuthenticationManager(authManager);

        try {
            SVNNodeKind nodeKind = repository.checkPath(filePath, -1);
        } catch (SVNException ex) {
            Logger.getLogger(ConsultaArtefatosService.class.getName()).log(Level.SEVERE, null, ex);
        }

        //        if (nodeKind == SVNNodeKind.NONE) {
        //            System.err.println("There is no entry at '" + url + "'.");
        //            System.exit(1);
        //        } else if (nodeKind == SVNNodeKind.DIR) {
        //            System.err.println("The entry at '" + url + "' is a directory while a file was expected.");
        //            System.exit(1);
        //        }
        try {
            System.out.println("Repository Root: " + repository.getRepositoryRoot(true));
            System.out.println("Repository UUID: " + repository.getRepositoryUUID(true));
            System.out.println("");
            listEntries(repository, "");
        } catch (SVNException ex) {
            Logger.getLogger(ConsultaArtefatosService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return out;
    }

    @Override
    @WebResult(name = "OutConsultarBaseline")
    public OutConsultarBaseline consultarBaseline(InConsultarBaseline in) {
        OutConsultarBaseline out = new OutConsultarBaseline();
        return out;
    }

    @Override
    @WebResult(name = "OutConsultarEvidTestes")
    public OutConsultarEvidTestes consultarEvidTestes(InConsultarEvidTestes in) {
        OutConsultarEvidTestes out = new OutConsultarEvidTestes();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static Boolean listEntries(SVNRepository repository, String path)
            throws SVNException {

        Collection entries = repository.getDir(path, -1, null,
                (Collection) null);
        Iterator iterator = entries.iterator();
        while (iterator.hasNext()) {
            SVNDirEntry entry = (SVNDirEntry) iterator.next();
            if (entry.getKind() == SVNNodeKind.FILE) {
                if (Pattern.matches("*", entry.getName())) {
                    return Boolean.TRUE;
                }
            }
            
            if (entry.getKind() == SVNNodeKind.DIR) {
                if (listEntries(repository, (path.equals("")) ? entry.getName() : path + "/" + entry.getName()) != null) 
                    break;
            }
        }
        return null;
    }

}
