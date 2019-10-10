package Lab04;

public class Aluno {

	/**
	 * Cria uma variavel para armazenar o nome do curso
	 */
	private String curso;
	/**
	 * Variavel para armazenar o nome do aluno.
	 */
	private String nome;
	/**
	 * Variavel para armazenar a matricula do aluno.
	 */
	private String matricula;
	
	/**
	 * O construtor constroi a classe a partir da verificacao
	 * dos parametros, se eles sao diferentes de null ou vazio. 
	 * @param matricula, e a matricula do aluno.
	 * @param nome, e o nome do aluno.
	 * @param curso, e o nome do curso.
	 */
	public Aluno(String matricula, String nome, String curso) {
		if(matricula == null)
		{
			throw new NullPointerException("Nao era esperado matricula nula");
		}
		else if("".equals(matricula.trim()))
		{
			throw new IllegalArgumentException("Nao pode se passar matricula vazia");
		}
		if(nome == null)
		{
			throw new NullPointerException("Nao era esperado nome nulo");
		}
		else if ("".equals(nome.trim()))
		{
			throw new IllegalArgumentException("Nao se pode passar nome vazio");
		}
		if (curso == null)
		{
			throw new NullPointerException("Nao era esperado curso nulo");
		}
		else if ("".equals(curso.trim()))
		{
			throw new IllegalArgumentException("Nao se pode passar curso vazio");
		}
		this.matricula = matricula;
		this.nome = nome;
		this.curso = curso;
	}
	/**
	 * Um toString dos componentes de aluno,
	 */
	@Override
	public String toString() {
		String saida = "";
		saida = this.matricula + " - " + this.nome + " - " + this.curso + "\n"; 
		return saida;
	}

}
