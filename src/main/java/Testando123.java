import java.util.ArrayList;
import java.util.Scanner;

public class Testando123 {
	private static final int ENCERRAMENTO_DO_APP = 0;
	private static final int CRIACAO_DE_CONTA = 1;
	private static final int DEPOSITO = 2;
	private static final int SAQUE = 3;
	private static final int EXIBIR_SALDO = 4;



	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<Usuario> usuarios = new ArrayList<>();

		int opcaoEscolhida = acionaMenuDeslogado();

		while (opcaoEscolhida != ENCERRAMENTO_DO_APP) {
			if (opcaoEscolhida == CRIACAO_DE_CONTA) {
				Usuario usuario = criaConta(scanner, usuarios);
				if (opcaoEscolhida == DEPOSITO){
					deposita(scanner, usuario);
				}
				opcaoEscolhida = acionaMenuLogado(usuario);

				if (opcaoEscolhida == DEPOSITO){
					deposita(scanner, usuario);
				}
				opcaoEscolhida = acionaMenuLogado(usuario);

				if (opcaoEscolhida == SAQUE){
					saca(usuario, scanner);
				}
				opcaoEscolhida = acionaMenuLogado(usuario);

				if (opcaoEscolhida == EXIBIR_SALDO){
					consultaSaldo(usuario, scanner);
				}
				opcaoEscolhida = acionaMenuLogado(usuario);
			}
		}

	}

	public static Usuario criaConta(Scanner scanner, ArrayList usuarios) {
		System.out.println("Digite um nome de usuario com no minimo 3 letras: ");
		String nomeDoNovoUsuario = scanner.nextLine();

		System.out.println("Digite uma senha com no minimo 3 caracteres : ");
		String senhaDoNovoUsuario = scanner.nextLine();

		System.out.println("Digite o valor inicial a ser depositado: ");
		String valorDoDepositoEmString = scanner.nextLine();
		Double valorDoDeposito = Double.parseDouble(valorDoDepositoEmString);

		if (valorDoDeposito <= 0) {
			System.out.println("valor invalido");
		}

		Usuario usuario = new Usuario(nomeDoNovoUsuario, senhaDoNovoUsuario, valorDoDeposito);

		usuarios.add(usuario);
		return usuario;
	}


	public static class Usuario {
		private String nome;
		private String senha;
		private double saldo;

		public Usuario(String nomeDoNovoUsuario, String senhaDoNovoUsuario, Double valorDoDeposito) {
		}

		public void setNome(String nome) {
			if (nome.length() >= 3) {
				this.nome = nome;
			} else {
				System.out.println("Nome muito curto");
			}
		}

		public void setSenha(String senha) {
			if (senha.length() >= 3) {
				this.senha = senha;
			} else {
				System.out.println("Senha muito curta");
			}
		}

		public void setSaldo(double saldo) {
			this.saldo = saldo;
		}

		public String getNome() {
			return nome;
		}

		public String getSenha() {
			return senha;
		}

		public double getSaldo() {
			return saldo;
		}
	}

	public static void deposita(Scanner scanner, Usuario usuario) {
		if (senhaIsValida(usuario, scanner)) {
			System.out.println("Digite o valor do deposito: ");
			double valorDoDeposito = scanner.nextDouble();

			if (valorDoDeposito > 0) {
				usuario.setSaldo(usuario.getSaldo() + valorDoDeposito);
			} else {
				System.out.println("Valor invalido");
			}
		}
	}

	public static void saca(Usuario usuario, Scanner scanner) {
		if (senhaIsValida(usuario, scanner)) {

			System.out.println("Digite o valor do saque: ");
			double valorDoSaque = scanner.nextDouble();

			if (valorDoSaque <= usuario.getSaldo() && valorDoSaque > 0) {

				System.out.println("Contando as notas...");

				usuario.setSaldo(usuario.getSaldo() - valorDoSaque);

				System.out.println("Saque realizado!");
			} else {
				System.out.println("Saque invalido");
			}
		}
	}

	public static void consultaSaldo(Usuario usuario, Scanner scanner){
		if (senhaIsValida(usuario, scanner)){
			System.out.println("Seu saldo é: " + usuario.getSaldo());
		}
	}

	public static boolean senhaIsValida(Usuario usuario, Scanner scanner) {
		System.out.println("confime sua senha");
		String senha = scanner.nextLine();

		if (usuario.getSenha().equals(senha)) {
			return true;
		}
		return false;
	}

	public static Integer acionaMenuLogado(Usuario usuario) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("-------------------------------------------------");
		System.out.println("Bem vindo " + usuario.getNome() +"!");
		System.out.println("O que deseja fazer?");
		System.out.println("    0. Encerrar");
		System.out.println("    2. Depositar");
		System.out.println("    3. Sacar");
		System.out.println("    4. Exibir saldo");

		System.out.print("Opção escolhida: ");
		int opcaoEscolhida = scanner.nextInt();
		System.out.println("-------------------------------------------------");
		System.out.println("");
		return opcaoEscolhida;
	}

	public static Integer acionaMenuDeslogado() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("-------------------------------------------------");
		System.out.println("Bem vindo!");
		System.out.println("O que deseja fazer?");
		System.out.println("    0. Encerrar");
		System.out.println("    1. Criar conta");
		System.out.print("Opção escolhida: ");
		int opcaoEscolhida = scanner.nextInt();
		System.out.println("-------------------------------------------------");
		System.out.println("");
		return opcaoEscolhida;
	}

}


