package kernel.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import kernel.sistema.Monitoramento;


public class Config { 
    
    public String serial;
    public String ip;
    public String porta;        
    public String nomeBase;
    public String usuario;
    public String senha;
    public String path = "C://Users//LucasEliel//Documents//NetBeansProjects//LES//LESPDV//Config.txt";

    public void verificaDados() throws IOException, ParseException{
    
        JSONObject jsonObject;
        JSONParser parser = new JSONParser();        
 
        try {
            
            new Arquivos().criarTxtConfig(path);
            jsonObject = (JSONObject) parser.parse(new FileReader(path));
            
            serial = (String) jsonObject.get("serial");
            ip = (String) jsonObject.get("ip");
            porta = (String) jsonObject.get("porta");
            nomeBase = (String) jsonObject.get("nomeBase");
            usuario = (String) jsonObject.get("usuario");
            senha = (String) jsonObject.get("senha");
            
        }catch (FileNotFoundException e) {
            new Monitoramento().gerarLogErro((e).toString(),this.getClass().getName());
        }       
    }     
    

    public String getSerial() throws ParseException, IOException{
        verificaDados();
        return serial;        
    }
    public String getIP() throws ParseException, IOException{
        verificaDados();
        return ip;        
    }
    public String getPorta() throws ParseException, IOException{
        verificaDados(); 
        return porta;        
    }
    public String getNomeBase() throws ParseException, IOException{
        verificaDados();
        return nomeBase;        
    }
    public String getUsuario() throws ParseException, IOException{
        verificaDados(); 
        return usuario;        
    }
    public String getSenha() throws ParseException, IOException{
        verificaDados();         
        return senha;        
    }
    
}