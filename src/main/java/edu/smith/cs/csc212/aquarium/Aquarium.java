package edu.smith.cs.csc212.aquarium;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import me.jjfoley.gfx.GFX;

/**
 * Aquarium is a graphical "application" that uses some code I built and have
 * shared with you that takes care of opening a window and communicating with
 * the user in a simple way.
 * 
 * The method draw is called 50 times per second, so we make an animation by
 * drawing our fish in one place, and moving that place slightly. The next time
 * draw gets called, our fish looks like it moved!
 * 
 * @author jfoley
 *
 * Edited by Per Van Dyke, I didn't end up with a partner in the lab
 */
public class Aquarium extends GFX {
	/**
	 * This is a static variable that tells us how wide the aquarium is.
	 */
	public static int WIDTH = 500;
	/**
	 * This is a static variable that tells us how tall the aquarium is.
	 */
	public static int HEIGHT = 500;

	/**
	 * Put a snail on the top of the tank.
	 */
	Snail algorithm = new Snail(177, Snail.HEIGHT + 1, "top");
	Shark jaws;
	
	List<Fish> fishList = new ArrayList<>();
	
	/**
	 * This is a constructor, code that runs when we make a new Aquarium.
	 */
	public Aquarium() {
		// Here we ask GFX to make our window of size WIDTH and HEIGHT.
		// Don't change this here, edit the variables instead.
		super(WIDTH, HEIGHT);
		fishList.add(new Fish(Color.red, 250, 250, 1, true, false));
		fishList.add(new Fish(Color.cyan, 100, 100, 1, false, true));
		jaws = new Shark(Color.gray, 0, 250, 1.2, false, true, fishList);
		
	}
	
	BubbleSystem bubbleSystem = new BubbleSystem();

	@Override
	public void draw(Graphics2D g) {
		// Draw the "ocean" background.
		g.setColor(Color.blue);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		//Draw fish
		for (Fish fish : fishList) {
			fish.draw(g);
		}
		
		//Draw Shark
		this.jaws.draw(g);
		
		this.bubbleSystem.drawChest(g);
		this.bubbleSystem.bubbleSpawn();
		this.bubbleSystem.bubbleDraw(g);

		// Draw our snail!
		algorithm.draw(g);
	}

	public static void main(String[] args) {
		// Uncomment this to make it go slower!
		// GFX.FPS = 10;
		// This is potentially helpful for debugging movement if there are too many print statements!

		// Note that we can store an Aquarium in a variable of type GFX because Aquarium
		// is a very specific GFX, much like 7 can be stored in a variable of type int!
		GFX app = new Aquarium();
		app.start();
	}

}
