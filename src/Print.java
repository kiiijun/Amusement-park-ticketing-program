package TicketingSystem;

import java.util.List;

public class Print {

	public void printTicketInfo(List<TicketInfo> orderList, int totalPrice) {
		System.out.println("�߱��� �����մϴ�. �����մϴ�.");
		System.out.println();
		System.out.println("------------ �Ե� ���� ---------------");
		for (int index = 0; index < orderList.size(); index++) {
			printTicketSelect(orderList.get(index).getTicketSelect());
			printTicketOption(orderList.get(index).getTicketOption());
			printTicketAge(orderList.get(index).getTicketAge());
			printQuantity(orderList.get(index).getQuantity());
			printTicketPrice(orderList.get(index).getTicketPrice());
			printPreferential(orderList.get(index).getPreferential());
			System.out.println();
		}
		System.out.println();
		System.out.println("����� �Ѿ��� " + totalPrice + "���Դϴ�. ");
		System.out.println();
		System.out.println("-----------------------------------");
	}

	public void printTicketSelect(int ticketSelect) {
		if (ticketSelect == ConstantData.FULL) {
			System.out.print("�����̿��\t");
		} else {
			System.out.print("��ũ�̿��\t");
		}
	}

	public void printTicketOption(int ticketOption) {
		if (ticketOption == ConstantData.ONE_DAY) {
			System.out.print("1DAY\t");
		} else {
			System.out.print("AFTER4\t");
		}
	}

	public void printTicketAge(int ticketAge) {
		if (ticketAge == ConstantData.AGE_FREE) {
			System.out.print("����\t");
		} else if (ticketAge == ConstantData.AGE_BABY) {
			System.out.print("���̺�\t");
		} else if (ticketAge == ConstantData.AGE_CHILD) {
			System.out.print("���\t");
		} else if (ticketAge == ConstantData.AGE_TEEN) {
			System.out.print("û�ҳ�\t");
		} else {
			System.out.print("�\t");
		}
	}

	public void printPreferential(int preferential) {
		if (preferential == ConstantData.NONE) {
			System.out.print("*������� ����");
		} else if (preferential == ConstantData.DISABLED) {
			System.out.print("*����� �������");
		} else if (preferential == ConstantData.NATION) {
			System.out.print("*���������� �������");
		} else if (preferential == ConstantData.ARMY) {
			System.out.print("*�ް��庴 �������");
		} else if (preferential == ConstantData.PREGNANT) {
			System.out.print("*�ӻ�� �������");
		} else {
			System.out.print("*�ٵ��� �ູī�� �������");
		}
	}

	public void printQuantity(int quantity) {
		System.out.print("x " + quantity + "\t");
	}

	public void printPrice(TicketInfo ticketOrder) {
		System.out.println("������ " + ticketOrder.getTicketPrice() + "�� �Դϴ�.");
		System.out.println("�����մϴ�.");
		System.out.println();
	}

	public void printTicketPrice(int ticketPrice) {
		System.out.print(ticketPrice + "\t");
	}

}
