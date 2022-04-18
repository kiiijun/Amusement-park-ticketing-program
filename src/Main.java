package TicketingSystem;

import java.util.Calendar;
import java.util.Scanner;

public class Main {
	public static final int F_1D_ADULT = 62000, F_1D_TEEN = 54000, F_1D_CHILD = 47000, F_A4_ADULT = 50000,
			F_A4_TEEN = 43000, F_A4_CHILD = 36000, P_1D_ADULT = 59000, P_1D_TEEN = 52000, P_1D_CHILD = 46000,
			P_A4_ADULT = 47000, P_A4_TEEN = 41000, P_A4_CHILD = 35000, BABY = 15000, FREE = 0;

	
	public static final int FULL = 1, PARK = 2;

	public static final int ONE_DAY = 1, AFTER_FOUR = 2;

	public static final int AGE_FREE = 1, AGE_BABY = 2, AGE_CHILD = 3, AGE_TEEN = 4, AGE_ADULT = 5;

	public static final int TICKET_SELECT = 0, TICKET_OPTION = 1, TICKET_AGE = 2, TICKET_QUANTITY = 3, TICKET_PRICE = 4,
			TICKET_PREFERENTIAL = 5;

	public static final int NONE = 1, DISABLED = 2, NATION = 3, ARMY = 4, PREGNANT = 5, MULTI = 6;

	public static final double TICKET_PREFERENTIAL_1 = 0.5, TICKET_PREFERENTIAL_2 = 0.51, TICKET_PREFERENTIAL_3 = 0.7;

	public static final int RESUME = 1, EXIT = 2;

	public static void main(String[] args) {
		int nextStep = 0;
		do {
			Scanner s = new Scanner(System.in);
			int index = 0;
			int[][] ticketInfo = new int[10][6];
			int rrn = 0;

			do {
				ticketInfo[index][TICKET_SELECT] = inputTicketSelect();
				ticketInfo[index][TICKET_OPTION] = inputTicketOption();
				int age = calculateAge(inputRRN());
				ticketInfo[index][TICKET_AGE] = caculateTicketAge(age);
				ticketInfo[index][TICKET_QUANTITY] = inputQuantity();
				ticketInfo[index][TICKET_PREFERENTIAL] = inputPreferential(age);
				ticketInfo[index][TICKET_PRICE] = calculateTicketPrice(ticketInfo, index);
				printPrice(ticketInfo[index][TICKET_PRICE], 1);
				nextStep = CheckNextStep(1);
				if (nextStep == RESUME) {
					index++;
				}
			} while (nextStep == RESUME);
			printTicketInfo(ticketInfo, index);
			nextStep = CheckNextStep(2);
		} while (nextStep == RESUME);
	}

	public static int inputTicketSelect() {
		Scanner s = new Scanner(System.in);
		System.out.println("권종을 선택하세요.");
		System.out.println("1. 종합이용권");
		System.out.println("2. 파크이용권");
		System.out.println("> ");
		int ticketSelect = s.nextInt();
		return ticketSelect;
	}

	public static int inputTicketOption() {
		Scanner s = new Scanner(System.in);
		System.out.println("권종을 선택하세요.");
		System.out.println("1. 1DAY");
		System.out.println("2. AFTER4");
		System.out.println("> ");
		int ticketOption = s.nextInt();
		return ticketOption;
	}

	public static String inputRRN() {
		String rrn;
		Scanner s = new Scanner(System.in);
		System.out.println("주민등록번호를 입력하세요.");
		System.out.println("> ");
		rrn = s.next();
		if (rrn.length() != 13) {
			System.out.println("다시 입력하세요.");
			System.out.println("> ");
		}
		return rrn;
	}

	public static int calculateAge(String rrn) {

		Calendar today = Calendar.getInstance();
		int Currentyear = today.get(Calendar.YEAR);
		int CurrentMonth = today.get(Calendar.MONTH);
		int CurrentDay = today.get(Calendar.DATE);
		int age = 0, yearOfBirth = 0, monthOfBirth = 0, dayOfBirth = 0;

		if (Character.getNumericValue(rrn.charAt(6)) == 3 || Character.getNumericValue(rrn.charAt(6)) == 4) {
			yearOfBirth = Character.getNumericValue(rrn.charAt(0)) * 10 + Character.getNumericValue(rrn.charAt(1))
					+ 2000;
		} else if (Character.getNumericValue(rrn.charAt(6)) == 1 || Character.getNumericValue(rrn.charAt(6)) == 2) {
			yearOfBirth = Character.getNumericValue(rrn.charAt(0)) * 10 + Character.getNumericValue(rrn.charAt(1))
					+ 1900;
		}
		monthOfBirth = Character.getNumericValue(rrn.charAt(2)) * 10 + Character.getNumericValue(rrn.charAt(3));
		dayOfBirth = Character.getNumericValue(rrn.charAt(4)) * 10 + Character.getNumericValue(rrn.charAt(5));
		if (CurrentMonth > monthOfBirth || (CurrentMonth == monthOfBirth && CurrentDay >= dayOfBirth)) {
			age = Currentyear - yearOfBirth;
		} else {
			age = Currentyear - yearOfBirth - 1;
		}
		return age;
	}

