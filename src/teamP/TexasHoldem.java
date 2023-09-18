package teamP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class TexasHoldem {
	private PlayerBanker player = new PlayerBanker();
	private PlayerBanker banker = new PlayerBanker();
	private PlayerBanker comm = new PlayerBanker();
	private CardDeck cd = new CardDeck();
	Scanner scan = new Scanner(System.in);
	
	public void start() {
		int fold = 1;
		ArrayList<Integer> bl = new ArrayList<Integer>();
		ArrayList<Integer> pl = new ArrayList<Integer>();
		clear();
		cd.init();
		cd.shuffle();
		System.out.println("<<<<<텍사스홀덤 시작>>>>>");
		fold = preFlop();
		if(fold==0) {System.out.println("패배"); return;}
		fold = draw3();
		if(fold==0) {System.out.println("패배"); return;}
		fold = draw1();
		if(fold==0) {System.out.println("패배"); return;}
		fold = draw1();
		if(fold==0) {System.out.println("패배"); return;}
		System.out.println("<<뱅커>>");
		bl = combine(banker.getCl(),comm.getCl());
		System.out.println("<<플레이어>>");
		pl = combine(player.getCl(),comm.getCl());
		match2(pl,bl);
		System.out.print("다시 하려면 아무 키 입력, 게임 종료는 0번 입력 > ");
		int i = scan.nextInt();
		if(i==0) {
			return;
		}else {
			start();
		}
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
			Card bc = cd.pick();
			banker.addCard(bc);
			Card pc = cd.pick();
			player.addCard(pc);
		}
		System.out.println("뱅커[??, ??]");
		System.out.println("<<플레이어>>");
		showMyDeckP();
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
		System.out.println("<<커뮤니티>>");
		showMyDeck(comm.getCl());
		System.out.println("<<플레이어>>");
		showMyDeck(player.getCl());
		if(callOrFold(scan)==0) {
			return 0;
		}else {
			return 1;
		}
	}
	
	public int draw1() {
		Card cc = cd.pick();
		comm.addCard(cc);
		System.out.println("<<커뮤니티>>");
		showMyDeck(comm.getCl());
		System.out.println("<<플레이어>>");
		showMyDeck(player.getCl());
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
	
	public void showMyDeck(ArrayList<Card> list) {
		CardPrint cp = new CardPrint();
		for(int i=0; i<list.size(); i++) {
			cp.deckAdd(list.get(i).getShape(), list.get(i).getNum());
		}
		for(int i=0; i<list.size(); i++) {
			if(i>=10) {
				System.out.print("    ["+(i+1)+"]     ");
			} else {
				System.out.print("     ["+(i+1)+"]      ");
			}
		}
		System.out.println();
		cp.cardPrint(cp.printDeck());
	}
	
	public void showMyDeckP() {
		CardPrint cp = new CardPrint();
		for(int i=0; i<player.getCl().size(); i++) {
			cp.deckAdd(player.getCl().get(i).getShape(), player.getCl().get(i).getNum());
		}
		for(int i=0; i<player.getCl().size(); i++) {
			if(i>=10) {
				System.out.print("    ["+(i+1)+"]     ");
			} else {
				System.out.print("     ["+(i+1)+"]      ");
			}
		}
		System.out.println();
		cp.cardPrint(cp.printDeck());
	}
	
	public void showMyDeckB() {
		CardPrint cp = new CardPrint();
		for(int i=0; i<banker.getCl().size(); i++) {
			cp.deckAdd(banker.getCl().get(i).getShape(), banker.getCl().get(i).getNum());
		}
		for(int i=0; i<banker.getCl().size(); i++) {
			if(i>=10) {
				System.out.print("    ["+(i+1)+"]     ");
			} else {
				System.out.print("     ["+(i+1)+"]      ");
			}
		}
		System.out.println();
		cp.cardPrint(cp.printDeck());
	}
	
	public void open() {
		System.out.println("뱅커"+banker.getCl());
		System.out.println("커뮤니티"+comm.getCl());
		System.out.println("내 카드"+player.getCl());
	}
	
	public ArrayList<Integer> combine(ArrayList<Card> pb, ArrayList<Card> comm) {
		ArrayList<Card> total = new ArrayList<Card>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i<pb.size(); i++) {
			total.add(pb.get(i));
		}
		for(int j = 0; j<comm.size(); j++) {
			total.add(comm.get(j));
		}
		list = match(total);
		return list;
	}
	
	public ArrayList<Integer> match(ArrayList<Card> total) {
		ArrayList<Card> five = new ArrayList<Card>();
		ArrayList<Card> flushD = new ArrayList<Card>();
		ArrayList<Card> stD = new ArrayList<Card>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		Collections.sort(total);
		int pair = 0;
		boolean fullhouse = false;
		boolean fourcard = false;
		boolean straight = false;
		boolean triple = false;
		boolean flush = false;
		for(int i = 0; i<total.size()-1; i++) {
			int sameSp = 0;
			if(total.get(i).getNum()-total.get(i+1).getNum()==0) {
				pair++;
				if(five.size()>0&&five.get(five.size()-1)==total.get(i)) {
					five.remove(five.size()-1);
				}
				five.add(total.get(i));
				five.add(total.get(i+1));
				if(i<5 && total.get(i+1).getNum()-total.get(i+2).getNum()==0) {
					triple = true;
					if(i<4 && total.get(i+2).getNum()-total.get(i+3).getNum()==0) {
						fourcard = true;
						triple = false;
					}
				}
			}
			if(triple && pair>=3) {
				fullhouse = true;
			}
			if(total.get(i).getNum()-total.get(i+1).getNum()==-1) {
				if(stD.size()>0&&stD.get(stD.size()-1)==total.get(i)) {
					stD.remove(stD.size()-1);
				}
				stD.add(total.get(i));
				stD.add(total.get(i+1));
			}else {
				stD.clear();
			}
			if(stD.size()>=5) {
				straight=true;
			}
			for(int j = 0; j<total.size(); j++) {
				if(total.get(i).getShape()==total.get(j).getShape()) {
					sameSp++;
					flushD.add(total.get(i));
					flushD.add(total.get(i+1));
				}
			}
			if(sameSp>=5) {
				flush=true;
			}
		}
		showMyDeck(total);
		if(flush&&straight) {
			if(stD.get(0).getNum()==1&&stD.get(4).getNum()==5) {
				System.out.println("백 스트레이트 플러시 !");
				list.add(9);
				list.add(stD.get(4).getNum());
				switch(stD.get(4).getShape()) {
				case '♠' :
					list.add(4);
					break;
				case '◆' :
					list.add(3);
					break;
				case '♥' :
					list.add(2);
					break;
				case '♣' :
					list.add(1);
					break;
					default :
						list.add(0);
				}
				return list;
			}else{
				System.out.println("스트레이트 플러시!");
				list.add(8);
				list.add(stD.get(stD.size()-1).getNum());
				switch(stD.get(4).getShape()) {
				case '♠' :
					list.add(4);
					break;
				case '◆' :
					list.add(3);
					break;
				case '♥' :
					list.add(2);
					break;
				case '♣' :
					list.add(1);
					break;
					default :
						list.add(0);
				}
				return list;
			}
		}else if(fourcard) {
			for(int i = 0; i<five.size()-3; i++) {
				if(five.get(i).getNum()==five.get(i+1).getNum()
						&&five.get(i+1).getNum()==five.get(i+2).getNum()
						&&five.get(i+2).getNum()==five.get(i+3).getNum()) {
					System.out.println(five.get(i).numPrint()+" 포카드");
					list.add(8);
					list.add(five.get(i).getNum());
					return list;
				}
			}
		}else if(fullhouse) {
			list.add(6);
			for(int i = 0; i<five.size()-3; i++) {
				if(five.get(i).getNum()==five.get(i+1).getNum()
						&&five.get(i+1).getNum()==five.get(i+2).getNum()) {
					System.out.print(five.get(i).numPrint()+" ");
					list.add(five.get(i).getNum());
					five.remove(i);
					five.remove(i+1);
					five.remove(i+2);
					System.out.println(five.get(five.size()-1).numPrint()+" ");
					list.add(five.get(five.size()-1).getNum());
					
				}
			}
			System.out.println("풀하우스");
			return list;
		}else if(flush) {
			System.out.println(flushD.get(flushD.size()-1)+" 플러시");
			list.add(5);
			list.add(flushD.get(flushD.size()-1).getNum());
			switch(flushD.get(flushD.size()-1).getShape()) {
			case '♠' :
				list.add(4);
				break;
			case '◆' :
				list.add(3);
				break;
			case '♥' :
				list.add(2);
				break;
			case '♣' :
				list.add(1);
				break;
				default :
					list.add(0);
			}
			return list;
		}else if(straight) {
				System.out.println(stD.get(stD.size()-1).numPrint()+" 스트레이트");
				list.add(4);
				list.add(stD.get(stD.size()-1).getNum());
				list.add(stD.get(stD.size()-2).getNum());
				list.add(stD.get(stD.size()-3).getNum());
				return list;
		}else if(triple) {
			list.add(3);
			for(int i = 0; i<five.size()-2; i++) {
				if(five.get(i).getNum()==five.get(i+1).getNum()
						&&five.get(i+1).getNum()==five.get(i+2).getNum()) {
					System.out.println(five.get(i).numPrint()+" 트리플");
					list.add(five.get(i).getNum());
					list.add(five.get(i+1).getNum());
					list.add(five.get(i+2).getNum());
					return list;
				}
			}
		}else if(pair>=2){
			System.out.println(""+five.get(five.size()-1).numPrint()+" "+five.get(five.size()-3).numPrint()+" 투페어");
			list.add(2);
			list.add(five.get(five.size()-1).getNum());
			list.add(five.get(five.size()-3).getNum());
			return list;
		}else if(pair==1) {
			System.out.println(five.get(five.size()-1).numPrint()+" 원페어");
			if(five.get(0).getNum()==1) {
				list.add(1);
			}else {
				list.add(0);
			}
			list.add(five.get(five.size()-1).getNum());
			return list;
		}else {
			if(total.get(0).getNum()==1) {
				System.out.println("A 탑");
				list.add(-1);
				return list;
			}else {
				System.out.println(total.get(total.size()-1).numPrint()+" 탑");
				list.add(-2);
				list.add(total.get(total.size()-1).getNum());
				return list;
			}
		}
		return list;
	}
	
	public void match2(ArrayList<Integer> pl, ArrayList<Integer> bl) {
		if(pl.get(0)>bl.get(0)) {
			System.out.println("플레이어 승");
		}else if(pl.get(0)<bl.get(0)) {
			System.out.println("뱅커 승");
		}else if(pl.get(0)<1&&pl.get(0)==pl.get(0)) {
			System.out.println("무승부");
		}else {
			if(pl.get(1)>bl.get(1)) {
				System.out.println("플레이어 승");
			}else if(pl.get(1)<bl.get(1)) {
				System.out.println("뱅커 승");
			}else {
				if(pl.get(2)>bl.get(2)) {
					System.out.println("플레이어 승");
				}else if(pl.get(2)<bl.get(2)) {
					System.out.println("뱅커 승");
				}else if(pl.get(0)==2&&pl.get(2)==bl.get(2)){
					System.out.println("무승부");
				}else {
					if(pl.get(3)>bl.get(3)) {
						System.out.println("플레이어 승");
					}else if(pl.get(3)<bl.get(3)) {
						System.out.println("뱅커 승");
					}else {
						System.out.println("무승부");
					}
				}
			}
		}
		
	}
}
