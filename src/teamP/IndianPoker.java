package teamP;

import java.util.Scanner;

public class IndianPoker {

   CardPrint cp = new CardPrint();

   Scanner scan = new Scanner(System.in);

   private int[] comCard = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // 컴퓨터
   private int[] userCard = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }; // 사용자

   int bettingCoin = 0; // 총 베팅 코인(컴퓨터+사용자)

   // 컴퓨터와 사용자의 보유코인
   private int comCoin = 100; // 컴퓨터 코인
   private int userCoin = 100; // 사용자 코인

   // 베팅 코인 초기화
   private int comBettingCoin = 0;
   private int userBettingCoin = 0;
         
   private int comTotalBettingCoin = 0;
   private int userTotalBettingCoin = 0;

   private String drawFlag = "N";
   private String allCoin = "N";

   public IndianPoker() {
   }

   // 룰설명
   public void IndianPokerRulePrint() {
      System.out.println(
            "┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
      System.out.println("                            ========Indian Poker Game rule========");
      System.out.println("     1. 카드는 1~10까지 숫자가 적힌 카드 2세트가 있습니다.(한 번 사용된 카드는 버려집니다.)");
      System.out.println("     2. 한 라운드에 카드 하나 씩 PC와 플레이어에게 랜덤으로 배정됩니다.(총 10라운드)");
      System.out.println("     3. 플레이어는 PC의 카드를 보고 베팅 여부를 결정하며 본인의 카드는 알 수 없습니다.");
      System.out.println("     4. 최초 베팅은 1개부터 최대 소유하고 있는 코인까지 가능합니다.");
      System.out.println("     5. 최초 베팅 포기할 경우 코인 1개가 소멸됩니다.(게임 진행 중 베팅을 포기하면 베팅한 코인은 모두 상대 플레이어가 가져갑니다.)");
      System.out.println("     6. 상대 플레이어보다 많은 코인을 베팅해야 베팅이 계속 진행되며, 동일한 코인을 베팅하면 카드 확인 후 승패를 결정합니다.");
      System.out.println("     7. 플레이어의 카드가 더 높을 경우 승리하며, 낮을 경우 베팅한 코인은 상대 플레이어가 가져갑니다.");
      System.out.println("     8. 코인이 모두 소멸되면 패배, 10라운드까지 게임이 진행되었을 때 더 많은 코인을 소지한 플레이어가 우승합니다. ");
      System.out.println(
            "┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");

      IndianPokerStart();

   }


   //랜덤카드 배정 메서드
   public int ranCard(String flag) {

      int resulut = 0;
      
      if ("C".equals(flag)) {
         int comNum = (int) (Math.random() * 10) + 1; // 컴퓨터 카드 배정
         for (int idx : comCard) {
            if (idx == comNum) { //랜덤으로 부여받은 카드 번호가 해당 카드 배열안에 있으면 해당 카드번호 리턴, 배열안에 없으면 0 리턴
               resulut = comNum;
            }
         }
      }

      if ("U".equals(flag)) {
         int userNum = (int) (Math.random() * 10) + 1; // 사용자 카드 배정
         for (int idx : userCard) {
            if (idx == userNum) {
               resulut = userNum;
            }
         }
      }

      return resulut;
   }

   // 게임시작
   public void IndianPokerStart() {
      System.out.println("게임을 시작하시겠습니까?(1.시작 / 2.종료)");
      int ready = scan.nextInt();
      int gameCount = 10; // 게임 횟수

      if (ready != 1 && ready != 2) {
         System.out.println("잘못된 입력입니다. 다시 입력해주세요.\n");
         IndianPokerStart();
      } else if (ready == 2) {
         System.out.println("게임을 종료합니다.");
      } else {
         while (ready <= gameCount) {

            //if (comCoin == 0) {
               //System.out.println("컴퓨터가 코인을 모두 소진하였습니다.\n최종 우승은 사용자 입니다.\n");
               //break;
            //} else if (userCoin == 0) {
               //System.out.println("사용자가 코인을 모두 소진하였습니다.\n최종 우승은 컴퓨터 입니다.\n");
               //break;
            //}

            // 담은 카드 초기화
            cp.deckPrint.clear();
            cp.str.setLength(0);

            if ("N".equals(drawFlag)) {
               bettingCoin = 0; // 베팅 코인

               // 새로운 게임 시작 시 이전 게임의 베팅 코인 초기화
               comTotalBettingCoin = 1;
               userTotalBettingCoin = 1;
            }

            int comNum = ranCard("C"); // 컴퓨터 카드 배정
            int userNum = ranCard("U"); // 사용자 카드 배정

            for (;;) {
               if (comNum == 0) {
                  comNum = ranCard("C");
               } else {
                  comCard[comNum - 1] = 0; //컴퓨터 넘버가 카드 배열에 안에 있으면 해당 값을 0으로 초기화
                  cp.deckAdd('♣', comNum);
                  break;
               }
            }

            for (;;) {
               if (userNum == 0) {
                  userNum = ranCard("U");
               } else {
                  userCard[userNum - 1] = 0; //사용자 넘버가 카드 배열에 안에 있으면 해당 값을 0으로 초기화
                  cp.deckAdd('B', 0); //사용자는 무조건 뒷면카드(모양만)
                  break;
               }
            }

            System.out.println("━━━━━━━━━━" + ready + "round ━━━━━━━━━━");
            
            System.out.println("카드가 배정되었습니다.");
            System.out.println("  < 컴퓨터 >  vs  < 사용자 >");
            cp.cardPrint(cp.printDeck());

            System.out.println("기본 베팅은 코인 1개 입니다.");
            bettingCoin = bettingCoin + 2;
            comCoin = comCoin - 1;
            userCoin = userCoin - 1;
            System.out.println();
            System.out.println("<현재 라운드 총 베팅 코인 : " + bettingCoin + "개>");
            System.out.println();
            System.out.println("컴퓨터 잔여 코인 : " + comCoin + "개");
            System.out.println("사용자 잔여 코인 : " + userCoin + "개");

            Loop1: for (;;) { // 게임시작
               //컴퓨터 베팅 시작
               do {
                  //comBettingCoin = (int) (Math.random() * 5) + 1;//컴퓨터는 현재 포기 안 나옴(포기 0임)
                  comBettingCoin = (int) (Math.random() * 10); //-> 컴퓨터 포기 나옴
                  
                  if (comBettingCoin == 0) {

                     // 담은 카드 초기화(컴퓨터 카드와 사용자 뒷면 카드를 초기화)
                     cp.deckPrint.clear();
                     cp.str.setLength(0);

                     System.out.println("");
                     System.out.println("  < 컴퓨터 >  vs  < 사용자 >");
                     //컴퓨터 카드와 사용자 앞면 카드를 불러옴
                     cp.deckAdd('♣', comNum);
                     cp.deckAdd('♥', userNum);
                     cp.cardPrint(cp.printDeck());

                     System.out.println("\n컴퓨터가 게임을 포기했습니다. 📣 YOU WIN !!!");

                     if (comNum == 10) {
                        userCoin = userCoin + bettingCoin;
                        comCoin = comCoin - 10;
                        bettingCoin = 0;
                        drawFlag = "N"; //무승부 아님(ex. 무승부는 플래그 값이 Y)
                        break Loop1; //해당 게임 종료
                     } else {
                        userCoin = userCoin + bettingCoin;
                        bettingCoin = 0;
                        drawFlag = "N";
                        break Loop1; //해당 게임 종료
                     }

                  } else {
                     if (comBettingCoin > comCoin) { //컴퓨터가 베팅한 코인 > 컴퓨터의 총 보유 코인
                        System.out.println("보유한 코인이 부족합니다.(잔여 코인 : " + comCoin + ")");
                     } else { 
                        if(userTotalBettingCoin > comBettingCoin){
                                                      
                                }else{
                              bettingCoin = bettingCoin + comBettingCoin;
                              comCoin = comCoin - comBettingCoin;
                              comTotalBettingCoin = comTotalBettingCoin + comBettingCoin;
                              System.out.println("");
                            System.out.println();
                            System.out.println("<현재 라운드 총 베팅 코인 : " + bettingCoin + "개>");
                            System.out.println();
                              System.out.println("컴퓨터 베팅 코인 : "+comBettingCoin+"개");
                              System.out.println("컴퓨터 총 베팅 코인 : "+comTotalBettingCoin+"개");
                              System.out.println("컴퓨터 잔여 코인 : "+comCoin+"개");
                              break;
                                }
                     }
                  }
               } while(true);                               
                   
               //컴퓨터 베팅 종료
               if ((comTotalBettingCoin == userTotalBettingCoin) || "Y".equals(allCoin)) {

                  // 담은 카드 초기화
                  cp.deckPrint.clear();
                  cp.str.setLength(0);

                  System.out.println("");
                  System.out.println("  < 컴퓨터 >  vs  < 사용자 >");
                  cp.deckAdd('♣', comNum);
                  cp.deckAdd('♥', userNum);
                  cp.cardPrint(cp.printDeck());

                  if (comNum > userNum) {
                     System.out.println("\n 📣 YOU LOSE...");
                     comCoin = comCoin + bettingCoin;
                     bettingCoin = 0;
                     drawFlag = "N";
                     break; //게임 종료 LOOP1

                  } else if (comNum < userNum) {
                     System.out.println("\n 📣 YOU WIN !!!");
                     userCoin = userCoin + bettingCoin;
                     bettingCoin = 0;
                     drawFlag = "N";
                     break; //게임 종료 LOOP1
                  } else {
                     System.out.println("\n 📣 DRAW");
                     drawFlag = "Y"; //카드 숫자가 같아서 무승부일 때 => 베팅했던 코인은 다음 판에 이어서 사용됨
                     break; //게임 종료 LOOP1
                  }
               }
               
               //사용자 베팅 시작
               do {
                  
                  System.out.println("");
                  System.out.println("몇개의 코인을 베팅 하시겠습니까?(0.포기)");

                  userBettingCoin = scan.nextInt();
                  
                  if (userBettingCoin == 0) {
                     // 담은 카드 초기화
                     cp.deckPrint.clear();
                     cp.str.setLength(0);

                     System.out.println("");
                     System.out.println("  < 컴퓨터 >  vs  < 사용자 >");
                     cp.deckAdd('♣', comNum);
                     cp.deckAdd('♥', userNum);
                     cp.cardPrint(cp.printDeck());

                     System.out.println("\n사용자가 게임을 포기했습니다. 📣 YOU LOSE...");

                     if (userNum == 10) {
                        comCoin = comCoin + bettingCoin+10;
                        userCoin = userCoin - 10;
                        bettingCoin = 0;
                        drawFlag = "N";
                        break Loop1;
                     } else {
                        comCoin = comCoin + bettingCoin;
                        bettingCoin = 0;
                        drawFlag = "N";
                        break Loop1;
                     }

                  } else {

                     if (userBettingCoin > userCoin) {
                        System.out.println("보유한 코인이 부족합니다.(잔여 코인 : " + userCoin + ")");
                     } else {
                        bettingCoin = bettingCoin + userBettingCoin;
                        userCoin = userCoin - userBettingCoin;
                        userTotalBettingCoin = userTotalBettingCoin + userBettingCoin;
                        System.out.println("");
                        System.out.println("<현재 라운드 총 베팅 코인 : " + bettingCoin + "개>");
                        System.out.println("사용자 베팅 코인 : " + userBettingCoin + "개");
                        System.out.println("사용자 총 베팅 코인 : " + userTotalBettingCoin + "개");
                        System.out.println("사용자 잔여 코인 : " + userCoin + "개");
                        
                        if(userCoin == 0) { 
                           System.out.println("사용자 코인 모두 소진");
                           allCoin = "Y";
                           break;
                        }
                        
                        break;
                     }
                  }

               } while (true);
               //사용자 베팅 종료
               
               //컴퓨터의 총 베팅 코인과 사용자의 총 베팅 코인이 같거나 컴퓨터나 사용자의 코인이 모두 소진된 경우 결과 표시
               if ((comTotalBettingCoin == userTotalBettingCoin) || "Y".equals(allCoin)) {

                  // 담은 카드 초기화
                  cp.deckPrint.clear();
                  cp.str.setLength(0);

                  System.out.println("");
                  System.out.println("  < 컴퓨터 >  vs  < 사용자 >");
                  cp.deckAdd('♣', comNum);
                  cp.deckAdd('♥', userNum);
                  cp.cardPrint(cp.printDeck());

                  if (comNum > userNum) {
                     System.out.println("\n 📣 YOU LOSE...");
                     comCoin = comCoin + bettingCoin;
                     bettingCoin = 0;
                     drawFlag = "N";
                     break; //게임 종료 LOOP1

                  } else if (comNum < userNum) {
                     System.out.println("\n 📣 YOU WIN !!!");
                     userCoin = userCoin + bettingCoin;
                     bettingCoin = 0;
                     drawFlag = "N";
                     break; //게임 종료 LOOP1
                  } else {
                     System.out.println("\n 📣 DRAW");
                     drawFlag = "Y"; //카드 숫자가 같아서 무승부일 때 => 베팅했던 코인은 다음 판에 이어서 사용됨
                     break; //게임 종료 LOOP1
                  }
               }

            }

            //마지막 10번째 게임이 끝났을 경우
            if (ready == 10) {
               System.out.println("\n게임이 모두 끝났습니다.");
               System.out.println("컴퓨터 잔여 코인 : " + comCoin + "개");
               System.out.println("사용자 잔여 코인 : " + userCoin + "개");

               if (comCoin > userCoin) {
                  System.out.println("(˃̣̣̣̣̣̣བ˂̣̣̣̣̣̣)📣 최종 우승은 컴퓨터입니다.\n");
               } else if (comCoin < userCoin) {
                  System.out.println("(~˙∇˙)~📣 최종 우승은 사용자입니다.\n");
               } else {
                  System.out.println("( ｣｡╹o╹｡)｣📣 최종결과는 무승부입니다.\n");
               }

            }

            ready++; //게임 횟수 증가
         }
      }
      System.out.println("종료하려면 0번을 눌러주세요.");
      int num=scan.nextInt();
      if(num==0) {
         return;
      }
   }   
}