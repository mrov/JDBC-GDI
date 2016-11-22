package GUIcriadasbestas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Titulação extends JFrame {

	private JPanel contentPane;
	private static Titulação frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//frame = new Titulação();
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
	public Titulação() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulao = new JLabel("Titula\u00E7\u00E3o");
		lblTitulao.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblTitulao.setBounds(263, 159, 84, 25);
		contentPane.add(lblTitulao);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblData.setBounds(220, 194, 60, 20);
		contentPane.add(lblData);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(263, 195, 156, 25);
		contentPane.add(textField);
		
		JLabel lblInstituio = new JLabel("Institui\u00E7\u00E3o:");
		lblInstituio.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblInstituio.setBounds(220, 233, 91, 25);
		contentPane.add(lblInstituio);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(309, 236, 156, 25);
		contentPane.add(textField_1);
		
		JLabel lblGrau = new JLabel("Grau:");
		lblGrau.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblGrau.setBounds(220, 276, 55, 25);
		contentPane.add(lblGrau);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(263, 279, 156, 25);
		contentPane.add(textField_2);
		
		JButton btnAdicionarTitulao = new JButton("Adicionar Titula\u00E7\u00E3o");
		btnAdicionarTitulao.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnAdicionarTitulao.setBounds(220, 415, 237, 35);
		contentPane.add(btnAdicionarTitulao);
	}

}
