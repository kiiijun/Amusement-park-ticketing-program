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

	public void inputTicketOption(TicketInfo ticketOrder) {
		do {
			System.out.println("권종을 선택하세요.");
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

	public void inputQuantity(TicketInfo ticketOrder) {
		System.out.println("발권 개수를 입력하세요.");
		System.out.print("> ");
		ticketOrder.setQuantity(s.nextInt());
		System.out.println();
	}

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
}
