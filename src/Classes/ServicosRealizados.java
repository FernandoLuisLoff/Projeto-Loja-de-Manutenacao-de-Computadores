package Classes;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ServicosRealizados extends VendaServicoRealizadas{
    Integer qtdServicos=0;

    Controller control = new Controller();

    ArrayList<ServicosRealizados> servicos = new ArrayList<>();

    public ServicosRealizados (String identificacao, String dataVendaServico, String cliente, String documento, String tipoCliente, String produtoServico, Double valorTot, String obs, Integer garantia, String formaPgto, String parcelasPgto){
        super(identificacao, dataVendaServico, cliente, documento, tipoCliente, produtoServico, valorTot, obs, garantia, formaPgto, parcelasPgto);
    }
    
    public void addServico (ServicosRealizados servico){
        servicos.add(servico);
    }

    public Integer getQtdServicos (){
        return qtdServicos;
    }

    public void setQtdServicos (Integer qtdServicos){
        this.qtdServicos = qtdServicos;
    }

    public void recibo (Integer index){

        String parcelamento="";
        Double valorParcela=0.0;

        try {
            valorParcela=servicos.get(index).valorTot/Integer.parseInt(servicos.get(index).parcelasPgto);
            parcelamento=servicos.get(index).parcelasPgto+"X R$ "+String.format("%.2f", valorParcela);
        } catch (Exception e) {
            parcelamento=servicos.get(index).parcelasPgto;
        }

        JOptionPane.showMessageDialog(null,
        "  Recibo do Servico: "+servicos.get(index).identificacao+"    Data do servico: "+servicos.get(index).dataVendaServico+"\n\n"+
        "  Nome do Estabelecimento: "+control.nomeEstab+"    CNPJ: "+control.cnpjEstab+"\n"+
        "  Endereco: "+control.enderecoEstab+"\n"+
        "  Telefone: "+control.telefoneEstab+"    Email: "+control.emailEstab+"\n\n"+
        "  Tipo de cliente: "+servicos.get(index).tipoCliente+"\n"+
        "  Cliente: "+servicos.get(index).cliente+"  CPF/CNPJ: "+servicos.get(index).documento+"\n\n"+
        "  Servico: "+servicos.get(index).produtoServico+"\n"+
        "  Valor: R$ "+String.format("%.2f", servicos.get(index).valorTot)+"\n"+
        "  Forma de pagamento: "+servicos.get(index).formaPgto+"    Parcelamento: "+parcelamento+"\n\n"+
        "  Observacao: "+servicos.get(index).obs+"\n"+
        "  Garantia: "+servicos.get(index).garantia+" meses\n",
        "Recibo",
        JOptionPane.DEFAULT_OPTION);
    }
}
