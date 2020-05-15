package bo;

import dao.entidadeDAO;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import vo.VendaBase;
import sam.business.spv.SPV0201BO;
import sam.dao.cas.Aa65DAO;
import sam.dao.cgs.Ab19DAO;
import sam.dao.cgs.Ab20DAO;
import sam.dao.cgs.Ab36DAO;
import sam.dao.cgs.Ab37DAO;
import sam.dao.cgs.Ab38DAO;
import sam.dao.cgs.Ab40DAO;
import sam.dao.cgs.Ab50DAO;
import sam.dao.cgs.Ab60DAO;
import sam.dao.cgs.Ab80DAO;
import sam.types.Decimal;
import sam.vo.cas.Aa65;
import sam.vo.cgs.Ab19;
import sam.vo.cgs.Ab20;
import sam.vo.cgs.Ab36;
import sam.vo.cgs.Ab37;
import sam.vo.cgs.Ab38;
import sam.vo.cgs.Ab40;
import sam.vo.cgs.Ab50;
import sam.vo.cgs.Ab60;
import sam.vo.cgs.Ab80;
import sam.vo.scn.Db10;
import kernel.sistema.Monitoramento;
import sam.business.kernel.VariaveisDoSistemaBO;
import sam.dao.cas.Aa30DAO;
import sam.dao.cgs.Ab59DAO;
import sam.dao.kernel.RootDAO;
import sam.dao.scn.Db10DAO;
import sam.kernel.ProcessoMultitec;
import sam.kernel.exceptions.ThreadCanceladaException;
import sam.vo.VariaveisDoSistemaVO;
import sam.vo.cas.Aa30;
import sam.vo.cgs.Ab59;



public class VendaBO {
    
    private Db10 localDb10 = new Db10();
    private final Ab80DAO ab80Dao = new Ab80DAO();
    private final Aa30DAO aa30Dao = new Aa30DAO();
    private final Db10DAO db10Dao = new Db10DAO();
    private final Aa65DAO aa65Dao = new Aa65DAO();
    private final Ab36DAO ab36Dao = new Ab36DAO();
    private final Ab50DAO ab50Dao = new Ab50DAO();
    private final Ab20DAO ab20Dao = new Ab20DAO();
    private final Ab40DAO ab40Dao = new Ab40DAO();
    private final Ab19DAO ab19Dao = new Ab19DAO();
    private final Ab37DAO ab37Dao = new Ab37DAO();
    private final Ab60DAO ab60Dao = new Ab60DAO();
    private final Ab38DAO ab38Dao = new Ab38DAO();
    private final Ab59DAO ab59Dao = new Ab59DAO();
    private final SPV0201BO spv0201bo = new SPV0201BO();
    
    private Ab80 ab80;
    private Aa30 aa30;
    private Aa65 aa65;
    private Ab36 ab36;
    private Ab50 ab50;
    private Ab20 ab20;
    private Ab40 ab40;
    private Ab19 ab19;
    private Ab37 ab37;
    private Ab60 ab60;
    private Ab38 ab38;
    private Ab59 ab59;
    private Db10 db10;
    
    
    public Db10 criarLancamento(VendaBase venda) throws IOException{
                        
        try{ 
            
            ab36 = ab36Dao.findByUniqueKey(venda.getCodUN());
            ab50 = ab50Dao.findByCodigo(venda.getCodItem(),0);            
            ab80 = ab80Dao.findByCodigo(venda.getCodEnt());
            aa65 = aa65Dao.findEmpresaById(venda.getIdEmpresa());
            ab20 = ab20Dao.findById(venda.getIdCC());
            ab40 = ab40Dao.findByUniqueKey(venda.getCodNat());
            ab19 = ab19Dao.findById(null);
            ab37 = ab37Dao.findByUniqueKey(null);
            ab60 = ab60Dao.findByUniqueKey(venda.getCodTabPreco());
            ab38 = ab38Dao.findByUniqueKey(venda.getCodFormPgto());
            ab59 = ab59Dao.findByUniqueKey(null);
            aa30 = aa30Dao.findByUniqueKey(venda.getUsuario());
            
            
            localDb10 = spv0201bo.criarLancamento(ab50, ab36, ab80,new Decimal(venda.getQtd()),new Decimal(venda.getVlrUnit()), ab20, ab19, ab80, "Venda efetuada pelo LESPDV", ab60, ab37);
            localDb10.setDb10identvda(venda.getComanda());
            localDb10.setDb10desc(new Decimal(venda.getDesconto()));
            localDb10.setAb80ByDb10rep(((Ab80)ab80Dao.findByCodigo((new entidadeDAO().idEntidadeAgente(aa30.getAa30nome().toString())))));
              
            
        }catch(Exception e){
            System.out.println("Status:" + e);                        
            new Monitoramento().gerarLogErro((e).toString(),this.getClass().getName());
        }
        
        return localDb10;
    }
    
    
    public void gravarLancamento(Db10 localDb10){
    
        spv0201bo.gravarLancamento(localDb10);
    
    }
    
    
    public void processarSCE(){

      //  spv0201bo.processarSCE(List<localDb10> paramList);
    
    }
    
    
    public void excluirLancamentosVenda(String numLancamento) throws ThreadCanceladaException, Exception{
        
        db10 = db10Dao.findByUniqueKey(new Integer(numLancamento));
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(db10);
        spv0201bo.excluirLctosVenda(localArrayList);
    
    }
    
}
