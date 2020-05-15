package vo;

import javax.xml.bind.annotation.XmlRootElement;
import org.json.simple.parser.ParseException;
import kernel.util.Config;



@XmlRootElement
public class unidade {
    
    private String codigoUn;
    private String descrUn;
    private String codigoEnt;
    private String descrEnt;

    
    public String getCodigoUn() {
            return codigoUn;
    }
    public void setCodigoUn(String codigoUn) {
            this.codigoUn = codigoUn;
    }
    public String getDescrUn() {
            return descrUn;
    }
    public void setDescrUn(String descrUn) {
            this.descrUn = descrUn;
    }
    public String getCodigoEnt() {
            return codigoEnt;
    }
    public void setCodigoEnt(String codigoEnt) {
            this.codigoEnt = codigoEnt;
    }
    public String getDescrEnt() {
            return descrEnt;
    }
    public void setDescrEnt(String descrEnt) {
            this.descrEnt = descrEnt;
    }

    
    @Override
    public String toString() {
            return "codigoUn=" + codigoUn + ", descrUn=" + descrUn + ", codigoEnt=" + codigoEnt + ", descrEnt=" + descrEnt;
    }
    
    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((codigoUn == null) ? 0 : codigoUn.hashCode());
            result = prime * result + ((descrUn == null) ? 0 : descrUn.hashCode());
            result = prime * result + ((codigoEnt == null) ? 0 : codigoEnt.hashCode());
            result = prime * result + ((descrEnt == null) ? 0 : descrEnt.hashCode());
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
        unidade other = (unidade) obj;
        if (codigoUn == null) {
                if (other.codigoUn != null)
                        return false;
        } else if (!codigoUn.equals(other.codigoUn))
                return false;
        if (descrUn == null) {
                if (other.descrUn != null)
                        return false;
        } else if (!descrUn.equals(other.descrUn))
                return false;
        if (codigoEnt == null) {
                if (other.codigoEnt != null)
                        return false;
        } else if (!codigoEnt.equals(other.codigoEnt))
                return false;
        if (descrEnt == null) {
                if (other.descrEnt != null)
                        return false;
        } else if (!descrEnt.equals(other.descrEnt))
                return false;
        return true;
    }
}
