package model;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * Created by stark on 06/06/14.
 */
public class Atividade {

    private Professor professorResponsavel;
    private Tecnico tecnicoResponsavel;
    private HashMap<String, Recurso> hmRecurso = new HashMap<>();
    private Intervalo intervalo;
    private String codigo;
    private Status status;
    private String data;
    
    public Atividade(String codigo, Professor prof, Tecnico tec, List<Recurso> recursos, Intervalo intervalo, Status status, String data) {
		// TODO Auto-generated constructor stub
    	this.professorResponsavel = (Professor) prof;
    	this.tecnicoResponsavel = tec;
   
    	for (Object recurso : recursos)
    		hmRecurso.put(((Recurso) recurso).recuperarPatrimonio(), (Recurso) recurso);

    	this.intervalo = intervalo;
    	this.codigo = codigo;
    	this.status = status;
    	this.data = data;
	}
    
    public Boolean verificarUsuarioResponsavel(Usuario usuarioResponsavel) {
    	
    	if ((Usuario) this.professorResponsavel == usuarioResponsavel ||
    		(Usuario) this.tecnicoResponsavel == usuarioResponsavel) {
    		
    		return true;
    	}
    	
    	return false;
    }

    public Status recuperarStatus() {
        return status;
    }

    public void modificarStatus(Status status) {
        this.status = status;
    }

    public String recuperarCodigo() {
        return codigo;
    }

    public void modificarCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public void atribuirTecnicoResponsavel(Tecnico tecnicoResponsavel) {
        this.tecnicoResponsavel = tecnicoResponsavel;
    }
    
    public void alocarRecursos() {
    	
    	for (Recurso recurso : hmRecurso.values())
			recurso.modificarStatusRecurso(Status.ALOCADO);
    	
    }
    
    public Collection<Recurso> recuperarRecursosAtividade() {
    	return hmRecurso.values();
    }
    
    public void desalocarRecurso (Recurso recurso) {
    	
    	Recurso recursoAtividade = hmRecurso.get(recurso.recuperarPatrimonio());
   
    	recursoAtividade.modificarStatusRecurso(Status.DISPONIVEL);
   
    	hmRecurso.remove(recursoAtividade.recuperarPatrimonio());
    }
    
    public void desalocarRecursos() {
    	
    	for (Recurso recurso : hmRecurso.values())
			recurso.modificarStatusRecurso(Status.DISPONIVEL);
    	
    }
    
    public String toStringAtividadePendente() {
    	// TODO Auto-generated method stub
    	
    	StringBuilder sb =  new StringBuilder();
    	
    	sb.append("Codigo da Atividade: " + codigo + "\n");
    	sb.append("Professor Responsavel: " + professorResponsavel + "\n");
    	sb.append("Recurso(s) Alocado(s): " + "\n");
    	
    	for (Recurso recurso : hmRecurso.values())
    		sb.append("Cod -> " + recurso.recuperarPatrimonio() + " " + recurso.recuperarDescricao() + "\n");

    	sb.append("Intervalo : " + intervalo + "\n");
    	sb.append("Data: " + data);
    	
    	return sb.toString();
    }
    
    
    
    public String recuperaData() {
		return data;
	}

	public void modificaData(String data) {
		this.data = data;
	}
	
	
	public Intervalo recuperaIntervalo() {
		return intervalo;
	}

	public void modificaIntervalo(Intervalo intervalo) {
		this.intervalo = intervalo;
	}

	@Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return codigo + " " +
    			professorResponsavel + " " +
    			intervalo + " " +
    			data;
    }
}
