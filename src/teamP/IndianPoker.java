package teamP;

import java.util.ArrayList;
import java.util.Scanner;

public class IndianPoker {
   Scanner scan = new Scanner(System.in);
   
   		private PlayerBanker banker = new PlayerBanker();
   		private PlayerBanker player = new PlayerBanker();
   		private CardDeck cd = new CardDeck(1);
   		private ArrayList<Card> list = new ArrayList<Card>();
      private int[] user1Card = {1,2,3,4,5,6,7,8,9,10}; //컴퓨터 
      private int[] user2Card = {1,2,3,4,5,6,7,8,9,10}; //사용자
      
      //컴퓨터와 사용자의 보유코인
      private int user1Coin = 20; //컴퓨터 코인
      private int user2Coin = 20; //사용자 코인
      
      // 베팅 코인 초기화
      private int user1BettingCoin = 0;
      private int user2BettingCoin = 0;
      
      public IndianPoker() {}
      
      
      // 룰설명
      public void IndianPokerRulePrint() {
         
             System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
             System.out.println("                            ========Indian Poker Game rule========");      
             System.out.println("     1. 카드는 1~10까지 숫자가 적힌 카드 2세트가 있습니다.(한 번 사용된 카드는 버려집니다.)");      
             System.out.println("     2. 한 라운드에 카드 하나 씩 PC와 플레이어에게 랜덤으로 배정됩니다.(총 10라운드)");
             System.out.println("     3. 플레이어는 PC의 카드를 보고 베팅 여부를 결정하며 본인의 카드는 알 수 없습니다.");
             System.out.println("     4. 베팅은 1개부터 최대 소유하고 있는 코인 -1개까지 가능합니다.");
             System.out.println("     5. 최초 베팅 포기할 경우 코인 1개가 소멸됩니다.(게임 진행 중 베팅을 포기하면 베팅한 코인은 모두 상대 플레이어가 가져갑니다.)");
             System.out.println("     6. 상대 플레이어보다 많은 코인을 베팅해야 베팅이 계속 진행되며, 동일한 코인을 베팅하면 카드 확인 후 승패를 결정합니다.");
             System.out.println("     7. 플레이어의 카드가 더 높을 경우 승리하며, 낮을 경우 베팅한 코인은 상대 플레이어가 가져갑니다.");
             System.out.println("     8. 코인이 모두 소진되면 패배, 10라운드까지 게임이 진행되었을 때 더 많은 코인을 소지한 플레이어가 우승합니다. ");
             System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
             
             IndianPokerStart();
             
      }
      
      // 카드 뒷장 가져오기
      public void secretCard() {
        CardPrint cp1 = new CardPrint();
        cp1.deckAdd('B', 0);
        System.out.println();
        cp1.cardPrint(cp1.printDeck());
      }
      // 게임시작
      public void draw() {
    	  Card comC = cd.pick();
    	  banker.addCard(comC);
    	  Card userC = cd.pick();
    	  player.addCard(userC);
    	  list.add(comC);
    	  list.add(userC);
      }
      
