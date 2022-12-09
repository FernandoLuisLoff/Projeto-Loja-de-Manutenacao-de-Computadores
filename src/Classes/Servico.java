package Classes;

import java.util.ArrayList;

public class Servico {

    String nome;
    Double valor;
    Integer garantia;

    ArrayList<Servico> servicos = new ArrayList<>();

    public Servico (String nome, Double valor, Integer garantia){
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

    public Integer getSizeArreyServicos(){
        return servicos.size();
    }

    public void addServico (Servico servico){
        servicos.add(servico);
    }

    public void removeServico (Integer index){
        servicos.remove(index.intValue());
    }

    public String readServicos (){
        String mostraProdutos="";
        int i=1;

        for (Servico servico : servicos) {
            mostraProdutos += "Servico "+i+":\n  Nome: "+servico.nome+"\n  Valor: R$ "+String.format("%.2f", servico.valor)+"\n  Garantia: "+servico.garantia+" meses\n\n"; 
            i++; 
        }

        return mostraProdutos;
    }

    public void inicializaServicos() {
        String []nome = new String[] {"Limpeza geral de computador", "Troca de componente", "Reparo na placa mae"};
        Double []valor = new Double[] {30.50,50.99,75.00};
        Integer []garantia = new Integer[] {3,3,6};
        
        for (int i=0; i<nome.length; i++){
            addServico(new Servico(nome[i], valor[i], garantia[i]));
        }
    }

    public String []arreyServicos (){
        String []serv = new String[servicos.size()];
        int i=0;

        for (Servico servico : servicos){
            serv[i] = servico.nome;
            i++;
        }

        return serv;
    }

    public Double retornaValor (Integer index){
        return servicos.get(index).getValor();
    }

    public Integer retornaGarantia (Integer index){
        return servicos.get(index).getGarantia();
    }
}
