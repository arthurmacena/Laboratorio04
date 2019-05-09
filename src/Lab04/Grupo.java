package Lab04;

import java.util.HashSet;

public class Grupo {

	/**
	 * Cria um conjunto relacionado de alunos.
	 */
	private HashSet<Aluno> alunos;
	
	/**
	 * O construtor inicializa o conjunto e verifica se o nome
	 * passado como parametro, e vazio ou nulo.
	 * @param nomeGrupo, e o nome do Grupo.
	 */
	public Grupo(String nomeGrupo) {
		if(nomeGrupo == null)
		{
			throw new NullPointerException("Nao era esperado nome do grupo nulo");
		}
		else if ("".equals(nomeGrupo.trim()))
		{
			throw new IllegalArgumentException("Nao se pode passar nome do grupo vazio");
		}
		
		this.alunos = new HashSet<>();
	}

	/**
	 * Adiciona os alunos, dentro do conjunto de Alunos.
	 * @param aluno
	 */
	public void addAluno(Aluno aluno) {
		this.alunos.add(aluno);
	}
	
	/**
	 * Um toString dos componentes do conjunto de alunos.
	 */
	@Override
	public String toString() {
		String saida = "Aluno do grupo listas:\n";
		for (Aluno aluno : this.alunos)
		{
			saida += aluno.toString();
		}
		return saida;
	}
}
