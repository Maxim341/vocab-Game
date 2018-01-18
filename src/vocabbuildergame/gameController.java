package vocabbuildergame;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class gameController {

    //declare and initiate QuestionList
    public static ArrayList<questionInfo> QuestionList = new ArrayList<questionInfo>();

    /*---------------------------------------------------------------------
        |  Method questionReader
        |
        |  Purpose: reads in the questions from the text file into an ArrayList and splits it up. 
        |   These will be used when we need to randomise the orders of the answers.
        |
        |  Parameters:
        |      none
        |
        |  Returns: VOID
        *-------------------------------------------------------------------*/
    public void questionReader() throws FileNotFoundException {
        Scanner scan = new Scanner(gameController.class.getResourceAsStream("mini_quiz.txt"));

        while (scan.hasNextLine()) {
            String[] split = scan.nextLine().split(",");

            String question = split[0];
            String wrong1 = split[1];
            String wrong2 = split[2];
            String wrong3 = split[3];
            String correct = split[4];

            
            if(question != null && wrong1 != null && wrong2 !=null && wrong3!=null && correct != null){
            QuestionList.add(new questionInfo(question, wrong1, wrong2, wrong3, correct));
            }
        }
    }

    /*---------------------------------------------------------------------
        |  Method testArray
        |
        |  Purpose: This is a test method to print out the question list.
        |
        |  Parameters:
        |      none
        |
        |  Returns: VOID
        *-------------------------------------------------------------------*/

    public void testArray() {
        System.out.println(QuestionList);
    }

    /*---------------------------------------------------------------------
        |  Method testArray
        |
        |  Purpose: This method shuffles the lines in the ArrayList to randomise question order. We use the Collections import.
        |
        |  Parameters:
        |      none
        |
        |  Returns: VOID
        *-------------------------------------------------------------------*/

    public void questionShuffle() {
        Collections.shuffle(QuestionList);
    }

}
