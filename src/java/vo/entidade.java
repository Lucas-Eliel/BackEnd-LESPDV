package vo;

import javax.xml.bind.annotation.XmlRootElement;
import org.json.simple.parser.ParseException;
import kernel.util.Config;



@XmlRootElement
public class entidade {
    
    private String codigo;
    private String nome;
    private String vlrDesconto;
    private String token;

    
    public String getCodigo() {
            return codigo;
    }
    public void setCodigo(String codigo) {
            this.codigo = codigo;
    }
    
    public String getNome() {
            return nome;
    }
    public void setNome(String nome) {
            this.nome = nome;
    }
    
    public String getVlrDesconto() {
            return vlrDesconto;
    }
    public void setVlrDesconto(String vlrDesconto) throws ParseException {
            this.vlrDesconto = vlrDesconto;    
    }
    
    public String getToken() {
            return token;
    }
    public void setToken(String token) throws ParseException {
            this.token = token;
    }
    
    @Override
    public String toString() {
            return "codigo=" + codigo + ", nome=" + nome + ",desconto=" + vlrDesconto + ", token=" + token;
    }
    
    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
            result = prime * result + ((nome == null) ? 0 : nome.hashCode());
            result = prime * result + ((vlrDesconto == null) ? 0 : vlrDesconto.hashCode());
            result = prime * result + ((token == null) ? 0 : token.hashCode());
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
        entidade other = (entidade) obj;
        if (codigo == null) {
                if (other.codigo != null)
                        return false;
        } else if (!codigo.equals(other.codigo))
                return false;
        
        if (nome == null) {
                if (other.nome != null)
                        return false;
        } else if (!nome.equals(other.nome))
                return false;
        
        if (vlrDesconto == null) {
                if (other.vlrDesconto != null)
                        return false;
        } else if (!vlrDesconto.equals(other.vlrDesconto))
                return false;
        
        if (token == null) {
                if (other.token != null)
                        return false;
        } else if (!token.equals(other.token))
                return false;
        
        
        return true;
    }
}
