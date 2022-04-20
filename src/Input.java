package TicketingSystem;

import java.util.Scanner;

public class Input {
	public Scanner s = new Scanner(System.in);
	public int nextStep;

	public void inputData(TicketInfo ticketOrder) {
		inputTicketSelect(ticketOrder);
		inputTicketOption(ticketOrder);
		inputRRN(ticketOrder);
		inputQuantity(ticketOrder);
		inputPreferential(ticketOrder);
	}

	public void inputTicketSelect(TicketInfo ticketOrder) {
		do {
			System.out.println("������ �����ϼ���.");
			System.out.println("1. �����̿��");
			System.out.println("2. ��ũ�̿��");
			System.out.print("> ");
			ticketOrder.setTicketSelect(s.nextInt());
			System.out.println();
			if (ticketOrder.getTicketSelect() != ConstantData.FULL
					&& ticketOrder.getTicketSelect() != ConstantData.PARK) {
				System.out.println("\n�߸� �Է��ϼ̽��ϴ�. \n");
			}
		} while (ticketOrder.getTicketSelect() != ConstantData.FULL
				&& ticketOrder.getTicketSelect() != ConstantData.PARK);
	}

	public void inputTicketOption(TicketInfo ticketOrder) {
		do {
			System.out.println("������ �����ϼ���.");
			System.out.println("1. 1DAY");
			System.out.println("2. AFTER4");
			System.out.print("> ");
			ticketOrder.setTicketOption(s.nextInt());
			System.out.println();
			if (ticketOrder.getTicketOption() != ConstantData.ONE_DAY
					&& ticketOrder.getTicketOption() != ConstantData.AFTER_FOUR) {
				System.out.println("\n�߸� �Է��ϼ̽��ϴ�. \n");
			}
		} while (ticketOrder.getTicketOption() != ConstantData.ONE_DAY
				&& ticketOrder.getTicketOption() != ConstantData.AFTER_FOUR);
	}

	public void inputRRN(TicketInfo ticketOrder) {
		do {
			System.out.println("�ֹε�Ϲ�ȣ�� �Է��ϼ���.");
			System.out.print("> ");
			ticketOrder.setRrn(s.next());
			System.out.println();
			if (ticketOrder.getRrn().length() != 13) {
				System.out.println("\n�߸� �Է��ϼ̽��ϴ�. \n");
			}
		} while (ticketOrder.getRrn().length() != 13);
	}

	public void inputQuantity(TicketInfo ticketOrder) {
		System.out.println("�߱� ������ �Է��ϼ���.");
		System.out.print("> ");
		ticketOrder.setQuantity(s.nextInt());
		System.out.println();
	}

	public void inputPreferential(TicketInfo ticketOrder) {
		do {
			if (ticketOrder.getAge() < 65) {
				System.out.println("�������� �Է��ϼ���.");
				System.out.println("1. ���� (���� ���� �ڵ�ó��)");
				System.out.println("2. �����");
				System.out.println("3. ����������");
				System.out.println("4. �ް��庴");
				System.out.println("5. �ӻ��");
				System.out.println("6. �ٵ��� �ູī��");
				System.out.print("> ");
				ticketOrder.setPreferential(s.nextInt());
				System.out.println();
			} else {
				System.out.println("���ϲ����� �������� ������ �� �����ϴ�. (�� 65�� �̻�)");
				System.out.println();
				ticketOrder.setPreferential(ConstantData.NONE);
			}

			if (ticketOrder.getPreferential() < ConstantData.NONE
					&& ticketOrder.getPreferential() > ConstantData.MULTI) {
				System.out.println("\n�߸� �Է��ϼ̽��ϴ�. \n");
			}
		} while (ticketOrder.getPreferential() < ConstantData.NONE
				&& ticketOrder.getPreferential() > ConstantData.MULTI);
	}

	public void inputNextStep(int function) {
		do {
			if (function == ConstantData.ADD_ORDER) {
				System.out.println("��� �߱� �Ͻðڽ��ϱ�?");
				System.out.println("1. ���� �߱�");
				System.out.println("2. ����");
				System.out.print("> ");
			} else {
				System.out.println("���ο� �ֹ�����Ʈ�� �ۼ��Ͻðڽ��ϱ�?");
				System.out.println("1. ���ο� �ֹ�����Ʈ �ۼ�");
				System.out.println("2. ���α׷� ������ ����");
				System.out.print("> ");
			}
			nextStep = s.nextInt();
			System.out.println();
			if (nextStep != ConstantData.RESUME && nextStep != ConstantData.EXIT) {
				System.out.println("\n�߸� �Է��ϼ̽��ϴ�. \n");
			}
		} while (nextStep != ConstantData.RESUME && nextStep != ConstantData.EXIT);
	}
}
