package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListDataListener;
import javax.swing.table.DefaultTableModel;

import model.Departamento;
import model.Professor;
import model.Recurso;
import model.Status;
import model.TipoRecurso;
import model.Universidade;
import model.Usuario;
import net.miginfocom.swing.MigLayout;
import control.ControleInstitucional;

public class ViewRecurso {

	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JTextField descricao;
	private JTextField patrimonio;
	private JTextField descricaoBusca;
	private JList<Recurso> tabela;
	private JComboBox<TipoRecurso> tipoRecurso;
	private JPanel panel;
	
	private ControleInstitucional controleInstitucional;
	private Recurso recurso;
	private TipoRecurso tRecurso;
	
	private JButton btnBuscar;

	/**
	 * Create the application.
	 */
	public ViewRecurso() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		controleInstitucional = new ControleInstitucional();
		tRecurso = new TipoRecurso(null);
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[grow]"));
		frame.setVisible(true);
		frame.setSize(800,600);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, "cell 0 0,grow");
		
		panel = new JPanel();
		tabbedPane.addTab("Formul\u00E1rio", null, panel, null);
		panel.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][]"));
		
		JLabel lblDescricao = new JLabel("Descricao");
		panel.add(lblDescricao, "cell 0 0,alignx trailing");
		
		descricao = new JTextField();
		panel.add(descricao, "cell 1 0,growx");
		descricao.setColumns(10);
		
		JLabel lblPatrimonio = new JLabel("Patrimonio");
		panel.add(lblPatrimonio, "cell 0 1,alignx trailing");
		
		patrimonio = new JTextField();
		panel.add(patrimonio, "cell 1 1,growx");
		patrimonio.setColumns(10);
		
		JLabel lblTipoRecurso = new JLabel("Tipo de Recurso");
		panel.add(lblTipoRecurso, "cell 0 4,alignx trailing");
		
		
		//Departamento[] vetorDepartamento;
		
		TipoRecurso[] vetorTipoRecursos = new TipoRecurso[Usuario.recuperaUsuarioLogado().recuperarDepartamento().listarTipoRecurso(new TipoRecurso(null)).toArray().length];
		int cont = 0;
		for(Object tp : Usuario.recuperaUsuarioLogado().recuperarDepartamento().listarTipoRecurso(new TipoRecurso(null)).toArray()){
			TipoRecurso tipoRecurso = (TipoRecurso) tp;
			vetorTipoRecursos[cont] = tipoRecurso;
			cont++;
		}
		
		tipoRecurso = new JComboBox<TipoRecurso>();
		tipoRecurso.setModel(new DefaultComboBoxModel<TipoRecurso>(vetorTipoRecursos));
		tipoRecurso.setEditable(false);
		panel.add(tipoRecurso, "cell 1 4,growx");
		
		/*****************************************************************/
		ActionListener salvarRecurso = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controleInstitucional = new ControleInstitucional();
				if(!patrimonio.getText().isEmpty() && !descricao.getText().isEmpty()){
					TipoRecurso tipo = (TipoRecurso)tipoRecurso.getSelectedItem();
					tipo.inserirRecurso(patrimonio.getText(), descricao.getText(), Status.DISPONIVEL);;	
				}else{
					JOptionPane.showMessageDialog(null, "Preencha corretamente os campos", "Mensagem", JOptionPane.ERROR_MESSAGE);
				}
			}
		};
		
		ActionListener limparRecurso = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controleInstitucional = new ControleInstitucional();
				//professor = new Professor(nome.getText(), siape.getText(), email.getText(), telefone.getText(), departamento.getSelectedIndex());
				//controleInstitucional.inserir(professor);
				patrimonio.setText(null);
				descricao.setText(null);
				tipoRecurso.setSelectedIndex(0);
				descricaoBusca.setText(null);
				tabela.setListData(new Recurso[1]);
				
			}
		};
		
		ActionListener buscarRecurso = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controleInstitucional = new ControleInstitucional();
				List<Recurso> resultado = controleInstitucional.buscarRecurso(descricaoBusca.getText());
				Recurso[] listData = new Recurso[resultado.size()]; 
				for(int i = 0; i < listData.length; i++){
					listData[i] = (Recurso)resultado.toArray()[i];
				}
				tabela.setListData(listData);	
			}
		};
		
		ActionListener alterarRecurso = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!patrimonio.getText().isEmpty() && !descricao.getText().isEmpty()){
					recurso.modificarPatrimonio(patrimonio.getText());
					recurso.modificarDescricao(descricao.getText());
					
					tRecurso.alterar(recurso);
				} else {
					JOptionPane.showMessageDialog(null, "Preencha corretamente os campos", "Mensagem", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		};
		
		MouseListener recuperaRecurso = new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				recurso = tabela.getSelectedValue();
				patrimonio.setText(recurso.recuperarPatrimonio());
				descricao.setText(recurso.recuperarDescricao());
				
				tabbedPane.setSelectedComponent(panel);
					
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
		
		
		/*****************************************************************/
		
		
		
		JButton btnCancelar = new JButton("Cancelar");
		panel.add(btnCancelar, "flowx,cell 1 7");
		btnCancelar.addActionListener(limparRecurso);
		
		JButton btnAlterar = new JButton("Alterar");
		panel.add(btnAlterar, "cell 1 7");
		btnAlterar.addActionListener(alterarRecurso);
		
		JButton btnSalvar = new JButton("Salvar");
		panel.add(btnSalvar, "cell 1 7");
		btnSalvar.addActionListener(salvarRecurso);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Consulta", null, panel_1, null);
		panel_1.setLayout(new MigLayout("", "[][grow]", "[][][grow]"));
		
		descricaoBusca = new JTextField();
		descricaoBusca.setColumns(10);
		panel_1.add(descricaoBusca, "cell 1 1");
		
		btnBuscar = new JButton("Buscar");
		panel_1.add(btnBuscar, "cell 1 1");
		btnBuscar.addActionListener(buscarRecurso);
		
		tabela = new JList<Recurso>();
		panel_1.add(tabela, "cell 1 2,grow");
		tabela.addMouseListener(recuperaRecurso);
	}

}
