package kernel.util;


import bo.VendaBO;
import java.io.File;
import java.io.IOException;
import orm.ConectionDB;
import sam.vo.scn.Db10;
import kernel.sistema.Monitoramento;
import orm.ConectionSAM;



public class teste {

        
   
    public static void main(String[] args) throws IOException, Exception {
      // new ConectionDB().criarTransacaoSAM();
        new ConectionSAM().criarTransacaoSAM("MIGUEL");


    }
    
}
