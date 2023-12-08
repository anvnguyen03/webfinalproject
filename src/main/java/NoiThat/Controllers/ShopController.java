package NoiThat.Controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import NoiThat.Entity.Cart;
import NoiThat.Entity.CartItems;
import NoiThat.Entity.Category;
import NoiThat.Entity.CategoryParents;
import NoiThat.Entity.Product;
import NoiThat.Entity.User;
import NoiThat.Services.CartItemsServiceImpl;
import NoiThat.Services.CartServiceImpl;
import NoiThat.Services.CateParentsServiceImpl;
import NoiThat.Services.CateServiceImpl;
import NoiThat.Services.ICartItemsService;
import NoiThat.Services.ICartService;
import NoiThat.Services.ICateParentsService;
import NoiThat.Services.ICateService;
import NoiThat.Services.IProductService;
import NoiThat.Services.ProductServiceImpl;

@WebServlet(urlPatterns = { "/shop/allproduct", "/shop/findByCategory", "/shop/findByCateParents", "/shop/search",
		"/shop/productdetails", "/shop/filterprice", "/shop/sortby" })

public class ShopController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	ICateParentsService catepase = new CateParentsServiceImpl();
	ICateService cate = new CateServiceImpl();
	IProductService prod = new ProductServiceImpl();
	ICartService cartService = new CartServiceImpl();
	ICartItemsService cartitemsService = new CartItemsServiceImpl();

	List<Product> listproprice = new ArrayList<Product>();
	List<Product> proprice = new ArrayList<Product>();
	List<Product> sortby = new ArrayList<Product>();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		req.setCharacterEncoding("UTF-8");

		// list category to shop dropdown menu
		findCategoryOfEachCateParents(req, resp);
		find12LatestProducts(req, resp);
		findCart(req, resp);

		String url = req.getRequestURI();
		if (url.contains("/allproduct")) {
//			findAndCountAllProduct(req, resp);
			findAndCountProductByPage(req, resp);
			req.getRequestDispatcher("/views/shop/Shop.jsp").forward(req, resp);
		} else if (url.contains("/findByCategory")) {
			findProductByCategory(req, resp);
			req.getRequestDispatcher("/views/shop/Shop.jsp").forward(req, resp);
		} else if (url.contains("/findByCateParents")) {
			findProductByCateParent(req, resp);
			req.getRequestDispatcher("/views/shop/Shop.jsp").forward(req, resp);
		} else if (url.contains("/shop/search")) {
			searchProduct(req, resp);
		} else if (url.contains("/productdetails")) {

			int productid = Integer.parseInt(req.getParameter("id"));
			Product product_detailed = prod.findOne(productid);

			Category category = product_detailed.getCategory();
			List<Product> relatedProducts = category.getProduct();

			req.setAttribute("product_detailed", product_detailed);
			req.setAttribute("relatedProducts", relatedProducts);
			req.getRequestDispatcher("/views/shop/Shop-ProductDetails.jsp").forward(req, resp);

		} else if (url.contains("/shop/filterprice")) {
			System.out.println(listproprice.size() + "fil");
			filterPriceProduct(req, resp);
		} else if (url.contains("/shop/sortby")) {
			System.out.println(listproprice.size() + "sort2");
			sortbyProduct(req, resp);
		}
	}

	private void sortbyProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//		String sort = req.getParameter("sort");
