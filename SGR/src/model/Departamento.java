package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by stark on 06/06/14.
 */
public class Departamento {
	
	
	private String nome;
	private String codDepto;

    private HashMap<String, Atividade> hmAtividade = new HashMap<>();
    private HashMap<String, TipoRecurso> hmTipoRecurso = new HashMap<>();
    private HashMap<String, Professor> hmProfessor = new HashMap<>();
    private HashMap<String, Tecnico> hmTecnico = new HashMap<>();
    
    public Departamento(String codDepto, String nome ) {
		// TODO Auto-generated constructor stub
    	this.codDepto = codDepto;
    	this.nome = nome;
	}
    
    

    public void inserirProfessor(Professor professor) {
    	
    	hmProfessor.put(professor.recuperarSiape(), professor);
    }
    
    public void inserirTecnico(Tecnico tecnico) {
    	
    	hmTecnico.put(tecnico.recuperarSiape(), tecnico);
    }
    
    public void inserirTipoRecurso(TipoRecurso tipoRecurso) {
    	hmTipoRecurso.put(tipoRecurso.recuperarTipo(), tipoRecurso);
    }
    
    public void inserirAtividade(Atividade atividade) {
    	hmAtividade.put(atividade.recuperarCodigo(), atividade);
    }
    
    public void inserir(Object object){

        if (object.getClass().isInstance(Tecnico.class)) {

            Tecnico tecnico = (Tecnico) object;

            hmTecnico.put(tecnico.recuperarSiape(), tecnico);
        }

        else if (object.getClass().isInstance(Professor.class)) {

            Professor professor = (Professor) object;

            hmProfessor.put(professor.recuperarSiape(), professor);

        }

        else if (object.getClass().isInstance(TipoRecurso.class)) {

            TipoRecurso tipoRecurso = (TipoRecurso) object;

            hmTipoRecurso.put(tipoRecurso.recuperarTipo(), tipoRecurso);

        }

        else if (object.getClass().isInstance(TipoRecurso.class)) {

            Atividade atividade = (Atividade) object;

            hmAtividade.put(atividade.recuperarCodigo(), atividade);

        }

       /* if (object.getClass().isInstance(Departamento.class)) {

            Departamento departamento = (Departamento) object;

            hmDepartamento.put(departamento.getIdDepto(), departamento);

        }*/

    }

    public void alterar(Object object){

        if (object.getClass().isInstance(Tecnico.class)){

            Tecnico tecnico = (Tecnico) object;

            hmTecnico.put(tecnico.recuperarSiape(), tecnico);
        }

        else if (object.getClass().isInstance(Professor.class)){

            Professor professor = (Professor) object;

            hmProfessor.put(professor.recuperarSiape(), professor);

        }

        else if(object.getClass().isInstance(TipoRecurso.class)){

            TipoRecurso tipoRecurso = (TipoRecurso) object;

            hmTipoRecurso.put(tipoRecurso.recuperarTipo(), tipoRecurso);

        }

        else if (object.getClass().isInstance(TipoRecurso.class)) {

            Atividade atividade = (Atividade) object;

            hmAtividade.put(atividade.recuperarCodigo(), atividade);

        }

       /* if (object.getClass().isInstance(Departamento.class)) {

            Departamento departamento = (Departamento) object;

            hmDepartamento.put(departamento.getIdDepto(), departamento);

        }*/

    }

    public List<Object> listar(Object object){

        ArrayList<Object> listaRetorno = new ArrayList<Object>();

        if(object.getClass().isInstance(Tecnico.class)){

            listaRetorno.addAll(hmTecnico.values());
        }

        else if(object.getClass().isInstance(Professor.class)){

            listaRetorno.addAll(hmProfessor.values());
        }

        else if(object.getClass().isInstance(TipoRecurso.class)){

            listaRetorno.addAll(hmTipoRecurso.values());
        }

        else if(object.getClass().isInstance(Atividade.class)){

            listaRetorno.addAll(hmAtividade.values());
        }

         /*if(object.getClass().isInstance(Departamento.class)){

            for (Departamento departamento : hmDepartamento.values()) {
                listaRetorno.add(departamento);
            }
        }*/

        return listaRetorno;
    }

    public void remover(Object object){


        if (object.getClass().isInstance(Tecnico.class)) {

            Tecnico tecnico = (Tecnico) object;

            tecnico.modificarStatus(Status.DESABILITADO.valor());
        }

        else if (object.getClass().isInstance(Professor.class)) {

            Professor professor = (Professor) object;

            professor.modificarStatus(Status.DESABILITADO.valor());
        }

        else if (object.getClass().isInstance(TipoRecurso.class)) {

            TipoRecurso tipoRecurso = (TipoRecurso) object;

            tipoRecurso.modificaStatus(Status.DESABILITADO.valor());

        }

        else if (object.getClass().isInstance(TipoRecurso.class)) {

            Atividade atividade = (Atividade) object;

            atividade.modificarStatus(Status.DESABILITADO.valor());

        }

         /* else if (object.getClass().isInstance(Departamento.class)) {

            Departamento departamento = (Departamento) object;

            //hmDepartamento.remove(departamento);

        }*/
    }

    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return nome;
    }
    
    public String recuperarCodigo() {
    	return codDepto;
    }



	public HashMap<String, Professor> retornaMapaProfessor() {
		return hmProfessor;
	}

	public void modificaMapaProfessor(HashMap<String, Professor> hmProfessor) {
		this.hmProfessor = hmProfessor;
	}

	public HashMap<String, TipoRecurso> retornaMapaTipoRecurso() {
		return hmTipoRecurso;
	}



	public void setHmTipoRecurso(HashMap<String, TipoRecurso> modificaMapaTipoRecurso) {
		this.hmTipoRecurso = hmTipoRecurso;
	}

	public HashMap<String, Tecnico> retornaMapaTecnico() {
		return hmTecnico;
	}

	public void modificaMapaTecnico(HashMap<String, Tecnico> hmTecnico) {
		this.hmTecnico = hmTecnico;
	}



	
    
    
}



