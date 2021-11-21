package MetroHacks2021;
import java.util.Random;
import java.util.Scanner;
public class HangmanPlayer {
	public static void main(String[] args) {
				int min = 0;
				int max = 9;
				String str;
				char letter;
				boolean keepgoing = true;
				boolean dothing = false;
				String yesno = "";
				char[] lettersDone = new char[26];
				System.out.println("Instructions: ");
				System.out.println("-------------------------------------------");
				System.out.println("Welcome to Hangman.");
				System.out.println("A single word will be generated.");
				System.out.println("A category will be provided.");
				System.out.println("As will the number of letters.");
				System.out.println("You will guess a letter. You have six lives.");
				System.out.println("For every wrong guess, a life will be lost.");
				System.out.println("After a guess, you will able to guess the word.");
				System.out.println("For every wrong guess, a life will be lost.");
				System.out.println("Have fun, and Good Luck!");
				System.out.println("");
				System.out.println("");
				System.out.println("Time to Play: ");
				System.out.println("-------------------------------------------");
				String word = "";
				int chooseCategory = (int)(Math.random() * (max - min + 1) + min);
				int chooseWord = (int)(Math.random() * (max - min + 1) + min);
				String[] instrumentWords=new String[] {"saxophone","violin","cello","clarinet","trumpet","harp",
				"piano","flute","drums","tuba"};
				String[] actionWords=new String[] {"play","swim","run","bike","aim","chew",
				"jump","kick","hide","punch"};
				String[] colorWords=new String[] {"red","yellow","black","brown","orange","white",
				"pink","blue","purple","green",};
				String[] foodWords=new String[] {"taco","burger","burrito","salad","pizza","soup",
				"sandwich","pasta","bread","quesadilla"};
				String[] petWords=new String[] {"dog","cat","rabbit","bird","frog","fish",
				"hamster","bunny","snake","ferret"};
				String[] sportWords=new String[] {"soccer","volleyball","cricket","football","baseball","crosscountry",
				"basketball","softball","tennis","rugby"};
				String[] liquidWords=new String[] {"water","alchohol","juice","soda","gasoline","bleach",
				"soap","slime","sauce","cream"};
				String[] vehiclesWords=new String[] {"car","motorcycle","train","plane","boat","helicopter",
				"wagon","bus","truck","rickshaw"};
				String[] occupationWords=new String[] {"doctor","officer","lawyer","teacher","firefighter","astronaut",
				"engineer","chef","businessman","consultant"};
				String[] languageWords=new String[] {"hindi","english","french","arabic","german","spanish",
				"mandarin","japanese","sanskrit","egyptian"};
				switch(chooseCategory) {
					case 0:
					word=instrumentWords[chooseWord];
					System.out.println("Your category is instruments");
					break;
					case 1:
					word=actionWords[chooseWord];
					System.out.println("Your category is actions");
					break;
					case 2:
					word=colorWords[chooseWord];
					System.out.println("Your category is colors");
					break;
					case 3:
					word=foodWords[chooseWord];
					System.out.println("Your category is foods");
					break;
					case 4:
					word=petWords[chooseWord];
					System.out.println("Your category is pets");
					break;
					case 5:
					word=sportWords[chooseWord];
					System.out.println("Your category is sports");
					break;
					case 6:
					word=liquidWords[chooseWord];
					System.out.println("Your category is liquids");
					break;
					case 7:
					word=vehiclesWords[chooseWord];
					System.out.println("Your category is vehicles");
					break;
					case 8:
					word=occupationWords[chooseWord];
					System.out.println("Your category is occupations");
					break;
					case 9:
					word=languageWords[chooseWord];
					System.out.println("Your category is language");
					break;
				}
				int lives=6;
				System.out.println("The word has "+word.length()+" letters");

				    Scanner sc= new Scanner(System.in);
				for(int i=0;i<=26;i++) {
					System.out.println("Guess a letter. Type your guess in lowercase: ");
					str=sc.next();
					letter = str.charAt(0);
					if(word.indexOf(letter) != -1) {
					System.out.println("The letter "+letter+" is in the word");
					}else{
					System.out.println("The letter "+letter+" is not in the word");
					lives=lives-1;
				}
				if(lives==0) {
					System.out.println("You lost. Nice try. The word was "+word);
					dothing=true;
				}else{
					System.out.println("You have "+lives+" lives left");
				}
				if(dothing==true) {
					break;
				}

				System.out.println("------------------\nGuess the word(yes/no)?");
				yesno = sc.next();
				if("yes".equalsIgnoreCase(yesno)){
					keepgoing = true;
					Scanner sc1= new Scanner(System.in);
					System.out.println("What is the word: ");
					String guess=sc.next();
				if(word.equalsIgnoreCase(guess)) {
					System.out.println("The word "+guess+" is the word. You won. Good job!");
					dothing=true;
				} else {
					System.out.println("The word "+guess+" does not match the word");
					lives=lives-1;
				if(lives==0) {
					System.out.println("You lost. Nice try. The word was "+word);
					dothing=true;
				}else{
					System.out.println("You have "+lives+" lives left");
					}
				}
				}else{
					keepgoing=false;
				}
				if(dothing==true) {
					break;
			}
		}
	}
}

