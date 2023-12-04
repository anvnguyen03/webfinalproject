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
import NoiThat.Entity.Product;
import NoiThat.Services.CateParentsServiceImpl;
import NoiThat.Services.CateServiceImpl;
import NoiThat.Services.ICateParentsService;
import NoiThat.Services.ICateService;
import NoiThat.Services.IProductService;
import NoiThat.Services.ProductServiceImpl;

@WebServlet( urlPatterns = {"/home"} )

public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	ICateParentsService catepase = new CateParentsServiceImpl();
	ICateService cate = new CateServiceImpl();
	IProductService prod = new ProductServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String url = req.getRequestURI().toString();
		
		findCategoryOfEachCateParents(req, resp);
		
		if (url.contains("/home")) {

			find12LatestProducts(req, resp);
			req.getRequestDispatcher("/views/home/Home.jsp").forward(req, resp);
		}

	}	

	private void find12LatestProducts(HttpServletRequest req, HttpServletResponse resp) {
		try {
			List<Product> listlatestprod = prod.findTop12LatestProduct();
			req.setAttribute("listlatestprod", listlatestprod);
		} catch (Exception e) {
			e.printStackTrace();
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
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
}