	public static int caculateTicketAge(int age) {
		int ticketAge = 0;
		if (age == 0) {
			ticketAge = AGE_FREE;
		} else if (age > 0 && age < 3) {
			ticketAge = AGE_BABY;
		} else if ((age >= 3 && age <= 12) || age >= 65) {
			ticketAge = AGE_CHILD;
		} else if (age >= 13 && age <= 18) {
			ticketAge = AGE_TEEN;
		} else if (age >= 19 && age < 65) {
			ticketAge = AGE_ADULT;
		}
		return ticketAge;
	}

	public static int inputQuantity() {
		Scanner s = new Scanner(System.in);
		System.out.println("발권 개수를 입력하세요.");
		System.out.println("> ");
		int quantity = s.nextInt();
		return quantity;
	}

	public static int inputPreferential(int age) {
		if (age < 65) {
			Scanner s = new Scanner(System.in);
			System.out.println("우대사항을 입력하세요.");
			System.out.println("1. 없음 (나이 우대는 자동처리)");
			System.out.println("2. 장애인");
			System.out.println("3. 국가유공자");
			System.out.println("4. 휴가장병");
			System.out.println("5. 임산부");
			System.out.println("6. 다둥이 행복카드");
			System.out.println("> ");

			int preferential = s.nextInt();
			return preferential;
		} else {
			System.out.println("귀하께서는 우대사항을 선택할 수 없습니다. (만 65세 이상)");
			return NONE;
		}
	}

	public static int calculateTicketPrice(int[][] ticketInfo, int index) {
		int ticketPrice = 0;
		if (ticketInfo[index][TICKET_AGE] == AGE_FREE) {
			ticketPrice = FREE;
		} else if (ticketInfo[index][TICKET_AGE] == AGE_BABY) {
			ticketPrice = BABY;
		} else if (ticketInfo[index][TICKET_AGE] == AGE_CHILD) {
			if (ticketInfo[index][TICKET_SELECT] == FULL) {
				if (ticketInfo[index][TICKET_OPTION] == ONE_DAY) {
					ticketPrice = F_1D_CHILD;
				} else {
					ticketPrice = F_A4_CHILD;
				}
			} else {
				if (ticketInfo[index][TICKET_OPTION] == ONE_DAY) {
					ticketPrice = P_1D_CHILD;
				} else {
					ticketPrice = P_A4_CHILD;
				}
			}
		} else if (ticketInfo[index][TICKET_AGE] == AGE_TEEN) {
			if (ticketInfo[index][TICKET_SELECT] == FULL) {
				if (ticketInfo[index][TICKET_OPTION] == ONE_DAY) {
					ticketPrice = F_1D_TEEN;
				} else {
					ticketPrice = F_A4_TEEN;
				}
			} else {
				if (ticketInfo[index][TICKET_OPTION] == ONE_DAY) {
					ticketPrice = P_1D_TEEN;
				} else {
					ticketPrice = P_A4_TEEN;
				}
			}
		} else if (ticketInfo[index][TICKET_AGE] == AGE_ADULT) {
			if (ticketInfo[index][TICKET_SELECT] == FULL) {
				if (ticketInfo[index][TICKET_OPTION] == ONE_DAY) {
					ticketPrice = F_1D_ADULT;
				} else {
					ticketPrice = F_A4_ADULT;
				}
			} else {
				if (ticketInfo[index][TICKET_OPTION] == ONE_DAY) {
					ticketPrice = P_1D_ADULT;
				} else {
					ticketPrice = P_A4_ADULT;
				}
			}
		}

		ticketPrice = ticketPrice * ticketInfo[index][TICKET_QUANTITY];

		if (ticketInfo[index][TICKET_PREFERENTIAL] == NONE) {
			ticketPrice = ticketPrice;
		} else if (ticketInfo[index][TICKET_PREFERENTIAL] == DISABLED) {
			ticketPrice = (int) (ticketPrice * TICKET_PREFERENTIAL_1);
		} else if (ticketInfo[index][TICKET_PREFERENTIAL] == NATION) {
			ticketPrice = (int) (ticketPrice * TICKET_PREFERENTIAL_1);
		} else if (ticketInfo[index][TICKET_PREFERENTIAL] == ARMY) {
			ticketPrice = (int) (ticketPrice * TICKET_PREFERENTIAL_2);
		} else if (ticketInfo[index][TICKET_PREFERENTIAL] == PREGNANT) {
			ticketPrice = (int) (ticketPrice * TICKET_PREFERENTIAL_1);
		} else if (ticketInfo[index][TICKET_PREFERENTIAL] == MULTI) {
			ticketPrice = (int) (ticketPrice * TICKET_PREFERENTIAL_3);
		}

		return ticketPrice;
	}

