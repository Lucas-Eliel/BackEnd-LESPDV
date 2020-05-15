package orm;

import dao.siteDAO;
import kernel.sistema.Monitoramento;
import org.postgresql.core.Query;
import sam.business.kernel.ValidacoesIniciais;
import sam.dao.cas.Aa30DAO;
import sam.dao.cas.base.Aa30DAOBase;
import sam.dao.kernel.RootDAO;
import sam.kernel.ProcessoMultitec;
import static sam.kernel.ProcessoMultitec.factory;
import sam.kernel.RecursoMultitec;
import sam.kernel.exceptions.BancoDadosException;
import sam.kernel.exceptions.ValidacaoException;
import sam.kernel.factory.BOFactory;
import sam.kernel.factory.DAOFactory;
import sam.orm.Session;
import sam.orm.WebSessionFactory;
import sam.types.ConnectionBroken;
import sam.types.MultiSQLType;
import sam.vo.VariaveisDoSistemaVO;
import sam.vo.cas.Aa01;
import sam.vo.cas.Aa30;
import vo.site;


public class ConectionSAM extends RecursoMultitec{
    
    
    public void criarTransacaoSAM(String usuario) throws Exception {
        
        siteDAO dadosBanco = new siteDAO();
        site integrate = dadosBanco.listaIntegrate();
        
        sam.orm.ConnectionControl.SHOW_SQL = true;
        
        RootDAO.factory = new DAOFactory();
        ProcessoMultitec.factory = new BOFactory();

        ConnectionBroken init = new ConnectionBroken();

        init.setNome(integrate.getNomeBase());
        init.setServidor(integrate.getIp()+":"+integrate.getPorta());
        init.setVendor("Postgre");
        init.setUsuario(integrate.getUsuario());
        init.setSenha(integrate.getSenha());

//        init.setNome("agrodel");
//        init.setServidor("localhost");
//        init.setVendor("Postgre");
//        init.setUsuario("postgres");
//        init.setSenha("postgres");
        
        ProcessoMultitec.factory.getInicializaBancoDadosBO().conectaBDExterno(init);
        
        Aa30DAO localAa30DAO = RootDAO.factory.getAa30DAO();
        Aa30 user = RootDAO.factory.getAa30DAO().findByUserWithParametros(usuario);
        
        if (user.getAa30dtcad() != null){
            
            user.setAa30dtcad(null);
            localAa30DAO.clearLic(user.getAa30id(), false);

        }
        
        user.setAa30dtcad(VariaveisDoSistemaVO.getInstance().getTime());
        RootDAO.factory.getAa30DAO().saveOrUpdate(user);
        
        ProcessoMultitec.factory.getVariaveisDoSistemaBO().carregarRestricoesUsusario(user, user.getAa65());
         
    }
    
    
    
    
     public void fecharTransacaoSAM(String usuario) throws Exception {
        
        siteDAO dadosBanco = new siteDAO();
        site integrate = dadosBanco.listaIntegrate();
        
        sam.orm.ConnectionControl.SHOW_SQL = true;
        
        RootDAO.factory = new DAOFactory();
        ProcessoMultitec.factory = new BOFactory();

        ConnectionBroken init = new ConnectionBroken();

        init.setNome(integrate.getNomeBase());
        init.setServidor(integrate.getIp()+":"+integrate.getPorta());
        init.setVendor("Postgre");
        init.setUsuario(integrate.getUsuario());
        init.setSenha(integrate.getSenha());

//        init.setNome("agrodel");
//        init.setServidor("localhost");
//        init.setVendor("Postgre");
//        init.setUsuario("postgres");
//        init.setSenha("postgres");
        
        ProcessoMultitec.factory.getInicializaBancoDadosBO().conectaBDExterno(init);
        
        Aa30DAO localAa30DAO = RootDAO.factory.getAa30DAO();
        Aa30 user = RootDAO.factory.getAa30DAO().findByUserWithParametros(usuario);
        
        if (user.getAa30dtcad() != null){
            
            user.setAa30dtcad(null);
            localAa30DAO.clearLic(user.getAa30id(), false);

        }
        
        user.setAa30dtcad(VariaveisDoSistemaVO.getInstance().getTime());
        RootDAO.factory.getAa30DAO().saveOrUpdate(user);
        
        ProcessoMultitec.factory.getVariaveisDoSistemaBO().carregarRestricoesUsusario(user, user.getAa65());
         
    }
    
}