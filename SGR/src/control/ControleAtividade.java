package control;

import java.util.List;

import model.Atividade;
import model.TipoRecurso;

public class ControleAtividade {

	public void inserir(Atividade atividade) {
		// TODO Auto-generated method stub
		ControleInstitucional.depto.inserirAtividade(atividade);
		System.out.println(atividade);
	}
	
	public List<TipoRecurso> recuperaTipoRecurso(){
		ControleInstitucional.depto.retornaMapaTipoRecurso()
	}
}