//		List<Product> listsort = new ArrayList<Product>(listproprice);
//		List<Product> sortby = new ArrayList<Product>(sortbypro); 
//		System.out.println(listproprice.size() + "sort");
//		System.out.println(listsort.size() + "sort1");
	    System.out.println("Before sorting: listproprice size = " + listproprice.size());

		if (req.getParameter("sort") != null) {
			if ("1".equals(req.getParameter("sort"))) {
				List<Product> listsort = new ArrayList<Product>(listproprice);
				sortby.clear();
				// Sắp xếp danh sách theo giá tăng dần
				Collections.sort(listsort, Comparator.comparingDouble(Product::getPrice));
				// Sao chép danh sách đã sắp xếp vào danh sách mới (nếu cần)
				sortby = listsort;
			}
			if ("2".equals(req.getParameter("sort"))) {
				List<Product> listsort = new ArrayList<Product>(listproprice);
				sortby.clear();
				// Sắp xếp danh sách theo giá giảm dần
				Collections.sort(listsort, Comparator.comparingDouble(Product::getPrice).reversed());
				sortby = listsort;
			}
			if ("0".equals(req.getParameter("sort"))) {
				sortby.clear();
				sortby = listproprice;
			}
		}
	    System.out.println("After sorting: sortby size = " + sortby.size());

		try {

			int countProduct = sortby.size();
			String indexPage = req.getParameter("index");

			if (indexPage == null) {
				indexPage = "1";
			}
			int pagesize = 12;

			int endP = countProduct / pagesize;
			if (countProduct % pagesize != 0) {
				endP++;
			}
			int i = 0;
			int spro = (Integer.parseInt(indexPage) - 1) * pagesize;
			int epro = (Integer.parseInt(indexPage)) * pagesize;
			List<Product> listprodByPage = new ArrayList<Product>();
			for (Product prod_current : sortby) {
				if (i >= spro && i < epro) {
					listprodByPage.add(prod_current);
				}
				i++;
			}

			req.setAttribute("startProduct", (listprodByPage).size());
			req.setAttribute("tag", indexPage);
			req.setAttribute("endP", endP);
			req.setAttribute("countproduct", countProduct);
			req.setAttribute("listprodByPage", listprodByPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("/views/shop/Shop.jsp").forward(req, resp);

	}

	private void filterPriceProduct(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		if (req.getParameter("filterprice") != null) {
			proprice.clear();
			String filterprice = req.getParameter("filterprice");

			// Chuyển đổi giá trị thành int
			String cleanPrice = filterprice.replaceAll("[^0-9-]", "");
			String[] priceRange = cleanPrice.split("-");
			int minPrice = Integer.parseInt(priceRange[0]);
			int maxPrice = Integer.parseInt(priceRange[1]);
			for (Product prod_current : listproprice) {
				if ((int) prod_current.getPrice() >= minPrice && (int) prod_current.getPrice() <= maxPrice) {
					proprice.add(prod_current);
				}
			}
		}

		try {

			int countProduct = proprice.size();
			String indexPage = req.getParameter("index");

			if (indexPage == null) {
				indexPage = "1";
			}
			int pagesize = 12;

			int endP = countProduct / pagesize;
			if (countProduct % pagesize != 0) {
				endP++;
			}
			int i = 0;
			int spro = (Integer.parseInt(indexPage) - 1) * pagesize;
			int epro = (Integer.parseInt(indexPage)) * pagesize;
			List<Product> listprodByPage = new ArrayList<Product>();
			for (Product prod_current : proprice) {
				if (i >= spro && i < epro) {
					listprodByPage.add(prod_current);
				}
				i++;
			}

			req.setAttribute("startProduct", (listprodByPage).size());
			req.setAttribute("tag", indexPage);
			req.setAttribute("endP", endP);
			req.setAttribute("countproduct", countProduct);
			req.setAttribute("listprodByPage", listprodByPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("/views/shop/Shop.jsp").forward(req, resp);

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
				total += i.getProduct().getPrice() * i.getQuantity();
			}
			req.setAttribute("count_items", count_items);
			req.setAttribute("total", total);

		}
	}

	private void searchProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String namepro = req.getParameter("nameprod");

		List<Product> prodname = prod.findProductsByName(namepro);

		int startProduct = prodname.size();
		int endProduct = startProduct;
		int countProduct = startProduct;
		String indexPage = "1";
		int endP = (startProduct / 12) + 1;

		req.setAttribute("tag", indexPage);
		req.setAttribute("endP", endP);
		req.setAttribute("countproduct", countProduct);
		req.setAttribute("startProduct", startProduct);
		req.setAttribute("endProduct", endProduct);
		req.setAttribute("listprodByPage", prodname);
		req.getRequestDispatcher("/views/shop/Shop.jsp").forward(req, resp);
	}

	private void find12LatestProducts(HttpServletRequest req, HttpServletResponse resp)
			throws UnsupportedEncodingException {
		try {
			List<Product> listlatestprod = prod.findTop12LatestProduct();
			req.setAttribute("listlatestprod", listlatestprod);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void findProductByCateParent(HttpServletRequest req, HttpServletResponse resp)
			throws UnsupportedEncodingException {

		int cateparentid = Integer.parseInt(req.getParameter("categoryparentsid"));
		try {
			List<Product> listprodByCateParents = prod.findProductByCateParensID(cateparentid);
			listproprice.clear();
			listproprice = listprodByCateParents;
			int countProduct = listprodByCateParents.size();

			String indexPage = req.getParameter("index");
			if (indexPage == null) {
				indexPage = "1";
			}
			int pagesize = 12;

			int endP = countProduct / pagesize;
			if (countProduct % pagesize != 0) {
				endP++;
			}

			List<Product> listprodByPage = prod.findProductByCateParensIDPaging(cateparentid,
					Integer.parseInt(indexPage) - 1, pagesize);
			int startProduct;
			if (Integer.parseInt(indexPage) == 1) {
				startProduct = 1;
			} else {
				startProduct = (Integer.parseInt(indexPage) - 1) * pagesize;
			}
			int endProduct = (Integer.parseInt(indexPage) - 1) * pagesize + listprodByPage.size();

			req.setAttribute("startProduct", startProduct);
			req.setAttribute("endProduct", endProduct);
			req.setAttribute("tag", indexPage);
			req.setAttribute("endP", endP);
			req.setAttribute("countproduct", countProduct);
			req.setAttribute("listprodByPage", listprodByPage);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void findProductByCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		int cateid = Integer.parseInt(req.getParameter("categoryid"));
//		String jsScript = "<script>console.log('var: " + cateid + "');</script>";
//        resp.getWriter().write(jsScript);

		try {
			List<Product> listprodByCate = prod.findProductByCateID(cateid);
			listproprice.clear();
			listproprice = listprodByCate;
			int countProduct = listprodByCate.size();

			String indexPage = req.getParameter("index");
			if (indexPage == null) {
				indexPage = "1";
			}
			int pagesize = 12;

			int endP = countProduct / pagesize;
			if (countProduct % pagesize != 0) {
				endP++;
			}

			List<Product> listprodByPage = prod.findProductByCateIDPaging(cateid, Integer.parseInt(indexPage) - 1,
					pagesize);
			int startProduct;
			if (Integer.parseInt(indexPage) == 1) {
				startProduct = 1;
			} else {
				startProduct = (Integer.parseInt(indexPage) - 1) * pagesize;
			}
			int endProduct = (Integer.parseInt(indexPage) - 1) * pagesize + listprodByPage.size();

			req.setAttribute("startProduct", startProduct);
			req.setAttribute("endProduct", endProduct);
			req.setAttribute("tag", indexPage);
			req.setAttribute("endP", endP);
			req.setAttribute("countproduct", countProduct);
			req.setAttribute("listprodByPage", listprodByPage);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void findAndCountProductByPage(HttpServletRequest req, HttpServletResponse resp)
			throws UnsupportedEncodingException {
		listproprice.clear();
		listproprice = prod.findAllProduct();
		
		try {
			String indexPage = req.getParameter("index");
			if (indexPage == null) {
				indexPage = "1";
			}
			int pagesize = 12;
			int countProduct = prod.countAll();

			int endP = countProduct / pagesize;
			if (countProduct % pagesize != 0) {
				endP++;
			}

			List<Product> listprodByPage = prod.findProductByPage(Integer.parseInt(indexPage) - 1, pagesize);

			int startProduct;
			if (Integer.parseInt(indexPage) == 1) {
				startProduct = 1;
			} else {
				startProduct = (Integer.parseInt(indexPage) - 1) * pagesize;
			}
			int endProduct = (Integer.parseInt(indexPage) - 1) * pagesize + listprodByPage.size();

			req.setAttribute("startProduct", startProduct);
			req.setAttribute("endProduct", endProduct);
			req.setAttribute("tag", indexPage);
			req.setAttribute("endP", endP);
			req.setAttribute("countproduct", countProduct);
			req.setAttribute("listprodByPage", listprodByPage);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// drop-down menu
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
