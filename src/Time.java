public class Time {
	private char units;
	private int totalTime;
	private int totalDistance;
	private int distances[] = {1600.0, 3200.0, 5000.0, 1609.0, 3218.0, 4828.0, 21082.0, 42164.0};
	public Time(int min, int sec, int distance){
		totalTime = min*60+sec;
    totalDistance = distance;
	}
  private int sixteen00(){
		double num = distances[0]/(double)totalDistance;
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
	private int thirty200(){
		double num = distances[1]/(double)totalDistance;
    return (int)(Math.pow(num, 1.06)*totalTime);
	}
	public String get3200(){
		int tempM = this.thirty200()/60;
		int tempS = this.thirty200()%60;
		if(tempS<9){
			return("3200: "+tempM+":0"+tempS);
		}
		else{
			return ("3200: "+tempM+":"+tempS);
		}
	}
	private int fiveK(){
		double num = distances[2]/(double)totalDistance;
    return (int)(Math.pow(num, 1.06)*totalTime);
	}
	public String get5k(){
		int tempS = this.fiveK()%60;
		int tempM = this.fiveK()/60;
		if(tempS<9){
			return("5000: "+tempM+":0"+tempS);
		}
		else{
			return("5000: "+tempM+":"+tempS);
		}
	}
	private int oneM(){
		double num = distances[3]/(double)totalDistance;
    return (int)(Math.pow(num, 1.06)*totalTime);
	}
	public String get1M(){
		int tempS = this.oneM()%60;
		int tempM = this.oneM()/60;
		if(tempS<9){
			return("1 Mile: "+tempM+":0"+tempS);
		}
		else{
			return("1 Mile: "+tempM+":"+tempS);
		}
	}
	private int twoM(){
		double num = distances[4]/(double)totalDistance;
    return (int)(Math.pow(num, 1.06)*totalTime);
	}
	public String get2M(){
		int tempS = this.twoM()%60;
		int tempM = this.twoM()/60;
		if(tempS<9){
			return("2 Mile: "+tempM+":0"+tempS);
		}
		else{
			return("2 Mile: "+tempM+":"+tempS);
		}
	}
	private int threeM(){
		double num = distances[5]/(double)totalDistance;
    return (int)(Math.pow(num, 1.06)*totalTime);
	}
	public String get5k(){
		int tempS = this.threeM()%60;
		int tempM = this.threeM()/60;
		if(tempS<9){
			return("3 Mile: "+tempM+":0"+tempS);
		}
		else{
			return("3 Mile: "+tempM+":"+tempS);
		}
	}
	private int halfMarathon(){
		double num = distances[6]/(double)totalDistance;
    return (int)(Math.pow(num, 1.06)*totalTime);
	}
	public String getHalf(){
		int tempS = this.halfMarathon() % 60;
    int totalMinutes = this.halfMarathon() / 60;
    int tempM = totalMinutes % 60;
    int tempH = totalMinutes / 60;
		if(tempS<9){
			if(tempM<9){
				return("13.1: "+tempH+":0"+tempM+":0"+tempS);
			}
			else{
				return("13.1: "+tempH+":"+tempM+":0"+tempS);
			}
		}
		else{
			if(tempM<9){
				return("13.1: "+tempH+":0"+tempM+":"+tempS);
			}
			else{
				return("13.1: "+tempH+":"+tempM+":"+tempS);
			}
		}
	}
	private int fullMarathon(){
		double num = distances[7]/(double)totalDistance;
    return (int)(Math.pow(num, 1.06)*totalTime);
	}
	public String getFull(){
		int tempS = this.fullMarathon() % 60;
    int totalMinutes = this.fullMarathon() / 60;
    int tempM = totalMinutes % 60;
    int tempH = totalMinutes / 60;
		if(tempS<9){
			if(tempM<9){
				return("26.2: "+tempH+":0"+tempM+":0"+tempS);
			}
			else{
				return("26.2: "+tempH+":"+tempM+":0"+tempS);
			}
		}
		else{
			if(tempM<9){
				return("26.2: "+tempH+":0"+tempM+":"+tempS);
			}
			else{
				return("26.2: "+tempH+":"+tempM+":"+tempS);
			}
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
	public static int dSelection(int selection){
		switch(selection){
			case 1:	return 1600;
			break;
			case 2: return 3200;
			break;
			case 3:	return 5000;
			break;
			case 4:	return 1609;		// One Mile
			break;
			case 5: return 3218;		// Two Mile
			break;
			case 6: return 4828;		// Three Mile
			break;
			case 7:	return 21082;		// Half Marathon
			break;
			case 8:	return 42164;		// Full Marathon
			break;
   		default:return 5000;		// Defaults to a 5k for XC season
    	break;
		}
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
