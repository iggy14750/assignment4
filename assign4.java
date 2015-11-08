import java.util.*;
import java.io.*;

public class assign4 {
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Question> quiz = new ArrayList<Question>();
        
        /*
        try {
            /*
            System.out.println("From what file would you like to read questions?");
            String f = sc.next();
            //*/
            //*
            File f = new File("trivia.txt");
            //*/
            Scanner in = new Scanner(f);
            while (in.hasNext()) {
                Question quest = new Question();
                quest.setQuestion(in.nextLine());
                int numans = Integer.parseInt(in.nextLine());
                quest.setNumAns(numans);
                String[] ans=new String[numans];
                for (int i = 0;i<numans;i++){
                    ans[i] = in.nextLine();
                }
                quest.setAnswers(ans);
                quest.setRightAns(Integer.parseInt(in.nextLine()));
                quest.setAttempts(Integer.parseInt(in.nextLine()));
                quest.setCorrect(Integer.parseInt(in.nextLine()));
                
                quiz.add(quest);
            }
        /*
        } catch (Exception e) {
            System.out.println("Sorry; couldn't find that file");
            System.exit(0);
        }
        //*/
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
            //I should also print out the stats
        }
        
        //saving to disk
        for (int i = 0; i<quiz.size();i++) {
            Question question = quiz.get(i);
            PrintWriter pw = new PrintWriter(f);
            pw.println(question.getQuestion());
            int numans = question.getNumAns();
            pw.println(numans);
            String[] answers = question.getAnswers();
            for (int j = 0;j<numans;j++) {
                pw.println(answers[j]);
            }
            pw.println(question.getRightAns());
            pw.println(question.getAttempts());
            pw.println(question.getCorrect());
        }
    }
    
}




