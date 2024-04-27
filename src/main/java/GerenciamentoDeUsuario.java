
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class GerenciamentoDeUsuario {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		criaConta();



	}


	public static Usuario criaConta() {
		Scanner scanner = new Scanner(System.in);

		Usuario usuario = null;

		System.out.println("Digite um nome de usuario: ");
		String nomeDoNovoUsuario = scanner.nextLine();

		System.out.println("Digite uma senha: ");
		String senhaDoNovoUsuario = scanner.nextLine();

		System.out.println("Confirme a senha digitada: ");
		String confimacaoSenhaDoNovoUsuario = scanner.nextLine();

		System.out.println("Digite o numero da sua agencia: ");
		String agencia = scanner.nextLine();

		System.out.println("Digite seu cpf completo (So os numeros):");
		String cpfCompleto = scanner.nextLine();

		System.out.println("Digite o numero da conta: ");
		String numeroDaContaEmString = scanner.nextLine();
		int numeroDaConta = Integer.parseInt(numeroDaContaEmString);

		System.out.println("Digite sua idade: ");
		String idadeEmString = scanner.nextLine();
		int idade = Integer.parseInt(idadeEmString);

		System.out.println("Digite o numero do seu celular (so os numeros):");
		String numeroDoCelular = scanner.nextLine();
		try {
			usuario = new Usuario(
				nomeDoNovoUsuario,
				senhaDoNovoUsuario,
				confimacaoSenhaDoNovoUsuario,
				agencia,
				cpfCompleto,
				numeroDaConta,
				idade,
				numeroDoCelular
			);
		} catch (RuntimeException exception) {
			System.out.println("Erro ao criar usuario! " + exception.getMessage());
			return null;
		}

		usuario.criaUsuario(usuario);
		System.out.println("Usuario criado!");
		System.out.println("Olá, " + usuario.getUsername() + "obrigado por criar uma conta em nosso sistema, sua agencia" +
			" é: " + agencia + "conta: " + usuario.getUsername() + ". Seu saldo já " + usuario.getSaldo() + " está disponivel para saque");

		return usuario;
	}

}
