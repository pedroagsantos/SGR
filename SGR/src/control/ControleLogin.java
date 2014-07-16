package control;

import model.Departamento;
import model.Universidade;
import model.Usuario;

public class ControleLogin {
	
	
	public Usuario login(String siape, String senha){
		
		for (Departamento dpto :Universidade.recuperaInstancia().recuperaDepartamentos()){
			for (Usuario usr : dpto.listarUsuarios()) {
				if(usr.recuperarSiape().equals(siape) && usr.recuperaSenha().equals(senha)){
					Usuario.setUsuarioLogado(usr);
					return usr;
				}
			}
		}
		return null;
	}
}
