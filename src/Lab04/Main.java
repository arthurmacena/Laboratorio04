package Lab04;


import java.util.Scanner;

public class Main {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		Sistema controle = new Sistema();
		do
		{
			String opcao;
			menu();
			opcao = opcao(sc);
			if (opcao.equals("C"))
			{
				cadastro(sc, controle);
			}
			else if(opcao.equals("E"))
			{
				exibir(sc, controle);
			}
			else if(opcao.equals("N"))
			{
				novo(sc, controle);
			}
			else if (opcao.equals("A"))
			{
				alocar(sc, controle);
			}
			else if (opcao.equals("R"))
			{
				registrar(sc, controle);
			}
			else if (opcao.equals("I"))
			{
				imprimir(sc, controle);
			}
			else if (opcao.equals("O"))
			{
				break;
			}
			else
			{
				System.out.println("Opcao nao realizada corretamente!");
			}
		}while(true);
	}
	
	public static void menu ()
	{
		System.out.println("(C)adastrar Aluno");
		System.out.println("(E)xibir Aluno");
		System.out.println("(N)ovo Grupo");
		System.out.println("(A)locar Aluno no Grupo e Imprimir Grupos");
		System.out.println("(R)egistrar Aluno que Respondeu");
		System.out.println("(I)mprimir Alunos que Responderam");
		System.out.println("(O)ra, vamos fechar o programa!");
	}
	
	public static String opcao(Scanner sc)
	{
		System.out.println();
		System.out.println("Opção> ");
		String opcao = sc.nextLine();
		return opcao;
	}
	
	public static void cadastro (Scanner sc, Sistema controle)
	{
		System.out.printf("Matricula: ");
		String matricula = sc.nextLine();
		System.out.printf("Nome: ");
		String nome = sc.nextLine();
		System.out.printf("Curso: ");
		String curso = sc.nextLine();
		if (!controle.cadastraAluno(matricula, nome, curso))
		{
			System.out.println("MATRICULA JA CADASTRADA!");
		}
		else
			System.out.println("CADASTRO REALIZADO!");
	}
	
	public static void exibir (Scanner sc, Sistema controle)
	{
		System.out.printf("Matricula: ");
		String matricula = sc.nextLine();
		System.out.println(controle.consultaAluno(matricula));
		
	}
	
	public static void novo(Scanner sc, Sistema controle)
	{
		System.out.printf("Grupo: ");
		String nomeGrupo = sc.nextLine();
		if(!controle.cadastraGrupo(nomeGrupo))
		{
			System.out.println("GRUPO JA CADASTRADO!");
		}
		else System.out.println("CADASTRO REALIZADO");
		
	}
	
	public static void alocar(Scanner sc, Sistema controle)
	{
		System.out.printf("(A)locar Aluno ou (I)mprimir Grupo? ");
		String entrada = sc.nextLine();
		if (entrada.equals("A"))
		{
			System.out.printf("Matricula: ");
			String matricula = sc.nextLine();
			System.out.printf("Grupo: ");
			String nomeGrupo = sc.nextLine();
			System.out.println(controle.alocaAluno(matricula, nomeGrupo));
		}
		else
		{
			System.out.printf("Grupo: ");
			String nomeGrupo = sc.nextLine();
			System.out.println();
			System.out.println(controle.imprimeGrupo(nomeGrupo));
		}
	}
	public static void registrar(Scanner sc, Sistema controle)
	{
		System.out.printf("Matricula: ");
		String matricula = sc.nextLine();
		if (controle.cadastraAlunoResponde(matricula))
		{
			System.out.println("ALUNO REGISTRADO!");
		}
		else
			System.out.println("ALUNO NAO CADASTRADO!");
	}
	
	public static void imprimir(Scanner sc, Sistema controle)
	{
		System.out.println("Alunos: ");
		System.out.println(controle.imprimeAlunoResponde());
	}
}
