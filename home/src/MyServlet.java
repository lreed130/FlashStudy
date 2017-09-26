
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MyServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	/*
	 * This method will print off the Header for the HTML code
	 */
	public void printHeader(PrintWriter print, boolean isLoggedIn) {
		print.println(
				"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">");
		print.println("<html>");
		print.println("<head>");
		print.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
		print.println("<title>Flash Study</title>");
		print.println("</head>");
		print.println("<body style = \"background-color: #d3ccb8\">");
		print.println("<table width=\"100%\" border=\"1px\" style=\"background:#442a02\"><tr><td>");
		print.println("<table width=\"100%\" background=\"https://i.imgur.com/p0McYtw.jpg\">");
		//Log in/log out button
		if(isLoggedIn){
			print.print("<tr><td><div align=\"right\"><input name = \"logButton\" type=\"submit\" value=\"Logout\"");
			print.println(" style=\"background-color: #d3ccb8\"><span style=\"display:inline-block; width: 80px;\"></span></div></td></tr>");
		}else{
			print.print("<tr><td><div align=\"right\"><input name = \"logButton\" type=\"submit\" value=\"Login\"");
			print.println(" style=\"background-color: #d3ccb8\"><span style=\"display:inline-block; width: 80px;\"></span></div></td></tr>");
		}
		print.println("<tr><td><span style=\"display:inline-block; height: 250px;\"></span></td></tr>");
		print.println("</table></td></tr></table>");
		print.println("<table width=\"100%\" style=\"background:#d3ccb8;\"><tr>");
		print.print("<td><div align=\"center\" style=\"color:#442a02; background-color:#ba9ac6;\"><a href=");
		//Put the url for Create webpage here!
		print.println(">Create</a></div></td>");
		print.print("<td><div align=\"center\" style=\"color:#442a02; background-color:#ba9ac6;\"><a href=");
		//Put the url for Flashcard Sets webpage here!
		print.println(">Flashcard Sets</a></div></td>");
		print.print("<td><div align=\"center\" style=\"color:#442a02; background-color:#ba9ac6;\"><a href=");
		//Put the url for SearchAll webpage here!
		print.println(">Search All</a></div></td>");
		print.println("</tr></table>");
	}
	public void printEnd(PrintWriter print){
		print.println("</body>");
		print.println("</html>");
	}
}
