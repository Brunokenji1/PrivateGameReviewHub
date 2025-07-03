package screen;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Criptografia;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setLocationRelativeTo(null);
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 339);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(86, 150, 278, 77);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Criptografia criptografia = new Criptografia(passwordField.getText(), Criptografia.MD5);
				System.out.println(criptografia.criptografar());
				if(passwordField.getText()!=null && !passwordField.getText().isEmpty()) {
					if(criptografia.criptografar().equals("E10ADC3949BA59ABBE56E057F20F883E")||criptografia.criptografar().equals("6531401F9A6807306651B87E44C05751")) {
					JOptionPane.showMessageDialog(btnNewButton, "Informações validas");
					dispose(); //fechar tela
					principal jprincipal = new principal();
					jprincipal.setLocationRelativeTo(jprincipal);  //definir a tela principal no centro
					jprincipal.setVisible(true);
					}
				}else {
					JOptionPane.showMessageDialog(btnNewButton, "Verifique as informações", "aviso", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(179, 53, 89, 23);
		panel.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 11, 258, 20);
		panel.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\bruno\\eclipse-workspace\\enari\\bin\\imagens\\TelaLogin.png"));
		lblNewLabel.setBounds(0, 0, 448, 300);
		contentPane.add(lblNewLabel);

	}
}
