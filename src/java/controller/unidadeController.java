package controller;

import java.util.ArrayList;
import dao.entidadeDAO;
import dao.unidadeDAO;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import vo.entidade;
import vo.unidade;



public class unidadeController {
    
    public ArrayList<unidade> listarUnidades(String descrUnidade) throws ParseException, IOException{
        System.out.println("Enviando para o GIT");
        return unidadeDAO.getInstance().listarUnidades(descrUnidade);
    }
    
}
