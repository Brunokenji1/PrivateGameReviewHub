
package screen;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;

import model.ArquivoJogo;
import model.Jogos;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class JCadatrar extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomeJogo;
	private JTextField textAnoLan;
	private JTextField textGenero;
	private JTextField textDesenvolvedora;
	private JTextField textNota;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCadatrar frame = new JCadatrar();
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
	public JCadatrar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 465, 606);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textNomeJogo = new JTextField();
		textNomeJogo.setBounds(21, 125, 403, 20);
		contentPane.add(textNomeJogo);
		textNomeJogo.setColumns(10);
		
		textAnoLan = new JTextField();
		textAnoLan.setColumns(10);
		textAnoLan.setBounds(21, 171, 403, 20);
		contentPane.add(textAnoLan);
		
		textGenero = new JTextField();
		textGenero.setColumns(10);
		textGenero.setBounds(21, 221, 403, 20);
		contentPane.add(textGenero);
		
		textDesenvolvedora = new JTextField();
		textDesenvolvedora.setColumns(10);
		textDesenvolvedora.setBounds(21, 269, 403, 20);
		contentPane.add(textDesenvolvedora);
		
		JTextArea textReview = new JTextArea();
		textReview.setBounds(21, 316, 403, 136);
		textReview.setLineWrap(true);
		textReview.setWrapStyleWord(true);
		contentPane.add(textReview);
		
		JButton botaoCadastrado = new JButton("Cadastrar");
		botaoCadastrado.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		

		
		botaoCadastrado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textNomeJogo.getText()!=null && 
						!textNomeJogo.getText().isEmpty() && 
						textAnoLan.getText()!=null && 
						!textAnoLan.getText().isEmpty() && 
						textGenero.getText()!=null && 
						!textGenero.getText().isEmpty() && 
						textDesenvolvedora.getText()!=null && 
						!textDesenvolvedora.getText().isEmpty() && 
						textReview.getText()!=null && 
						!textReview.getText().isEmpty() &&
						textNota.getText()!=null && 
						!textNota.getText().isEmpty()) {
					ArrayList<Jogos> lista = ArquivoJogo.carregarJogos();
					String nomeNovo = textNomeJogo.getText().trim().toLowerCase();
					for( Jogos jogo :lista) {
						if(jogo.getNome().trim().toLowerCase().equals(nomeNovo)) {
							JOptionPane.showMessageDialog(botaoCadastrado, "Esse jogo já está cadastrado");
							return;
						}
					}
					lista.add(new Jogos(textNomeJogo.getText(), textGenero.getText(), textAnoLan.getText(), textDesenvolvedora.getText(), textReview.getText(), textNota.getText()
					));
					ArquivoJogo.salvarJogos(lista);

					JOptionPane.showMessageDialog(botaoCadastrado, "Jogo Cadastrado com Sucesso");
					dispose(); //fechar tela
					principal jprincipal = new principal();
					jprincipal.setLocationRelativeTo(jprincipal);  //definir a tela principal no centro
					jprincipal.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(botaoCadastrado, "Complete todos os espaços", "aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		botaoCadastrado.setBounds(303, 521, 121, 23);
		contentPane.add(botaoCadastrado);
		
		textNota = new JTextField();
		textNota.setColumns(10);
		textNota.setBounds(21, 480, 78, 20);
		contentPane.add(textNota);
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		botaoVoltar.setBounds(21, 521, 121, 23);
		contentPane.add(botaoVoltar);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bruno\\eclipse-workspace\\enari\\bin\\imagens\\telacadastrar01.png"));
		lblNewLabel.setBounds(0, 0, 450, 568);
		contentPane.add(lblNewLabel);
		botaoVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(botaoVoltar,"Voltando para a tela principal");
				dispose();
				principal jprincipal = new principal();
				jprincipal.setLocationRelativeTo(jprincipal);
				jprincipal.setVisible(true);
				
			}
		});
		

		
	}
}
