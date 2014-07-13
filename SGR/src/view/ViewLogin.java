package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import model.Usuario;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewLogin extends JFrame {
;
	private JTextField siape;
	private JTextField senha;


	/**
	 * Create the application.
	 */
	public ViewLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the this.
	 */
	private void initialize() {
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		JLabel lblSiape = new JLabel("SIAPE");
		lblSiape.setBounds(96, 74, 46, 14);
		this.getContentPane().add(lblSiape);
		
		siape = new JTextField();
		siape.setBounds(152, 71, 140, 20);
		this.getContentPane().add(siape);
		siape.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(96, 136, 46, 14);
		this.getContentPane().add(lblSenha);
		
		senha = new JTextField();
		senha.setBounds(152, 133, 140, 20);
		this.getContentPane().add(senha);
		senha.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario procurado = Usuario.consultaUsuario(siape.getText(), senha.getText());
				if(procurado == null){
					new JOptionPane("Usuario nao encontrado!", JOptionPane.ERROR_MESSAGE);
				}
				else if(!(procurado.recuperaSenha().equals(senha.getText()))){
					new JOptionPane("Usuario/Senha inválido", JOptionPane.ERROR_MESSAGE);
				}
				else{
					Usuario.setUsuarioLogado(procurado);
					TelaPrincipal principal = new TelaPrincipal();
				}
			}
		});
		btnEntrar.setBounds(175, 200, 89, 23);
		this.getContentPane().add(btnEntrar);
	}
}
