package br.com.adm.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Produto.class)
public abstract class Produto_ {

	public static volatile SingularAttribute<Produto, Integer> idProduto;
	public static volatile SingularAttribute<Produto, String> marcaProduto;
	public static volatile SingularAttribute<Produto, Double> precoProduto;
	public static volatile SingularAttribute<Produto, String> codigoProduto;
	public static volatile SingularAttribute<Produto, Boolean> statusProduto;
	public static volatile SingularAttribute<Produto, String> nomeProduto;

}

