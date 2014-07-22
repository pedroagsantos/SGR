package model;
import java.util.ArrayList;
import java.util.List;

public class Departamento {
	
	
	private String nome;
	private String codDepto;
	private Integer nextCodAtividade = 0;
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

    public boolean alterarTecnico(Tecnico tecnico){
    	Usuario tec = listarTecnico(tecnico).iterator().next();	
		if (tec !=null) {
			remover(tec);
			inserirTecnico(tecnico);
			return true;
		}

		return false;
    }
   
    public List<Usuario> listarUsuarios(){
    	
    	return this.usuarios;
    }
    

    public boolean alterarProfessor(Professor professor){
    	Usuario prof = listarProfessor(professor).iterator().next();	
		if (prof !=null) {
			remover(prof);
			inserirProfessor(professor);
			return true;
		}
		return false;
    }

    public List<Usuario> listarTecnico(Tecnico tecnico){

        ArrayList<Usuario> listaRetorno = new ArrayList<Usuario>();
			if (tecnico.recuperarSiape().isEmpty()
					|| tecnico.recuperarSiape() == null){
				for (Usuario usuario : this.usuarios) {
					if(usuario instanceof Tecnico  && 
							usuario.recuperarStatus() != Status.DESABILITADO.valor())
						listaRetorno.add(usuario);
				}
			}
			else {
				for (Usuario usuario : this.usuarios) {
					if (usuario instanceof Tecnico) {
						if (usuario.recuperarSiape().indexOf(usuario.recuperarSiape()) > -1  && 
								usuario.recuperarStatus() != Status.DESABILITADO.valor())
							listaRetorno.add(usuario);
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
					if(usuario instanceof Professor && 
							usuario.recuperarStatus() != Status.DESABILITADO.valor())
						listaRetorno.add(usuario);
				}
			}
			else {
				for (Usuario usuario : this.usuarios) {
					if (usuario instanceof Professor) {
						if (professor.recuperarSiape().indexOf(usuario.recuperarSiape()) > -1 && 
								usuario.recuperarStatus() != Status.DESABILITADO.valor())
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

            tipoRecurso.modificaStatus(Status.DESABILITADO);

        }

    }
 
    public void inserirTipoRecurso(TipoRecurso tipoRecurso){
    	
    	tipoRecursos.add(tipoRecurso);
    }
    
    public boolean alteraTipoRecurso(TipoRecurso tipoRecurso){
    	TipoRecurso tp = listarTipoRecurso(tipoRecurso).iterator().next();	
		if (tp !=null) {
			remover(tp);
			inserirTipoRecurso(tipoRecurso);
			return true;
		}

		return false;
		
    }
    
    public List<TipoRecurso> listarTipoRecurso(TipoRecurso tipoRecurso){

        ArrayList<TipoRecurso> listaRetorno = new ArrayList<TipoRecurso>();

			if ( tipoRecurso.recuperarTipo() == null || tipoRecurso.recuperarTipo().isEmpty()){
				for (TipoRecurso tipoRec : this.tipoRecursos) {
					if(tipoRec.recuperaStatus() != Status.DESABILITADO)
						listaRetorno.add(tipoRec);;
				}
			}
			else {
				for (TipoRecurso tipoRec : this.tipoRecursos) {
					if (tipoRec.recuperarTipo().indexOf(
							tipoRec.recuperarTipo()) > -1 && tipoRec.recuperaStatus() != Status.DESABILITADO)
						listaRetorno.add(tipoRec);
				}
			}

        return listaRetorno;
    }
    
    public List<Atividade> recuperarAtividades(Status status, Usuario usuarioResponsavel){

        ArrayList<Atividade> listaRetorno = new ArrayList<Atividade>();

		for (Atividade atividade : atividades) {
			
			if(atividade.recuperarStatus() == status && 
			atividade.verificarUsuarioResponsavel(usuarioResponsavel))
				listaRetorno.add(atividade);
		}

        return listaRetorno;
    }
    
    public List<Atividade> recuperarAtividades(Status status){

        ArrayList<Atividade> listaRetorno = new ArrayList<Atividade>();

		for (Atividade atividade : atividades) {
			
			if(atividade.recuperarStatus() == status)
				
				listaRetorno.add(atividade);
		}

        return listaRetorno;
    }
    
    public List<Atividade> recuperarAtividades(){

    	return this.atividades;
    }
    
    public void inserirAtividade(Atividade atividade){
    	
    	atividades.add(atividade);
    	nextCodAtividade++;
    	
    }
    
    public String recuperaCodigoAtivdade(){
    	return String.valueOf(nextCodAtividade);
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



