package model;

/**
 * Created by stark on 06/06/14.
 */
public class Professor extends Usuario{

    //private HashMap<String, Atividade> hmAtividade;
    private Integer departamento;
	
	
	public Professor(String nome, String siape, String email, String telefone, Integer depto) {
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
	
	public Integer recuperarDepartamento() {
		return departamento;
	}
	
	public void modificarDepartamento(Integer depto) {
		this.departamento = depto;
	}
	
	
}
