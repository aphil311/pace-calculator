public class Time {
	private char units;
	private int totalTime;
	private int totalDistance;
	public Time(int min, int sec, int distance){
		totalTime = min*60+sec;
    totalDistance = distance;
	}
  private int sixteen00(){
		double num = 1600.0/(double)totalDistance;
    return (int)(Math.pow(num, 1.06)*totalTime);
	}
	public String get1600(){
		int tempM = this.sixteen00()/60;
		int tempS = this.sixteen00()%60;
		if(tempS<9){
			return("1600: "+tempM+":0"+tempS);
		}
		else{
			return ("1600: "+tempM+":"+tempS);
		}
	}
	private int fiveK(){
		double num = 5000.0/(double)totalDistance;
    return (int)(Math.pow(num, 1.06)*totalTime);
	}
	public int get5k(){
		int tempS = this.fiveK()%60;
		int tempM = this.fiveK()/60;
		if(tempS<9){
			System.out.println("5000: "+tempM+":0"+tempS);
		}
		else{
			System.out.println("5000: "+tempM+":"+tempS);
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
	public String toString(){
    int min = totalTime/60;
    int sec = totalTime%60;
    if(sec<9)
      return totalDistance+" | "+min+":0"+sec;
    else
      return totalDistance+" | "+min+":"+sec;
	}
}
