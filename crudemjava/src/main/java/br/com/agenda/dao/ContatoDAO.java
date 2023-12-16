package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDAO {
	
	
	//CREATE aula 03
	public void save(Contato contato) {
		String sql = "INSERT INTO contatos (nome, idade) values (?, ?)";
		
		Connection conn = null;
		
		PreparedStatement pstm = null;
		//PreparedStatement pstm = null;
		
		try {
			//cria a conexao com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//executando a query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//passando os 3 valores para o objeto contato
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			//pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));;
			
			pstm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm!=null) {
					pstm.close();
				}
				
				if (conn!=null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	//aula 05
	public void update(Contato contatos) {
		String sql = "update contatos set nome = ?, idade = ? " + "where id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			
			//conectando com o banco
			conn = ConnectionFactory.createConnectionToMySQL();
			
			//classe para a execucao da query
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, contatos.getNome());
			pstm.setInt(2, contatos.getIdade());
			pstm.setInt(3, contatos.getId());
			
			pstm.execute();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				
				
				if (pstm!=null) {
					pstm.close();
				}
				
				if (conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
				
	}
	
	
	//aula 04
	public List<Contato> getContatos() throws SQLException {
		String sql = "select * from contatos";
		
		List<Contato> contatos = new ArrayList<Contato>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		//classe que recupera os dados do banco
		ResultSet rset = null;
		
		try {
			
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Contato contato = new Contato();
				
				contato.setId(rset.getInt("id"));
				contato.setNome(rset.getString("nome"));
				contato.setIdade(rset.getInt("idade"));
				
				contatos.add(contato);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rset!=null) {
					rset.close();
				}
				
				if (pstm!=null) {
					pstm.close();
				}
				
				if (conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return contatos;
	}

}
