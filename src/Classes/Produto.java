package Classes;

import java.util.ArrayList;

public class Produto {
    Integer qtdprodutos=0;

    String nome;
    Double valor;
    Integer garantia;

    ArrayList<Produto> produtos = new ArrayList<>();

    public Produto (String nome, Double valor, Integer garantia){
        this.nome = nome;
        this.valor = valor;
        this.garantia= garantia;
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

    public Integer getQtdprodutos (){
        return qtdprodutos;
    }

    public void setQtdprodutos (Integer qtdprodutos){
        this.qtdprodutos = qtdprodutos;
    }

    public void addProduto (Produto produto){
        produtos.add(produto);
    }

    public String readProdutos (){
        String mostraProdutos="";
        int i=1;

        for (Produto produto : produtos) {
            mostraProdutos += "Produto "+i+":\n  Nome: "+produto.nome+"\n  Valor: R$ "+String.format("%.2f", produto.valor)+"\n  Garantia: "+produto.garantia+" meses\n\n"; 
            i++; 
        }

        return mostraProdutos;
    }

    public void inicializaProdutos() {
        String []nome = new String[] {"Processador", "Memoria 8gb", "Placa de video"};
        Double []valor = new Double[] {500.99,299.99,875.99};
        Integer []garantia = new Integer[] {12,3,6};
        
        for (int i=0; i<3; i++){
            addProduto(new Produto(nome[i], valor[i], garantia[i]));
            setQtdprodutos(getQtdprodutos()+1);
        }
    }

    public String []arreyProdutos (){
        String []produt = new String[produtos.size()];
        int i=0;

        for (Produto produto : produtos){
            produt[i] = produto.nome;
            i++;
        }

        return produt;
    }

    public Double retornaValorUnit (Integer index){
        return produtos.get(index).getValor();
    }

    public Integer retornaGarantia (Integer index){
        return produtos.get(index).getGarantia();
    }
}
