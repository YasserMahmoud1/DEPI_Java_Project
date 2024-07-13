import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentName;
    private int studentID;
    private final List<Course> courseList;

    Student(String name, int studentID){
        this.studentName = name;
        this.studentID = studentID;
        courseList =new ArrayList<>();
    }

    String getStudentName(){
        return studentName;
    }

    int getStudentID(){
        return studentID;
    }

    void setStudentName(String newName){
        this.studentName = newName;
    }

    void setStudentID(int newID){
        this.studentID = newID;
    }

    void addCourse(String name, double degree, int totalDegree, int creditHours){
        Course course = new Course(name, degree, totalDegree, creditHours);
        this.courseList.add(course);
    }

    void deleteCourse(Course c){
        courseList.remove(c);
    }

    List<Course> getCourses(){
        return courseList;
    }

    double getGPA(){
        double totalHours = 0;
        double totalGrade = 0;
        for (Course c :courseList) {
            totalHours += c.getCreditHours();
            totalGrade += (selectGPA(c.getGrade()) * c.getCreditHours());
        }
        return Manage.round(totalGrade / totalHours);
    }

    private double selectGPA(double grade){
        if(grade >= 90){
            return 4.0;
        }else if(grade >= 85 ){
            return 3.6;
        }
        else if (grade >= 80){
            return 3.3;
        }else if (grade >= 75){
            return 3.0;
        }
        else if (grade>= 70){
            return 2.6;
        }else if (grade>= 65){
            return 2.4;
        }
        else if (grade>= 60){
            return 2.2;
        }else if (grade>= 50){
            return 2;
        }else{
            return 0;
        }
    }

    void showCourses(){
        if (courseList.isEmpty()){
            System.out.println("\nThere is no courses added yet!\n");
        }
        System.out.println();
        System.out.printf("%-20s%-10s%-10s%n", "Course Name", "Grade","Credit Hours");
        System.out.println("-----------------------------------------------------------------------");
        for (Course c : courseList){
            System.out.printf("%-20s%-10s%-10s%n", c.getCourseName(),Manage.round(c.getGrade()),c.getCreditHours());
        }
        System.out.println();
    }

    boolean checkCoursesEmpty(){
        return courseList.isEmpty();
    }
}
