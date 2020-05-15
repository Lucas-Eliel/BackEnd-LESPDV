package kernel.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Arquivos {
    
    
    public void criarTxt(String path) throws IOException{
        
        File file = new File(path);
        
        if (!file.exists()) {
            file.createNewFile();
        }    
    }
    
    public void criarTxtConfig(String path) throws IOException{
        
        File file = new File(path);
        
        if (!file.exists()) {
            file.createNewFile();
            BufferedWriter buffWrite = new BufferedWriter(new FileWriter(path));
            buffWrite.append("{\"serial\":\"\",\"ip\":\"\",\"porta\":\"\",\"nomeBase\":\"\",\"usuario\":\"\",\"senha\":\"\"}");
            buffWrite.close();
        }        
    }    
}
