package Login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import DAO.UserDAO;
import DTO.UserDTO;
import Login.Front;
import javax.swing.DropMode;
import java.awt.Component;

public class Login {

	private JFrame frmUsuario;
	private JTextField txtLogin;
	private JTextField txtSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

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
					Login window = new Login();
					window.frmUsuario.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frmUsuario = new JFrame();
		frmUsuario.setType(Type.POPUP);
		frmUsuario.setFocusCycleRoot(false);
		frmUsuario.setFocusTraversalKeysEnabled(false);
		frmUsuario.setFocusable(false);
		frmUsuario.setAutoRequestFocus(false);
		frmUsuario.getContentPane().setFocusTraversalKeysEnabled(false);
		frmUsuario.getContentPane().setFocusable(false);
		frmUsuario.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\K3lvin\\Pictures\\Captura de tela 2023-06-17 210442.png"));
		frmUsuario.setTitle("Calc By Kelvin");
		frmUsuario.getContentPane().setBackground(new Color(128, 128, 128));
		frmUsuario.setBounds(100, 100, 529, 470);
		frmUsuario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUsuario.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(10, 14, 104, 16);
		frmUsuario.getContentPane().add(lblNewLabel);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 91, 104, 16);
		frmUsuario.getContentPane().add(lblSenha);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\K3lvin\\Downloads\\17buNI-removebg-preview.png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setRequestFocusEnabled(false);
		lblNewLabel_1.setBounds(257, 0, 256, 431);
		frmUsuario.getContentPane().add(lblNewLabel_1);

		txtLogin = new JTextField();
		txtLogin.setBounds(10, 39, 227, 29);
		frmUsuario.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);

		txtSenha = new JTextField();
		txtSenha.setColumns(10);
		txtSenha.setBounds(10, 119, 227, 29);
		frmUsuario.getContentPane().add(txtSenha);

		JButton btnLogar = new JButton("Logar");
		btnLogar.setBounds(69, 165, 104, 37);
		btnLogar.setDisabledIcon(null);
		frmUsuario.getContentPane().add(btnLogar);
		
		JButton btnCadastro = new JButton("Cadastro");
		btnCadastro.setBounds(40, 223, 163, 23);
		frmUsuario.getContentPane().add(btnCadastro);

		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					UserDTO User = new UserDTO();

					User.setUsuario(txtLogin.getText());
					User.setSenha(txtSenha.getText());
					UserDAO user = new UserDAO();
					ResultSet rsResultSet = user.autenticationuser(User);
					if (rsResultSet.next()) {
						Front front = new Front();
						JOptionPane.showMessageDialog(null, "Bem vindo!");
						txtLogin.setText(null);
						txtSenha.setText(null);
						frmUsuario.setVisible(false);

					} else {
						txtLogin.setText(null);
						txtSenha.setText(null);
						JOptionPane.showMessageDialog(null, "Dados invalidos");
						JOptionPane.showMessageDialog(null,
								"Usuario Digitada:\n" + User.getUsuario() + "\nSenha Digitado:\n" + User.getSenha());
					}
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, erro);
				}

			}
		});
	}
}
