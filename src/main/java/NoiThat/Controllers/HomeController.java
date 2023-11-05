package NoiThat.Controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import NoiThat.Entity.Category;
import NoiThat.Entity.CategoryParents;
import NoiThat.Services.CateParentsServiceImpl;
import NoiThat.Services.CateServiceImpl;
import NoiThat.Services.ICateParentsService;
import NoiThat.Services.ICateService;

@WebServlet( urlPatterns = {"/home"} )

public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	ICateParentsService catepase = new CateParentsServiceImpl();
	ICateService cate = new CateServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String url = req.getRequestURI().toString();
		
		if (url.contains("/home")) {
			findCategoryOfEachCateParents(req, resp);
			req.getRequestDispatcher("/views/home/Home.jsp").forward(req, resp);
		}

	}	

	private void findCategoryOfEachCateParents(HttpServletRequest req, HttpServletResponse resp) throws UnsupportedEncodingException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		try {
			List<CategoryParents> listcatepa = catepase.findAllCateParents();
			
			// Duyệt qua danh sách CategoryParents và thêm danh sách Category cho mỗi CategoryParents
	        for (CategoryParents cateParent : listcatepa) {
	            List<Category> listcate = cate.findByCategoryParentsID(cateParent.getCateParentsID());
	            cateParent.setCategories(listcate);
	        }
	        
	        req.setAttribute("listcatepa", listcatepa);
//	        req.getRequestDispatcher("/views/home/Home.jsp").forward(req, resp);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
}
