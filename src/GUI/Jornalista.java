package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tipposetabelas.Endereco;
import tipposetabelas.Telefone;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Jornalista extends JFrame {

	private JPanel contentPane;
	private static Jornalista frame;
	private JTextField textFieldCPF;
	private JTextField textFieldNome;
	private JTextField textFieldDataNasc;
	private JTextField textFieldTel1;
	private JTextField textFieldTel2;
	private JTextField textFieldTel4;
	private JTextField textFieldTel5;
	private JTextField textFieldCEP;
	private JTextField textFieldCida;
	private JTextField textFieldBairro;
	private JTextField textFieldRua;
	private JTextField textFieldNumero;
	private JTextField textFieldDataAdm;
	private JTextField textFieldSalario;
	private JTextField textFieldMTB;
	private JTextField textFieldSup;
	private JTextField textFieldDatatitu;
	private JTextField textFieldInst;
	private JTextField textFieldGrau;
	private JTextField textFieldTel3;

	/**
	 * Launch the application.
	 */
	
	public String supervisor(String CPF){
		if(CPF.equalsIgnoreCase("")){return "NULL";}
		return CPF;	
	}
	
	public String titulacao(String data, String instituicao,String Grau){
		//tp_titulacao(TO_DATE('22/04/1979','dd/MM/yyyy') , 'Universidade Federal de Pernambuco', 'Bacharelado'))
		if(Grau.equalsIgnoreCase("")){return "NULL";}
		String retorno = null;
		retorno = retorno.format("tp_titulacao(TO_DATE('%s','dd/MM/yyyy') , '%s', '%s'))", data,instituicao,Grau);
		return retorno;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//frame = new Jornalista();
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
	public Jornalista(Connection con) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1079, 545);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Informa\u00E7\u00F5es Pessoais");
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		label.setBounds(42, 38, 196, 25);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("CPF:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_1.setBounds(21, 74, 72, 25);
		contentPane.add(label_1);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(73, 74, 202, 25);
		contentPane.add(textFieldCPF);
		
		JLabel label_2 = new JLabel("Nome:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_2.setBounds(21, 110, 72, 25);
		contentPane.add(label_2);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(73, 110, 202, 25);
		contentPane.add(textFieldNome);
		
		JLabel label_3 = new JLabel("Data de Nascimento:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_3.setBounds(21, 144, 164, 25);
		contentPane.add(label_3);
		
		textFieldDataNasc = new JTextField();
		textFieldDataNasc.setColumns(10);
		textFieldDataNasc.setBounds(182, 147, 202, 25);
		contentPane.add(textFieldDataNasc);
		
		JLabel label_4 = new JLabel("Sexo:");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_4.setBounds(21, 180, 72, 25);
		contentPane.add(label_4);
		
		JComboBox comboBoxSexo = new JComboBox();
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		comboBoxSexo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxSexo.setBounds(73, 185, 112, 20);
		contentPane.add(comboBoxSexo);
		
		JLabel label_5 = new JLabel("Telefone 1:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_5.setBounds(21, 216, 93, 25);
		contentPane.add(label_5);
		
		textFieldTel1 = new JTextField();
		textFieldTel1.setColumns(10);
		textFieldTel1.setBounds(111, 216, 202, 25);
		contentPane.add(textFieldTel1);
		
		JLabel label_6 = new JLabel("Telefone 2:");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_6.setBounds(21, 252, 93, 25);
		contentPane.add(label_6);
		
		textFieldTel2 = new JTextField();
		textFieldTel2.setColumns(10);
		textFieldTel2.setBounds(111, 252, 202, 25);
		contentPane.add(textFieldTel2);
		
		JLabel label_7 = new JLabel("Telefone 3:");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_7.setBounds(21, 288, 93, 25);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("Telefone 4:");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_8.setBounds(21, 324, 93, 25);
		contentPane.add(label_8);
		
		textFieldTel4 = new JTextField();
		textFieldTel4.setColumns(10);
		textFieldTel4.setBounds(111, 324, 202, 25);
		contentPane.add(textFieldTel4);
		
		JLabel label_9 = new JLabel("Telefone 5:");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_9.setBounds(21, 361, 93, 25);
		contentPane.add(label_9);
		
		textFieldTel5 = new JTextField();
		textFieldTel5.setColumns(10);
		textFieldTel5.setBounds(111, 361, 202, 25);
		contentPane.add(textFieldTel5);
		
		JLabel label_10 = new JLabel("Endere\u00E7o");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_10.setBounds(546, 216, 86, 25);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("CEP:");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_11.setBounds(429, 243, 72, 25);
		contentPane.add(label_11);
		
		textFieldCEP = new JTextField();
		textFieldCEP.setColumns(10);
		textFieldCEP.setBounds(469, 243, 202, 25);
		contentPane.add(textFieldCEP);
		
		JLabel label_12 = new JLabel("Cidade:");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_12.setBounds(429, 279, 72, 25);
		contentPane.add(label_12);
		
		textFieldCida = new JTextField();
		textFieldCida.setColumns(10);
		textFieldCida.setBounds(491, 279, 202, 25);
		contentPane.add(textFieldCida);
		
		JLabel label_13 = new JLabel("Bairro:");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_13.setBounds(429, 316, 72, 25);
		contentPane.add(label_13);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(484, 316, 202, 25);
		contentPane.add(textFieldBairro);
		
		JLabel label_14 = new JLabel("Rua:");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_14.setBounds(429, 349, 72, 25);
		contentPane.add(label_14);
		
		textFieldRua = new JTextField();
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(469, 349, 202, 25);
		contentPane.add(textFieldRua);
		
		JLabel label_15 = new JLabel("Numero:");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_15.setBounds(429, 385, 72, 25);
		contentPane.add(label_15);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(496, 385, 202, 25);
		contentPane.add(textFieldNumero);
		
		
		JLabel lblInformaesJornalista = new JLabel("Informa\u00E7\u00F5es Jornalista");
		lblInformaesJornalista.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblInformaesJornalista.setBounds(469, 38, 202, 25);
		contentPane.add(lblInformaesJornalista);
		
		JLabel lblDataDeAdmiss = new JLabel("Data de Admiss\u00E3o:");
		lblDataDeAdmiss.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDataDeAdmiss.setBounds(429, 110, 149, 25);
		contentPane.add(lblDataDeAdmiss);
		
		textFieldDataAdm = new JTextField();
		textFieldDataAdm.setColumns(10);
		textFieldDataAdm.setBounds(582, 110, 156, 25);
		contentPane.add(textFieldDataAdm);
		
		JLabel label_18 = new JLabel("Salario:");
		label_18.setFont(new Font("Tahoma", Font.PLAIN, 17));
		label_18.setBounds(429, 74, 72, 25);
		contentPane.add(label_18);
		
		textFieldSalario = new JTextField();
		textFieldSalario.setColumns(10);
		textFieldSalario.setBounds(496, 74, 123, 25);
		contentPane.add(textFieldSalario);
		
		JLabel lblMtb = new JLabel("MTB:");
		lblMtb.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblMtb.setBounds(429, 144, 57, 25);
		contentPane.add(lblMtb);
		
		textFieldMTB = new JTextField();
		textFieldMTB.setColumns(10);
		textFieldMTB.setBounds(476, 147, 123, 25);
		contentPane.add(textFieldMTB);
		
		JLabel lblSupervisor = new JLabel("Supervisor:");
		lblSupervisor.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSupervisor.setBounds(429, 180, 93, 25);
		contentPane.add(lblSupervisor);
		
		textFieldSup = new JTextField();
		textFieldSup.setColumns(10);
		textFieldSup.setBounds(516, 183, 123, 25);
		contentPane.add(textFieldSup);
		
		JLabel lblTitulao = new JLabel("Titula\u00E7\u00E3o");
		lblTitulao.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTitulao.setBounds(804, 38, 93, 25);
		contentPane.add(lblTitulao);
		
		JLabel lblData_1 = new JLabel("Data:");
		lblData_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblData_1.setBounds(748, 74, 72, 25);
		contentPane.add(lblData_1);
		
		textFieldDatatitu = new JTextField();
		textFieldDatatitu.setColumns(10);
		textFieldDatatitu.setBounds(795, 74, 123, 25);
		contentPane.add(textFieldDatatitu);
		
		JLabel lblData = new JLabel("Institui\u00E7\u00E3o:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblData.setBounds(748, 110, 85, 25);
		contentPane.add(lblData);
		
		textFieldInst = new JTextField();
		textFieldInst.setColumns(10);
		textFieldInst.setBounds(843, 110, 214, 25);
		contentPane.add(textFieldInst);
		
		JLabel lblGrau = new JLabel("Grau:");
		lblGrau.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGrau.setBounds(748, 144, 57, 25);
		contentPane.add(lblGrau);
		
		textFieldGrau = new JTextField();
		textFieldGrau.setColumns(10);
		textFieldGrau.setBounds(795, 144, 123, 25);
		contentPane.add(textFieldGrau);
		
		textFieldTel3 = new JTextField();
		textFieldTel3.setColumns(10);
		textFieldTel3.setBounds(111, 288, 202, 25);
		contentPane.add(textFieldTel3);
		
		
		
		
		
		
		
		
		
		
		
		
		//DEBUGADOR!!!
		
		textFieldBairro.setText("qualquer");
		textFieldCPF.setText("qualquer");
		textFieldNome.setText("qualquer");
		textFieldCEP.setText("qualquer");
		textFieldTel1.setText("qualquer");
		textFieldNumero.setText("qualquer");
		textFieldSalario.setText("1600.00");
		textFieldCida.setText("qualquer");
		textFieldDataAdm.setText("11/06/1985");
		textFieldDataNasc.setText("11/06/1985");
		textFieldCida.setText("qualquer");
		textFieldRua.setText("qualquer");
		textFieldMTB.setText("qualquer");
		
		/*
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
		String comando = null;
		comando = comando.format("INSERT INTO tb_jornalista VALUES("
				+ "'%s', "
				+ "'%s', "
				+ "TO_DATE('%s', 'dd/MM/yyyy'), "
				+ "'%c', "
				+ "%s, "
				+ "%s, "
				+ "%s, "
				+ "TO_DATE('%s', 'dd/MM/yyyy'), "
				+ "'%s', "
				+ "%s, "
				+ "%s)" ,
				textFieldCPF.getText(),
				textFieldNome.getText(),
				textFieldDataNasc.getText(),
				comboBoxSexo.getSelectedItem().toString().charAt(0),
				telefone,
				endereco,
				textFieldSalario.getText(),
				textFieldDataAdm.getText(),
				textFieldMTB.getText(),
				supervisor(textFieldSup.getText()),
				titulacao(textFieldDatatitu.getText(), textFieldInst.getText(), textFieldGrau.getText())
				);
		
		
		System.out.println(comando);
		*/
		
		
		
		
		
		
		
		
		JButton btnAdicionarJornalista = new JButton("Adicionar Jornalista");
		btnAdicionarJornalista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//INSERT INTO tb_jornalista VALUES('658775462-03', 'Catarina Abreu',       TO_DATE('28/02/1988', 'dd/MM/yyyy'), 'F',varray_fones(tp_fone('081-934003663'), tp_fone('081-965987452'), tp_fone('081-9913584956')),tp_endereco('35741200', 'Fortaleza', 'Meireles', 'Rua Oswaldo Cruz', '1'), 1600.00, TO_DATE('15/08/2014', 'dd/MM/yyyy'),'92425/12/43/SP',NULL,tp_titulacao(TO_DATE('22/04/1979','dd/MM/yyyy') , 'Universidade Federal de Pernambuco', 'Bacharelado'));
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
					String comando = null;
					comando = comando.format("INSERT INTO tb_jornalista VALUES("
							+ "'%s', "
							+ "'%s', "
							+ "TO_DATE('%s', 'dd/MM/yyyy'), "
							+ "'%c', "
							+ "%s, "
							+ "%s, "
							+ "%s, "
							+ "TO_DATE('%s', 'dd/MM/yyyy'), "
							+ "'%s', "
							+ "%s, "
							+ "%s) ",
							textFieldCPF.getText(),
							textFieldNome.getText(),
							textFieldDataNasc.getText(),
							comboBoxSexo.getSelectedItem().toString().charAt(0),
							telefone,
							endereco,
							textFieldSalario.getText(),
							textFieldDataAdm.getText(),
							textFieldMTB.getText(),
							supervisor(textFieldSup.getText()),
							titulacao(textFieldDatatitu.getText(), textFieldInst.getText(), textFieldGrau.getText())
							);
					stmt.executeQuery(comando);
					new JOptionPane().showMessageDialog(null, "Jornalista Adicionado com Sucesso");
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnAdicionarJornalista.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAdicionarJornalista.setBounds(341, 450, 237, 35);
		contentPane.add(btnAdicionarJornalista);
	}

}
