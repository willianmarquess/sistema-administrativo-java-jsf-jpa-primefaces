/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adm.ctr;

import br.com.adm.dao.PessoaFisicaDAO;
import br.com.adm.dao.VendaDAO;
import br.com.adm.model.Cidade;
import br.com.adm.model.Estoque;
import br.com.adm.model.Item;
import br.com.adm.model.PessoaFisica;
import br.com.adm.model.Produto;
import br.com.adm.model.Venda;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.hibernate.validator.constraints.NotBlank;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Jason
 */
@ManagedBean(name = "CadastrarVendaBean")
@ViewScoped
public class CadastrarVendaBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Estoque estoque = new Estoque();
    private Produto produto = new Produto();
    private Venda venda = new Venda();
    private Item item = new Item();

    private List<Item> itens = new ArrayList<Item>();

    FacesContext context;
    private boolean render = false;
    private Item itemSelecionado;
    private PessoaFisica cliente = new PessoaFisica();
    private Cidade cidade = new Cidade();
    private String nomeCliente;
    private Double total = 0.0;
    private Date dataPagamento;
    private Integer formaPagamentoVenda;

    public void adicionar() {
        context = FacesContext.getCurrentInstance();

        if (item.getQuantidadeItem() <= estoque.getQuantidadeEstoque() && item.getQuantidadeItem() >= 0.5) {
            if (!itens.contains(item)) {
                item.setTotalParcialItem(item.getQuantidadeItem() * item.getProdutoItem().getPrecoProduto());
                total += item.getTotalParcialItem();
                itens.add(item);
                render = true;
                limpar();
            } else {
                limpar();
                FacesMessage mensagem = new FacesMessage("Não pode adicionar este PRODUTO");
                mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
                context.addMessage(null, mensagem);
            }
        } else {
            FacesMessage mensagem = new FacesMessage("Digite uma quantidade correta");
            mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
            context.addMessage(null, mensagem);
        }

    }
    public void gerarDataPagamento() {
        context = FacesContext.getCurrentInstance();
        FacesMessage mensagem;
        LocalDate dataAtual = LocalDate.now();
        if (null != formaPagamentoVenda) {
            switch (formaPagamentoVenda) {
                case 0:
                    dataPagamento = java.sql.Date.valueOf(dataAtual);
                    break;
                case 1:
                    dataPagamento = java.sql.Date.valueOf(dataAtual);
                    break;
                case 2:
                    dataPagamento = java.sql.Date.valueOf(dataAtual.plusMonths(1));
                    break;
                case 3:
                    dataPagamento = java.sql.Date.valueOf(dataAtual.plusMonths(2));
                    break;
                default:
                    break;
            }
        }
    }

    public String gerarFormaPagamento() {
        if (null != formaPagamentoVenda) {
            switch (formaPagamentoVenda) {
                case 0:
                    return "avista";
                case 1:
                    return "1xcartao";
                case 2:
                    return "2xcartao";
                case 3:
                    return "3xcartao";
                default:
                    break;
            }
        }
        return "";
    }

    public void salvar() {
        context = FacesContext.getCurrentInstance();
        try {
            venda.setClienteVenda(cliente);
            venda.setDataPagamentoVenda(dataPagamento);
            venda.setDataVenda(java.sql.Date.valueOf(LocalDate.now()));
            venda.setFormaPagamentoVenda(gerarFormaPagamento());
            venda.setTipoVenda("venda");
            venda.setTotalVenda(total);

            PessoaFisicaDAO daofuncionario = new PessoaFisicaDAO();
            venda.setFuncionarioVenda(daofuncionario.restaurar(21));

            VendaDAO dao = new VendaDAO();

            if (dao.salvar(venda, itens)) {
                context.addMessage(null, new FacesMessage("VENDA cadastrada com sucesso!"));
                clearAll();

            } else {
                FacesMessage mensagem = new FacesMessage("Erro ao cadastrar VENDA!");
                mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
                context.addMessage(null, mensagem);
            }
        } catch (Exception e) {
            System.out.println("Erro ao salvar a venda! Erro: " + e.getMessage());
        }
    }


    public void clienteSelecionado(SelectEvent event) {
        cliente = (PessoaFisica) event.getObject();
        cidade = cliente.getCidadePessoa();
    }

    public void excluir() {
        itens.remove(itemSelecionado);
        total -= itemSelecionado.getTotalParcialItem();
    }

    public void limpar() {
        produto = new Produto();
        item = new Item();
        estoque = new Estoque();
    }
    
    public void clearAll(){
     produto = new Produto();
     item =  new Item();
     estoque = new Estoque();
     venda = new Venda();
     cidade = new Cidade();
     cliente = new PessoaFisica();
     itens = new ArrayList<Item>();
     render = false;
     nomeCliente = "";
     total = 0.0;
     dataPagamento = new Date();
     formaPagamentoVenda = null;
    }

    public void produtoSelecionado(SelectEvent event) {
        estoque = (Estoque) event.getObject();
        produto = estoque.getProdutoEstoque();
        item.setProdutoItem(produto);
    }

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public FacesContext getContext() {
        return context;
    }

    public void setContext(FacesContext context) {
        this.context = context;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public boolean isRender() {
        return render;
    }

    public void setRender(boolean render) {
        this.render = render;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public List<Item> getItens() {
        return itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public Item getItemSelecionado() {
        return itemSelecionado;
    }

    public void setItemSelecionado(Item itemSelecionado) {
        this.itemSelecionado = itemSelecionado;
    }

    public PessoaFisica getCliente() {
        return cliente;
    }

    public void setCliente(PessoaFisica cliente) {
        this.cliente = cliente;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @NotBlank
    public String getNomeCliente() {
        return cliente == null ? null : cliente.getNomePessoaFisica();
    }

    public void setNomeCliente(String nomeCliente) {

    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public Integer getFormaPagamentoVenda() {
        return formaPagamentoVenda;
    }

    public void setFormaPagamentoVenda(Integer formaPagamentoVenda) {
        this.formaPagamentoVenda = formaPagamentoVenda;
    }
}
