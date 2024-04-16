import java.util.Arrays;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {

        int totalNumberOfRightGuess = 0;
        Scanner scanner = new Scanner(System.in);
        //inputs :
        System.out.println("welcome to our calcualtion programm , first you should chosse between" +
                "+ , - , * , /");
        char chosenOperator = scanner.nextLine().charAt(0);
        // System.out.println(chosenOperator);
        // what operation -> acc + - * /
        while (chosenOperator != '+' && chosenOperator != '-' && chosenOperator != '*' && chosenOperator != '/') {
            System.out.println("oops your input is not valid try again");
            chosenOperator = scanner.nextLine().charAt(0);
        }
        System.out.println("smart choice, you choesed : " + chosenOperator);

        System.out.println("enter your learning level between 1,2,3");
        //learing level 1,2,3
        int inputedLearningLevel = scanner.nextInt();
        while (inputedLearningLevel != 1 && inputedLearningLevel != 2 && inputedLearningLevel != 3) {
            System.out.println("oops your input is not valid try again");
            inputedLearningLevel = scanner.nextInt();
        }
        System.out.println("smart choice, you choesed learning level : " + inputedLearningLevel);


        //how many questions to awnser -> this should be our while
        System.out.println("now tell me how many questions you want to awnser ");
        int numberOfQuestions = scanner.nextInt();

        String[] tableViewLikeResulat = new String[numberOfQuestions];
        int maxNumberInThisLevel;
        int minNumberInthisLevel;
        switch (inputedLearningLevel) {
            case 2 -> {
                minNumberInthisLevel = 10;
                maxNumberInThisLevel = 99;
            }
            case 3 -> {
                minNumberInthisLevel = 100;
                maxNumberInThisLevel = 999;
            }
            default -> {
                minNumberInthisLevel = 0;
                maxNumberInThisLevel = 9;
            }
        }
        int qustionsCounter = 1;
        for (int remainingQues = numberOfQuestions; remainingQues > 0; remainingQues--) {
            //then generate 2 random numbers and show it
            int randomNum1 = (int) (Math.random() * (maxNumberInThisLevel - minNumberInthisLevel + 1)) + minNumberInthisLevel;
            int randomNum2 = (int) (Math.random() * (maxNumberInThisLevel - minNumberInthisLevel + 1)) + minNumberInthisLevel;

            System.out.println("\n so i generated your question, your questions  number (" + qustionsCounter + " out of " + numberOfQuestions +
                    " questions ),and it is \n" +
                    randomNum1 + " " + chosenOperator + " " + randomNum2 + "\n" +
                    "enter your guess");
            System.out.println("***your current status is " + totalNumberOfRightGuess + " correct out of " + numberOfQuestions + "questions ***");


            //input a resulalt from user
            double inputedResualtFromUser;
            try {
                inputedResualtFromUser = scanner.nextDouble();

            } catch (Exception e) {
                inputedResualtFromUser = Double.parseDouble(scanner.nextLine());

            }


            // and calculate res base on opreation and compare to users
            double realResulatOfCalc = 0;
            switch (chosenOperator) {
                case '+' -> realResulatOfCalc = randomNum1 + randomNum2;
                case '-' -> realResulatOfCalc = randomNum1 - randomNum2;
                case '*' -> realResulatOfCalc = randomNum1 * randomNum2;
                case '/' -> realResulatOfCalc = (double) randomNum1 / randomNum2;
                default -> System.out.println("some thing unexpected happend!!");
            }
            //show true or false show correct awnser
            if (realResulatOfCalc == inputedResualtFromUser) {
                System.out.println("congats you got it right. ");
                tableViewLikeResulat[qustionsCounter - 1] = "** question number " + qustionsCounter + " was  : " + randomNum1 + " " + chosenOperator + " " + randomNum2 + " = " + realResulatOfCalc +
                        " ,and you got the right awnser **" + "\n"
                ;
                totalNumberOfRightGuess++;
            } else {
                System.out.println("you are rough kid right awnser is " + realResulatOfCalc);
                tableViewLikeResulat[qustionsCounter - 1] = "** question number " + qustionsCounter + " was: " + randomNum1 + " " + chosenOperator + " " + randomNum2 + " = " + realResulatOfCalc +
                        " ,but you entered " + inputedLearningLevel + " which is not right **" + "\n"
                ;
            }


            qustionsCounter++;
        }
        //at the end show mean of correct awnsers
        System.out.println(" total");
        double meanOfCorrectAwnwsers = (double) totalNumberOfRightGuess / numberOfQuestions;
        System.out.println("you awnsered " + numberOfQuestions + " Questions and you became this resualts" +
                "\n right awnsers : " + totalNumberOfRightGuess +
                "\n rough awnsers : " + (numberOfQuestions - totalNumberOfRightGuess) +
                "\nand you got total avreage of :" + meanOfCorrectAwnwsers
        );
        System.out.println();
        System.out.println(Arrays.toString(tableViewLikeResulat).substring(1, Arrays.toString(tableViewLikeResulat).length() - 1));


        //show questions and awnsers as resulalt

    }
}
