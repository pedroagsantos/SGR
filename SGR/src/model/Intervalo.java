package model;
/**
 * Created by stark on 06/06/14.
 */
public enum Intervalo {

    //PRIMEIRO(1), SEGUNDO(2), TERCEIRO(3), QUARTO(4), QUINTO(5), SEXTO(6);
    

    PRIMEIRO("8:00-10:00", 1),
    SEGUNDO("10:00-12:00", 2),
    TERCEIRO("14:00-16:00", 3),
    QUARTO("16:00-18:00", 4),
    QUINTO("18:00-20:00", 5),
    SEXTO("20:00-22:00", 6);

    private int intervalo;
    private String nome;

    private Intervalo (String nome, int intervalo){
        this.intervalo = intervalo;
        this.nome = nome;
    }

    public int valor(){
        return this.intervalo;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return nome;
    }

}
