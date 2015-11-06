package tamagotchi;

import java.util.Scanner;

public class Tamagotchi {
	
	private final int SLEEP_CAP = 1000;			//max sleep
	private final int HUNGER_CAP = 1000;		//max hunger
	private final int PLAY_CAP = 1000;			//max play 
	
	private Scanner sc;
	
	private String name;
	private int hungerNeed = 500;
	private int playNeed = 500;
	private int sleepNeed = 500;

	public Tamagotchi(String name){
		this.name = name;
	}
	
	public void play(){
		System.out.println("You play with " + name);
		playNeed += 100;
	}
	
	public void sleep(){
		System.out.println("You put " + name + "to sleep");
	}
}
