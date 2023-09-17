package teamP;

import java.util.Scanner;

public class TexasHoldem {
	private PlayerBanker player = new PlayerBanker();
	private PlayerBanker banker = new PlayerBanker();
	private PlayerBanker comm = new PlayerBanker();
	private CardDeck cd = new CardDeck();
	Scanner scan = new Scanner(System.in);
	
	public void start() {
		int fold = 1;
		clear();
		cd.init();
		cd.shuffle();
		fold = preFlop();
		if(fold==0) {System.out.println("패배"); return;}
		fold = draw3();
		if(fold==0) {System.out.println("패배"); return;}
		fold = draw1();
		if(fold==0) {System.out.println("패배"); return;}
		fold = draw1();
		if(fold==0) {System.out.println("패배"); return;}
		open();
	}
	
	public int callOrFold(Scanner scan) {
		System.out.print("폴드하려면 0번 > ");
		int i = scan.nextInt();
		if(i==0) {
			return 0;
		}
		return 1;
	}
	
	public int preFlop() {
		for(int i = 0; i<2; i++) {
			Card pc = cd.pick();
			player.addCard(pc);
			System.out.println("내 카드"+player.getCl());
			Card bc = cd.pick();
			banker.addCard(bc);
			if(i==0) {
				System.out.println("뱅커[??]");
			}else {
				System.out.println("뱅커[??, ??]");
			}
		}
		if(callOrFold(scan)==0) {
			return 0;
		}else {
			return 1;
		}
	}
	
	public int draw3() {
		for(int i = 0; i<3; i++) {
			Card cc = cd.pick();
			comm.addCard(cc);
		}
		System.out.println("커뮤니티"+comm.getCl());
		System.out.println("내 카드"+player.getCl());
		if(callOrFold(scan)==0) {
			return 0;
		}else {
			return 1;
		}
	}
	
	public int draw1() {
		Card cc = cd.pick();
		comm.addCard(cc);
		System.out.println("커뮤니티"+comm.getCl());
		System.out.println("내 카드"+player.getCl());
		if(callOrFold(scan)==0) {
			return 0;
		}else {
			return 1;
		}
	}
	
	public void clear() {
		player.getCl().clear();
		banker.getCl().clear();
		comm.getCl().clear();
	}
	
	public void open() {
		System.out.println("뱅커"+banker.getCl());
		System.out.println("커뮤니티"+comm.getCl());
		System.out.println("내 카드"+player.getCl());
	}
	
	public void match() {
		/*여기서 족보 비교 혹은 플레이어,뱅커 족보 판단만 여기서 하고 다른 메소드에서 비교
		 * 출력 결과물 예시
		 * 뱅커 - 스트레이트
		 * 플레이어 - 투 페어
		 * 뱅커 승 
		*/
	}
}
