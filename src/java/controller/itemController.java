package controller;

import dao.entidadeDAO;
import dao.itemDAO;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.parser.ParseException;
import vo.item;



public class itemController {
    
    public ArrayList<item> listarItemEan(String ean) throws ParseException, IOException{
        System.out.println("Enviando para o GIT");
        return itemDAO.getInstance().listarItemEan(ean);
    }
    
    public ArrayList<item> listarItemDescr(String descr) throws ParseException, IOException{
        System.out.println("Enviando para o GIT");
        return itemDAO.getInstance().listarItemDescr(descr);
    }
}
