package control;

import java.util.ArrayList;
import java.util.HashMap;

import model.Departamento;
import model.Professor;
import model.Tecnico;
import model.TipoRecurso;

public class ControleInstitucional {

	public void inserir(Professor professor) {

		/*if (buscarProfessor(professor.recuperarSiape()) != null) {
			
			return false;			
		}*/
		depto.inserirProfessor(professor);
		
		//listaProfessor.add(professor);
		//return true;

	}

	public boolean alterar(Professor professor) {

		Professor prof = buscarProfessor(professor.recuperarSiape());	
		if (prof !=null) {
			depto.remover(prof);
			depto.inserir(professor);
			//listaProfessor.remove(prof);
			//listaProfessor.add(professor);
			return true;
		}

		return false;

	}

	public void inserir(Tecnico tecnico) {
		//listaTecnico.add(tecnico);
		depto.inserirTecnico(tecnico);

	}

	

	public Professor buscarProfessor(String siape) {
		// TODO Auto-generated method stub
		for (Professor professor : depto.retornaMapaProfessor().values()) {
			if (professor.recuperarSiape().equals(siape)) {
				return professor;
			}
		}
		return null;
	}

	public void inserir(TipoRecurso tp) {
		//listaTipoRecurso.add(tp);
		depto.inserirTipoRecurso(tp);

	}

	public HashMap<String, Professor> getListaProfessor() {
		return depto.retornaMapaProfessor();
	}
	
	public HashMap<String, Tecnico> getListaTecnico() {
		return depto.retornaMapaTecnico();
	}
	
	public HashMap<String, TipoRecurso> getListaTipoRecurso() {
		return depto.retornaMapaTipoRecurso();
	}

	public Tecnico buscarTecnico(String siape) {
		for (Tecnico tecnico : depto.retornaMapaTecnico().values()) {
			if (tecnico.recuperarSiape().equals(siape)) {
				return tecnico;
			}
		}
		return null;
	}

	public boolean alterar(Tecnico tecnico) {
		Tecnico tec = buscarTecnico(tecnico.recuperarSiape());	
		if (tec !=null) {
			depto.remover(tec);
			depto.inserir(tecnico);
			//listaProfessor.remove(prof);
			//listaProfessor.add(professor);
			return true;
		}

		return false;
		
	}

	public TipoRecurso buscarTipoRecurso(String tipo) {
		
		for (TipoRecurso tipoRecurso : depto.retornaMapaTipoRecurso().values()) {
			if (tipoRecurso.recuperarTipo().equals(tipo)) {
				return tipoRecurso;
			}
		}
		return null;
		
	}

	public boolean alterar(TipoRecurso tipoRecurso) {
		TipoRecurso tp = buscarTipoRecurso(tipoRecurso.recuperarTipo());	
		if (tp !=null) {
			depto.remover(tp);
			depto.inserir(tipoRecurso);
			//listaProfessor.remove(prof);
			//listaProfessor.add(professor);
			return true;
		}

		return false;
		
	}

	
}
