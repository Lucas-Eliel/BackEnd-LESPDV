package dao;

import java.io.IOException;
import orm.ConectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import kernel.sistema.Monitoramento;
import org.json.simple.parser.ParseException;
import kernel.util.Criptografia;
import vo.usuario;


public class usuarioDAO extends ConectionDB{
    
private static usuarioDAO instance;
public String usuarioStatus; 
public int sizeRs; 
public String user; 
public String senha;

Criptografia criptografia = new Criptografia();

    public static usuarioDAO getInstance(){
            if(instance == null)
                    instance = new usuarioDAO();
            return instance;
    }

    public String validaUsuario(String user,String senha) throws ParseException, IOException{
        
            Connection conexao = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            conexao = criarConexaoCliente();
            this.user = user;            
            this.senha = criptografia.criptografaSenhaSAM((user.toUpperCase() + senha).toCharArray());
            
            try {
                    
                    pstmt = conexao.prepareStatement("select * from aa30 where aa30user = '"+this.user+"' and aa30senha = '"+this.senha+"' ");                    
                    rs = pstmt.executeQuery();                  
                    sizeRs =0;
                    
                    while(rs.next() == true){                    
                        sizeRs = sizeRs + 1;
                    }

                    if(sizeRs > 0){                    
                        usuarioStatus = "{"+'"'+"login"+'"'+":[{"+'"'+"status"+'"'+":"+'"'+"true"+'"'+"}]}";                        
                    }else{                        
                        usuarioStatus = "{"+'"'+"login"+'"'+":[{"+'"'+"status"+'"'+":"+'"'+"false"+'"'+"}]}";                    
                    }
                    

            } catch (Exception e) {
                    System.out.println("Erro ao validar o usuário: " + e);
                    e.printStackTrace();
            } finally {
                    fecharConexaoCliente(conexao, pstmt, rs);
            }
            return usuarioStatus;
    }
    
    
        public ArrayList<usuario> listarIdUsuario(String usuario) throws ParseException, IOException{
            Connection conexao = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            ArrayList<usuario> dados = null;


            conexao = criarConexaoCliente();
            dados = new ArrayList<usuario>();
            try {
                    pstmt = conexao.prepareStatement("Select * from aa30 where aa30user = '"+usuario+"' ");
                    rs = pstmt.executeQuery();

                    while(rs.next()){
                            usuario aa30 = new usuario();

                            aa30.setIdUsuario(rs.getLong("aa30id"));
                            dados.add(aa30);
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
    

	