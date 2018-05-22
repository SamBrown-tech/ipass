package nl.hu.v1wac.firstapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/CalculatorServlet.do")
public class CalculatorServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int number1 = Integer.parseInt(req.getParameter("number1"));
		int number2 = Integer.parseInt(req.getParameter("number2"));
		String add = req.getParameter("add");
		String substract = req.getParameter("substract");
		String multiply = req.getParameter("multiply");
		String divide = req.getParameter("divide");
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		out.println("<!DOCTYPE html>");
		 out.println("<html>");
		 out.println(" <title>Calculator output</title>");
		 out.println(" <body>");
		 if(add != null) {
			 out.println(number1 + " + " + number2 + " = " + (number1 + number2));
		 } else if(substract != null) {
			 out.println(number1 + " - " + number2 + " = " + (number1 - number2));
		 } else if(multiply != null) {
			 out.println(number1 + " x " + number2 + " = " + (number1 * number2));
		 } else if(divide != null) {
			 out.println(number1 + " / " + number2 + " = " + (number1 / number2));
		 }
		 
		 out.println(" </body>");
		 out.println("</html>");

		
	}
}
