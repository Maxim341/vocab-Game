package vocabbuildergame;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class loginController {

    //initiate player list
    public static ArrayList<playerInfo> playerList = new ArrayList<playerInfo>();

    //initiate variable to confirm log in status
    public static boolean loggedIn = false;

    public static boolean isLoggedIn() {
        return loggedIn;
    }

    public static void setLoggedIn(boolean loggedIn) {
        loginController.loggedIn = loggedIn;
    }

    /*---------------------------------------------------------------------
        |  Method logIn
        |
        |  Purpose: This reads in a users input for their username and password 
        |  and checks they have registered and their details are correct. 
        |
        |  Parameters:
        |      playerInfo:p
        |
        |  Returns: VOID
        *-------------------------------------------------------------------*/
    public static void logIn(playerInfo p) throws FileNotFoundException {
        playerInfo player = new playerInfo();

        Scanner scan = new Scanner(System.in);

        System.out.print("\n\tEnter your username: ");
        String userNameCheck = scan.next();
        player.setUserNameCheck(userNameCheck);
        System.out.print("\n\tEnter your password: ");
        String passwordCheck = scan.next();
        player.setPasswordCheck(passwordCheck);

        int checkFlag = 0;

        for (playerInfo info : playerList) {
            if (info.getUserName().equals(userNameCheck) && info.getPassword().equals(passwordCheck)) {
                checkFlag = 1;
            }
        }

        if (checkFlag == 1) {
            System.out.println("\nYou are logged in. Now play the game!");
            loggedIn = true;
        } else {
            System.out.println("\nIncorrect username or password. Please log in again or register first.");
        }
        
        if(userNameCheck == null || passwordCheck == null){
            System.out.println("Please enter a username and password");
        }

        p = player;

    }

    /*---------------------------------------------------------------------
        |  Method register
        |
        |  Purpose: This method allows a player to register. It also checks 
        |  whether they have already registered with the same details.
        |
        |  Parameters:
        |     none
        |
        |  Returns: VOID
        *-------------------------------------------------------------------*/
    public static void register() throws FileNotFoundException {
        playerInfo player = new playerInfo();

        Scanner scan = new Scanner(System.in);

        System.out.print("\n\tEnter your first name: ");
        String firstName = scan.next();
        player.setFirstName(firstName);

        System.out.print("\n\tEnter your surname: ");
        String surname = scan.next();
        player.setSurname(surname);

        System.out.print("\n\tEnter a username: ");
        String userName = scan.next();
        player.setUserName(userName);

        boolean check = true;
        for (playerInfo info : playerList) {

            if (info.getUserName().equals(userName)) {
                check = false;
                System.out.println("\nYou are already registered, please log in.");

            }

        }

        if (check == true) {

            System.out.print("\n\tEnter a password: ");
            String password = scan.next();
            player.setPassword(password);

            int gamesPlayed = 0;
            int totalScore = 0;

            if (player.getPassword().length() < 5 || player.getPassword().length() > 15) {

                System.out.println("\n Please enter a password between 5 and 15 characters. ");
                register();
            } else {
                playerInfo players = new playerInfo(firstName, surname, userName, password, gamesPlayed, totalScore);
                playerList.add(players);
                try {
                    writer();
                } catch (IOException ex) {
                    Logger.getLogger(vocabBuilderGame.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("\t \nCongratulations! You have registered. Now please log in to play the game.");

            }
            
            if(firstName == null || surname == null || userName ==null || password ==null){
                System.out.println("Some information required for registration is missing!");
            }
            
            
            
        }
    }

    /*---------------------------------------------------------------------
        |  Method writer
        |
        |  Purpose: adds the last person in the arrayList to playerInfo.txt
        |    used when registering. 
        |
        |  Parameters:
        |     none
        |
        |  Returns: VOID
        *-------------------------------------------------------------------*/
    public static void writer() throws FileNotFoundException, IOException {

        File file = new File("src/vocabbuildergame/playerInfo.txt");
        FileOutputStream fo = new FileOutputStream(file, true);
        PrintWriter pw = new PrintWriter(fo);

        pw.println(playerList.get(playerList.size() - 1));

        pw.close();
        fo.close();

    }


    /*---------------------------------------------------------------------
        |  Method playerReader
        |
        |  Purpose: reads playerInfo.txt and loads it into the playerList
        |
        |  Parameters:
        |     none
        |
        |  Returns: VOID
        *-------------------------------------------------------------------*/
    public void playerReader() throws FileNotFoundException {
        Scanner scan = new Scanner(loginController.class.getResourceAsStream("playerInfo.txt"));

        try {
            scan.nextLine();

            while (scan.hasNextLine()) {
                String[] split = scan.nextLine().split(",");

                String firstName = split[0];
                String surname = split[1];
                String userName = split[2];
                String password = split[3];
                int gamesPlayed = Integer.parseInt(split[4]);
                int totalScore = Integer.parseInt(split[5]);

                playerList.add(new playerInfo(firstName, surname, userName, password, gamesPlayed, totalScore));
            }

        } catch (NumberFormatException e) {
            System.out.println("Number Format Exception");
        }
    }

    /*---------------------------------------------------------------------
        |  Method overWriter
        |
        |  Purpose: At the end of the game method this overwrites the text file with updated score and games played.
        |
        |  Parameters:
        |     none
        |
        |  Returns: VOID
        *-------------------------------------------------------------------*/

    public static void overWriter() throws FileNotFoundException, IOException {
        playerInfo player = new playerInfo();

        File file = new File("src/vocabbuildergame/playerInfo.txt");
        FileOutputStream fo = new FileOutputStream(file, false);
        PrintWriter pw = new PrintWriter(fo);
        String temp = "";
        for (playerInfo info : playerList) {
            temp += info.toString() + "\n";
        }

        pw.println("fistname,surname,username,password,games played,score");
        pw.print(temp);
        pw.flush();
        pw.close();
        fo.close();

    }

}
