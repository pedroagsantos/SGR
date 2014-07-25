package control;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Departamento;
import model.Professor;
import model.Recurso;
import model.Tecnico;
import model.TipoRecurso;
import model.Usuario;

public class ControleInstitucional {

	private Departamento depto = Usuario.recuperaUsuarioLogado().recuperarDepartamento();
	
	public void inserirProfessor(String nome, String siape, String email, String telefone, Departamento dept) {
		Professor professor = new Professor(nome, siape, email, telefone, dept);
		depto.inserirProfessor(professor);
		JOptionPane.showMessageDialog(null, "Inserido com Sucesso!", "Mensagem", JOptionPane.OK_OPTION);
	}

	public boolean alterar(Professor professor) {
		return depto.alterarProfessor(professor);
	}

	public void inserirTecnico(String nome, String siape, String email, String telefone, Departamento dept) {
		Tecnico tecnico = new Tecnico(nome, siape, email, telefone, dept);
		depto.inserirTecnico(tecnico);
		JOptionPane.showMessageDialog(null, "Inserido com Sucesso!", "Mensagem", JOptionPane.OK_OPTION);

	}

	

	public List<Usuario> buscarProfessor(String siape) {
		Professor parametro = new Professor(null, siape, null, null, null);
			return depto.listarProfessor(parametro); 
	}

	public void inserir(TipoRecurso tp) {
		depto.inserirTipoRecurso(tp);
		JOptionPane.showMessageDialog(null, "Inserido com Sucesso!", "Mensagem", JOptionPane.OK_OPTION);

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

	public List<Recurso> buscarRecurso(String descricao){
		List<Recurso> retorno = new ArrayList<Recurso>();
		if(descricao.equals("") || descricao == null)
			for (TipoRecurso tipoRec : depto.listarTipoRecurso(new TipoRecurso(null))) {
				retorno.addAll(tipoRec.listarRecursos());
			}
		else{
			for (TipoRecurso tipoRec : depto.listarTipoRecurso(new TipoRecurso(null))) {
				for (Recurso recurso : tipoRec.listarRecursos()) {
					if(recurso.recuperarDescricao().indexOf(descricao) > -1)
						retorno.add(recurso);
				}
			}
		}
		return retorno;
	}
}
