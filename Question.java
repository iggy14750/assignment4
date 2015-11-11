public class Question {

    private String question;
    private int numans;
    private String[] answers;
    private int rightans;
    private int attempts=0;
    private int correct=0;
    public Question() {
        
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }
    public int getNumAns() {
        return numans;
    }
    public void setNumAns(int answers) {
        this.numans = answers;
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
    public void newAttempt(){
        this.attempts++;
    }
    public int getCorrect() {
        return correct;
    }
    public void newCorrect() {
        this.correct++;
    }
    public void setCorrect(int righto) {
        this.correct = righto;
    }
    public boolean isRightAns(int guess) {
        return (rightans==guess);
    }
    public double getPercent() {
        return ((double) this.correct)/this.attempts;
    }
    
}