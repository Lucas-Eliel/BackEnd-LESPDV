package vo;

import javax.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class lancamento {
    
    private String numLancamento;
    private String comanda;
    private String codigo;
    private String descr;
    private String qt;
    private String unit;
    private String total;
    private String subTotal;
    private String desconto;

    
    public String getNumLancamento() {
            return numLancamento;
    }
    public void setNumLancamento(String numLancamento) {
            this.numLancamento = numLancamento;
    }
    public String getComanda() {
            return comanda;
    }
    public void setComanda(String comanda) {
            this.comanda = comanda;
    }
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
    public String getQt() {
            return qt;
    }
    public void setQt(String qt){
            this.qt = qt;
    }
    public String getUnit() {
            return unit;
    }
    public void setUnit(String unit) {
            this.unit = unit;
    }
    public String getDesconto() {
            return desconto;
    }
    public void setDesconto(String desconto) {
            this.desconto = desconto;
    }
    public String getSubTotal() {
            return subTotal;
    }
    public void setSubTotal(String subTotal) {
            this.subTotal = subTotal;
    }
    public String getTotal() {
            return total;
    }
    public void setTotal(String total) {
            this.total = total;
    }
    
    
    
    @Override
    public String toString() {
            return "numLancamento=" + numLancamento + ", comanda=" + comanda + ", codigo=" + codigo + ", descr=" + descr + "qt=" + qt + ", unit=" + unit + ", desconto=" + desconto + ", total=" + total;
    }
    
    @Override
    public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((numLancamento == null) ? 0 : numLancamento.hashCode());
            result = prime * result + ((comanda == null) ? 0 : comanda.hashCode());
            result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
            result = prime * result + ((descr == null) ? 0 : descr.hashCode());
            result = prime * result + ((qt == null) ? 0 : qt.hashCode());
            result = prime * result + ((desconto == null) ? 0 : desconto.hashCode());
            result = prime * result + ((unit == null) ? 0 : unit.hashCode());
            result = prime * result + ((subTotal == null) ? 0 : subTotal.hashCode());
            result = prime * result + ((total == null) ? 0 : total.hashCode());
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
        lancamento other = (lancamento) obj;
        if (numLancamento == null) {
                if (other.numLancamento != null)
                        return false;
        } else if (!numLancamento.equals(other.numLancamento))
                return false;
        if (comanda == null) {
                if (other.comanda != null)
                        return false;
        } else if (!comanda.equals(other.comanda))
                return false;
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
        if (qt == null) {
                if (other.qt != null)
                        return false;
        } else if (!qt.equals(other.qt))
                return false;
        if (desconto == null) {
                if (other.desconto != null)
                        return false;
        } else if (!desconto.equals(other.desconto))
                return false;
        if (unit == null) {
                if (other.unit != null)
                        return false;
        } else if (!unit.equals(other.unit))
                return false;
        if (subTotal == null) {
                if (other.subTotal != null)
                        return false;
        } else if (!subTotal.equals(other.subTotal))
                return false;
        if (total == null) {
                if (other.total != null)
                        return false;
        } else if (!total.equals(other.total))
                return false;
        return true;
    }
}
