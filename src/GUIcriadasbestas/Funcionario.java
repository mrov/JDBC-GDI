package GUIcriadasbestas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class Funcionario extends JFrame {

	private JPanel contentPane;
	Funcionario frame;
	private JTextField textFieldCPF;
	private JTextField textFieldNome;
	private JTextField textFieldDataNasc;
	private JTextField textFieldTel1;
	private JTextField textFieldTel2;
	private JTextField textFieldTel3;
	private JTextField textFieldTel4;
	private JTextField textFieldTel5;
	private JTextField textFieldCEP;
	private JTextField textFieldCidade;
	private JTextField textFieldBairro;
	private JTextField textFieldRua;
	private JTextField textFieldNumero;
	private JTextField textFieldDataAssin;
	private JTextField textFieldSalario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//frame = new Funcionario();
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
	public Funcionario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Informa\u00E7\u00F5es Pessoais");
		label.setFont(new Font("Tahoma", Font.BOLD, 17));
		label.setBounds(65, 51, 196, 25);
		contentPane.add(label);
		
		JLabel labelCPF = new JLabel("CPF:");
		labelCPF.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelCPF.setBounds(44, 87, 72, 25);
		contentPane.add(labelCPF);
		
		textFieldCPF = new JTextField();
		textFieldCPF.setColumns(10);
		textFieldCPF.setBounds(96, 87, 202, 25);
		contentPane.add(textFieldCPF);
		
		JLabel labelNome = new JLabel("Nome:");
		labelNome.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelNome.setBounds(44, 123, 72, 25);
		contentPane.add(labelNome);
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(96, 123, 202, 25);
		contentPane.add(textFieldNome);
		
		JLabel labelDataNasc = new JLabel("Data de Nascimento:");
		labelDataNasc.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelDataNasc.setBounds(44, 157, 164, 25);
		contentPane.add(labelDataNasc);
		
		textFieldDataNasc = new JTextField();
		textFieldDataNasc.setColumns(10);
		textFieldDataNasc.setBounds(205, 160, 202, 25);
		contentPane.add(textFieldDataNasc);
		
		JLabel labelSexo = new JLabel("Sexo:");
		labelSexo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelSexo.setBounds(44, 193, 72, 25);
		contentPane.add(labelSexo);
		
		JComboBox comboBoxSexo = new JComboBox();
		comboBoxSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		comboBoxSexo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		comboBoxSexo.setBounds(96, 198, 112, 20);
		contentPane.add(comboBoxSexo);
		
		JLabel labelTel1 = new JLabel("Telefone 1:");
		labelTel1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelTel1.setBounds(44, 229, 93, 25);
		contentPane.add(labelTel1);
		
		textFieldTel1 = new JTextField();
		textFieldTel1.setColumns(10);
		textFieldTel1.setBounds(134, 229, 202, 25);
		contentPane.add(textFieldTel1);
		
		JLabel labelTel2 = new JLabel("Telefone 2:");
		labelTel2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelTel2.setBounds(44, 265, 93, 25);
		contentPane.add(labelTel2);
		
		textFieldTel2 = new JTextField();
		textFieldTel2.setColumns(10);
		textFieldTel2.setBounds(134, 265, 202, 25);
		contentPane.add(textFieldTel2);
		
		JLabel labelTel3 = new JLabel("Telefone 3:");
		labelTel3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelTel3.setBounds(44, 301, 93, 25);
		contentPane.add(labelTel3);
		
		textFieldTel3 = new JTextField();
		textFieldTel3.setColumns(10);
		textFieldTel3.setBounds(134, 301, 202, 25);
		contentPane.add(textFieldTel3);
		
		JLabel labelTel4 = new JLabel("Telefone 4:");
		labelTel4.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelTel4.setBounds(44, 337, 93, 25);
		contentPane.add(labelTel4);
		
		textFieldTel4 = new JTextField();
		textFieldTel4.setColumns(10);
		textFieldTel4.setBounds(134, 337, 202, 25);
		contentPane.add(textFieldTel4);
		
		JLabel labelTel5 = new JLabel("Telefone 5:");
		labelTel5.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelTel5.setBounds(44, 374, 93, 25);
		contentPane.add(labelTel5);
		
		textFieldTel5 = new JTextField();
		textFieldTel5.setColumns(10);
		textFieldTel5.setBounds(134, 374, 202, 25);
		contentPane.add(textFieldTel5);
		
		JLabel label_10 = new JLabel("Endere\u00E7o");
		label_10.setFont(new Font("Tahoma", Font.BOLD, 17));
		label_10.setBounds(573, 197, 86, 25);
		contentPane.add(label_10);
		
		JLabel labelCep = new JLabel("CEP:");
		labelCep.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelCep.setBounds(456, 232, 72, 25);
		contentPane.add(labelCep);
		
		textFieldCEP = new JTextField();
		textFieldCEP.setColumns(10);
		textFieldCEP.setBounds(496, 232, 202, 25);
		contentPane.add(textFieldCEP);
		
		JLabel labelCida = new JLabel("Cidade:");
		labelCida.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelCida.setBounds(456, 268, 72, 25);
		contentPane.add(labelCida);
		
		textFieldCidade = new JTextField();
		textFieldCidade.setColumns(10);
		textFieldCidade.setBounds(518, 268, 202, 25);
		contentPane.add(textFieldCidade);
		
		JLabel labelBair = new JLabel("Bairro:");
		labelBair.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelBair.setBounds(456, 305, 72, 25);
		contentPane.add(labelBair);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setColumns(10);
		textFieldBairro.setBounds(511, 305, 202, 25);
		contentPane.add(textFieldBairro);
		
		JLabel labelRua = new JLabel("Rua:");
		labelRua.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelRua.setBounds(456, 338, 72, 25);
		contentPane.add(labelRua);
		
		textFieldRua = new JTextField();
		textFieldRua.setColumns(10);
		textFieldRua.setBounds(496, 338, 202, 25);
		contentPane.add(textFieldRua);
		
		JLabel labelNum = new JLabel("Numero:");
		labelNum.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelNum.setBounds(456, 374, 72, 25);
		contentPane.add(labelNum);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setColumns(10);
		textFieldNumero.setBounds(523, 374, 202, 25);
		contentPane.add(textFieldNumero);
		
		JButton buttonAdd = new JButton("Adicionar Assinante");
		buttonAdd.setFont(new Font("Tahoma", Font.BOLD, 18));
		buttonAdd.setBounds(279, 415, 237, 35);
		contentPane.add(buttonAdd);
		
		JLabel lblInfoFuncionario = new JLabel("Informa\u00E7\u00F5es Funcionario");
		lblInfoFuncionario.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblInfoFuncionario.setBounds(511, 51, 220, 25);
		contentPane.add(lblInfoFuncionario);
		
		JLabel labelDataAssin = new JLabel("Data de Assinatura:");
		labelDataAssin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		labelDataAssin.setBounds(456, 123, 149, 25);
		contentPane.add(labelDataAssin);
		
		textFieldDataAssin = new JTextField();
		textFieldDataAssin.setColumns(10);
		textFieldDataAssin.setBounds(609, 123, 156, 25);
		contentPane.add(textFieldDataAssin);
		
		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblSalario.setBounds(456, 87, 72, 25);
		contentPane.add(lblSalario);
		
		textFieldSalario = new JTextField();
		textFieldSalario.setColumns(10);
		textFieldSalario.setBounds(523, 87, 242, 25);
		contentPane.add(textFieldSalario);
	}

}
