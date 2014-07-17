package control;

import java.util.ArrayList;
import java.util.Collection;
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

	public void inserir(String codigo, Professor prof, Tecnico tec, Collection<Recurso> recursosEscolhidos, Intervalo intervalo, Status status) {
		Atividade nova;	
		
		List<Recurso> recursos = new ArrayList<>();
		recursos.addAll(recursosEscolhidos);
		
		if(tec != null)
			nova = new Atividade(codigo, prof, tec, recursos, intervalo, Status.APROVADA);
		else
			nova = new Atividade(codigo, prof, tec, recursos, intervalo, Status.PENDENTE);
		depto.inserirAtividade(nova);
	}
	
	public List<TipoRecurso> recuperaTipoRecurso(String tipo){
		
		return depto.listarTipoRecurso(new TipoRecurso(tipo));
	}
	
	public void aprovarAtividade(Atividade atividade) {
		
		Tecnico tecnicoResponsavel = (Tecnico) Usuario.recuperaUsuarioLogado();
		
		atividade.atribuirTecnicoResponsavel(tecnicoResponsavel);
		atividade.alocarRecursos();
		atividade.modificarStatus(Status.ALOCADO);	
	}
	
	public List<Atividade> recuperarAtividades(Status status) {
		
		return depto.recuperarAtividades(status);
	}
	
	public List<Atividade> recuperarAtividades() {
		
		return depto.recuperarAtividades();
	}
	
	
	public String recuperaCodigoAtivdade(){
    	return depto.recuperaCodigoAtivdade();
    }

	public void reprovarAtividade(Atividade atividade) {
		
		Tecnico tecnicoResponsavel = (Tecnico) Usuario.recuperaUsuarioLogado();
		
		atividade.atribuirTecnicoResponsavel(tecnicoResponsavel);
		
		atividade.modificarStatus(Status.RECUSADA);
		
	}
	
	public void cancelarAtividade(Atividade atividade) {
		
		if (atividade.recuperarStatus() == Status.APROVADA)
			cancelarAlocacao(atividade);
		else
			atividade.modificarStatus(Status.CANCELADA);
		
	}
	
	public void cancelarAlocacao(Atividade atividade) {
		
		atividade.desalocarRecursos();
		
		atividade.modificarStatus(Status.CANCELADA);
		
	}

}
