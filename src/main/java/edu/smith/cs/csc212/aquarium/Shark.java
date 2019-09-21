package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.util.List;

public class Shark extends Fish {

	List<Fish> fishList;
	Fish targetFish;
	double targetX;
	double targetY;
	
	
	public Shark(Color color, double startX, double startY, double speed, 
			boolean isLittle, boolean facingLeft, List<Fish> fishList) {
		super(color, startX, startY, speed, isLittle, facingLeft);
		this.fishList = fishList;
		this.targetFish = fishList.get(0);
		this.targetX = this.targetFish.x;
		this.targetY = this.targetFish.y;
	}
	
	@Override
	public void swim() {
		this.updateTargetLocation();
		//calculate the sides of a right triangle 
		double differenceX = this.targetX - this.x;
		double differenceY = this.targetY - this.y;
		//figure out what direction to point the fish next frame
		if (differenceX > 0) {
			this.facingLeft = false;
		} else {
			this.facingLeft = true;
		}
		//calculate the third side, yes I know I could do this more easily
		double targetDistance = Math.sqrt(Math.pow(differenceX, 2) + Math.pow(differenceY, 2));
		//move the fish
		this.x += (differenceX / targetDistance) * this.speed;
		this.y += (differenceY / targetDistance) * this.speed;
		//check to see if the fish is near its target
		if (Math.abs(differenceX) < 2 && Math.abs(differenceY) < 2) {
			if (!fishList.isEmpty()) {
				//if so, eat target
				this.fishList.remove(0);
				if (!fishList.isEmpty()) {
					//and set new target
					this.getNextTarget();
				}
			} else {
				//if no more fish, swim away
				this.targetX = 1000;
				this.targetY = 250;
				System.out.println("THE END");
			}
			
		
		}
	}
	
	//gets the next fish to eat
	public void getNextTarget() {
		this.targetFish = this.fishList.get(0);
	}
	
	//if there are valid fish left, update the location of the target
	public void updateTargetLocation() {
		if (!fishList.isEmpty()) {
			this.targetX = this.targetFish.x;
			this.targetY = this.targetFish.y;
		}
	}
}
