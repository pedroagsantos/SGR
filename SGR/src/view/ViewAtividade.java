package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JFrame;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;

import control.ControleAtividade;
import control.ControleInstitucional;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;

import model.Atividade;
import model.Intervalo;
import model.Professor;
import model.Recurso;
import model.Tecnico;
import model.TipoRecurso;
import net.miginfocom.swing.MigLayout;

public class ViewAtividade {

	private JFrame frame;
	private JTextField codigo;
	private JComboBox professorCombo;
	private JComboBox intervaloCombo;
	private JComboBox tipoRecursoCombo;
	private JComboBox recursoCombo;
	private JList<Object> recursoJlist;
	
	private ControleInstitucional controleInstitucional;
	private ControleAtividade controleAtividade;
	private Tecnico tecnicoResponsavel;
	private Professor professorResponsavel;
	private TipoRecurso tipoRec;
	private HashMap<String, Recurso> recursos;
	private Intervalo intervalos;
	private Atividade atividade;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAtv window = new ViewAtv();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	/**
	 * Create the application.
	 */
	public ViewAtividade() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		controleInstitucional = new ControleInstitucional();
		controleAtividade = new ControleAtividade();
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][grow]", "[][][][][][][][][]"));
		frame.setVisible(true);
		frame.setSize(800,600);
		
		JLabel lblCdigo = new JLabel("Codigo:");
		frame.getContentPane().add(lblCdigo, "cell 0 0,alignx trailing");
		
		codigo = new JTextField();
		frame.getContentPane().add(codigo, "cell 1 0,growx");
		codigo.setColumns(10);
		
		JLabel lblProfessor = new JLabel("Professor:");
		frame.getContentPane().add(lblProfessor, "cell 0 1,alignx trailing");
		
		Object[] vetorProfessor = controleInstitucional.getListaProfessor().values().toArray();
		
		professorCombo = new JComboBox();
		professorCombo.setModel(new DefaultComboBoxModel(vetorProfessor));
		professorCombo.setEditable(true);
		frame.getContentPane().add(professorCombo, "cell 1 1,growx");
		
		JLabel lblTipoDeRecurso = new JLabel("Tipo de Recurso:");
		frame.getContentPane().add(lblTipoDeRecurso, "cell 0 2,alignx trailing");
		
		Object[] vetorTipoRecurso;
		vetorTipoRecurso = controleInstitucional.getListaTipoRecurso().values().toArray();
		tipoRecursoCombo = new JComboBox();
		tipoRecursoCombo.setModel(new DefaultComboBoxModel(vetorTipoRecurso));
		tipoRecursoCombo.setEditable(true);
		frame.getContentPane().add(tipoRecursoCombo, "cell 1 2,growx");
		
		/***************/
		tipoRec = (TipoRecurso) tipoRecursoCombo.getSelectedItem();
		/***************/
		
		JLabel lblRecurso = new JLabel("Recurso:");
		frame.getContentPane().add(lblRecurso, "cell 0 3,alignx trailing");
		
		/*Object[] vetorRecurso;
		vetorRecurso = tipoRec.listar().toArray();
		recursoCombo = new JComboBox();
		recursoCombo.setModel(new DefaultComboBoxModel(vetorRecurso));
		recursoCombo.setEditable(true);*/
		
		recursoJlist = new JList<>(tipoRec.listar().toArray());
		
		frame.getContentPane().add(recursoJlist, "cell 1 3,growx");
		
		JLabel lblIntervalo = new JLabel("Intervalo:");
		frame.getContentPane().add(lblIntervalo, "cell 0 4,alignx trailing");
		
		Object[] vetorIntervalo;
		vetorIntervalo = intervalos.values();
		intervaloCombo = new JComboBox();
		intervaloCombo.setModel(new DefaultComboBoxModel(vetorIntervalo));
		intervaloCombo.setEditable(true);
		frame.getContentPane().add(intervaloCombo, "cell 1 4,growx");
		
		/*******************************************************/
		
		ActionListener salvarAtividade = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//controleInstitucional = new ControleInstitucional();
				//professor = new Professor(nome.getText(), siape.getText(), email.getText(), telefone.getText(), departamento.getSelectedIndex());
				atividade = new Atividade(codigo.getText(), 
											professorCombo.getSelectedItem(), 
											tecnicoResponsavel, 
											recursoJlist.getSelectedValuesList(), 
											intervaloCombo.getSelectedIndex()+1, 
											2);
				
				controleAtividade.inserir(atividade);
				
			}
		};
		
		/*********************************************************/
		
		JButton btnCancelar = new JButton("Cancelar");
		frame.getContentPane().add(btnCancelar, "flowx,cell 1 8");
		
		JButton btnLimpar = new JButton("Limpar");
		frame.getContentPane().add(btnLimpar, "cell 1 8");
		
		JButton btnSalvar = new JButton("Salvar");
		frame.getContentPane().add(btnSalvar, "cell 1 8");
		btnSalvar.addActionListener(salvarAtividade);
	}

}
