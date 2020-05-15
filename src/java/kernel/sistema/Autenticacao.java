package kernel.sistema;


import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import org.json.simple.parser.ParseException;
import kernel.util.Config;
import kernel.util.Criptografia;


public class Autenticacao {
    
    
    Config config = new Config();
    Monitoramento monitoramento = new Monitoramento();
    Criptografia criptografia = new Criptografia();
        
    private String serial;
    private Boolean statusSerial;
    private String token;
    private Boolean statusToken;
    
    
    public Boolean validarSerial(String serial) throws IOException {
        
        try{
            this.serial = config.getSerial();
            
            if(serial == this.serial){
                this.statusSerial = true;
            }else{
                this.statusToken = false;
            }
            
        }catch(Exception e){
            System.out.println("Status:" + e);
            monitoramento.gerarLogErro((e).toString(),this.getClass().getName());
        }          
        return this.statusSerial;
    }
        
    
    
    public Boolean validarToken(String token) throws IOException{
    
        try{
        
            String tokenDescriptado = criptografia.descriptografaToken(token);
            if(tokenDescriptado.contains("LES")){
                this.statusToken = true;
            }else{
                this.statusToken = false;
            }
        
        }catch(Exception e){
            System.out.println("Status:" + e);
            monitoramento.gerarLogErro((e).toString(),this.getClass().getName());
        }
        
        return this.statusToken;
    }
    
}
