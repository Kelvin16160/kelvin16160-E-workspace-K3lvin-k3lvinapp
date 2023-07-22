package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DTO.UserDTO;

public class UserDAO {
	
	/* Essas Variaveis de Classe recebem os Identificadores Ex: a Tabela do Banco + BD, e as Colunas Ex idusuario e Senha */
	Connection conn;
	final String BD = "usuario";
	final String idusuario = "idusuario";
	final String senha = "senha";

	
	
	/* Autenticação com o banco passando os get das Vaviaveis de Classe UserDTO, e utilizando os metodos de PreparedStatemant e ResultSet para a comparação com o Banco*/
	public ResultSet autenticationuser(UserDTO userDTO) {

		conn = new Conecxão().Connection();

		try {
			String sql = "select * from " + BD + " where " + idusuario + " = ?" + " and " + senha + " = ?";

			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, userDTO.getUsuario().toString());
			pstm.setString(2, userDTO.getSenha());
			ResultSet rs = pstm.executeQuery();
			return rs;

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Comparação com os Dados do Banco esta Errada " + e);

		}
		return null;
	}

}
