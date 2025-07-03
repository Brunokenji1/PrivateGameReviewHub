package screen;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTable;

import model.ArquivoJogo;
import model.Jogos;
import model.ModeloTabela;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;


public class principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ArrayList<Jogos> jogos;
	private JTextField campoBuscar;
	private JLabel lblNewLabel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal frame = new principal();
					frame.setLocationRelativeTo(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public principal() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 628);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton botaoCadastrar = new JButton("Cadastrar");
		botaoCadastrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		botaoCadastrar.setBounds(846, 503, 119, 23);
		botaoCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCadatrar jcadastrar = new JCadatrar();
				jcadastrar.setLocationRelativeTo(jcadastrar);  
				jcadastrar.setVisible(true);
				dispose();
			}
		});
		contentPane.setLayout(null);
		contentPane.add(botaoCadastrar);
		
		JScrollPane tabela = new JScrollPane();
		tabela.setBounds(22, 69, 943, 418);
		contentPane.add(tabela);
		
	
		
		table = new JTable();
		tabela.setViewportView(table);
		
		campoBuscar = new JTextField();
		campoBuscar.setBounds(206, 24, 635, 23);
		contentPane.add(campoBuscar);
		campoBuscar.setColumns(10);
		
		JButton botaoBuscar = new JButton("Buscar");
		botaoBuscar.setFont(new Font("Tahoma", Font.BOLD, 12));
		botaoBuscar.setBounds(864, 23, 101, 23);
		botaoBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeBuscado = campoBuscar.getText().trim().toLowerCase();
				ArrayList<Jogos> lista = ArquivoJogo.carregarJogos();
				for(Jogos jogo : lista) {
					if (jogo.getNome().toLowerCase().equals(nomeBuscado)) {
						JEditarReview editar = new JEditarReview(jogo);
						editar.setLocationRelativeTo(null);
						editar.setVisible(true);
						dispose();
						return;
					}
				}
				JOptionPane.showMessageDialog(null, "Jogo não encontrado");
			}
		});
		contentPane.add(botaoBuscar);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bruno\\eclipse-workspace\\enari\\bin\\imagens\\TelaPrincipal.png"));
		lblNewLabel.setBounds(0, 0, 984, 589);
		contentPane.add(lblNewLabel);
		
		atualizarTabela();
	}
	
	private void atualizarTabela() {
		this.jogos = ArquivoJogo.carregarJogos();
		ModeloTabela modeloTabela = new ModeloTabela(jogos);
		table.setModel(modeloTabela);
	}
    public static ArrayList<Jogos> getJogosAtualizados() {
        return ArquivoJogo.carregarJogos();
    }

}
