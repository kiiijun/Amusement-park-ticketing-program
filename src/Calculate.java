package TicketingSystem;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

// 시스템의 계산부를 담당하는 class
public class Calculate {

	// 만나이, 나이별 요금제, 티켓 금액 계산 묶음
	public void calculateData(TicketInfo ticketOrder) {
		calculateAge(ticketOrder);
		caculateTicketAge(ticketOrder);
		calculateTicketPrice(ticketOrder);
	}

	// 만 나이 계산
	public void calculateAge(TicketInfo ticketOrder) {
		SimpleDateFormat todayFormat = new SimpleDateFormat("yyyyMMdd");
		Calendar today = Calendar.getInstance();
		ticketOrder.setOrderDate(todayFormat.format(today.getTime()));
		int Currentyear = today.get(Calendar.YEAR);
		int CurrentMonth = today.get(Calendar.MONTH) + 1;
		int CurrentDay = today.get(Calendar.DATE);
		int yearOfBirth = 0, monthOfBirth = 0, dayOfBirth = 0;

		if (Character.getNumericValue(ticketOrder.getRrn().charAt(6)) == 3
				|| Character.getNumericValue(ticketOrder.getRrn().charAt(6)) == 4) {
			yearOfBirth = Character.getNumericValue(ticketOrder.getRrn().charAt(0)) * 10
					+ Character.getNumericValue(ticketOrder.getRrn().charAt(1)) + 2000;
		} else if (Character.getNumericValue(ticketOrder.getRrn().charAt(6)) == 1
				|| Character.getNumericValue(ticketOrder.getRrn().charAt(6)) == 2) {
			yearOfBirth = Character.getNumericValue(ticketOrder.getRrn().charAt(0)) * 10
					+ Character.getNumericValue(ticketOrder.getRrn().charAt(1)) + 1900;
		}
		monthOfBirth = Character.getNumericValue(ticketOrder.getRrn().charAt(2)) * 10
				+ Character.getNumericValue(ticketOrder.getRrn().charAt(3));
		dayOfBirth = Character.getNumericValue(ticketOrder.getRrn().charAt(4)) * 10
				+ Character.getNumericValue(ticketOrder.getRrn().charAt(5));
		if (CurrentMonth > monthOfBirth || (CurrentMonth == monthOfBirth && CurrentDay >= dayOfBirth)) {
			ticketOrder.setAge(Currentyear - yearOfBirth);
		} else {
			ticketOrder.setAge(Currentyear - yearOfBirth - 1);
		}
	}

	// 나이별 요금제 구분
	public void caculateTicketAge(TicketInfo ticketOrder) {
		if (ticketOrder.getAge() == 0) {
			ticketOrder.setTicketAge(ConstantData.AGE_FREE);
		} else if (ticketOrder.getAge() > 0 && ticketOrder.getAge() < 3) {
			ticketOrder.setTicketAge(ConstantData.AGE_BABY);
		} else if ((ticketOrder.getAge() >= 3 && ticketOrder.getAge() <= 12) || ticketOrder.getAge() >= 65) {
			ticketOrder.setTicketAge(ConstantData.AGE_CHILD);
		} else if (ticketOrder.getAge() >= 13 && ticketOrder.getAge() <= 18) {
			ticketOrder.setTicketAge(ConstantData.AGE_TEEN);
		} else if (ticketOrder.getAge() >= 19 && ticketOrder.getAge() < 65) {
			ticketOrder.setTicketAge(ConstantData.AGE_ADULT);
		}
	}

