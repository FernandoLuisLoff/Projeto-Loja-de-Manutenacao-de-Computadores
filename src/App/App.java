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

        Controller control = new Controller();

        ClientePf pessoaFisica = new ClientePf("", "");
        ClientePj pessoaJuridica = new ClientePj("", "");
        Produto produto = new Produto("", 0.0, 0);
        Servico servico = new Servico("", 0.0, 0);
        VendasRealizadas vendasRealizadas = new VendasRealizadas(0, 0.0, "", "", "", "", "", 0.0, "", 0);
        ServicosRealizados servicosRealizados = new ServicosRealizados("", "", "", "", "", 0.0, "", 0);

        String []menu = new String[] {"Realizar cadastros", "Mostrar cadastros", "Registrar uma venda ou servico realizado", "Vizualizar as vendas ou servicos realizados", "Sair"};
        String []menuCadastro = new String[] {"Cliente Pessoa Fisica", "Cliente Pessoa Juridica", "Produto", "Servico", "Sair"};
        String []menuVendasServicos = new String[] {"Venda", "Servico"};
        String []tipoCliente = new String[] {"Cliente Pessoa Fisica", "Cliente Pessoa Juridica"};
        String []confirmacao = new String[] {"Sim", "Nao"};

        JComboBox MENU = new JComboBox(menu);
        JComboBox MENUCADASTRO = new JComboBox(menuCadastro);
        JComboBox MENUVENDASSERVICOS = new JComboBox(menuVendasServicos);
        JComboBox MENUTIPOCLIENTE = new JComboBox(tipoCliente);
        JComboBox CONFIRMACAO = new JComboBox(confirmacao);

        SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy - HH:mm");
        Date hoje = new Date();

        int documento=0;
        boolean validacao=true;

        // Carregando dados nas arreys
        // pessoaFisica.inicializaClientesPF();
        // pessoaJuridica.inicializaClientesPJ(); 
        // produto.inicializaProdutos();
        // servico.inicializaServicos();

        do {
            JOptionPane.showMessageDialog(null,
                MENU,
                "Oque deseja fazer:",
                JOptionPane.DEFAULT_OPTION);
            
            // Fazer cadastros do sistema
            if (MENU.getSelectedItem().equals("Realizar cadastros")) {
                do {
                    JOptionPane.showMessageDialog(null,
                        MENUCADASTRO,
                        "Oque deseja cadastrar:",
                        JOptionPane.DEFAULT_OPTION);

                    // Cadastra Pessoa Fisica
                    if (MENUCADASTRO.getSelectedItem().equals("Cliente Pessoa Fisica")) {

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
                                documento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Qual o cpf do cliente:",
                                    "Cadastro Cliente Pessoa Fisica",
                                    JOptionPane.DEFAULT_OPTION));

                                pessoaFisica.setCpf(Integer.toString(documento));

                                pessoaFisica.addClientePf(new ClientePf(pessoaFisica.getNome(),pessoaFisica.getCpf()));
                                pessoaFisica.setQtdClientesPf(pessoaFisica.getQtdClientesPf()+1);
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null,
                                    "Documento invalido!",
                                    "Cadastro Cliente Pessoa Fisica",
                                    JOptionPane.ERROR_MESSAGE); 
                            }
                        }
                    }

                    // Cadastra Pessoa Juridica
                    if (MENUCADASTRO.getSelectedItem().equals("Cliente Pessoa Juridica")) {

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
                                documento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                    "Qual o cnpj do cliente:",
                                    "Cadastro Cliente Pessoa Juridica",
                                    JOptionPane.DEFAULT_OPTION));

                                pessoaJuridica.setCnpj(Integer.toString(documento));

                                pessoaJuridica.addClientePj(new ClientePj(pessoaJuridica.getNome(),pessoaJuridica.getCnpj()));
                                pessoaJuridica.setQtdCllientesPj(pessoaJuridica.getQtdCllientesPj()+1);
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(null,
                                    "Documento invalido!",
                                    "Cadastro Cliente Pessoa Juridica",
                                    JOptionPane.ERROR_MESSAGE); 
                            }
                        }
                    }

                    // Cadastra Produto
                    if (MENUCADASTRO.getSelectedItem().equals("Produto")) {

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

                                validacao=true;
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

                                    produto.addProduto(new Produto(produto.getNome(), produto.getValor(), produto.getGarantia())); 
                                    produto.setQtdprodutos(produto.getQtdprodutos()+1);
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(null,
                                        "Garantia invalida!",
                                        "Cadastro Produto",
                                        JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                    }

                    // Cadastra Servico
                    if (MENUCADASTRO.getSelectedItem().equals("Servico")) {

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

                                validacao=true;
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

                                    servico.addServico(new Servico(servico.getNome(), servico.getValor(), servico.getGarantia())); 
                                    servico.setQtdServicos(servico.getQtdServicos()+1);
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
                    if (MENUCADASTRO.getSelectedItem().equals("Sair")) {
                        break;
                    }

                    JOptionPane.showMessageDialog(null,
                        CONFIRMACAO,
                        "Realizar outro cadastro?",
                        JOptionPane.DEFAULT_OPTION);

                } while (!CONFIRMACAO.getSelectedItem().equals("Nao"));
            }

            // Mostrar cadastros do sistema
            if (MENU.getSelectedItem().equals("Mostrar cadastros")) {
                do {
                    JOptionPane.showMessageDialog(null,
                        MENUCADASTRO,
                        "Qual cadastro deseja mostrar:",
                        JOptionPane.DEFAULT_OPTION);

                    // Mostrar Pessoa Fisica
                    if (MENUCADASTRO.getSelectedItem().equals("Cliente Pessoa Fisica")) {
                        if (pessoaFisica.getQtdClientesPf().equals(0))
                        {
                            JOptionPane.showMessageDialog(null,
                                "Nao existem registros!",
                                "Clientes Pessoa Fisica:",
                                JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                pessoaFisica.readClientes(),
                                "Clientes Pessoa Fisica:",
                                JOptionPane.DEFAULT_OPTION);
                        }
                    }

                    // Mostrar Pessoa Juridica
                    if (MENUCADASTRO.getSelectedItem().equals("Cliente Pessoa Juridica")) {
                        if (pessoaJuridica.getQtdCllientesPj().equals(0))
                        {
                            JOptionPane.showMessageDialog(null,
                                "Nao existem registros!",
                                "Clientes Pessoa Juridica:",
                                JOptionPane.ERROR_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null,
                                pessoaJuridica.readClientes(),
                                "Clientes Pessoa Juridica:",
                                JOptionPane.DEFAULT_OPTION);
                        }
                    }

                    // Mostrar Produtos
                    if (MENUCADASTRO.getSelectedItem().equals("Produto")) {
                        if (produto.getQtdprodutos().equals(0))
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
                    if (MENUCADASTRO.getSelectedItem().equals("Servico")) {
                        if (servico.getQtdServicos().equals(0))
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
                    if (MENUCADASTRO.getSelectedItem().equals("Sair")) {
                        break;
                    }
                        
                    JOptionPane.showMessageDialog(null,
                        CONFIRMACAO,
                        "Mostrar outro cadastro?",
                        JOptionPane.DEFAULT_OPTION);

                } while (!CONFIRMACAO.getSelectedItem().equals("Nao"));
            }

            // Registrar uma venda ou servico
            if (MENU.getSelectedItem().equals("Registrar uma venda ou servico realizado")) {
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
                    if (MENUVENDASSERVICOS.getSelectedItem().equals("Venda")){

                        JOptionPane.showMessageDialog(null,
                            MENUTIPOCLIENTE,
                            "Qual o tipo do cliente:",
                            JOptionPane.DEFAULT_OPTION);

                        vendasRealizadas.setDataVendaServico(dt.format(hoje.getTime()));
                        vendasRealizadas.setTipoCliente(MENUVENDASSERVICOS.getSelectedItem().toString());

                        if (MENUTIPOCLIENTE.getSelectedItem().equals("Cliente Pessoa Fisica")) {
                            JOptionPane.showMessageDialog(null,
                                CLIENTESPF,
                                "Selecione o cliente:",
                                JOptionPane.DEFAULT_OPTION);

                            vendasRealizadas.setCliente(MENUTIPOCLIENTE.getSelectedItem().toString());
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
                            
                            validacao = true;
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null,
                                "Quantidade invalida!",
                                "Registrar venda",
                                JOptionPane.ERROR_MESSAGE);
                            
                            validacao = false;
                        }

                        if (validacao){
                            vendasRealizadas.setValorTot(vendasRealizadas.getValorUnit()*vendasRealizadas.getQuant());

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
                                vendasRealizadas.addVenda(new VendasRealizadas(vendasRealizadas.getQuant(), vendasRealizadas.getValorUnit(), vendasRealizadas.getDataVendaServico(), vendasRealizadas.getCliente(), vendasRealizadas.getDocumento(), vendasRealizadas.getTipoCliente(), vendasRealizadas.getProdutoServico(), vendasRealizadas.getValorTot(), vendasRealizadas.getObs(), vendasRealizadas.getGarantia()));
                            
                                vendasRealizadas.recibo(vendasRealizadas.getQtdVendas());
                                vendasRealizadas.setQtdVendas(vendasRealizadas.getQtdVendas()+1);
                            }
                        }
                    }

                    // Registrar uma servico prestado
                    if (MENUVENDASSERVICOS.getSelectedItem().equals("Servico")){
                        
                        JOptionPane.showMessageDialog(null,
                            MENUTIPOCLIENTE,
                            "Qual o tipo do cliente:",
                            JOptionPane.DEFAULT_OPTION);

                        servicosRealizados.setDataVendaServico(dt.format(hoje.getTime()));
                        servicosRealizados.setTipoCliente(MENUVENDASSERVICOS.getSelectedItem().toString());

                        if (MENUTIPOCLIENTE.getSelectedItem().equals("Cliente Pessoa Fisica")) {
                            JOptionPane.showMessageDialog(null,
                                CLIENTESPF,
                                "Selecione o cliente:",
                                JOptionPane.DEFAULT_OPTION);

                            servicosRealizados.setCliente(MENUTIPOCLIENTE.getSelectedItem().toString());
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
                            servicosRealizados.addServico(new ServicosRealizados( servicosRealizados.getDataVendaServico(), servicosRealizados.getCliente(), servicosRealizados.getDocumento(), servicosRealizados.getTipoCliente(), servicosRealizados.getProdutoServico(), servicosRealizados.getValorTot(), servicosRealizados.getObs(), servicosRealizados.getGarantia()));
                        
                            servicosRealizados.recibo(servicosRealizados.getQtdServicos());
                            servicosRealizados.setQtdServicos(servicosRealizados.getQtdServicos()+1);
                        }
                    }

                    JOptionPane.showMessageDialog(null,
                        CONFIRMACAO,
                        "Realizar outra venda ou servico?",
                        JOptionPane.DEFAULT_OPTION);

                } while (!CONFIRMACAO.getSelectedItem().equals("Nao"));
            }

        } while (!MENU.getSelectedItem().equals("Sair"));
    }
}
