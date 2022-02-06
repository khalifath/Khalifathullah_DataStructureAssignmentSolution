package com.assessment.skyscrapermain;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SkyScraperMain {

	static SkyScraperHandler sct = new SkyScraperHandler();

	public static void main (String args[]) {
		int nFloors=0;
		int floorNumber=0;
		int counter=1;
		Validation code;
		boolean isValidFloorNumber = false;
		Scanner sc = new Scanner(System.in);

		try {
			while(!isValidFloorNumber) {
				System.out.println("enter the total no of floors in the building");
				nFloors = sc.nextInt();
				isValidFloorNumber=	sct.setMaxFloors(nFloors);
			}

			while (counter<=nFloors) {

				System.out.println("enter the floor size given on day: " + counter);
				floorNumber = sc.nextInt();
				code= sct.validateInput(floorNumber);

				switch(code) {
				case SUCCESS:
					sct.setFloorNumber(floorNumber);
					counter++;
					break;
				case GREATER_THAN_FLOORS:
					System.out.println("Entered floor number cannot be greater than total floors!!! ");
					break;
				case DUPLICATE_FLOOR_NUMBER:
					System.out.println(floorNumber + " Floor number you have already entered!! , pleae enter other floor number");
					break;
				case LESS_THAN_OR_ZERO:
					System.out.println("Entered floor number cannot be less than or equal to Zero!!! ");
					break;
				}
			};
			sct.orderOfConstruction(sct.getMaxFloors());

		}catch(InputMismatchException e) {
			System.out.println("You have not provided valid input , exiting.. please re-execute and provide valid input!!.");
		}
		sc.close();
	}
}
