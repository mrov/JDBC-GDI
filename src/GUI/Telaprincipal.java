package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class Telaprincipal extends JFrame {

	private JPanel contentPane;
	private static Telaprincipal frame;
	private Connection con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//frame = new Telaprincipal();
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
	public Telaprincipal(Connection con) {
		this.con = con;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnAdicionar = new JMenu("Adicionar");
		menuBar.add(mnAdicionar);
		
		JMenuItem mntmAssinante = new JMenuItem("Assinante");
		mntmAssinante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AdicionarAssinante novatela = new AdicionarAssinante(con);
				novatela.setVisible(true);
				dispose();
			}
		});
		mnAdicionar.add(mntmAssinante);
		
		JMenuItem mntmPlano = new JMenuItem("Plano");
		mntmPlano.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdicionarPlanos novatela = new AdicionarPlanos(con);
				novatela.setVisible(true);
				dispose();
			}
		});
		mnAdicionar.add(mntmPlano);
		
		JMenuItem mntmEdio = new JMenuItem("Edi\u00E7\u00E3o");
		mntmEdio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Edicao novatela = new Edicao(con);
				novatela.setVisible(true);
				dispose();
			}
		});
		mnAdicionar.add(mntmEdio);
		
		JMenuItem mntmJornalista = new JMenuItem("Jornalista");
		mntmJornalista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Jornalista novatela = new Jornalista(con);
				novatela.setVisible(true);
				dispose();
			}
		});
		mnAdicionar.add(mntmJornalista);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBemVindoGerenciador = new JLabel("Bem vindo Gerenciador do Banco");
		lblBemVindoGerenciador.setFont(new Font("Tahoma", Font.PLAIN, 43));
		lblBemVindoGerenciador.setForeground(Color.BLUE);
		lblBemVindoGerenciador.setBounds(75, 125, 642, 156);
		contentPane.add(lblBemVindoGerenciador);
	}
}
