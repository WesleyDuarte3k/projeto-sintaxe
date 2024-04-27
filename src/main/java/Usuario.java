
import java.util.ArrayList;

public class Usuario {
	private Integer id;
	private String nome;
	private String sobrenome;
	private String cpf;
	private Integer idade;
	private String numeroDeCelular;
	private int numeroDaConta;
	private String username;
	private String senha;
	private Double saldo = 100.00;
	public String agencia;

	ArrayList<Usuario> usuarios = new ArrayList<>();

	public Usuario(
		String username,
		String senha,
		String confirmacaoDeSenha,
		String agencia,
		String sobrenome,
		String cpf,
		String nacionalidade,
		int idade,
		String numeroDeCelular
		
	) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.setCpf(cpf);
		this.numeroDaConta = numeroDaConta;
		this.setIdade(idade);
		this.setNumeroDeCelular(numeroDeCelular);
		this.setUsername(username);
		this.setPassword(senha, confirmacaoDeSenha);
		this.saldo = 0.0;
	}

	public Usuario(String nomeDoNovoUsuario,
	               String senhaDoNovoUsuario,
	               String confimacaoSenhaDoNovoUsuario,
	               String agencia, String cpfCompleto,
	               int numeroDaConta,
	               int idade, String numeroDoCelular) {
	}

	public void setPassword(String senha, String confirmacaoDeSenha) {
		if (senhaIsValida(senha, confirmacaoDeSenha)) {
			this.senha = senha;
		} else {
			throw new RuntimeException("Senha invalida!");
		}
	}



	public String getUsername() {
		return username;
	}

	public String getSenha() {
		return senha;
	}

	public void depositaSaldo(Double saldo) {
		if (saldo <= 0) {
			throw new RuntimeException("Saldo a depositar nao pode ser menor ou igual ßa zero");
		}
		this.saldo += saldo;
	}

	public void setUsername(String username) {
		if (nomeDaContaIsValido(username)) {
			this.username = username;
		} else {
			throw new RuntimeException("Username invalido!");
		}
	}

	public void debitaSaldo(Double saldo) {
		if (saldo <= 0) {
			throw new RuntimeException("Saldo a debitar nao pode ser menor ou igual a zero");
		}
		this.saldo -= saldo;
	}

	@Override
	public String toString() {
		return "Id:" + this.id + ". Username: " + this.username + ". Password: " + this.senha + ". Saldo: " + this.saldo;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public Double getSaldo() {
		return this.saldo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		if (cpfIsValido(cpf)) {
			this.cpf = cpf;
		} else {
			throw new RuntimeException("CPF ivalido");
		}
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		if (this.idade > 18 && this.idade < 200) {
			this.idade = idade;
		} else {
			throw new RuntimeException("Idade nao permitida");
		}
	}

	public String getNumeroDeCelular() {
		return numeroDeCelular;
	}

	public void setNumeroDeCelular(String numeroDeCelular) {
		if (this.numeroDeCelularIsvalido(numeroDeCelular)) {
			this.numeroDeCelular = numeroDeCelular;
		} else {
			throw new RuntimeException("Numero de celular invalido");
		}
	}

	public Integer getNumeroDaConta() {
		return numeroDaConta;
	}

	public void setNumeroDaConta(Integer numeroDaConta) {
		this.numeroDaConta = numeroDaConta;
	}

	private boolean nomeDaContaIsValido(String nomeDaconta) {
		int tamanhoMinimoDoNome = 3;
		int tamanhoDoNomeDaConta = nomeDaconta.length();
		if (tamanhoDoNomeDaConta < tamanhoMinimoDoNome) {
			System.out.println("O nome deve ter no minimo 3 letras.");
			return false;
		}
		return true;
	}

	private boolean cpfIsValido(String cpfCompletoEmString) {
		String cpfComNoveDigitos = "";
		for (int i = 0; i < 9; i++) {
			String numeroAtualDoCpf = String.valueOf(cpfCompletoEmString.charAt(i));
			cpfComNoveDigitos += numeroAtualDoCpf;
		}
		String cpfComDezDigitos = obtemCpfComDigitoVerificador(cpfComNoveDigitos);
		String cpfComOnzeDigitos = obtemCpfComDigitoVerificador(cpfComDezDigitos);
		return cpfCompletoEmString.equals(cpfComOnzeDigitos);
	}

	public String obtemCpfComDigitoVerificador(String cpfComNoveDigitos) {
		int peso = cpfComNoveDigitos.length() + 1;
		char[] digitos = cpfComNoveDigitos.toCharArray();

		int somaDoDigitoMultiplicado = 0;
		for (char digito : digitos) {
			somaDoDigitoMultiplicado += Integer.parseInt(String.valueOf(digito)) * peso--;
		}
		int fatorMultiplicador = somaDoDigitoMultiplicado % 11;
		int digitoVerificador = (fatorMultiplicador >= 2) ? (11 - fatorMultiplicador) : 0;
		return cpfComNoveDigitos.concat(String.valueOf(digitoVerificador));
	}

	private boolean senhaIsValida(String senha, String confirmacaoDaSenha) {
		int tamanhoMinimoDaSenha = 3;
		if (senha.equals(confirmacaoDaSenha) && senha.length() > tamanhoMinimoDaSenha) {
			return true;
		}
		System.out.println("A senha precisa ser igual a confirmacao de senha e ter no minimo 4 digitos");
		return false;
	}

	private boolean numeroDeCelularIsvalido(String numeroDoCelular) {
		boolean numeroDoCelularIsValido = true;
		if (numeroDoCelular.length() != 11) {
			System.out.println("O numero digitado esta incorreto.");
			return false;
		}
		return numeroDoCelularIsValido;
	}

	public void exibePerfil(Usuario usuario) {
		System.out.println("");
		System.out.println("-------------------------------------------------");
		System.out.println("Bem vindo " + usuario.nome + " " + usuario.sobrenome);
		System.out.println("Login: " + usuario.username);
		System.out.println("Primeiro nome: " + usuario.nome);
		System.out.println("Ultimo nome: " + usuario.sobrenome);
		System.out.println("CPF: " + usuario.cpf);
		System.out.println("Numero da conta: " + numeroDaConta);
		System.out.println("Idade: " + usuario.idade);
		System.out.println("Celular: " + usuario.numeroDeCelular);
		System.out.println("-------------------------------------------------");
	}

	public void criaUsuario(Usuario usuario) {
		usuarios.add(usuario);
	}
}

