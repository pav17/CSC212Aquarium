package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;

public class Fish {
	Color color;
	int x;
	int y;
	boolean isLittle;
	boolean facingLeft;
	
	public Fish(Color color, int startX, int startY, 
			boolean isLittle, boolean facingLeft) {
		this.color = color;
		this.x = startX;
		this.y = startY;
		this.isLittle = isLittle;
	}
	
	public void draw(Graphics2D g) {
		if (this.isLittle) {
			DrawFish.smallFacingLeft(g, this.color, this.x, this.y);
		} else {
			DrawFish.facingLeft(g, this.color, this.x, this.y);
		}
		
		this.swim();
	}
	
	public void swim() {
		this.x += 1;
		this.y += 1;
	}
}
