package NoiThat.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "CartItems")
@NamedQuery(name = "CartItems.findAll", query = "SELECT c FROM CartItems c")
public class CartItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartItemsID;
	
	@ManyToOne
	@JoinColumn(name = "cartID")
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name = "productID")
	private Product product;
	
	@ManyToOne
	@JoinColumn(name = "billID")
	private Bill bill;
	
	private int quantity;

	public CartItems(int cartItemsID, Cart cart, Product product, Bill bill, int quantity) {
		this.cartItemsID = cartItemsID;
		this.cart = cart;
		this.product = product;
		this.bill = bill;
		this.quantity = quantity;
	}

	public CartItems() {

	}

	public int getCartItemsID() {
		return cartItemsID;
	}

	public void setCartItemsID(int cartItemsID) {
		this.cartItemsID = cartItemsID;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
