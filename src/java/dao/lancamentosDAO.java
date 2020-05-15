package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.json.simple.parser.ParseException;
import orm.ConectionDB;
import kernel.sistema.Monitoramento;
import kernel.util.Config;
import vo.lancamento;


public class lancamentosDAO extends ConectionDB {
        
        public String token;
        Config conf = new Config();
    
	private static lancamentosDAO instance;
	
	public static lancamentosDAO getInstance(){
		if(instance == null)
			instance = new lancamentosDAO();
		return instance;
	}
                        

        public ArrayList<lancamento> listarLancamentos(String comanda) throws ParseException, IOException{
            Connection conexao = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            ArrayList<lancamento> dados = null;


            conexao = criarConexaoCliente();
            dados = new ArrayList<lancamento>();
            try {
                    pstmt = conexao.prepareStatement("select db10lct,db10identvda,ab50codigo,aa50descr,db10desc,db10total,db10qt,db10unit,(db10total - db10desc) as total from db10 "+
                                                     "inner join ab50 on db10item = ab50id "+
                                                     "inner join aa50 on ab50item = aa50id "+
                                                     "where db10identvda = "+comanda+"");
                    rs = pstmt.executeQuery();

                    while(rs.next()){
                            lancamento db10 = new lancamento();
                            
                            db10.setNumLancamento(rs.getString("db10lct"));
                            db10.setComanda(rs.getString("db10identvda"));
                            db10.setCodigo(rs.getString("ab50codigo"));
                            db10.setDescr(rs.getString("aa50descr"));
                            db10.setQt(rs.getString("db10qt"));
                            db10.setUnit(rs.getString("db10unit"));
                            db10.setDesconto (rs.getString("db10desc"));
                            db10.setSubTotal(rs.getString("db10total"));
                            db10.setTotal(rs.getString("total"));
                            dados.add(db10);
                    }

            } catch (Exception e) {
                System.out.println("Status:" + e);                        
                new Monitoramento().gerarLogErro((e).toString(),this.getClass().getName());
            } finally {
                fecharConexaoCliente(conexao, pstmt, rs);
            }
            return dados;
        }                                

        


        public ArrayList<lancamento> listarNumLancamentos() throws ParseException, IOException{
            Connection conexao = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            ArrayList<lancamento> dados = null;


            conexao = criarConexaoCliente();
            dados = new ArrayList<lancamento>();
            try {
                    pstmt = conexao.prepareStatement("select distinct db10identvda from db10 "+
                                                     "inner join ab50 on db10item = ab50id "+
                                                     "inner join aa50 on ab50item = aa50id ");
                                                     
                    rs = pstmt.executeQuery();

                    while(rs.next() == true){
                            lancamento db10 = new lancamento();

                            db10.setComanda(rs.getString("db10identvda"));
                            dados.add(db10);
                    }

            } catch (Exception e) {
                System.out.println("Status:" + e);                        
                new Monitoramento().gerarLogErro((e).toString(),this.getClass().getName());
            } finally {
                fecharConexaoCliente(conexao, pstmt, rs);
            }
            return dados;
        }
        
        
        
        public ArrayList<lancamento> listarTotalLancamentos(String comanda) throws ParseException, IOException{
            Connection conexao = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            ArrayList<lancamento> dados = null;


            conexao = criarConexaoCliente();
            dados = new ArrayList<lancamento>();
            try {
                    pstmt = conexao.prepareStatement("select sum(db10total) - sum(db10desc) as db10total from db10 "+
                                                     "inner join ab50 on db10item = ab50id "+
                                                     "inner join aa50 on ab50item = aa50id "+
                                                     "where db10identvda = "+comanda+"");
                    rs = pstmt.executeQuery();

                    while(rs.next()){
                            lancamento db10 = new lancamento();

                            db10.setTotal(rs.getString("db10total"));
                            dados.add(db10);
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