/*
Nome do autor: Elian Melo Morais
Data de cria��o do arquivo: 14/05/2019
Resumo: Servlet para testes da aplica��o
Refer�ncia ao enunciado/origem do exerc�cio: PDS1 � PROVA SIMULADA QUEST�O 2
*/

package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/teste")
public class ServletTeste extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Servlet de teste funcionando");
	}

}
