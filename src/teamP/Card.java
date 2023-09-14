package teamP;

public class Card {

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
	
}
