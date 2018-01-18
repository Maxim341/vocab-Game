
package vocabbuildergame;

public class questionInfo 
{
    
    private String question;
    private String wrong1;
    private String wrong2;
    private String wrong3;
    private String correct;
 
    /**
     *
     * @return question
     */
    public String getQuestion() 
    {
        return question;
    }

    /**
     *
     * @param question
     */
    public void setQuestion(String question) 
    {
        this.question = question;
    }

    /**
     *
     * @return wrong1
     */
    public String getWrong1() 
    {
        return wrong1;
    }

    /**
     *
     * @param wrong1
     */
    public void setWrong1(String wrong1) 
    {
        this.wrong1 = wrong1;
    }

    /**
     *
     * @return wrong2
     */
    public String getWrong2() 
    {
        return wrong2;
    }

    /**
     *
     * @param wrong2
     */
    public void setWrong2(String wrong2) 
    {
        this.wrong2 = wrong2;
    }

    /**
     *
     * @return wrong3
     */
    public String getWrong3() 
    {
        return wrong3;
    }

    /**
     *
     * @param wrong3
     */
    public void setWrong3(String wrong3) 
    {
        this.wrong3 = wrong3;
    }

    /**
     *
     * @return correct
     */
    public String getCorrect() 
    {
        return correct;
    }

    /**
     *
     * @param correct
     */
    public void setCorrect(String correct) 
    {
        this.correct = correct;
    }

    /**
     *
     */
    public questionInfo() 
    {  
    }
   
    /**
     *
     * @param question
     * @param wrong1
     * @param wrong2
     * @param wrong3
     * @param correct
     */
    public questionInfo(String question, String wrong1, String wrong2, String wrong3, String correct) 
    {
        this.question = question;
        this.wrong1 = wrong1;
        this.wrong2 = wrong2;
        this.wrong3 = wrong3;
        this.correct = correct;
    }
    
    @Override
    public String toString() 
    {
        return question + "," + wrong1 + "," + wrong2 + "," + wrong3 + ',' + correct + "\n";
    }    
}
