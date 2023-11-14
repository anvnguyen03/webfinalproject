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

@WebServlet(urlPatterns = { "/shop/allproduct", "/shop/productbycategory", "/shop/productbycateparents" })

public class ShopController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ICateParentsService catepase = new CateParentsServiceImpl();
	ICateService cate = new CateServiceImpl();
	IProductService prod = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		// list category to shop dropdown menu
		findCategoryOfEachCateParents(req, resp);
		// list 6 latest product
		find6LatestProducts(req, resp);

		String url = req.getRequestURI();
		if (url.contains("/allproduct")) {
//			findAndCountAllProduct(req, resp);
			findAndCountProductByPage(req, resp);
			req.getRequestDispatcher("/views/shop/Shop.jsp").forward(req, resp);
		} else if (url.contains("/productbycategory")) {
			findProductByCategory(req, resp);
			req.getRequestDispatcher("/views/shop/Shop.jsp").forward(req, resp);
		} else if (url.contains("/productbycateparents")) {
			findProductByCateParent(req, resp);
			req.getRequestDispatcher("/views/shop/Shop.jsp").forward(req, resp);
		}
	}

	private void find6LatestProducts(HttpServletRequest req, HttpServletResponse resp)
			throws UnsupportedEncodingException {
		try {
			List<Product> listlatestprod = prod.findTop6LatestProduct();
			req.setAttribute("listlatestprod", listlatestprod);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void findProductByCateParent(HttpServletRequest req, HttpServletResponse resp)
			throws UnsupportedEncodingException {

		int cateparentid = Integer.parseInt(req.getParameter("categoryparentsid"));
		try {
			List<Product> listprod = prod.findProductByCateParensID(cateparentid);
			int countProduct = listprod.size();
			req.setAttribute("listprod", listprod);
			req.setAttribute("countproduct", countProduct);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void findProductByCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		int cateid = Integer.parseInt(req.getParameter("categoryid"));
//		String jsScript = "<script>console.log('var: " + cateid + "');</script>";
//        resp.getWriter().write(jsScript);

		try {
			List<Product> listprod = prod.findProductByCateID(cateid);
			int countProduct = listprod.size();
			req.setAttribute("listprod", listprod);
			req.setAttribute("countproduct", countProduct);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void findAndCountAllProduct(HttpServletRequest req, HttpServletResponse resp)
			throws UnsupportedEncodingException {

		try {
			int countProduct = prod.countAll();
			req.setAttribute("countproduct", countProduct);

			List<Product> listprod = prod.findAllProduct();
			req.setAttribute("listprod", listprod);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	//

	private void findAndCountProductByPage(HttpServletRequest req, HttpServletResponse resp)
			throws UnsupportedEncodingException {

		try {
			String indexPage = req.getParameter("index");
			if (indexPage == null) {
				indexPage = "1";
			}
			int pagesize = 12;
			int countProduct = prod.countAll();
			
			int endP = countProduct/pagesize;
			if (countProduct % pagesize != 0) {
				endP++;
			}
			
			List<Product> listprodByPage = prod.findProductByPage(Integer.parseInt(indexPage)-1,pagesize);
			
			int countProd = listprodByPage.size();
			
			req.setAttribute("tag", indexPage);
			req.setAttribute("endP", endP);
			req.setAttribute("countproduct", countProd);
			req.setAttribute("listprodByPage", listprodByPage);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void findCategoryOfEachCateParents(HttpServletRequest req, HttpServletResponse resp)
			throws UnsupportedEncodingException {

		try {
			List<CategoryParents> listcatepa = catepase.findAllCateParents();

			// Duyệt qua danh sách CategoryParents và thêm danh sách Category cho mỗi
			// CategoryParents
			for (CategoryParents cateParent : listcatepa) {
				List<Category> listcate = cate.findByCategoryParentsID(cateParent.getCateParentsID());
				cateParent.setCategories(listcate);
			}

			req.setAttribute("listcatepa", listcatepa);
//	        req.getRequestDispatcher("/views/home/Home.jsp").forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
