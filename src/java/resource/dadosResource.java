package resource;

import bo.VendaBO;
import com.google.gson.Gson;
import controller.comandaController;
import controller.entidadeController;
import controller.itemController;
import controller.lancamentosController;
import controller.unidadeController;
import controller.usuarioController;
import java.io.IOException;
import java.util.ArrayList;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import vo.VendaBase;
import org.json.simple.parser.ParseException;
import orm.ConectionDB;
import orm.ConectionSAM;
import sam.cliente.swing.kernel.componentes.tela.Mensagem;
import sam.kernel.exceptions.ThreadCanceladaException;
import sam.vo.scn.Db10;
import vo.comanda;
import vo.entidade;
import vo.item;
import vo.lancamento;
import vo.unidade;

    @Path("/dados")
    public class dadosResource {
        
    
    @POST
    @Path("/novaVenda")
    @Consumes("application/json")
    public String novaVenda(String venda) throws IOException, Exception{
        Gson gson = new Gson();
        VendaBase vendaBase = (VendaBase) gson.fromJson(venda, VendaBase.class);
        new ConectionSAM().criarTransacaoSAM(vendaBase.getUsuario());
        VendaBO vendaBO = new VendaBO();
        Db10 localDb10 = vendaBO.criarLancamento(vendaBase);
        vendaBO.gravarLancamento(localDb10);
        return "true";
    }
        
    @DELETE
    @Path("/excluiVenda/{numLancamento}/{usuario}")
    @Consumes("application/json")
    public String excluiVenda(@PathParam("numLancamento") String numLancamento, @PathParam("usuario") String usuario) throws IOException, Exception, ThreadCanceladaException{
        new ConectionSAM().criarTransacaoSAM(usuario);
        VendaBO vendaBO = new VendaBO();
        vendaBO.excluirLancamentosVenda(numLancamento);
        return "true";
    }
    
    @GET
    @Path("/validaUsuario/{user}/{senha}")
    @Produces("application/json")
    public String validaUsuario(@PathParam("user") String user,@PathParam("senha") String senha) throws ParseException, IOException, org.json.simple.parser.ParseException, java.text.ParseException{
        return new usuarioController().validaUsuario(user,senha);
    }
    
    @GET
    @Path("/ultimoNumeroComanda")
    @Produces("application/json")
    public ArrayList<comanda> ultimoNumeroComanda() throws ParseException, IOException{
        return new comandaController().ultimoNumeroComanda();        
    }
    
    @GET
    @Path("/listarDadosComanda/{comanda}")
    @Produces("application/json")
    public ArrayList<comanda> listarDadosComanda(@PathParam("comanda") String comanda) throws ParseException, IOException{
        return new comandaController().listarDadosComanda(comanda);        
    }
    
    @GET
    @Path("/listarItemEan/{ean}")
    @Produces("application/json")
    public ArrayList<item> listaItemEan(@PathParam("ean") String ean) throws ParseException, IOException, org.json.simple.parser.ParseException, java.text.ParseException{                
        return new itemController().listarItemEan(ean);
    }
    
    @GET
    @Path("/listarItemDescr/{descr}")
    @Produces("application/json")
    public ArrayList<item> listaItemDescr(@PathParam("descr") String descr) throws ParseException, IOException, org.json.simple.parser.ParseException, java.text.ParseException{                
        return new itemController().listarItemDescr(descr);
    }
    
    @GET
    @Path("/listarLancamentos/{comanda}")
    @Produces("application/json")
    public ArrayList<lancamento> listarLancamentos(@PathParam("comanda") String comanda) throws ParseException, IOException{
        return new lancamentosController().listarLancamentos(comanda);        
    }
    
    @GET
    @Path("/listarTotalLancamentos/{comanda}")
    @Produces("application/json")
    public ArrayList<lancamento> listarTotalLancamentos(@PathParam("comanda") String comanda) throws ParseException, IOException{
        return new lancamentosController().listarTotalLancamentos(comanda);        
    }
        
    @GET
    @Path("/listarNumLancamentos")
    @Produces("application/json")
    public ArrayList<lancamento> listarNumLancamentos() throws ParseException, IOException{
        return new lancamentosController().listarNumLancamentos();        
    }
    
    @GET
    @Path("/listarEntidades/{descrEntidade}")
    @Produces("application/json")
    public ArrayList<entidade> listarEntidades(@PathParam("descrEntidade") String descrEntidade) throws ParseException, IOException{
        return new entidadeController().listarEntidades(descrEntidade);        
    }
    
    @GET
    @Path("/listarUnidades/{descrUnidade}")
    @Produces("application/json")
    public ArrayList<unidade> listarUnidades(@PathParam("descrUnidade") String descrUnidade) throws ParseException, IOException{
        return new unidadeController().listarUnidades(descrUnidade);        
    }
    
    @GET
    @Path("/fecharTransacaoSAM/{usuario}")
    @Produces("application/json")
    public String fecharTransacaoSAM(@PathParam("usuario") String usuario) throws ParseException, IOException, Exception{
        new ConectionSAM().fecharTransacaoSAM(usuario);  
        return "true";
    }
    
    
    
}
