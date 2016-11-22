package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tipposetabelas.*;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdicionarAssinante extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldCPF;
	private JTextField textFieldNome;
	private JTextField textFieldDataNasc;
	private JTextField textFieldTel1;
	private JTextField textFieldTel2;
	private JTextField textFieldTel3;
	private JTextField textFieldTel4;
	private JTextField textFieldTel5;
	private JTextField textFieldCEP;
	private JTextField textFieldCida;
	private JTextField textFieldBairro;
	private JTextField textFieldRua;
	private JTextField textFieldNumero;
	private JTextField textFieldDatassin;
	private static AdicionarAssinante frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//AdicionarAssinante frame = new AdicionarAssinante();
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
	public AdicionarAssinante(Connection con) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setBounds(77, 87, 202, 25);
		contentPane.add(textFieldCPF);
		textFieldCPF.setColumns(10);
		
		JLabel lblCPF = new JLabel("CPF:");
		lblCPF.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCPF.setBounds(25, 87, 72, 25);
		contentPane.add(lblCPF);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNome.setBounds(25, 123, 72, 25);
		contentPane.add(lblNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(77, 123, 202, 25);
		contentPane.add(textFieldNome);
		
		JLabel lblDataDeNascimento = new JLabel("Data de Nascimento:");
		lblDataDeNascimento.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDataDeNascimento.setBounds(25, 157, 164, 25);
		contentPane.add(lblDataDeNascimento);
		
		textFieldDataNasc = new JTextField();
		textFieldDataNasc.setColumns(10);
		textFieldDataNasc.setBounds(186, 160, 202, 25);
		contentPane.add(textFieldDataNasc);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSexo.setBounds(25, 193, 72, 25);
		contentPane.add(lblSexo);
		
		JComboBox comboBoxSexo = new JComboBox();
		comboBoxSexo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		comboBoxSexo.setBounds(77, 198, 112, 20);
		contentPane.add(comboBoxSexo);
		
		JLabel lblTelefone1 = new JLabel("Telefone 1:");
		lblTelefone1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTelefone1.setBounds(25, 229, 93, 25);
		contentPane.add(lblTelefone1);
		
		textFieldTel1 = new JTextField();
		textFieldTel1.setColumns(10);
		textFieldTel1.setBounds(115, 229, 202, 25);
		contentPane.add(textFieldTel1);
		
		JLabel lblTelefone2 = new JLabel("Telefone 2:");
		lblTelefone2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTelefone2.setBounds(25, 265, 93, 25);
		contentPane.add(lblTelefone2);
		
		textFieldTel2 = new JTextField();
		textFieldTel2.setColumns(10);
		textFieldTel2.setBounds(115, 265, 202, 25);
		contentPane.add(textFieldTel2);
		
		JLabel lblTelefone3 = new JLabel("Telefone 3:");
		lblTelefone3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTelefone3.setBounds(25, 301, 93, 25);
		contentPane.add(lblTelefone3);
		
		textFieldTel3 = new JTextField();
		textFieldTel3.setColumns(10);
		textFieldTel3.setBounds(115, 301, 202, 25);
		contentPane.add(textFieldTel3);
		
		JLabel lblTelefone4 = new JLabel("Telefone 4:");
		lblTelefone4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTelefone4.setBounds(25, 337, 93, 25);
		contentPane.add(lblTelefone4);
		
		textFieldTel4 = new JTextField();
		textFieldTel4.setColumns(10);
		textFieldTel4.setBounds(115, 337, 202, 25);
		contentPane.add(textFieldTel4);
		
		JLabel lblTelefone5 = new JLabel("Telefone 5:");
		lblTelefone5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTelefone5.setBounds(25, 374, 93, 25);
		contentPane.add(lblTelefone5);
		
		textFieldTel5 = new JTextField();
		textFieldTel5.setColumns(10);
		textFieldTel5.setBounds(115, 374, 202, 25);
		contentPane.add(textFieldTel5);
		
		JLabel lblEndereco = new JLabel("Endere\u00E7o");
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblEndereco.setBounds(554, 197, 86, 25);
		contentPane.add(lblEndereco);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCep.setBounds(437, 232, 72, 25);
		contentPane.add(lblCep);
		
		textFieldCEP = new JTextField();
		textFieldCEP.setColumns(10);
		textFieldCEP.setBounds(477, 232, 202, 25);
		contentPane.add(textFieldCEP);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCidade.setBounds(437, 268, 72, 25);
		contentPane.add(lblCidade);
		
		textFieldCida = new JTextField();
		textFieldCida.setColumns(10);
		textFieldCida.setBounds(499, 268, 202, 25);
		contentPane.add(textFieldCida);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBairro.setBounds(437, 305, 72, 25);
		contentPane.add(lblBairro);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(492, 305, 202, 25);
		contentPane.add(textFieldBairro);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblRua.setBounds(437, 338, 72, 25);
		contentPane.add(lblRua);
		
		textFieldRua = new JTextField();
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(477, 338, 202, 25);
		contentPane.add(textFieldRua);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNumero.setBounds(437, 374, 72, 25);
		contentPane.add(lblNumero);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(504, 374, 202, 25);
		contentPane.add(textFieldNumero);
		
		JLabel lblInformaesPessoais = new JLabel("Informa\u00E7\u00F5es Pessoais");
		lblInformaesPessoais.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblInformaesPessoais.setBounds(46, 51, 196, 25);
		contentPane.add(lblInformaesPessoais);
		
		JLabel lblPlano = new JLabel("Plano");
		lblPlano.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblPlano.setBounds(564, 51, 55, 25);
		contentPane.add(lblPlano);
		
		JLabel lblPlano_1 = new JLabel("Plano:");
		lblPlano_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPlano_1.setBounds(437, 87, 60, 20);
		contentPane.add(lblPlano_1);
		
		JLabel lblDataDeAssinatura = new JLabel("Data de Assinatura:");
		lblDataDeAssinatura.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDataDeAssinatura.setBounds(437, 123, 149, 25);
		contentPane.add(lblDataDeAssinatura);
		
		textFieldDatassin = new JTextField();
		textFieldDatassin.setColumns(10);
		textFieldDatassin.setBounds(590, 123, 156, 25);
		contentPane.add(textFieldDatassin);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 784, 21);
		contentPane.add(menuBar);
		
		JMenu menu = new JMenu("Adicionar");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Assinante");
		menu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("Plano");
		menu.add(menuItem_1);
		
		JComboBox comboBoxPlano = new JComboBox();
		comboBoxPlano.setModel(new DefaultComboBoxModel(new String[] {"B\u00E1sico", "Combo", "Ultra"}));
		comboBoxPlano.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxPlano.setBounds(492, 87, 72, 20);
		contentPane.add(comboBoxPlano);
		
		//DEBUGER
		
		
		
		
		
		JButton ButtonAdicionar = new JButton("Adicionar Assinante");
		ButtonAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Statement stmt = con.createStatement();
					String[] telefones = new String[5];
					telefones[0] = textFieldTel1.getText();
					telefones[1] = textFieldTel2.getText();
					telefones[2] = textFieldTel3.getText();
					telefones[3] = textFieldTel4.getText();
					telefones[4] = textFieldTel5.getText();
					Telefone tel = new Telefone(telefones);
					String telefone = tel.retornaVarray();
					Endereco end = new Endereco(textFieldCEP.getText(),textFieldCida.getText(),textFieldBairro.getText(),textFieldRua.getText(),textFieldNumero.getText());
					String endereco = end.to_string();
					Assinante Ass = new Assinante(textFieldCPF.getText(), textFieldNome.getText(), textFieldDataNasc.getText(), comboBoxSexo.getSelectedItem().toString().charAt(0) , telefone, endereco, comboBoxPlano.getSelectedItem().toString(), textFieldDatassin.getText());
					System.out.println(Ass.AddAssinante());
					stmt.executeUpdate(Ass.AddAssinante());
					stmt.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		ButtonAdicionar.setFont(new Font("Tahoma", Font.BOLD, 18));
		ButtonAdicionar.setBounds(260, 415, 237, 35);
		contentPane.add(ButtonAdicionar);
	}
}
