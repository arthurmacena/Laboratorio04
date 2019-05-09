package Lab04;

import java.util.ArrayList;
import java.util.HashMap;

public class Sistema {
	/**
	 * Cria um mapa relacionando uma String com Aluno.
	 */
	private HashMap<String, Aluno> mapaAluno;
	/**
	 * Cria um mapa relacionando uma String com Grupo.
	 */
	private HashMap<String, Grupo> mapaGrupo;
	/**
	 * Cria um arrayList de Strings.
	 */
	private ArrayList<String> respostaAluno;
	
	/**
	 * O construtor inicializa os mapas e o arrayList.
	 */
	public Sistema()
	{
		this.mapaAluno = new HashMap<>();
		this.mapaGrupo = new HashMap<>();
		this.respostaAluno = new ArrayList<>();
	}
	/**
	 * Relaciona o mapaAluno, da matricula do Aluno
	 * e criando o Aluno.
	 * 
	 * @param matricula,  e a matricula do Aluno.
	 * @param nome,  e o nome do Aluno.
	 * @param curso, e o nome do curso.
	 * @return true ou falso, se o cadastro foi com sucesso ou nao.
	 */
	public boolean cadastraAluno(String matricula, String nome, String curso) {
		if (mapaAluno.containsKey(matricula))
		{
			return false;
		}
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
		this.mapaAluno.put(matricula, new Aluno(matricula, nome, curso));
		return true;
	}
	/**
	 * Exibe o Aluno consultado, se ele existir.
	 * @param matricula, e a matricula do aluno.
	 * @return String, se ele existe os dados do aluno
	 * se nao existe que o aluno nao foi cadastrado.
	 */
	public String consultaAluno(String matricula) {
		if(mapaAluno.containsKey(matricula))
		{
			return this.mapaAluno.get(matricula).toString();
		}
		else
		{
			String saida = "Aluno ainda nao cadastrado.";
			return saida;
		}
		
	}
	/**
	 * Relaciona o mapaGrupo com nome do grupo, com o novo grupo criado.
	 * @param nomeGrupo1, e o nome do grupo.
	 * @return true ou false, se o grupo foi criado com sucesso ou nao.
	 */
	public boolean cadastraGrupo(String nomeGrupo1) {
		String nomeGrupo = nomeGrupo1.toLowerCase();
		if (this.mapaGrupo.containsKey(nomeGrupo))
		{
			return false;
		}
		if(nomeGrupo == null)
		{
			throw new NullPointerException("Nao era esperado nome do grupo nulo");
		}
		else if ("".equals(nomeGrupo.trim()))
		{
			throw new IllegalArgumentException("Nao se pode passar nome do grupo vazio");
		}
		this.mapaGrupo.put(nomeGrupo,new Grupo(nomeGrupo));
		return true;
	}
	/**
	 * Aloca o aluno ja cadastrado a um grupo ja cadastrado.
	 * @param matricula, e a matricula do aluno.
	 * @param nomeGrupo1, e o nome do grupo.
	 * @return Uma string se o aluno foi alocado, ou se o grupo
	 * ou o aluno nao foi cadastrado.
	 */
	public String alocaAluno(String matricula, String nomeGrupo1) {
		String nomeGrupo = nomeGrupo1.toLowerCase();
		if (this.mapaAluno.containsKey(matricula) && this.mapaGrupo.containsKey(nomeGrupo))
		{
			this.mapaGrupo.get(nomeGrupo).addAluno(mapaAluno.get(matricula));
			return "ALUNO ALOCADO!";
		}
		else
		{
			if (!this.mapaAluno.containsKey(matricula))
				return "Aluno nao cadastrado";
			else 
				return "Grupo nao cadastrado";
		}
	}
	/**
	 * Imprime os alunos de um grupo.
	 * @param nomeGrupo1, e o nome do grupo.
	 * @return Uma String, com os alunos ou se o grupo nao foi
	 * cadastrado.
	 */
	public String imprimeGrupo(String nomeGrupo1) {
		String nomeGrupo = nomeGrupo1.toLowerCase();
		if (this.mapaGrupo.containsKey(nomeGrupo))
		{
			return this.mapaGrupo.get(nomeGrupo).toString();
		}
		return "Grupo nao cadastrado.";
	}
	/**
	 * Cadastra o aluno que responde.
	 * @param matricula, e a matricula do aluno.
	 * @return Um boolean, se o aluno foi cadastrado ou nao.
	 */
	public boolean cadastraAlunoResponde(String matricula)
	{
		if (this.mapaAluno.containsKey(matricula))
		{
			this.respostaAluno.add(this.mapaAluno.get(matricula).toString());
			return true;
		}
		return false;
	}
	/**
	 * imprime os alunos que responderam.
	 * @return Uma String, da ordem dos alunos que responderam.
	 */
	public String imprimeAlunoResponde()
	{
		String saida = "";
		for (int i =0; i<this.respostaAluno.size();i++)
		{
			saida += i+1 + ". " + this.respostaAluno.get(i);
		}
		return saida;
	}
	
}
