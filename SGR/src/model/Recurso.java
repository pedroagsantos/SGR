package model;
/**
 * Created by stark on 06/06/14.
 */
public class Recurso {

    private String patrimonio;
    private String descricao;
    private int status;
    
    public Recurso(String patrimonio, String descricao, int status) {
		// TODO Auto-generated constructor stub
    	this.patrimonio = patrimonio;
    	this.descricao = descricao;
    	this.status = status;
	}

    public void modificarStatusRecurso(Integer status) {
        this.status = status;
    }

    public int recuperarStatusRecurso() {
        return status;
    }

    public String recuperarPatrimonio() {
        return patrimonio;
    }

    public void modificarPatrimonio(String patrimonio) {
        this.patrimonio = patrimonio;
    }

    public String recuperarDescricao() {
        return descricao;
    }

    public void modificarDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return descricao;
    }
}
