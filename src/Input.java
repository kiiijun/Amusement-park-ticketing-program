package TicketingSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// 시스템의 입력부를 담당하는 class
public class Input {
	public Scanner s = new Scanner(System.in);
	public int nextStep; 
	public int inputMethod;
//	public int fileIndex;
	
	public Input() {
		nextStep = 0;
		inputMethod = 0;
//		fileIndex = 0;
	}

	
	public void inputData(TicketInfo ticketOrder) throws IOException {
	//	checkInputMethod();
	//	if (inputMethod == ConstantData.KEYBOARD) {
			inputTicketSelect(ticketOrder);
			inputTicketOption(ticketOrder);
			inputRRN(ticketOrder);
			inputQuantity(ticketOrder);
			inputPreferential(ticketOrder);
	//	} else if (inputMethod == ConstantData.FILE) {
	//		InputByFile(ticketOrder);
	//	}
	}
	
	//입력 방식을 선택함 (키보드 / 파일)
//	public void checkInputMethod() {
//		do {
//			System.out.println("입력방식을 선택하세요.");
//			System.out.println("1. 키보드");
//			System.out.println("2. 파일");
//			System.out.print("> ");
//			inputMethod = s.nextInt();
//			if (inputMethod != ConstantData.KEYBOARD && inputMethod != ConstantData.FILE) {
//				System.out.println("\n잘못 입력하셨습니다. \n");
//			}
//		} while (inputMethod != ConstantData.KEYBOARD && inputMethod != ConstantData.FILE);
//
//	}
	
	// 권종을 선택함 (종합 / 파크)
	public void inputTicketSelect(TicketInfo ticketOrder) {
		do {
			System.out.println("권종을 선택하세요.");
			System.out.println("1. 종합이용권");
			System.out.println("2. 파크이용권");
			System.out.print("> ");
			ticketOrder.setTicketSelect(s.nextInt());
			System.out.println();
			if (ticketOrder.getTicketSelect() != ConstantData.FULL
					&& ticketOrder.getTicketSelect() != ConstantData.PARK) {
				System.out.println("\n잘못 입력하셨습니다. \n");
			}
		} while (ticketOrder.getTicketSelect() != ConstantData.FULL
				&& ticketOrder.getTicketSelect() != ConstantData.PARK);
	}
	
	// 이용시간을 선택함 (하루/ 오후 4시 이후)
	public void inputTicketOption(TicketInfo ticketOrder) {
		do {
			System.out.println("이용시간을 선택하세요.");
			System.out.println("1. 1DAY");
			System.out.println("2. AFTER4");
			System.out.print("> ");
			ticketOrder.setTicketOption(s.nextInt());
			System.out.println();
			if (ticketOrder.getTicketOption() != ConstantData.ONE_DAY
					&& ticketOrder.getTicketOption() != ConstantData.AFTER_FOUR) {
				System.out.println("\n잘못 입력하셨습니다. \n");
			}
		} while (ticketOrder.getTicketOption() != ConstantData.ONE_DAY
				&& ticketOrder.getTicketOption() != ConstantData.AFTER_FOUR);
	}
	
	// 주민번호를 입력함 (13자리)
	public void inputRRN(TicketInfo ticketOrder) {
		do {
			System.out.println("주민등록번호를 입력하세요.");
			System.out.print("> ");
			ticketOrder.setRrn(s.next());
			System.out.println();
			if (ticketOrder.getRrn().length() != 13) {
				System.out.println("\n잘못 입력하셨습니다. \n");
			}
		} while (ticketOrder.getRrn().length() != 13);
	}
	
	//발권 개수를 입력함 
	public void inputQuantity(TicketInfo ticketOrder) {
		System.out.println("발권 개수를 입력하세요.");
		System.out.print("> ");
		ticketOrder.setQuantity(s.nextInt());
		System.out.println();
	}

	//우대사항을 선택함 (없음/장애인/국가유공자/휴가장병/임산부/다둥이)
	public void inputPreferential(TicketInfo ticketOrder) {
		do {
			if (ticketOrder.getAge() < 65) {
				System.out.println("우대사항을 입력하세요.");
				System.out.println("1. 없음 (나이 우대는 자동처리)");
				System.out.println("2. 장애인");
				System.out.println("3. 국가유공자");
				System.out.println("4. 휴가장병");
				System.out.println("5. 임산부");
				System.out.println("6. 다둥이 행복카드");
				System.out.print("> ");
				ticketOrder.setPreferential(s.nextInt());
				System.out.println();
			} else {
				System.out.println("귀하께서는 우대사항을 선택할 수 없습니다. (만 65세 이상)");
				System.out.println();
				ticketOrder.setPreferential(ConstantData.NONE);
			}

			if (ticketOrder.getPreferential() < ConstantData.NONE
					&& ticketOrder.getPreferential() > ConstantData.MULTI) {
				System.out.println("\n잘못 입력하셨습니다. \n");
			}
		} while (ticketOrder.getPreferential() < ConstantData.NONE
				&& ticketOrder.getPreferential() > ConstantData.MULTI);
	}

	// 시스템 제어의 분기별 선택을 담당
	public void inputNextStep(int function) {
		do {
			if (function == ConstantData.ADD_ORDER) {
				System.out.println("계속 발권 하시겠습니까?");
				System.out.println("1. 다음 발권");
				System.out.println("2. 종료");
				System.out.print("> ");
			} else {
				System.out.println("새로운 주문리스트를 작성하시겠습니까?");
				System.out.println("1. 새로운 주문리스트 작성");
				System.out.println("2. 프로그램 완전히 종료");
				System.out.print("> ");
			}
			nextStep = s.nextInt();
			System.out.println();
			if (nextStep != ConstantData.RESUME && nextStep != ConstantData.EXIT) {
				System.out.println("\n잘못 입력하셨습니다. \n");
			}
		} while (nextStep != ConstantData.RESUME && nextStep != ConstantData.EXIT);
	}

	//파일로 부터의 입력을 받아 저장.
//	public boolean InputByFile(TicketInfo ticketOrder) throws IOException {
//		System.out.println("input파일을 읽어옵니다.");
//		BufferedReader reader = new BufferedReader(new FileReader(
//				"C:\\Users\\user\\eclipse-workspace\\TicketingSystem\\src\\TicketingSystem\\TestInput.csv"));
//		String line;
//		int lineCount = 0;
//		while ((line = reader.readLine()) != null) {
//			if(fileIndex == lineCount) {
//			String[] spliter = line.split(",");
//			ticketOrder.setTicketSelect(Integer.parseInt(spliter[ConstantData.F_TICKET_SELECT]));
//			ticketOrder.setTicketOption(Integer.parseInt(spliter[ConstantData.F_TICKET_OPTION]));
//			ticketOrder.setRrn(spliter[ConstantData.F_TICKET_RRN]);
//			System.out.println(spliter[ConstantData.F_TICKET_RRN]);
//			ticketOrder.setQuantity(Integer.parseInt(spliter[ConstantData.F_TICKET_QUANTITY]));
//			ticketOrder.setPreferential(Integer.parseInt(spliter[ConstantData.F_TICKET_PREFERENTIAL]));
//			}
//			lineCount++;
//		}if(ticketOrder.getQuantity() == 0) {
//			return false;
//		}
//		fileIndex++;
//		return true;
//	}
}