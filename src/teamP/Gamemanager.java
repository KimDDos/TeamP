package teamP;

import java.util.Scanner;

public class Gamemanager {
	private TexasHoldem th = new TexasHoldem();
	private SevenPoker sf = new SevenPoker();
	private IndianPoker iPoker = new IndianPoker();

	public void mainConsole(Scanner scan) {
		int menu = 0;
		do {
			System.out.println("----GAME----");
			System.out.println("1. 텍사스 홀덤");
			System.out.println("2. 세븐포커");
			System.out.println("3. 블랙잭");
			System.out.println("4. 인디언포커");
			System.out.println("5. 도둑잡기");
			System.out.println("6. 종료");
			System.out.print("> 번호입력 : ");
			menu = scan.nextInt();
			
			switch(menu){
			case 1 : th.start();
				break;
			case 2 : sf.sevenPokerStart(scan);
				
				break;
			case 3 :
				
				break;
			case 4 :iPoker.IndianPokerRulePrint();
				
				break;
			case 5 : ;
				break;
			case 6 : 
				break;
				default :
					System.out.println("잘못된 메뉴입니다.");
			}
		}while(menu != 6);
		System.out.println("프로그램 종료");
	}
	
	
	public void th() {
		th.start();
	}
	
}
