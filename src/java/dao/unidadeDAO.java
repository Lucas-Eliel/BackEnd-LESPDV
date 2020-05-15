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
import vo.unidade;

public class unidadeDAO extends ConectionDB {
        
        public String token;
        Config conf = new Config();
    
	private static unidadeDAO instance;
	
	public static unidadeDAO getInstance(){
		if(instance == null)
			instance = new unidadeDAO();
		return instance;
	}
                        

        public ArrayList<unidade> listarUnidades(String descrUnidade) throws ParseException, IOException{
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<unidade> clientes = null;
		
		conexao = criarConexaoCliente();
		clientes = new ArrayList<unidade>();
		try {
			pstmt = conexao.prepareStatement("select * from ab36 inner join ab80 on ab36ent = ab80id inner join aa80 on ab80ent = aa80id  where UPPER(ab36descr) like UPPER('%"+descrUnidade+"%') order by ab36codigo");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				unidade ab36 = new unidade();
				
				ab36.setCodigoUn(rs.getString("ab36codigo"));
                                ab36.setDescrUn(rs.getString("ab36descr"));
                                ab36.setCodigoEnt(rs.getString("ab80codigo"));
                                ab36.setDescrEnt(rs.getString("aa80na"));
				clientes.add(ab36);
			}
			
		} catch (Exception e) {
                        System.out.println("Status:" + e);                        
			new Monitoramento().gerarLogErro((e).toString(),this.getClass().getName());
		} finally {
			fecharConexaoCliente(conexao, pstmt, rs);
		}
		return clientes;
        }
        
}
