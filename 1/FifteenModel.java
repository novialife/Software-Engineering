package labb2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class FifteenModel implements Boardgame {
	
	private String currentMessage = "No message yet";
	public String[][] board = new String[4][4];   
	public int iemp, jemp;                        

	
	FifteenModel () {
		List<String> listofnum = new ArrayList<String>();
		String[] nums = {" 1"," 2"," 3"," 4"," 5"," 6"," 7"," 8"," 9","10","11","12","13","14","15","  "};
		for (String num: nums) {
			listofnum.add(num);
		}
		
		Collections.shuffle(listofnum);
		
		for(int i = 0; i < 4; i++){
	        for(int j = 0; j < 4; j++){
	        	board[i][j] = listofnum.get(0);
	        	listofnum.remove(0);
	        	if (board[i][j] == "  ") {
	        		this.iemp = i;
	        		this.jemp = j;
	        	}
	        }
	    }
	}
	
	
	public boolean move(int i, int j) {
		if ((iemp == i+1 || iemp == i-1) && jemp == j && board[i][j] != "  ") {
			String temp = board[i][j];
			board[i][j] = "  ";
			board[iemp][jemp] = temp;
			iemp = i;
			jemp = j;
			currentMessage = "OK";
			return true;
			
		}
		else if ((jemp == j+1 || jemp == j-1) && iemp == i && board[i][j] != "  ") {
			String temp = board[i][j];
			board[i][j] = "  ";
			board[iemp][jemp] = temp;
			iemp = i;
			jemp = j;
			currentMessage = "OK";
			return true;
		}
		else {
			currentMessage = "Please choose a position next to the empty one!";
			return false;
		}
	}
	
	public String getStatus(int i, int j) {
		return board[i][j];
	}

	public String getMessage() {
		return currentMessage;
	}
}