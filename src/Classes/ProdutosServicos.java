package Classes;

public abstract class ProdutosServicos {
    
    String nome;
    Double valor;
    Integer garantia;

    public ProdutosServicos (String nome, Double valor, Integer garantia){
        this.nome = nome;
        this.valor = valor;
        this.garantia = garantia;
    }

    public String getNome (){
        return nome;
    }

    public void setNome (String nome){
        this.nome = nome;
    }

    public Double getValor (){
        return valor;
    }

    public void setValor (Double valor){
        this.valor = valor;
    }

    public Integer getGarantia (){
        return garantia;
    }

    public void setGarantia (Integer garantia){
        this.garantia = garantia;
    }
}
