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
import NoiThat.Entity.User;
import NoiThat.Services.CateParentsServiceImpl;
import NoiThat.Services.CateServiceImpl;
import NoiThat.Services.ICateParentsService;
import NoiThat.Services.ICateService;

@WebServlet(urlPatterns = {"/admin/home", "/admin/cateparents", "/admin/category", "/admin/products", "/admin/users", "/admin/orders"})
public class AdminController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	ICateParentsService cateParents = new CateParentsServiceImpl();
	ICateService cate = new CateServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		HttpSession session = req.getSession(false);
		User u = (User) session.getAttribute("account");
		if (u != null) {
			if (u.getRoleID() == 1) {
				if (url.contains("/home")) {
					req.getRequestDispatcher("/views/admin/admin-home.jsp").forward(req, resp);
				} else if (url.contains("/cateparents")) {
					List<CategoryParents> listcateparents = cateParents.findAllCateParents();
					req.setAttribute("listcateparents", listcateparents);
					req.getRequestDispatcher("/views/admin/admin-dashboards-categoryparents.jsp").forward(req, resp);
				} else if (url.contains("/category")) {
					List<Category> listcate = cate.findAllCate();
					req.setAttribute("listcate", listcate);
					req.getRequestDispatcher("/views/admin/admin-dashboards-category.jsp").forward(req, resp);
				} else if (url.contains("/products")) {
					req.getRequestDispatcher("/views/admin/admin-dashboards-products.jsp").forward(req, resp);
				} else if (url.contains("/users")) {
					req.getRequestDispatcher("/views/admin/admin-dashboards-users.jsp").forward(req, resp);
				} else if (url.contains("/orders")) {
					req.getRequestDispatcher("/views/admin/admin-orders.jsp").forward(req, resp);
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
