package NoiThat.Controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;

import NoiThat.Entity.Bill;
import NoiThat.Entity.Category;
import NoiThat.Entity.CategoryParents;
import NoiThat.Entity.Product;
import NoiThat.Entity.User;
import NoiThat.Entity.UserRole;
import NoiThat.Services.BillServiceImpl;
import NoiThat.Services.CateParentsServiceImpl;
import NoiThat.Services.CateServiceImpl;
import NoiThat.Services.IBillService;
import NoiThat.Services.ICateParentsService;
import NoiThat.Services.ICateService;
import NoiThat.Services.IProductService;
import NoiThat.Services.IRoleService;
import NoiThat.Services.IUserService;
import NoiThat.Services.ProductServiceImpl;
import NoiThat.Services.RoleServiceImpl;
import NoiThat.Services.UserServiceImpl;

@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 10, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024
		* 50)

@WebServlet(urlPatterns = { "/admin/home", "/admin/cateparents", "/admin/category", "/admin/products", "/admin/users",
		"/admin/orders", "/admin/orderDetails", "/admin/editorder", 
		"/admin/addproducts", "/admin/updateproducts", "/admin/productdetails", "/admin/updateusers",
		"/admin/userDetails", "/admin/addcategoryparents", "/admin/deletecategoryparents",
		"/admin/updatecategoryparents", "/admin/addcate", "/admin/deletecate", "/admin/updatecate", "/admin/updatepro",
		"/admin/addpro", "/admin/deletepro", "/admin/updateuser", "/admin/deleteuser" })
