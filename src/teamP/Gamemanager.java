package teamP;

import java.util.Scanner;

public class Gamemanager {
	private TexasHoldem th = new TexasHoldem();
	private SevenPoker sf = new SevenPoker();
	private IndianPoker iPoker = new IndianPoker();
	private Cardjoker cj =new Cardjoker();
	private BlackJack bj = new BlackJack();

	public void mainConsole(Scanner scan) {
		int menu = 0;
		do {
			System.out.println(""
					+ "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓\r\n"
					+ "┃  ███████╗███████╗██╗     ███████╗ ██████╗████████╗     ██████╗  █████╗ ███╗   ███╗███████╗  ┃\r\n"
					+ "┃  ██╔════╝██╔════╝██║     ██╔════╝██╔════╝╚══██╔══╝    ██╔════╝ ██╔══██╗████╗ ████║██╔════╝  ┃\r\n"
					+ "┃  ███████╗█████╗  ██║     █████╗  ██║        ██║       ██║  ███╗███████║██╔████╔██║█████╗    ┃\r\n"
					+ "┃  ╚════██║██╔══╝  ██║     ██╔══╝  ██║        ██║       ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝    ┃\r\n"
					+ "┃  ███████║███████╗███████╗███████╗╚██████╗   ██║       ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗  ┃\r\n"
					+ "┃  ╚══════╝╚══════╝╚══════╝╚══════╝ ╚═════╝   ╚═╝        ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝  ┃\r\n"
					+ "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛\r\n");
			System.out.println("                                  1. 세븐포커(SevenPoker)");
			System.out.println("                                  2. 텍사스홀덤(TrxsHoldom)");
			System.out.println("                                  3. 블랙잭(BlackJack)");
			System.out.println("                                  4. 인디언포커(IndianPoker)");
			System.out.println("                                  5. 도둑잡기(Catching Joker)");
			System.out.println("                                  6. 종료");
			System.out.print("                                         > 번호입력 : ");
			menu = scan.nextInt();
			
			switch(menu){
			case 1 : sf.sevenPokerStart(scan); break;
			case 2 : th.start(); break;
			case 3 : bj.blackJackStart(); break;
			case 4 : iPoker.IndianPokerRulePrint(); break;
			case 5 : cj.Cardjokerstart(scan); break;
			case 6 : break;
				default :
					System.out.println("잘못된 메뉴입니다.");
			}
		}while(menu != 6);
	}
}
