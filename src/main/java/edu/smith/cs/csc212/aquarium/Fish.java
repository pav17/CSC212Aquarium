package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;
import java.awt.Point;

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
		this.targetX = r.nextInt(501);
		this.targetY = r.nextInt(501);
	}
	
	public void draw(Graphics2D g) {
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
		Point fishPoint = new Point();
		
		
		double differenceX = this.targetX - this.x;
		double differenceY = this.targetY - this.y;
		System.out.println(differenceX);
		System.out.println(differenceY);
		double targetDistance = Math.sqrt(Math.pow(differenceX, 2)
				- Math.pow(differenceY, 2));
		System.out.println(targetDistance);
		
		this.x += (differenceX / targetDistance) * this.speed;
		this.y += (differenceY / targetDistance) * this.speed;
		if (differenceX < 2 && differenceY < 2) {
			this.targetX = r.nextInt(501);
			this.targetY = r.nextInt(501);
		}
	}
}
