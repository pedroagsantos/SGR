package model;
import java.util.HashMap;

/**
 * Created by stark on 06/06/14.
 */
public class Tecnico extends Usuario {

    //private HashMap<String, Atividade> hmAtividade;
    private Integer departamento;
    
    public Tecnico(String nome, String siape, String email, String telefone, Integer depto) {
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

	public void modificarDepartamento(int depto) {
		this.departamento = depto;
		
	}

	public Integer recuperarDepartamento() {
		return departamento;
	}
}
