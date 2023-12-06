package NoiThat.Controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import NoiThat.Entity.Cart;
import NoiThat.Entity.User;
import NoiThat.Services.CartServiceImpl;
import NoiThat.Services.ICartService;
import NoiThat.Services.IUserService;
import NoiThat.Services.UserServiceImpl;
import utils.Email;

@WebServlet(urlPatterns = { "/register", "/login", "/forgotpass", "/verifycode", "/verify-success", "/waiting", "/logout"})
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	IUserService userService = new UserServiceImpl();
	ICartService cartService = new CartServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String url = req.getRequestURI().toString();

		if (url.contains("/register")) {
			req.getRequestDispatcher("/decorators/register.jsp").forward(req, resp);
		} else if (url.contains("/login")) {
			getLogin(req, resp);
		} else if (url.contains("/forgotpass")) {
//			getForgotPass(req, resp);
		} else if (url.contains("/verifycode")) {
			req.getRequestDispatcher("/decorators/verify.jsp").forward(req, resp);
		} else if (url.contains("/verify-success")) {
			req.getRequestDispatcher("/decorators/verifysuccess.jsp").forward(req, resp);
		} else if (url.contains("/waiting")) {
			getWaiting(req, resp);
		} else if (url.contains("/logout")) {
			getLogout(req, resp);
		}
	}

	private void getLogout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		
		session.removeAttribute("account");
		session.invalidate();
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("username".equals(cookie.getName())) {
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
					break;
				}
			}
		}
		
		resp.sendRedirect(req.getContextPath() + "/home");
	}

	private void getWaiting(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("account") != null) {
			User u = (User) session.getAttribute("account");
			req.setAttribute("username", u.getUsername());
			if (u.getUserrole().getRoleID() == 1) {
				resp.sendRedirect(req.getContextPath() + "/admin/home");
			} else if (u.getUserrole().getRoleID() == 2) {
				resp.sendRedirect(req.getContextPath() + "/home");
			}
			
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
		}
		
	}

	private void getLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		// check session
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			resp.sendRedirect(req.getContextPath() + "/waiting");
			return;
		}
		
		// check cookie
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("username")) {
					session = req.getSession(true);
					session.setAttribute("username", cookie.getValue());
					resp.sendRedirect(req.getContextPath() + "/waiting");
					return;
				}
			}
		}
		
		req.getRequestDispatcher("/decorators/login.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		String url = req.getRequestURI().toString();

		if (url.contains("/register")) {
			postRegister(req, resp);
		} else if (url.contains("/login")) {
			postLogin(req, resp);
		} else if (url.contains("/forgotpass")) {
//			postForgotPass(req, resp);
		} else if (url.contains("/verifycode")) {
			postVerifyCode(req, resp);
		}
	}

	private void postLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		boolean isRememberMe = false;
		String remember = req.getParameter("remember");
		
		if ("on".equals(remember)) {
			isRememberMe = true;
		}
		String alertMsg = "";
		
		if (username.isEmpty() || password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("error", alertMsg);
			req.getRequestDispatcher("/decorators/login.jsp").forward(req, resp);
			return;
		}
		
		User user = userService.login(username, password);
		
		if (user != null) {
			if (user.getState() == 1) {
				// create session
				HttpSession session = req.getSession(true);
				session.setAttribute("account", user);
				
				if (isRememberMe) {
					saveRememberMe(resp, username);
				}
				
				resp.sendRedirect(req.getContextPath() + "/waiting");
			} else {
				alertMsg = "Tài khoản bị khóa, hãy liên hệ admin nhé";
				req.setAttribute("error", alertMsg);
				req.getRequestDispatcher("/decorators/login.jsp").forward(req, resp);
			}
			
		} else {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("error", alertMsg);
			req.getRequestDispatcher("/decorators/login.jsp").forward(req, resp);
		}
		
	}

	private void saveRememberMe(HttpServletResponse resp, String username) {
		Cookie cookie = new Cookie("username", username);
		cookie.setMaxAge(30*60);
		resp.addCookie(cookie);
	}

	private void postVerifyCode(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		try (PrintWriter out = resp.getWriter()){
			
			//truy cập session 
			HttpSession session = req.getSession();
			// user tại đây lấy từ register, chưa có userID
			User user = (User) session.getAttribute("account");
			
			String code = req.getParameter("authcode");
			
			if (code.equals(user.getCode())) {
				user.setEmail(user.getEmail());
				user.setState(1);
				
				userService.updateState(user);
				
				// tạo cart cho user mới đăng kí
				User us = userService.findOne(user.getUsername());
				session.setAttribute("account", us);
				Cart cart = new Cart();
				cart.setUser(us);
				cartService.insert(cart);
				
				resp.sendRedirect(req.getContextPath() + "/verify-success");
			} else {
				req.setAttribute("error_otp", "Lỗi OTP không trùng khớp");
				req.getRequestDispatcher("/decorators/verify.jsp").forward(req, resp);
			}
			
		} 
	}

	private void postRegister(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String email = req.getParameter("email");
		String fullname = req.getParameter("fullname");
		
		String alertMsg = "";
		if (userService.checkExistEmai(email)) {
			alertMsg = "Email đã tồn tại";
			req.setAttribute("error", alertMsg);
			req.getRequestDispatcher("/decorators/register.jsp").forward(req, resp);
		} else if (userService.checkExistUsername(username)) {
			alertMsg = "Username đã tồn tại";
			req.setAttribute("error", alertMsg);
			req.getRequestDispatcher("/decorators/register.jsp").forward(req, resp);
		} else {
			Email sm = new Email();
			
			String code = sm.getRandom();
			
			//create new user using all informations
			User user = new User(username, email, code, fullname);
			
			boolean test = sm.sendEmail(user);
			if (test) {
				HttpSession session = req.getSession();
				session.setAttribute("account", user);
				
				boolean isSuccess = userService.register(email, password, username, fullname, code);
				if (isSuccess) {
					resp.sendRedirect(req.getContextPath() + "/verifycode");
				} else {
					alertMsg = "Lỗi hệ thống!";
					req.setAttribute("error", alertMsg);
					req.getRequestDispatcher("/decorators/register.jsp").forward(req, resp);
				}
			} else {
				PrintWriter out = resp.getWriter();
				out.println("Lỗi khi gửi mail!!");
			}
			
		}
	}
}
