import java.util.Scanner;
import java.text.DecimalFormat;

/* The purpose of this class is to perform basic arithmetic functions on user inputted numbers.
 * The functions include additon, subtraction, multiplication, division, exponents, and modulus.
 * The program runs in two modes: interactive mode and non interactive mode. To run the program
 * in interactive mode, simply run the program without any arguments. You will be prompted to
 * enter your desired operation, as well as the numbers on which you wish the operation to be performed.
 * 
 * To run the program in non interactive mode, run the program with the following arguments:
 * java Calculator.java [num1] [operator] [num2]
 * 
 * Example:
 * java Calculator 2 * 3
 * 
 * The program will output the result to the console.
 */

public class Calculator {
    private static DecimalFormat DF = new DecimalFormat("0.#");     //Used for removing trailing 0's off of numbers. IE: 5.000 becomes 5 and 8.200 becomes 8.2
    private static Scanner SC;
    private static Float[] nums = new Float[2];

    /* The add() method adds [num1] and [num2] and returns the answer as a formatted string.
     * Arguments: [num1], [num2]
     * Accepted Input Types: float, int
     * Return Type: String
     * Conditions: None
     */
    public static String add(float num1, float num2){
        return DF.format(num1 + num2);
    }

    /* The subtract() method subtracts [num2] from [num1] and returns the answer as a formatted string.
     * Arguments: [num1], [num2]
     * Accepted Input Types: float, int
     * Return Type: String
     * Conditions: None
     */
    public static String subtract(float num1, float num2){
        return DF.format(num1 - num2);
    }

    /* The multiply() method multiplies [num1] and [num2] and returns the answer as a formatted string.
     * Arguments: [num1], [num2]
     * Accepted Input Types: float, int
     * Return Type: String
     * Conditions: None
     */
    public static String multiply(float num1, float num2){
        return DF.format(num1 * num2);
    }

    /* The divide() method divides [num1] by [num2] and returns the answer as a formatted string.
     * Arguments: [num1], [num2]
     * Accepted Input Types: int, float
     * Return Type: String
     * Conditions: [num2] cannot be 0. Dividing by 0 will return infinity.
     */
    public static String divide(float num1, float num2){
        return DF.format(num1 / num2);
    }

    /* The exponent() method multiplies [num1] by itself [num2] times and returns the answer as a formatted string.
     * Arguments: [num1], [num2]
     * Accepted Input Types: float, int
     * Return Type: String
     * Conditions: None
     */
    public static String exponent(float num1, float num2){
        return DF.format(Math.pow(num1, num2));
    }

    /* The modulus() find the remainder when [num1] is divided by [num2] and returns the answer as a formatted string.
     * Arguments: [num1], [num2]
     * Accepted Input Types: int
     * Return Type: String
     * Conditions: Inputs must be integers.
     */
    public static String modulus(int num1, int num2){
        return DF.format(num1 % num2);
    }

    /* The toString() method prints a formatted and readable version of an equation to the console. Accepts two numbers,
     * an operator, and the result as arguments.
     * Arguments: float [num1], String [operator], float [num2], String [result]
     */
    private static void toString(float num1, String operator, float num2, String result){
        System.out.println(String.format("%s %s %s = %s", DF.format(num1), operator, DF.format(num2), result));
    }

    /* The inputFloats() method prompts the user to input two numbers. After each input the method checks to make sure 
     * that the user inputted a number (int or float) through the use of Float.parseFloat. If the input is not a number,
     * an error is printed the console and the user is prompted to enter two numbers again. If the inputs are numbers,
     * the nums[] array is updated with the values of the input numbers.
     * Arguments: None
     * Accepted Input Types: int, float
     * Return Type: void
     * Conditions: The inputs provided by the user must be numbers (int or float).
     * Notes: Makes use of the Float[] nums array declared at the top of the class to store the values of the inputs for later use.
     */
    private static void inputFloats(){
        while(true){
            try{
                System.out.print("Enter First Number: ");
                float inputNum1 = Float.parseFloat(SC.nextLine());
                System.out.print("Enter Second Number: ");
                float inputNum2 = Float.parseFloat(SC.nextLine());

                nums[0] = inputNum1;    //Stores the inputs in the nums[] array
                nums[1] = inputNum2;    //Stores the inputs in the nums[] array
                break;
            } catch(Exception e){
                System.out.println("ERROR: Invalid Value. Inputs must be numbers.");
                continue;
            }
        }
    }

    /* The inputFloats() method prompts the user to input two numbers. After each input the method checks to make sure 
     * that the user inputted a number (int). If the input is not a number, an error is printed the console and the user
     * is prompted to enter two numbers again. If the inputted number is not an integer, an error is printed to the console
     * and the user is prompted to enter two numbers again. If the inputs are numbers, the nums[] array is updated with the
     * values of the input numbers.
     * Arguments: None
     * Accepted Input Types: int
     * Return Type: void
     * Conditions: The inputs provided by the user must be integers.
     * Notes: Makes use of the Float[] nums array declared at the top of the class to store the values of the inputs for later use.
     */
    private static void inputInts(){
        int inputNum1;
        int inputNum2;
        while(true){
            try{
                try{
                    System.out.print("Enter First Number: ");
                    inputNum1 = Integer.parseInt(SC.nextLine());
                } catch(Exception e){
                    System.out.println("ERROR: Invalid Value. Inputs for the modulus operation must be integers.");
                    continue;
                }
                
                try{
                    System.out.print("Enter Second Number: ");
                    inputNum2 = Integer.parseInt(SC.nextLine());
                } catch(Exception e){
                    System.out.println("ERROR: Invalid Value. Inputs for the modulus operation must be integers.");
                    continue;
                }

                nums[0] = (float) inputNum1;    //Stores the input in the nums[] array. Casted to float because nums[] is a float array.
                nums[1] = (float) inputNum2;    //Stores the input in the nums[] array. Casted to float because nums[] is a float array.
                break;
            } catch(Exception e){
                System.out.println("ERROR: Invalid Value. Inputs must be numbers.");
                continue;
            }
        }
    }

