import java.util.*
import java.io.*

public class assign4 {
    
    public static Question j(){
        
    }
    
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //*
        System.out.println("From what file would you like to read questions?");
        String f = sc.next();
        //*/
        /*
        File f = new File("trivia.txt");
        //*/
        Scanner in = new Scanner(f);
        ArrayList<Question> quiz = new ArrayList;
        while (in.hasNext()) {
            Question quest = new Question();
            quest.setQuestion(in.next());
            int numans = in.nextInt();
            String[] ans=new String[numans];
            for (int i = 0;i<numans;i++){
                ans[i] = in.next();
            }
            quest.setAnswers(ans);
            quest.setRightAns(in.nextInt());
            quest.setAttempts(in.nextInt());
            quest.setCorrect(in.nextInt());
            quiz.add(quest);
        }
        //Here begins the quiz
        int[] ourGuesses = new int[quiz.size()];
        for (int i = 0;i<quiz.size();i++) {
            Question quest = quiz.get(i);
            System.out.println("Question " + i + ":\n" + quest.getQuestion() + "\nAnswers:");
            String[] answers = quest.getAnswers();
            for (int j =0;j<answers.length;j++) {
                System.out.println(j+": "+answers[j]);
            }
            System.out.println("Please type the number of the best answer.");
            int guess = sc.nextInt();
            quest.newAttempt();
            ourGuesses[i] = guess;
            if (quest.isRightAns(guess)) {
                quest.newCorrect();
            }
        }
        
        //begin displaying results
        for (int i = 0;i<quiz.size();i++) {
            Question quest = quiz.get(i);
            System.out.println("Question: " + quest.getQuestion());
            int[] ans = quest.getAnswers();
            int rightAns = quiz.getRightAns();
            int guess = ourGuesses[i];
            System.out.println("Answer: " + ans[rightAns]);
            System.out.println("Guess: " + ans[guess]);
            String response;
            if (quest.isRightAns(guess)) {
                response = "Correct! Well done, padawan!";
            } else {
                response = "Incorrect! Senpai didn't notice you!";
            }
            System.out.println("\tResults: " + response);
        }
    }
    
}