package com.barbosa.dao;

import com.barbosa.dao.Conexao;
import com.barbosa.model.Interessado;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

import org.apache.log4j.Logger;

public class InteressadoDao {
	private static final Logger logger = Logger.getLogger(InteressadoDao.class);
	
	public void insereInteressado(Interessado interessado){
		PreparedStatement stmt = null;
		
		try{
			if(interessado == null)
				throw new Exception("Interessado inv‡lido!");
			
			String sql = "insert into interessado(nome, telefone, email, interesse) values(?, ?, ?, ?)";
			
			stmt = Conexao.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, interessado.getNome());
			stmt.setString(2, interessado.getTelefone());
			stmt.setString(3, interessado.getEmail());
			stmt.setString(4, interessado.getInteresse());
			
			stmt.executeUpdate();

		    ResultSet rs = stmt.getGeneratedKeys();

		    if ( rs.next() ) {
		        interessado.setId( rs.getInt(1) );
		    } else {
		    	throw new Exception("Nenhum registro inserido.");
		    }

		    rs.close();
			
			Conexao.getConnection().commit();
			
		}catch(Exception e){
			try{
				Conexao.getConnection().rollback();
				logger.error("Problemas inserindo interessado.", e);
			}catch(Exception eRollback){
				logger.error("Problemas com rollback", eRollback);
			}
		}finally{
			try{
				if(stmt != null) stmt.close();
			}catch(Exception eSql){
				logger.error("Erro liberando recursos", eSql);
			}
		}
	}
	
	public Interessado obtemInteressado(Integer id){
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Interessado interessado = null;
		
		try{
			if(id == null){
				throw new Exception("ID nulo nao vale");
			}
			
			String sql = "select * from interessado where id = ?";
			stmt = Conexao.getConnection().prepareStatement(sql);
			stmt.setInt(1, id);
			
			rs = stmt.executeQuery();
			
			if(rs.next()){
				interessado = new Interessado();
				interessado.setId( rs.getInt("ID") );
				interessado.setNome( rs.getString("NOME") );
				interessado.setTelefone( rs.getString("TELEFONE") );
				interessado.setEmail( rs.getString("EMAIL") );
				interessado.setInteresse( rs.getString("INTERESSE") );
			}
		}catch(Exception e){
			logger.error("Erro obtendo interessado: " + id, e);
		}finally{
			try{
				if(rs != null) rs.close();
				if(stmt != null) rs.close();
				
				rs = null;
				stmt = null;
						
			}catch(Exception eFinally){
				logger.error("Erro liberando recursors.", eFinally);
			}
		}
		
		return interessado;
	}
	
	public void atualizaInteressado(Interessado interessado){
		PreparedStatement stmt = null;
		
		try{
			String sql = "update interessado set nome=?, telefone=?, email=?, interesse=? where id=?";
			
			stmt = Conexao.getConnection().prepareStatement(sql);
			
			stmt.setString(1, interessado.getNome());
			stmt.setString(2, interessado.getTelefone());
			stmt.setString(3, interessado.getEmail());
			stmt.setString(4, interessado.getInteresse());
			stmt.setInt(5, interessado.getId());
			
			stmt.executeUpdate();
			
			Conexao.getConnection().commit();
		}catch(Exception e){
			try{
				Conexao.getConnection().rollback();
				logger.error("Problemas atualizando interessado.", e);
			}catch(Exception eRollback){
				logger.error("Problemas com rollback", eRollback);
			}
		}finally{
			try{
				if(stmt != null) stmt.close();
			}catch(Exception eSql){
				logger.error("Erro liberando recursos", eSql);
			}
		}
	}
	
	public void excluiInteressado(Integer id){
		PreparedStatement stmt = null;
		
		try{
			String sql = "delete from interessado where id=?";
			
			stmt = Conexao.getConnection().prepareStatement(sql);
			
			stmt.setInt(1, id);
			
			stmt.executeUpdate();
			
			Conexao.getConnection().commit();
		}catch(Exception e){
			try{
				Conexao.getConnection().rollback();
				logger.error("Problemas excluindo interessado.", e);
			}catch(Exception eRollback){
				logger.error("Problemas com rollback", eRollback);
			}
		}finally{
			try{
				if(stmt != null) stmt.close();
			}catch(Exception eSql){
				logger.error("Erro liberando recursos", eSql);
			}
		}
	}
}
