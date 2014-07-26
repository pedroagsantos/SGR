package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import model.Departamento;
import model.Tecnico;
import model.Universidade;
import model.Usuario;
import net.miginfocom.swing.MigLayout;
import control.ControleInstitucional;

public class ViewTecnico {

	private JFrame frame;
	private JTabbedPane tabbedPane;
	private JTextField nome;
	private JTextField siape;
	private JTextField email;
	private JTextField telefone;
	private JTextField siapeBusca;
	private JList<Tecnico> tabela;
	private JComboBox<Departamento> departamento;
	private JPanel panel;
	
	private ControleInstitucional controleInstitucional;
	private Tecnico tecnico;
	
	private JButton btnBuscar;

	/**
	 * Create the application.
	 */
	public ViewTecnico() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		controleInstitucional = new ControleInstitucional();
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
		
		JLabel lblNome = new JLabel("Nome");
		panel.add(lblNome, "cell 0 0,alignx trailing");
		
		nome = new JTextField();
		panel.add(nome, "cell 1 0,growx");
		nome.setColumns(10);
		
		JLabel lblSiape = new JLabel("Siape");
		panel.add(lblSiape, "cell 0 1,alignx trailing");
		
		siape = new JTextField();
		panel.add(siape, "cell 1 1,growx");
		siape.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		panel.add(lblEmail, "cell 0 2,alignx trailing");
		
		email = new JTextField();
		panel.add(email, "cell 1 2,growx");
		email.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone");
		panel.add(lblTelefone, "cell 0 3,alignx trailing");
		
		telefone = new JTextField();
		panel.add(telefone, "cell 1 3,growx");
		telefone.setColumns(10);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		panel.add(lblDepartamento, "cell 0 4,alignx trailing");
		
		Departamento[] vetorDepartamento = new Departamento[Universidade.recuperaInstancia().recuperaDepartamentos().toArray().length];
		
		int cont = 0;
		for(Object depto : Universidade.recuperaInstancia().recuperaDepartamentos().toArray()){
			Departamento departamento = (Departamento) depto;
			vetorDepartamento[cont] = departamento;
			cont++;
		}
		
		
		departamento = new JComboBox<Departamento>();
		departamento.setModel(new DefaultComboBoxModel<Departamento>(vetorDepartamento));
		departamento.setEditable(false);
		panel.add(departamento, "cell 1 4,growx");
		
		/*****************************************************************/
		ActionListener salvarTecnico = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controleInstitucional = new ControleInstitucional();
				if(!nome.getText().isEmpty() && !siape.getText().isEmpty() && !email.getText().isEmpty())
					controleInstitucional.inserirTecnico(nome.getText(), siape.getText(), email.getText(), telefone.getText(), (Departamento)departamento.getSelectedItem());
				else
					JOptionPane.showMessageDialog(null, "Preencha corretamente os campos", "Mensagem", JOptionPane.ERROR_MESSAGE);
			}
		};
		
		ActionListener limparTecnico = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controleInstitucional = new ControleInstitucional();
				//professor = new Professor(nome.getText(), siape.getText(), email.getText(), telefone.getText(), departamento.getSelectedIndex());
				//controleInstitucional.inserir(professor);
				nome.setText(null);
				siape.setText(null);
				email.setText(null);
				telefone.setText(null);
				departamento.setSelectedIndex(0);
				siapeBusca.setText(null);
				tabela.setListData(new Vector());
				
			}
		};
		
		ActionListener buscarTecnico = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controleInstitucional = new ControleInstitucional();
				/*Tecnico[] listZero = new Tecnico[0];*/
				//tabela.setListData(new Vector());
				//tabela.setListData(new Vector());
				
				DefaultListModel lista = new DefaultListModel<>();
				List<Usuario> listaTecnico = controleInstitucional.buscarTecnico(siape.getText());
				Tecnico[] listData = new Tecnico[listaTecnico.size()]; 
				for(int i = 0; i < listData.length; i++){
					//listData[i] = (Tecnico)listaTecnico.toArray()[i];
					lista.addElement((Tecnico)listaTecnico.toArray()[i]);
				}
				
				
				tabela.setModel(lista);
				
				
			}
		};
		
		ActionListener alterarTecnico = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controleInstitucional = new ControleInstitucional();
				if(!nome.getText().isEmpty() && !siape.getText().isEmpty() && !email.getText().isEmpty()){
					tecnico.modificarNome(nome.getText());
					//professor.modificarSiape(siape.getText());
					tecnico.modificarEmail(email.getText());
					tecnico.modificarTelefone(telefone.getText());
					tecnico.modificarDepartamento((Departamento)departamento.getSelectedItem());
					controleInstitucional.alterar(tecnico);	
				} else {
					JOptionPane.showMessageDialog(null, "Preencha corretamente os campos", "Mensagem", JOptionPane.ERROR_MESSAGE);
				}				
			}
		};
		
		MouseListener recuperaProfessor = new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				tecnico = (Tecnico) tabela.getSelectedValue();
				nome.setText(tecnico.recuperarNome());
				siape.setText(tecnico.recuperarSiape());
				email.setText(tecnico.recuperarEmail());
				telefone.setText(tecnico.recuperarTelefone());
				departamento.setSelectedItem(tecnico.recuperarDepartamento());
				
				tabbedPane.setSelectedComponent(panel);
				
				
				
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
				
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
		btnCancelar.addActionListener(limparTecnico);
		
		JButton btnAlterar = new JButton("Alterar");
		panel.add(btnAlterar, "cell 1 7");
		btnAlterar.addActionListener(alterarTecnico);
		
		JButton btnSalvar = new JButton("Salvar");
		panel.add(btnSalvar, "cell 1 7");
		btnSalvar.addActionListener(salvarTecnico);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Consulta", null, panel_1, null);
		panel_1.setLayout(new MigLayout("", "[][grow]", "[][][grow]"));
		
		JLabel lblSiape_1 = new JLabel("Siape");
		panel_1.add(lblSiape_1, "cell 0 0,alignx trailing");
		
		siapeBusca = new JTextField();
		panel_1.add(siapeBusca, "cell 1 0,growx");
		siapeBusca.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		panel_1.add(btnBuscar, "cell 1 1");
		btnBuscar.addActionListener(buscarTecnico);
		
		tabela = new JList<Tecnico>();
		panel_1.add(tabela, "cell 1 2,grow");
		tabela.addMouseListener(recuperaProfessor);
	}

}
