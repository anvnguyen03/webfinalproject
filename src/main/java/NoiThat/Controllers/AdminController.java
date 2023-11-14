package NoiThat.Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import NoiThat.Entity.User;

@WebServlet(urlPatterns = {"/admin/home"})
public class AdminController extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String url = req.getRequestURI();
		HttpSession session = req.getSession(false);
		User u = (User) session.getAttribute("account");
		
		if (u.getRoleID() == 1) {
			if (url.contains("/home")) {
				req.getRequestDispatcher("/decorators/admin.jsp").forward(req, resp);
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/home");
			System.out.println("Tài khoản của bạn không có quyền truy cập servlet này!");
		}
	}
}
