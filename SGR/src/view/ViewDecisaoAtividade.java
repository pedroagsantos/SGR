package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ViewDecisaoAtividade {

	/*************************************/
	//Caso de Uso: Cancelar Atividade
	/************************************/
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDecisaoAtividade window = new ViewDecisaoAtividade();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewDecisaoAtividade() {
		initialize();
		this.frame.setVisible(true);	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 440, 450);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
		);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		
		JLabel lblDadosDaAtividade = new JLabel("Dados da atividade:");
		
		JButton btnCancelarAtividade = new JButton("Cancelar Atividade");
		btnCancelarAtividade.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Atividade Cancelada!");
			}
		});
		
		JButton btnCancelar = new JButton("Cancelar");
		
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				frame.dispose();
				
			}
		});
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap(10, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(btnCancelar)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnCancelarAtividade))))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblDadosDaAtividade)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(37)
					.addComponent(lblDadosDaAtividade)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 299, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCancelarAtividade)
						.addComponent(btnCancelar))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		frame.getContentPane().setLayout(groupLayout);
	}
}
