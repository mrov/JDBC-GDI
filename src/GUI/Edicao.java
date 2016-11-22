package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Edicao extends JFrame {

	private JPanel contentPane;
	static Edicao frame;
	private JTextField textFieldCPF;
	private JTextField textFieldData;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//frame = new Edicao();
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
	public Edicao(Connection con) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEdicao = new JLabel("Edi\u00E7\u00E3o");
		lblEdicao.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEdicao.setBounds(363, 183, 60, 25);
		contentPane.add(lblEdicao);
		
		JLabel lblCpfDoChefe = new JLabel("CPF do Chefe:");
		lblCpfDoChefe.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCpfDoChefe.setBounds(217, 220, 149, 20);
		contentPane.add(lblCpfDoChefe);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(326, 219, 156, 25);
		contentPane.add(textFieldCPF);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblData.setBounds(276, 257, 55, 25);
		contentPane.add(lblData);
		
		textFieldData = new JTextField();
		textFieldData.setColumns(10);
		textFieldData.setBounds(326, 257, 156, 25);
		contentPane.add(textFieldData);
		
		textFieldCPF.setText("123456789");
		textFieldData.setText("17/06/1995");
		
		JButton btnAdicionarEdio = new JButton("Adicionar Edi\u00E7\u00E3o");
		btnAdicionarEdio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Statement stmt = con.createStatement();
					String comando = null;
					comando = comando.format("INSERT INTO tb_edicao VALUES(ID_EDICAO.Nextval,(SELECT REF(J) FROM tb_jornalista J where j.cpf = '%s'), TO_DATE('%s', 'dd/MM/yyyy'));", textFieldCPF.getText(),textFieldData.getText());
					System.out.println(comando);
					stmt.executeUpdate(comando);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnAdicionarEdio.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAdicionarEdio.setBounds(287, 415, 237, 35);
		contentPane.add(btnAdicionarEdio);
	}
}
