package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Candidato;
import util.ConexionPostgreSQL;



public class CandidatoDao {

private ConexionPostgreSQL conexionpost;
	
	private static final String INSERT_CANDIDATO_SQL = "INSERT INTO candidato (nombre, email, pais) VALUES (?,?,?);";
	private static final String DELETE_CANDIDATO_SQL = "DELETE FROM candidato WHERE id = ?;";
	private static final String UPDATE_CANDIDATO_SQL = "UPDATE candidato SET nombre = ?, email = ?, pais = ? WHERE id=?;";
	private static final String SELECT_CANDIDATO_BY_ID = "SELECT * FROM candidato WHERE id = ?;";
	private static final String SELECT_ALL_CANDIDATOS = "SELECT * FROM candidato;";
	
public CandidatoDao() {
		
		this.conexionpost = ConexionPostgreSQL.getConexion();
		
	}
	
	public void insert(Candidato candidato) throws SQLException {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERT_CANDIDATO_SQL);
			preparedStatement.setString(1, candidato.getNombre());
			preparedStatement.setString(2, candidato.getEmail());
			preparedStatement.setString(3, candidato.getPais());
			conexion.execute();
		}catch (SQLException e) {
			
		}
	}
	public void delete (int id) throws SQLException {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(DELETE_CANDIDATO_SQL);
			preparedStatement.setInt(1, id);
			
			conexion.execute();
		}catch (SQLException e) {
			
		}
	}
	
	public void update(Candidato candidato) throws SQLException {
		
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(UPDATE_CANDIDATO_SQL);
			preparedStatement.setString(1, candidato.getNombre());
			preparedStatement.setString(2, candidato.getEmail());
			preparedStatement.setString(3, candidato.getPais());
			preparedStatement.setInt(4, candidato.getId());
			conexion.execute();
		}catch (SQLException e) {
			
		}
	}
	
	public List<Candidato> selectAll(){
		
		List <Candidato> candidato = new ArrayList <>();
		
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_ALL_CANDIDATOS);
			ResultSet rs = conexion.query();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String pais = rs.getString("pais");
				candidatos.add(new Candidato ( id,nombre, email, pais));
				
			}
		}catch(SQLException e) {
			
		}
		return candidatos;
	}
	
public Candidato select(int id){
		Candidato candidato = null;
		
		
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_CANDIDATO_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = conexion.query();
			
			while (rs.next()) {
				
				String nombre = rs.getString("nombre");
				String email = rs.getString("email");
				String pais = rs.getString("pais");
				candidato = new Candidato ( id, nombre, email, pais);
				
			}
		}catch(SQLException e) {
			
		}
		return candidato;
	}
}
