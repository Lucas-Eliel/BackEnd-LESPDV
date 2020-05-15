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
import vo.site;
import vo.unidade;

public class siteDAO extends ConectionDB {
        
        public String token;
        Config conf = new Config();
    
	private static siteDAO instance;
	
	public static siteDAO getInstance(){
		if(instance == null)
			instance = new siteDAO();
		return instance;
	}
                        

        public site listaIntegrate() throws ParseException, IOException{
		Connection conexao = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		site bb_bdintegrate = new site();
		
		conexao = criarConexaoSite();

		try {
			pstmt = conexao.prepareStatement("select * from bb_bdintegrate");
			rs = pstmt.executeQuery();
			
			while(rs.next()){

				bb_bdintegrate.setIdDbIntegrate(rs.getString("idbdintegrate"));
                                bb_bdintegrate.setIdProduto(rs.getString("idprodutofk"));
                                bb_bdintegrate.setNomeBase(rs.getString("nomebase"));
                                bb_bdintegrate.setIp(rs.getString("ip"));
                                bb_bdintegrate.setPorta(rs.getString("porta"));
                                bb_bdintegrate.setUsuario(rs.getString("usuario"));
                                bb_bdintegrate.setSenha(rs.getString("senha"));
			}
			
		} catch (Exception e) {
                        System.out.println("Status:" + e);                        
			new Monitoramento().gerarLogErro((e).toString(),this.getClass().getName());
		} finally {
			fecharConexaoSite(conexao, pstmt, rs);
		}
		return bb_bdintegrate;
        }
        
}
