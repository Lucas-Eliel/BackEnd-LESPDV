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
import vo.item;


public class itemDAO extends ConectionDB {
        
        public String token;
        Config conf = new Config();
    
	private static itemDAO instance;
	
	public static itemDAO getInstance(){
		if(instance == null)
			instance = new itemDAO();
		return instance;
	}
                        

        public ArrayList<item> listarItemEan(String ean) throws ParseException, IOException{
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<item> dados = null;

		
		conexao = criarConexaoCliente();
		dados = new ArrayList<item>();
		try {
			pstmt = conexao.prepareStatement("select ab50codigo,aa50descr,ab601preco from ab50\n" +
                                                         "inner join aa50 on ab50item = aa50id "+
                                                         "inner join ab601 on ab601id = ab50id "+
                                                         "where ab50ean = '"+ean+"'");
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				item ab50 = new item();
				
				ab50.setCodigo(rs.getString("ab50codigo"));
				ab50.setDescr(rs.getString("aa50descr"));
                                ab50.setValor(rs.getString("ab601preco"));
				dados.add(ab50);
			}
			
		} catch (Exception e) {
                    System.out.println("Status:" + e);                        
                    new Monitoramento().gerarLogErro((e).toString(),this.getClass().getName());
		} finally {
                    fecharConexaoCliente(conexao, pstmt, rs);
		}
		return dados;
        }
        
        
        public ArrayList<item> listarItemDescr(String descr) throws ParseException, IOException{
          Connection conexao = null;
          PreparedStatement pstmt = null;
          ResultSet rs = null;
          ArrayList<item> dados = null;


          conexao = criarConexaoCliente();
          dados = new ArrayList<item>();
          try {
                  pstmt = conexao.prepareStatement("select ab50codigo,aa50descr,ab601preco from ab50\n" +
                                                   "inner join aa50 on ab50item = aa50id "+
                                                   "inner join ab601 on ab601id = ab50id "+
                                                   "where UPPER(aa50descr) like UPPER('%"+descr+"%') order by aa50descr");
                  rs = pstmt.executeQuery();

                  while(rs.next()){
                          item ab50 = new item();

                          ab50.setCodigo(rs.getString("ab50codigo"));
                          ab50.setDescr(rs.getString("aa50descr"));
                          ab50.setValor(rs.getString("ab601preco"));
                          dados.add(ab50);
                  }

          } catch (Exception e) {
              System.out.println("Status:" + e);                        
              new Monitoramento().gerarLogErro((e).toString(),this.getClass().getName());
          } finally {
              fecharConexaoCliente(conexao, pstmt, rs);
          }
          return dados;
        }
        
}