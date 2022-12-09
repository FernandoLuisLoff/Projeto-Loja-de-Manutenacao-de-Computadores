package Classes;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VendasRealizadas extends VendaServicoRealizadas{

    Integer quant;
    Double valorUnit;

    Controller control = new Controller();

    ArrayList<VendasRealizadas> vendas = new ArrayList<>();

    public VendasRealizadas (Integer quant,  Double valorUnit, String identificacao, String dataVendaServico, String cliente, String documento, String tipoCliente, String produtoServico, Double valorTot, String obs, Integer garantia, String formaPgto, String parcelasPgto){
        super(identificacao, dataVendaServico, cliente, documento, tipoCliente, produtoServico, valorTot, obs, garantia, formaPgto, parcelasPgto);
        this.quant = quant;
        this.valorUnit = valorUnit;
    }

    public Integer getQuant (){
        return quant;
    }

    public void setQuant (Integer quant){
        this.quant = quant;
    }

    public Double getValorUnit (){
        return valorUnit;
    }

    public void setValorUnit (Double valorUnit){
        this.valorUnit = valorUnit;
    }

    public Integer getSizeArreyVendas(){
        return vendas.size();
    }

    public void addVenda (VendasRealizadas venda){
        vendas.add(venda);
    }

    public void removeVenda (Integer index){
        vendas.remove(index.intValue());
    }

    public void recibo (Integer index){

        String parcelamento="";
        Double valorParcela=0.0;

        try {
            valorParcela=vendas.get(index).valorTot/Integer.parseInt(vendas.get(index).parcelasPgto);
            parcelamento=vendas.get(index).parcelasPgto+"X R$ "+String.format("%.2f", valorParcela);
        } catch (Exception e) {
            parcelamento=vendas.get(index).parcelasPgto;
        }

        JOptionPane.showMessageDialog(null,
        "  Recibo da Venda: "+vendas.get(index).identificacao+"    Data da venda: "+vendas.get(index).dataVendaServico+"\n\n"+
        "  Nome do Estabelecimento: "+control.nomeEstab+"\n"+
        "  CNPJ: "+control.cnpjEstab+"\n"+
        "  Endereco: "+control.enderecoEstab+"\n"+
        "  Telefone: "+control.telefoneEstab+"    Email: "+control.emailEstab+"\n\n"+
        "  Tipo de cliente: "+vendas.get(index).tipoCliente+"\n"+
        "  Cliente: "+vendas.get(index).cliente+"    CPF/CNPJ: "+vendas.get(index).documento+"\n\n"+
        "  Produto: "+vendas.get(index).produtoServico+"    Quantidade: "+vendas.get(index).quant+"\n"+
        "  Valor unitario: R$ "+String.format("%.2f", vendas.get(index).valorUnit)+"    Valor total: R$ "+String.format("%.2f", vendas.get(index).valorTot)+"\n"+
        "  Parcelamento: "+parcelamento+"\n"+
        "  Forma de pagamento: "+vendas.get(index).formaPgto+"\n\n"+
        "  Observacao: "+vendas.get(index).obs+"\n"+
        "  Garantia: "+vendas.get(index).garantia+" meses\n",
        "Recibo",
        JOptionPane.DEFAULT_OPTION);
    }

    public String []arreyIdentificadoresVendas (){
        String []identificadores = new String[vendas.size()];
        int i=0;

        for (VendasRealizadas venda : vendas){
            identificadores[i] = venda.identificacao;
            i++;
        }



        return identificadores;
    }
}
