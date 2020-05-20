package br.com.adm.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Estoque.class)
public abstract class Estoque_ {

	public static volatile SingularAttribute<Estoque, Integer> idEstoque;
	public static volatile SingularAttribute<Estoque, Double> quantidadeMinEstoque;
	public static volatile SingularAttribute<Estoque, Double> valorTotal;
	public static volatile SingularAttribute<Estoque, Produto> produtoEstoque;
	public static volatile SingularAttribute<Estoque, Double> quantidadeEstoque;
	public static volatile SingularAttribute<Estoque, Double> quantidade;
	public static volatile SingularAttribute<Estoque, Boolean> statusEstoque;

}

