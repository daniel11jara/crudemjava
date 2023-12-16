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
		
		//Contato contato = new Contato();
		//contato.setNome("Renan");
		//contato.setIdade(89);
		
		
		//contatoDao.save(contato);
		
		
		//aula 06
		Contato c1 = new Contato();
		
		c1.setNome("Jaime silva");
		c1.setIdade(56);
		c1.setId(1);//substituindo o ID 
		
		contatoDao.update(c1);
		
		
		//aula 05 - visualizacao dos dados
		
		for (Contato c : contatoDao.getContatos()) {
			
			System.out.println("Contatos: " + c.getNome());
			
		}

	}

}
