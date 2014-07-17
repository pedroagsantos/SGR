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
	
	public List<Atividade> recuperarAtividadesPendentes() {
		
		return depto.recuperarAtividadesPendentes();
	}
	
	public void aprovarAtividade(Atividade atividade) {
		
		Tecnico tecnicoResponsavel = (Tecnico) Usuario.recuperaUsuarioLogado();
		
		atividade.atribuirTecnicoResponsavel(tecnicoResponsavel);
		atividade.alocarRecursos();
		atividade.modificarStatus(Status.ALOCADO);	
	}
	
	
	public String recuperaCodigoAtivdade(){
    	return depto.recuperaCodigoAtivdade();
    }
}
