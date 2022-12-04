package Classes;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class VendasRealizadas extends VendaServicoRealizadas{
    Integer qtdVendas=0;

    Integer quant;
    Double valorUnit;

    ArrayList<VendasRealizadas> vendas = new ArrayList<>();

    public VendasRealizadas (Integer quant,  Double valorUnit, String dataVendaServico, String cliente, String documento, String tipoCliente, String produtoServico, Double valorTot, String obs, Integer garantia){
        super(dataVendaServico, cliente, documento, tipoCliente, produtoServico, valorTot, obs, garantia);
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

    public Integer getQtdVendas (){
        return qtdVendas;
    }

    public void setQtdVendas (Integer qtdVendas){
        this.qtdVendas = qtdVendas;
    }

    public void addVenda (VendasRealizadas venda){
        vendas.add(venda);
    }

    public void recibo (Integer index){
        JOptionPane.showMessageDialog(null,
        "---------- Recibo da Venda "+(index+1)+" ----------\n"+
        "  Data da venda: "+vendas.get(index).dataVendaServico+"\n\n"+
        "  Tipo de cliente: "+vendas.get(index).tipoCliente+"\n"+
        "  Cliente: "+vendas.get(index).cliente+"\n"+
        "  Documento: "+vendas.get(index).documento+"\n\n"+
        "  Produto: "+vendas.get(index).produtoServico+"\n"+
        "  Valor unitario: R$ "+String.format("%.2f", vendas.get(index).valorUnit)+"\n"+
        "  Quantidade: "+vendas.get(index).quant+"\n"+
        "  Valor total: R$ "+String.format("%.2f", vendas.get(index).valorTot)+"\n\n"+
        "  Observacao: "+vendas.get(index).obs+"\n"+
        "  Garantia: "+vendas.get(index).garantia+" meses",
        "Recibo",
        JOptionPane.DEFAULT_OPTION);
    }
}
