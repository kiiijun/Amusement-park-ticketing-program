package TicketingSystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

// �ý����� ��ºθ� ����ϴ� class
public class Print {

	// ��� ��Ŀ� ���� ����� ���
	public void printTicketInfo(List<TicketInfo> orderList, int totalPrice) {
		System.out.println("�߱��� �����մϴ�. �����մϴ�.\n");
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
		System.out.println("=*=*=*=*=*=*=*= LOTTE WORLD ADVENTURE =*=*=*=*=*=*=*=*");
		System.out.println("=*=*=*=*=*= PLEASE CHECK YOUR ORDER LIST =*=*=*=*=*=**\n");

		for (int index = 0; index < orderList.size(); index++) {
			printTicketSelect(orderList.get(index).getTicketSelect());
			printTicketOption(orderList.get(index).getTicketOption());
			printTicketAge(orderList.get(index).getTicketAge());
			printQuantity(orderList.get(index).getQuantity());
			printTicketPrice(orderList.get(index).getTicketPrice());
			printPreferential(orderList.get(index).getPreferential());
			System.out.println();
		}
		System.out.println("\n����� �Ѿ��� " + totalPrice + "���Դϴ�. \n");
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*\n");
	}

	// txt ���Ͽ� ArrayList�� ���� ����.
	public void printFile(List<TicketInfo> orderList) {
		File file = new File("C:\\Users\\snrm1\\eclipse-workspace\\TicketingSystem\\src\\TicketingSystem\\Result.txt");
		FileWriter fw = null;
		BufferedWriter bw = null;
		boolean checkFileExistence = false;
		if (file.exists()) {
			checkFileExistence = true;
		}
		try {
			fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);
			if (checkFileExistence == false) {
				bw.write("��¥,����,�̿�ð�,���ɱ���,����,����,������\n");
			}
			for (int index = 0; index < orderList.size(); index++) {
				printFileOrderDate(orderList.get(index).getOrderDate(), bw);
				printFileTicketSelect(orderList.get(index).getTicketSelect(), bw);
				printFileTicketOption(orderList.get(index).getTicketOption(), bw);
				printFileTicketAge(orderList.get(index).getTicketAge(), bw);
				printFileQuantity(orderList.get(index).getQuantity(), bw);
				printFileTicketPrice(orderList.get(index).getTicketPrice(), bw);
				printFilePreferential(orderList.get(index).getPreferential(), bw);
				bw.newLine();
			}
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// ����ڰ� ������ ������ ���
	public void printTicketSelect(int ticketSelect) {
		if (ticketSelect == ConstantData.FULL) {
			System.out.printf(" %5s *", "�����̿��");
		} else {
			System.out.printf(" %5s *", "��ũ�̿��");
		}
	}

	// ����ڰ� ������ ������ ���Ͽ� ����
	public void printFileTicketSelect(int ticketSelect, BufferedWriter bw) {
		try {
			if (ticketSelect == ConstantData.FULL) {
				bw.write("�����̿��,");
			} else {
				bw.write("��ũ�̿��,");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ����ڰ� ������ �̿�ð��� ���
	public void printTicketOption(int ticketOption) {
		if (ticketOption == ConstantData.ONE_DAY) {
			System.out.printf(" %3s *", "�ְ���");
		} else {
			System.out.printf(" %3s *", "�߰���");
		}
	}

	// ����ڰ� ������ �̿�ð��� ���Ͽ� ����
	public void printFileTicketOption(int ticketOption, BufferedWriter bw) {
		try {
			if (ticketOption == ConstantData.ONE_DAY) {
				bw.write("�ְ���,");
			} else {
				bw.write("�߰���,");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ������� �����̿� ���� ����� ���
	public void printTicketAge(int ticketAge) {
		if (ticketAge == ConstantData.AGE_FREE) {
			System.out.printf(" %3s *", "����");
		} else if (ticketAge == ConstantData.AGE_BABY) {
			System.out.printf(" %3s *", "���̺�");
		} else if (ticketAge == ConstantData.AGE_CHILD) {
			System.out.printf(" %3s *", "���");
		} else if (ticketAge == ConstantData.AGE_TEEN) {
			System.out.printf(" %3s *", "û�ҳ�");
		} else {
			System.out.printf(" %3s *", "�");
		}
	}

	// ������� �����̿� ���� ����� ���Ͽ� ����
	public void printFileTicketAge(int ticketAge, BufferedWriter bw) {
		try {
			if (ticketAge == ConstantData.AGE_FREE) {
				bw.write("����,");
			} else if (ticketAge == ConstantData.AGE_BABY) {
				bw.write("���̺�,");
			} else if (ticketAge == ConstantData.AGE_CHILD) {
				bw.write("���,");
			} else if (ticketAge == ConstantData.AGE_TEEN) {
				bw.write("û�ҳ�,");
			} else {
				bw.write("�,");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ����ڰ� ������ ������ ���
	public void printPreferential(int preferential) {
		if (preferential == ConstantData.NONE) {
			System.out.printf(" %10s *", "������� ����");
		} else if (preferential == ConstantData.DISABLED) {
			System.out.printf(" %10s *", "����� �������");
		} else if (preferential == ConstantData.NATION) {
			System.out.printf(" %10s *", "���������� �������");
		} else if (preferential == ConstantData.ARMY) {
			System.out.printf(" %10s *", "�ް��庴 �������");
		} else if (preferential == ConstantData.PREGNANT) {
			System.out.printf(" %10s *", "�ӻ�� �������");
		} else {
			System.out.printf(" %10s *", "�ٵ��� �������");
		}
	}

	// ����ڰ� ������ ������ ���Ͽ� ����
	public void printFilePreferential(int preferential, BufferedWriter bw) {
		try {
			if (preferential == ConstantData.NONE) {
				bw.write("������� ����");
			} else if (preferential == ConstantData.DISABLED) {
				bw.write("����� �������");
			} else if (preferential == ConstantData.NATION) {
				bw.write("���������� �������");
			} else if (preferential == ConstantData.ARMY) {
				bw.write("�ް��庴 �������");
			} else if (preferential == ConstantData.PREGNANT) {
				bw.write("�ӻ�� �������");
			} else {
				bw.write("�ٵ��� �������");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ����ڰ� �Է��� �߱� ������ ���
	public void printQuantity(int quantity) {
		System.out.printf(" %2d�� *", quantity);
	}

	// ����ڰ� �Է��� �߱� ������ ����
	public void printFileQuantity(int quantity, BufferedWriter bw) {
		try {
			bw.write(quantity + ",");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ����ڰ� �Է��� �̿���� ������ ���Ŀ� �°� ���
	public void printPrice(TicketInfo ticketOrder) {
		System.out.println("������ " + ticketOrder.getTicketPrice() + "�� �Դϴ�.");
		System.out.println("�����մϴ�.");
		System.out.println();
	}

	// ����ڰ� �Է��� �̿���� ������ ���
	public void printTicketPrice(int ticketPrice) {
		System.out.printf(" %6d�� *", ticketPrice);
	}

	// ����ڰ� �Է��� �̿���� ������ ���Ͽ� ����
	public void printFileTicketPrice(int ticketPrice, BufferedWriter bw) {
		try {
			bw.write(ticketPrice + ",");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// ����ڰ� �߱��� ���ڸ� ���Ͽ� ����
	public void printFileOrderDate(String orderdate, BufferedWriter bw) {
		try {
			bw.write(orderdate + ",");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
