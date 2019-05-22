/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 14/05/2019
Resumo: Servlet para testes da aplica��o
Refer�ncia ao enunciado/origem do exerc�cio: PDS1 � PROVA SIMULADA QUEST�O 2
*/

package web;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ClienteDao;
import dao.ContratoDao;
import dao.HotelDao;
import dao.ItemDao;
import dao.PacoteDao;
import dao.PasseioDao;
import dao.impl.DaoFactory;
import dao.impl.Transaction;
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
			Cliente cliente1 = new Cliente(null, "Jo�o", "joao@gmail.com", "(34)0000-0000", "000.000.000-00", 
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

			ClienteDao clienteDao = DaoFactory.criarClienteDao();
			HotelDao hotelDao = DaoFactory.criarHotelDao();
			PasseioDao passeioDao = DaoFactory.criarPasseioDao();
			PacoteDao pacoteDao = DaoFactory.criarPacoteDao();
			ItemDao itemDao = DaoFactory.criarItemDao();
			ContratoDao contratoDao = DaoFactory.criarContratoDao();
			
			/*Transaction.begin();
			
			clienteDao.inserirAtualizar(cliente1);
			clienteDao.inserirAtualizar(cliente2);
			hotelDao.inserirAtualizar(hotel1);
			hotelDao.inserirAtualizar(hotel2);
			passeioDao.inserirAtualizar(passeio1);
			passeioDao.inserirAtualizar(passeio2);
			pacoteDao.inserirAtualizar(pacote1);
			pacoteDao.inserirAtualizar(pacote2);
			itemDao.inserirAtualizar(item1);
			itemDao.inserirAtualizar(item2);
			contratoDao.inserirAtualizar(contrato1);
			contratoDao.inserirAtualizar(contrato2);
			
			Transaction.commit();*/
		
			response.getWriter().append("\nBanco de dados do sucesso");
			
			response.getWriter().append("\nPre�o passeios pacote1: " + pacote1.precoPasseios());
			response.getWriter().append("\nPre�o total pacote1: " + pacote1.precoTotal());
			response.getWriter().append("\nPre�o passeios pacote1: " + pacote2.precoPasseios());
			response.getWriter().append("\nPre�o total pacote1: " + pacote2.precoTotal());
			
			Cliente joao = clienteDao.buscar(1);
			
			response.getWriter().append("\n\nJo�o: " + joao);
			response.getWriter().append("\n\nTodos os Clientes: " + clienteDao.buscarTodos());
			
			List<Hotel> hotel = hotelDao.buscaHoteis("a", new BigDecimal("100"), new BigDecimal("1500"));
			
			response.getWriter().append("\n\nHotel: " + hotel);
			
		} catch (ParseException e) {
			response.getWriter().append("\nDeu ruim galera corre");
		}

	}

}
