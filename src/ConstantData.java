package TicketingSystem;

//시스템의 상수값을 담당하는 class
public final class ConstantData {

	// 모든 종류의 이용권 금액 구분
	public static final int F_1D_ADULT = 62000, F_1D_TEEN = 54000, F_1D_CHILD = 47000, F_A4_ADULT = 50000,
			F_A4_TEEN = 43000, F_A4_CHILD = 36000, P_1D_ADULT = 59000, P_1D_TEEN = 52000, P_1D_CHILD = 46000,
			P_A4_ADULT = 47000, P_A4_TEEN = 41000, P_A4_CHILD = 35000, BABY = 15000, FREE = 0;

	// 종합이용권, 파크이용권 구분
	public static final int FULL = 1, PARK = 2;

	// 하루이용권, 4시이후이용권 구분
	public static final int ONE_DAY = 1, AFTER_FOUR = 2;

	// 무료, 베이비, 어린이, 청소년, 어른 구분
	public static final int AGE_FREE = 1, AGE_BABY = 2, AGE_CHILD = 3, AGE_TEEN = 4, AGE_ADULT = 5;

	// 이용권 출력시 출력 데이터 구분
	public static final int TICKET_SELECT = 0, TICKET_OPTION = 1, TICKET_AGE = 2, TICKET_QUANTITY = 3, TICKET_PRICE = 4,
			TICKET_PREFERENTIAL = 5;

	// 우대사항 구분
	public static final int NONE = 1, DISABLED = 2, NATION = 3, ARMY = 4, PREGNANT = 5, MULTI = 6;

	// 우대사항별 할인율 구분
	public static final double TICKET_PREFERENTIAL_1 = 0.5, TICKET_PREFERENTIAL_2 = 0.51, TICKET_PREFERENTIAL_3 = 0.7;

	// 시스템 제어 기능 구분
	public static final int RESUME = 1, EXIT = 2;

	// 주문 기능 구분
	public static final int ADD_ORDER = 1, NEW_ORDER = 2;

	// 파일 입력시 입력 데이터 구분
	public static final int F_TICKET_SELECT = 0, F_TICKET_OPTION = 1, F_TICKET_RRN = 2, F_TICKET_QUANTITY = 3,
			F_TICKET_PREFERENTIAL = 4;

	// 입력 방식 구분
	public static final int KEYBOARD = 1, FILE = 2;
}
