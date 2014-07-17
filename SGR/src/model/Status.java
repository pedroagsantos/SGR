package model;
/**
 * Created by stark on 06/06/14.
 */
public enum Status {

    EM_USO(0),
    INDISPONIVEL(1),
    DISPONIVEL(2),
    ALOCADO(3),

    EM_ANDAMENTO(4),
    APROVADA(5),
    RECUSADA(6),
    CANCELADA(7),
    PENDENTE(8),
    FINALIZADA(9),

    HABILITADO(10),
    DESABILITADO(11);

    private int status;

    Status(int status){
        this.status = status;
    }

    public int valor(){
        return this.status;
    }


}
