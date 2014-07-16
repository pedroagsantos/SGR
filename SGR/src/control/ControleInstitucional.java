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

		Usuario prof = buscarProfessor(professor.recuperarSiape()).iterator().next();	
		if (prof !=null) {
			depto.remover(prof);
			depto.inserirProfessor(professor);
			return true;
		}

		return false;

	}

	public void inserirTecnico(String nome, String siape, String email, String telefone, Departamento dept) {
		Tecnico tecnico = new Tecnico(nome, siape, email, telefone, dept);
		depto.inserirTecnico(tecnico);

	}

	

	public List<Usuario> buscarProfessor(String siape) {
		// TODO Auto-generated method stub
		Professor parametro = new Professor(null, siape, null, null, null);
			return depto.listarProfessor(parametro); 
	}

	public void inserir(TipoRecurso tp) {
		//listaTipoRecurso.add(tp);
		depto.inserirTipoRecurso(tp);

	}

	public List<Usuario> buscarTecnico(String siape) {
		Tecnico procurado = new Tecnico(null, siape, null, null, null);
		/*for (Usuario tecnico : depto.listarTecnico(procurado)) {
			if (tecnico.recuperarSiape().equals(siape)) {
				return tecnico;
			}
		}*/
		return depto.listarTecnico(procurado);
	}

	public boolean alterar(Tecnico tecnico) {
		Usuario tec = buscarTecnico(tecnico.recuperarSiape()).iterator().next();	
		if (tec !=null) {
			depto.remover(tec);
			depto.inserirTecnico(tecnico);
			return true;
		}

		return false;
		
	}

	public List<TipoRecurso> buscarTipoRecurso(String tipo) {
		
		TipoRecurso parametro = new TipoRecurso(tipo);
		return depto.listarTipoRecurso(parametro);
		
	}

	public boolean alterar(TipoRecurso tipoRecurso) {
		TipoRecurso tp = buscarTipoRecurso(tipoRecurso.recuperarTipo()).iterator().next();	
		if (tp !=null) {
			depto.remover(tp);
			depto.inserirTipoRecurso(tipoRecurso);
			//listaProfessor.remove(prof);
			//listaProfessor.add(professor);
			return true;
		}

		return false;
		
	}

	
}
