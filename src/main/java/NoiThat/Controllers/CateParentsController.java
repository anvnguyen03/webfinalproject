package NoiThat.Controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NoiThat.Entity.CategoryParents;
import NoiThat.Services.CateParentsServicePImpl;
import NoiThat.Services.ICateParentsService;



@WebServlet(urlPatterns = { "/home" })

public class CateParentsController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	ICateParentsService catepase = new CateParentsServicePImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String url = req.getRequestURI().toString();
		if (url.contains("/home")) {
			findAllparent(req, resp);
		} 
//		else if (url.contains("add")) {
//			RequestDispatcher rd = req.getRequestDispatcher("/views/category/addcategory.jsp");
//			rd.forward(req, resp);
//		} else if (url.contains("update")) {
//			findOne(req, resp);
//		} else if (url.contains("delete")) {
//			findOne(req, resp);
//		} else if (url.contains("findAll")) {
//			findAll(req, resp);
//		}
	}	
	
	private void findAllparent(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		try {
			List<CategoryParents> listcatepa = catepase.findAllCateParents();
			
			req.setAttribute("listcatepa", listcatepa);
			
			req.getRequestDispatcher("/views/category/listCatePa.jsp").forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
