package TicketingSystem;

// 주문 정보 형식을 담당하는  class
public class TicketInfo {

	private int ticketSelect; // 권종
	private int ticketOption; // 이용시간
	private int ticketAge; // 나이별 요금제
	private int quantity; // 수량
	private int preferential; // 우대사항
	private int ticketPrice; // 이용권 금액
	private String rrn; // 주민등록번호
	private int age; // 만나이
	private String orderDate; // 발권일자

	public TicketInfo() {
		ticketSelect = 0;
		ticketOption = 0;
		ticketAge = 0;
		quantity = 0;
		preferential = 0;
		ticketPrice = 0;
		rrn = "";
		age = 0;
		orderDate = "";
	}

	public int getTicketSelect() {
		return ticketSelect;
	}

	public void setTicketSelect(int ticketSelect) {
		this.ticketSelect = ticketSelect;
	}

	public int getTicketOption() {
		return ticketOption;
	}

	public void setTicketOption(int ticketOption) {
		this.ticketOption = ticketOption;
	}

	public int getTicketAge() {
		return ticketAge;
	}

	public void setTicketAge(int ticketAge) {
		this.ticketAge = ticketAge;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPreferential() {
		return preferential;
	}

	public void setPreferential(int preferential) {
		this.preferential = preferential;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public String getRrn() {
		return rrn;
	}

	public void setRrn(String rrn) {
		this.rrn = rrn;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
}
