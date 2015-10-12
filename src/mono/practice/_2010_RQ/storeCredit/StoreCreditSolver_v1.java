package mono.practice._2010_RQ.storeCredit;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class StoreCreditSolver_v1 {
	
	private Integer[] stringToIntArray(String input){
		String[] sArray= input.split("\\s");
		Integer[] intarray=new Integer[sArray.length];
		int i = 0;
		for(String s : sArray){
			int item = Integer.parseInt(s.trim());
			intarray[i++] = item;
		}
		return intarray;
	}
	
	private String solveCaseNaive(int credit, int noOfItem, Integer[] prices){
		String solution = "";
		boolean solutionFound = false;
		for(int i = 0; i < noOfItem-1 && !solutionFound; i++){
			if(prices[i] > credit){
				continue;
			}
			for(int j=i+1; j < noOfItem; j++){
				if(prices[i] + prices[j] == credit){
					solution = (i+1)+ " "+(j+1);
					solutionFound = true;
					break;
				}
			}
		}
		return solution;
	}
	
	public void solve(){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            int noOfCase = Integer.parseInt(br.readLine());
            String[] results = new String[noOfCase];
            for(int i=0; i<noOfCase; i++){
            	results[i] = solveCaseNaive(
            			Integer.parseInt(br.readLine()), 
            			Integer.parseInt(br.readLine()), 
            			stringToIntArray(br.readLine().trim())
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
		StoreCreditSolver_v1 solver = new StoreCreditSolver_v1();
		solver.solve();
	}

}
