package model;
/**
 * Created by stark on 06/06/14.
 */
public class Usuario {

    protected String nome;
    protected String siape;
    protected String login;
    protected String senha;
    protected String email;
    protected int status;
    protected String telefone;

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
}
