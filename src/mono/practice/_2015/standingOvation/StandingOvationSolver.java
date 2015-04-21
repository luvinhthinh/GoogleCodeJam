package mono.practice._2015.standingOvation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StandingOvationSolver {
	private Integer[] stringToIntArray(String input){
		int len = input.length();
		Integer[] intarray=new Integer[len];

		for(int i=0; i < len; i++){
			intarray[i] = Integer.parseInt(""+input.charAt(i));
		}
		
		return intarray;
	}
	
	private int solveCaseNaive(int max, Integer[] people){
		if(max==0)
			return 0;
		
		int friends = 0;
		int len = people.length;
		int total=0, needed=0;
		
		for(int i = 0; i < len; i++){
			needed = i;
			if(people[i] > 0){
				if(total >= needed){
					total = total + people[i];
				}else{
					friends = friends + (needed-total);
					total = total + people[i] + (needed-total);
				}
			}
		}
	
		return friends;
	}
	
	public void solve(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            int noOfCase = Integer.parseInt(br.readLine());
            Integer[] results = new Integer[noOfCase];
            for(int i=0; i<noOfCase; i++){
            	String testInput = br.readLine();
            	String[] tokens = testInput.split(" ");
            	results[i] = solveCaseNaive(
            			Integer.parseInt(tokens[0]), 
            			stringToIntArray(tokens[1])
            			);
            }
            for(int i=1; i<=noOfCase; i++){
            	System.out.println("Case #"+i+": " + results[i-1]);
            }
        }catch(Exception nfe){
            System.err.println("Invalid Format!");
        }
	}
	
	
	public static void main(String[] args) {
		StandingOvationSolver solver = new StandingOvationSolver();
		solver.solve();
	}
}
