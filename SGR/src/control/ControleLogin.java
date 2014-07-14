package control;

import model.Departamento;
import model.Universidade;
import model.Usuario;

public class ControleLogin {
	
	
	public Usuario Login(String siape, String senha){
		
		for (Departamento dpto :Universidade.recuperaInstancia().recuperaDepartamentos()){
			for (Usuario usr : dpto.listar()) {
				
				if(usr.recuperarSiape() == siape && usr.recuperaSenha() == senha){
					return usr.recuperatUsuarioLogado();
				}
			}
		}
		
		return null;
	}
}
