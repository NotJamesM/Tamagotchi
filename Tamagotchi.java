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
		sc = new Scanner(System.in);
		menu();
	}
	
	private void menu(){
		int option = sc.nextInt();
		switch(option){
		case 1:	play();
		case 2: sleep();
		case 3: feed();
		}
	}
	
	private void play(){
		System.out.println("You play with " + name);
		if(playNeed < 200) playNeed += 800;
		else playNeed = PLAY_CAP;
		nextTurn();
	}
	
	private void sleep(){
		System.out.println("You put " + name + "to sleep");
		if(sleepNeed < 200) sleepNeed += 800;
		else sleepNeed = SLEEP_CAP;
		nextTurn();
	}
	
	private void feed(){
		System.out.println("You feed " + name);
		if(hungerNeed < 200) hungerNeed += 800;
		else hungerNeed = HUNGER_CAP;
		nextTurn();
	}
	
	private void nextTurn(){
		sleepNeed -= 100;
		playNeed -= 150;
		hungerNeed -= 200;
		System.out.println("Current Stats (low is bad, high is good):");
		System.out.println("Hunger: " + hungerNeed);
		System.out.println("Sleep" + sleepNeed);
		System.out.println("Fun need: " + playNeed);
		menu();
	}
}