    /* The nonInteractiveMode() method is called when the program is run with arguments. Arguments are accepted in the following order:
     * [num1] [operator] [num2]
     * The method then outputs the answer of the equation to console.
     * Arguments: [num1] [operator] [num2]
     * Accepted Input Types: float/int, string, float/int
     * Return Type: void
     * Conditions: [num1] and [num2] must be numbers (int or float). If the operator is /, [num2] cannot be 0. If the operator is
     * %, [num1] and [num2] must be integers.
     */
    private static void nonInteractiveMode(String[] args){
        boolean run = true;
        if(args.length != 3){
            run = false;
            System.out.println("ERROR: Invalid amount of arguments. Enter arguments in the following format: [num1] [operator] [num2].");
        }

        while(run){
            try{
                Float.parseFloat(args[0]);
                Float.parseFloat(args[2]);
            } catch(Exception e){
                System.out.println("ERROR: Invalid Value. Operators must be numbers.");
                break;
            }
            
            switch(args[1]){
                case "+":
                    System.out.println(add(Float.parseFloat(args[0]), Float.parseFloat(args[2])));
                    break;
                case "-":
                    System.out.println(subtract(Float.parseFloat(args[0]), Float.parseFloat(args[2])));
                    break;
                case "*":
                case "x":
                    System.out.println(multiply(Float.parseFloat(args[0]), Float.parseFloat(args[2])));
                    break;
                case "/":
                    if(args[2].equals("0")){
                        System.out.println("ERROR: Invalid value for the second operand. Divisor cannot be zero.");
                        break;
                    }
                    System.out.println(divide(Float.parseFloat(args[0]), Float.parseFloat(args[2])));
                    break;
                case "^":
                case "xx":
                    System.out.println(exponent(Float.parseFloat(args[0]), Float.parseFloat(args[2])));
                    break;
                case "%":
                    try{
                        System.out.println(modulus(Integer.parseInt(args[0]), Integer.parseInt(args[2])));
                        break;
                    } catch(Exception e){
                        System.out.println("ERROR: Invalid Value. Inputs for the modulus operation must be integers.");
                        break;
                    }
                default:
                    System.out.println("ERROR: Invalid Operator. Valid operators are: +, -, *, /, ^, %.");
            }
            break;
        }
    }

    /* The interactiveMode() method is called when the program is run without any. The program asks the user to input an
     * operator and two numbers. The method then prints the equation as well as the answer to console.
     * Arguments: none
     * Accepted Input Types: none
     * Return Type: void
     * Conditions: [num1] and [num2] must be numbers (int or float). If the operator is /, [num2] cannot be 0. If the operator is
     * %, [num1] and [num2] must be integers.
     */
    private static void interactiveMode(){
        SC = new Scanner(System.in);
        boolean run = true;
        while(run){
            System.out.print("Enter Operator: ");
            String operator = SC.nextLine();
            switch(operator){
            case "+":
                inputFloats();
                toString(nums[0], operator, nums[1], add(nums[0], nums[1]));
                run=false;
                continue;
            case "-":
                inputFloats();
                toString(nums[0], operator, nums[1], subtract(nums[0], nums[1]));
                run=false;
                continue;
            case "*":
            case "x":
                inputFloats();
                toString(nums[0], operator, nums[1], multiply(nums[0], nums[1]));
                run=false;
                continue;
            case "/":
                inputFloats();
                if(nums[1] == 0){
                    System.out.println("ERROR: Invalid value. Second input cannot be zero.");
                    continue;
                }
                toString(nums[0], operator, nums[1], divide(nums[0], nums[1]));
                run=false;
                continue;
            case "^":
            case "xx":
                inputFloats();
                toString(nums[0], operator, nums[1], exponent(nums[0], nums[1]));
                run=false;
                continue;
            case "%":
                inputInts();
                //nums[] is an array of floats, so the contents formatted into a string and then parsed into an int for the modulus function.
                toString(nums[0], operator, nums[1], modulus(Integer.parseInt(DF.format(nums[0])), Integer.parseInt(DF.format(nums[1]))));
                run=false;
                continue;
            default:
                System.out.println("ERROR: Invalid Operator. Valid operators are: +, -, *, /, %, ^");
                continue;
            }
        }
        SC.close();
    }

    /* The main() method is called when the program is run. If the program is run without any arguments,
     * it enters interactive mode by calling the interactiveMode() method. If the program is run with arguments,
     * it enters non interactive mode by calling the nonInteractiveMode() method. More info on interactiveMode()
     * and nonInteractiveMode() can be found at their respective method headings.
     * Arguments: String[] args
     * Accepted Input Types: String
     * Return Type: void
     * Conditions: None
     * Notes: Always called whenever the program is ran.
     */
    public static void main(String[] args){
        if (args.length == 0){
            interactiveMode();
        } else {
            nonInteractiveMode(args);
        }
    }
}       