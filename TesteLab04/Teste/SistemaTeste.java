package Teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Lab04.Sistema;

class SistemaTeste {
	
	private Sistema controle;
	
	@BeforeEach
	void criaNovo()
	{
		controle = new Sistema();
	}
	
	@Test
	void cadastraAlunoTeste()
	{
		assertTrue(controle.cadastraAluno("118210675", "ARTHUR", "COMPUTACAO"));
		assertFalse(controle.cadastraAluno("118210675", "ARTHUR", "COMPUTACAO"));
	}
	
	@Test
	void cadastraAlunoExistenteTest()
	{
		controle.cadastraAluno("118210675", "Rafael", "Computacao");
		assertFalse(controle.cadastraAluno("118210675", "Arthur", "Computacao"));
	}
	
	@Test
	void cadastraAlunoMatriculaNull()
	{
		try
		{
			controle.cadastraAluno(null, "arthur", "Computacao");
			fail("Era esperado falha ao cadastrar matricula null");
		}catch(NullPointerException npe) {}
	}
	
	@Test
	void cadastraAlunoMatriculaVazia()
	{
		try
		{
			controle.cadastraAluno("", "Arthur", "Computucao");
			fail("Era esperado falha ao cadastrar matricula vazia");
		}catch(IllegalArgumentException iae) {}
	}

	@Test
	void cadastraAlunoNomeNull()
	{
		try
		{
			controle.cadastraAluno("123", null, "Computucao");
			fail("Era espelhado falha ao cadastrar nome null");
		}catch(NullPointerException npe) {}
	}
	
	@Test
	void cadastraAlunoNomeVazio()
	{
		try
		{
			controle.cadastraAluno("132", "", "Computucao");
			fail("Era esperado falha ao cadastrar nome vazio");
		}catch (IllegalArgumentException iae) {}
	}

	
	@Test
	void cadastraAlunoCursoNull()
	{
		try
		{
			controle.cadastraAluno("123", "Arthur", null);
			fail("Era espelhado falha ao cadastrar curso null");
		}catch(NullPointerException npe) {}
	}
	
	@Test
	void cadastraAlunoCursoVazio()
	{
		try
		{
			controle.cadastraAluno("123", "Arthur", "");
			fail("Era esperado falha ao cadastra curso vazio");
		}catch(IllegalArgumentException iae) {}
	}
	
	@Test
	void consultaAlunoTeste()
	{
		controle.cadastraAluno("123", "Arthur", "CC");
		assertTrue(controle.consultaAluno("123").equals("123 - Arthur - CC\n"));
	}
	
	@Test
	void cadastraGrupoTest()
	{
		assertTrue(controle.cadastraGrupo("Listas"));
		assertFalse((controle.cadastraGrupo("LISTAS")));
	}
	
	@Test
	void cadastraGrupoNomeNull()
	{
		try
		{
			controle.cadastraGrupo(null);
			fail("Era esperado falha ao cadatrar nomeGrupo null");
		}catch(NullPointerException npe) {}
	}
	
	@Test
	void cadastraGrupoNomeVazio()
	{
		try
		{
			controle.cadastraGrupo("");
		}catch(IllegalArgumentException iae) {}
	}
	
	@Test
	void alocaAlunoTest()
	{
		controle.cadastraAluno("123", "Art", "curso");
		controle.cadastraGrupo("Listas");
		assertTrue(controle.alocaAluno("123", "listas").equals("ALUNO ALOCADO!"));
	}
	
	@Test
	void imprimeGrupoTest()
	{
		controle.cadastraAluno("123", "Art", "curso");
		controle.cadastraGrupo("Listas");
		controle.alocaAluno("123", "listas");
		assertTrue(controle.imprimeGrupo("LISTAS").equals("Aluno do grupo listas:\n123 - Art - curso\n"));
	}
	
	@Test
	void imprimeGrupoInexistenteTest()
	{
		assertTrue(controle.imprimeGrupo("Nome").equals("Grupo nao cadastrado."));
	}
	
	@Test
	void cadastraAlunoRespondeTest()
	{
		controle.cadastraAluno("123", "Art", "curso");
		assertTrue(controle.cadastraAlunoResponde("123"));
		assertFalse(controle.cadastraAlunoResponde("1324"));
	}
	
	@Test
	void imprimeAlunoRespondeTest()
	{

		assertTrue(controle.imprimeAlunoResponde().equals(""));
		controle.cadastraAluno("123", "Art", "curso");
		controle.cadastraAlunoResponde("123");
		assertTrue(controle.imprimeAlunoResponde().equals("1. 123 - Art - curso\n"));
		
	}
	
}
