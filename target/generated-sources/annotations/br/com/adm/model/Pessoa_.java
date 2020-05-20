package br.com.adm.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Pessoa.class)
public abstract class Pessoa_ {

	public static volatile SingularAttribute<Pessoa, Integer> idPessoa;
	public static volatile SingularAttribute<Pessoa, String> enderecoPessoa;
	public static volatile SingularAttribute<Pessoa, String> cepPessoa;
	public static volatile SingularAttribute<Pessoa, String> celularPessoa;
	public static volatile SingularAttribute<Pessoa, Cidade> cidadePessoa;
	public static volatile SingularAttribute<Pessoa, Boolean> statusPessoa;
	public static volatile SingularAttribute<Pessoa, String> telefonePessoa;

}

