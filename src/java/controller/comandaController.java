package controller;

import dao.comandaDAO;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.parser.ParseException;
import vo.comanda;



public class comandaController {
    
    public ArrayList<comanda> ultimoNumeroComanda() throws ParseException, IOException{
        System.out.println("Enviando para o GIT");
        return comandaDAO.getInstance().ultimoNumeroComanda();
    }
    
    public ArrayList<comanda> listarDadosComanda(String comanda) throws ParseException, IOException{
        System.out.println("Enviando para o GIT");
        return comandaDAO.getInstance().listarDadosComanda(comanda);
    }
    
}
