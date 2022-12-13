package Classes;

import java.util.ArrayList;

public class Servico extends ProdutosServicos{

    ArrayList<Servico> servicos = new ArrayList<>();

    public Servico (String nome, Double valor, Integer garantia){
        super(nome, valor, garantia);
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

    public String mostrarServicos (String nome, String valor, String garantia){
        String mostraProdutos="";
        int i=1;

        for (Servico servico : servicos) {
            if (servico.nome.contains(nome)){
                if (servico.valor.toString().contains(valor) || valor.equals("-1")){
                    if (servico.garantia.toString().equals(garantia) || garantia.equals("-1")){
                        mostraProdutos += "Servico "+i+":\n  Nome: "+servico.nome+"\n  Valor: R$ "+String.format("%.2f", servico.valor)+"\n  Garantia: "+servico.garantia+" meses\n\n"; 
                    }
                }
            }
            i++;
        }

        return mostraProdutos;
    }

    public void inicializaServicos() {
        String []nome = new String[] {"Limpeza geral de computador", "Troca de componente", "Reparo na placa mae"};
        Double []valor = new Double[] {30.50, 50.99, 75.00};
        Integer []garantia = new Integer[] {3, 3, 6};
        
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