      public void showMyDeck(ArrayList<Card> list) {
  		CardPrint cp1 = new CardPrint();
  		for(int i=0; i<list.size(); i++) {
  			cp1.deckAdd(list.get(i).getShape(), list.get(i).getNum());
  		}
  		for(int i=0; i<list.size(); i++) {
  			if(i>=10) {
  				System.out.print("    ["+(i+1)+"]     ");
  			} else {
  				System.out.print("     ["+(i+1)+"]      ");
  			}
  		}
  		System.out.println();
  		cp1.cardPrint(cp1.printDeck());

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
  		//secretCard();
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
      public void showGamingMyDeckP() {
    	  CardPrint cp = new CardPrint();
    		cp.oneCardPrint();
    	}
      
      public void betting() {
    	  
      }
      
      public void match() {
    	  if(list.get(0).getNum()
    			  -list.get(1).getNum()==0) {
    		  System.out.println("무승부");
    	  }else if(list.get(0).getNum()
    			  -list.get(1).getNum()>0) {
    		  System.out.println("플레이어 승리");
    	  }else {
    		  System.out.println("플레이어 패배");
    	  }
      }
      
      public void IndianPokerStart() {
    	  list.clear();
    	  cd.initip();
    	  cd.shuffleip();
//    	  draw();
//    	  showMyDeckB();
    	  //match();
    	  //showMyDeck(list);
    	  
    	 //secretCard();
         System.out.println("게임을 시작하시겠습니까?(1.시작 / 2.종료)");
         int ready = scan.nextInt();
         int gameCount = 10; //게임 횟수
          
          while(ready <= gameCount) {
             
             //담은 카드 초기화
             
             int bettingCoin = 0; //베팅 코인
             
//             int user1Num = (int)(Math.random()*10) + 1; //컴퓨터 카드 배정
//             int user2Num = (int)(Math.random()*10) + 1; //사용자 카드 배정
//             
//             for(int idx : user1Card) {
//                if(idx == user1Num) {
//                   user1Card[idx-1] = 0;
//                   cp.deckAdd('♣', idx);
//                }
//             }
//
//             for(int idx : user2Card) {
//                if(idx == user2Num) {
//                   user2Card[idx-1] = 0;
//                   cp.deckAdd('♥', idx);
//                }
//             }
             System.out.println("-------------------------------------"+ready+"번째 게임 -------------------------------------");
             System.out.println("카드가 배정되었습니다.");
             System.out.println("( 컴퓨터      vs      사용자 )");
             draw();
             showMyDeckB();
             showGamingMyDeckP();
             System.out.println("기본 베팅은 코인 1개 입니다.");
             bettingCoin = bettingCoin + 2;
             user1Coin = user1Coin - 1;
             user2Coin = user2Coin - 1;
             System.out.println("베팅 코인 : "+bettingCoin+"개");
             System.out.println("컴퓨터 잔여 코인 : "+user1Coin+"개");
             System.out.println("사용자 잔여 코인 : "+user2Coin+"개");
             
             Loop1 : for(;;) {
                do {
                   //user1BattingCoin = (int)(Math.random()*5)+1; --> 컴퓨터 포기 안 나오게 하기
                   user1BettingCoin = (int)(Math.random()*5)+1;
                   if(user1BettingCoin == 0) {
                      System.out.println("게임을 포기하셨습니다. 사용자 WIN");
                      if(list.get(0).getNum() == 10) {
                         user2Coin = user2Coin + bettingCoin;
                         user1Coin = user1Coin - 10;
                         bettingCoin = 0;
                         break Loop1;
                      }else {
                         user2Coin = user2Coin + bettingCoin;
                         bettingCoin = 0;
                         break Loop1;
                      }
                      
                   }else {
                      if(user1BettingCoin > user1Coin) {
                         System.out.println("보유한 코인이 부족합니다.(잔여 코인 : "+user1Coin+")");
                      }else {
                         bettingCoin = bettingCoin + user1BettingCoin;
                         user1Coin = user1Coin - user1BettingCoin;
                         System.out.println("");
                         System.out.println("베팅 코인 : "+bettingCoin+"개");
                         System.out.println("컴퓨터 베팅 코인 : "+user1BettingCoin+"개");
                         System.out.println("컴퓨터 잔여 코인 : "+user1Coin+"개");
                         break;
                      }
                   }
                   
                }while(true);
                
                do {
                   
                   System.out.println("");
                   System.out.println("몇개의 코인을 베팅 하시겠습니까?(0.포기)");
                   
                   user2BettingCoin = scan.nextInt();
                   if(user2BettingCoin == 0) {
                   	showMyDeck(list);
                      System.out.println("게임을 포기하셨습니다. 컴퓨터 WIN");
                      if(list.get(1).getNum() == 10) {
                         user1Coin = user1Coin + bettingCoin;
                         user2Coin = user2Coin - 10;
                         bettingCoin = 0;
                         break Loop1;
                      }else {
                         user1Coin = user1Coin + bettingCoin;
                         bettingCoin = 0;
                         break Loop1;
                      }
                      
                   }else {
                      
                      if(user2BettingCoin > user2Coin) {
                         System.out.println("보유한 코인이 부족합니다.(잔여 코인 : "+user2Coin+")");
                      }else {
                         bettingCoin = bettingCoin + user2BettingCoin;
                         user2Coin = user2Coin - user2BettingCoin;
                         System.out.println("");
                         System.out.println("베팅 코인 : "+bettingCoin+"개");
                         System.out.println("사용자 베팅 코인 : "+user2BettingCoin+"개");
                         System.out.println("사용자 잔여 코인 : "+user2Coin+"개");
                         break;
                      }
                   }
                   
                }while(true);   

                if(user1BettingCoin == user2BettingCoin) {
                	match();
//                   if(list.get(0).getNum() > list.get(1).getNum()) {
//                       System.out.println("컴퓨터가 이겼습니다.");
//                      user1Coin = user1Coin + bettingCoin;
//                      bettingCoin = 0;
//                      break;
//                      
//                   }else if(list.get(0).getNum() < list.get(1).getNum()) {
//                      System.out.println("사용자가 이겼습니다.");
//                      user2Coin = user2Coin + bettingCoin;
//                      bettingCoin = 0;
//                      break;
                  // }
                }
                
             }
             
             ready++;   
          }
         
      }
 }