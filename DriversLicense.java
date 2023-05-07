

import java.util.ArrayList;
import java.util.Scanner;

public class DriversLicense {
    
    public static void exam_result(int correct){
        if (correct >= 15){
            System.out.println("You have passed.");
        }
        else{
            System.out.println("You have failed.");
        }
    }

    public static int correctnumbers(char[] attempted_answers, char[] correct_answers){
        int correct =0;
        for(int i = 0; i<20; i++){
            if (correct_answers[i] == attempted_answers[i]){
                correct++;
            }
        }
        return correct;
    }

    public static int incorrectnumbers(char[] attempted_answers, char[] correct_answers){
        int incorrect =0;
        for(int i = 0; i<20; i++){
            if (correct_answers[i] != attempted_answers[i]){
                incorrect++;
            }
        }
        return incorrect;
    }

    public static ArrayList<Integer> missednumbers(char[] attempted_answers){
        int j = 0;
        int[] missed = new int[20];
        ArrayList<Integer> array = new ArrayList<>();
        for(int i = 0; i<20; i++){
            if(attempted_answers[i] == ' '){
                missed[j] = i + 1;
                array.add(i+1);
                j=j+1;
            }
        }
        return array;
    }

    public static void main(String [] argv){
        Scanner sc= new Scanner(System.in); 
        char attempted_answers[] = new char[20];
        
        
        char correct_answers[] = {'B', 'D', 'A', 'A', 'C', 'A', 'B', 'A', 'C', 'D', 'B', 'C', 'D', 'A', 'D', 'C', 'C', 'B', 'D', 'A'};
        
        
        //sc.useDelimiter('');

        for (int i = 0; i < 20; i++) {
            System.out.println("Please enter your answer for Question No. " + (i+1));
            String str = sc.nextLine();
            
            if(str == null || str.length() == 0){
                attempted_answers[i] = ' ';
            }
            else{
                attempted_answers[i] = str.charAt(0);
            }
            
        }

        
        ArrayList<Integer> array = missednumbers(attempted_answers);


        System.out.println("correct answers are " + correctnumbers(attempted_answers, correct_answers));
        System.out.println("incorrect answers are " + incorrectnumbers(attempted_answers, correct_answers));
        System.out.println("The questions you have missed are ");
        for(int i = 0; i < array.size(); i++){
            System.out.println(array.get(i));
        }
        exam_result(correctnumbers(attempted_answers, correct_answers));
        sc.close();
    }
}
