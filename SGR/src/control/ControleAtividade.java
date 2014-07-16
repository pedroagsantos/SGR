package control;

import java.util.List;

import model.Atividade;
import model.Departamento;
import model.TipoRecurso;
import model.Usuario;

public class ControleAtividade {
	
	private Departamento depto = Usuario.recuperaUsuarioLogado().recuperarDepartamento();

	public void inserir(Atividade atividade) {
		// TODO Auto-generated method stub
		depto.inserirAtividade(atividade);
	}
	
	public List<TipoRecurso> recuperaTipoRecurso(){
		return depto.listarTipoRecurso(new TipoRecurso(null));
	}
}
