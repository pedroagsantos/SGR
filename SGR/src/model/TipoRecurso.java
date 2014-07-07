package model;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by stark on 06/06/14.
 */
public class TipoRecurso {

    private HashMap<String, Recurso> hmRecurso = new HashMap<>();
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

        hmRecurso.put(recurso.recuperarPatrimonio(), recurso);

    }

    public void alterar(Recurso recurso){

        hmRecurso.put(recurso.recuperarPatrimonio(), recurso);

    }

    public List<Recurso> listar(){

        ArrayList<Recurso> listaRetorno = new ArrayList<Recurso>();

        listaRetorno.addAll(hmRecurso.values());

        return listaRetorno;
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
