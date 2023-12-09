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
import NoiThat.Services.IUserService;
import NoiThat.Services.ProductServiceImpl;
import NoiThat.Services.UserServiceImpl;

@WebServlet( urlPatterns = {"/home", "/myaccount", "/orderdetails", "/changepassword", "/changeaccountdetails", "/contact"})

public class HomeController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	ICateParentsService catepase = new CateParentsServiceImpl();
	ICateService cate = new CateServiceImpl();
	IProductService prod = new ProductServiceImpl();
	ICartService cartService = new CartServiceImpl();
	ICartItemsService cartitemsService = new CartItemsServiceImpl();
	IBillService billService = new BillServiceImpl();
	IUserService userService = new UserServiceImpl();
	
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
			
		} else if (url.contains("/contact")) {
			req.getRequestDispatcher("/views/contact/contact.jsp").forward(req, resp);
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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI().toString();
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		findCategoryOfEachCateParents(req, resp);
		findCart(req, resp);
		
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("account") != null) {
			if (url.contains("/changepassword")) {
					User u = (User) session.getAttribute("account");
					
					List<Bill> bills = billService.findByUser(u.getUserID());
					req.setAttribute("bills", bills);
					
					String oldPass = req.getParameter("old_pass");
					String newPass = req.getParameter("new_pass");
					String confirmNewPass = req.getParameter("confirm_new_pass");
					
					if (!oldPass.equals(u.getPassword().toString())) {
						String error = "Mật khẩu không chính xác!";
						req.setAttribute("error", error);
						req.getRequestDispatcher("/views/home/my-account.jsp").forward(req, resp);
					} else {
						if (newPass.equals(confirmNewPass)) {
							u.setPassword(confirmNewPass);
							userService.update(u);
							String message = "Đổi mật khẩu thành công, vui lòng đăng nhập lại để kiểm tra";
							req.setAttribute("message", message);
							req.getRequestDispatcher("/views/home/my-account.jsp").forward(req, resp);
						} else {
							String error = "Mật khẩu mới không trùng khớp, hãy xác nhận lại!";
							req.setAttribute("error", error);
							req.getRequestDispatcher("/views/home/my-account.jsp").forward(req, resp);
						}
					}
			} else if (url.contains("/changeaccountdetails")) {
				String email = req.getParameter("email");
				String fullname = req.getParameter("fullname");
				String password = req.getParameter("password");
				
				User u = (User) session.getAttribute("account");
				List<Bill> bills = billService.findByUser(u.getUserID());
				req.setAttribute("bills", bills);
				if (password.equals(u.getPassword().toString())) {
					if (!email.equals(u.getEmail())) {
						if (userService.checkExistEmai(email)) {
							String err = "Email "+email+" đã được sử dụng, hãy sử dụng email khác!";
							req.setAttribute("err", err);
							req.getRequestDispatcher("/views/home/my-account.jsp").forward(req, resp);
						} else {
							u.setFullname(fullname);
							u.setEmail(email);
							userService.update(u);
							String msg = "Cập nhật thành công!";
							req.setAttribute("msg", msg);
							req.getRequestDispatcher("/views/home/my-account.jsp").forward(req, resp);
						}
					} else {
						u.setFullname(fullname);
						userService.update(u);
						String msg = "Cập nhật thành công!";
						req.setAttribute("msg", msg);
						req.getRequestDispatcher("/views/home/my-account.jsp").forward(req, resp);
					}
				} else {
					String err = "Xác thực mật khẩu không chính xác!!!!";
					req.setAttribute("err", err);
					req.getRequestDispatcher("/views/home/my-account.jsp").forward(req, resp);
				}
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
	}
}
