package com.assessment.skyscrapermain;
import java.util.LinkedList;
import java.util.Queue;
import java.util.HashMap;


enum Validation{
	GREATER_THAN_FLOORS,
	LESS_THAN_OR_ZERO,
	DUPLICATE_FLOOR_NUMBER,
	SUCCESS
}


class SkyScraperHandler {

	private int noFloors;
	private Queue<Integer> queue;
	HashMap<Integer, String> map = new HashMap<>();
	int counter=1;

	int arr[];

	SkyScraperHandler(){
		this.noFloors=0;
		this.queue = new LinkedList<>();
	}

	public int getMaxFloors() {
		return noFloors;
	}

	public boolean setMaxFloors(int noFloors) {
		if(noFloors<1) {
			System.out.println("Kindly enter a valid Floor number!!");
			return false;
		}
		this.noFloors = noFloors;
		return true;
	}

	public void setFloorNumber(int nfloor) {
		//System.out.println("Added floor number to stack " + nfloor);
		queue.add(nfloor);
	}

	public Validation validateInput(int floorNumber) {
		if(floorNumber > noFloors) {
			return Validation.GREATER_THAN_FLOORS;
		}
		else if(floorNumber <=0){
			return Validation.LESS_THAN_OR_ZERO;
		}
		else {

			for (Integer item: queue) {
				if(item==floorNumber) {
					return Validation.DUPLICATE_FLOOR_NUMBER;
				}
			}
		}

		return Validation.SUCCESS;
	}

	public void reverseCheck(int arr[],int maxVal) {

		int maxValIndex=0;

		if(maxVal==0)
			return;

		String construct="";

		for(int i=arr.length-1;i>=0;i--) {

			if(arr[i]==maxVal) {
				if(maxValIndex==0)
					maxValIndex=i+1;
				construct+=arr[i] + " ";
				maxVal--;
			}
		}

		//System.out.println("Adding to hashmap " + "index : " + maxValIndex + " construct " + construct );
		map.put(maxValIndex, construct);
		maxValIndex=0;
		reverseCheck(arr, maxVal);
	}

	public void orderOfConstruction(int maxFloor) {

		int index=0;
		arr= new int[maxFloor];
		index=0;
		String construct="";

		for (Integer item: queue) {
			arr[index]=item;
			index++;
		}

		reverseCheck(arr,getMaxFloors());
		
		for(int i=1;i<=getMaxFloors();i++) {
			System.out.println("Day: "+i);
			construct=map.get(i);
		
			if(construct !=null) {
				System.out.println(construct);
			}
			else {
				System.out.println("");	
			}
				
		}
		map.clear();
	}
}


