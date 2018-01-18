package vocabbuildergame;


public class playerInfo 
{

    private String firstName;
    private String surname;
    private String userName;
    private String password;
    private static String userNameCheck;
    private static String passwordCheck;
    int gamesPlayed=0;
    int totalScore=0;
    

    /**
     *
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getSurname() {
        return surname;
    }

    /**
     *
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     *
     * @return
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public static String getUserNameCheck() {
        return userNameCheck;
    }

    /**
     *
     * @param userNameCheck
     */
    public static void setUserNameCheck(String userNameCheck) {
        playerInfo.userNameCheck = userNameCheck;
    }

    /**
     *
     * @return
     */
    public static String getPasswordCheck() {
        return passwordCheck;
    }

    /**
     *
     * @param passwordCheck
     */
    public static void setPasswordCheck(String passwordCheck) {
        playerInfo.passwordCheck = passwordCheck;
    }

    /**
     *
     * @return
     */
    public int getGamesPlayed() {
        return gamesPlayed;
    }

    /**
     *
     * @param gamesPlayed
     */
    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }

    /**
     *
     * @return
     */
    public int getTotalScore() {
        return totalScore;
    }

    /**
     *
     * @param totalScore
     */
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    
   

    public playerInfo() 
    {  
    }
    
    /**
     *
     * @param firstName
     * @param surname
     * @param userName
     * @param password
     * @param gamesPlayed
     * @param totalScore
     */
    public playerInfo(String firstName, String surname, String userName, String password, int gamesPlayed, int totalScore) 
    {
        this.firstName = firstName;
        this.surname = surname;
        this.userName = userName;
        this.password = password;
        this.gamesPlayed = gamesPlayed;
        this.totalScore = totalScore;
    }

    @Override
    public String toString() 
    {
        return firstName + "," + surname + "," + userName + "," + password + "," + gamesPlayed + "," + totalScore;
    }

}



