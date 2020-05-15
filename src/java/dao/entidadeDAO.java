package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.json.simple.parser.ParseException;
import orm.ConectionDB;
import kernel.sistema.Monitoramento;
import kernel.util.Config;
import vo.entidade;

public class entidadeDAO extends ConectionDB {
        
        public String token;
        Config conf = new Config();
    
	private static entidadeDAO instance;
	
	public static entidadeDAO getInstance(){
		if(instance == null)
			instance = new entidadeDAO();
		return instance;
	}
                        

        public ArrayList<entidade> listarEntidades(String descrEntidade) throws ParseException, IOException{
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<entidade> clientes = null;
		
		conexao = criarConexaoCliente();
		clientes = new ArrayList<entidade>();
		try {
			pstmt = conexao.prepareStatement("select * from ab80 inner join aa80 on ab80ent = aa80id  where UPPER(aa80nome) like UPPER('%"+descrEntidade+"%') order by aa80na");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				entidade ab80 = new entidade();
				
				ab80.setCodigo(rs.getString("ab80codigo"));
				ab80.setNome(rs.getString("aa80na"));
                                ab80.setVlrDesconto(rs.getString("ab80cdesctxincond"));
				clientes.add(ab80);
			}
			
		} catch (Exception e) {
                        System.out.println("Status:" + e);                        
			new Monitoramento().gerarLogErro((e).toString(),this.getClass().getName());
		} finally {
			fecharConexaoCliente(conexao, pstmt, rs);
		}
		return clientes;
        }
        
        
        public String idEntidadeAgente(String agente) throws ParseException, IOException{
            
            Connection conexao = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            String result = null;
            conexao = criarConexaoCliente();

            try {
                    pstmt = conexao.prepareStatement("select * from ab80 inner join aa30 on ab80ruser = aa30id where aa30nome = '"+agente+"' ");
                    rs = pstmt.executeQuery();
                    
                    while(rs.next()){
                        result = rs.getString("ab80codigo");
                    }
                    
            } catch (Exception e) {
                    System.out.println("Status:" + e);                        
                    new Monitoramento().gerarLogErro((e).toString(),this.getClass().getName());
            } finally {
                    fecharConexaoCliente(conexao, pstmt, rs);
            }
            return result;
         
        }

}
