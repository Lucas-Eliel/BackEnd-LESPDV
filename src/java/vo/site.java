package vo;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class site {
    
    private String idDbIntegrate;
    private String idProduto;
    private String nomeBase;
    private String ip;
    private String porta;
    private String usuario;
    private String senha;

    
    public String getIdDbIntegrate() {
            return idDbIntegrate;
    }
    public void setIdDbIntegrate(String idDbIntegrate) {
            this.idDbIntegrate = idDbIntegrate;
    }
    
    
    public String getIdProduto() {
            return idProduto;
    }
    public void setIdProduto(String idProduto) {
            this.idProduto = idProduto;
    }
    
    
    public String getNomeBase() {
            return nomeBase;
    }
    public void setNomeBase(String nomeBase) {
            this.nomeBase = nomeBase;
    }
    
    
    public String getIp() {
            return ip;
    }
    public void setIp(String ip) {
            this.ip = ip;
    }
    
    public String getPorta() {
            return porta;
    }
    public void setPorta(String porta) {
            this.porta = porta;
    }
    
    public String getUsuario() {
            return usuario;
    }
    public void setUsuario(String usuario) {
            this.usuario = usuario;
    }
    
    public String getSenha() {
            return senha;
    }
    public void setSenha(String senha) {
            this.senha = senha;
    }
    
    
    
    
    
    @Override
    public String toString() {
            return "idDbIntegrate=" + idDbIntegrate + ", idProduto=" + idProduto + ", nomeBase=" + nomeBase + ", ip=" + ip + ", porta=" + porta + ", usuario=" + usuario + ", senha=" + senha;
    }
    
    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((idDbIntegrate == null) ? 0 : idDbIntegrate.hashCode());
            result = prime * result + ((idProduto == null) ? 0 : idProduto.hashCode());
            result = prime * result + ((nomeBase == null) ? 0 : nomeBase.hashCode());
            result = prime * result + ((ip == null) ? 0 : ip.hashCode());
            result = prime * result + ((porta == null) ? 0 : porta.hashCode());
            result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
            result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
        site other = (site) obj;
        
        
        
        if (idDbIntegrate == null) {
                if (other.idDbIntegrate != null)
                        return false;
        } else if (!idDbIntegrate.equals(other.idDbIntegrate))
                return false;
        
        
        if (idProduto == null) {
                if (other.idProduto != null)
                        return false;
        } else if (!idProduto.equals(other.idProduto))
                return false;
        
        
        
        if (nomeBase == null) {
                if (other.nomeBase != null)
                        return false;
        } else if (!nomeBase.equals(other.nomeBase))
                return false;
        
        
        if (ip == null) {
                if (other.ip != null)
                        return false;
        } else if (!ip.equals(other.ip))
                return false;
                
                
        if (porta == null) {
                if (other.porta != null)
                        return false;
        } else if (!porta.equals(other.porta))
                return false;
                        
                        
        if (usuario == null) {
                if (other.usuario != null)
                        return false;
        } else if (!usuario.equals(other.usuario))
                return false;
                                
                                
        if (senha == null) {
                if (other.senha != null)
                        return false;
        } else if (!senha.equals(other.senha))
                return false;
        
        
        
        return true;
    }
}
