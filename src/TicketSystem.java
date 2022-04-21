package TicketingSystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 시스템의 구동 및 제어를 담당하는 class
public class TicketSystem {
	public List<TicketInfo> orderList;
	public TicketInfo ticketOrder;
	public Input inputProcess;
	public Print printProcess;
	public Calculate calculateProcess;

	//시스템의 구동을 담당
	public void startSystem() throws IOException {
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
			printProcess.printFile(orderList);
			inputProcess.inputNextStep(ConstantData.NEW_ORDER);
		} while (inputProcess.nextStep == ConstantData.RESUME);
	}
	
	public void endSystem() {
		System.exit(0);
	}

	//list에 주문내역을 추가함
	public void addList() {
		orderList.add(ticketOrder);
	}

	//시스템의 인자를 리셋함
	public void resetTicketSystem() {
		orderList = new ArrayList<TicketInfo>();
		ticketOrder = new TicketInfo();
		inputProcess = new Input();
		printProcess = new Print();
		calculateProcess = new Calculate();
	}
}
