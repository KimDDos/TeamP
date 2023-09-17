package teamP;

import java.util.ArrayList;
import java.util.List;

import 정의서.Deck;

public class CardPrint {
	StringBuffer str = new StringBuffer();
	String cardNum = "";
	List<String> deckPrint = new ArrayList<>();
	String[] cardNumArr = new String[0];
	String[] card1 = new String[55];
	String[] card2 = new String[55];
	String[] card3 = new String[55];
	String[] card4 = new String[55];
	String[] card5 = new String[55];
	String[] card6 = new String[55];
	String[] card7 = new String[55];
	String[] card8 = new String[55];
	String[] card9 = new String[55];
	int i;
	CardDeck cd = new CardDeck();
	
	public CardPrint() {}
	
	public void cardPrint(String str2) { 
		for (i = 1; i <= 54; ++i) {
			card1[i] = "┏━━━━━━━━━━━┓";
		}
		
		for (i = 1; i <= 54; ++i) {
			card9[i] = "┗━━━━━━━━━━━┛";
		}
		
		card2[1] = "┃ A         ┃";
		card3[1] = "┃           ┃";
		card4[1] = "┃           ┃";
		card5[1] = "┃     ♥     ┃";
		card6[1] = "┃           ┃";
		card7[1] = "┃           ┃";
		card8[1] = "┃         A ┃";
		card2[2] = "┃ 2         ┃";
		card3[2] = "┃           ┃";
		card4[2] = "┃     ♥     ┃";
		card5[2] = "┃           ┃";
		card6[2] = "┃     ♥     ┃";
		card7[2] = "┃           ┃";
		card8[2] = "┃         2 ┃";
		card2[3] = "┃ 3         ┃";
		card3[3] = "┃     ♥     ┃";
		card4[3] = "┃           ┃";
		card5[3] = "┃     ♥     ┃";
		card6[3] = "┃           ┃";
		card7[3] = "┃     ♥     ┃";
		card8[3] = "┃         3 ┃";
		card2[4] = "┃ 4         ┃";
		card3[4] = "┃           ┃";
		card4[4] = "┃   ♥   ♥   ┃";
		card5[4] = "┃           ┃";
		card6[4] = "┃   ♥   ♥   ┃";
		card7[4] = "┃           ┃";
		card8[4] = "┃         4 ┃";
		card2[5] = "┃ 5         ┃";
		card3[5] = "┃           ┃";
		card4[5] = "┃   ♥   ♥   ┃";
		card5[5] = "┃     ♥     ┃";
		card6[5] = "┃   ♥   ♥   ┃";
		card7[5] = "┃           ┃";
		card8[5] = "┃         5 ┃";
		card2[6] = "┃ 6         ┃";
		card3[6] = "┃   ♥   ♥   ┃";
		card4[6] = "┃           ┃";
		card5[6] = "┃   ♥   ♥   ┃";
		card6[6] = "┃           ┃";
		card7[6] = "┃   ♥   ♥   ┃";
		card8[6] = "┃         6 ┃";
		card2[7] = "┃ 7         ┃";
		card3[7] = "┃   ♥   ♥   ┃";
		card4[7] = "┃     ♥     ┃";
		card5[7] = "┃   ♥   ♥   ┃";
		card6[7] = "┃           ┃";
		card7[7] = "┃   ♥   ♥   ┃";
		card8[7] = "┃         7 ┃";
		card2[8] = "┃ 8         ┃";
		card3[8] = "┃   ♥   ♥   ┃";
		card4[8] = "┃     ♥     ┃";
		card5[8] = "┃   ♥   ♥   ┃";
		card6[8] = "┃     ♥     ┃";
		card7[8] = "┃   ♥   ♥   ┃";
		card8[8] = "┃         8 ┃";
		card2[9] = "┃ 9         ┃";
		card3[9] = "┃   ♥   ♥   ┃";
		card4[9] = "┃     ♥     ┃";
		card5[9] = "┃   ♥ ♥ ♥   ┃";
		card6[9] = "┃     ♥     ┃";
		card7[9] = "┃   ♥   ♥   ┃";
		card8[9] = "┃         9 ┃";
		card2[10] = "┃ 10        ┃";
		card3[10] = "┃   ♥   ♥   ┃";
		card4[10] = "┃   ♥   ♥   ┃";
		card5[10] = "┃   ♥   ♥   ┃";
		card6[10] = "┃   ♥   ♥   ┃";
		card7[10] = "┃   ♥   ♥   ┃";
		card8[10] = "┃        10 ┃";
		card2[11] = "┃ J         ┃";
		card3[11] = "┃           ┃";
		card4[11] = "┃           ┃";
		card5[11] = "┃     ♥     ┃";
		card6[11] = "┃           ┃";
		card7[11] = "┃           ┃";
		card8[11] = "┃         J ┃";
		card2[12] = "┃ Q         ┃";
		card3[12] = "┃           ┃";
		card4[12] = "┃           ┃";
		card5[12] = "┃     ♥     ┃";
		card6[12] = "┃           ┃";
		card7[12] = "┃           ┃";
		card8[12] = "┃         Q ┃";
		card2[13] = "┃ K         ┃";
		card3[13] = "┃           ┃";
		card4[13] = "┃           ┃";
		card5[13] = "┃     ♥     ┃";
		card6[13] = "┃           ┃";
		card7[13] = "┃           ┃";
		card8[13] = "┃         K ┃";
		// 하트
		card2[14] = "┃ A         ┃";
		card3[14] = "┃           ┃";
		card4[14] = "┃           ┃";
		card5[14] = "┃     ♣     ┃";
		card6[14] = "┃           ┃";
		card7[14] = "┃           ┃";
		card8[14] = "┃         A ┃";
		card2[15] = "┃ 2         ┃";
		card3[15] = "┃           ┃";
		card4[15] = "┃     ♣     ┃";
		card5[15] = "┃           ┃";
		card6[15] = "┃     ♣     ┃";
		card7[15] = "┃           ┃";
		card8[15] = "┃         2 ┃";
		card2[16] = "┃ 3         ┃";
		card3[16] = "┃     ♣     ┃";
		card4[16] = "┃           ┃";
		card5[16] = "┃     ♣     ┃";
		card6[16] = "┃           ┃";
		card7[16] = "┃     ♣     ┃";
		card8[16] = "┃         3 ┃";
		card2[17] = "┃ 4         ┃";
		card3[17] = "┃           ┃";
		card4[17] = "┃   ♣   ♣   ┃";
		card5[17] = "┃           ┃";
		card6[17] = "┃   ♣   ♣   ┃";
		card7[17] = "┃           ┃";
		card8[17] = "┃         4 ┃";
		card2[18] = "┃ 5         ┃";
		card3[18] = "┃           ┃";
		card4[18] = "┃   ♣   ♣   ┃";
		card5[18] = "┃     ♣     ┃";
		card6[18] = "┃   ♣   ♣   ┃";
		card7[18] = "┃           ┃";
		card8[18] = "┃         5 ┃";
		card2[19] = "┃ 6         ┃";
		card3[19] = "┃   ♣   ♣   ┃";
		card4[19] = "┃           ┃";
		card5[19] = "┃   ♣   ♣   ┃";
		card6[19] = "┃           ┃";
		card7[19] = "┃   ♣   ♣   ┃";
		card8[19] = "┃         6 ┃";
		card2[20] = "┃ 7         ┃";
		card3[20] = "┃   ♣   ♣   ┃";
		card4[20] = "┃     ♣     ┃";
		card5[20] = "┃   ♣   ♣   ┃";
		card6[20] = "┃           ┃";
		card7[20] = "┃   ♣   ♣   ┃";
		card8[20] = "┃         7 ┃";
		card2[21] = "┃ 8         ┃";
		card3[21] = "┃   ♣   ♣   ┃";
		card4[21] = "┃     ♣     ┃";
		card5[21] = "┃   ♣   ♣   ┃";
		card6[21] = "┃     ♣     ┃";
		card7[21] = "┃   ♣   ♣   ┃";
		card8[21] = "┃         8 ┃";
		card2[22] = "┃ 9         ┃";
		card3[22] = "┃   ♣   ♣   ┃";
		card4[22] = "┃     ♣     ┃";
		card5[22] = "┃   ♣ ♣ ♣   ┃";
		card6[22] = "┃     ♣     ┃";
		card7[22] = "┃   ♣   ♣   ┃";
		card8[22] = "┃         9 ┃";
		card2[23] = "┃ 10        ┃";
		card3[23] = "┃   ♣   ♣   ┃";
		card4[23] = "┃   ♣   ♣   ┃";
		card5[23] = "┃   ♣   ♣   ┃";
		card6[23] = "┃   ♣   ♣   ┃";
		card7[23] = "┃   ♣   ♣   ┃";
		card8[23] = "┃        10 ┃";
		card2[24] = "┃ J         ┃";
		card3[24] = "┃           ┃";
		card4[24] = "┃           ┃";
		card5[24] = "┃     ♣     ┃";
		card6[24] = "┃           ┃";
		card7[24] = "┃           ┃";
		card8[24] = "┃         J ┃";
		card2[25] = "┃ Q         ┃";
		card3[25] = "┃           ┃";
		card4[25] = "┃           ┃";
		card5[25] = "┃     ♣     ┃";
		card6[25] = "┃           ┃";
		card7[25] = "┃           ┃";
		card8[25] = "┃         Q ┃";
		card2[26] = "┃ K         ┃";
		card3[26] = "┃           ┃";
		card4[26] = "┃           ┃";
		card5[26] = "┃     ♣     ┃";
		card6[26] = "┃           ┃";
		card7[26] = "┃           ┃";
		card8[26] = "┃         K ┃";
		// 클로버
		card2[27] = "┃ A         ┃";
		card3[27] = "┃           ┃";
		card4[27] = "┃           ┃";
		card5[27] = "┃     ♠     ┃";
		card6[27] = "┃           ┃";
		card7[27] = "┃           ┃";
		card8[27] = "┃         A ┃";
		card2[28] = "┃ 2         ┃";
		card3[28] = "┃           ┃";
		card4[28] = "┃     ♠     ┃";
		card5[28] = "┃           ┃";
		card6[28] = "┃     ♠     ┃";
		card7[28] = "┃           ┃";
		card8[28] = "┃         2 ┃";
		card2[29] = "┃ 3         ┃";
		card3[29] = "┃     ♠     ┃";
		card4[29] = "┃           ┃";
		card5[29] = "┃     ♠     ┃";
		card6[29] = "┃           ┃";
		card7[29] = "┃     ♠     ┃";
		card8[29] = "┃         3 ┃";
		card2[30] = "┃ 4         ┃";
		card3[30] = "┃           ┃";
		card4[30] = "┃   ♠   ♠   ┃";
		card5[30] = "┃           ┃";
		card6[30] = "┃   ♠   ♠   ┃";
		card7[30] = "┃           ┃";
		card8[30] = "┃         4 ┃";
		card2[31] = "┃ 5         ┃";
		card3[31] = "┃           ┃";
		card4[31] = "┃   ♠   ♠   ┃";
		card5[31] = "┃     ♠     ┃";
		card6[31] = "┃   ♠   ♠   ┃";
		card7[31] = "┃           ┃";
		card8[31] = "┃         5 ┃";
		card2[32] = "┃ 6         ┃";
		card3[32] = "┃   ♠   ♠   ┃";
		card4[32] = "┃           ┃";
		card5[32] = "┃   ♠   ♠   ┃";
		card6[32] = "┃           ┃";
		card7[32] = "┃   ♠   ♠   ┃";
		card8[32] = "┃         6 ┃";
		card2[33] = "┃ 7         ┃";
		card3[33] = "┃   ♠   ♠   ┃";
		card4[33] = "┃     ♠     ┃";
		card5[33] = "┃   ♠   ♠   ┃";
		card6[33] = "┃           ┃";
		card7[33] = "┃   ♠   ♠   ┃";
		card8[33] = "┃         7 ┃";
		card2[34] = "┃ 8         ┃";
		card3[34] = "┃   ♠   ♠   ┃";
		card4[34] = "┃     ♠     ┃";
		card5[34] = "┃   ♠   ♠   ┃";
		card6[34] = "┃     ♠     ┃";
		card7[34] = "┃   ♠   ♠   ┃";
		card8[34] = "┃         8 ┃";
		card2[35] = "┃ 9         ┃";
		card3[35] = "┃   ♠   ♠   ┃";
		card4[35] = "┃     ♠     ┃";
		card5[35] = "┃   ♠ ♠ ♠   ┃";
		card6[35] = "┃     ♠     ┃";
		card7[35] = "┃   ♠   ♠   ┃";
		card8[35] = "┃         9 ┃";
		card2[36] = "┃ 10        ┃";
		card3[36] = "┃   ♠   ♠   ┃";
		card4[36] = "┃   ♠   ♠   ┃";
		card5[36] = "┃   ♠   ♠   ┃";
		card6[36] = "┃   ♠   ♠   ┃";
		card7[36] = "┃   ♠   ♠   ┃";
		card8[36] = "┃        10 ┃";
		card2[37] = "┃ J         ┃";
		card3[37] = "┃           ┃";
		card4[37] = "┃           ┃";
		card5[37] = "┃     ♠     ┃";
		card6[37] = "┃           ┃";
		card7[37] = "┃           ┃";
		card8[37] = "┃         J ┃";
		card2[38] = "┃ Q         ┃";
		card3[38] = "┃           ┃";
		card4[38] = "┃           ┃";
		card5[38] = "┃     ♠     ┃";
		card6[38] = "┃           ┃";
		card7[38] = "┃           ┃";
		card8[38] = "┃         Q ┃";
		card2[39] = "┃ K         ┃";
		card3[39] = "┃           ┃";
		card4[39] = "┃           ┃";
		card5[39] = "┃     ♠     ┃";
		card6[39] = "┃           ┃";
		card7[39] = "┃           ┃";
		card8[39] = "┃         K ┃";
		// 스페이드
		card2[40] = "┃ A         ┃";
		card3[40] = "┃           ┃";
		card4[40] = "┃           ┃";
		card5[40] = "┃     ♦     ┃";
		card6[40] = "┃           ┃";
		card7[40] = "┃           ┃";
		card8[40] = "┃         A ┃";
		card2[41] = "┃ 2         ┃";
		card3[41] = "┃           ┃";
		card4[41] = "┃     ♦     ┃";
		card5[41] = "┃           ┃";
		card6[41] = "┃     ♦     ┃";
		card7[41] = "┃           ┃";
		card8[41] = "┃         2 ┃";
		card2[42] = "┃ 3         ┃";
		card3[42] = "┃     ♦     ┃";
		card4[42] = "┃           ┃";
		card5[42] = "┃     ♦     ┃";
		card6[42] = "┃           ┃";
		card7[42] = "┃     ♦     ┃";
		card8[42] = "┃         3 ┃";
		card2[43] = "┃ 4         ┃";
		card3[43] = "┃           ┃";
		card4[43] = "┃   ♦   ♦   ┃";
		card5[43] = "┃           ┃";
		card6[43] = "┃   ♦   ♦   ┃";
		card7[43] = "┃           ┃";
		card8[43] = "┃         4 ┃";
		card2[44] = "┃ 5         ┃";
		card3[44] = "┃           ┃";
		card4[44] = "┃   ♦   ♦   ┃";
		card5[44] = "┃     ♦     ┃";
		card6[44] = "┃   ♦   ♦   ┃";
		card7[44] = "┃           ┃";
		card8[44] = "┃         5 ┃";
		card2[45] = "┃ 6         ┃";
		card3[45] = "┃   ♦   ♦   ┃";
		card4[45] = "┃           ┃";
		card5[45] = "┃   ♦   ♦   ┃";
		card6[45] = "┃           ┃";
		card7[45] = "┃   ♦   ♦   ┃";
		card8[45] = "┃         6 ┃";
		card2[46] = "┃ 7         ┃";
		card3[46] = "┃   ♦   ♦   ┃";
		card4[46] = "┃     ♦     ┃";
		card5[46] = "┃   ♦   ♦   ┃";
		card6[46] = "┃           ┃";
		card7[46] = "┃   ♦   ♦   ┃";
		card8[46] = "┃         7 ┃";
		card2[47] = "┃ 8         ┃";
		card3[47] = "┃   ♦   ♦   ┃";
		card4[47] = "┃     ♦     ┃";
		card5[47] = "┃   ♦   ♦   ┃";
		card6[47] = "┃     ♦     ┃";
		card7[47] = "┃   ♦   ♦   ┃";
		card8[47] = "┃         8 ┃";
		card2[48] = "┃ 9         ┃";
		card3[48] = "┃   ♦   ♦   ┃";
		card4[48] = "┃     ♦     ┃";
		card5[48] = "┃   ♦ ♦ ♦   ┃";
		card6[48] = "┃     ♦     ┃";
		card7[48] = "┃   ♦   ♦   ┃";
		card8[48] = "┃         9 ┃";
		card2[49] = "┃ 10        ┃";
		card3[49] = "┃   ♦   ♦   ┃";
		card4[49] = "┃   ♦   ♦   ┃";
		card5[49] = "┃   ♦   ♦   ┃";
		card6[49] = "┃   ♦   ♦   ┃";
		card7[49] = "┃   ♦   ♦   ┃";
		card8[49] = "┃        10 ┃";
		card2[50] = "┃ J         ┃";
		card3[50] = "┃           ┃";
		card4[50] = "┃           ┃";
		card5[50] = "┃     ♦     ┃";
		card6[50] = "┃           ┃";
		card7[50] = "┃           ┃";
		card8[50] = "┃         J ┃";
		card2[51] = "┃ Q         ┃";
		card3[51] = "┃           ┃";
		card4[51] = "┃           ┃";
		card5[51] = "┃     ♦     ┃";
		card6[51] = "┃           ┃";
		card7[51] = "┃           ┃";
		card8[51] = "┃         Q ┃";
		card2[52] = "┃ K         ┃";
		card3[52] = "┃           ┃";
		card4[52] = "┃           ┃";
		card5[52] = "┃     ♦     ┃";
		card6[52] = "┃           ┃";
		card7[52] = "┃           ┃";
		card8[52] = "┃         K ┃";
		// 다이아
		card2[53] = "┃           ┃";
		card3[53] = "┃     J     ┃";
		card4[53] = "┃     O     ┃";
		card5[53] = "┃     K     ┃";
		card6[53] = "┃     E     ┃";
		card7[53] = "┃     R     ┃";
		card8[53] = "┃           ┃";
		// 조커
		card2[54] = "┃░░░░░░░░░░░┃";
		card3[54] = "┃░░░░░░░░░░░┃";
		card4[54] = "┃░░░░░░░░░░░┃";
		card5[54] = "┃░░░░░░░░░░░┃";
		card6[54] = "┃░░░░░░░░░░░┃";
		card7[54] = "┃░░░░░░░░░░░┃";
		card8[54] = "┃░░░░░░░░░░░┃";
		// 뒷면
		cardNum = str2;
		cardNumArr = cardNum.split(",");
		
		int idx;
		for (i = 0; i < cardNumArr.length; ++i) {
			idx = Integer.parseInt(cardNumArr[i]);
			str.append(card1[idx] + " ");
		}
		str.append("\n");
		
		for (i = 0; i < cardNumArr.length; ++i) {
			idx = Integer.parseInt(cardNumArr[i]);
			str.append(card2[idx] + " ");
		}
		str.append("\n");
		
		for (i = 0; i < cardNumArr.length; ++i) {
			idx = Integer.parseInt(cardNumArr[i]);
			str.append(card3[idx] + " ");
		}
		str.append("\n");
		
		for (i = 0; i < cardNumArr.length; ++i) {
			idx = Integer.parseInt(cardNumArr[i]);
			str.append(card4[idx] + " ");
		}
		str.append("\n");
		
		for (i = 0; i < cardNumArr.length; ++i) {
			idx = Integer.parseInt(cardNumArr[i]);
			str.append(card5[idx] + " ");
		}
		str.append("\n");
		
		for (i = 0; i < cardNumArr.length; ++i) {
			idx = Integer.parseInt(cardNumArr[i]);
			str.append(card6[idx] + " ");
		}
		str.append("\n");
		
		for (i = 0; i < cardNumArr.length; ++i) {
			idx = Integer.parseInt(cardNumArr[i]);
			str.append(card7[idx] + " ");
		}
		str.append("\n");
		
		for (i = 0; i < cardNumArr.length; ++i) {
			idx = Integer.parseInt(cardNumArr[i]);
			str.append(card8[idx] + " ");
		}
		str.append("\n");
		
		for (i = 0; i < cardNumArr.length; ++i) {
			idx = Integer.parseInt(cardNumArr[i]);
			str.append(card9[idx] + " ");
		}
		System.out.println(str);
	}
	
	
	
