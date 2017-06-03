package cn.tarena.film.pojo;

public class Order {

	private String orderId;
	
	
	private User user;
	private Seat seat;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", user=" + user + ", seat=" + seat + "]";
	}
	
	
}
