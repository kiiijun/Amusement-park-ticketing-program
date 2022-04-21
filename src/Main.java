package TicketingSystem;

import java.io.IOException;

//Main class
//TicketSystem 생성 및 구동
public class Main {

	public static void main(String[] args) throws IOException {
		
		
		TicketSystem ts = new TicketSystem();
		ts.startSystem();
		ts.endSystem();
	}
}