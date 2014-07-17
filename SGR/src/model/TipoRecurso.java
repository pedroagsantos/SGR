package model;
import java.util.ArrayList;
import java.util.List;

public class TipoRecurso {

    private List<Recurso> recursos = new ArrayList<>();
    private Status status;
    private String tipo;
    
    public TipoRecurso(String tipo) {
		// TODO Auto-generated constructor stub
    	this.tipo = tipo;
	}

    public Status recuperaStatus() {
        return status;
    }

    public void modificaStatus(Status status) {
        this.status = status;
    }

    public String recuperarTipo() {
        return tipo;
    }


    public void inserir(Recurso recurso){

        recursos.add(recurso);

    }

    public void alterar(Recurso recurso){

        recursos.add(recurso);

    }

    public List<Recurso> listarRecursos(){

        return recursos;
    }

    public void remover(Recurso recurso){

            recurso.modificarStatusRecurso(Status.DESABILITADO);
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return tipo;
    }

	public void modificarTipo(String tipo) {
		// TODO Auto-generated method stub
		this.tipo = tipo;
		
	}
}
