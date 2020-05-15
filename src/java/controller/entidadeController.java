package controller;

import java.util.ArrayList;
import dao.entidadeDAO;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import vo.entidade;



public class entidadeController {
    
    public ArrayList<entidade> listarEntidades(String descrEntidade) throws ParseException, IOException{
        System.out.println("Enviando para o GIT");
        return entidadeDAO.getInstance().listarEntidades(descrEntidade);
    }
    
}
