package vocabbuildergame;

public class leaderBoardInfo implements Comparable<leaderBoardInfo> {

    private String firstName1;
    private String surname1;
    private double percentageScore1;

    /**
     *
     * @return
     */
    public String getFirstName1() {
        return firstName1;
    }

    /**
     *
     * @param firstName1
     */
    public void setFirstName1(String firstName1) {
        this.firstName1 = firstName1;
    }

    /**
     *
     * @return
     */
    public String getSurname1() {
        return surname1;
    }

    /**
     *
     * @param surname1
     */
    public void setSurname1(String surname1) {
        this.surname1 = surname1;
    }

    /**
     *
     * @return
     */
    public double getPercentageScore1() {
        return percentageScore1;
    }

    /**
     *
     * @param percentageScore1
     */
    public void setPercentageScore1(double percentageScore1) {
        this.percentageScore1 = percentageScore1;
    }

    public leaderBoardInfo() {

    }

    /**
     *
     * @param firstName1
     * @param surname1
     * @param percentageScore1
     */
    public leaderBoardInfo(String firstName1, String surname1, double percentageScore1) {
        this.firstName1 = firstName1;
        this.surname1 = surname1;
        this.percentageScore1 = percentageScore1;
    }

    @Override
    public String toString() {
        return firstName1 + "," + surname1 + "," + percentageScore1 + "%" + "\n";
    }


    /*---------------------------------------------------------------------
        |  Method compareTo
        |
        |  Purpose: needed for collections.sort to work. 
        |   -works out the order for leaderboard using percentageScore
        |
        |  Parameters:
        |      leaderBoardInfo: compareScore
        |
        |  Returns: VOID
        *-------------------------------------------------------------------*/
    @Override
    public int compareTo(leaderBoardInfo compareScore) {

        int compare = (int) ((leaderBoardInfo) compareScore).percentageScore1;
        /* For Ascending order*/
        //return (int) this.percentageScore1-compare;

        /* For Descending order do like this */
        return (int) compare - (int) this.percentageScore1;
    }

}
