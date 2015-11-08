import java.util.*
import java.io.*

public class assign4 {
    
    public static Question j(){
        
    }
    
    
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("From what file would you like to read questions?");
        String f = sc.next();
        // File f = new File("trivia.txt");
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
        
        for (Question quest: quiz) {
            
            System.out.println(quest.getQuestion());
            String[] answers = quest.getAnswers();
            
        }
        
        
    }
    
}