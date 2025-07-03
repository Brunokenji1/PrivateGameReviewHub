package screen;

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

public class JEditarReview extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNomeJogo;
	private JTextField textAnoLan;
	private JTextField textGenero;
	private JTextField textDesenvolvedora;
	private JTextField textNota;
	private Jogos jogoOriginal;

	public JEditarReview(Jogos jogo) {
		this.jogoOriginal = jogo;

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 606);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textNomeJogo = new JTextField();
		textNomeJogo.setBounds(10, 98, 428, 20);
		contentPane.add(textNomeJogo);
		textNomeJogo.setColumns(10);

		textAnoLan = new JTextField();
		textAnoLan.setColumns(10);
		textAnoLan.setBounds(10, 146, 428, 20);
		contentPane.add(textAnoLan);

		textGenero = new JTextField();
		textGenero.setColumns(10);
		textGenero.setBounds(10, 193, 428, 20);
		contentPane.add(textGenero);

		textDesenvolvedora = new JTextField();
		textDesenvolvedora.setColumns(10);
		textDesenvolvedora.setBounds(10, 241, 428, 20);
		contentPane.add(textDesenvolvedora);

		JTextArea textReview = new JTextArea();
		textReview.setFont(new Font("Tahoma", Font.PLAIN, 11));
		textReview.setLineWrap(true);
		textReview.setWrapStyleWord(true);
		textReview.setBounds(10, 293, 428, 134);
		contentPane.add(textReview);

		JButton botaoSalvar = new JButton("Salvar");
		botaoSalvar.setFont(new Font("Tahoma", Font.BOLD, 12));
		botaoSalvar.setBounds(336, 503, 102, 23);
		contentPane.add(botaoSalvar);

		textNota = new JTextField();
		textNota.setColumns(10);
		textNota.setBounds(10, 459, 78, 20);
		contentPane.add(textNota);

		textNomeJogo.setText(jogoOriginal.getNome());
		textAnoLan.setText(jogoOriginal.getAno_lancamento());
		textGenero.setText(jogoOriginal.getGenero());
		textDesenvolvedora.setText(jogoOriginal.getDesenvolvedora());
		textReview.setText(jogoOriginal.getReview());
		textNota.setText(jogoOriginal.getNota());
		
		JButton botaoVoltar = new JButton("Voltar");
		botaoVoltar.setFont(new Font("Tahoma", Font.BOLD, 12));
		botaoVoltar.setBounds(10, 503, 102, 23);
		contentPane.add(botaoVoltar);
		
		JButton botaoExcluir = new JButton("Excluir");
		botaoExcluir.setFont(new Font("Tahoma", Font.BOLD, 12));
		botaoExcluir.setBounds(170, 503, 102, 23);
		contentPane.add(botaoExcluir);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bruno\\eclipse-workspace\\enari\\bin\\imagens\\Dados do jogo.png"));
		lblNewLabel.setBounds(0, 0, 450, 568);
		contentPane.add(lblNewLabel);
		botaoExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcao = JOptionPane.showConfirmDialog(botaoExcluir, "Tem certeza que deseja excluir este jogo?", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION);
				if(opcao == JOptionPane.YES_OPTION) {
					ArrayList<Jogos> lista = ArquivoJogo.carregarJogos();
					String nomeAlvo = jogoOriginal.getNome();
					for(int i = 0; i < lista.size(); i++) {
						if(lista.get(i).getNome().equals(nomeAlvo)) {
							lista.remove(i);
							break;
						}
					}
					ArquivoJogo.salvarJogos(lista);
					JOptionPane.showMessageDialog(botaoExcluir, "Jogo excluido com sucesso!");
					dispose();
					principal jprincipal = new principal();
					jprincipal.setLocationRelativeTo(jprincipal);
					jprincipal.setVisible(true);
					
					
				}
			
			}
		});

		botaoVoltar.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(botaoVoltar, "Voltando tela inicial");
				principal jprincipal = new principal();
				dispose();
				jprincipal.setLocationRelativeTo(jprincipal);
				jprincipal.setVisible(true);
				
			}
		});;
		botaoSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textNomeJogo.getText() != null && !textNomeJogo.getText().isEmpty() &&
					textAnoLan.getText() != null && !textAnoLan.getText().isEmpty() &&
					textGenero.getText() != null && !textGenero.getText().isEmpty() &&
					textDesenvolvedora.getText() != null && !textDesenvolvedora.getText().isEmpty() &&
					textReview.getText() != null && !textReview.getText().isEmpty() &&
					textNota.getText() != null && !textNota.getText().isEmpty()) {

					String nomeAntigo = jogoOriginal.getNome(); // Salva nome antigo antes da edição

					
					jogoOriginal.setNome(textNomeJogo.getText());
					jogoOriginal.setAno_lancamento(textAnoLan.getText());
					jogoOriginal.setGenero(textGenero.getText());
					jogoOriginal.setDesenvolvedora(textDesenvolvedora.getText());
					jogoOriginal.setReview(textReview.getText());
					jogoOriginal.setNota(textNota.getText());

					ArrayList<Jogos> lista = ArquivoJogo.carregarJogos();

					// Substitui o jogo antigo pelo novo na lista
					for (int i = 0; i < lista.size(); i++) {
						if (lista.get(i).getNome().equals(nomeAntigo)) {
							lista.set(i, jogoOriginal);
							break;
						}
					}

					ArquivoJogo.salvarJogos(lista);

					JOptionPane.showMessageDialog(botaoSalvar, "Jogo atualizado com sucesso");
					dispose();
					principal jprincipal = new principal();
					jprincipal.setLocationRelativeTo(jprincipal);
					jprincipal.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(botaoSalvar, "Complete todos os espaços", "Aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
}
