package control;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JOptionPane;

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

	public void inserir(String codigo, Professor prof, Tecnico tec, Collection<Recurso> recursosEscolhidos, Intervalo intervalo, Status status, String data) {
		Atividade nova;	

		List<Recurso> recursos = new ArrayList<>();
		recursos.addAll(recursosEscolhidos);

		if(tec != null) {
			nova = new Atividade(codigo, prof, tec, recursos, intervalo, Status.PENDENTE, data);
			if(!avaliaAtividade(nova))
				return;
			else
				aprovarAtividade(nova);
		}
		else
			nova = new Atividade(codigo, prof, tec, recursos, intervalo, Status.PENDENTE, data);
		depto.inserirAtividade(nova);
		JOptionPane.showConfirmDialog(null, "Inserido com Sucesso!", "Mensagem", JOptionPane.OK_OPTION);
	}

	private boolean avaliaAtividade(Atividade nova) {
		for (Atividade ativs : depto.recuperarAtividades()) {
			if((ativs.recuperaData().equals(nova.recuperaData())) && (ativs.recuperaIntervalo() == nova.recuperaIntervalo())){
				for (TipoRecurso tipoRecurso : recuperaTipoRecurso("") ) {
					for (Recurso recurso2 : tipoRecurso.listarRecursos()) {
						if(recurso2.recuperarStatusRecurso() != Status.DISPONIVEL) {
							JOptionPane.showMessageDialog(null, "Recurso " + recurso2.recuperarDescricao() +" nao esta disponivel", "Operacao negada", JOptionPane.ERROR_MESSAGE);
							return false;

						}
					}

				}
			}
		}
		return true;
	}

	public List<TipoRecurso> recuperaTipoRecurso(String tipo){

		return depto.listarTipoRecurso(new TipoRecurso(tipo));
	}

	public List<Atividade> recuperarAtividadesPendentes() {

		return depto.recuperarAtividades();
	}

	public void aprovarAtividade(Atividade atividade) {

		Tecnico tecnicoResponsavel = (Tecnico) Usuario.recuperaUsuarioLogado();

		atividade.atribuirTecnicoResponsavel(tecnicoResponsavel);
		atividade.alocarRecursos();
		atividade.modificarStatus(Status.APROVADA);	
	}

	public List<Atividade> recuperarAtividades(Status status) {

		return depto.recuperarAtividades(status);
	}
	
	public List<Atividade> recuperarAtividades(Status status, Usuario usuarioResponsavel) {

		
		return depto.recuperarAtividades(status, usuarioResponsavel);
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
			this.cancelarAlocacao(atividade);
		else
			atividade.modificarStatus(Status.CANCELADA);

	}
	
	public void finalizarAtividade(Atividade atividade) {
		
		atividade.desalocarRecursos();
		
		atividade.modificarStatus(Status.FINALIZADA);
		
	}

	public void cancelarAlocacao(Atividade atividade) {

		atividade.desalocarRecursos();

		atividade.modificarStatus(Status.CANCELADA);

	}

}
