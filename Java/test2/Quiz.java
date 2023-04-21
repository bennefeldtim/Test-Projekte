import java.util.Random;


public class Quiz{

    static int Operand1 = (int) (Math.random() * 21.0);
    static int Operand2 = (int) (Math.random() * 21.0);


    public static void main(String[] args) {
        RechenQuiz();
    }

    public static void RechenQuiz() {

        System.out.println(
                "Was ist "
                        + Operand1
                        + " "
                        + "+-*/".charAt((new Random()).nextInt(4))
                        + " "
                        + Operand2);

        //RechenQuiz quiz = new RechenQuiz();
        //quiz.getExercise();
        //int result = quiz.getResult();
        // System.out.println("Result: "+result);


    }
}