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
    
    
    public void inserir(Object object){

        if (object instanceof Tecnico || object instanceof Professor) {

            Usuario usuario = (Usuario) object;

            usuarios.add(usuario);
        }


        else if (object instanceof TipoRecurso) {

            TipoRecurso tipoRecurso = (TipoRecurso) object;

            tipoRecursos.add(tipoRecurso);

        }

        else if (object instanceof TipoRecurso) {

            Atividade atividade = (Atividade) object;

            atividades.add(atividade);

        }
                
        else{
        	throw new RuntimeException("Tipo nao Esperado");
        }

    }

    public void alterar(Object object){
    	
        if (object instanceof Tecnico || object instanceof Professor){

            Usuario usuario = (Usuario) object;

            usuarios.add(usuario);
        }

        else if(object instanceof TipoRecurso){

            TipoRecurso tipoRecurso = (TipoRecurso) object;

            tipoRecursos.add(tipoRecurso);

        }

        else if (object instanceof TipoRecurso){

            Atividade atividade = (Atividade) object;

            atividades.add(atividade);

        }

    }

    public List<Object> listar(Object object){

        ArrayList<Object> listaRetorno = new ArrayList<Object>();

        if(object instanceof Tecnico){
        if(((Tecnico)object).recuperarSiape().isEmpty() || ((Tecnico)object).recuperarSiape() == null)
				listaRetorno.addAll(usuarios);
        else{
        	for (Usuario usuario : usuarios) {
				if(usuario instanceof Tecnico){
					if(usuario.recuperarSiape().indexOf(((Tecnico) object).recuperarSiape()) > -1)
						listaRetorno.add(usuario);
					}
				}
        	}
        }

        else if(object instanceof TipoRecurso){

            listaRetorno.addAll(tipoRecursos);
        }

        else if(object instanceof Atividade){

            listaRetorno.addAll(atividades);
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



