package model;
import java.util.ArrayList;
import java.util.List;

public class TipoRecurso {

    private List<Recurso> recursos = new ArrayList<>();
    private int status;
    private String tipo;
    
    public TipoRecurso(String tipo) {
		// TODO Auto-generated constructor stub
    	this.tipo = tipo;
	}

    public int recuperaStatus() {
        return status;
    }

    public void modificaStatus(int status) {
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

            recurso.modificarStatusRecurso(Status.DESABILITADO.valor());
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
