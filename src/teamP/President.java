package teamP;

import java.util.Collections;
import java.util.Scanner;

public class President {
// 대부호 게임
	private PlayerBanker player = new PlayerBanker();
	private PlayerBanker comm = new PlayerBanker();
	private PlayerBanker comm2 = new PlayerBanker();
	private PlayerBanker comm3 = new PlayerBanker();
	private PlayerBanker comm4 = new PlayerBanker();
	private PlayerBanker comm5 = new PlayerBanker();
	private PlayerBanker comm6 = new PlayerBanker();
	private CardDeck cd = new CardDeck();
	private CardDeck trash = new CardDeck();
	CardPrint cp = new CardPrint();
	CardPrint cp2 = new CardPrint();
	private int members;
	private int count;
	private int dropOrPass=1;
	private int orderNumber; // playerBanker에 추가해야함
	private int rank;
	
	public President() {
		trash.getCd().clear();
	}
	
	public void presidentStart(Scanner scan) {
		gameSetting(scan);
		presidentRulePrint(scan);
		givingHandouts(this.members);
		firstCheck();
		System.out.println("대부호 게임을 시작합니다~!");
		firstGame(scan);
		
	}
	
	public void gameSetting(Scanner scan) {
		int menu = 0;
		do {
		System.out.println("게임 인원수를 지정해주세요. (2~7인)");
		menu = scan.nextInt();
		switch(menu) {
		case 2: 
			System.out.println(menu+"인이서 게임을 진행합니다.");
			break;
		case 3: 
			System.out.println(menu+"인이서 게임을 진행합니다.");
			break;
		case 4: 
			System.out.println(menu+"인이서 게임을 진행합니다.");
			break;
		case 5: 
			System.out.println(menu+"인이서 게임을 진행합니다.");
			break;
		case 6: 
			System.out.println(menu+"인이서 게임을 진행합니다.");
			break;
		case 7: 
			System.out.println(menu+"인이서 게임을 진행합니다.");
			break;
		default : System.out.println("2~7 범위에 해당하는 인원수를 입력해주세요!");
		}
		} while(!(1<menu || menu <8)); {
			System.out.println("인원수는 "+menu+"명으로 시작합니다.");
			this.members=menu;
		}
	}
	
	public void presidentRulePrint(Scanner scan) {
		int menu = 0;
		do {
		System.out.println("첫번째 게임 룰 설명");
		System.out.println("1. 게임은 다이아 3을 가진 플레이어부터 Strat ");
		System.out.println("2. Start를 제외한 다른 플레이어들은 내놓은 카드보다 강한 카드를 무조건 내야하고,");
		System.out.println("   선이 같은 숫자의 카드를 여러 장 냈을 때는 장수를 맞추어 그보다 강한 카드를 내야한다. ");
		System.out.println("   선이 2장을 냈다고 해서 3장 이상을 내는 것이 아니고 장수는 똑같이 낸다. ");
		System.out.println("3. 카드를 낼 수 없거나 내기 싫으면 패스할 수 있다. (패스의 횟수는 제한 없음)");
		System.out.println("4. 다른 플레이어 전원이 패스해서 다시 바닥에 있는 카드를 낸 플레이어까지 차례가 돌아오면 그 플레이어는 선 플레이어가 된다. 바닥에 내려놓은 카드는 치우고 선 플레이어는 가진 패에서 원하는 카드를 낼 수 있다.");
		System.out.println("5. 손패를 전부 털어낸 사람이 다음 게임의 대부호가 된다. 나머지 플레이어들은 가지고 있는 손패가 적을수록 더 높은 계급을 부여받는 것으로 계급이 확정된다.");
		System.out.println("6. 대부호, 부호, 평민, 빈민, 대빈민 계급 순으로 앉는다. 인원수에 따라 계급의 종류는 달라진다.");
		// 등등 룰 더 넣기
		System.out.println("게임을 시작하려면 아무숫자나 입력해주세요!");
		try {
			menu = scan.nextInt();
			if(menu ==1 || menu != 1) {
				menu = 1;
				break;
			}
		} catch (Exception e) {
			System.out.println("숫자만 입력해주세요.");
			continue;
		}
		} while(menu!=1);
	}
	
