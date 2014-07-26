package control;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import org.joda.time.DateTime;

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

	public void inserir(String codigo, Professor prof, Tecnico tec, Collection<Recurso> recursosEscolhidos, Intervalo intervalo, Status status, DateTime date) {
		Atividade nova;	

		List<Recurso> recursos = new ArrayList<>();
		recursos.addAll(recursosEscolhidos);

		if(tec != null) {
			nova = new Atividade(codigo, prof, tec, recursos, intervalo, Status.PENDENTE, date);
			
			if(!avaliaAtividade(nova))
				return;
			else{
				aprovarAtividade(nova);	
				depto.inserirAtividade(nova);
			}
		}
		else{
			nova = new Atividade(codigo, prof, tec, recursos, intervalo, Status.PENDENTE, date);
			depto.inserirAtividade(nova);
			JOptionPane.showMessageDialog(null, "Solicitação feita com sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
		}
		
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
		JOptionPane.showMessageDialog(null, "Atividade Aprovada", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
	}

	public List<Atividade> recuperarAtividades(Status status) {
			verificaEmAndamento();
		return depto.recuperarAtividades(status);
	}
	
	private void verificaEmAndamento() {
		
		for(Atividade ativ: depto.recuperarAtividades())
			if(mesmaDataCorrente(ativ) && 
					ativ.recuperarStatus() == Status.APROVADA)
					ativ.modificarStatus(Status.EM_ANDAMENTO);
	}
	
	private Boolean mesmaDataCorrente(Atividade ativ) {
		
		DateTime dataAtividade = ativ.recuperaData();
		
		DateTime agora = new DateTime(DateTime.now());
		
		int horaDoDia = agora.getHourOfDay();
		int horaDoIntervalo = ativ.recuperaIntervalo().horaIntervalo();
		
		if (agora.getYear() !=  dataAtividade.getYear())
			return false;
		if (agora.getMonthOfYear() !=  dataAtividade.getMonthOfYear())
			return false;
		if (agora.getWeekOfWeekyear() !=  dataAtividade.getWeekOfWeekyear())
			return false;
		if (agora.getDayOfWeek() != dataAtividade.getDayOfWeek())
			return false;
		if (horaDoDia < horaDoIntervalo || horaDoDia > horaDoIntervalo + 2)
			return false; 
		
		return true;
			
	}
	
	public Intervalo[] recuperaViewIntervalos() {
		
		DateTime agora = new DateTime(DateTime.now());
		
		int horaDoDia = agora.getHourOfDay();
		
		ArrayList<Intervalo> intervaloList =  new ArrayList<>();
		
		for (Intervalo intervalo: Intervalo.values())
			if (horaDoDia < intervalo.horaIntervalo())
				intervaloList.add(intervalo);
		
		Intervalo[] vetorIntervalo = new Intervalo[intervaloList.size()];
		
		for(int i = 0; i < intervaloList.size(); i++){
			vetorIntervalo[i] =  intervaloList.get(i);
		}
		return vetorIntervalo;
	}

	/*private void verificaEmAndamento() {
		Date agora = new Date();
		SimpleDateFormat sdfmt = new SimpleDateFormat("ddMMyyyyHHmm");
		String agoraStr = sdfmt.format(agora);
		for(Atividade ativ: depto.recuperarAtividades()){
			String dataAtividadeStr = ativ.recuperaData().replaceAll("/", "") + ativ.recuperaIntervalo().toString().split("-")[0].trim().replaceAll(":", "");
			try {
				Date dataAtividade = sdfmt.parse(dataAtividadeStr);
				if(dataAtividade.compareTo(agora) > 0)
					ativ.modificarStatus(Status.EM_ANDAMENTO);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}*/
	
	public List<Atividade> recuperarAtividades(Status status, Usuario usuarioResponsavel) {

		verificaEmAndamento();
		return depto.recuperarAtividades(status, usuarioResponsavel);
	}

	public List<Atividade> recuperarAtividades() {

		verificaEmAndamento();
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
		JOptionPane.showMessageDialog(null, "Atividade Finalizada", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
	}

	public void cancelarAlocacao(Atividade atividade) {

		atividade.desalocarRecursos();

		atividade.modificarStatus(Status.CANCELADA);
		JOptionPane.showMessageDialog(null, "Atividade Cancelada", "Mensagem", JOptionPane.INFORMATION_MESSAGE);

	}

}
