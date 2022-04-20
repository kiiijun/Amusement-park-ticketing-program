package TicketingSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TicketSystem {
	public List<TicketInfo> orderList;
	public TicketInfo ticketOrder;
	public Input inputProcess;
	public Print printProcess;
	public Calculate calculateProcess;

	public void startSystem() {
		resetTicketSystem();
		do {
			resetTicketSystem();
			do {
				ticketOrder = new TicketInfo();
				inputProcess.inputData(ticketOrder);
				calculateProcess.calculateData(ticketOrder);
				printProcess.printPrice(ticketOrder);
				addList();
				inputProcess.inputNextStep(ConstantData.ADD_ORDER);
			} while (inputProcess.nextStep == ConstantData.RESUME);

			printProcess.printTicketInfo(orderList, calculateProcess.CalculateTotalPrice(orderList));
			inputProcess.inputNextStep(ConstantData.NEW_ORDER);
		} while (inputProcess.nextStep == ConstantData.RESUME);
	}

	public void addList() {
		orderList.add(ticketOrder);
	}

	public void resetTicketSystem() {
		orderList = new ArrayList<TicketInfo>();
		ticketOrder = new TicketInfo();
		inputProcess = new Input();
		printProcess = new Print();
		calculateProcess = new Calculate();
	}
}
