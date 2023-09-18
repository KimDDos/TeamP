package teamP;

import java.util.Objects;

public class Card implements Comparable{

	private char shape;  //모양
	private int num; //숫자
	
	//생성자
	public Card() {
		shape = '♥';
		num = 1;
	}
	
	public Card(char shape, int num) {
		this.shape = shape;
		this.num = num;
	}

	@Override
	public String toString() {
		if(num>1&&num<=10) {
			return ""+shape+num;
		}else if(num==1) {
			return ""+shape+"A";
		}else if(num==11) {
			return ""+shape+"J";
		}else if(num==12) {
			return ""+shape+"Q";
		}else if(num==13) {
			return ""+shape+"K";
		}else {
			return "";
		}
		
	}

	//print 메서드
	public void print() {
		System.out.print(shape);
		switch(num) {
		case 11: System.out.print("J ");
			break;
		case 12: System.out.print("Q ");
			break;
		case 13: System.out.print("K ");
			break;
			default:
				System.out.print(num+" ");
		}
	}
	
	public String numPrint() {
		switch(num) {
		case 1: return "A";
		case 11: return "J";
		case 12: return "Q";
		case 13: return "K";
			default:
				return ""+num;
		}
	}

	public char getShape() {
		return shape;
	}

	public void setShape(char shape) {
		switch(shape) {
		case '♥': case '♣': case '♠': case '◆':
			this.shape = shape;
		break;
		default:
			this.shape='♥';
		}
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		if(num < 1 || num > 13) {
			this.num = 1;
		}else {
			this.num = num;			
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(num, shape);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return num == other.num && shape == other.shape;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Card card = (Card)o;
		return this.num-card.num;
	}
	
}
