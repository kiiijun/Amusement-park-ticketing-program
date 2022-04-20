package TicketingSystem;

import java.util.List;

public class Print {

	public void printTicketInfo(List<TicketInfo> orderList, int totalPrice) {
		System.out.println("발권을 종료합니다. 감사합니다.");
		System.out.println();
		System.out.println("------------ 롯데 월드 ---------------");
		for (int index = 0; index < orderList.size(); index++) {
			printTicketSelect(orderList.get(index).getTicketSelect());
			printTicketOption(orderList.get(index).getTicketOption());
			printTicketAge(orderList.get(index).getTicketAge());
			printQuantity(orderList.get(index).getQuantity());
			printTicketPrice(orderList.get(index).getTicketPrice());
			printPreferential(orderList.get(index).getPreferential());
			System.out.println();
		}
		System.out.println();
		System.out.println("입장료 총액은 " + totalPrice + "원입니다. ");
		System.out.println();
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

	public void printPrice(TicketInfo ticketOrder) {
		System.out.println("가격은 " + ticketOrder.getTicketPrice() + "원 입니다.");
		System.out.println("감사합니다.");
		System.out.println();
	}

	public void printTicketPrice(int ticketPrice) {
		System.out.print(ticketPrice + "\t");
	}

}
