package NoiThat.Controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
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

@WebServlet(urlPatterns = {"/cart", "/addtocart", "/updatecartitem", "/deletecartitem",
						   "/checkout", "/recentlyview"})
public class CartController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	ICateParentsService catepase = new CateParentsServiceImpl();
	ICateService cate = new CateServiceImpl();
	IProductService prod = new ProductServiceImpl();
	ICartService cartService = new CartServiceImpl();
	ICartItemsService cartitemsService = new CartItemsServiceImpl();
	IBillService billService = new BillServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		// list category to shop dropdown menu
		findCategoryOfEachCateParents(req, resp);
		findCart(req, resp);
		
		String url = req.getRequestURI().toString();
		HttpSession session = req.getSession(false);
		User u = (User) session.getAttribute("account");
		if (u != null) {
			if (url.contains("/cart")) {
				
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
					if (count_items != 0) {
						req.getRequestDispatcher("/views/cart/cart.jsp").forward(req, resp);
					} else {
						req.getRequestDispatcher("/views/cart/empty-cart.jsp").forward(req, resp);
					}
			} else if (url.contains("/addtocart")) {
				
					int productid = Integer.parseInt(req.getParameter("id"));
					int quantity = 1;
					String quantityParams = req.getParameter("quantity");
					if (quantityParams != null && !quantityParams.isEmpty()) {
						try {
							quantity = Integer.parseInt(quantityParams);
						} catch (NumberFormatException  e) {
							e.printStackTrace();
						}
					}

					Product p = prod.findOne(productid);
					Cart c = cartService.findOne(u.getUserID());
					
					CartItems cartitem = new CartItems();
					cartitem.setCart(c);
					cartitem.setProduct(p);
					cartitem.setQuantity(quantity);
					try {
						cartitemsService.insert(cartitem);
						String successMsg = "Thêm thành công 1 sản phẩm vào giỏ hàng.";
						req.setAttribute("message", successMsg);
					} catch (Exception e) {
						String alertMsg = "Thất bại! Không thể thêm sản phẩm vào giỏ hàng!";
						req.setAttribute("error", alertMsg);
						throw e;
					}
					
					// Lấy params message, error hiện thông báo đã thêm thành công, nhưng lộ url
//					req.getRequestDispatcher("/cart").forward(req, resp);
					
					// Không lộ url nhưng không hiện được thông báo 
					resp.sendRedirect(req.getContextPath() + "/cart");
					
			} else if (url.contains("/updatecartitem")){
				
				int cartitemid = Integer.parseInt(req.getParameter("id"));
				int quantity = Integer.parseInt(req.getParameter("quantity"));
				
				CartItems cartitem = cartitemsService.findOne(cartitemid);
				if (cartitem.getQuantity() != quantity) {
					cartitem.setQuantity(quantity);
					cartitemsService.update(cartitem);
				}
				
				resp.sendRedirect(req.getContextPath() + "/cart");
			} else if (url.contains("/deletecartitem")) {
				
				String idParam = req.getParameter("id");
				if (idParam != null && !idParam.isEmpty()) {
					int cartitemid = Integer.parseInt(idParam);
					CartItems cartitem = cartitemsService.findOne(cartitemid);
					
					try {
						cartitemsService.delete(cartitem);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				resp.sendRedirect(req.getContextPath() + "/cart");
			} else if (url.contains("/checkout")) {
				Cart cart = cartService.findOne(u.getUserID());
				List<CartItems> ci = cartitemsService.findItemsInCart(cart.getCartID());
				
				int count_items = ci.size();
				double total = 0;
				List<String> messages = new ArrayList<String>();
				List<String> errors = new ArrayList<String>();
				for (CartItems i : ci) {
						if (i.getProduct().getStoke() != 0) {
							if (i.getQuantity() > i.getProduct().getStoke()) {
								int sl = i.getProduct().getStoke();
								i.setQuantity(sl);
								cartitemsService.update(i);
								messages.add("Sản phẩm " + i.getProduct().getProductName() + " chỉ còn lại " + sl + " cái.");
							}
						} else {
							errors.add("Sản phẩm " + i.getProduct().getProductName() + " đã hết hàng!");
							try {
								i.setQuantity(0);
								cartitemsService.update(i);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					
						total += i.getProduct().getPrice()*i.getQuantity();
				}
				req.setAttribute("cartitems", ci);
				req.setAttribute("count_items", count_items);
				req.setAttribute("total", total);
				req.setAttribute("messages", messages);
				req.setAttribute("errors", errors);
				
				if (!messages.isEmpty() || !errors.isEmpty()) {
					req.getRequestDispatcher("/views/cart/cart.jsp").forward(req, resp);
				} else {
					if (count_items != 0) {
						req.getRequestDispatcher("/views/cart/checkOut.jsp").forward(req, resp);
					} else {
						req.getRequestDispatcher("/views/cart/empty-cart.jsp").forward(req, resp);
					}
				}
				
			} else if (url.contains("/recentlyview")) {
				Enumeration<String> attributeNames = session.getAttributeNames();
				List<Product> productList = new ArrayList<>();
//				List<Product> recentProducts = new ArrayList<>(); // Danh sách lưu trữ 15 sản phẩm gần đây nhất

				while (attributeNames.hasMoreElements()) {
				    String attributeName = attributeNames.nextElement();
				    Object attributeValue = session.getAttribute(attributeName);

				    // Kiểm tra nếu attribute có kiểu Product thì thêm vào danh sách sản phẩm
				    if (attributeValue instanceof Product) {
				        productList.add((Product) attributeValue);
				    }
				}
				
				req.setAttribute("productList", productList);
				req.getRequestDispatcher("/views/cart/recentlyview.jsp").forward(req, resp);
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/login");
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

	private void findCategoryOfEachCateParents(HttpServletRequest req, HttpServletResponse resp) {
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
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");
		
		findCategoryOfEachCateParents(req, resp);
		findCart(req, resp);
		
		String url = req.getRequestURI().toString();
		HttpSession session = req.getSession(false);
		User u = (User) session.getAttribute("account");
		if (url.contains("/checkout")) {
			String address = req.getParameter("address");
			String phone = req.getParameter("phone");

			Bill bill = new Bill();
			bill.setUser(u);
			bill.setAddress(address);
			bill.setPhone(phone);
			
			try {
				billService.insert(bill);
				
				double total = 0;
				List<CartItems> cartitems = cartitemsService.findItemsInCart(u.getCart().getCartID());
				for (CartItems cartitem : cartitems) {
					cartitem.setBill(bill);
					cartitemsService.update(cartitem);
					total += cartitem.getProduct().getPrice()*cartitem.getQuantity();
				}
				
				total += 1000; // 1000$ shipping fee
				bill.setTotal(total);
				billService.update(bill);
				
				req.setAttribute("bill", bill);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
//			resp.sendRedirect(req.getContextPath() + "/myaccount");
			req.getRequestDispatcher("/views/cart/checkOut-Success.jsp").forward(req, resp);
		}
		
	}
	
}
