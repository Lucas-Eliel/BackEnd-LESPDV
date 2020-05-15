package vo;

import javax.xml.bind.annotation.XmlRootElement;
import org.json.simple.parser.ParseException;



@XmlRootElement
public class item {
    
    private String codigo;
    private String descr;
    private String valor;

    
    public String getCodigo() {
            return codigo;
    }
    public void setCodigo(String codigo) {
            this.codigo = codigo;
    }
    public String getDescr() {
            return descr;
    }
    public void setDescr(String descr) {
            this.descr = descr;
    }
    public String getValor() {
            return valor;
    }
    public void setValor(String valor) throws ParseException {
            this.valor = valor;
    }
    
    @Override
    public String toString() {
            return "codigo=" + codigo + ", descr=" + descr + ", valor=" + valor;
    }
    
    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
            result = prime * result + ((descr == null) ? 0 : descr.hashCode());
            result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
        item other = (item) obj;
        if (codigo == null) {
                if (other.codigo != null)
                        return false;
        } else if (!codigo.equals(other.codigo))
                return false;
        if (descr == null) {
                if (other.descr != null)
                        return false;
        } else if (!descr.equals(other.descr))
                return false;
        if (valor == null) {
                if (other.valor != null)
                        return false;
        } else if (!valor.equals(other.valor))
                return false;
        return true;
    }
}