	public void deckAdd(char shape, int number){
		deckPrint.add(cardSelect(shape, number));
	}
	
	public String printDeck() {
		String printDeck = null;
		for(int i=0; i<deckPrint.size(); i++) {
			if(printDeck == null) {
				printDeck = deckPrint.get(i).toString()+",";
			} else if(i==deckPrint.size()-1) {
				printDeck += deckPrint.get(i).toString();
			} else {
				printDeck += deckPrint.get(i).toString()+",";
			}
		}
		return printDeck;
	}
	
//	public String cardbackPrint() {
//		// 54번 출력
//		cardNum = "54";
//	}
	
	public String cardSelect(char shape, int number) {
		switch (shape) {
		case '♥': 
			// 1~13
			if(number==1) {
				cardNum = "1"; 
			} else if (number==2) {
				cardNum = "2"; 
			} else if (number==3) {
				cardNum = "3"; 
			} else if (number==4) {
				cardNum = "4"; 
			} else if (number==5) {
				cardNum = "5"; 
			} else if (number==6) {
				cardNum = "6"; 
			} else if (number==7) {
				cardNum = "7"; 
			} else if (number==8) {
				cardNum = "8"; 
			} else if (number==9) {
				cardNum = "9"; 
			} else if (number==10) {
				cardNum = "10"; 
			} else if (number==11) {
				cardNum = "11"; 
			} else if (number==12) {
				cardNum = "12"; 
			} else {
				cardNum = "13"; 
			}
			break;
		case '♣': 
			// 14~26
			if(number==1) {
				cardNum = "14"; 
			} else if (number==2) {
				cardNum = "15"; 
			} else if (number==3) {
				cardNum = "16"; 
			} else if (number==4) {
				cardNum = "17"; 
			} else if (number==5) {
				cardNum = "18"; 
			} else if (number==6) {
				cardNum = "19"; 
			} else if (number==7) {
				cardNum = "20"; 
			} else if (number==8) {
				cardNum = "21"; 
			} else if (number==9) {
				cardNum = "22"; 
			} else if (number==10) {
				cardNum = "23"; 
			} else if (number==11) {
				cardNum = "24"; 
			} else if (number==12) {
				cardNum = "25"; 
			} else {
				cardNum = "26"; 
			}
			break;
		case '♠': 
			// 27~39
			if(number==1) {
				cardNum = "27"; 
			} else if (number==2) {
				cardNum = "28"; 
			} else if (number==3) {
				cardNum = "29"; 
			} else if (number==4) {
				cardNum = "30"; 
			} else if (number==5) {
				cardNum = "31"; 
			} else if (number==6) {
				cardNum = "32"; 
			} else if (number==7) {
				cardNum = "33"; 
			} else if (number==8) {
				cardNum = "34"; 
			} else if (number==9) {
				cardNum = "35"; 
			} else if (number==10) {
				cardNum = "36"; 
			} else if (number==11) {
				cardNum = "37"; 
			} else if (number==12) {
				cardNum = "38"; 
			} else {
				cardNum = "39"; 
			}
			break;
		case '◆': 
			// 40~52
			if(number==1) {
				cardNum = "40"; 
			} else if (number==2) {
				cardNum = "41"; 
			} else if (number==3) {
				cardNum = "42"; 
			} else if (number==4) {
				cardNum = "43"; 
			} else if (number==5) {
				cardNum = "44"; 
			} else if (number==6) {
				cardNum = "45"; 
			} else if (number==7) {
				cardNum = "46"; 
			} else if (number==8) {
				cardNum = "47"; 
			} else if (number==9) {
				cardNum = "48"; 
			} else if (number==10) {
				cardNum = "49"; 
			} else if (number==11) {
				cardNum = "50"; 
			} else if (number==12) {
				cardNum = "51"; 
			} else {
				cardNum = "52"; 
			}
			break;
			default: break;
		}
		return cardNum;
	}
}
