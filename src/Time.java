public class Time {
	private char units;
	private int totalTime;
	private int totalDistance;
	public Time(int min, int sec, int distance){
		totalTime = min*60+sec;
		if(distance < 4){
			if(units == 'i'){

			}
			else
				System.out.print("");
		}
	}
	public int getTime(){
		return totalTime;
	}
	public void pushUnits(char iOrE){
		// Miles = i, Meters = e;
		if((iOrE == 'i')||(iOrE =='e'))
			units = iOrE;
		else
			System.out.println("Error: Not a valid character");
	}
	public void pushHour(int hour){
		totalTime = totalTime+(hour*60*60);
	}
}
