package Classes;

import java.util.ArrayList;

public class Produto extends ProdutosServicos{

    ArrayList<Produto> produtos = new ArrayList<>();

    public Produto (String nome, Double valor, Integer garantia){
        super(nome, valor, garantia);
    }

    public Integer getSizeArreyProdutos (){
        return produtos.size();
    }

    public void addProduto (Produto produto){
        produtos.add(produto);
    }

    public void removeProduto (Integer index){
        produtos.remove(index.intValue());
    }

    public String mostrarProdutos (String nome, String valor, String garantia){
        String mostraProdutos="";
        int i=1;

        for (Produto produto : produtos){
            if (produto.nome.contains(nome)){
                if (produto.valor.toString().contains(valor) || valor.equals("-1")){
                    if (produto.garantia.toString().equals(garantia) || garantia.equals("-1")){
                        mostraProdutos += "Produto "+i+":\n  Nome: "+produto.nome+"\n  Valor: R$ "+String.format("%.2f", produto.valor)+"\n  Garantia: "+produto.garantia+" meses\n\n"; 
                    }
                }
            }
            i++;
        }

        return mostraProdutos;
    }

    public void inicializaProdutos() {
        String []nome = new String[] {"Processador", "Memoria 8gb", "Placa de video"};
        Double []valor = new Double[] {500.99,299.99,875.99};
        Integer []garantia = new Integer[] {12,3,6};
        
        for (int i=0; i<nome.length; i++){
            addProduto(new Produto(nome[i], valor[i], garantia[i]));
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
