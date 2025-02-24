import java.util.Scanner;

public class SimpleChat {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Hi! What is your name?");
        String name = scan.nextLine();
        if (name.equalsIgnoreCase("exit")) {
            scan.close();
            return;
        }

        System.out.println("It is nice to meet you " + name + ". How are you doing today?");
        String mood = scan.nextLine();
        if (mood.equalsIgnoreCase("exit")) {
            scan.close();
            return;
        }

        System.out.println("Cool! What are you currently studying?");
        String major = scan.nextLine();
        if (major.equalsIgnoreCase("exit")){
            scan.close();
            return;
        }


        System.out.println("Wow, " + major + " sounds very interesting! What would you like to print? (e.g. 'Show a tree of size 6 please.' ");

        String userInput = scan.nextLine();
        if (userInput.equalsIgnoreCase("exit")) {
            scan.close();
            return;
        }

        String shape = extractShape(userInput);
        int size = extractSize(userInput);

        if (shape == null || size < 1) {
            System.out.println("Error: Please enter a valid shape and size. Exiting.");
            scan.close();
            return;
        }

        if (shape.equals("square")) {
            square(size);
        }
        else if (shape.equals("triangle")) {
            triangle(size);
        }
        else if (shape.equals("tree")) {
            tree(size);
        }
        else {
            System.out.println("Invalid shape. Exiting");
            scan.close();
            return;
        }

        System.out.println("\n Is this what you were looking for? Please type 'yes' or 'no'.");
        String confirmation = scan.nextLine();
        if (confirmation.equalsIgnoreCase("exit")){
            scan.close();
            return;
        }

        if (confirmation.equalsIgnoreCase("yes")){
            System.out.println("That is great to hear!");
        }
        else {
            System.out.println("Sorry to hear that, if you want another shape please restart the program. Exiting");
        }

        scan.close();

    }

    public static String extractShape(String input) {
        if (input.toLowerCase().contains("square")) {
            return "square";
        }
        if (input.toLowerCase().contains("triangle")) {
            return "triangle";
        }
        if (input.toLowerCase().contains("tree")) {
            return "tree";
        }
        return null;
    }

    public static int extractSize(String input) {
        String[] words = input.split(" ");
        for (int i = 0; i < words.length; i++) {
            boolean isNumber = true;


            for (int j = 0; j < words[i].length(); j++) {
                if (!Character.isDigit(words[i].charAt(j))) {
                    isNumber = false;
                    break;
                }
            }

            if (isNumber) {
                return Integer.parseInt(words[i]);
            }
        }
        return -1;
    }




public static void square(int x){
        if (x == 1){
            System.out.println("+");
            return;
        }
        for (int i = 0; i < x; i++){
            System.out.print("+");
        }
        System.out.println();
        for (int i = 0; i < x-2; i++){
            System.out.print("+");
            for (int j = 0; j < x-2; j++){
                System.out.print(" ");
            }
            System.out.print("+");
            System.out.println();
        }

        for (int i = 0; i < x; i++){
        System.out.print("+");
        }
    }
    public static void triangle(int x){
        if (x == 1){
            System.out.println("+");
            return;
        }
        System.out.print("+");
        System.out.println();
        for (int i = 2; i < x; i++){
            System.out.print("+");
            for (int j = 2; j < i; j++){
                System.out.print(" ");
            }
            System.out.print("+");
            System.out.println();
        }
        for (int i = 0; i < x; i++){
            System.out.print("+");
        }
    }

    public static void tree(int x){
        if (x == 1) {
            System.out.print("+\n|");
            return;
        }

        for (int i = 0; i < x - 1; i++) {
            System.out.print(" ");
        }
        System.out.print("+");
        System.out.println();
        for (int i = 2; i < x; i++){
            for (int k = 0; k < x - i; k++){
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++){
                System.out.print("+");
            }
            System.out.println();
        }
        for (int i = 0; i < x * 2 -1; i++){
            System.out.print("+");
        }
        System.out.println();
        for (int i = 0; i < x-1; i++){
            System.out.print(" ");
        }
        System.out.print("|");

    }

}