	public static int CalculateTotalPrice(int[][] ticketInfo, int index) {
		int totalPrice = 0;
		for (int i = 0; i <= index; i++) {
			totalPrice = totalPrice + ticketInfo[i][TICKET_PRICE];
		}
		return totalPrice;
	}

	public static int CheckNextStep(int function) {
		Scanner s = new Scanner(System.in);
		if(function == 1) {
		System.out.println("계속 발권 하시겠습니까?");
		System.out.println("1. 다음 발권");
		System.out.println("2. 종료");
		}
		else {
			System.out.println("새로운 주문리스트를 작성하시겠습니까?");
			System.out.println("1. 새로운 주문리스트 작성");
			System.out.println("2. 프로그램 완전히 종료");
		}
		int nextStep = s.nextInt();
		return nextStep;
		
	}

	public static void printTicketInfo(int[][] ticketInfo, int index) {
		int totalPrice = 0;
		totalPrice = CalculateTotalPrice(ticketInfo, index);
		System.out.println("발권을 종료합니다. 감사합니다.");
		System.out.println("------------ 롯데 월드 ---------------");
		for (int i = 0; i <= index; i++) {
			printTicketSelect(ticketInfo[i][TICKET_SELECT]);
			printTicketOption(ticketInfo[i][TICKET_OPTION]);
			printTicketAge(ticketInfo[i][TICKET_AGE]);
			printQuantity(ticketInfo[i][TICKET_QUANTITY]);
			printPrice(ticketInfo[i][TICKET_PRICE], 2);
			printPreferential(TICKET_PREFERENTIAL);
			System.out.println();
		}
		System.out.println("입장료 총액은 " + totalPrice + "원입니다. ");
		System.out.println("-----------------------------------");
	}

	public static void printTicketSelect(int ticketSelect) {
		if (ticketSelect == FULL) {
			System.out.print("종합이용권\t");
		} else {
			System.out.print("파크이용권\t");
		}
	}

	public static void printTicketOption(int ticketOption) {
		if (ticketOption == ONE_DAY) {
			System.out.print("1DAY\t");
		} else {
			System.out.print("AFTER4\t");
		}
	}

	public static void printTicketAge(int ticketAge) {
		if (ticketAge == AGE_FREE) {
			System.out.print("무료\t");
		} else if (ticketAge == AGE_BABY) {
			System.out.print("베이비\t");
		} else if (ticketAge == AGE_CHILD) {
			System.out.print("어린이\t");
		} else if (ticketAge == AGE_TEEN) {
			System.out.print("청소년\t");
		} else {
			System.out.print("어른\t");
		}
	}

	public static void printPreferential(int preferential) {
		if (preferential == NONE) {
			System.out.print("*우대적용 없음");
		} else if (preferential == DISABLED) {
			System.out.print("*장애인 우대적용");
		} else if (preferential == NATION) {
			System.out.print("*국가유공자 우대적용");
		} else if (preferential == ARMY) {
			System.out.print("*휴가장병 우대적용");
		} else if (preferential == PREGNANT) {
			System.out.print("*임산부 우대적용");
		} else {
			System.out.print("*다둥이 행복카드 우대적용");
		}
	}

	public static void printQuantity(int quantity) {
		System.out.print("x " + quantity + "\t");
	}

	public static void printPrice(int price, int function) {
		if (function == 1) {
			System.out.println("가격은 " + price + "원 입니다.");
			System.out.println("감사합니다.");
		} else {
			System.out.print(price + "\t");
		}
	}
}