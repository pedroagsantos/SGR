package view;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;

import control.ControleAtividade;
import model.Atividade;
import model.Recurso;
import model.Status;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import net.miginfocom.swing.MigLayout;

import javax.swing.JList;


public class ViewDecisaoDesalocarRecurso {
	
	private JFrame frame;
	private Atividade atividade;
	private ControleAtividade controleAtividade;
	private Recurso[] recursoArray;
	private JList listRecursos;
	private ArrayList<Recurso> recursos;

	/**
	 * Create the application.
	 */
	public ViewDecisaoDesalocarRecurso(Atividade atividade) {
		
		this.atividade = atividade;
		
		initialize();
		
		this.frame.setVisible(true);	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		controleAtividade = new ControleAtividade();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 462, 412);
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
		
		JLabel lblDadosDaAtividade = new JLabel("Recursos da Atividade:");
		panel.setLayout(new MigLayout("", "[96px,grow][75px][75px][][10px][71px][][10px][67px]", "[14px][299px,grow][23px]"));
		
		listRecursos = new JList<Recurso>();
		
		recursos = new ArrayList<>();
		recursos.addAll(atividade.recuperarRecursosAtividade());
		
		recursoArray = new Recurso[recursos.size()];
		
		for(int i = 0; i < recursoArray.length; i++)
			recursoArray[i] = (Recurso) recursos.get(i);

		listRecursos.setListData(recursoArray);
		
		panel.add(listRecursos, "cell 0 1 7 1,grow");
		
		JButton btnVoltar = new JButton("Voltar");
		
		btnVoltar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				frame.dispose();
				
			}
		});
		
		panel.add(btnVoltar, "cell 3 2,alignx left,aligny top");
		panel.add(lblDadosDaAtividade, "cell 0 0,alignx left,aligny top");
		
		JButton btnDesalocarRecurso = new JButton("Desalocar Recurso");
		
		btnDesalocarRecurso.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Recurso recurso = (Recurso) listRecursos.getSelectedValue();
				
				atividade.desalocarRecurso(recurso);
				
				recursos.remove(recurso);
				
				recursoArray = new Recurso[recursos.size()];
				
				for(int i = 0; i < recursoArray.length; i++)
					recursoArray[i] = (Recurso) recursos.get(i);
				
				listRecursos.setListData(recursoArray);
			}
		});
		panel.add(btnDesalocarRecurso, "cell 6 2,alignx left,aligny top");
		frame.getContentPane().setLayout(groupLayout);
	}
}
