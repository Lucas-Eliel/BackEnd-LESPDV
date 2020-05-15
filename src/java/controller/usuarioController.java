package controller;

import dao.usuarioDAO;
import java.io.IOException;
import java.text.ParseException;


public class usuarioController {
    
    public String validaUsuario(String user,String senha) throws ParseException, IOException, org.json.simple.parser.ParseException{
    System.out.println("Enviando para o GIT");
    return usuarioDAO.getInstance().validaUsuario(user, senha);
    }
    
}
