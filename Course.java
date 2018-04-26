/**
 * Γράψτε μια περιγραφή της κλάσης Course εδώ.
 * 
 * @author (Το όνομά σας) 
 * @version (Αριθμός έκδοσης ή ημερομηνία εδώ)
 */
import java.util.InputMismatchException;
import java.util.Scanner;
 
public class Course {
 
    public String title = null;  //course title
    public int semester = 0; //course semester valid values from 1 to 8, only integers
    public boolean lab = false; //course has a lab also
    public float theoryGrade; //theory grade, valid values from 0 to 10 
    public float labGrade; //lab grade, valid values from 0 to 10 
    public float courseGrade; //final course grade, valid values from 0 to 10, if course has lab 60% theory grade, 40% lab
    float theoryWeight = (float)0.6; //theory 60%
    float labWeight = (float)0.4; //theory 40%
    
    static Scanner userInput = new Scanner(System.in);
      
    public void createCourse(){
        //takes input from console to initialize a course
        
        //title
        System.out.println("> Enter the title of the course: ");
        title = userInput.nextLine();
        
        //semester
        boolean tryAgain = true;
        do {
            try {
                System.out.println("> Enter the semester of the course: 1, 2, 3, 4, 5, 6, 7, 8");
                semester = Integer.parseInt(userInput.nextLine());
                if (semester >= 1 && semester <= 8){
                System.out.println("Valid number of semester !");
                tryAgain = false;
            }
            else if (semester < 1 || semester > 8){
                // exception if semester is out of range
                throw new NumberFormatException("Semester is out of range.");
            }
        }
        catch (NumberFormatException e1) { // Range check
            System.out.println("* The number you entered is not between 1 and 8.  Try again.");
            System.out.println();
        }
        //exception if semester is not integer
       catch (InputMismatchException e2) { // Something other than a number
            System.out.println("* You did not enter an integer.  Try again.");
            System.out.println();
        }
       } while(tryAgain);  
       
       //course has a lab or not
       tryAgain = true;
       String labExists; //temporary variable