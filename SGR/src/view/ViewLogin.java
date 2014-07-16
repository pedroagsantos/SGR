package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Usuario;
import control.ControleLogin;

public class ViewLogin {
	
	JFrame frame;
	private JTextField siape;
	private JTextField senha;
	private ControleLogin controleLogin;


	/**
	 * Create the application.
	 */
	public ViewLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		controleLogin = new ControleLogin();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Sign In");
		
		JLabel lblSiape = new JLabel("SIAPE");
		lblSiape.setBounds(96, 74, 46, 14);
		frame.getContentPane().add(lblSiape);
		
		siape = new JTextField();
		siape.setBounds(152, 71, 140, 20);
		frame.getContentPane().add(siape);
		siape.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(96, 136, 46, 14);
		frame.getContentPane().add(lblSenha);
		
		senha = new JTextField();
		senha.setBounds(152, 133, 140, 20);
		frame.getContentPane().add(senha);
		senha.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario procurado = controleLogin.login(siape.getText(), senha.getText());
				if(procurado == null){
					new JOptionPane("Usuario nao encontrado!", JOptionPane.ERROR_MESSAGE);
				}
				else if(!(procurado.recuperaSenha().equals(senha.getText()))){
					new JOptionPane("Usuario/Senha invalido", JOptionPane.ERROR_MESSAGE);
				}
				else{
					Usuario.setUsuarioLogado(procurado);
					TelaPrincipal principal = new TelaPrincipal();
					frame.dispose();
					principal.setVisible(true);
				}
			}
		});
		btnEntrar.setBounds(175, 200, 89, 23);
		frame.getContentPane().add(btnEntrar);
	}
}
