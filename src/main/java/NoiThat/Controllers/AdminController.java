package NoiThat.Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import NoiThat.Entity.Category;
import NoiThat.Entity.CategoryParents;
import NoiThat.Entity.Product;
import NoiThat.Entity.User;
import NoiThat.Entity.UserRole;
import NoiThat.Services.CateParentsServiceImpl;
import NoiThat.Services.CateServiceImpl;
import NoiThat.Services.ICateParentsService;
import NoiThat.Services.ICateService;
import NoiThat.Services.IProductService;
import NoiThat.Services.IRoleService;
import NoiThat.Services.IUserService;
import NoiThat.Services.ProductServiceImpl;
import NoiThat.Services.RoleServiceImpl;
import NoiThat.Services.UserServiceImpl;

@WebServlet(urlPatterns = {"/admin/home", "/admin/cateparents", "/admin/category", "/admin/products", "/admin/users", "/admin/orders", 
						   "/admin/addproducts", "/admin/updateproducts", "/admin/productdetails", "/admin/updateusers",
						   "/admin/userDetails"})
public class AdminController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	ICateParentsService cateParents = new CateParentsServiceImpl();
	ICateService cate = new CateServiceImpl();
	IProductService pro = new ProductServiceImpl();
	IUserService user = new UserServiceImpl();
	IRoleService role = new RoleServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		HttpSession session = req.getSession(false);
		User u = (User) session.getAttribute("account");
		if (u != null) {
			if (u.getUserrole().getRoleID() == 1) {
				if (url.contains("/home")) {
					req.getRequestDispatcher("/views/admin/admin-home.jsp").forward(req, resp);
				} else if (url.contains("/cateparents")) {
					
					List<CategoryParents> listcateparents = cateParents.findAllCateParents();
					req.setAttribute("listcateparents", listcateparents);
					req.getRequestDispatcher("/views/admin/admin-dashboards-categoryparents.jsp").forward(req, resp);
					
				} else if (url.contains("/category")) {
					
					List<Category> listcate = cate.findAllCate();
					List<CategoryParents> listcateparents = cateParents.findAllCateParents();
					req.setAttribute("listcateparents", listcateparents);
					req.setAttribute("listcate", listcate);
					req.getRequestDispatcher("/views/admin/admin-dashboards-category.jsp").forward(req, resp);
					
				} else if (url.contains("/products")) {
					
					List<Product> listpro = pro.findAllProduct();
					req.setAttribute("listpro", listpro);
					req.getRequestDispatcher("/views/admin/admin-dashboards-products.jsp").forward(req, resp);
					
				} else if (url.contains("/users")) {
					
					List<User> listuser = user.findAllUser();
					req.setAttribute("listuser", listuser);
					req.getRequestDispatcher("/views/admin/admin-dashboards-users.jsp").forward(req, resp);
					
				} else if (url.contains("/orders")) {
					
					req.getRequestDispatcher("/views/admin/admin-orders.jsp").forward(req, resp);
					
				} else if (url.contains("/addproducts")) {
					List<Category> listcate = cate.findAllCate();
					req.setAttribute("listcate", listcate);
					req.getRequestDispatcher("/views/admin/admin-addProducts.jsp").forward(req, resp);
					
				} else if (url.contains("/updateproducts")) {
					int productid = Integer.parseInt(req.getParameter("productID"));
					Product product = pro.findOne(productid);
					req.setAttribute("product", product);
					
					List<Category> listcate = cate.findAllCate();
					req.setAttribute("listcate", listcate);
					
					req.getRequestDispatcher("/views/admin/admin-updateProducts.jsp").forward(req, resp);
					
				} else if (url.contains("/productdetails")) {
					
					int productid = Integer.parseInt(req.getParameter("productID"));
					Product product = pro.findOne(productid);
					req.setAttribute("product", product);
					
					List<Category> listcate = cate.findAllCate();
					req.setAttribute("listcate", listcate);
					
					req.getRequestDispatcher("/views/admin/admin-productDetails.jsp").forward(req, resp);
					
				} else if (url.contains("/updateusers")) {
					
					int userid = Integer.parseInt(req.getParameter("userID"));
					User userUpdate = user.findOne(userid);
					req.setAttribute("userUpdate", userUpdate);
					
					List<UserRole> listrole = role.findAllRole();
					req.setAttribute("listrole", listrole);
					
					req.getRequestDispatcher("/views/admin/admin-updateUsers.jsp").forward(req, resp);
					
				} else if (url.contains("/userDetails")) {
					
					int userid = Integer.parseInt(req.getParameter("userID"));
					User us = user.findOne(userid);
					req.setAttribute("user", us);
					
					req.getRequestDispatcher("/views/admin/admin-userDetails.jsp").forward(req, resp);
					
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/home");
				System.out.println("Tài khoản của bạn không có quyền truy cập servlet này!");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/home");
		}
		
	}
}
