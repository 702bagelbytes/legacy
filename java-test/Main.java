import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        System.out.println("Hello, world!");
        Scanner s = new Scanner(System.in);
        int num = (int) (Math.random() * 101);
        int guesses = 0;
        while (true) {
            System.out.print("Enter your guess: ");
            guesses++;
            int guess = s.nextInt();
            if (guess < num) {
                System.out.println("Too low!");
            } else if (guess > num) {
                System.out.println("Too high!");
            } else {
                System.out.println("You win!");
                break;
            }
        }
        System.out.println("You took " + guesses + " guesses.");
        s.close();
    }
}