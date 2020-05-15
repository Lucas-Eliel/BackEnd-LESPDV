package vo;


import javax.xml.bind.annotation.XmlRootElement;
import org.json.simple.parser.ParseException;
import kernel.util.Config;



@XmlRootElement
public class comanda {
    
    private String numero;
    private String codEntidade;
    private String descrEntidade;
    private String codUnidade;
    private String descrUnidade;
    private String desconto;
    
    public String getNumero() {
            return numero;
    }
    public void setNumero(String numero) {
            this.numero = numero;
    }
    
    public String getCodEntidade() {
            return codEntidade;
    }
    public void setCodEntidade(String codEntidade) {
            this.codEntidade = codEntidade;
    }
    
    public String getDescrEntidade() {
            return descrEntidade;
    }
    public void setDescrEntidade(String descrEntidade) {
            this.descrEntidade = descrEntidade;
    }
    
    public String getCodUnidade() {
            return codUnidade;
    }
    public void setCodUnidade(String codUnidade) {
            this.codUnidade = codUnidade;
    }
    
    public String getDescrUnidade() {
            return descrUnidade;
    }
    public void setDescrUnidade(String descrUnidade) {
            this.descrUnidade = descrUnidade;
    }
    
    public String getDesconto() {
            return desconto;
    }
    public void setDesconto(String desconto) {
            this.desconto = desconto;
    }
    
    
    @Override
    public String toString() {
            return "numero=" + numero + "codEntidade=" + codEntidade + "descrEntidade=" + descrEntidade + "codUnidade=" + codUnidade + "descrUnidade=" + descrUnidade ;
    }
    
    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((numero == null) ? 0 : numero.hashCode());
            result = prime * result + ((codEntidade == null) ? 0 : codEntidade.hashCode());
            result = prime * result + ((descrEntidade == null) ? 0 : descrEntidade.hashCode());
            result = prime * result + ((codUnidade == null) ? 0 : codUnidade.hashCode());
            result = prime * result + ((descrUnidade == null) ? 0 : descrUnidade.hashCode());
            result = prime * result + ((desconto == null) ? 0 : desconto.hashCode());

            return result;
    }
    
    
    @Override
    public boolean equals(Object obj) {
        
        if (this == obj)
                return true;
        if (obj == null)
                return false;
        if (getClass() != obj.getClass())
                return false;
        comanda other = (comanda) obj;
        if (numero == null) {
                if (other.numero != null)
                        return false;
        } else if (!numero.equals(other.numero))
                return false;
        
        
        if (codEntidade == null) {
                if (other.codEntidade != null)
                        return false;
        } else if (!codEntidade.equals(other.codEntidade))
                return false;
                
                
        if (descrEntidade == null) {
                if (other.descrEntidade != null)
                        return false;
        } else if (!descrEntidade.equals(other.descrEntidade))
                return false;
                        
                        
        if (codUnidade == null) {
                if (other.codUnidade != null)
                        return false;
        } else if (!codUnidade.equals(other.codUnidade))
                return false;
                                
                                
        if (descrUnidade == null) {
                if (other.descrUnidade != null)
                        return false;
        } else if (!descrUnidade.equals(other.descrUnidade))
                return false;
        
        if (desconto == null) {
                if (other.desconto != null)
                        return false;
        } else if (!desconto.equals(other.desconto))
                return false;
        return true;
    }
    
}
