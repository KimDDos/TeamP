package teamP;

import java.util.Scanner;

public class Game {
	private TexasHoldem th = new TexasHoldem();

	public void mainConsole(Scanner scan) {
		int menu = 0;
		
		do {
			System.out.println("----GAME----");
			System.out.println("1. 텍사스 홀덤");
			System.out.println("2. 이런거");
			System.out.println("3. 저런거");
			System.out.println("4. 추가");
			System.out.println("5. 예정");
			System.out.println("6. 종료");
			System.out.print("> 번호입력 : ");
			menu = scan.nextInt();
			
			switch(menu){
			case 1 :
				th();
				break;
			case 2 :
				
				break;
			case 3 :
				
				break;
			case 4 :
				
				break;
			case 5 :
				
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
