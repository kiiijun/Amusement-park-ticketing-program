package TicketingSystem;

import java.util.ArrayList;
import java.util.List;

// �ý����� ���� �� ��� ����ϴ� class
public class TicketSystem {
	public List<TicketInfo> orderList;
	public TicketInfo ticketOrder;
	public Input inputProcess;
	public Print printProcess;
	public Calculate calculateProcess;

	// �ý����� ������ ���
	public void startSystem() {
		resetTicketSystem();
		do {
			resetTicketSystem();
			do {
				ticketOrder = new TicketInfo();
				inputProcess.SelectInputMethod();
				if (inputProcess.inputMethod == ConstantData.KEYBOARD) { // Ű���� �Է½�
					inputProcess.inputData(ticketOrder);
					calculateProcess.calculateData(ticketOrder);
					printProcess.printPrice(ticketOrder);
					addList();
				} else if (inputProcess.inputMethod == ConstantData.FILE) { // file �Է½�
					inputProcess.inputByFile();
					for (int index = 0; index < inputProcess.FileInputData.size(); index++) {
						ticketOrder = new TicketInfo();
						ticketOrder = inputProcess.FileInputData.get(index);
						calculateProcess.calculateData(ticketOrder);
						addList();
					}
				}
				inputProcess.inputNextStep(ConstantData.ADD_ORDER);
			} while (inputProcess.nextStep == ConstantData.RESUME);
			printProcess.printTicketInfo(orderList, calculateProcess.CalculateTotalPrice(orderList));
			printProcess.printFile(orderList);
			inputProcess.inputNextStep(ConstantData.NEW_ORDER);
		} while (inputProcess.nextStep == ConstantData.RESUME);
	}

	public void endSystem() {
		System.exit(0);
	}

	// list�� �ֹ������� �߰���
	public void addList() {
		orderList.add(ticketOrder);
	}

	// �ý����� ���ڸ� ������
	public void resetTicketSystem() {
		orderList = new ArrayList<TicketInfo>();
		ticketOrder = new TicketInfo();
		inputProcess = new Input();
		printProcess = new Print();
		calculateProcess = new Calculate();
	}
}
