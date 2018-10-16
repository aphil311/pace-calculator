import java.util.Scanner;
public class CalcTime {
	public static void main(String[] args) {
		// Objects
		Scanner scan = new Scanner(System.in);
		// Variables
		int distance, min, sec, tempInt, distanceSel;
		int hr = 0;																				// In case not initialized
		boolean pushUnits = false, hours = false;
		final boolean METRIC = true;											// Toggles meters/miles
		int tempS, tempM;																	// Allows cycling times
		String tempStr;
		char units = 'a';
		System.out.println("-------------");
		System.out.println("| 1. 1600m  |");
		System.out.println("| 2. 3200m  |");
		System.out.println("| 3. 5000m  |");
		System.out.println("| 4. 1 Mile |");
		System.out.println("| 5. 2 Mile |");
		System.out.println("| 6. 3 Mile |");
		System.out.println("| 7. Half   |");
		System.out.println("| 8. Full   |");
		System.out.println("| 9. Custom |");
		System.out.println("-------------");
		System.out.print("Selection: ");
		distanceSel =  scan.nextInt();
		// Custom distance
		if(distanceSel == 9){
			pushUnits = true;
			// Menu
			System.out.println("-------------");
			System.out.println("| 1. Meters |");
			System.out.println("| 2. Miles  |");
			System.out.println("-------------");
			System.out.print("Selection");
			tempInt = scan.nextInt();
			if(tempInt == 1){
				units = 'e';
			}
			else if(tempInt == 2){
				units = 'i';
			}
			else{
				// Error Catching
				while((tempInt!=1)&&(tempInt!=2)){
					System.out.println("Please select either 1 or 2.");
					System.out.print("Selection: ");
					tempInt = scan.nextInt();
				}
			}
			System.out.print("Distance: ");
			distance = scan.nextInt();
		}
		distance = Time.dSelection(distanceSel);
		tempStr = null;
		System.out.print("Time: ");
		tempStr = scan.next();
		// Seperates given time into hours, minutes, and seconds
		if(tempStr.length() == 4){
			min = Integer.parseInt(tempStr.substring(0,1));
			sec = Integer.parseInt(tempStr.substring(2,4));
		}
		else if(tempStr.length() == 5){
			min = Integer.parseInt(tempStr.substring(0,2));
			sec = Integer.parseInt(tempStr.substring(3,5));
		}
		else if(tempStr.length() == 7){
			hr = Integer.parseInt(tempStr.substring(0,1));
			min = Integer.parseInt(tempStr.substring(2,4));
			sec = Integer.parseInt(tempStr.substring(5,7));
			hours = true;
		}
		else {
			// Error Catching
			System.out.println("Not a valid time");
			min = 0;
			sec = 0;
		}
		// Object Initialization
		Time time1 = new Time(min, sec, distance);
		// If custom distance
		if(pushUnits){
			time1.pushUnits(units);
		}
		// If marathon/half marathon
		if(hours){
			time1.pushHour(hr);
		}

		// Prints
		if(METRIC){
			if(distance!=1600)
				System.out.println(time1.get1600());
			if(distance!=3200)
				System.out.println(time1.get3200());
			if(distance!=5000)
				System.out.println(time1.get5k());
			if(distance!=21082)
				System.out.println(time1.getHalf());
			if(distance!=42164)
				System.out.println(time1.getFull());
		}
		else{
			if(distance!=1609)
				System.out.println(time1.get1M());
			if(distance!=3218)
				System.out.println(time1.get2M());
			if(distance!=4828)
				System.out.println(time1.get3M());
			if(distance!=21082)
				System.out.println(time1.getHalf());
			if(distance!=42164)
				System.out.println(time1.getFull());
		}
	}
}
