import java.util.*;
import java.io.*;

public class assign4 {
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        ArrayList<Question> quiz = new ArrayList<Question>();
        
        //Reading in from disk
        System.out.println("From what file would you like to read questions?");
        String filename = "trivia.txt";//sc.next();
        File f = new File(filename);
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
        in.close();
        
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
        int numRight = 0;
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
                numRight++;
            } else {
                response = "Incorrect! Senpai didn't notice you!";
            }
            System.out.println("\tResults: " + response);
            //double percent = (((double) quest.getCorrect())/quest.getAttempts())*100;
            System.out.printf("\tStats: %d/%d; %.2f%%\n", quest.getCorrect(), quest.getAttempts(), quest.getPercent());
        }
        System.out.println("\tPersonal: " + numRight + "/" + quiz.size() + " - " + (((double) numRight)/quiz.size())*100 + "%");
        
        //saving to disk
        PrintWriter pw = new PrintWriter(filename);
        for (int i = 0; i<quiz.size();i++) {
            Question question = quiz.get(i);
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
        pw.close();
    }
    
}




