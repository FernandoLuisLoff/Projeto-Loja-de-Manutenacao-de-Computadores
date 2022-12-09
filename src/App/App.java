package App;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import Classes.Controller;

import Classes.ClientePf;
import Classes.ClientePj;

import Classes.Produto;
import Classes.Servico;

import Classes.VendasRealizadas;
import Classes.ServicosRealizados;

public class App {
    public static void main(String[] args) throws Exception {

        String realizarCadastroStr = "Realizar cadastros";
        String mostrarCadastroStr = "Mostrar cadastros";
        String excluirCadastroStr = "Excluir cadastros";
        
        String registarVendaServicoStr = "Registrar uma venda ou servico realizado";
        String vizualizarVendaServicoStr = "Vizualizar uma venda ou servico realizado";
        String excluirVendaServicoStr = "Excluir uma venda ou servico realizado";

        String pessoaFisicaStr = "Cliente Pessoa Fisica";
        String pessoaJuridicaStr = "Cliente Pessoa Juridica";

        String produtoStr = "Produto";
        String servicoStr = "Servico";
        String vendaStr = "Venda";

        String dinheiroStr = "Dinheiro";
        String cartaoCreditoStr = "Cartao de credito";
        String cartaoDebitoStr = "Cartao de debito";
        String chequeStr = "Cheque";

        String simStr = "Sim";
        String naoStr = "Nao";

        String sairStr = "Sair";

        String []menu = new String[] {realizarCadastroStr, mostrarCadastroStr, excluirCadastroStr, registarVendaServicoStr, vizualizarVendaServicoStr, excluirVendaServicoStr, sairStr};
        String []menuCadastro = new String[] {pessoaFisicaStr, pessoaJuridicaStr, produtoStr, servicoStr, sairStr};
        String []menuVendasServicos = new String[] {vendaStr, servicoStr, sairStr};
        String []formasPgto = new String[] {dinheiroStr, cartaoCreditoStr, cartaoDebitoStr, chequeStr};
        String []parcelasPgto = new String[] {"A vista", "2", "3", "4", "5", "6"};
        String []tipoCliente = new String[] {pessoaFisicaStr, pessoaJuridicaStr};
        String []confirmacao = new String[] {simStr, naoStr};

        JComboBox MENU = new JComboBox(menu);
        JComboBox MENUCADASTRO = new JComboBox(menuCadastro);
        JComboBox MENUVENDASSERVICOS = new JComboBox(menuVendasServicos);
        JComboBox FORMASPGTO = new JComboBox(formasPgto);
        JComboBox PARCELASPGTO = new JComboBox(parcelasPgto);
        JComboBox MENUTIPOCLIENTE = new JComboBox(tipoCliente);
        JComboBox CONFIRMACAO = new JComboBox(confirmacao);

        ClientePf pessoaFisica = new ClientePf("", "");
        ClientePj pessoaJuridica = new ClientePj("", "");
        Produto produto = new Produto("", 0.0, 0);
        Servico servico = new Servico("", 0.0, 0);
        VendasRealizadas vendasRealizadas = new VendasRealizadas(0, 0.0, "", "", "", "", "", "", 0.0, "", 0, "", "");
        ServicosRealizados servicosRealizados = new ServicosRealizados("", "", "", "", "", "", 0.0, "", 0, "", "");

        Controller control = new Controller();

        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
        Date hoje = new Date();

        int auxNum=0;
        String mostraClientes="", nome="", documento="";
        boolean validacao=true;

        // Carregando dados nas arreys
        pessoaFisica.inicializaClientesPF();
        pessoaJuridica.inicializaClientesPJ(); 
        produto.inicializaProdutos();
        servico.inicializaServicos();

        do {
            JOptionPane.showMessageDialog(null,
                MENU,
                "Oque deseja fazer:",
                JOptionPane.DEFAULT_OPTION);
            
            // Fazer cadastros do sistema
            if (MENU.getSelectedItem().equals(realizarCadastroStr)) {
                do {
                    JOptionPane.showMessageDialog(null,
                        MENUCADASTRO,
                        "Oque deseja cadastrar:",
                        JOptionPane.DEFAULT_OPTION);

                    // Cadastra Pessoa Fisica
                    if (MENUCADASTRO.getSelectedItem().equals(pessoaFisicaStr)) {

                        pessoaFisica.setNome(JOptionPane.showInputDialog(null,
                            "Qual o nome do cliente:",
                            "Cadastro Cliente Pessoa Fisica",
                            JOptionPane.DEFAULT_OPTION));
                        
                        if (pessoaFisica.getNome().isEmpty()) {
                            JOptionPane.showMessageDialog(null,
                                "Campo nome nao foi preenchido!",
                                "Cadastro Cliente Pessoa Fisica",
                                JOptionPane.ERROR_MESSAGE);
                        } else if ( control.validaSemNum(pessoaFisica.getNome())) {
                            JOptionPane.showMessageDialog(null,
                                "Foram digitados numeros no nome!",
                                "Cadastro Cliente Pessoa Fisica",
                                JOptionPane.ERROR_MESSAGE);
                        } else {
                            try {
                                auxNum = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Qual o cpf do cliente:",
                                    "Cadastro Cliente Pessoa Fisica",
                                    JOptionPane.DEFAULT_OPTION));

                                pessoaFisica.setCpf(Integer.toString(auxNum));

                                pessoaFisica.addClientePf(new ClientePf(pessoaFisica.getNome(),pessoaFisica.getCpf()));
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null,
                                    "Documento invalido!",
                                    "Cadastro Cliente Pessoa Fisica",
                                    JOptionPane.ERROR_MESSAGE); 
                            }
                        }
                    }

                    // Cadastra Pessoa Juridica
                    if (MENUCADASTRO.getSelectedItem().equals(pessoaJuridicaStr)) {

                        pessoaJuridica.setNome(JOptionPane.showInputDialog(null,
                            "Qual o nome do cliente:",
                            "Cadastro Cliente Pessoa Juridica",
                            JOptionPane.DEFAULT_OPTION));
                        if (pessoaJuridica.getNome().isEmpty()) {
                            JOptionPane.showMessageDialog(null,
                                "Campo nome nao foi preenchido!",
                                "Cadastro Cliente Pessoa Juridica",
                                JOptionPane.ERROR_MESSAGE);
                        } else if ( control.validaSemNum(pessoaJuridica.getNome())) {
                            JOptionPane.showMessageDialog(null,
                                "Foram digitados numeros no nome!",
                                "Cadastro Cliente Pessoa Juridica",
                                JOptionPane.ERROR_MESSAGE);
                        } else {
                            try {
                                auxNum = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Qual o cnpj do cliente:",
                                    "Cadastro Cliente Pessoa Juridica",
                                    JOptionPane.DEFAULT_OPTION));

                                pessoaJuridica.setCnpj(Integer.toString(auxNum));

                                pessoaJuridica.addClientePj(new ClientePj(pessoaJuridica.getNome(),pessoaJuridica.getCnpj()));
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null,
                                    "Documento invalido!",
                                    "Cadastro Cliente Pessoa Juridica",
                                    JOptionPane.ERROR_MESSAGE); 
                            }
                        }
                    }

                    // Cadastra Produto
                    if (MENUCADASTRO.getSelectedItem().equals(produtoStr)) {

                        produto.setNome(JOptionPane.showInputDialog(null,
                            "Qual o nome do produto:",
                            "Cadastro Produto",
                            JOptionPane.DEFAULT_OPTION));

                        if (produto.getNome().isEmpty()) {
                            JOptionPane.showMessageDialog(null,
                                "Campo nome nao foi preenchido!",
                                "Cadastro Produto",
                                JOptionPane.ERROR_MESSAGE);
                        } else {
                            try {
                                produto.setValor(Double.parseDouble(JOptionPane.showInputDialog(null,
                                    "Qual o valor do produto:",
                                    "Cadastro Produto",
                                    JOptionPane.DEFAULT_OPTION)));

                                if (produto.getValor()<=0){
                                    JOptionPane.showMessageDialog(null,
                                        "O valor deve ser maior que 0!",
                                        "Cadastro Produto",
                                        JOptionPane.ERROR_MESSAGE); 

                                    validacao=false;
                                } else {
                                    validacao=true;
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null,
                                    "Valor invalido!",
                                    "Cadastro Produto",
                                    JOptionPane.ERROR_MESSAGE); 

                                validacao=false;
                            }
                            if (validacao){
                                try {
                                    produto.setGarantia(Integer.parseInt(JOptionPane.showInputDialog(null,
                                        "Qual a garantia do produto(em meses):",
                                        "Cadastro Produto",
                                        JOptionPane.DEFAULT_OPTION)));

                                    if (produto.getGarantia()<=0){
                                        JOptionPane.showMessageDialog(null,
                                            "A garantia deve ser maior que 0!",
                                            "Cadastro Produto",
                                            JOptionPane.ERROR_MESSAGE); 
                                    } else {
                                        produto.addProduto(new Produto(produto.getNome(), produto.getValor(), produto.getGarantia())); 
                                    }
                                } catch (Exception e){
                                    JOptionPane.showMessageDialog(null,
                                        "Garantia invalida!",
                                        "Cadastro Produto",
                                        JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                    }

                    // Cadastra Servico
                    if (MENUCADASTRO.getSelectedItem().equals(servicoStr)) {

                        servico.setNome(JOptionPane.showInputDialog(null,
                            "Qual o nome do Servico:",
                            "Cadastro Servico",
                            JOptionPane.DEFAULT_OPTION));

                        if (servico.getNome().isEmpty()) {
                            JOptionPane.showMessageDialog(null,
                                "Campo nome nao foi preenchido!",
                                "Cadastro Servico",
                                JOptionPane.ERROR_MESSAGE);
                        } else {
                            try {
                                servico.setValor(Double.parseDouble(JOptionPane.showInputDialog(null,
                                    "Qual o valor do Servico:",
                                    "Cadastro Servico",
                                    JOptionPane.DEFAULT_OPTION)));

                                if (servico.getValor()<=0){
                                    JOptionPane.showMessageDialog(null,
                                        "O valor deve ser maior que 0!",
                                        "Cadastro Servico",
                                        JOptionPane.ERROR_MESSAGE); 

                                    validacao=false;
                                } else {
                                    validacao=true;
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null,
                                    "Valor invalido!",
                                    "Cadastro Servico",
                                    JOptionPane.ERROR_MESSAGE); 

                                validacao=false;
                            }
                            if (validacao){
                                try {
                                    servico.setGarantia(Integer.parseInt(JOptionPane.showInputDialog(null,
                                        "Qual a garantia do Servico(em meses):",
                                        "Cadastro Servico",
                                        JOptionPane.DEFAULT_OPTION)));

                                    if (servico.getGarantia()<=0){
                                        JOptionPane.showMessageDialog(null,
                                            "A garantia deve ser maior que 0!",
                                            "Cadastro Servico",
                                            JOptionPane.ERROR_MESSAGE); 
        
                                    } else {
                                        servico.addServico(new Servico(servico.getNome(), servico.getValor(), servico.getGarantia()));
                                    }
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null,
                                        "Garantia invalida!",
                                        "Cadastro Servico",
                                        JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                    }

                    // Sair
                    if (MENUCADASTRO.getSelectedItem().equals(sairStr)) {
                        break;
                    }

                    JOptionPane.showMessageDialog(null,
                        CONFIRMACAO,
                        "Realizar outro cadastro?",
                        JOptionPane.DEFAULT_OPTION);

                } while (!CONFIRMACAO.getSelectedItem().equals(naoStr));
            }

            // Mostrar cadastros do sistema
            if (MENU.getSelectedItem().equals(mostrarCadastroStr)) {
                do {
                    JOptionPane.showMessageDialog(null,
                        MENUCADASTRO,
                        "Qual cadastro deseja mostrar:",
                        JOptionPane.DEFAULT_OPTION);

                    // Mostrar Pessoa Fisica
                    if (MENUCADASTRO.getSelectedItem().equals(pessoaFisicaStr)) {

                        nome=JOptionPane.showInputDialog(null,
                            "Qual o nome do cliente que deseja mostrar?\n"+
                            "Para ver todos deixe o campo vazio.",
                            "Clientes Pessoa Fisica:",
                            JOptionPane.DEFAULT_OPTION);

                        if (control.validaSemNum(nome)) {
                            JOptionPane.showMessageDialog(null,
                                "Foram digitados numeros no nome!",
                                "Clientes Pessoa Fisica:",
                                JOptionPane.ERROR_MESSAGE);
                        } else {
                            try {
                                documento=JOptionPane.showInputDialog(null,
                                    "Qual o cpf do cliente que deseja mostrar?\n"+
                                    "Para ver todos deixe o campo vazio.",
                                    "Clientes Pessoa Fisica:",
                                    JOptionPane.DEFAULT_OPTION);

                                if (!documento.isEmpty()){
                                    Integer.parseInt(documento);
                                }
                                validacao=true;
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null,
                                    "Documento invalido!",
                                    "Clientes Pessoa Fisica:",
                                    JOptionPane.ERROR_MESSAGE); 
                                
                                validacao=false;
                            }

                            if (validacao){
                                
                                mostraClientes=pessoaFisica.readClientes(nome, documento);

                                if (pessoaFisica.getSizeArreyClientesPf().equals(0) || mostraClientes.equals("")){
                                    JOptionPane.showMessageDialog(null,
                                        "Nao existem registros!",
                                        "Clientes Pessoa Fisica:",
                                        JOptionPane.ERROR_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                        mostraClientes,
                                        "Clientes Pessoa Fisica:",
                                        JOptionPane.DEFAULT_OPTION);
                                }
                            }
                        }
                    }

                    // Mostrar Pessoa Juridica
                    if (MENUCADASTRO.getSelectedItem().equals(pessoaJuridicaStr)) {

                        nome=JOptionPane.showInputDialog(null,
                            "Qual o nome do cliente que deseja mostrar?\n"+
                            "Para ver todos deixe o campo vazio.",
                            "Clientes Pessoa Juridica:",
                            JOptionPane.DEFAULT_OPTION);

                        if (control.validaSemNum(nome)) {
                            JOptionPane.showMessageDialog(null,
                                "Foram digitados numeros no nome!",
                                "Clientes Pessoa Juridica:",
                                JOptionPane.ERROR_MESSAGE);
                        } else {
                            try {
                                documento=JOptionPane.showInputDialog(null,
                                    "Qual o cnpj do cliente que deseja mostrar?\n"+
                                    "Para ver todos deixe o campo vazio.",
                                    "Clientes Pessoa Juridica:",
                                    JOptionPane.DEFAULT_OPTION);

                                if (!documento.isEmpty()){
                                    Integer.parseInt(documento);
                                }
                                validacao=true;
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null,
                                    "Documento invalido!",
                                    "Clientes Pessoa Juridica:",
                                    JOptionPane.ERROR_MESSAGE); 
                                
                                validacao=false;
                            }

                            if (validacao){
                            
                                mostraClientes=pessoaJuridica.readClientes(nome, documento);

                                if (pessoaJuridica.getSizeArreyClientesPj().equals(0) || mostraClientes.equals("")){
                                    JOptionPane.showMessageDialog(null,
                                        "Nao existem registros!",
                                        "Clientes Pessoa Juridica:",
                                        JOptionPane.ERROR_MESSAGE);
                                } else {
                                    JOptionPane.showMessageDialog(null,
                                        mostraClientes,
                                        "Clientes Pessoa Juridica:",
                                        JOptionPane.DEFAULT_OPTION);
                                }
                            }
                        }
                    }

                    // Mostrar Produtos
                    if (MENUCADASTRO.getSelectedItem().equals(produtoStr)){
                        if (produto.getSizeArreyProdutos().equals(0))
                        {
                            JOptionPane.showMessageDialog(null,
                                "Nao existem registros!",
                                "Produtos:",
                                JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                produto.readProdutos(),
                                "Produtos:",
                                JOptionPane.DEFAULT_OPTION);
                        }
                    }

                    // Mostrar Servicos
                    if (MENUCADASTRO.getSelectedItem().equals(servicoStr)) {
                        if (servico.getSizeArreyServicos().equals(0))
                        {
                            JOptionPane.showMessageDialog(null,
                                "Nao existem registros!",
                                "Servicos:",
                                JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                servico.readServicos(),
                                "Servicos:",
                                JOptionPane.DEFAULT_OPTION);
                        }
                    }

                    // Sair
                    if (MENUCADASTRO.getSelectedItem().equals(sairStr)) {
                        break;
                    }
                        
                    JOptionPane.showMessageDialog(null,
                        CONFIRMACAO,
                        "Mostrar outro cadastro?",
                        JOptionPane.DEFAULT_OPTION);

                } while (!CONFIRMACAO.getSelectedItem().equals(naoStr));
            }

            // Excluir cadastros do sistema
            if (MENU.getSelectedItem().equals(excluirCadastroStr)) {
                do {
                    JOptionPane.showMessageDialog(null,
                        MENUCADASTRO,
                        "Qual cadastro deseja excluir:",
                        JOptionPane.DEFAULT_OPTION);

                    // Excluir Pessoa Fisica
                    if (MENUCADASTRO.getSelectedItem().equals(pessoaFisicaStr)) {
                        if (pessoaFisica.getSizeArreyClientesPf().equals(0))
                        {
                            JOptionPane.showMessageDialog(null,
                                "Nao existem registros!",
                                "Clientes Pessoa Fisica:",
                                JOptionPane.ERROR_MESSAGE);
                        } else {
                            JComboBox CLIENTESPF = new JComboBox(pessoaFisica.arreyNomesPf());

                            JOptionPane.showMessageDialog(null,
                                CLIENTESPF,
                                "Qual cliente deseja excluir?",
                                JOptionPane.DEFAULT_OPTION);

                            pessoaFisica.removeClientePf(CLIENTESPF.getSelectedIndex());
                        }
                    }

                    // Excluir Pessoa Juridica
                    if (MENUCADASTRO.getSelectedItem().equals(pessoaJuridicaStr)) {
                        if (pessoaJuridica.getSizeArreyClientesPj().equals(0))
                        {
                            JOptionPane.showMessageDialog(null,
                                "Nao existem registros!",
                                "Clientes Pessoa Juridica:",
                                JOptionPane.ERROR_MESSAGE);
                        } else {
                            JComboBox CLIENTESPJ = new JComboBox(pessoaJuridica.arreyNomesPj());

                            JOptionPane.showMessageDialog(null,
                                CLIENTESPJ,
                                "Qual cliente deseja excluir?",
                                JOptionPane.DEFAULT_OPTION);

                            pessoaJuridica.removeClientePj(CLIENTESPJ.getSelectedIndex());
                        }
                    }

                    // Excluir Produtos
                    if (MENUCADASTRO.getSelectedItem().equals(produtoStr)) {
                        if (produto.getSizeArreyProdutos().equals(0))
                        {
                            JOptionPane.showMessageDialog(null,
                                "Nao existem registros!",
                                "Produtos:",
                                JOptionPane.ERROR_MESSAGE);
                        } else {
                            JComboBox PRODUTOS = new JComboBox(produto.arreyProdutos());

                            JOptionPane.showMessageDialog(null,
                                PRODUTOS,
                                "Qual produto deseja excluir?",
                                JOptionPane.DEFAULT_OPTION);
                            
                            produto.removeProduto(PRODUTOS.getSelectedIndex());
                        }
                    }

                    // Excluir Produtos
                    if (MENUCADASTRO.getSelectedItem().equals(servicoStr)) {
                        if (servico.getSizeArreyServicos().equals(0))
                        {
                            JOptionPane.showMessageDialog(null,
                                "Nao existem registros!",
                                "Produtos:",
                                JOptionPane.ERROR_MESSAGE);
                        } else {
                            JComboBox SERVICOS = new JComboBox(servico.arreyServicos());

                            JOptionPane.showMessageDialog(null,
                                SERVICOS,
                                "Qual servico deseja excluir?",
                                JOptionPane.DEFAULT_OPTION);

                            servico.removeServico(SERVICOS.getSelectedIndex());
                        }
                    }

                    // Sair
                    if (MENUCADASTRO.getSelectedItem().equals(sairStr)) {
                        break;
                    }

                    JOptionPane.showMessageDialog(null,
                        CONFIRMACAO,
                        "Excluir outro cadastro?",
                        JOptionPane.DEFAULT_OPTION);

                } while (!CONFIRMACAO.getSelectedItem().equals(naoStr));
            }

            // Registrar uma venda ou servico
            if (MENU.getSelectedItem().equals(registarVendaServicoStr)) {
                do {
                    JComboBox CLIENTESPF = new JComboBox(pessoaFisica.arreyNomesPf());
                    JComboBox CLIENTESPJ = new JComboBox(pessoaJuridica.arreyNomesPj());
                    JComboBox PRODUTOS = new JComboBox(produto.arreyProdutos());
                    JComboBox SERVICOS = new JComboBox(servico.arreyServicos());

                    JOptionPane.showMessageDialog(null,
                        MENUVENDASSERVICOS,
                        "Oque deseja registrar:",
                        JOptionPane.DEFAULT_OPTION);

                    // Registrar uma venda
                    if (MENUVENDASSERVICOS.getSelectedItem().equals(vendaStr)){

                        try {
                            auxNum=Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Qual é o identificador da venda (somente numeros):",
                                "Registrar venda",
                                JOptionPane.DEFAULT_OPTION));

                            vendasRealizadas.setIdentificacao(Integer.toString(auxNum));

                            if (vendasRealizadas.getIdentificacao().isEmpty()){
                                JOptionPane.showMessageDialog(null,
                                    "Campo identificador nao foi preenchido!",
                                    "Registrar venda",
                                    JOptionPane.ERROR_MESSAGE);
                                    
                                validacao=false;
                            } else {
                                validacao=true;
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null,
                                "Identificador invalido!",
                                "Registrar venda",
                                JOptionPane.ERROR_MESSAGE);

                            validacao=false;
                        }

                        if (validacao){
                            JOptionPane.showMessageDialog(null,
                                MENUTIPOCLIENTE,
                                "Qual o tipo do cliente:",
                                JOptionPane.DEFAULT_OPTION);

                            vendasRealizadas.setDataVendaServico(dt.format(hoje.getTime()));
                            vendasRealizadas.setTipoCliente(MENUTIPOCLIENTE.getSelectedItem().toString());

                            if (MENUTIPOCLIENTE.getSelectedItem().equals(pessoaFisicaStr)) {
                                JOptionPane.showMessageDialog(null,
                                    CLIENTESPF,
                                    "Selecione o cliente:",
                                    JOptionPane.DEFAULT_OPTION);

                                vendasRealizadas.setCliente(CLIENTESPF.getSelectedItem().toString());
                                vendasRealizadas.setDocumento(pessoaFisica.retornaDocumento(CLIENTESPF.getSelectedIndex()));
                            } else {
                                JOptionPane.showMessageDialog(null,
                                    CLIENTESPJ,
                                    "Selecione o cliente:",
                                    JOptionPane.DEFAULT_OPTION);

                                vendasRealizadas.setCliente(CLIENTESPJ.getSelectedItem().toString());
                                vendasRealizadas.setDocumento(pessoaJuridica.retornaDocumento(CLIENTESPJ.getSelectedIndex()));
                            }

                            JOptionPane.showMessageDialog(null,
                                PRODUTOS,
                                "Selecione o Produto:",
                                JOptionPane.DEFAULT_OPTION);

                            vendasRealizadas.setProdutoServico(PRODUTOS.getSelectedItem().toString());
                            vendasRealizadas.setValorUnit(produto.retornaValorUnit(PRODUTOS.getSelectedIndex()));
                            vendasRealizadas.setGarantia(produto.retornaGarantia(PRODUTOS.getSelectedIndex()));

                            try {
                                vendasRealizadas.setQuant(Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Quantidade de produtos:",
                                    "Registrar venda",
                                    JOptionPane.DEFAULT_OPTION)));
                                
                                if (vendasRealizadas.getQuant()<=0){
                                    JOptionPane.showMessageDialog(null,
                                        "A quantidade deve ser maior que 0!",
                                        "Registrar venda",
                                        JOptionPane.ERROR_MESSAGE);
                                    
                                    validacao=false;
                                } else {
                                    validacao=true;
                                }
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null,
                                    "Quantidade invalida!",
                                    "Registrar venda",
                                    JOptionPane.ERROR_MESSAGE);
                                
                                validacao = false;
                            }

                            if (validacao){
                                vendasRealizadas.setValorTot(vendasRealizadas.getValorUnit()*vendasRealizadas.getQuant());

                                JOptionPane.showMessageDialog(null,
                                    FORMASPGTO,
                                    "Selecione a forma de pagamento:",
                                    JOptionPane.DEFAULT_OPTION);

                                vendasRealizadas.setFormaPgto(FORMASPGTO.getSelectedItem().toString());

                                JOptionPane.showMessageDialog(null,
                                    PARCELASPGTO,
                                    "Selecione as parcelas de pagamento:",
                                    JOptionPane.DEFAULT_OPTION);

                                vendasRealizadas.setParcelasPgto(PARCELASPGTO.getSelectedItem().toString());

                                vendasRealizadas.setObs(JOptionPane.showInputDialog(null,
                                    "Observacao da venda:",
                                    "Registrar venda",
                                    JOptionPane.DEFAULT_OPTION));

                                if (vendasRealizadas.getObs().isEmpty()) {
                                    JOptionPane.showMessageDialog(null,
                                        "Campo observacao nao foi preenchido!",
                                        "Registrar venda",
                                        JOptionPane.ERROR_MESSAGE);
                                } else {
                                    vendasRealizadas.addVenda(new VendasRealizadas(vendasRealizadas.getQuant(), vendasRealizadas.getValorUnit(), vendasRealizadas.getIdentificacao(), vendasRealizadas.getDataVendaServico(), vendasRealizadas.getCliente(), vendasRealizadas.getDocumento(), vendasRealizadas.getTipoCliente(), vendasRealizadas.getProdutoServico(), vendasRealizadas.getValorTot(), vendasRealizadas.getObs(), vendasRealizadas.getGarantia(), vendasRealizadas.getFormaPgto(), vendasRealizadas.getParcelasPgto()));
                                
                                    vendasRealizadas.recibo(vendasRealizadas.getSizeArreyVendas()-1);
                                }
                            }
                        }
                    }

                    // Registrar uma servico prestado
                    if (MENUVENDASSERVICOS.getSelectedItem().equals(servicoStr)){
                        try {
                            auxNum=Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Qual é o identificador do servico (somente numeros):",
                                "Registrar servico",
                                JOptionPane.DEFAULT_OPTION));

                            servicosRealizados.setIdentificacao(Integer.toString(auxNum));
                            
                            if (servicosRealizados.getIdentificacao().isEmpty()){
                                JOptionPane.showMessageDialog(null,
                                    "Campo identificador nao foi preenchido!",
                                    "Registrar servico",
                                    JOptionPane.ERROR_MESSAGE);
                                
                                validacao=false;
                            } else {
                                validacao=true;
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null,
                                "Identificador invalido!",
                                "Registrar servico",
                                JOptionPane.ERROR_MESSAGE);

                            validacao=false;
                        }

                        if (validacao) {
                            JOptionPane.showMessageDialog(null,
                                MENUTIPOCLIENTE,
                                "Qual o tipo do cliente:",
                                JOptionPane.DEFAULT_OPTION);

                            servicosRealizados.setDataVendaServico(dt.format(hoje.getTime()));
                            servicosRealizados.setTipoCliente(MENUTIPOCLIENTE.getSelectedItem().toString());

                            if (MENUTIPOCLIENTE.getSelectedItem().equals(pessoaFisicaStr)) {
                                JOptionPane.showMessageDialog(null,
                                    CLIENTESPF,
                                    "Selecione o cliente:",
                                    JOptionPane.DEFAULT_OPTION);

                                servicosRealizados.setCliente(CLIENTESPF.getSelectedItem().toString());
                                servicosRealizados.setDocumento(pessoaFisica.retornaDocumento(CLIENTESPF.getSelectedIndex()));
                            } else {
                                JOptionPane.showMessageDialog(null,
                                    CLIENTESPJ,
                                    "Selecione o cliente:",
                                    JOptionPane.DEFAULT_OPTION);

                                servicosRealizados.setCliente(CLIENTESPJ.getSelectedItem().toString());
                                servicosRealizados.setDocumento(pessoaJuridica.retornaDocumento(CLIENTESPJ.getSelectedIndex()));
                            }

                            JOptionPane.showMessageDialog(null,
                                SERVICOS,
                                "Selecione o Servicos:",
                                JOptionPane.DEFAULT_OPTION);

                            servicosRealizados.setProdutoServico(SERVICOS.getSelectedItem().toString());
                            servicosRealizados.setValorTot(servico.retornaValor(SERVICOS.getSelectedIndex()));
                            servicosRealizados.setGarantia(servico.retornaGarantia(SERVICOS.getSelectedIndex()));

                            JOptionPane.showMessageDialog(null,
                                FORMASPGTO,
                                "Selecione a forma de pagamento:",
                                JOptionPane.DEFAULT_OPTION);

                            servicosRealizados.setFormaPgto(FORMASPGTO.getSelectedItem().toString());

                            JOptionPane.showMessageDialog(null,
                                PARCELASPGTO,
                                "Selecione as parcelas de pagamento:",
                                JOptionPane.DEFAULT_OPTION);

                            servicosRealizados.setParcelasPgto(PARCELASPGTO.getSelectedItem().toString());

                            servicosRealizados.setObs(JOptionPane.showInputDialog(null,
                                "Observacao do servico:",
                                "Registrar servico",
                                JOptionPane.DEFAULT_OPTION));

                            if (servicosRealizados.getObs().isEmpty()) {
                                JOptionPane.showMessageDialog(null,
                                    "Campo observacao nao foi preenchido!",
                                    "Registrar servico",
                                    JOptionPane.ERROR_MESSAGE);
                            } else {
                                servicosRealizados.addServico(new ServicosRealizados(servicosRealizados.getIdentificacao(), servicosRealizados.getDataVendaServico(), servicosRealizados.getCliente(), servicosRealizados.getDocumento(), servicosRealizados.getTipoCliente(), servicosRealizados.getProdutoServico(), servicosRealizados.getValorTot(), servicosRealizados.getObs(), servicosRealizados.getGarantia(), servicosRealizados.getFormaPgto(), servicosRealizados.getParcelasPgto()));
                            
                                servicosRealizados.recibo(servicosRealizados.getSizeArreyServicos()-1);
                            }
                        }
                    }

                    JOptionPane.showMessageDialog(null,
                        CONFIRMACAO,
                        "Realizar outra venda ou servico?",
                        JOptionPane.DEFAULT_OPTION);

                } while (!CONFIRMACAO.getSelectedItem().equals(naoStr));
            }

            // Vizualizar uma venda ou servico
            if (MENU.getSelectedItem().equals(vizualizarVendaServicoStr)) {
                do {
                    JOptionPane.showMessageDialog(null,
                        MENUVENDASSERVICOS,
                        "Oque deseja vizualizar:",
                        JOptionPane.DEFAULT_OPTION);

                    // Vizualizar uma venda realizada
                    if (MENUVENDASSERVICOS.getSelectedItem().equals(vendaStr)){
                        if (vendasRealizadas.getSizeArreyVendas().equals(0)){
                            JOptionPane.showMessageDialog(null,
                                "Nao existem registros!",
                                "Vendas realizadas:",
                                JOptionPane.ERROR_MESSAGE);
                        } else {
                            JComboBox VENDAS = new JComboBox(vendasRealizadas.arreyIdentificadoresVendas());

                            JOptionPane.showMessageDialog(null,
                                VENDAS,
                                "Qual venda deseja vizualizar?",
                                JOptionPane.DEFAULT_OPTION);

                            vendasRealizadas.recibo(VENDAS.getSelectedIndex()); 
                        }
                    }

                    // Vizualizar um servico prestado
                    if (MENUVENDASSERVICOS.getSelectedItem().equals(servicoStr)){
                        if (servicosRealizados.getSizeArreyServicos().equals(0)){
                            JOptionPane.showMessageDialog(null,
                                "Nao existem registros!",
                                "Servicos prestados:",
                                JOptionPane.ERROR_MESSAGE);
                        } else {
                            JComboBox SERVICOS = new JComboBox(servicosRealizados.arreyIdentificadoresServicos());

                            JOptionPane.showMessageDialog(null,
                                SERVICOS,
                                "Qual servico prestado deseja vizualizar?",
                                JOptionPane.DEFAULT_OPTION);

                            servicosRealizados.recibo(SERVICOS.getSelectedIndex()); 
                        }
                    }

                    // Sair
                    if (MENUVENDASSERVICOS.getSelectedItem().equals(sairStr)) {
                        break;
                    }
                    
                    JOptionPane.showMessageDialog(null,
                        CONFIRMACAO,
                        "Vizualizar outra venda ou servico?",
                        JOptionPane.DEFAULT_OPTION);

                } while (!CONFIRMACAO.getSelectedItem().equals(naoStr));
            }

            // Excluir uma venda ou servico
            if (MENU.getSelectedItem().equals(excluirVendaServicoStr)) {
                do {
                    JOptionPane.showMessageDialog(null,
                        MENUVENDASSERVICOS,
                        "Oque deseja excluir:",
                        JOptionPane.DEFAULT_OPTION);

                    // Excluir uma venda realizada
                    if (MENUVENDASSERVICOS.getSelectedItem().equals(vendaStr)){
                        if (vendasRealizadas.getSizeArreyVendas().equals(0)){
                            JOptionPane.showMessageDialog(null,
                                "Nao existem registros!",
                                "Vendas realizadas:",
                                JOptionPane.ERROR_MESSAGE);
                        } else {
                            JComboBox VENDAS = new JComboBox(vendasRealizadas.arreyIdentificadoresVendas());

                            JOptionPane.showMessageDialog(null,
                                VENDAS,
                                "Qual venda deseja excluir?",
                                JOptionPane.DEFAULT_OPTION);

                            vendasRealizadas.removeVenda(VENDAS.getSelectedIndex());
                        }
                    }

                    // Excluir um servico prestado
                    if (MENUVENDASSERVICOS.getSelectedItem().equals(servicoStr)){
                        if (servicosRealizados.getSizeArreyServicos().equals(0)){
                            JOptionPane.showMessageDialog(null,
                                "Nao existem registros!",
                                "Servicos prestados:",
                                JOptionPane.ERROR_MESSAGE);
                        } else {
                            JComboBox SERVICOS = new JComboBox(servicosRealizados.arreyIdentificadoresServicos());

                            JOptionPane.showMessageDialog(null,
                                SERVICOS,
                                "Qual servico prestado deseja excluir?",
                                JOptionPane.DEFAULT_OPTION);

                            servicosRealizados.removeServico(SERVICOS.getSelectedIndex());
                        }
                    }

                    // Sair
                    if (MENUVENDASSERVICOS.getSelectedItem().equals(sairStr)) {
                        break;
                    }

                    JOptionPane.showMessageDialog(null,
                        CONFIRMACAO,
                        "Excluir outra venda ou servico?",
                        JOptionPane.DEFAULT_OPTION);

                } while (!CONFIRMACAO.getSelectedItem().equals(naoStr));
            }

        } while (!MENU.getSelectedItem().equals(sairStr));
    }
}