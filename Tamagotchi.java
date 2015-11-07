package tamagotchi;

import java.util.Scanner;

public class Tamagotchi {
	
	private final int SLEEP_CAP = 1000;			//max sleep
	private final int HUNGER_CAP = 1000;		//max hunger
	private final int PLAY_CAP = 1000;			//max play 
	
	private Scanner sc;
	
	private String name;
	private boolean isAlive;
	private int hungerNeed = 500;
	private int playNeed = 500;
	private int sleepNeed = 500;

	public Tamagotchi(String name){
		this.name = name;
		isAlive = true;
		sc = new Scanner(System.in);
		menu();
	}
	
	private void menu(){
		if(isAlive == false) ;
		System.out.println("\nWhat to do with " + name);
		System.out.print("1 - Play\n2 - Put to bed\n3 - Feed\n");
		int option = sc.nextInt();
		switch(option){
		case 1:	play();
		case 2: sleep();
		case 3: feed();
		}
	}
	
	private void play(){
		System.out.println("\nYou play with " + name);
		if(playNeed < 800) playNeed += 475;
		else playNeed = PLAY_CAP;
		nextTurn();
	}
	
	private void sleep(){
		System.out.println("\nYou put " + name + "to sleep");
		sleepNeed = SLEEP_CAP;
		nextTurn();
	}
	
	private void feed(){
		System.out.println("\nYou feed " + name);
		if(hungerNeed < 800) hungerNeed += 500;
		else hungerNeed = HUNGER_CAP;
		nextTurn();
	}
	
	private void nextTurn(){
		sleepNeed -= 50;
		playNeed -= 200;
		hungerNeed -= 175;
		if(sleepNeed < 1) die("sleep.");
		if(hungerNeed < 1) die("food.");
		printStats();
		menu();
	}
	
	private void printStats(){
		System.out.println("Stats:\nHunger: " + hungerNeed + "\nSleep: "+sleepNeed +"\nFun: " + playNeed);
	}
	
	private void die(String deathCause){
		System.out.println(name + " has died due to lack of " + deathCause);
		isAlive = false;
	}
}
