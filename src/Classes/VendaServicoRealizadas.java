package Classes;

public abstract class VendaServicoRealizadas {
    String identificacao;
    String dataVendaServico;

    String cliente;
    String documento;
    String tipoCliente;

    String produtoServico;
    Double valorTot;

    String formaPgto;
    String parcelasPgto;

    String obs;
    Integer garantia;

    public VendaServicoRealizadas (String identificacao, String dataVendaServico, String cliente, String documento, String tipoCliente, String produtoServico, Double valorTot, String obs, Integer garantia, String formaPgto, String parcelasPgto){
        this.identificacao = identificacao;
        this.dataVendaServico = dataVendaServico;
        this.cliente = cliente;
        this.documento = documento;
        this.tipoCliente = tipoCliente;
        this.produtoServico = produtoServico;
        this.valorTot = valorTot;
        this.obs = obs;
        this.garantia = garantia;
        this.formaPgto = formaPgto;
        this.parcelasPgto = parcelasPgto;
    }

    // Data venda
    public String getIdentificacao (){
        return identificacao;
    }

    public void setIdentificacao (String identificacao){
        this.identificacao = identificacao;
    }

    // Data venda
    public String getDataVendaServico (){
        return dataVendaServico;
    }

    public void setDataVendaServico (String dataVendaServico){
        this.dataVendaServico = dataVendaServico;
    }

    // Cliente
    public String getCliente (){
        return cliente;
    }

    public void setCliente (String cliente){
        this.cliente = cliente;
    }

    // Documento
    public String getDocumento (){
        return documento;
    }

    public void setDocumento (String documento){
        this.documento = documento;
    }

    // Tipo cliente
    public String getTipoCliente (){
        return tipoCliente;
    }

    public void setTipoCliente (String tipoCliente){
        this.tipoCliente = tipoCliente;
    }

    // Produto
    public String getProdutoServico (){
        return produtoServico;
    }

    public void setProdutoServico (String produtoServico){
        this.produtoServico = produtoServico;
    }

    // Valor Total
    public Double getValorTot (){
        return valorTot;
    }

    public void setValorTot (Double valorTot){
        this.valorTot = valorTot;
    }

    // Observacao
    public String getObs (){
        return obs;
    }

    public void setObs (String obs){
        this.obs = obs;
    }

    // Garantia
    public Integer getGarantia (){
        return garantia;
    }

    public void setGarantia (Integer garantia){
        this.garantia = garantia;
    }

    // Forma pagamento
    public String getFormaPgto (){
        return formaPgto;
    }

    public void setFormaPgto (String formaPgto){
        this.formaPgto = formaPgto;
    }

    // Parcelas pagamento
    public String getParcelasPgto (){
        return parcelasPgto;
    }

    public void setParcelasPgto (String parcelasPgto){
        this.parcelasPgto = parcelasPgto;
    }
    
}
