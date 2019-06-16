import java.io.IOException;
//import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.*;

@SuppressWarnings("unused")
@WebServlet("/tcon")
public class tcon extends HttpServlet {
//private static final long serialVersionUID = 1L;

/*tcon()
{

super(); 
}*/

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String[] Accessories={};
		Accessories=request.getParameterValues("tshirtAccessories");
		String tshirtAccessories="";
		String tshirtTagLine=request.getParameter("tshirtTagLine");
		String tshirtOption=request.getParameter("tshirtOption");
		String tcolor=request.getParameter("tcolor");
		out.println("<html>");
		out.println("<head><title>T-shirt</title></head>");
		out.println("<body>");
		try {
			Statement stmt;
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/s", "root", "root");
			if (conn != null) {
				stmt= conn.createStatement();
				//String qu;                
					String qu="select * from Tshirts;";
				ResultSet rs =stmt.executeQuery(qu);
				if(!rs.isBeforeFirst())
				{
					int ono = 100;
					qu="insert into Tshirts values("+Integer.toString(ono)+",'"+tshirtAccessories+"','"+tshirtTagLine+"','"+tshirtOption+"','"+tcolor+"');";
					stmt.executeUpdate(qu);
				}
				rs.afterLast();
				if(rs.previous())
			    {
			int ono= Integer.parseInt(rs.getString("OrderNo"));
			ono++;
	if(tshirtAccessories!=null && tshirtTagLine!=null && tshirtOption!=null && tcolor!=null){
		for(String option:Accessories)
		{
			tshirtAccessories=tshirtAccessories+option;
		}
qu="insert into Tshirts values("+Integer.toString(ono)+",'"+tshirtAccessories+"','"+tshirtTagLine+"','"+tshirtOption+"','"+tcolor+"');";
	stmt.executeUpdate(qu);
}
}
	qu="select * from Tshirts;";
	rs =stmt.executeQuery(qu);

	out.println("<table border=2>");
	out.println("<tr>");
	out.print("<td>OrderNo</td>");
	out.print("<td>T-shirt Accessories</td>");
	out.print("<td>T-shirt tag-line</td>");
	out.print("<td>T-shirt type</td>");
	out.print("<td>T-shirt color</td>");
	out.println("</tr>");
	while(rs.next()){
	out.println("<tr>");
    out.print("<td>"+(rs.getString("OrderNo"))+"</td>");
	//out.print("<td>"+rs.getString("OrderNo")+"1"+"</td>");
	out.print("<td>"+rs.getString("tshirtAccessories")+"</td>");
	out.print("<td>"+rs.getString("tshirtTagLine")+"</td>");
	out.print("<td>"+rs.getString("tshirtOption")+"</td>");
	out.print("<td>"+rs.getString("tcolor")+"</td>");
	out.println("</tr>");
	}
}
    out.println("</table>");
    out.println("<a href=\"tshirt.jsp\">click here</a>");
			out.println("</body></html>");
	}
catch (Exception e)
	{
	e.printStackTrace();
}
}
}
