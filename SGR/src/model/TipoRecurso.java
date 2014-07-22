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


    public void inserirRecurso(String patrimonio, String descricao, Status status){

    	Recurso recurso = new Recurso(patrimonio, descricao, status);
        recursos.add(recurso);

    }

    public void alterar(Recurso recurso){

        recursos.add(recurso);

    }

    public List<Recurso> buscarRecurso(String descricao) {
    	ArrayList<Recurso> listaRetorno = new ArrayList<>();
    	if(descricao.equals("") || descricao == null)
    		listaRetorno.addAll(recursos);
    	else{
	    	for (Recurso recurso : recursos) {
				if(recurso.recuperarDescricao().indexOf(descricao) > -1){
					listaRetorno.add(recurso);
				}
			}
    	}
    	return listaRetorno;
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
