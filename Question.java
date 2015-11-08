public class Question {

    private String question;
    private String[] answers;
    private int rightans;
    private int attempts;
    private int correct;
    public Question() {
        
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    
    public String[] getAnswers() {
        return answers;
    }
    public void setAnswers(String[] ans){
        this.answers = ans;
    }
    public int getRightAns() {
        return rightans;
    }
    public void setRightAns(int right) {
        this.rightans = right;
    }
    public int getAttempts() {
        return attempts;
    }
    public void setAttempts(int tries) {
        this.attempts = tries;
    }
    public int getCorrect() {
        return correct;
    }
    public void setCorrect(int righto) {
        this.correct = righto;
    }
    public boolean isRightAns(int guess) {
        
        return (rightans==guess);
        
    }
    
    
}