package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Secao extends JFrame {

	private JPanel contentPane;
	private JTextField txtEsportes;
	private JTextField textCPF;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Secao frame = new Secao();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Secao(Connection con) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeo = new JLabel("Se\u00E7\u00E3o");
		lblSeo.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblSeo.setBounds(299, 149, 60, 25);
		contentPane.add(lblSeo);
		
		JLabel lblNomeDaSeo = new JLabel("Nome da Se\u00E7\u00E3o:");
		lblNomeDaSeo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNomeDaSeo.setBounds(180, 185, 149, 20);
		contentPane.add(lblNomeDaSeo);
		
		txtEsportes = new JTextField();
		txtEsportes.setText("Esportes");
		txtEsportes.setColumns(10);
		txtEsportes.setBounds(309, 186, 156, 25);
		contentPane.add(txtEsportes);
		
		JLabel lblCofDoCoordenador = new JLabel("CPF do Coordenador:");
		lblCofDoCoordenador.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCofDoCoordenador.setBounds(180, 219, 179, 25);
		contentPane.add(lblCofDoCoordenador);
		
		textCPF = new JTextField();
		textCPF.setText("123456789");
		textCPF.setColumns(10);
		textCPF.setBounds(340, 222, 156, 25);
		contentPane.add(textCPF);
		
		JButton btnAdicionarSeo = new JButton("Adicionar Se\u00E7\u00E3o");
		btnAdicionarSeo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//INSERT INTO tb_secao VALUES('Esportes', 	(Select REF(J) FROM tb_jornalista J where j.cpf = '782662490-13'));
				try {
					Statement stmt = con.createStatement();
					String comando = null;
					comando = comando.format("INSERT INTO tb_secao VALUES('%s', 	(Select REF(J) FROM tb_jornalista J where j.cpf = '%s'))", txtEsportes.getText() , textCPF.getText());
					System.out.println(comando);
					new JOptionPane().showMessageDialog(null, "Seção Adicionado com Sucesso");
					stmt.executeUpdate(comando);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		});
		btnAdicionarSeo.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAdicionarSeo.setBounds(239, 415, 237, 35);
		contentPane.add(btnAdicionarSeo);
	}
}
