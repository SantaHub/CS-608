package project1;

import java.util.List;

public class MyThread extends Thread {

	private List<Integer> segmentedNumberList;
	private Integer biggestNumber; 
	
	public MyThread(List<Integer> numberList) {
		this.segmentedNumberList = numberList;
	}

	public void run() {
		biggestNumber = segmentedNumberList.get(0);
		for(Integer number : segmentedNumberList) {
			if (biggestNumber < number) 
				biggestNumber = number;
		}
	}

	public int getBiggestNumber() {
		return biggestNumber;
	}
	
	public String toString() {
		return "Thread array size : "+ segmentedNumberList.size();
	}
}