	public void firstGame(Scanner sc) {
		do{
			orderSettings();
			if(orderList(player)) {
				int menu = -1;
				// 앞에 컴퓨터가 낸 카드를 볼 수 있는 메서드 추가 필요
				do {
					showMyDeck();
					System.out.println("카드를 내려면 1, Pass 하려면 0");
					menu = sc.nextInt();
					if(menu==0) System.out.println("Pass~!!");
					if(menu!=0) {
						System.out.println("내고싶은 카드번호를 입력해주세요.");
						menu = sc.nextInt();
						while(true) {
							if(pedigreeChart(player.getCl().get(menu-1).getNum())) {
								trash.getCd().add(player.getCl().get(menu-1));
							} else {
								System.out.println("더 강한 카드를 내주세요!");
								System.out.println("(강함) 2-A-K-Q-J-10-9-8-7-6-5-4-3 (약함)");
								menu = sc.nextInt();
							}
							System.out.println("카드를 더 내려면 1, 턴을 종료하려면 0을 입력해주세요.");
							menu = sc.nextInt();
							if(menu==0) break;
						}
					}
				} while(menu!=0);
				System.out.println("Player 턴 종료~!");
				dropOrPass++;
				if(this.members+1==dropOrPass) {
					dropOrPass=1;
				}
			}
			comOrders();
		} while(true);
	}
	
	public void givingHandouts(int members) {
		int deckcount = cd.getCd().size();
		switch (members) {
		case 2: 
			for(int i=0; i<deckcount; i++) {
				if(i%2 == 1) {
					player.addCard(cd.pick());
				} else {
					comm.addCard(cd.pick());
				}
			}
			break;
		case 3: 
			for(int i=0; i<deckcount; i++) {
				if(i%3==1) {
					player.addCard(cd.pick());
				} else if(i%3==2) {
					comm.addCard(cd.pick());
				} else {
					comm2.addCard(cd.pick());
				}
			}
			break;
		case 4: 
			for(int i=0; i<deckcount; i++) {
				if(i%4==1) {
					player.addCard(cd.pick());
				} else if(i%4==2) {
					comm.addCard(cd.pick());
				} else if(i%4==3) {
					comm2.addCard(cd.pick());
				} else {
					comm3.addCard(cd.pick());
				}
			}
			break;
		case 5: 
			for(int i=0; i<deckcount; i++) {
				if(i%5==1) {
					player.addCard(cd.pick());
				} else if(i%5==2) {
					comm.addCard(cd.pick());
				} else if(i%5==3) {
					comm2.addCard(cd.pick());
				} else if(i%5==4) {
					comm3.addCard(cd.pick());
				} else {
					comm4.addCard(cd.pick());
				}
			}
			break;
		case 6: 
			for(int i=0; i<deckcount; i++) {
				if(i%6==1) {
					player.addCard(cd.pick());
				} else if(i%6==2) {
					comm.addCard(cd.pick());
				} else if(i%6==3) {
					comm2.addCard(cd.pick());
				} else if(i%6==4) {
					comm3.addCard(cd.pick());
				} else if(i%6==5) {
					comm4.addCard(cd.pick());
				} else {
					comm5.addCard(cd.pick());
				}
			}
			break;
		case 7: 
			for(int i=0; i<deckcount; i++) {
				if(i%7==1) {
					player.addCard(cd.pick());
				} else if(i%7==2) {
					comm.addCard(cd.pick());
				} else if(i%7==3) {
					comm2.addCard(cd.pick());
				} else if(i%7==4) {
					comm3.addCard(cd.pick());
				} else if(i%7==5) {
					comm4.addCard(cd.pick());
				} else if(i%7==6) {
					comm5.addCard(cd.pick());
				} else {
					comm6.addCard(cd.pick());
				}
			}
			break;
		}
		System.out.println("카드 분배 완료~!");
		System.out.println("--------------------------------------------------------------------------");
	}
	
