package TicketingSystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

// �ý����� ��ºθ� ����ϴ� class
public class Print {

	// ��� ��Ŀ� ���� ����� ���
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

	// ����ڰ� ������ ������ ���
	public void printTicketSelect(int ticketSelect) {
		if (ticketSelect == ConstantData.FULL) {
			System.out.print("�����̿��\t");
		} else {
			System.out.print("��ũ�̿��\t");
		}
	}

	public void printFileTicketSelect(int ticketSelect, FileWriter fw) throws IOException {
		if (ticketSelect == ConstantData.FULL) {
			fw.write("�����̿�� ,");
		} else {
			fw.write("��ũ�̿�� ,");
		}
	}

	// ����ڰ� ������ �̿�ð��� ���
	public void printTicketOption(int ticketOption) {
		if (ticketOption == ConstantData.ONE_DAY) {
			System.out.print("1DAY\t");
		} else {
			System.out.print("AFTER4\t");
		}
	}

	public void printFileTicketOption(int ticketOption, FileWriter fw) throws IOException {
		if (ticketOption == ConstantData.ONE_DAY) {
			fw.write("1DAY ,");
		} else {
			fw.write("AFTER4 ,");
		}
	}

	// ������� �����̿� ���� ����� ���
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
	
	public void printFileTicketAge(int ticketAge, FileWriter fw) throws IOException {
		if(ticketAge == ConstantData.AGE_FREE) {
			fw.write("���� ,");
		}else if (ticketAge == ConstantData.AGE_BABY) {
			fw.write("���̺� ,");
		}else if (ticketAge == ConstantData.AGE_CHILD) {
			fw.write("��� ,");
		}else if (ticketAge == ConstantData.AGE_TEEN) {
			fw.write("û�ҳ� ,");
		}else {
			fw.write("� ,");
		}
	}

	// ����ڰ� ������ ������ ���
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
	
	public void printFilePreferential(int preferential, FileWriter fw) throws IOException {
		if (preferential == ConstantData.NONE) {
			fw.write("*������� ���� ");
		} else if (preferential == ConstantData.DISABLED) {
			fw.write("*����� ������� ");
		} else if (preferential == ConstantData.NATION) {
			fw.write("*���������� ������� ");
		} else if (preferential == ConstantData.ARMY) {
			fw.write("*�ް��庴 ������� ");
		} else if (preferential == ConstantData.PREGNANT) {
			fw.write("*�ӻ�� ������� ");
		} else {
			fw.write("*�ٵ��� �ູī�� ������� ");
		}
	}

	// ����ڰ� �Է��� �߱� ������ ���
	public void printQuantity(int quantity) {
		System.out.print("x " + quantity + "\t");
	}
	
	public void printFileQuantity(int quantity, FileWriter fw) throws IOException {
		fw.write(quantity+",");
	}

	// ����ڰ� �Է��� �̿���� ������ ���Ŀ� �°� ���
	public void printPrice(TicketInfo ticketOrder) {
		System.out.println("������ " + ticketOrder.getTicketPrice() + "�� �Դϴ�.");
		System.out.println("�����մϴ�.");
		System.out.println();
	}

	// ����ڰ� �Է��� �̿���� ������ ���
	public void printTicketPrice(int ticketPrice) {
		System.out.print(ticketPrice + "\t");
	}
	
	public void printFileTicketPrice(int ticketPrice, FileWriter fw) throws IOException {
		fw.write(ticketPrice+",");
	}
	
	public void printFileOrderDate(String orderdate, FileWriter fw) throws IOException {
		fw.write(orderdate+",");
	}

	public void printFile(List<TicketInfo> orderList) throws IOException {
		File file = new File("C:\\Users\\user\\eclipse-workspace\\TicketingSystem\\src\\TicketingSystem\\Result.csv");
		FileWriter fw = new FileWriter(file, true);
		fw.write("��¥ ,���� ,�̿�ð�, ���ɱ��� ,���� ,���� ,������ \n");
		for (int index = 0; index < orderList.size(); index++) {
			printFileOrderDate(orderList.get(index).getOrderDate(), fw);
			printFileTicketSelect(orderList.get(index).getTicketSelect(), fw);
			printFileTicketOption(orderList.get(index).getTicketOption(), fw);
			printFileTicketAge(orderList.get(index).getTicketAge(), fw);
			printFileQuantity(orderList.get(index).getQuantity(), fw);
			printFileTicketPrice(orderList.get(index).getTicketPrice(), fw);
			printFilePreferential(orderList.get(index).getPreferential(), fw);
			fw.write("\n");
		}
		fw.close();

	}

}