public class AdminController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ICateParentsService cateParents = new CateParentsServiceImpl();
	ICateService cate = new CateServiceImpl();
	IProductService pro = new ProductServiceImpl();
	IUserService user = new UserServiceImpl();
	IRoleService role = new RoleServiceImpl();
	IBillService bill = new BillServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

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
					List<Bill> listbill = bill.findAll();
					req.setAttribute("listbill", listbill);
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
				} else if (url.contains("/orderDetails")) {
					int billid = Integer.parseInt(req.getParameter("id"));
					Bill b = bill.findByID(billid);
					req.setAttribute("bill", b);
					req.getRequestDispatcher("/views/admin/admin-orderDetails.jsp").forward(req, resp);
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/home");
				System.out.println("Tài khoản của bạn không có quyền truy cập trang này!");
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/home");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		String url = req.getRequestURI();

		// Thêm category parents - sửa dòng 308 ad-dash-caparents, xóa - 261, update-223
		if (url.contains("/admin/addcategoryparents")) {

			String cateParentsName = req.getParameter("cateParentsName");
			String stateStr = req.getParameter("state");
			int state = Integer.parseInt(stateStr);

			try {
				CategoryParents new_caparent = new CategoryParents();
				new_caparent.setCateParentsName(cateParentsName);
				new_caparent.setState(state);
				cateParents.insert(new_caparent);

			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.sendRedirect(req.getContextPath() + "/admin/cateparents");

		} else if (url.contains("/admin/deletecategoryparents")) {

			int cateParentsID = Integer.parseInt(req.getParameter("cateParentsID"));
			String cateParentsName = req.getParameter("cateParentsName");

			try {
				CategoryParents new_caparent = new CategoryParents();
				new_caparent.setCateParentsID(cateParentsID);
				new_caparent.setCateParentsName(cateParentsName);
				new_caparent.setState(2);
				cateParents.delete(new_caparent);

			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.sendRedirect(req.getContextPath() + "/admin/cateparents");

		} else if (url.contains("/admin/updatecategoryparents")) {

			int cateParentsID = Integer.parseInt(req.getParameter("cateParentsID"));
			String cateParentsName = req.getParameter("cateParentsName");
			String stateStr = req.getParameter("state");
			int state = Integer.parseInt(stateStr);

			try {
				CategoryParents new_caparent = new CategoryParents();
				new_caparent.setCateParentsID(cateParentsID);
				new_caparent.setCateParentsName(cateParentsName);
				new_caparent.setState(state);
				cateParents.update(new_caparent);

			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.sendRedirect(req.getContextPath() + "/admin/cateparents");
		}

		// Thêm sửa xóa category - ad-dash-category 218-edit, 271-dele, 324-add
		else if (url.contains("/admin/addcate")) {

			String cateName = req.getParameter("cateName");
			String stateStr = req.getParameter("state");
			int cateParentsID = Integer.parseInt(req.getParameter("cateParentsID"));

			int state = Integer.parseInt(stateStr);
			CategoryParents cateParents = new CategoryParents();
			cateParents.setCateParentsID(cateParentsID);

			try {
				Category new_cate = new Category();

				new_cate.setCateName(cateName);
				new_cate.setState(state);
				new_cate.setCateParent(cateParents);
				cate.insert(new_cate);

			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.sendRedirect(req.getContextPath() + "/admin/category");

		} else if (url.contains("/admin/deletecate")) {

			int cateID = Integer.parseInt(req.getParameter("cateID"));
			String cateName = req.getParameter("cateName");
			int cateParentsID = Integer.parseInt(req.getParameter("cateParentsID"));

			CategoryParents cateParents = new CategoryParents();
			cateParents.setCateParentsID(cateParentsID);

			try {
				Category new_cate = new Category();

				new_cate.setCateID(cateID);
				new_cate.setCateName(cateName);
				new_cate.setState(2);
				new_cate.setCateParent(cateParents);
				cate.update(new_cate);

			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.sendRedirect(req.getContextPath() + "/admin/category");
		} else if (url.contains("/admin/updatecate")) {

			int cateID = Integer.parseInt(req.getParameter("cateID"));
			String cateName = req.getParameter("cateName");
			String stateStr = req.getParameter("state");
			int cateParentsID = Integer.parseInt(req.getParameter("cateParentsID"));

			int state = Integer.parseInt(stateStr);
			CategoryParents cateParents = new CategoryParents();
			cateParents.setCateParentsID(cateParentsID);

			try {
				Category new_cate = new Category();

				new_cate.setCateID(cateID);
				new_cate.setCateName(cateName);
				new_cate.setState(state);
				new_cate.setCateParent(cateParents);
				cate.update(new_cate);

			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.sendRedirect(req.getContextPath() + "/admin/category");
		}

		// Thêm sửa xóa product - ad-dash-pro 256-edit - 271-dele, 324-add
		else if (url.contains("/admin/addpro")) {

			Product prod = new Product();
			int cateID = Integer.parseInt(req.getParameter("cateID"));
			Category cate = new Category();

			try {
				BeanUtils.populate(prod, req.getParameterMap());

//				xử lý image
				if (req.getPart("imgLink1").getSize() != 0) {
					prod.setImgLink1(prod.ProcessImage("imgLink1", req));
				}
				if (req.getPart("imgLink2").getSize() != 0) {
					prod.setImgLink2(prod.ProcessImage("imgLink2", req));
				}
				if (req.getPart("imgLink3").getSize() != 0) {
					prod.setImgLink3(prod.ProcessImage("imgLink3", req));
				}
				if (req.getPart("imgLink4").getSize() != 0) {
					prod.setImgLink4(prod.ProcessImage("imgLink4", req));
				}
				if (req.getPart("imgLink5").getSize() != 0) {
					prod.setImgLink5(prod.ProcessImage("imgLink5", req));
				}

				cate.setCateID(cateID);
				prod.setCategory(cate);
				pro.insert(prod);

			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.sendRedirect(req.getContextPath() + "/admin/products");

		} else if (url.contains("/admin/deletepro")) {

			int proID = Integer.parseInt(req.getParameter("productID"));

			try {
				pro.delete(proID, 0);
			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.sendRedirect(req.getContextPath() + "/admin/products");

		} else if (url.contains("/admin/updatepro")) {

			Product prod = new Product();
			int cateID = Integer.parseInt(req.getParameter("cateID"));
			Category cate = new Category();

			try {
				BeanUtils.populate(prod, req.getParameterMap());

//				xử lý image
				if (req.getPart("imgLink1").getSize() != 0) {
					prod.setImgLink1(prod.ProcessImage("imgLink1", req));
				}
				if (req.getPart("imgLink2").getSize() != 0) {
					prod.setImgLink2(prod.ProcessImage("imgLink2", req));
				}
				if (req.getPart("imgLink3").getSize() != 0) {
					prod.setImgLink3(prod.ProcessImage("imgLink3", req));
				}
				if (req.getPart("imgLink4").getSize() != 0) {
					prod.setImgLink4(prod.ProcessImage("imgLink4", req));
				}
				if (req.getPart("imgLink5").getSize() != 0) {
					prod.setImgLink5(prod.ProcessImage("imgLink5", req));
				}

				cate.setCateID(cateID);
				prod.setCategory(cate);
				pro.update(prod);

			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.sendRedirect(req.getContextPath() + "/admin/products");
		}

		// Sửa xóa user - ad-dash-user 232-dele
		else if (url.contains("/admin/deleteuser")) {

			int userID = Integer.parseInt(req.getParameter("userID"));

			try {
				user.delete(userID, 2);
			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.sendRedirect(req.getContextPath() + "/admin/users");

		} else if (url.contains("/admin/updateuser")) {

			int roleID = Integer.parseInt(req.getParameter("roleID"));
			UserRole urole = new UserRole();
			urole.setRoleID(roleID);
			User userr = new User();

			try {
				BeanUtils.populate(userr, req.getParameterMap());
				userr.setUserrole(urole);

				user.update(userr);

			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.sendRedirect(req.getContextPath() + "/admin/users");
		}
		//Edit bill - ad-order-233
		else if (url.contains("/admin/editorder")) {

			int userID = Integer.parseInt(req.getParameter("userID"));
			User ur = new User();
			ur.setUserID(userID);
			Bill editbill = new Bill(); 

			try {
				BeanUtils.populate(editbill, req.getParameterMap());
				editbill.setUser(ur);				
				bill.update(editbill);

			} catch (Exception e) {
				e.printStackTrace();
			}
			resp.sendRedirect(req.getContextPath() + "/admin/orders");
		}
	}
}
