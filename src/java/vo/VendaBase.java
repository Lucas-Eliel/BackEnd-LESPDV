package vo;

import sam.types.Decimal;


public class VendaBase {
    

    private Long comanda;
    private String codEnt;
    private Long idEmpresa;
    private String codUN;
    private String codItem;
    private Long idCC;
    private String codNat;
    private Long idCadDiversos;
    private String codElemento;
    private String codTabPreco;
    private String codFormPgto;
    private String qtd;
    private String vlrUnit;
    private String usuario;
    private String desconto;

    
    
    
    public Long getComanda() {
        return comanda;
    }
    public void setComanda(Long comanda) {
        this.comanda = comanda;
    }
    public String getCodEnt() {
        return codEnt;
    }
    public void setCodEnt(String codEnt) {
        this.codEnt = codEnt;
    }
    public Long getIdEmpresa() {
        return idEmpresa;
    }
    public void setIdEmpresa(Long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }
    public String getCodUN() {
        return codUN;
    }
    public void setCodUN(String codUN) {
        this.codUN = codUN;
    }
    public String getCodItem() {
        return codItem;
    }
    public void setCodItem(String codItem) {
        this.codItem = codItem;
    }
    public Long getIdCC() {
        return idCC;
    }
    public void setIdCC(Long idCC) {
        this.idCC = idCC;
    }
    public String getCodNat() {
        return codNat;
    }
    public void setCodNat(String codNat) {
        this.codNat = codNat;
    }
    public Long getIdCadDiversos() {
        return idCadDiversos;
    }
    public void setIdCadDiversos(Long idCadDiversos) {
        this.idCadDiversos = idCadDiversos;
    }
    public String getCodElemento() {
        return codElemento;
    }
    public void setCodElemento(String codElemento) {
        this.codElemento = codElemento;
    }
    public String getCodTabPreco() {
        return codTabPreco;
    }
    public void setCodTabPreco(String codTabPreco) {
        this.codTabPreco = codTabPreco;
    }
    public String getCodFormPgto() {
        return codFormPgto;
    }
    public void setCodFormPgto(String codFormPgto) {
        this.codFormPgto = codFormPgto;
    }        
    public String getQtd() {
        return qtd;
    }
    public void setQtd(String qtd) {
        this.qtd = qtd;
    }        
    public String getVlrUnit() {
        return vlrUnit;
    }
    public void setVlrUnit(String vlrUnit) {
        this.vlrUnit = vlrUnit;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getDesconto(){
        return desconto;
    }
    public void setDesconto(String desconto) {
        this.desconto = desconto;
    }
}
