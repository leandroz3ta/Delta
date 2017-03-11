package br.edu.faculdadedelta.util;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class JPAUtilTest {

	private EntityManager em;
	
	@Test
	public void deveTerInstanciadoEntityManagerDefinida(){
		assertNotNull("instancia do EntityManager não deve estar nula", em);
	}
	@Test 
	public void deveFecharEntityManager(){
		em.close();
		assertFalse("Instãncia de EntityManager deve estar fechada.", em.isOpen());
	}
	
	@Test
	public void deveAbrirUmaTransacao(){
		assertFalse("Transação deve estar fechada", em.getTransaction().isActive());
		em.getTransaction().begin();
		assertTrue("Transação deve estar aberta", em.getTransaction().isActive());
	}
	
	@Before
	public void instanciarEntityManager(){
		em = JPAUtil.INSTANCE.getEntityManager();
	}
	
	@After
	public void fecharEntityManager(){
		if(em.isOpen()){
			em.close();
		}
	}
}
