package br.com.agenda.aplicacao;



import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		ContatoDAO contatoDao = new ContatoDAO();
		
		Contato contato = new Contato();
		contato.setNome("Renan");
		contato.setIdade(89);
		
		
		contatoDao.save(contato);
		
		//aula 05 - visualizacao dos dados
		
		for (Contato c : contatoDao.getContatos()) {
			
			System.out.println("Contatos: " + c.getNome());
			
		}

	}

}
