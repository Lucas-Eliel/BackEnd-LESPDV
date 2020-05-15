package orm;
import dao.siteDAO;
import dao.usuarioDAO;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.json.simple.parser.ParseException;
import org.postgresql.core.Encoding;
import sam.cliente.business.kernel.InicializacaoClienteLBO;
import sam.cliente.swing.kernel.main.LookAndFeel;
import sam.dao.kernel.RootDAO;
import sam.kernel.ProcessoMultitec;
import sam.kernel.factory.BOFactory;
import sam.kernel.factory.DAOFactory;
import sam.types.ConnectionBroken;
import sam.vo.VariaveisDoSistemaVO;
import sam.vo.cas.Aa30;
import kernel.sistema.Monitoramento;
import kernel.util.Config;
import sam.dao.cas.Aa30DAO;
import sam.dao.kernel.ProcessoMultitecDAO;
import static sam.dao.kernel.RootDAO.inicializaBanco;
import sam.kernel.RecursoMultitec;
import vo.site;
import vo.usuario;


public class ConectionDB {

    private String DRIVER;
    private String URL;
    private String USUARIO;
    private String SENHA;    
    Config conf = new Config();
    
    
    
    public Connection criarConexaoSite() throws ParseException, IOException{
        
        DRIVER = "org.postgresql.Driver";
        URL = "jdbc:postgresql://191.252.202.70:5432/site";
        USUARIO = "postgres";
        SENHA = "postgres";
        Connection conexao = null;

        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (Exception e) {
            new Monitoramento().gerarLogErro((e).toString(),this.getClass().getName());
        }
        return conexao;
    }

    
    
    
    public void fecharConexaoSite(Connection conexao, PreparedStatement pstmt, ResultSet rs){
        try {
            if(conexao != null){
                conexao.close();
            }
            if(pstmt != null){
                    pstmt.close();
            }
            if(rs != null){
                    rs.close();
            }
        } catch (Exception e) {
                System.out.println("Erro ao fechar conexão com o banco: " + URL);
        }
    } 
    
    
    
    public Connection criarConexaoCliente() throws ParseException, IOException{
        
        siteDAO dadosBanco = new siteDAO();
        site integrate = dadosBanco.listaIntegrate();
        
        DRIVER = "org.postgresql.Driver";
        URL = "jdbc:postgresql://"+integrate.getIp()+":"+integrate.getPorta()+"/"+integrate.getNomeBase()+"";
        USUARIO = integrate.getUsuario();
        SENHA = integrate.getSenha();
        Connection conexao = null;

////        DRIVER = "org.postgresql.Driver";
////        URL = "jdbc:postgresql://localhost:5432/agrodel";
////        USUARIO = "postgres";
////        SENHA = "postgres";
////        Connection conexao = null;


        try {
            Class.forName(DRIVER);
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        } catch (Exception e) {
            new Monitoramento().gerarLogErro((e).toString(),this.getClass().getName());
        }
        return conexao;
    }
    
    
    public void fecharConexaoCliente(Connection conexao, PreparedStatement pstmt, ResultSet rs){
        
        try {
            if(conexao != null){
                conexao.close();
            }
            if(pstmt != null){
                    pstmt.close();
            }
            if(rs != null){
                    rs.close();
            }
        } catch (Exception e) {
                System.out.println("Erro ao fechar conexão com o banco: " + URL);
        }
    } 
    
}
