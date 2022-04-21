package TicketingSystem;

// �ֹ� ���� ������ ����ϴ�  class
public class TicketInfo {

	private int ticketSelect; // ����
	private int ticketOption; // �̿�ð�
	private int ticketAge; // ���̺� �����
	private int quantity; // ����
	private int preferential; // ������
	private int ticketPrice; // �̿�� �ݾ�
	private String rrn; // �ֹε�Ϲ�ȣ
	private int age; // ������
	private String orderDate; // �߱�����

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
