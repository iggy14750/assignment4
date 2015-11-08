import java.util.*;
import java.io.*;

public class assign4 {
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        //try {
            /*
            System.out.println("From what file would you like to read questions?");
            String f = sc.next();
            //*/
            //*
            File f = new File("trivia.txt");
            //*/
            Scanner in = new Scanner(f);
        ArrayList<Question> quiz = new ArrayList<Question>();
        while (in.hasNext()) {
            Question quest = new Question();
            quest.setQuestion(in.nextLine());
            int numans = in.nextInt();
            String throwaway = in.nextLine();
            String[] ans=new String[numans];
            for (int i = 0;i<numans;i++){
                ans[i] = in.nextLine();
            }
            quest.setAnswers(ans);
            quest.setRightAns(in.nextInt());
            throwaway = in.nextLine();
            quest.setAttempts(in.nextInt());
            throwaway = in.nextLine();
            quest.setCorrect(in.nextInt());
            
            quiz.add(quest);
        }
        /* } catch (Exception e) {
            System.out.println("Sorry; couldn't find that file");
            System.exit(0);
        } */
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
            String[] ans = quest.getAnswers();
            int rightAns = quest.getRightAns();
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