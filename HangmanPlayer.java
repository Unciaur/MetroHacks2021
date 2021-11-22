package MetroHacks2021;

import java.util.Random;
import java.util.Scanner;

public class HangmanPlayer {
    public static void main(String[] args) {
        // Set up the game's base variables
        int min = 0;
        int maxCategory = 10;
        int maxWord = 14;
        boolean guessCheck;
        String yesno = "";
        System.out.println("Instructions: ");
        System.out.println("-------------------------------------------");
        System.out.println("Welcome to Hangman.");
        System.out.println("A single word will be generated.");
        System.out.println("A category will be provided.");
        System.out.println("As will the number of letters.");
        System.out.println("You will guess a letter. You have six lives.");
        System.out.println("For every wrong guess, a life will be lost.");
        System.out.println("After a guess, you will able to guess the word.");
        System.out.println("Have fun, and Good Luck!");
        System.out.println("\n");
        System.out.println("Time to Play: ");
        System.out.println("-------------------------------------------");
        String word = "";
        int chooseCategory = (int)(Math.random() * (maxCategory - min + 1) + min);
        int chooseWord = (int)(Math.random() * (maxWord - min + 1) + min);
        String[] instrumentWords=new String[] {"saxophone","violin","cello","clarinet","trumpet","harp",
                "piano","flute","drums","tuba","trombone","euphonium","viola","bass","guitar"};

        String[] actionWords=new String[] {"play","swim","run","bike","aim","chew",
                "jump","kick","hide","punch","fall","duck","throw","grab","shiver"};

        String[] colorWords=new String[] {"red","yellow","black","brown","orange","white",
                "pink","blue","purple","green","magenta","cyan","lime","olive"};

        String[] foodWords=new String[] {"taco","burger","burrito","salad","pizza","soup",
                "sandwich","pasta","bread","quesadilla","casserole","nachos","rolls","cheese","sushi"};

        String[] petWords=new String[] {"dog","cat","rabbit","bird","frog","fish",
                "hamster","bunny","snake","ferret","tarantula","turtle","rat","mouse","alligator"};

        String[] sportWords=new String[] {"soccer","volleyball","cricket","football","baseball","crosscountry",
                "basketball","softball","tennis","rugby","golf","track","lacrosse","fencing","swimming"};

        String[] liquidWords=new String[] {"water","beer","juice","soda","gasoline","bleach",
                "soap","slime","sauce","cream","glue","paint","mercury","wine","rum"};

        String[] vehiclesWords=new String[] {"car","motorcycle","train","plane","boat","helicopter",
                "wagon","bus","truck","rickshaw","bicycle","tricycle","scooter","unicycle","dumptruck"};

        String[] occupationWords=new String[] {"doctor","officer","lawyer","teacher","firefighter","astronaut",
                "engineer","chef","businessman","consultant","soldier","salesman","investor","entrepreneur","nurse"};

        String[] languageWords=new String[] {"hindi","english","french","arabic","german","spanish",
                "mandarin","japanese","sanskrit","egyptian","swedish","tamil","marathi","italian","portugese"};

        String[] locationWords=new String[] {"house","station","gallery","school","hospital","carnival",
                "mall","outpost","plant","store","refinery","hotel","factory","port","camp"};

        // Choosing a category and word
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
            case 10:
                word=locationWords[chooseWord];
                System.out.println("Your category is locations");
                break;
        }

        // Set up the game
        int lives=6;
        int length = word.length();
        char guess = '-';
        System.out.println("The word has "+length+" letters");
        Scanner sc = new Scanner(System.in);
        String displayWord = "";
        for(int i = 0; i < length; i++){
            displayWord += "_ ";
        }
        String guessed = "";
        boolean win = false;

        // Game loop
        while(lives > 0) {
            System.out.println("Guessed letters: "+guessed);
            System.out.print("Guess a letter: ");
            guessCheck = false;
            guess = sc.next().toLowerCase().charAt(0);
            if(guessed.indexOf(guess) == -1) {
                guessed += guess + " ";
                for (int i = 0; i < length; i++) {
                    if (word.charAt(i) == guess) {
                        guessCheck = true;
                        displayWord = displayWord.substring(0, i * 2) + word.charAt(i) + displayWord.substring(i * 2 + 1);
                    }
                }
            } else {
                System.out.println("You already guessed that letter.");
            }
            System.out.println(displayWord);

            // Check if the letter was in the word
            if(!guessCheck){
                System.out.println("That letter was not in the word.");
                lives--;
            }

            // Manage lives
            if(lives == 0) {
                break;
            } else if(lives == 1){
                System.out.println("You have 1 life left.");
            } else {
                System.out.println("You have "+lives+" lives left.");
            }

            // Guess the word prompt
            System.out.println("-------------------------------------------\nGuess the word(yes/no)?");
            yesno = sc.next();
            if("yes".equalsIgnoreCase(yesno)){
                System.out.println("What is the word: ");
                String wordGuess=sc.next();
                if(word.equalsIgnoreCase(wordGuess)){
                    System.out.println("The word "+word+" is the word. You won. Good job!");
                    win = true;
                    break;
                } else {
                    System.out.println("The word "+guess+" does not match the word");
                    lives=lives-1;
                    if(lives != 0){
                        System.out.println("You have "+lives+" lives left.");
                    }
                }
            } else {
                System.out.println("-------------------------------------------");
            }
        }
        // Game over
        if(!win){
            System.out.println("You lost. Nice try. The word was " + word + ".");
        }
    }
    //update
}