	// 티켓 금액 계산
	public void calculateTicketPrice(TicketInfo ticketOrder) {
		if (ticketOrder.getTicketAge() == ConstantData.AGE_FREE) {
			ticketOrder.setTicketPrice(ConstantData.FREE);
		} else if (ticketOrder.getTicketAge() == ConstantData.AGE_BABY) {
			ticketOrder.setTicketPrice(ConstantData.BABY);
		} else if (ticketOrder.getTicketAge() == ConstantData.AGE_CHILD) {
			if (ticketOrder.getTicketSelect() == ConstantData.FULL) {
				if (ticketOrder.getTicketOption() == ConstantData.ONE_DAY) {
					ticketOrder.setTicketPrice(ConstantData.F_1D_CHILD);
				} else {
					ticketOrder.setTicketPrice(ConstantData.F_A4_CHILD);
				}
			} else {
				if (ticketOrder.getTicketOption() == ConstantData.ONE_DAY) {
					ticketOrder.setTicketPrice(ConstantData.P_1D_CHILD);
				} else {
					ticketOrder.setTicketPrice(ConstantData.P_A4_CHILD);
				}
			}
		} else if (ticketOrder.getTicketAge() == ConstantData.AGE_TEEN) {
			if (ticketOrder.getTicketSelect() == ConstantData.FULL) {
				if (ticketOrder.getTicketOption() == ConstantData.ONE_DAY) {
					ticketOrder.setTicketPrice(ConstantData.F_1D_TEEN);
				} else {
					ticketOrder.setTicketPrice(ConstantData.F_A4_TEEN);
				}
			} else {
				if (ticketOrder.getTicketOption() == ConstantData.ONE_DAY) {
					ticketOrder.setTicketPrice(ConstantData.P_1D_TEEN);
				} else {
					ticketOrder.setTicketPrice(ConstantData.P_A4_TEEN);
				}
			}
		} else if (ticketOrder.getTicketAge() == ConstantData.AGE_ADULT) {
			if (ticketOrder.getTicketSelect() == ConstantData.FULL) {
				if (ticketOrder.getTicketOption() == ConstantData.ONE_DAY) {
					ticketOrder.setTicketPrice(ConstantData.F_1D_ADULT);
				} else {
					ticketOrder.setTicketPrice(ConstantData.F_A4_ADULT);
				}
			} else {
				if (ticketOrder.getTicketOption() == ConstantData.ONE_DAY) {
					ticketOrder.setTicketPrice(ConstantData.P_1D_ADULT);
				} else {
					ticketOrder.setTicketPrice(ConstantData.P_A4_ADULT);
				}
			}
		}

		ticketOrder.setTicketPrice(ticketOrder.getTicketPrice() * ticketOrder.getQuantity());

		if (ticketOrder.getPreferential() == ConstantData.NONE) {
			ticketOrder.setTicketPrice(ticketOrder.getTicketPrice());
		} else if (ticketOrder.getPreferential() == ConstantData.DISABLED) {
			ticketOrder.setTicketPrice((int) (ticketOrder.getTicketPrice() * ConstantData.TICKET_PREFERENTIAL_1));
		} else if (ticketOrder.getPreferential() == ConstantData.NATION) {
			ticketOrder.setTicketPrice((int) (ticketOrder.getTicketPrice() * ConstantData.TICKET_PREFERENTIAL_1));
		} else if (ticketOrder.getPreferential() == ConstantData.ARMY) {
			ticketOrder.setTicketPrice((int) (ticketOrder.getTicketPrice() * ConstantData.TICKET_PREFERENTIAL_2));
		} else if (ticketOrder.getPreferential() == ConstantData.PREGNANT) {
			ticketOrder.setTicketPrice((int) (ticketOrder.getTicketPrice() * ConstantData.TICKET_PREFERENTIAL_1));
		} else if (ticketOrder.getPreferential() == ConstantData.MULTI) {
			ticketOrder.setTicketPrice((int) (ticketOrder.getTicketPrice() * ConstantData.TICKET_PREFERENTIAL_3));
		}
	}

	// 모든 주문에 대한 총액 계산
	public int CalculateTotalPrice(List<TicketInfo> orderList) {
		int totalPrice = 0;
		for (int index = 0; index < orderList.size(); index++) {
			totalPrice = totalPrice + orderList.get(index).getTicketPrice();
		}
		return totalPrice;
	}
}
