import java.util.Scanner;

public class BookDemoStaticVariables{
	private static int x;
	private int y;
	
	public StaticTest(int val) {
		x = val;
		y = val;
		
	}
	
	public void print() {
		System.out.println(x + " " + y)}
	
	public static int getX() {
		return x;
	}
	public static void main(String[] args){
		StaticTest s1 = new StaticTest(1);
		s1.print();  //prints "1 1"
		
		StaticTest s2 = new StaticTest(2);
		s2.print();
		s1.print();
		}
	}
	
	
	