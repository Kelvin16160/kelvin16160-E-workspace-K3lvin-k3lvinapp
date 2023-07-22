package Login;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.Label;

public class Front {

	private JFrame frame;
	private JTextField txtValor1;
	private JTextField txtValor2;

	/**
	 * Launch the application.
	 */
	public void frontend() {

		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) {
			

		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Front window = new Front();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Front() {
		initialize();
	}

	/**
	 * Inicia o Programa
	 */
	public void initialize() {

		frame = new JFrame();
		frame.getContentPane().setFocusable(true);
		frame.getContentPane().setVisible(true);
		frame.getContentPane().setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
		frame.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frame.setVisible(true);
		frame.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 12));
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\K3lvin\\Pictures\\Captura de tela 2023-06-17 210442.png"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Calc By K3lvin");
		frame.getContentPane().setBackground(new Color(192, 192, 192));
		frame.setBounds(100, 100, 520, 383);
		frame.getContentPane().setLayout(null);

		// Textos de identificao

		JLabel lblEscrevaOSegundo = new JLabel("Escreva o Segundo Valor");
		lblEscrevaOSegundo.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
		lblEscrevaOSegundo.setBounds(10, 66, 135, 15);
		frame.getContentPane().add(lblEscrevaOSegundo);

		JLabel lblNewLabel = new JLabel("Escreva o Primeiro Valor");
		lblNewLabel.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel.setBounds(10, 11, 135, 15);
		frame.getContentPane().add(lblNewLabel);

		// Box dos Valores

		txtValor1 = new JTextField();
		txtValor1.setBounds(10, 35, 130, 25);
		frame.getContentPane().add(txtValor1);
		txtValor1.setColumns(10);

		txtValor2 = new JTextField();
		txtValor2.setBounds(10, 85, 130, 25);
		frame.getContentPane().add(txtValor2);
		txtValor2.setColumns(10);

		JComboBox<?> comboBox = new JComboBox();
		comboBox.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 11));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Soma", "Subt", "Div", "Mult" }));
		comboBox.setBounds(10, 121, 89, 22);
		frame.getContentPane().add(comboBox);

		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.setSelectedIcon(new ImageIcon("C:\\Users\\K3lvin\\Pictures\\Captura de tela 2023-06-17 210442.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedItem().equals("Soma")) {
					int number1 = Integer.parseInt(txtValor1.getText());
					int number2 = Integer.parseInt(txtValor2.getText());
					int Result = number1 + number2;

					JOptionPane.showMessageDialog(null, "Resultado\n" + Result);

				} else if (comboBox.getSelectedItem().equals("Subt")) {
					int number1 = Integer.parseInt(txtValor1.getText());
					int number2 = Integer.parseInt(txtValor2.getText());
					int Result = number1 - number2;

					JOptionPane.showMessageDialog(null, "Resultado\\n" + Result);

				} else if (comboBox.getSelectedItem().equals("Div")) {
					int number1 = Integer.parseInt(txtValor1.getText());
					int number2 = Integer.parseInt(txtValor2.getText());
					int Result = number1 / number2;

					JOptionPane.showMessageDialog(null, "Resultado\\n" + Result);

				}else if (comboBox.getSelectedItem().equals("Subt")) {
					int number1 = Integer.parseInt(txtValor1.getText());
					int number2 = Integer.parseInt(txtValor2.getText());
					int Result = number1 - number2;

					JOptionPane.showMessageDialog(null, "Resultado\n" + Result);

				}else if (comboBox.getSelectedItem().equals("Mult")) {
					int number1 = Integer.parseInt(txtValor1.getText());
					int number2 = Integer.parseInt(txtValor2.getText());
					int Result = number1 * number2;

					JOptionPane.showMessageDialog(null, "Resultado\\n" + Result);

				}
			}
		});
		btnNewButton.setBounds(164, 220, 164, 31);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Selecione o Operador.");
		lblNewLabel_1.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(198, 11, 130, 20);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\K3lvin\\Downloads\\17buNI-removebg-preview.png"));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(0, 0, 504, 344);
		frame.getContentPane().add(lblNewLabel_2);

	}
}
