package model;
import java.util.ArrayList;
import java.util.List;

public class Departamento {
	
	
	private String nome;
	private String codDepto;

    private List<Atividade> atividades = new ArrayList<Atividade>();
    private List<TipoRecurso> tipoRecursos = new ArrayList<TipoRecurso>();
    private List<Usuario> usuarios = new ArrayList<Usuario>();

    
    public Departamento(String codDepto, String nome ) {
    	this.codDepto = codDepto;
    	this.nome = nome;
	}
    
    
    public void inserirTecnico(Tecnico tecnico){
    	
    	this.usuarios.add(tecnico);

    }
    
    public void inserirProfessor(Professor professor){
    	
    	this.usuarios.add(professor);
    }

    public void alterarTecnico(Tecnico tecnico){

            this.usuarios.add(tecnico);
    }
   
    public List<Usuario> listarUsuarios(){
    	
    	return this.usuarios;
    }
    

    public void alterarProfessor(Professor professor){

    	this.usuarios.add(professor);
    }

    public List<Usuario> listarTecnico(Tecnico tecnico){

        ArrayList<Usuario> listaRetorno = new ArrayList<Usuario>();
			if (tecnico.recuperarSiape().isEmpty()
					|| tecnico.recuperarSiape() == null){
				for (Usuario usuario : this.usuarios) {
					if(usuario instanceof Tecnico)
						listaRetorno.add(usuario);
				}
			}
			else {
				for (Usuario usuarios : this.usuarios) {
					if (usuarios instanceof Tecnico) {
						if (usuarios.recuperarSiape().indexOf(
								((Tecnico) usuarios).recuperarSiape()) > -1)
							listaRetorno.add(usuarios);
					}
				}
			}
			
        return listaRetorno;
    }

    public List<Usuario> listarProfessor(Professor professor){

        ArrayList<Usuario> listaRetorno = new ArrayList<Usuario>();
			if (professor.recuperarSiape().isEmpty()
					|| professor.recuperarSiape() == null){
				for (Usuario usuario : this.usuarios) {
					if(usuario instanceof Professor)
						listaRetorno.add(usuario);
				}
			}
			else {
				for (Usuario usuario : this.usuarios) {
					if (usuario instanceof Professor) {
						if (professor.recuperarSiape().indexOf(usuario.recuperarSiape()) > -1)
							listaRetorno.add(usuario);
					}
				}
			}

        return listaRetorno;
    }
    
    public void remover(Object object){


        if (object instanceof Tecnico || object instanceof Professor){

            Usuario usuario = (Usuario) object;

            usuario.modificarStatus(Status.DESABILITADO.valor());
        }

        else if (object instanceof TipoRecurso){

            TipoRecurso tipoRecurso = (TipoRecurso) object;

            tipoRecurso.modificaStatus(Status.DESABILITADO.valor());

        }

    }
 
    public void inserirTipoRecurso(TipoRecurso tipoRecurso){
    	
    	tipoRecursos.add(tipoRecurso);
    }
    
    public void alteraTipoRecurso(TipoRecurso tipoRecurso){

        this.tipoRecursos.add(tipoRecurso);
    }
    
    public List<TipoRecurso> listarTipoRecurso(TipoRecurso tipoRecurso){

        ArrayList<TipoRecurso> listaRetorno = new ArrayList<TipoRecurso>();

			if ( tipoRecurso.recuperarTipo() == null || tipoRecurso.recuperarTipo().isEmpty())
				listaRetorno.addAll(this.tipoRecursos);
			else {
				for (TipoRecurso tipoRecursos : this.tipoRecursos) {
					if (tipoRecursos.recuperarTipo().indexOf(
							tipoRecursos.recuperarTipo()) > -1)
						listaRetorno.add(tipoRecursos);
				}
			}

        return listaRetorno;
    }
   
    public void inserirAtividade(Atividade atividade){
    	
    	atividades.add(atividade);
    	
    }
    
    ///Terminar a implementação
    //public void inserirRecurso(Recurso re)
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return nome;
    }
    
    public String recuperaNome(){
    	return nome;
    }
    
    public String recuperarCodigo() {
    	return codDepto;
    }
    
    
    
}



