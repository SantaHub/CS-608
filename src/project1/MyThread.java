package project1;

import java.util.List;

public class MyThread {

	private List<Integer> numberList;
	private Integer biggestNumber; 
	
	public MyThread(List<Integer> numberList) {
		this.numberList = numberList;
	}

	public void run() {
		biggestNumber = numberList.get(0);
		for(Integer number : numberList) {
			if (biggestNumber < number) 
				biggestNumber = number;
		}
	}

	public int getBiggestNumber() {
		return biggestNumber;
	}
}
