package view;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.AbstractListModel;

import model.Atividade;
import model.Status;
import control.ControleAtividade;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unchecked")
public class ViewBuscarAtividades {

	private JFrame frame;
	private JComboBox comboBox;
	private ControleAtividade controleAtividade;
	private JList list;
	private Atividade[] atividadesArray;
	private JButton btnNewButton;
	private ViewDetalhesAtividade viewDetalhesAtiviade;

	/**
	 * Create the application.
	 */
	public ViewBuscarAtividades() {
		
		initialize();
		
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		controleAtividade = new ControleAtividade();
		list = new JList();
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(452,404);
		frame.setTitle("Buscar Atividade");
		
		JLabel lblStatus = new JLabel("Status: ");
		lblStatus.setBounds(10, 14, 48, 14);
		
		comboBox = new JComboBox();
		comboBox.setEditable(false);
		
		comboBox.addItem(Status.APROVADA);
		comboBox.addItem(Status.RECUSADA);
		comboBox.addItem(Status.CANCELADA);
		comboBox.addItem(Status.PENDENTE);
		comboBox.addItem(Status.FINALIZADA);
		comboBox.addItem(Status.EM_ANDAMENTO);
		
		comboBox.setBounds(58, 11, 266, 20);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(335, 329, 89, 23);
		
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				frame.dispose();
			}
		});
		
		
		list.setBounds(58, 50, 366, 268);
		
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Atividade atividade = (Atividade) list.getSelectedValue();
				
				viewDetalhesAtiviade = new ViewDetalhesAtividade(atividade);
			
			}
		});
		
		
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(btnVoltar);
		frame.getContentPane().add(lblStatus);
		frame.getContentPane().add(comboBox);
		frame.getContentPane().add(list);
		
		btnNewButton = new JButton("Buscar");
		
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Status status = (Status) comboBox.getSelectedItem();
				
				List<Atividade> atividades = controleAtividade.recuperarAtividades(status);
				
				atividadesArray = new Atividade[atividades.size()];
				
				for(int i = 0; i < atividadesArray.length; i++)
					atividadesArray[i] = (Atividade) atividades.get(i);

				list.setListData(atividadesArray);
				
			}
		});
		btnNewButton.setBounds(335, 10, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
