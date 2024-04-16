import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        int totalNumberOfRightGeuss = 0;
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


        int maxNumberInThisLevel;
        int minNumberInthisLevel;
        switch (inputedLearningLevel) {
            case 2:
                minNumberInthisLevel = 10;
                maxNumberInThisLevel = 99;
                break;
            case 3:
                minNumberInthisLevel = 100;
                maxNumberInThisLevel = 999;
                break;
            default:
                minNumberInthisLevel = 0;
                maxNumberInThisLevel = 9;
        }

        for (int remainingQues = numberOfQuestions; remainingQues > 0; remainingQues--) {
            //then generate 2 random numbers and show it
            int randomNum1 = (int) (Math.random() * (maxNumberInThisLevel - minNumberInthisLevel + 1)) + minNumberInthisLevel;
            int randomNum2 = (int) (Math.random() * (maxNumberInThisLevel - minNumberInthisLevel + 1)) + minNumberInthisLevel;

            System.out.println(" so i generated your question, your questions is \n" +
                    +randomNum1 + " " + chosenOperator + " " + randomNum2 + "\n" +
                    "enter your guess");
            //input a resulalt from user

            double inputedResualtFromUser = scanner.nextDouble();

            // and calculate res base on opreation and compare to users
            double realResulatOfCalc = 0;
            switch (chosenOperator) {
                case '+':
                    realResulatOfCalc = randomNum1 + randomNum2;
                    break;
                case '-':
                    realResulatOfCalc = randomNum1 - randomNum2;
                    break;
                case '*':
                    realResulatOfCalc = randomNum1 * randomNum2;
                    break;
                case '/':
                    realResulatOfCalc = (double)randomNum1 / randomNum2;
                    break;
                default:
                    System.out.println("some thing unexpected happend!!");
            }
            //show true or false show correct awnser
            if (realResulatOfCalc == inputedResualtFromUser) {
                System.out.println("congats you got it right. ");
                totalNumberOfRightGeuss++;
            } else {
                System.out.println("you are rough kid right awnser is " + realResulatOfCalc);
            }

        }
        //at the end show mean of correct awnsers
        System.out.println(" total");
        double meanOfCorrectAwnwsers = (double) totalNumberOfRightGeuss / numberOfQuestions;
        System.out.println("you awnsered " + numberOfQuestions + " Questions and you became this resualts" +
                "\n right awnsers : " + totalNumberOfRightGeuss +
                "\n rough awnsers : " + (numberOfQuestions - totalNumberOfRightGeuss) +
                "\nand you got total avreage of :" + meanOfCorrectAwnwsers
        );


        //show questions and awnsers as resulalt

    }
}
