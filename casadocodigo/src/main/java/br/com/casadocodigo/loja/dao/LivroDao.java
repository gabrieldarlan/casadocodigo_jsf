package br.com.casadocodigo.loja.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.loja.models.Livro;

public class LivroDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext
	private EntityManager manager;

	public void salvar(Livro livro) {
		manager.persist(livro);
	}

	public List<Livro> listar() {

		String jpql = "select distinct(l) from Livro l join fetch l.autores";

		return manager.createQuery(jpql, Livro.class).getResultList();
	}
}
