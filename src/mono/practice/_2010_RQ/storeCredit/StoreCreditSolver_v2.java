package mono.practice._2010_RQ.storeCredit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class StoreCreditSolver_v2 {
	int credit, noOfItem;
	
	private Map<Integer, Queue<Integer>> stringToMap(String input){
		String[] sArray= input.split("\\s");
		Map<Integer, Queue<Integer>> m = new LinkedHashMap<Integer, Queue<Integer>>();
		int i = 0;
		for(String s : sArray){
			int item = Integer.parseInt(s.trim());
			if(item < this.credit){
				Queue<Integer> q = m.get(item);
				if(q == null){
					q = new LinkedList<Integer>();
					m.put(item, q);
				}
				q.add(i);
			}
			i++;
		}
		return m;
	}
	
	private String solveCase(int credit, int noOfItem, Map<Integer, Queue<Integer>> prices){
		String solution = "";
		for (Map.Entry<Integer, Queue<Integer>> entry : prices.entrySet()) {
			int val = entry.getKey();
			int index0 = entry.getValue().poll();
			
			Queue<Integer> index1 = prices.get(credit - val);
			if(index1 != null){
				solution = (index0+1)+ " "+(index1.poll()+1);
				break;
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
            	this.credit = Integer.parseInt(br.readLine());
            	this.noOfItem = Integer.parseInt(br.readLine());
            	results[i] = solveCase(
            			this.credit, 
            			this.noOfItem, 
            			stringToMap(br.readLine().trim())
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
		StoreCreditSolver_v2 solver = new StoreCreditSolver_v2();
		solver.solve();
	}
}
