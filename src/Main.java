import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Manage.students = new ArrayList<>();
        boolean isContinue = false;
        do {
            System.out.println("====\tStudent Management System\t====");
            System.out.println("1- Add Student");
            System.out.println("2- Delete Student");
            System.out.println("3- Update Student");
            System.out.println("4- Show All Students");
            System.out.println("5- Show All Courses Of Student");
            System.out.println("6- Show CGPA Of Student");
            int choice;
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
            String l;
            do{
                System.out.print("Yes or No (y/n): ");
                l = scanner.next();
                if(Objects.equals(l, "Y")||Objects.equals(l, "y")){
                    isContinue = true;
                }else if(Objects.equals(l, "N")||Objects.equals(l, "n")){
                    isContinue = false;
                }

            }while (!Objects.equals(l, "Y") &&!Objects.equals(l, "y")  && !Objects.equals(l, "N")&&!Objects.equals(l, "n")  );
        }while (isContinue);
    }

}