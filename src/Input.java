package TicketingSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// �ý����� �Էºθ� ����ϴ� class
public class Input {
	public Scanner s = new Scanner(System.in);
	public int nextStep;
	public int inputMethod;

	public Input() {
		nextStep = 0;
		inputMethod = 0;
	}

	// ����ڷ� ���� �Է¹޴� ����� ����
	public void inputData(TicketInfo ticketOrder) {
		inputTicketSelect(ticketOrder);
		inputTicketOption(ticketOrder);
		inputRRN(ticketOrder);
		inputQuantity(ticketOrder);
		inputPreferential(ticketOrder);
	}

	// ������ ������ (���� / ��ũ)
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

	// �̿�ð��� ������ (�Ϸ�/ ���� 4�� ����)
	public void inputTicketOption(TicketInfo ticketOrder) {
		do {
			System.out.println("�̿�ð��� �����ϼ���.");
			System.out.println("1. �ְ���(1Day)");
			System.out.println("2. �߰���(After4)");
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

	// �ֹι�ȣ�� �Է��� (13�ڸ�)
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

	// �߱� ������ �Է���
	public void inputQuantity(TicketInfo ticketOrder) {
		System.out.println("�߱� ������ �Է��ϼ���.");
		System.out.print("> ");
		ticketOrder.setQuantity(s.nextInt());
		System.out.println();
	}

	// �������� ������ (����/�����/����������/�ް��庴/�ӻ��/�ٵ���)
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

	// �ý��� ������ �б⺰ ������ ���
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
		if (function == ConstantData.ADD_ORDER) {
			System.out.println("�߰� �߱��� �����մϴ�.\n");
		} else {
			System.out.println("���α׷��� ������ �����մϴ�. �����մϴ�.");
		}
	}
}