package mono.practice._2010_RQ.storeCredit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class StoreCreditSolver_v3 {
	private List<Game> games = new ArrayList<Game>();
	private List<String> results = new ArrayList<String>();
	
	public void read(){
		List<Game> games = new ArrayList<Game>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            int noOfCase = Integer.parseInt(br.readLine());
            for(int i=0; i<noOfCase; i++){
            	games.add(
            			new Game(
            					Integer.parseInt(br.readLine()), 	// Credit
            					Integer.parseInt(br.readLine()), 	// Number of items
            					br.readLine().trim().split("\\s")	// item list
            			));
            }
            this.games = games;
        }catch(Exception nfe){
            System.err.println("Invalid Format!");
        }
	}
	
	public void solve(){
		for(Game game : games){
			if(game.C == 548 && game.I == 1287)
				System.out.println(game.C + "   " + game.I);
			results.add(game.solve());
		}
	}
	
	public void printResult(){
		for(int i = 1; i <= results.size(); i++){
			System.out.println("Case #"+i+": " + results.get(i-1));
		}
	}
	
	public static void main(String[] args) {
		StoreCreditSolver_v3 solver = new StoreCreditSolver_v3();
		solver.read();
		solver.solve();
		solver.printResult();
	}
}


class Game{
	int C, I;
	String[] items_string;
	
	public Game(int C, int I, String[] items){
		this.C = C;
		this.I = I;
		this.items_string = items;
	}
	
	/**
	 * Convert a string which contains all item's prices into a table whose key is item's price and value is a queue of indexes where the price is located.
	 * For example :  1 5 9 1 2 4 5 1 -> 1=[0, 3, 7], 5=[1, 6], 9=[2], 2=[4], 4=[5]  
	 * @return
	 */
	private Map<Integer, Queue<Integer>> stringToMap(){
		String[] sArray= this.items_string;
		Map<Integer, Queue<Integer>> m = new LinkedHashMap<Integer, Queue<Integer>>();
		int i = 0;
		for(String s : sArray){
			int item = Integer.parseInt(s.trim());
			if(item < this.C){
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
	
	public String solve(){
		String solution = "";
		Map<Integer, Queue<Integer>> prices = stringToMap();
		for (Map.Entry<Integer, Queue<Integer>> entry : prices.entrySet()) {
			int val = entry.getKey();
			int index0 = entry.getValue().poll();
			
			Queue<Integer> index1 = prices.get(this.C - val);
			if(index1 != null && !index1.isEmpty()){
				solution = (index0+1)+ " "+(index1.poll()+1);
				break;
			}
		}
		return solution;
	}
}
