package NoiThat.Controllers;

import java.io.IOException;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import NoiThat.Entity.Bill;
import NoiThat.Entity.Cart;
import NoiThat.Entity.CartItems;
import NoiThat.Entity.Category;
import NoiThat.Entity.CategoryParents;
import NoiThat.Entity.Product;
import NoiThat.Entity.User;
import NoiThat.Services.BillServiceImpl;
import NoiThat.Services.CartItemsServiceImpl;
import NoiThat.Services.CartServiceImpl;
import NoiThat.Services.CateParentsServiceImpl;
import NoiThat.Services.CateServiceImpl;
import NoiThat.Services.IBillService;
import NoiThat.Services.ICartItemsService;
import NoiThat.Services.ICartService;
import NoiThat.Services.ICateParentsService;
import NoiThat.Services.ICateService;
import NoiThat.Services.IProductService;
import NoiThat.Services.ProductServiceImpl;

@WebServlet( urlPatterns = {"/home", "/myaccount", "/orderdetails"} )

public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	ICateParentsService catepase = new CateParentsServiceImpl();
	ICateService cate = new CateServiceImpl();
	IProductService prod = new ProductServiceImpl();
	ICartService cartService = new CartServiceImpl();
	ICartItemsService cartitemsService = new CartItemsServiceImpl();
	IBillService billService = new BillServiceImpl();
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String url = req.getRequestURI().toString();
		
		findCategoryOfEachCateParents(req, resp);
		findCart(req, resp);
		
		if (url.contains("/home")) {

			find12LatestProducts(req, resp);
			req.getRequestDispatcher("/views/home/Home.jsp").forward(req, resp);
		} else if (url.contains("/myaccount")) {
			HttpSession session = req.getSession();
			if (session != null && session.getAttribute("account") != null) {
				User u = (User) session.getAttribute("account");
				
				List<Bill> bills = billService.findByUser(u.getUserID());
				
				req.setAttribute("bills", bills);
				req.getRequestDispatcher("/views/home/my-account.jsp").forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + "/login");
			}
		} else if (url.contains("/orderdetails")) {
			HttpSession session = req.getSession();
			if (session != null && session.getAttribute("account") != null) {
				int bilid = Integer.parseInt(req.getParameter("id"));
				Bill bill = billService.findByID(bilid);
				req.setAttribute("bill", bill);
				req.getRequestDispatcher("views/home/order-details.jsp").forward(req, resp);
			} else {
				resp.sendRedirect(req.getContextPath() + "/login");
			}
			
		}

	}	

	private void findCart(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("account") != null) {
			
			User u = (User) session.getAttribute("account");
			Cart cart = cartService.findOne(u.getUserID());
			List<CartItems> ci = cartitemsService.findItemsInCart(cart.getCartID());
			req.setAttribute("cartitems", ci);
			
			int count_items = ci.size();
			double total = 0;
			for (CartItems i : ci) {
					total += i.getProduct().getPrice()*i.getQuantity();
			}
			req.setAttribute("count_items", count_items);
			req.setAttribute("total", total);
			
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
