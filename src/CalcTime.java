import java.util.Scanner;
public class CalcTime {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int distance, min, sec, tempInt;
		String tempStr;
		System.out.println("-------------");
		System.out.println("| 1. 1600   |");
		System.out.println("| 2. 3200   |");
		System.out.println("| 3. 5000   |");
		System.out.println("| 4. Custom |");
		System.out.println("-------------");
		System.out.print("Selection: ");
		distance =  scan.nextInt();
		if(distance == 4){
			System.out.println("-------------");
			System.out.println("| 1. Meters |");
			System.out.println("| 2. Miles  |");
			System.out.println("-------------");
			tempInt = scan.nextInt();
		}
		System.out.print("Time: ");
		tempStr = scan.nextLine();
		if(tempStr.length() == 4){
			min = Integer.parseInt(tempStr.substring(1,2));
			sec = Integer.parseInt(tempStr.substring(1,2));
		}
		else if(tempStr.length() == 5){
			min = Integer.parseInt(tempStr.substring(1,2));
			sec = Integer.parseInt(tempStr.substring(1,2));
		}
		else {
			System.out.println("Not a valid time");
			min = 0;
			sec = 0;
		}

		Time time1 = new Time(min, sec, distance);
	}
	
}