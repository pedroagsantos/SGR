package model;


/**
 * Created by stark on 06/06/14.
 */
public abstract class Usuario {

    protected String nome;
    protected String siape;
    protected String login;
    protected String senha;
    protected String email;
    protected int status;
    protected String telefone;
    private static Usuario usrLogado;
    protected Departamento departamento;

    public String recuperarNome() {
        return nome;
    }

    public void modificarNome(String nome) {
        this.nome = nome;
    }

    public String recuperarSiape() {
        return siape;
    }

    public void modificarSiape(String siape) {
        this.siape = siape;
    }

    public int recuperarStatus() {
        return status;
    }

    public void modificarStatus(int status) {
        this.status = status;
    }

	public String recuperarEmail() {
		return email;
	}

	public void modificarEmail(String email) {
		this.email = email;
	}
	
	public String recuperarTelefone() {
        return telefone;
    }
	
	public void modificarTelefone(String tel) {
        this.telefone = tel;
    }
	
	public String recuperaSenha(){
		return this.senha;
	}
	
	public void insereSenha(String senha){
		this.senha = senha;
	}
	
	public static Usuario recuperaUsuarioLogado(){
		return usrLogado;
	}
	
	public static void setUsuarioLogado (Usuario logado){
		usrLogado = logado;
	}	
	
	public void modificarDepartamento(Departamento depto) {
		this.departamento = depto;
		
	}

	public Departamento recuperarDepartamento() {
		return departamento;
	}
	
}