	public void firstCheck() {
		switch (this.members) {
		case 2: 
			for(int i=0; i<player.getCl().size(); i++) {
				if(player.getCl().get(i).getShape() =='◆' && player.getCl().get(i).getNum()==3) {
					player.setOrderNumber(1);
					comm.setOrderNumber(2);
					break;
				} else {
					player.setOrderNumber(2);
					comm.setOrderNumber(1);
				} 
			}
		case 3: 
			for(int i=0; i<player.getCl().size(); i++) {
				if(player.getCl().get(i).getShape() =='◆' && player.getCl().get(i).getNum()==3) {
					player.setOrderNumber(1);
					comm.setOrderNumber(2);
					comm2.setOrderNumber(3);
				} 
			}
			for(int i=0; i<comm.getCl().size(); i++) {
				if (comm.getCl().get(i).getShape() == '◆' && comm.getCl().get(i).getNum() == 3) {
					player.setOrderNumber(3);
					comm.setOrderNumber(1);
					comm2.setOrderNumber(2);
				} else {
					player.setOrderNumber(2);
					comm.setOrderNumber(3);
					comm2.setOrderNumber(1);
				}
			}
			break;
		case 4: 
			for(int i=0; i<player.getCl().size(); i++) {
				if(player.getCl().get(i).getShape() =='◆' && player.getCl().get(i).getNum()==3) {
					player.setOrderNumber(1);
					comm.setOrderNumber(2);
					comm2.setOrderNumber(3);
					comm3.setOrderNumber(4);
				} 
			}
			for(int i=0; i<comm.getCl().size(); i++) {
				if (comm.getCl().get(i).getShape() == '◆' && comm.getCl().get(i).getNum() == 3) {
					player.setOrderNumber(4);
					comm.setOrderNumber(1);
					comm2.setOrderNumber(2);
					comm3.setOrderNumber(3);
				} 
			}
			for(int i=0; i<comm2.getCl().size(); i++) {
				if (comm2.getCl().get(i).getShape() == '◆' && comm2.getCl().get(i).getNum() == 3) {
					player.setOrderNumber(3);
					comm.setOrderNumber(4);
					comm2.setOrderNumber(1);
					comm3.setOrderNumber(2);
				} else {
					player.setOrderNumber(2);
					comm.setOrderNumber(3);
					comm2.setOrderNumber(4);
					comm3.setOrderNumber(1);
				}
			}
			break;
		case 5: 
			for(int i=0; i<player.getCl().size(); i++) {
				if(player.getCl().get(i).getShape() =='◆' && player.getCl().get(i).getNum()==3) {
					player.setOrderNumber(1);
					comm.setOrderNumber(2);
					comm2.setOrderNumber(3);
					comm3.setOrderNumber(4);
					comm4.setOrderNumber(5);
				} 
			}
			for(int i=0; i<comm.getCl().size(); i++) {
				if (comm.getCl().get(i).getShape() == '◆' && comm.getCl().get(i).getNum() == 3) {
					player.setOrderNumber(5);
					comm.setOrderNumber(1);
					comm2.setOrderNumber(2);
					comm3.setOrderNumber(3);
					comm4.setOrderNumber(4);
				} 
			}
			for(int i=0; i<comm2.getCl().size(); i++) {
				if (comm2.getCl().get(i).getShape() == '◆' && comm2.getCl().get(i).getNum() == 3) {
					player.setOrderNumber(4);
					comm.setOrderNumber(5);
					comm2.setOrderNumber(1);
					comm3.setOrderNumber(2);
					comm4.setOrderNumber(3);
				} 
			}
			for(int i=0; i<comm3.getCl().size(); i++) {
				if (comm3.getCl().get(i).getShape() == '◆' && comm3.getCl().get(i).getNum() == 3) {
					player.setOrderNumber(3);
					comm.setOrderNumber(4);
					comm2.setOrderNumber(5);
					comm3.setOrderNumber(1);
					comm4.setOrderNumber(2);
				} else {
					player.setOrderNumber(2);
					comm.setOrderNumber(3);
					comm2.setOrderNumber(4);
					comm3.setOrderNumber(5);
					comm4.setOrderNumber(1);
				}
			}
			break;
		case 6: 
			for(int i=0; i<player.getCl().size(); i++) {
				if(player.getCl().get(i).getShape() =='◆' && player.getCl().get(i).getNum()==3) {
					player.setOrderNumber(1);
					comm.setOrderNumber(2);
					comm2.setOrderNumber(3);
					comm3.setOrderNumber(4);
					comm4.setOrderNumber(5);
					comm5.setOrderNumber(6);
				} 
			}
			for(int i=0; i<comm.getCl().size(); i++) {
				if (comm.getCl().get(i).getShape() == '◆' && comm.getCl().get(i).getNum() == 3) {
					player.setOrderNumber(6);
					comm.setOrderNumber(1);
					comm2.setOrderNumber(2);
					comm3.setOrderNumber(3);
					comm4.setOrderNumber(4);
					comm5.setOrderNumber(5);
				} 
			}
			for(int i=0; i<comm2.getCl().size(); i++) {
				if (comm2.getCl().get(i).getShape() == '◆' && comm2.getCl().get(i).getNum() == 3) {
					player.setOrderNumber(5);
					comm.setOrderNumber(6);
					comm2.setOrderNumber(1);
					comm3.setOrderNumber(2);
					comm4.setOrderNumber(3);
					comm5.setOrderNumber(4);
				} 
			}
			for(int i=0; i<comm3.getCl().size(); i++) {
				if (comm3.getCl().get(i).getShape() == '◆' && comm3.getCl().get(i).getNum() == 3) {
					player.setOrderNumber(4);
					comm.setOrderNumber(5);
					comm2.setOrderNumber(6);
					comm3.setOrderNumber(1);
					comm4.setOrderNumber(2);
					comm5.setOrderNumber(3);
				} 
			}
			for(int i=0; i<comm4.getCl().size(); i++) {
				if (comm4.getCl().get(i).getShape() == '◆' && comm4.getCl().get(i).getNum() == 3) {
					player.setOrderNumber(3);
					comm.setOrderNumber(4);
					comm2.setOrderNumber(5);
					comm3.setOrderNumber(6);
					comm4.setOrderNumber(1);
					comm5.setOrderNumber(2);
				} else {
					player.setOrderNumber(2);
					comm.setOrderNumber(3);
					comm2.setOrderNumber(4);
					comm3.setOrderNumber(5);
					comm4.setOrderNumber(6);
					comm5.setOrderNumber(1);
				}
			}
			break;
		case 7: 
			for(int i=0; i<player.getCl().size(); i++) {
				if(player.getCl().get(i).getShape() =='◆' && player.getCl().get(i).getNum()==3) {
					player.setOrderNumber(1);
					comm.setOrderNumber(2);
					comm2.setOrderNumber(3);
					comm3.setOrderNumber(4);
					comm4.setOrderNumber(5);
					comm5.setOrderNumber(6);
					comm6.setOrderNumber(7);
				} 
			}
			for(int i=0; i<comm.getCl().size(); i++) {
				if (comm.getCl().get(i).getShape() == '◆' && comm.getCl().get(i).getNum() == 3) {
					player.setOrderNumber(7);
					comm.setOrderNumber(1);
					comm2.setOrderNumber(2);
					comm3.setOrderNumber(3);
					comm4.setOrderNumber(4);
					comm5.setOrderNumber(5);
					comm6.setOrderNumber(6);
				} 
			}
			for(int i=0; i<comm2.getCl().size(); i++) {
				if (comm2.getCl().get(i).getShape() == '◆' && comm2.getCl().get(i).getNum() == 3) {
					player.setOrderNumber(6);
					comm.setOrderNumber(7);
					comm2.setOrderNumber(1);
					comm3.setOrderNumber(2);
					comm4.setOrderNumber(3);
					comm5.setOrderNumber(4);
					comm6.setOrderNumber(5);
				} 
			}
			for(int i=0; i<comm3.getCl().size(); i++) {
				if (comm3.getCl().get(i).getShape() == '◆' && comm3.getCl().get(i).getNum() == 3) {
					player.setOrderNumber(5);
					comm.setOrderNumber(6);
					comm2.setOrderNumber(7);
					comm3.setOrderNumber(1);
					comm4.setOrderNumber(2);
					comm5.setOrderNumber(3);
					comm6.setOrderNumber(4);
				} 
			}
			for(int i=0; i<comm4.getCl().size(); i++) {
				if (comm4.getCl().get(i).getShape() == '◆' && comm4.getCl().get(i).getNum() == 3) {
					player.setOrderNumber(4);
					comm.setOrderNumber(5);
					comm2.setOrderNumber(6);
					comm3.setOrderNumber(7);
					comm4.setOrderNumber(1);
					comm5.setOrderNumber(2);
					comm6.setOrderNumber(3);
				} 
			}
			for(int i=0; i<comm5.getCl().size(); i++) {
				if (comm5.getCl().get(i).getShape() == '◆' && comm5.getCl().get(i).getNum() == 3) {
					player.setOrderNumber(3);
					comm.setOrderNumber(4);
					comm2.setOrderNumber(5);
					comm3.setOrderNumber(6);
					comm4.setOrderNumber(7);
					comm5.setOrderNumber(1);
					comm6.setOrderNumber(2);
				} else {
					player.setOrderNumber(2);
					comm.setOrderNumber(3);
					comm2.setOrderNumber(4);
					comm3.setOrderNumber(5);
					comm4.setOrderNumber(6);
					comm5.setOrderNumber(7);
					comm6.setOrderNumber(1);
				}
			}
			break;
		}
		if(player.getOrderNumber()==1) { System.out.println("우선 플레이 대상은 player입니다."); orderSetting(player);}
		if(comm.getOrderNumber()==1) System.out.println("우선 플레이 대상은 com입니다."); orderSetting(comm);
		if(comm2.getOrderNumber()==1) System.out.println("우선 플레이 대상은 com2입니다."); orderSetting(comm2);
		if(comm3.getOrderNumber()==1) System.out.println("우선 플레이 대상은 com3입니다."); orderSetting(comm3);
		if(comm4.getOrderNumber()==1) System.out.println("우선 플레이 대상은 com4입니다."); orderSetting(comm4);
		if(comm5.getOrderNumber()==1) System.out.println("우선 플레이 대상은 com5입니다."); orderSetting(comm5);
		if(comm6.getOrderNumber()==1) System.out.println("우선 플레이 대상은 com6입니다."); orderSetting(comm6);
		System.out.println("--------------------------------------------------------------------------");
	}
	
//	if(trash.getCd().get(0) != null) {
//		System.out.println("[마지막으로 제출한 카드]");
//		cp2.deckAdd(trash.getCd().get(0).getShape(), trash.getCd().get(0).getNum());
//		cp2.cardPrint(cp2.printDeck());
//	}
	
