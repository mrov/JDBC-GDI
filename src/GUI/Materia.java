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

public class Materia extends JFrame {

	private JPanel contentPane;
	private JTextField txtSecao;
	private JTextField textIDedi;
	private JTextField txtTitulo;
	private JTextField txtConteudo;
	private JTextField txtAnexos;

	/**
	 * Launch the application.
	 */
	//Metodos
	
	public String Conteudonull(String conteudo){
		if(conteudo.equalsIgnoreCase("")){return "NULL";}
		return conteudo;
	}
	
	public String Anexosnull(String Anexos){
		if(Anexos.equalsIgnoreCase("")){return "NULL";}
		return Anexos;
	}
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//Materia frame = new Materia();
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
	public Materia(Connection con) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMateria = new JLabel("Materia");
		lblMateria.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMateria.setBounds(148, 50, 79, 25);
		contentPane.add(lblMateria);
		
		JLabel lblIdDaSeo = new JLabel("Nome da Se\u00E7\u00E3o:");
		lblIdDaSeo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIdDaSeo.setBounds(29, 86, 149, 20);
		contentPane.add(lblIdDaSeo);
		
		txtSecao = new JTextField();
		txtSecao.setText("Esportes");
		txtSecao.setColumns(10);
		txtSecao.setBounds(158, 86, 156, 25);
		contentPane.add(txtSecao);
		
		JLabel lblIdDaEdio = new JLabel("ID da Edi\u00E7\u00E3o:");
		lblIdDaEdio.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblIdDaEdio.setBounds(29, 120, 179, 25);
		contentPane.add(lblIdDaEdio);
		
		textIDedi = new JTextField();
		textIDedi.setText("1");
		textIDedi.setColumns(10);
		textIDedi.setBounds(132, 121, 156, 25);
		contentPane.add(textIDedi);
		
		JLabel lblTitulo = new JLabel("Titulo:");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTitulo.setBounds(29, 156, 179, 25);
		contentPane.add(lblTitulo);
		
		txtTitulo = new JTextField();
		txtTitulo.setText("Pai de familia conserta carro");
		txtTitulo.setColumns(10);
		txtTitulo.setBounds(86, 156, 156, 25);
		contentPane.add(txtTitulo);
		
		JLabel lblConteudo = new JLabel("Conteudo:");
		lblConteudo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblConteudo.setBounds(29, 192, 79, 25);
		contentPane.add(lblConteudo);
		
		txtConteudo = new JTextField();
		txtConteudo.setText("Conteudo da materia");
		txtConteudo.setColumns(10);
		txtConteudo.setBounds(109, 192, 420, 122);
		contentPane.add(txtConteudo);
		
		JLabel lblAnexos = new JLabel("Anexos:");
		lblAnexos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblAnexos.setBounds(29, 325, 79, 25);
		contentPane.add(lblAnexos);
		
		txtAnexos = new JTextField();
		txtAnexos.setText("Anexos relacionados a materia");
		txtAnexos.setColumns(10);
		txtAnexos.setBounds(109, 325, 420, 122);
		contentPane.add(txtAnexos);
		
		JButton btnAdicionarMateria = new JButton("Adicionar Materia");
		btnAdicionarMateria.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//INSERT INTO tb_materia VALUES(ID_MATERIA.Nextval, (Select REF(g) from tb_secao g where g.nome = 'Esportes'), (SELECT REF(E) FROM tb_edicao E WHERE e.numero = 1), 'Vasco perde e é vice novamente',            	NULL, NULL);
				try {
					Statement stmt = con.createStatement();
					String comando = null;
					comando = comando.format("INSERT INTO tb_materia VALUES(ID_MATERIA.Nextval, (Select REF(g) from tb_secao g where g.nome = '%s'), (SELECT REF(E) FROM tb_edicao E WHERE e.numero = %s), '%s', '%s', '%s')", txtSecao.getText(),textIDedi.getText(),txtTitulo.getText(),Conteudonull(txtConteudo.getText()),Anexosnull(txtAnexos.getText()));
					System.out.println(comando);
					new JOptionPane().showMessageDialog(null, "Materia Adicionado com Sucesso");
					stmt.executeUpdate(comando);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAdicionarMateria.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAdicionarMateria.setBounds(539, 329, 237, 76);
		contentPane.add(btnAdicionarMateria);
	}
}
