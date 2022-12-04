package Classes;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ServicosRealizados extends VendaServicoRealizadas{
    Integer qtdServicos=0;

    ArrayList<ServicosRealizados> servicos = new ArrayList<>();

    public ServicosRealizados (String dataVendaServico, String cliente, String documento, String tipoCliente, String produtoServico, Double valorTot, String obs, Integer garantia){
        super(dataVendaServico, cliente, documento, tipoCliente, produtoServico, valorTot, obs, garantia);
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
        JOptionPane.showMessageDialog(null,
        "---------- Recibo do Servico "+(index+1)+" ----------\n"+
        "  Data do servico: "+servicos.get(index).dataVendaServico+"\n\n"+
        "  Tipo de cliente: "+servicos.get(index).tipoCliente+"\n"+
        "  Cliente: "+servicos.get(index).cliente+"\n"+
        "  Documento: "+servicos.get(index).documento+"\n\n"+
        "  Servico: "+servicos.get(index).produtoServico+"\n"+
        "  Valor: R$ "+String.format("%.2f", servicos.get(index).valorTot)+"\n\n"+
        "  Observacao: "+servicos.get(index).obs+"\n"+
        "  Garantia: "+servicos.get(index).garantia+" meses",
        "Recibo",
        JOptionPane.DEFAULT_OPTION);
    }
}