	public void showMyDeck() {
		Collections.sort(player.getCl());
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
	
	public boolean orderList(PlayerBanker name) {
			if(name.getOrderNumber()==dropOrPass) {
				return true;
			}
			return false;
	}
	
	public void comOrderList(PlayerBanker com) {
		if(com.getOrderNumber()==dropOrPass) {
			comChoice(com);
			dropOrPass++;
		}
		if(this.members+1==dropOrPass) {
			this.dropOrPass=1;
		}
	}
	
	public void comOrders() {
		switch (this.members){
		case 2: comOrderList(comm);	break;
		case 3: 
			comOrderList(comm);
			comOrderList(comm2);
			break;
		case 4: 
			comOrderList(comm);
			comOrderList(comm2);
			comOrderList(comm3);
			break;
		case 5: 
			comOrderList(comm);
			comOrderList(comm2);
			comOrderList(comm3);
			comOrderList(comm4);
			break;
		case 6: 
			comOrderList(comm);
			comOrderList(comm2);
			comOrderList(comm3);
			comOrderList(comm4);
			comOrderList(comm5);
			break;
		case 7: 
			comOrderList(comm);
			comOrderList(comm2);
			comOrderList(comm3);
			comOrderList(comm4);
			comOrderList(comm5);
			comOrderList(comm6);
			break;
		}
	}
	
	public void orderSetting(PlayerBanker com) {
		// comm5.getCl().get(i).getShape() == '◆' && comm5.getCl().get(i).getNum() == 3
		if(com.getOrderNumber()==1) {
			for(int i=0; i<com.getCl().size(); i++) {
				if(com.getCl().get(i).getShape() == '◆' && com.getCl().get(i).getNum() == 3) {
					trash.getCd().add(com.getCl().get(i));
					com.getCl().remove(i);
				}
			}
		}
	}
	
	public void orderSettings() {
		switch (this.members){
		case 2: 
			orderSetting(player);
			orderSetting(comm);
			break;
		case 3: 
			orderSetting(player);
			orderSetting(comm);
			orderSetting(comm2);
			break;
		case 4: 
			orderSetting(player);
			orderSetting(comm);
			orderSetting(comm2);
			orderSetting(comm3);
			break;
		case 5: 
			orderSetting(player);
			orderSetting(comm);
			orderSetting(comm2);
			orderSetting(comm3);
			orderSetting(comm4);
			break;
		case 6: 
			orderSetting(player);
			orderSetting(comm);
			orderSetting(comm2);
			orderSetting(comm3);
			orderSetting(comm4);
			orderSetting(comm5);
			break;
		case 7: 
			orderSetting(player);
			orderSetting(comm);
			orderSetting(comm2);
			orderSetting(comm3);
			orderSetting(comm4);
			orderSetting(comm5);
			orderSetting(comm6);
			break;
		}
	}
	
	public void comChoice(PlayerBanker com) {
		while(true) {
			int ran = (int)(Math.random()*com.getCl().size()); 
			if(pedigreeChart(com.getCl().get(ran).getNum())) {
				trash.getCd().add(com.getCl().get(ran));
				if(pedigreeChart(com.getCl().get(ran).getNum())) {
					trash.getCd().add(com.getCl().get(ran));
				}
				break;
			}
		}
	}
	
	public boolean pedigreeChart(int num) { // 족보
		// (강함) 2-A-K-Q-J-10-9-8-7-6-5-4-3 (약함)
		if(num ==2 && (trash.getCd().get(0).getNum()==1 || trash.getCd().get(0).getNum()>2)) {
			trash.getCd().remove(0);
			return true;
		}
		if (trash.getCd().get(0).getNum() == 1 && (2<num||num<14)) {
			return false;
		}
		if(num ==1) {
			if(trash.getCd().get(0).getNum() == 2) {
				return false;
			} else if(trash.getCd().get(0).getNum() == 1) {
				return false;
			} else {
				trash.getCd().remove(0);
				return true;
			}
		}
		if(num > trash.getCd().get(0).getNum()) {
			trash.getCd().remove(0);
			return true;
		}
		return false;
	}
	
//	public boolean revolrution() { // 같은 숫자가 4장일때 혁명
//		if() {
//			
	// (강함) 2-A-K-Q-J-10-9-8-7-6-5-4-3 (약함)  
	//  ->  (강함) 3-4-5-6-7-8-9-10-J-Q-K-A-2 (약함)
//		}
//	}
	
	// 2번째 게임부터 룰 적용
	
	public void rank(int rank) {
		String ranked = null;
		switch (rank) {
		case 1:  
			ranked = "대부호";
			break;
		
		
		default: break;
		}
	}
	
	
	
	public int getCount() {
		return count;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public PlayerBanker getPlayer() {
		return player;
	}

	public PlayerBanker getComm() {
		return comm;
	}

	public PlayerBanker getComm2() {
		return comm2;
	}

	public PlayerBanker getComm3() {
		return comm3;
	}

	public PlayerBanker getComm4() {
		return comm4;
	}

	public PlayerBanker getComm5() {
		return comm5;
	}

	public PlayerBanker getComm6() {
		return comm6;
	}

	@Override
	public String toString() {
		return "cd=" + cd;
	}
	
}
