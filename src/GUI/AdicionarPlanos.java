package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tipposetabelas.*;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.sql.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdicionarPlanos extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldPreco;
	private JTextField textFieldPlano;
	private static AdicionarPlanos frame;
	private Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//AdicionarPlanos frame = new AdicionarPlanos();
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
	public AdicionarPlanos(Connection con) {
		this.con = con;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlano = new JLabel("Plano");
		lblPlano.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPlano.setBounds(340, 132, 55, 25);
		contentPane.add(lblPlano);
		
		JLabel lblPlano_1 = new JLabel("Plano:");
		lblPlano_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPlano_1.setBounds(268, 167, 60, 20);
		contentPane.add(lblPlano_1);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o:");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPreco.setBounds(268, 204, 55, 25);
		contentPane.add(lblPreco);
		
		textFieldPlano = new JTextField();
		textFieldPreco = new JTextField();
		textFieldPreco.setColumns(10);
		textFieldPreco.setBounds(323, 205, 156, 25);
		contentPane.add(textFieldPreco);
		
		JButton btnAdicionarPlano = new JButton("Adicionar Plano");
		btnAdicionarPlano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//Cria um statement e cria um objeto plano com os valores nos campos de texto, depois executa o comando gerado pelos valores do texto
					Statement stmt = con.createStatement();
					Plano pl = new Plano(textFieldPlano.getText(),Double.parseDouble(textFieldPreco.getText()));
					String comando = pl.AddPlano();
					stmt.executeUpdate(comando);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAdicionarPlano.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAdicionarPlano.setBounds(254, 415, 237, 35);
		contentPane.add(btnAdicionarPlano);
		
		
		textFieldPlano.setColumns(10);
		textFieldPlano.setBounds(323, 167, 156, 25);
		contentPane.add(textFieldPlano);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 784, 21);
		contentPane.add(menuBar);
		
		JMenu menu = new JMenu("Adicionar");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Assinante");
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Plano");
		menu.add(menuItem_1);
	}

}
