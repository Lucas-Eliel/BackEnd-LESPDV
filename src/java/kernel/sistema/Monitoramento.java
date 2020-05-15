package kernel.sistema;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import kernel.util.Arquivos;


public class Monitoramento {
    
    public String conteudoLido = "";
    public String conteudoEscrito = "";
    public String path = "//opt//apache-tomcat-8.5.32//webapps//LESPDV//WEB-INF//Log.txt";
    
    
    public void gerarLogErro(String erro,String local) throws IOException{

        new Arquivos().criarTxt(path);
        SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String timeLog = dtf.format(new Date(System.currentTimeMillis()));        
        String msgLog = timeLog + " *** " + erro + " [LOCAL] "+ local;
        
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        
        while (true) {
            
                conteudoLido = buffRead.readLine();
                        
            if (conteudoLido == null) {
                BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path,true));
                conteudoEscrito = msgLog;
                buffWrite.newLine();
                buffWrite.append(conteudoEscrito);
                buffWrite.close();
                break;
            }
        }    
    }
    
    
    
    public void gerarLogTransacao(String status,String Local){
    
    
    }
    
}
