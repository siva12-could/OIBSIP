import java.util.*;
public class NumberGuessingGame {
    static ArrayList<Integer> score = new ArrayList<Integer>();
    public static void main(String[] args) {
        NumberGuessingGame method = new NumberGuessingGame();
        method.menu(score);
    }
    public void menu(ArrayList<Integer> score) {
        NumberGuessingGame method = new NumberGuessingGame();
        Scanner input = new Scanner(System.in);
        System.out.println("--------------------");
        System.out.println("Welcome to the numberGuessing game");
        System.out.println("1) Play the Game...!");
        System.out.println("2) Score Board...!");
        System.out.println("3) Exit the game...!");
        System.out.println("--------------------");
        try {
            System.out.print("What action would you like to do from the above actions? ");
            int menuOpt = input.nextInt();
            switch (menuOpt) {
                case 1:
                    System.out.print("\n"+"What would you like the range of the numbers to be? ");
                    int numberRange = input.nextInt();
                    int randomnum = method.randomnum(numberRange);
                    method.guessnum(randomnum);
                    break;
                case 2:
                    method.displayScoreBoard();
                    break;
                case 3:
                    System.out.println("\n"+"Thanks for playing the game!");
                    System.exit(1);
                    break;
                default:
                    throw new InputMismatchException("Invalid number entry.Could you please Try again later");
            }
        }catch(InputMismatchException e){
            System.err.println("\n"+e.getMessage() +"\n");
            menu(score);
        }
    }
    public int randomnum(int numberRange) {
        Random random = new Random();
        int randomnum = random.nextInt(numberRange) + 1;
        return randomnum;
    }
    public void guessnum(int randomnum) {
        Scanner input = new Scanner(System.in);
        int user_num_Guess;
        int guess = 0;
        do {
            System.out.print("Enter your guess number: ");
            user_num_Guess = input.nextInt();
            guess++;
            if (user_num_Guess > randomnum) {
                System.out.println("Entered number is greater then the randomnumber");
            } else if (user_num_Guess < randomnum) {
                System.out.println("Entered number is less then the randomnumber");
            }
        } while (randomnum != user_num_Guess);
        System.out.println(" ");
        if (guess == 1) {
            System.out.println("You answered number is right in " + guess + " try!");
        } else {
            System.out.println("You answered number is right in " + guess + " tries!");
        }
        score.add(guess);
        System.out.println(" ");

        menu(score);
    }
    public void displayScoreBoard() {
        System.out.println("------------------------");
        System.out.println("Score Board");
        System.out.println("------------------------");
        System.out.println("Your fastest games today out of all tries is: " +"\n");
        Collections.sort(score);
        for (Integer scores : score) {
            System.out.println("Finished the number game in " + scores + " tries");
        }
        System.out.println(" ");
        menu(score);
    }
}
