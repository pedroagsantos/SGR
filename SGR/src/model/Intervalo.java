package model;
/**
 * Created by stark on 06/06/14.
 */
public enum Intervalo {

    //PRIMEIRO(1), SEGUNDO(2), TERCEIRO(3), QUARTO(4), QUINTO(5), SEXTO(6);
    

    PRIMEIRO("08:00-10:00", 1, 8),
    SEGUNDO("10:00-12:00", 2, 10),
    TERCEIRO("14:00-16:00", 3, 14),
    QUARTO("16:00-18:00", 4, 16),
    QUINTO("18:00-20:00", 5, 18),
    SEXTO("20:00-22:00", 6, 20);


    private String nome;
    private int intervalo;
    private int hora;

    private Intervalo (String nome, int intervalo, int hora){
        this.intervalo = intervalo;
        this.nome = nome;
        this.hora = hora;
    }

    public int valor(){
        return this.intervalo;
    }
    
    public int horaIntervalo(){
        return this.hora;
    }
    
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return nome;
    }

}
