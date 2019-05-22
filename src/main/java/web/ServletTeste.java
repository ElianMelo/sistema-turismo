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
import java.util.List;

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
import servico.ClienteServico;
import servico.ContratoServico;
import servico.HotelServico;
import servico.ItemServico;
import servico.PacoteServico;
import servico.PasseioServico;

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
			
			ClienteServico cliente = new ClienteServico();
			HotelServico hotel = new HotelServico();
			PasseioServico passeio = new PasseioServico();
			PacoteServico pacote = new PacoteServico();
			ItemServico item = new ItemServico();
			ContratoServico contrato = new ContratoServico();

			/*cliente.inserirAtualizar(cliente1);
			cliente.inserirAtualizar(cliente2);
			hotel.inserirAtualizar(hotel1);
			hotel.inserirAtualizar(hotel2);
			passeio.inserirAtualizar(passeio1);
			passeio.inserirAtualizar(passeio2);
			pacote.inserirAtualizar(pacote1);
			pacote.inserirAtualizar(pacote2);
			item.inserirAtualizar(item1);
			item.inserirAtualizar(item2);
			contrato.inserirAtualizar(contrato1);
			contrato.inserirAtualizar(contrato2);*/
		
			response.getWriter().append("\nBanco de dados do sucesso");
			
			response.getWriter().append("\nPreço passeios pacote1: " + pacote1.precoPasseios());
			response.getWriter().append("\nPreço total pacote1: " + pacote1.precoTotal());
			response.getWriter().append("\nPreço passeios pacote1: " + pacote2.precoPasseios());
			response.getWriter().append("\nPreço total pacote1: " + pacote2.precoTotal());
			
			Cliente joao = cliente.buscar(1);
			
			response.getWriter().append("\n\nJoão: " + joao);
			response.getWriter().append("\n\nTodos os Clientes: " + cliente.buscarTodos());
			
			List<Hotel> hotelResult = hotel.buscaHoteis("a", new BigDecimal("100"), new BigDecimal("1500"));
			
			response.getWriter().append("\n\nHotel: " + hotelResult);
			
		} catch (ParseException e) {
			response.getWriter().append("\nDeu ruim galera corre");
		}

	}

}
