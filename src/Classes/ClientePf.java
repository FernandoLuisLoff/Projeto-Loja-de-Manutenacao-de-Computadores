package Classes;

import java.util.ArrayList;

public class ClientePf extends Cliente {
    Integer qtdClientesPf=0;

    String cpf;

    ArrayList<ClientePf> clientes = new ArrayList<>();

    public ClientePf (String nome, String cpf){
        super(nome);
        this.cpf = cpf;
    }

    public Integer getQtdClientesPf (){
        return qtdClientesPf;
    }

    public void setQtdClientesPf(Integer qtdClientesPf){
        this.qtdClientesPf = qtdClientesPf;
    }

    public String getCpf (){
        return cpf;
    }

    public void setCpf (String cpf){
        this.cpf = cpf;
    }

    public void addClientePf (ClientePf clientePf){
        clientes.add(clientePf);
    }

    public String readClientes (){
        String mostraClientes="";
        int i=1;

        for (ClientePf cliente : clientes){
            mostraClientes += "Cliente "+i+":\n  Nome: "+cliente.nome+"\n  Cpf: "+cliente.cpf+"\n\n"; 
            i++; 
        }

        return mostraClientes;
    }

    public void inicializaClientesPF (){
        String []nome = new String[] {"Fernando", "Luis", "Felipe"};
        String []cpf = new String[] {"123789456", "234567894", "512689435"};

        for (int i=0; i<3; i++){
            addClientePf(new ClientePf(nome[i], cpf[i]));
            setQtdClientesPf(getQtdClientesPf()+1);
        }
    }

    public String []arreyNomesPf (){
        String []nomes = new String[clientes.size()];
        int i=0;

        for (ClientePf cliente : clientes){
            nomes[i] = cliente.nome;
            i++;
        }

        return nomes;
    }

    public String retornaDocumento (Integer index){
        return clientes.get(index).getCpf();
    }
}