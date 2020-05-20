package br.com.adm.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Item.class)
public abstract class Item_ {

	public static volatile SingularAttribute<Item, Produto> produtoItem;
	public static volatile SingularAttribute<Item, Venda> vendaItem;
	public static volatile SingularAttribute<Item, Double> totalParcialItem;
	public static volatile SingularAttribute<Item, Double> quantidadeItem;
	public static volatile SingularAttribute<Item, Integer> idItem;

}

