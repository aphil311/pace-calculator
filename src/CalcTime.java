import java.util.Scanner;
public class CalcTime {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int distance, hr = 0, min, sec, tempInt, distanceSel;
		boolean pushUnits = false, hours = false;
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
		if(distanceSel == 9){
			pushUnits = true;
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
				while((tempInt!=1)&&(tempInt!=2)){
					System.out.println("Please select either 1 or 2.");
					System.out.print("Selection: ");
				}
			}
                        System.out.print("Distance: ");
                        distance = scan.nextInt();
		}
		switch(distanceSel){
			case 1:	distance = 1600;
							break;
			case 2: distance = 3200;
							break;
			case 3:	distance = 5000;
							break;
			case 4:	distance = 1609;
							break;
			case 5: distance = 3218;
							break;
			case 6: distance = 4828;
							break;
			case 7:	distance = 21082;
							break;
			case 8:	distance = 42164;
							break;
                        default:    distance = 1600;
                                                        break;
		}
		System.out.print("Time: ");
		tempStr = scan.nextLine();
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
			System.out.println("Not a valid time");
			min = 0;
			sec = 0;
		}

		Time time1 = new Time(min, sec, distance);
		if(pushUnits){
			time1.pushUnits(units);
		}
		if(hours){
			time1.pushHour(hr);
		}
	}

}
