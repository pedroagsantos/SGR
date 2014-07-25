package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import model.Usuario;
import control.ControleLogin;

import javax.swing.SwingConstants;

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
		frame.setSize(300, 250);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Sign In");
		frame.setResizable(false);
		
		JLabel lblSiape = new JLabel("SIAPE");
		lblSiape.setBounds(50, 74, 46, 14);
		frame.getContentPane().add(lblSiape);
		
		siape = new JTextField();
		siape.setBounds(120, 71, 140, 20);
		frame.getContentPane().add(siape);
		siape.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(50, 110, 46, 14);
		frame.getContentPane().add(lblSenha);
		
		senha = new JPasswordField();
		senha.setBounds(120, 110, 140, 20);
		frame.getContentPane().add(senha);
		senha.setColumns(10);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuario procurado = controleLogin.login(siape.getText(), senha.getText());
				if(procurado == null){
					JOptionPane.showMessageDialog(frame, "Usuario/Senha invalido!", "Erro", JOptionPane.ERROR_MESSAGE);
				} else{
					Usuario.setUsuarioLogado(procurado);
					//TODO Essa é a tela para todos os usuários (Tá errado)?
					TelaPrincipal principal = new TelaPrincipal();
					
					frame.dispose();
					principal.setVisible(true);
				}
			}
		});
		btnEntrar.setBounds(175, 150, 89, 23);
		frame.getContentPane().add(btnEntrar);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setVerticalAlignment(SwingConstants.TOP);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 40));
		lblLogin.setBounds(10, 11, 274, 53);
		frame.getContentPane().add(lblLogin);
	}
}
