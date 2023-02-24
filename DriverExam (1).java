import java.util.Objects;
import java.util.Scanner;

public class DriverExam {
    public static final int Total = 20;//no of questions
    public static String[] Correct_answers = {"B", "D", "A", "A", "C", "A", "B", "A", "C", "D", "B", "C", "D", "A", "D", "C", "C", "B", "D", "A"};
    public static String attempted_answers[]  = new String[Total];
    public static int missed_counter = 0;//no of missed questions


    public static boolean passed(int correct) {
        if (correct >= 15) {

            return true;
        } else {


            return false;
        }
    }

    public static int totalCorrect() {
        int correct = 0;
        for (int i = 0; i < Total; i++) {
            if (Correct_answers[i].equals(attempted_answers[i])) {
                correct++;
            }
        }
        return correct;
    }

    public static int totalIncorrect() {
        int incorrect = 0;
        for (int i = 0; i < Total; i++) {
            if (!Objects.equals(Correct_answers[i], attempted_answers[i])) {
                incorrect++;
            }
        }
        return incorrect;
    }

    public static int[] questionsMissed() {
        int j = 0;
        int[] missed= new int[20];
        for (int i = 0; i < Total; i++) {
            if (attempted_answers[i] == "") {
                missed[j] = i + 1;
                j = j + 1;
                missed_counter = missed_counter+1;
            }
        }
        return missed;
    }
    public static void main(String [] argv){

        DriverExam exam = new DriverExam();

        Scanner Scan = new Scanner(System.in);


        System.out.println("Please enter either: A,B,C,D )");
        for (int i = 0; i < Total; i++) {
            System.out.println("Question " + (i + 1));
            attempted_answers[i] = Scan.nextLine();
            while(!attempted_answers[i].equals("A") && !attempted_answers[i].equals("B") && !attempted_answers[i].equals("C")&& !attempted_answers[i].equals("D")&& !attempted_answers[i].equals("")){
                System.out.println("Please enter valid answer option for question "+(i+1) );
                attempted_answers[i] = Scan.nextLine();
            }


        }

        int Correct = exam.totalCorrect();
        int Incorrect = exam.totalIncorrect();
        int[] missed_question = exam.questionsMissed();
        boolean result = exam.passed(Correct);
        if (result){

            System.out.println("Congratulations! You have passed the Driver's Exam");
        }
        else{
            System.out.println("You have failed the Driver's Exam, try again later");

        }

        System.out.println("Number of correct answers: " + Correct);
        System.out.println("Number of incorrect answers: " + Incorrect);
        System.out.println("Questions missed :");
        //prints the missed questions
        for(int i =0; i<missed_counter; i++){
            System.out.println(missed_question[i]);
        }

    }
}
