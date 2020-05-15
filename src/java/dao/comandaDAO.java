package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import kernel.sistema.Monitoramento;
import kernel.util.Config;
import org.json.simple.parser.ParseException;
import orm.ConectionDB;
import vo.comanda;
import vo.entidade;


public class comandaDAO extends ConectionDB {
    
     
        Config conf = new Config();
    
	private static comandaDAO instance;
	
	public static comandaDAO getInstance(){
		if(instance == null)
			instance = new comandaDAO();
		return instance;
	}
                        

        public ArrayList<comanda> ultimoNumeroComanda() throws ParseException, IOException{
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<comanda> numero = null;
		
		conexao = criarConexaoCliente();
		numero = new ArrayList<comanda>();
		try {
			pstmt = conexao.prepareStatement("select max(db10identvda)+1 as ultimaComanda from db10");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				comanda db10 = new comanda();
				
				db10.setNumero(rs.getString("ultimaComanda"));
				numero.add(db10);
			}
			
		} catch (Exception e) {
                        System.out.println("Status:" + e);                        
			new Monitoramento().gerarLogErro((e).toString(),this.getClass().getName());
		} finally {
			fecharConexaoCliente(conexao, pstmt, rs);
		}
		return numero;
        }
        
        
        
        public ArrayList<comanda> listarDadosComanda(String comanda) throws ParseException, IOException{
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<comanda> numero = null;
		
		conexao = criarConexaoCliente();
		numero = new ArrayList<comanda>();
		try {
			pstmt = conexao.prepareStatement("select * from db10 " +
                                                        "inner join ab80 on db10ent = ab80id " +
                                                        "inner join aa80 on ab80ent = aa80id " +
                                                        "inner join ab36 on db10un = ab36id " +
                                                        "where db10identvda = '"+comanda+"' limit 1");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				comanda db10 = new comanda();
				
				db10.setNumero(rs.getString("db10identvda"));
                                db10.setCodEntidade(rs.getString("ab80codigo"));
                                db10.setDesconto(rs.getString("ab80cdesctxincond"));
                                db10.setDescrEntidade(rs.getString("aa80na"));
                                db10.setCodUnidade(rs.getString("ab36codigo"));
                                db10.setDescrUnidade(rs.getString("ab36descr"));

				numero.add(db10);
			}
			
		} catch (Exception e) {
                        System.out.println("Status:" + e);                        
			new Monitoramento().gerarLogErro((e).toString(),this.getClass().getName());
		} finally {
			fecharConexaoCliente(conexao, pstmt, rs);
		}
		return numero;
        }
    
}
