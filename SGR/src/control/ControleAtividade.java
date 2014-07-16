package control;

import java.util.List;

import model.Atividade;
import model.Departamento;
import model.Intervalo;
import model.Professor;
import model.Recurso;
import model.Status;
import model.Tecnico;
import model.TipoRecurso;
import model.Usuario;

public class ControleAtividade {
	
	private Departamento depto = Usuario.recuperaUsuarioLogado().recuperarDepartamento();

	public void inserir(String codigo, Professor prof, Tecnico tec, List<Recurso> recursos, Intervalo intervalo, Status status) {
		Atividade nova;	
		if(tec != null)
			nova = new Atividade(codigo, prof, tec, recursos, intervalo, Status.APROVADA);
		else
			nova = new Atividade(codigo, prof, tec, recursos, intervalo, Status.PENDENTE);
		depto.inserirAtividade(nova);
	}
	
	public List<TipoRecurso> recuperaTipoRecurso(String tipo){
		return depto.listarTipoRecurso(new TipoRecurso(tipo));
	}
}
