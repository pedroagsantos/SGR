package control;

import java.util.List;

import model.Departamento;
import model.Professor;
import model.Tecnico;
import model.TipoRecurso;
import model.Usuario;

public class ControleInstitucional {

	private Departamento depto = Usuario.recuperaUsuarioLogado().recuperarDepartamento();
	
	public void inserirProfessor(String nome, String siape, String email, String telefone, Departamento dept) {
		Professor professor = new Professor(nome, siape, email, telefone, dept);
		depto.inserirProfessor(professor);
	}

	public boolean alterar(Professor professor) {
		return depto.alterarProfessor(professor);
	}

	public void inserirTecnico(String nome, String siape, String email, String telefone, Departamento dept) {
		Tecnico tecnico = new Tecnico(nome, siape, email, telefone, dept);
		depto.inserirTecnico(tecnico);

	}

	

	public List<Usuario> buscarProfessor(String siape) {
		Professor parametro = new Professor(null, siape, null, null, null);
			return depto.listarProfessor(parametro); 
	}

	public void inserir(TipoRecurso tp) {
		depto.inserirTipoRecurso(tp);

	}

	public List<Usuario> buscarTecnico(String siape) {
		Tecnico procurado = new Tecnico(null, siape, null, null, null);
		return depto.listarTecnico(procurado);
	}

	public boolean alterar(Tecnico tecnico) {
		 return depto.alterarTecnico(tecnico);	
	}

	public List<TipoRecurso> buscarTipoRecurso(String tipo) {
		
		TipoRecurso parametro = new TipoRecurso(tipo);
		return depto.listarTipoRecurso(parametro);
		
	}

	public boolean alterar(TipoRecurso tipoRecurso) {
		return depto.alteraTipoRecurso(tipoRecurso);
	}

	
}
