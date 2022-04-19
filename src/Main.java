package TicketingSystem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Main {

	Scanner s = new Scanner(System.in);
	TicketInfo ticketOrder;
	List<TicketInfo> orderList = new ArrayList<TicketInfo>();
	int nextStep;

	public static void main(String[] args) {
		Main ts = new Main();
		do {
			do {
				ts.ticketOrder = new TicketInfo();
				ts.inputTicketSelect();
				ts.inputTicketOption();
				ts.inputRRN();
				ts.calculateAge();
				ts.caculateTicketAge();
				ts.inputQuantity();
				ts.inputPreferential();
				ts.calculateTicketPrice();
				ts.printPrice();
				ts.addList();
				ts.CheckNextStep(1);
			} while (ts.nextStep == ConstantData.RESUME);
			ts.printTicketInfo();
			ts.CheckNextStep(2);
		} while (ts.nextStep == ConstantData.RESUME);
	}

	public void inputTicketSelect() {
		do {
			System.out.println("권종을 선택하세요.");
			System.out.println("1. 종합이용권");
			System.out.println("2. 파크이용권");
			System.out.print("> ");
			ticketOrder.ticketSelect = s.nextInt();
			if (ticketOrder.ticketSelect != ConstantData.FULL && ticketOrder.ticketSelect != ConstantData.PARK) {
				System.out.println("\n잘못 입력하셨습니다. \n");
			}
		} while (ticketOrder.ticketSelect != ConstantData.FULL && ticketOrder.ticketSelect != ConstantData.PARK);
	}

	public void inputTicketOption() {
		do {
			System.out.println("권종을 선택하세요.");
			System.out.println("1. 1DAY");
			System.out.println("2. AFTER4");
			System.out.print("> ");
			ticketOrder.ticketOption = s.nextInt();
			if (ticketOrder.ticketOption != ConstantData.ONE_DAY
					&& ticketOrder.ticketOption != ConstantData.AFTER_FOUR) {
				System.out.println("\n잘못 입력하셨습니다. \n");
			}
		} while (ticketOrder.ticketOption != ConstantData.ONE_DAY
				&& ticketOrder.ticketOption != ConstantData.AFTER_FOUR);
	}

	public void inputRRN() {
		do {
			System.out.println("주민등록번호를 입력하세요.");
			System.out.print("> ");
			ticketOrder.rrn = s.next();
			if (ticketOrder.rrn.length() != 13) {
				System.out.println("\n잘못 입력하셨습니다. \n");
			}
		} while (ticketOrder.rrn.length() != 13);
	}

	public void calculateAge() {

		Calendar today = Calendar.getInstance();
		int Currentyear = today.get(Calendar.YEAR);
		int CurrentMonth = today.get(Calendar.MONTH);
		int CurrentDay = today.get(Calendar.DATE);
		int yearOfBirth = 0, monthOfBirth = 0, dayOfBirth = 0;

		if (Character.getNumericValue(ticketOrder.rrn.charAt(6)) == 3
				|| Character.getNumericValue(ticketOrder.rrn.charAt(6)) == 4) {
			yearOfBirth = Character.getNumericValue(ticketOrder.rrn.charAt(0)) * 10
					+ Character.getNumericValue(ticketOrder.rrn.charAt(1)) + 2000;
		} else if (Character.getNumericValue(ticketOrder.rrn.charAt(6)) == 1
				|| Character.getNumericValue(ticketOrder.rrn.charAt(6)) == 2) {
			yearOfBirth = Character.getNumericValue(ticketOrder.rrn.charAt(0)) * 10
					+ Character.getNumericValue(ticketOrder.rrn.charAt(1)) + 1900;
		}
		monthOfBirth = Character.getNumericValue(ticketOrder.rrn.charAt(2)) * 10
				+ Character.getNumericValue(ticketOrder.rrn.charAt(3));
		dayOfBirth = Character.getNumericValue(ticketOrder.rrn.charAt(4)) * 10
				+ Character.getNumericValue(ticketOrder.rrn.charAt(5));
		if (CurrentMonth > monthOfBirth || (CurrentMonth == monthOfBirth && CurrentDay >= dayOfBirth)) {
			ticketOrder.age = Currentyear - yearOfBirth;
		} else {
			ticketOrder.age = Currentyear - yearOfBirth - 1;
		}
	}

	public void caculateTicketAge() {
		if (ticketOrder.age == 0) {
			ticketOrder.ticketAge = ConstantData.AGE_FREE;
		} else if (ticketOrder.age > 0 && ticketOrder.age < 3) {
			ticketOrder.ticketAge = ConstantData.AGE_BABY;
		} else if ((ticketOrder.age >= 3 && ticketOrder.age <= 12) || ticketOrder.age >= 65) {
			ticketOrder.ticketAge = ConstantData.AGE_CHILD;
		} else if (ticketOrder.age >= 13 && ticketOrder.age <= 18) {
			ticketOrder.ticketAge = ConstantData.AGE_TEEN;
		} else if (ticketOrder.age >= 19 && ticketOrder.age < 65) {
			ticketOrder.ticketAge = ConstantData.AGE_ADULT;
		}
	}

	public void inputQuantity() {
		System.out.println("발권 개수를 입력하세요.");
		System.out.print("> ");
		ticketOrder.quantity = s.nextInt();
	}

	public void inputPreferential() {
		do {
			if (ticketOrder.age < 65) {
				System.out.println("우대사항을 입력하세요.");
				System.out.println("1. 없음 (나이 우대는 자동처리)");
				System.out.println("2. 장애인");
				System.out.println("3. 국가유공자");
				System.out.println("4. 휴가장병");
				System.out.println("5. 임산부");
				System.out.println("6. 다둥이 행복카드");
				System.out.print("> ");
				ticketOrder.preferential = s.nextInt();
			} else {
				System.out.println("귀하께서는 우대사항을 선택할 수 없습니다. (만 65세 이상)");
				ticketOrder.preferential = ConstantData.NONE;
			}

			if (ticketOrder.preferential < ConstantData.NONE && ticketOrder.preferential > ConstantData.MULTI) {
				System.out.println("\n잘못 입력하셨습니다. \n");
			}
		} while (ticketOrder.preferential < ConstantData.NONE && ticketOrder.preferential > ConstantData.MULTI);
	}

	public void calculateTicketPrice() {
		if (ticketOrder.ticketAge == ConstantData.AGE_FREE) {
			ticketOrder.ticketPrice = ConstantData.FREE;
		} else if (ticketOrder.ticketAge == ConstantData.AGE_BABY) {
			ticketOrder.ticketPrice = ConstantData.BABY;
		} else if (ticketOrder.ticketAge == ConstantData.AGE_CHILD) {
			if (ticketOrder.ticketSelect == ConstantData.FULL) {
				if (ticketOrder.ticketOption == ConstantData.ONE_DAY) {
					ticketOrder.ticketPrice = ConstantData.F_1D_CHILD;
				} else {
					ticketOrder.ticketPrice = ConstantData.F_A4_CHILD;
				}
			} else {
				if (ticketOrder.ticketOption == ConstantData.ONE_DAY) {
					ticketOrder.ticketPrice = ConstantData.P_1D_CHILD;
				} else {
					ticketOrder.ticketPrice = ConstantData.P_A4_CHILD;
				}
			}
		} else if (ticketOrder.ticketAge == ConstantData.AGE_TEEN) {
			if (ticketOrder.ticketSelect == ConstantData.FULL) {
				if (ticketOrder.ticketOption == ConstantData.ONE_DAY) {
					ticketOrder.ticketPrice = ConstantData.F_1D_TEEN;
				} else {
					ticketOrder.ticketPrice = ConstantData.F_A4_TEEN;
				}
			} else {
				if (ticketOrder.ticketOption == ConstantData.ONE_DAY) {
					ticketOrder.ticketPrice = ConstantData.P_1D_TEEN;
				} else {
					ticketOrder.ticketPrice = ConstantData.P_A4_TEEN;
				}
			}
		} else if (ticketOrder.ticketAge == ConstantData.AGE_ADULT) {
			if (ticketOrder.ticketSelect == ConstantData.FULL) {
				if (ticketOrder.ticketOption == ConstantData.ONE_DAY) {
					ticketOrder.ticketPrice = ConstantData.F_1D_ADULT;
				} else {
					ticketOrder.ticketPrice = ConstantData.F_A4_ADULT;
				}
			} else {
				if (ticketOrder.ticketOption == ConstantData.ONE_DAY) {
					ticketOrder.ticketPrice = ConstantData.P_1D_ADULT;
				} else {
					ticketOrder.ticketPrice = ConstantData.P_A4_ADULT;
				}
			}
		}

		ticketOrder.ticketPrice = ticketOrder.ticketPrice * ticketOrder.quantity;

		if (ticketOrder.preferential == ConstantData.NONE) {
			ticketOrder.ticketPrice = ticketOrder.ticketPrice;
		} else if (ticketOrder.preferential == ConstantData.DISABLED) {
			ticketOrder.ticketPrice = (int) (ticketOrder.ticketPrice * ConstantData.TICKET_PREFERENTIAL_1);
		} else if (ticketOrder.preferential == ConstantData.NATION) {
			ticketOrder.ticketPrice = (int) (ticketOrder.ticketPrice * ConstantData.TICKET_PREFERENTIAL_1);
		} else if (ticketOrder.preferential == ConstantData.ARMY) {
			ticketOrder.ticketPrice = (int) (ticketOrder.ticketPrice * ConstantData.TICKET_PREFERENTIAL_2);
		} else if (ticketOrder.preferential == ConstantData.PREGNANT) {
			ticketOrder.ticketPrice = (int) (ticketOrder.ticketPrice * ConstantData.TICKET_PREFERENTIAL_1);
		} else if (ticketOrder.preferential == ConstantData.MULTI) {
			ticketOrder.ticketPrice = (int) (ticketOrder.ticketPrice * ConstantData.TICKET_PREFERENTIAL_3);
		}
	}

	public void addList() {
		orderList.add(ticketOrder);
	}

	public int CalculateTotalPrice() {
		int totalPrice = 0;
		for (int index = 0; index < orderList.size(); index++) {
			totalPrice = totalPrice + orderList.get(index).ticketPrice;
		}
		return totalPrice;
	}

	public void CheckNextStep(int function) {
		do {
			if (function == 1) {
				System.out.println("계속 발권 하시겠습니까?");
				System.out.println("1. 다음 발권");
				System.out.println("2. 종료");
			} else {
				System.out.println("새로운 주문리스트를 작성하시겠습니까?");
				System.out.println("1. 새로운 주문리스트 작성");
				System.out.println("2. 프로그램 완전히 종료");
			}
			nextStep = s.nextInt();
			if(nextStep != ConstantData.RESUME && nextStep != ConstantData.EXIT) {
				System.out.println("\n잘못 입력하셨습니다. \n");
			}
		} while (nextStep != ConstantData.RESUME && nextStep != ConstantData.EXIT);
	}

	public void printTicketInfo() {
		System.out.println("발권을 종료합니다. 감사합니다.");
		System.out.println("------------ 롯데 월드 ---------------");
		for (int index = 0; index < orderList.size(); index++) {
			printTicketSelect(orderList.get(index).ticketSelect);
			printTicketOption(orderList.get(index).ticketOption);
			printTicketAge(orderList.get(index).ticketAge);
			printQuantity(orderList.get(index).quantity);
			printTicketPrice(orderList.get(index).ticketPrice);
			printPreferential(orderList.get(index).preferential);
			System.out.println();
		}
		System.out.println("입장료 총액은 " + CalculateTotalPrice() + "원입니다. ");
		System.out.println("-----------------------------------");
	}

	public void printTicketSelect(int ticketSelect) {
		if (ticketSelect == ConstantData.FULL) {
			System.out.print("종합이용권\t");
		} else {
			System.out.print("파크이용권\t");
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
			System.out.print("무료\t");
		} else if (ticketAge == ConstantData.AGE_BABY) {
			System.out.print("베이비\t");
		} else if (ticketAge == ConstantData.AGE_CHILD) {
			System.out.print("어린이\t");
		} else if (ticketAge == ConstantData.AGE_TEEN) {
			System.out.print("청소년\t");
		} else {
			System.out.print("어른\t");
		}
	}

	public void printPreferential(int preferential) {
		if (preferential == ConstantData.NONE) {
			System.out.print("*우대적용 없음");
		} else if (preferential == ConstantData.DISABLED) {
			System.out.print("*장애인 우대적용");
		} else if (preferential == ConstantData.NATION) {
			System.out.print("*국가유공자 우대적용");
		} else if (preferential == ConstantData.ARMY) {
			System.out.print("*휴가장병 우대적용");
		} else if (preferential == ConstantData.PREGNANT) {
			System.out.print("*임산부 우대적용");
		} else {
			System.out.print("*다둥이 행복카드 우대적용");
		}
	}

	public void printQuantity(int quantity) {
		System.out.print("x " + quantity + "\t");
	}

	public void printPrice() {
		System.out.println("가격은 " + ticketOrder.ticketPrice + "원 입니다.");
		System.out.println("감사합니다.");
	}

	public void printTicketPrice(int ticketPrice) {
		System.out.print(ticketPrice + "\t");
	}
}