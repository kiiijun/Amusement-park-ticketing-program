package TicketingSystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

// 시스템의 출력부를 담당하는 class
public class Print {

	// 출력 양식에 따라 출력을 담당
	public void printTicketInfo(List<TicketInfo> orderList, int totalPrice) {
		System.out.println("발권을 종료합니다. 감사합니다.\n");
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
		System.out.println("=*=*=*=*=*=*=*= LOTTE WORLD ADVENTURE =*=*=*=*=*=*=*=*");
		System.out.println("=*=*=*=*=*= PLEASE CHECK YOUR ORDER LIST =*=*=*=*=*=**\n");

		for (int index = 0; index < orderList.size(); index++) {
			printTicketSelect(orderList.get(index).getTicketSelect());
			printTicketOption(orderList.get(index).getTicketOption());
			printTicketAge(orderList.get(index).getTicketAge());
			printQuantity(orderList.get(index).getQuantity());
			printTicketPrice(orderList.get(index).getTicketPrice());
			printPreferential(orderList.get(index).getPreferential());
			System.out.println();
		}
		System.out.println("\n입장료 총액은 " + totalPrice + "원입니다. \n");
		System.out.println("=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*=*\n");
	}

	// txt 파일에 ArrayList의 내용 저장.
	public void printFile(List<TicketInfo> orderList) {
		File file = new File("C:\\Users\\snrm1\\eclipse-workspace\\TicketingSystem\\src\\TicketingSystem\\Result.txt");
		FileWriter fw = null;
		BufferedWriter bw = null;
		boolean checkFileExistence = false;
		if (file.exists()) {
			checkFileExistence = true;
		}
		try {
			fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);
			if (checkFileExistence == false) {
				bw.write("날짜,권종,이용시간,연령구분,수량,가격,우대사항\n");
			}
			for (int index = 0; index < orderList.size(); index++) {
				printFileOrderDate(orderList.get(index).getOrderDate(), bw);
				printFileTicketSelect(orderList.get(index).getTicketSelect(), bw);
				printFileTicketOption(orderList.get(index).getTicketOption(), bw);
				printFileTicketAge(orderList.get(index).getTicketAge(), bw);
				printFileQuantity(orderList.get(index).getQuantity(), bw);
				printFileTicketPrice(orderList.get(index).getTicketPrice(), bw);
				printFilePreferential(orderList.get(index).getPreferential(), bw);
				bw.newLine();
			}
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null) {
					bw.close();
				}
				if (fw != null) {
					fw.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	// 사용자가 선택한 권종을 출력
	public void printTicketSelect(int ticketSelect) {
		if (ticketSelect == ConstantData.FULL) {
			System.out.printf(" %5s *", "종합이용권");
		} else {
			System.out.printf(" %5s *", "파크이용권");
		}
	}

	// 사용자가 선택한 권종을 파일에 쓰기
	public void printFileTicketSelect(int ticketSelect, BufferedWriter bw) {
		try {
			if (ticketSelect == ConstantData.FULL) {
				bw.write("종합이용권,");
			} else {
				bw.write("파크이용권,");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 사용자가 선택한 이용시간을 출력
	public void printTicketOption(int ticketOption) {
		if (ticketOption == ConstantData.ONE_DAY) {
			System.out.printf(" %3s *", "주간권");
		} else {
			System.out.printf(" %3s *", "야간권");
		}
	}

	// 사용자가 선택한 이용시간을 파일에 쓰기
	public void printFileTicketOption(int ticketOption, BufferedWriter bw) {
		try {
			if (ticketOption == ConstantData.ONE_DAY) {
				bw.write("주간권,");
			} else {
				bw.write("야간권,");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 사용자의 만나이에 따른 요금제 출력
	public void printTicketAge(int ticketAge) {
		if (ticketAge == ConstantData.AGE_FREE) {
			System.out.printf(" %3s *", "무료");
		} else if (ticketAge == ConstantData.AGE_BABY) {
			System.out.printf(" %3s *", "베이비");
		} else if (ticketAge == ConstantData.AGE_CHILD) {
			System.out.printf(" %3s *", "어린이");
		} else if (ticketAge == ConstantData.AGE_TEEN) {
			System.out.printf(" %3s *", "청소년");
		} else {
			System.out.printf(" %3s *", "어른");
		}
	}

	// 사용자의 만나이에 따른 요금제 파일에 쓰기
	public void printFileTicketAge(int ticketAge, BufferedWriter bw) {
		try {
			if (ticketAge == ConstantData.AGE_FREE) {
				bw.write("무료,");
			} else if (ticketAge == ConstantData.AGE_BABY) {
				bw.write("베이비,");
			} else if (ticketAge == ConstantData.AGE_CHILD) {
				bw.write("어린이,");
			} else if (ticketAge == ConstantData.AGE_TEEN) {
				bw.write("청소년,");
			} else {
				bw.write("어른,");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 사용자가 선택한 우대사항 출력
	public void printPreferential(int preferential) {
		if (preferential == ConstantData.NONE) {
			System.out.printf(" %10s *", "우대적용 없음");
		} else if (preferential == ConstantData.DISABLED) {
			System.out.printf(" %10s *", "장애인 우대적용");
		} else if (preferential == ConstantData.NATION) {
			System.out.printf(" %10s *", "국가유공자 우대적용");
		} else if (preferential == ConstantData.ARMY) {
			System.out.printf(" %10s *", "휴가장병 우대적용");
		} else if (preferential == ConstantData.PREGNANT) {
			System.out.printf(" %10s *", "임산부 우대적용");
		} else {
			System.out.printf(" %10s *", "다둥이 우대적용");
		}
	}

	// 사용자가 선택한 우대사항 파일에 쓰기
	public void printFilePreferential(int preferential, BufferedWriter bw) {
		try {
			if (preferential == ConstantData.NONE) {
				bw.write("우대적용 없음");
			} else if (preferential == ConstantData.DISABLED) {
				bw.write("장애인 우대적용");
			} else if (preferential == ConstantData.NATION) {
				bw.write("국가유공자 우대적용");
			} else if (preferential == ConstantData.ARMY) {
				bw.write("휴가장병 우대적용");
			} else if (preferential == ConstantData.PREGNANT) {
				bw.write("임산부 우대적용");
			} else {
				bw.write("다둥이 우대적용");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 사용자가 입력한 발권 개수를 출력
	public void printQuantity(int quantity) {
		System.out.printf(" %2d장 *", quantity);
	}

	// 사용자가 입력한 발권 개수를 쓰기
	public void printFileQuantity(int quantity, BufferedWriter bw) {
		try {
			bw.write(quantity + ",");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 사용자가 입력한 이용권의 가격을 형식에 맞게 출력
	public void printPrice(TicketInfo ticketOrder) {
		System.out.println("가격은 " + ticketOrder.getTicketPrice() + "원 입니다.");
		System.out.println("감사합니다.");
		System.out.println();
	}

	// 사용자가 입력한 이용권의 가격을 출력
	public void printTicketPrice(int ticketPrice) {
		System.out.printf(" %6d원 *", ticketPrice);
	}

	// 사용자가 입력한 이용권의 가격을 파일에 쓰기
	public void printFileTicketPrice(int ticketPrice, BufferedWriter bw) {
		try {
			bw.write(ticketPrice + ",");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 사용자가 발권한 일자를 파일에 쓰기
	public void printFileOrderDate(String orderdate, BufferedWriter bw) {
		try {
			bw.write(orderdate + ",");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
