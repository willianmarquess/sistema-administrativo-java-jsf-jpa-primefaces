package br.com.adm.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Venda.class)
public abstract class Venda_ {

	public static volatile SingularAttribute<Venda, String> observacaoVenda;
	public static volatile ListAttribute<Venda, Item> itens;
	public static volatile SingularAttribute<Venda, Date> dataVenda;
	public static volatile SingularAttribute<Venda, PessoaFisica> clienteVenda;
	public static volatile SingularAttribute<Venda, String> tipoVenda;
	public static volatile SingularAttribute<Venda, Double> totalVenda;
	public static volatile SingularAttribute<Venda, String> formaPagamentoVenda;
	public static volatile SingularAttribute<Venda, Date> dataPagamentoVenda;
	public static volatile SingularAttribute<Venda, PessoaFisica> funcionarioVenda;
	public static volatile SingularAttribute<Venda, Integer> idVenda;

}

