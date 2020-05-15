package controller;

import dao.entidadeDAO;
import dao.lancamentosDAO;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.parser.ParseException;
import vo.entidade;
import vo.lancamento;


public class lancamentosController {
    
    public ArrayList<lancamento> listarLancamentos(String comanda) throws ParseException, IOException{
        System.out.println("Enviando para o GIT");
        return lancamentosDAO.getInstance().listarLancamentos(comanda);
    }
    
    public ArrayList<lancamento> listarTotalLancamentos(String comanda) throws ParseException, IOException{
        System.out.println("Enviando para o GIT");
        return lancamentosDAO.getInstance().listarTotalLancamentos(comanda);
    }
    
    public ArrayList<lancamento> listarNumLancamentos() throws ParseException, IOException{
        System.out.println("Enviando para o GIT");
        return lancamentosDAO.getInstance().listarNumLancamentos();
    }
    
}
