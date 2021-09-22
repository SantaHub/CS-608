package project1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	private static Random random = new Random(System.currentTimeMillis());

	private static Integer getArraySize(int numberOfThreads) {
		Random random = new Random(System.currentTimeMillis());
		Integer arraySize = Math.abs(random.nextInt() % 100) + 100;
		while (arraySize % numberOfThreads != 0) // Make sure arraySize divisible by numberOfThreads
			arraySize++;
		return arraySize;
	}

	private static List<Integer> getPopulatedArray(int numberOfThreads) {
		Integer arraySize = getArraySize(numberOfThreads);

		List<Integer> numberList = new ArrayList<Integer>();
		for (int i = 0; i < arraySize; i++)
			numberList.add(random.nextInt());
		return numberList;
	}

	private static Integer getTheBiggestNumber(List<Integer> numberList) {
		Integer biggestNumber = numberList.get(0);
		for (int i = 1; i < numberList.size(); i++)
			if (biggestNumber < numberList.get(i))
				biggestNumber = numberList.get(i);

		return biggestNumber;
	}
	
	private static List<MyThread> initializeThreadList(int numberOfThreads, List<Integer> numberList) {
		int segment = numberList.size() / numberOfThreads;
		List<MyThread> threadList = new ArrayList<MyThread>();
		// Initializing threads with their array data
		for (int i = 0; i < numberOfThreads; i++) {
			// generating Array based on segments
			List<Integer> segmentedNumberList = new ArrayList<Integer>();
			for (int j = i * segment; j < (i+1)*segment; j++) {
				segmentedNumberList.add(numberList.get(j));
			}
			threadList.add(new MyThread(segmentedNumberList));
		}
		return threadList;
	}

	private static Integer getBiggestNumberUsingThreads(int numberOfThreads, List<Integer> numberList) {
		List<MyThread> threadList = initializeThreadList(numberOfThreads, numberList);
		for(MyThread myThread : threadList) {
			myThread.run();
		}
		List<Integer> biggestFromThread = new ArrayList<Integer>();
		for(MyThread myThread: threadList) {
			biggestFromThread.add(myThread.getBiggestNumber());
		}

		return getTheBiggestNumber(biggestFromThread);
	}
	
	public static void main(String[] args) {
		int numberOfThreads = 4;
		List<Integer> numberList = getPopulatedArray(numberOfThreads);
		Integer biggestNumber = getTheBiggestNumber(numberList);
		System.out.println("The biggest number of the entire array before creating threads is: " + biggestNumber);

		// Testing with Threads
		Integer biggestNumberWithThreads = getBiggestNumberUsingThreads(numberOfThreads, numberList);
		System.out.println("The biggest number using threads : " + biggestNumberWithThreads);
	}
}