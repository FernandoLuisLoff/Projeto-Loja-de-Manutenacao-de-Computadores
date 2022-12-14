package Classes;

import java.util.ArrayList;

public class ClientePj extends Cliente {

    String cnpj;

    ArrayList<ClientePj> clientes = new ArrayList<>();

    public ClientePj( String nome, String cnpj) {
        super(nome);
        this.cnpj = cnpj;
    }

    public String getCnpj(){
        return cnpj;
    }

    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }

    public Integer getSizeArreyClientesPj(){
        return clientes.size();
    }

    public void addClientePj (ClientePj clientePf){
        clientes.add(clientePf);
    }

    public void removeClientePj (Integer index){
        clientes.remove(index.intValue());
    }

    public String readClientes (String nome, String cnpj){
        String mostraClientes="";
        int i=1;

        for (ClientePj cliente : clientes) {
            if (cliente.nome.contains(nome)){
                if (cliente.cnpj.contains(cnpj)){
                    mostraClientes += "Cliente "+i+":\n  Nome: "+cliente.nome+"\n  Cnpj: "+cliente.cnpj+"\n\n"; 
                }
            }
            i++;
        }

        return mostraClientes;
    }

    public void inicializaClientesPJ() {
        String []nome = new String[] {"Americanas", "Casas Bahia", "Mercado Livre"};
        String []cnpj = new String[] {"123465478", "46749847", "4568978"};

        for (int i=0; i<nome.length; i++){
            addClientePj(new ClientePj(nome[i], cnpj[i]));
        }
    }

    public String []arreyNomesPj (){
        String []nomes = new String[clientes.size()];
        int i=0;

        for (ClientePj cliente : clientes){
            nomes[i] = cliente.nome;
            i++;
        }

        return nomes;
    }

    public String retornaDocumento (Integer index){
        return clientes.get(index).getCnpj();
    }
}
