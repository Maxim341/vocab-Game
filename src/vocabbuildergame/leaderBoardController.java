package vocabbuildergame;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class leaderBoardController {

    //Initiating leaderBoard array
    public static ArrayList<leaderBoardInfo> leaderBoard = new ArrayList<leaderBoardInfo>();

    /*---------------------------------------------------------------------
        |  Method laderBoard
        |
        |  Purpose: adds required playerInfo into leaderBoard array, sorts the array and prints to the screen
        |
        |  Parameters:
        |     none
        |
        |  Returns: VOID
        *-------------------------------------------------------------------*/
    public static void leaderBoard() {
        loginController login = new loginController();
        leaderBoard.clear();
        for (playerInfo boardInfo : login.playerList) {

            String firstName = boardInfo.getFirstName();
            String secondName = boardInfo.getSurname();
            double percentage = ((((double) boardInfo.totalScore / ((double) boardInfo.gamesPlayed * 10))) * 100);
            DecimalFormat df = new DecimalFormat("#.##");
            percentage = Double.valueOf(df.format(percentage));

            leaderBoard.add(new leaderBoardInfo(firstName, secondName, percentage));

        }
        Collections.sort(leaderBoard);

        System.out.println("Leaderboard!");
        System.out.println("Showing percentage of questions correct" + "\n");

        for (leaderBoardInfo boardInfo : leaderBoard) {
            System.out.println(boardInfo.getFirstName1() + " " + boardInfo.getSurname1() + ": " + boardInfo.getPercentageScore1() + "%");

        }

        Scanner scan = new Scanner(System.in);
        System.out.println("\n" + "Press any key to continue: ");
        String input = scan.next();

    }
}
