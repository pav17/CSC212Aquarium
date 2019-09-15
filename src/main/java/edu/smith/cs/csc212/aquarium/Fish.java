package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;

public class Fish {
	Color color;
	public double x;
	public double y;
	double speed;
	boolean isLittle;
	boolean facingLeft;
	
	double targetX;
	double targetY;
	
	static Random r = new Random();
	
	public Fish(Color color, double startX, double startY, double speed, 
			boolean isLittle, boolean facingLeft) {
		this.color = color;
		this.x = startX;
		this.y = startY;
		this.isLittle = isLittle;
		this.facingLeft = facingLeft;
		this.targetX = r.nextInt(401);
		this.targetY = r.nextInt(401);
		this.speed = speed;
	}
	
	public void draw(Graphics2D g) {
		//make sure the fish faces the correct direction
		if (this.isLittle) {
			if (this.facingLeft) {
				DrawFish.smallFacingLeft(g, this.color, this.x, this.y);
			} else {
				DrawFish.smallFacingRight(g, this.color, this.x, this.y);
			}
		} else {
			if (this.facingLeft) {
				DrawFish.facingLeft(g, this.color, this.x, this.y);
			} else {
				DrawFish.facingRight(g, this.color, this.x, this.y);
			}
		}
		
		this.swim();
	}
	
	public void swim() {
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
			//if so, get a new target
			this.targetX = r.nextInt(401);
			this.targetY = r.nextInt(401);
		
		}
	}
}
