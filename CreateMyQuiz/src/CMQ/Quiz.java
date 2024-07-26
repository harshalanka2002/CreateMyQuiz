package CMQ;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Quiz {
    private static final String[] QUESTIONS = {
        "What is the square root of 2?\na)2\nb)3\nc)4\nd)5\nChoose an option:",
        "What is the capital of India?\na)New Delhi\nb)Maharastra\nc)Madya Pradesh\nd)Gujarat",
        "Who created Bitcoin?\na)Corbin Fraser\nb)Satoshi Nakamoto\nc)Changpeng Zhao\nd)David Lee Chaum",
        "How many states are there in India?\na)26\nb)27\nc)25\nd)28"
    };
    private static final String[] ANSWERS = {"c", "a", "b", "d"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int points = 0;

        for (int i = 0; i < QUESTIONS.length; i++) {
            System.out.println(QUESTIONS[i]);

            Timer timer = new Timer();
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("Time's up!");
                    System.out.println("Press Enter for next question");
                    timer.cancel();
                    
                }
            };
            timer.schedule(task, 10000); // Schedule after 10 seconds
            
            String answer = "";
            try {
                answer = scanner.nextLine().toLowerCase(); // Read entire line and convert to lowercase
            } catch (Exception e) {
                // Handle potential exceptions
            }

            // Cancel timer if user enters an answer before timeout
            timer.cancel();

            //String answer = scanner.next();
            if (isValidAnswer(answer) && answer.equals(ANSWERS[i])) {
                
                System.out.println("Correct answer.");
                
                points++;
            } else {
                System.out.println("Incorrect answer.");
            }
        }

        System.out.println("\nTotal Points Obtained In The Quiz are: " + points);
    }

    private static boolean isValidAnswer(String answer) {
        return answer.equalsIgnoreCase("a") || answer.equalsIgnoreCase("b") || answer.equalsIgnoreCase("c") ||   answer.equalsIgnoreCase("d");
    }
}
