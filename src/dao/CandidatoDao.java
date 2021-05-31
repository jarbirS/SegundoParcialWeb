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
	
	private static final String INSERT_CANDIDATO_SQL = "INSERT INTO candidato (documento, nombre, apellido, numero) VALUES (?,?,?,?);";
	private static final String DELETE_CANDIDATO_SQL = "DELETE FROM candidato WHERE id = ?;";
	private static final String UPDATE_CANDIDATO_SQL = "UPDATE candidato SET documento = ?, nombre = ?, apellido = ?, numero = ? WHERE id=?;";
	private static final String SELECT_CANDIDATO_BY_ID = "SELECT * FROM candidato WHERE id = ?;";
	private static final String SELECT_ALL_CANDIDATOS = "SELECT * FROM candidato;";
	
public CandidatoDao() {
		
		this.conexionpost = ConexionPostgreSQL.getConexion();
		
	}
	
	public void insert(Candidato candidato) throws SQLException {
		try {
			PreparedStatement preparedStatement = conexionpost.setPreparedStatement(INSERT_CANDIDATO_SQL);
			preparedStatement.setString(1, candidato.getDocumento());
			preparedStatement.setString(2, candidato.getNombre());
			preparedStatement.setString(3, candidato.getApellido());
			preparedStatement.setInt(4, candidato.getNumero());
			conexionpost.execute();
		}catch (SQLException e) {
			
		}
	}
	public void delete (int id) throws SQLException {
		try {
			PreparedStatement preparedStatement = conexionpost.setPreparedStatement(DELETE_CANDIDATO_SQL);
			preparedStatement.setInt(1, id);
			
			conexionpost.execute();
		}catch (SQLException e) {
			
		}
	}
	
	public void update(Candidato candidato) throws SQLException {
		
		try {
			PreparedStatement preparedStatement = conexionpost.setPreparedStatement(UPDATE_CANDIDATO_SQL);
			preparedStatement.setString(1, candidato.getDocumento());
			preparedStatement.setString(2, candidato.getNombre());
			preparedStatement.setString(3, candidato.getApellido());
			preparedStatement.setInt(4, candidato.getNumero());
			preparedStatement.setInt(5, candidato.getId());
			conexionpost.execute();
		}catch (SQLException e) {
			
		}
	}
	
	public List<Candidato> selectAll(){
		
		List <Candidato> candidatos = new ArrayList <>();
		
		try {
			PreparedStatement preparedStatement = conexionpost.setPreparedStatement(SELECT_ALL_CANDIDATOS);
			ResultSet rs = conexionpost.query();
			
			while (rs.next()) {
				int id = rs.getInt("id");
				String documento = rs.getString("documento");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				int numero = rs.getInt("numero");
				candidatos.add(new Candidato( id, documento, nombre, apellido, numero));
				
			}
		}catch(SQLException e) {
			
		}
		return candidatos;
	}
	
public Candidato select(int id){
		Candidato candidato = null;
		
		
		try {
			PreparedStatement preparedStatement = conexionpost.setPreparedStatement(SELECT_CANDIDATO_BY_ID);
			preparedStatement.setInt(1, id);
			
			ResultSet rs = conexionpost.query();
			
			while (rs.next()) {
				
				String documento = rs.getString("documento");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				int numero = rs.getInt("numero");
				candidato = new Candidato ( id, documento, nombre, apellido, numero);
				
			}
		}catch(SQLException e) {
			
		}
		return candidato;
	}
}
