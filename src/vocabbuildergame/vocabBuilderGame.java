package vocabbuildergame;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class vocabBuilderGame {

    public static playerInfo player = new playerInfo();
    public static questionInfo question = new questionInfo();
    public static loginController logIn = new loginController();
    public static gameController game = new gameController();

  

    public static void main(String[] args) throws IOException {
        // Here we call two methods which read player information and question information into the program.
        logIn.playerReader();
        game.questionReader();

        //initiate scanner for main menu selection
        Scanner scan = new Scanner(System.in);

        char selection = 'a';
        while (selection != 'q') {

            // Main menu
            System.out.println();
            System.out.println("\tWelcome to the Word Game\n");
            System.out.println("\t\tLogin (L)");
            System.out.println("\t\tRegister (R)");
            System.out.println("\t\tAbout (A)");
            System.out.println("\t\tPlay the Game (P)");
            System.out.println("\t\tShow the Leaderboard (B)");
            System.out.println("\t\tQuit (Q)");
            System.out.println("\t\tTest (T)");
            System.out.print("\n\tPlease choose an option:_");
            selection = scan.next().charAt(0);
            switch (selection) {
                case 'l':
                case 'L':
                    logIn.logIn(player);
                    break;
                case 'r':
                case 'R':
                    logIn.register();
                    break;
                case 'a':
                case 'A':
                    about();
                    break;
                case 'p':
                case 'P':
                    theGame();
                    break;
                case 'b':
                case 'B':
                    leaderBoardController.leaderBoard();
                    break;
                case 't':
                case 'T':
                    Test();
                    break;

            }
        }
        System.out.println("\tPROGRAM ENDED\n");
    }

    // This will contain a description of how to play the game. 
    public static void about() {
        System.out.println("\t\n**Insert discription of game here when we have written code for it**\n");
    }

    /*---------------------------------------------------------------------
        |  Method theGame
        |
        |  Purpose:  Verify the user is logged in and then shuffle the questions to randomise them. 
        |  - The number of games played is then updated and a call to the overwriter method to update the playerinfo.txt file.
        |
        |  Parameters:
        |      None
        |
        |  Returns: VOID
        *-------------------------------------------------------------------*/
    public static void theGame() {

        loginController login = new loginController();

        if (login.isLoggedIn() == true) {
            //shuffle questions if someone is logged in. 
            game.questionShuffle();
            //find who is logged in and add one to their games played. 
            for (playerInfo info1 : logIn.playerList) {
                if (info1.getUserName().equals(player.getUserNameCheck())) {
                    info1.gamesPlayed++;
                    //make sure we assign player to person logged in. 
                    player = info1;
                    questions();
                }
            }

            try {
                //write to log file. 
                logIn.overWriter();
            } catch (IOException ex) {
                Logger.getLogger(vocabBuilderGame.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            System.out.println("\t\nPlease register or log in first\n");
        }
    }

    /*---------------------------------------------------------------------
        |  Method questions
        |
        |  Purpose: Main method to control the game. prints questions to screen and takes user input using switch statement. 
        |  players total score will be updated here. 
        |  Local variables are used to display current game score and position in terms of questions answered and skipped.
        |  Main data structures used here are ArrayLists. 
        |
        |  Parameters:
        |      None
        |
        |  Returns: VOID
        *-------------------------------------------------------------------*/
    public static void questions() {

        gameController info = new gameController();
        ArrayList<String> answers = new ArrayList<String>();
        //define variables needed to display feedback
        int total = 0;
        int skippedCount = 0;
        int questionCount = 0;
        for (int i = 0; i < 10; i++) {

            //boolean used so we know if a question is answered wrong/correct.
            Boolean incorrect = true;

            Scanner scan = new Scanner(System.in);
            //display question
            System.out.println("\n" + "New Word: " + info.QuestionList.get(i).getQuestion());
            //add answers to arrayList
            answers.add(info.QuestionList.get(i).getWrong1());
            answers.add(info.QuestionList.get(i).getWrong2());
            answers.add(info.QuestionList.get(i).getWrong3());
            answers.add(info.QuestionList.get(i).getCorrect());
            Collections.shuffle(answers);

            int count = 0;
            //print answers to screen
            for (String answer : answers) {
                count++;
                System.out.println(count + ". " + answer);
            }

            System.out.println("5. I don't know");
            System.out.println("\t\nChoose an option.");
            char playerInput = scan.next().charAt(0);

            switch (playerInput) {
                case '1':

                    questionCount++;

                    if (answers.get(0).equals(info.QuestionList.get(i).getCorrect())) {
                        incorrect = false;
                        total++;

                        System.out.println("Correct!");

                        System.out.println(info.QuestionList.get(i).getQuestion() + " means " + answers.get(0));

                        System.out.println("Questions answered: " + questionCount + "/10");
                        System.out.println("Questions skipped: " + skippedCount + "/10");
                        System.out.println("Current Score: " + total);

                        player.totalScore++;

                        System.out.println("\t\n press any key to continue");
                        String input = scan.next();
                        if (input != null) {

                            break;

                        }

                    }

                    break;
                case '2':

                    questionCount++;
                    if (answers.get(1).equals(info.QuestionList.get(i).getCorrect())) {
                        incorrect = false;

                        total++;

                        System.out.println("Correct!");

                        System.out.println(info.QuestionList.get(i).getQuestion() + " means " + answers.get(1));

                        System.out.println("Questions answered: " + questionCount + "/10" + "\n");
                        System.out.println("Questions skipped: " + skippedCount + "/10" + "\n");
                        System.out.println("Current Score: " + total);

                        player.totalScore++;

                        System.out.println("\t\n press any key to continue");
                        String input = scan.next();
                        if (input != null) {

                            break;

                        }

                    }

                    break;
                case '3':

                    questionCount++;
                    if (answers.get(2).equals(info.QuestionList.get(i).getCorrect())) {
                        incorrect = false;

                        total++;

                        System.out.println("Correct!");

                        System.out.println(info.QuestionList.get(i).getQuestion() + " means " + answers.get(2));

                        System.out.println("Questions answered: " + questionCount + "/10" + "\n");
                        System.out.println("Questions skipped: " + skippedCount + "/10" + "\n");
                        System.out.println("Current Score: " + total);

                        player.totalScore++;
                        System.out.println("\t\n press any key to continue");
                        String input = scan.next();
                        if (input != null) {

                            break;

                        }

                    }

                    break;
                case '4':

                    questionCount++;
                    if (answers.get(3).equals(info.QuestionList.get(i).getCorrect())) {
                        incorrect = false;

                        total++;

                        System.out.println("Correct!");

                        System.out.println(info.QuestionList.get(i).getQuestion() + " means " + answers.get(3));

                        System.out.println("Questions answered: " + questionCount + "/10" + "\n");
                        System.out.println("Questions skipped: " + skippedCount + "/10" + "\n");
                        System.out.println("Current Score: " + total);

                        player.totalScore++;
                        System.out.println("\t\n press any key to continue");
                        String input = scan.next();
                        if (input != null) {

                            break;

                        }

                    }
                    break;
                case '5':
                    incorrect = false;
                    skippedCount++;
                    break;
            }

            if (incorrect == true) {

                System.out.println("Incorrect!");

                System.out.println(info.QuestionList.get(i).getQuestion() + " means " + info.QuestionList.get(i).getCorrect());

                System.out.println("Questions answered: " + questionCount + "/10" + "\n");
                System.out.println("Questions skipped: " + skippedCount + "/10" + "\n");
                System.out.println("Current Score: " + total);

                System.out.println("\t\n press any key to continue");
                String input = scan.next();
                if (input != null) {
                    try {
                        logIn.overWriter();
                    } catch (IOException ex) {
                        Logger.getLogger(vocabBuilderGame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    answers.clear();
                    continue;

                }

            }

            if (i == 9 || i == 10) {
                System.out.println("Game Over!");

                System.out.println("Questions answered: " + questionCount + "/10" + "\n");
                System.out.println("Questions skipped: " + skippedCount + "/10" + "\n");
                System.out.println("Current Score: " + total);

                System.out.println("\t\n press any key to continue");
                String input = scan.next();

            }

            try {
                logIn.overWriter();
            } catch (IOException ex) {
                Logger.getLogger(vocabBuilderGame.class.getName()).log(Level.SEVERE, null, ex);
            }
            answers.clear();

        }
    }

    /*---------------------------------------------------------------------
        |  Method Test
        |
        |  Purpose: general test method where we shuffle the questions and then print them out.
        |
        |  Parameters:
        |      None
        |
        |  Returns: VOID
        *-------------------------------------------------------------------*/
    public static void Test() {
        game.questionShuffle();
        game.testArray();
    }

}
