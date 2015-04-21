package mono.practice.reverseWords;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReverseWordSolver {

	private String solveCaseNaive(String input){
		String solution = "";
		String[] sArray= input.split("\\s");
		int noOfItem = sArray.length;
		String[] tmpArray = new String[noOfItem];
		for(int i = 0, j = noOfItem-1; i <= j; i++, j--){
			tmpArray[i] = sArray[j];
			tmpArray[j] = sArray[i];
		}
		solution = Arrays.toString(tmpArray).replaceAll(",","");
		return solution.substring(1, solution.length()-1);
	}
	
	public void solve(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            int noOfCase = Integer.parseInt(br.readLine());
            String[] results = new String[noOfCase];
            for(int i=0; i<noOfCase; i++){
            	results[i] = solveCaseNaive(br.readLine());;
            }
            for(int i=1; i<=noOfCase; i++){
            	System.out.println("Case #"+i+": " + results[i-1]);
            }
        }catch(Exception nfe){
            System.err.println("Invalid Format!");
        }
	}
	
	public static void main(String[] args) {
		ReverseWordSolver solver = new ReverseWordSolver();
		solver.solve();
	}
}
