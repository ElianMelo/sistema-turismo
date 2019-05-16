/*
Nome do autor: Elian Melo Morais
Data de criação do arquivo: 14/05/2019
Resumo: Servlet para testes da aplicação
Referência ao enunciado/origem do exercício: PDS1 – PROVA SIMULADA QUESTÃO 2
*/

package web;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dominio.Cliente;
import dominio.Contrato;
import dominio.Hotel;
import dominio.Item;
import dominio.Pacote;
import dominio.Passeio;

@WebServlet("/teste")
public class ServletTeste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Servlet de teste funcionando");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Cliente cliente1 = new Cliente(null, "João", "joao@gmail.com", "(34)0000-0000", "000.000.000-00", 
					sdf.parse("01/01/1990"), new BigDecimal("1500.00"));
			Cliente cliente2 = new Cliente(null, "Maria", "maria@gmail.com", "(34)1111-1111", "111.111.111-11", 
					sdf.parse("02/02/1970"), new BigDecimal("2500.00"));
			
			Hotel hotel1 = new Hotel(null, "Hotel dias tao contados", "Paraiba", new BigDecimal("1000.00"));
			Hotel hotel2 = new Hotel(null, "Caribe Hotel", "Canada", new BigDecimal("2000.00"));
			
			Passeio passeio1 = new Passeio(null, "Rio Alegre", new BigDecimal("250.00"), "Paraiba");
			Passeio passeio2 = new Passeio(null, "Caribe", new BigDecimal("550.00"), "Caribe");
			
			Pacote pacote1 = new Pacote(null, "Pacote Brasil", 5, hotel1);
			Pacote pacote2 = new Pacote(null, "Pacote Canada", 10, hotel2);
			
			Item item1 = new Item(null, 1, pacote1, passeio1);
			Item item2 = new Item(null, 2, pacote2, passeio2);
			
			Contrato contrato1 = new Contrato(null, sdf.parse("01/01/2010"), cliente1, pacote1);
			Contrato contrato2 = new Contrato(null, sdf.parse("02/02/2020"), cliente2, pacote2);
			
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistema.turismo");
			EntityManager em = emf.createEntityManager();
			
			em.getTransaction().begin();
			
			em.persist(cliente1);
			em.persist(cliente2);
			em.persist(hotel1);
			em.persist(hotel2);
			em.persist(passeio1);
			em.persist(passeio2);
			em.persist(pacote1);
			em.persist(pacote2);
			em.persist(item1);
			em.persist(item2);
			em.persist(contrato1);
			em.persist(contrato2);
			
			em.getTransaction().commit();
			
			em.close();
			emf.close();
			
			response.getWriter().append("\nBanco de dados do sucesso");
			
			response.getWriter().append("\nPreço passeios pacote1: " + pacote1.precoPasseios());
			response.getWriter().append("\nPreço total pacote1: " + pacote1.precoTotal());
			response.getWriter().append("\nPreço passeios pacote1: " + pacote2.precoPasseios());
			response.getWriter().append("\nPreço total pacote1: " + pacote2.precoTotal());
			
		} catch (ParseException e) {
			response.getWriter().append("\nDeu ruim galera corre");
		}

		

	}

}
