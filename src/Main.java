import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        boolean isContinue = false;
        Scanner scanner = new Scanner(System.in);
        String continueStr;
        int choice;

        do {
            System.out.println("====\tStudent Management System\t====");
            System.out.println("1- Add Student");
            System.out.println("2- Delete Student");
            System.out.println("3- Update Student");
            System.out.println("4- Show All Students");
            System.out.println("5- Show All Courses Of Student");
            System.out.println("6- Show CGPA Of Student");

            do{
                System.out.print("Enter Your Choice(1-6): ");
                choice = scanner.nextInt();
            }while (choice <=0 || choice > 6);

            switch (choice){
                case 1:
                    Manage.addStudent();
                    break;
                case 2:
                    Manage.deleteStudent();
                    break;
                case 3:
                    Manage.updateStudent();
                    break;
                case 4:
                    Manage.showStudents();
                    break;
                case 5:
                    Manage.showCourses();
                    break;
                case 6:
                    Manage.showCGPA();
                    break;
            }
            System.out.println("Do you want to make another operation?");

            do{
                System.out.print("Yes or No (y/n): ");
                continueStr = scanner.next();
                if(Objects.equals(continueStr, "Y")||Objects.equals(continueStr, "y")){
                    isContinue = true;
                }else if(Objects.equals(continueStr, "N")||Objects.equals(continueStr, "n")){
                    isContinue = false;
                }
            }while (!Objects.equals(continueStr, "Y") &&!Objects.equals(continueStr, "y")  && !Objects.equals(continueStr, "N")&&!Objects.equals(continueStr, "n")  );
        }while (isContinue);
    }

}