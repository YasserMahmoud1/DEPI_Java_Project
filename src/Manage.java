import java.util.List;
import java.util.Scanner;

public class Manage {
    static List<Student> students;
    static Scanner scanner = new Scanner(System.in);
    static void addStudent(){
        String name;
        int id;
        System.out.print("Enter the student name: ");
        scanner.nextLine();
        name = scanner.nextLine();
        System.out.print("Enter the student ID: ");
        id = scanner.nextInt();
        for(Student s :students){
            if(s.getStudentID() == id){
                System.out.println("\nCan't have the same ID twice!\n");
                return;
            }
        }
        students.add(new Student(name, id));
        System.out.println("\nStudent Added Successfully!\n");
    }
    static void showStudents(){
        if(students.isEmpty()){
            System.out.println("\nThere are no students added yet!\n");
            return;
        }

        System.out.println();
        System.out.printf("%-10s%-30s%n", "ID", "Name");
        System.out.println("-------------------------------");

        for(Student s : students){
            System.out.printf("%-10d%-30s%n", s.getStudentID(), s.getStudentName());
        }
        System.out.println();
    }
    static void deleteStudent(){
        if(students.isEmpty()){
            System.out.println("\nThere are no students added yet!\n");
            return;
        }
        System.out.print("Enter the ID of the student you want to delete: ");
        boolean found = false;
        int id = scanner.nextInt();
        for(Student s: students){
            if(s.getStudentID() == id){
                students.remove(s);
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("\nThe ID you entered is not found\n");
            return;
        }
        System.out.println("\nStudent deleted Successfully\n");
    }
    static void showCourses(){
        if(students.isEmpty()){
            System.out.println("\nThere are no students added yet!\n");
            return;
        }
        System.out.print("Enter the ID of the student you want to show courses for: ");
        int id = scanner.nextInt();
        boolean found = false;
        for (Student s:  students){
            if(s.getStudentID() == id){
                if (s.checkCoursesEmpty()){
                    System.out.println("\nThere is no courses added yet!\n");
                    return;
                }
                s.showCourses();
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("\nThe ID you entered is not found\n");
        }
    }
    static void showCGPA(){
        if( students.isEmpty()){
            System.out.println("\nThere are no students added yet!\n");
            return;
        }
        System.out.print("Enter the ID of the student you want to show CGPA for: ");
        int id =  scanner.nextInt();
        boolean found = false;
        for (Student s:  students){
            if(s.getStudentID() == id){
                if (s.checkCoursesEmpty()){
                    System.out.println("\nThere is no courses added yet!\n");
                    return;
                }
                System.out.printf("\nThe CGPA of this student is: %s\n\n", s.getGPA());
                found = true;
            }
        }
        if(!found){
            System.out.println("\nThe ID you entered is not found\n");
        }
    }
    static void updateStudent(){
        if ( students.isEmpty()) {
            System.out.println("\nThere are no students added yet!\n");
            return;
        }
        System.out.print("Enter the student ID you want to update: ");
        int id =  scanner.nextInt();
        boolean found = false;
        Student student = null;
        for (Student s :  students) {
            if (s.getStudentID() == id){
                student = s;
                found = true;
                break;
            }
        }
        if(!found){
            System.out.println("\nThe ID you entered is not found\n");
            return;
        }
        int uChoice;
        do {
            System.out.println("1- Add Course");
            System.out.println("2- Delete Course");
            System.out.println("3- Update Course");
            System.out.println("4- Update Student Name");
            System.out.println("5- Update Student ID");
            System.out.print("Enter Your Choice(1-5): ");
            uChoice =  scanner.nextInt();
        }while (uChoice <= 0 || uChoice>5);

        switch (uChoice){
            case 1:
                addCourse(student);
                break;
            case 2:
                deleteCourse(student);
                break;
            case 3:
                updateCourse(student);
                break;
            case 4:
                updateStudentName(student);
                break;
            case 5:
                updateStudentID(student);
                break;
        }
    }
    static void addCourse(Student student){
        System.out.print("Enter the name of the course: ");
         scanner.nextLine();
        String name =  scanner.nextLine();
        System.out.print("Enter the degree of the course: ");
        double degree =  scanner.nextDouble();
        System.out.print("Enter the total degree of the course: ");
        int totalDegree =  scanner.nextInt();
        System.out.print("Enter the credit hours of the course: ");
        int creditHours =  scanner.nextInt();

        student.addCourse(name,degree,totalDegree,creditHours);

        System.out.println("\nThe course added successfully!\n");
    }
    static void deleteCourse(Student student){
        if (student.checkCoursesEmpty()){
            System.out.println("\nThere is no courses added yet!\n");
            return;
        }
        int i =1;
        System.out.printf("%-5s %-20s%-10s%-10s%n","ID", "Course Name", "Grade","Credit Hours");
        System.out.println("----------------------------------------------------------------------------");
        for (Course c : student.getCourses()){
            System.out.printf("%-5d %-20s%-10s%-10s%n",i, c.getCourseName(), c.getGrade(),c.getCreditHours());
            i++;
        }
        i--;
        int id;
        do{
            System.out.print("\nEnter the ID of the course you want to delete: ");
            id =  scanner.nextInt();
        }while (id <=0 || id>i);
        student.deleteCourse(student.getCourses().get(id-1));
        System.out.println("\nCourse has deleted successfully!\n");
    }
    static void updateStudentName(Student student){
        System.out.print("Enter the new name of the student: ");
         scanner.nextLine();
        String newName =  scanner.nextLine();
        student.setStudentName(newName);

        System.out.println("\nThe name changed successfully!\n");
    }
    static void updateStudentID(Student student){
        System.out.print("Enter the new ID of the student: ");
        int newID=  scanner.nextInt();
        student.setStudentID(newID);

        System.out.println("\nThe ID changed successfully!\n");
    }
    static void updateCourse(Student student){
        if (student.checkCoursesEmpty()){
            System.out.println("\nThere is no courses added yet!\n");
            return;
        }
        int i =1;
        System.out.printf("%-5s %-20s%-20s%-20s%-20s%n","ID", "Course Name", "Degree","Total Degree" ,"Credit Hours");
        System.out.println("-------------------------------------------------------------------------------");
        for (Course c : student.getCourses()){
            System.out.printf("%-5s %-20s%-20s%-20s%-20s%n",i, c.getCourseName(), c.getDegree(),c.getTotalDegree(),c.getCourseName());
            i++;
        }
        int id;
        do{
            System.out.print("\nEnter the ID of the course you want to update: ");
            id =  scanner.nextInt();
        }while (id <=0 || id>i);
        int uChoice;
        do {
            System.out.println("1- Update Course Name");
            System.out.println("2- Update Course Degree");
            System.out.println("3- Update Course Total Degree");
            System.out.println("4- Update Course Credit Hours");
            System.out.print("Enter Your Choice(1-4): ");
            uChoice =  scanner.nextInt();
        }while (uChoice <= 0 || uChoice>4);
        Course c = student.getCourses().get(id-1);
        switch (uChoice){
            case 1:
                updateCourseName(c);
                break;
            case 2:
                updateCourseDegree(c);
                break;
            case 3:
                updateCourseTotalDegree(c);
                break;
            case 4:
                updateCourseCreditHours(c);
                break;
        }

    }
    static void updateCourseName(Course course){
        System.out.print("Enter the new course name: ");
         scanner.nextLine();
        String newName =  scanner.nextLine();
        course.setCourseName(newName);
        System.out.println("\nThe course name updated successfully!\n");
    }
    static void updateCourseDegree(Course course){
        System.out.print("Enter the new course degree: ");
        double newDegree =  scanner.nextDouble();
        course.setDegree(newDegree);
        System.out.println("\nThe course degree updated successfully!\n");
    }
    static void updateCourseTotalDegree(Course course){
        System.out.print("Enter the new course total degree: ");
        double newTotalDegree =  scanner.nextDouble();
        course.setTotalDegree(newTotalDegree);
        System.out.println("\nThe course total degree updated successfully!\n");
    }
    static void updateCourseCreditHours(Course course){
        System.out.print("Enter the new course credit Hours: ");
        int newCreditHours =  scanner.nextInt();
        course.setCreditHours(newCreditHours);
        System.out.println("\nThe course credit hours updated successfully!\n");
    }
    static double round(double d){
        String formattedValue = String.format("%.2f", d);
        return Double.parseDouble(formattedValue);
    }

}
