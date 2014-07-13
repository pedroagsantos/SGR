package model;

/**
 * Created by stark on 06/06/14.
 */
public class Tecnico extends Usuario {

    
    public Tecnico(String nome, String siape, String email, String telefone, Departamento depto) {
		// TODO Auto-generated constructor stub
		this.nome = nome;
		this.siape = siape;
		this.email = email;
		this.telefone = telefone;
		this.departamento = depto;
		
	}
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return nome;
    }

	public void modificarDepartamento(Departamento depto) {
		this.departamento = depto;
		
	}

	public Departamento recuperarDepartamento() {
		return departamento;
	}
}
