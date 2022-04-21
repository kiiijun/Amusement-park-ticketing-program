package TicketingSystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

// 시스템의 출력부를 담당하는 class
public class Print {

	// 출력 양식에 따라 출력을 담당
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

	// 사용자가 선택한 권종을 출력
	public void printTicketSelect(int ticketSelect) {
		if (ticketSelect == ConstantData.FULL) {
			System.out.print("종합이용권\t");
		} else {
			System.out.print("파크이용권\t");
		}
	}

	public void printFileTicketSelect(int ticketSelect, FileWriter fw) throws IOException {
		if (ticketSelect == ConstantData.FULL) {
			fw.write("종합이용권 ,");
		} else {
			fw.write("파크이용권 ,");
		}
	}

	// 사용자가 선택한 이용시간을 출력
	public void printTicketOption(int ticketOption) {
		if (ticketOption == ConstantData.ONE_DAY) {
			System.out.print("1DAY\t");
		} else {
			System.out.print("AFTER4\t");
		}
	}

	public void printFileTicketOption(int ticketOption, FileWriter fw) throws IOException {
		if (ticketOption == ConstantData.ONE_DAY) {
			fw.write("1DAY ,");
		} else {
			fw.write("AFTER4 ,");
		}
	}

	// 사용자의 만나이에 따른 요금제 출력
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
	
	public void printFileTicketAge(int ticketAge, FileWriter fw) throws IOException {
		if(ticketAge == ConstantData.AGE_FREE) {
			fw.write("무료 ,");
		}else if (ticketAge == ConstantData.AGE_BABY) {
			fw.write("베이비 ,");
		}else if (ticketAge == ConstantData.AGE_CHILD) {
			fw.write("어린이 ,");
		}else if (ticketAge == ConstantData.AGE_TEEN) {
			fw.write("청소년 ,");
		}else {
			fw.write("어른 ,");
		}
	}

	// 사용자가 선택한 우대사항 출력
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
	
	public void printFilePreferential(int preferential, FileWriter fw) throws IOException {
		if (preferential == ConstantData.NONE) {
			fw.write("*우대적용 없음 ");
		} else if (preferential == ConstantData.DISABLED) {
			fw.write("*장애인 우대적용 ");
		} else if (preferential == ConstantData.NATION) {
			fw.write("*국가유공자 우대적용 ");
		} else if (preferential == ConstantData.ARMY) {
			fw.write("*휴가장병 우대적용 ");
		} else if (preferential == ConstantData.PREGNANT) {
			fw.write("*임산부 우대적용 ");
		} else {
			fw.write("*다둥이 행복카드 우대적용 ");
		}
	}

	// 사용자가 입력한 발권 개수를 출력
	public void printQuantity(int quantity) {
		System.out.print("x " + quantity + "\t");
	}
	
	public void printFileQuantity(int quantity, FileWriter fw) throws IOException {
		fw.write(quantity+",");
	}

	// 사용자가 입력한 이용권의 가격을 형식에 맞게 출력
	public void printPrice(TicketInfo ticketOrder) {
		System.out.println("가격은 " + ticketOrder.getTicketPrice() + "원 입니다.");
		System.out.println("감사합니다.");
		System.out.println();
	}

	// 사용자가 입력한 이용권의 가격을 출력
	public void printTicketPrice(int ticketPrice) {
		System.out.print(ticketPrice + "\t");
	}
	
	public void printFileTicketPrice(int ticketPrice, FileWriter fw) throws IOException {
		fw.write(ticketPrice+",");
	}
	
	public void printFileOrderDate(String orderdate, FileWriter fw) throws IOException {
		fw.write(orderdate+",");
	}

	public void printFile(List<TicketInfo> orderList) throws IOException {
		File file = new File("C:\\Users\\user\\eclipse-workspace\\TicketingSystem\\src\\TicketingSystem\\Result.csv");
		FileWriter fw = new FileWriter(file, true);
		fw.write("날짜 ,권종 ,이용시간, 연령구분 ,수량 ,가격 ,우대사항 \n");
		for (int index = 0; index < orderList.size(); index++) {
			printFileOrderDate(orderList.get(index).getOrderDate(), fw);
			printFileTicketSelect(orderList.get(index).getTicketSelect(), fw);
			printFileTicketOption(orderList.get(index).getTicketOption(), fw);
			printFileTicketAge(orderList.get(index).getTicketAge(), fw);
			printFileQuantity(orderList.get(index).getQuantity(), fw);
			printFileTicketPrice(orderList.get(index).getTicketPrice(), fw);
			printFilePreferential(orderList.get(index).getPreferential(), fw);
			fw.write("\n");
		}
		fw.close();

	}

}
