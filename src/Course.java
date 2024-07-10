public class Course {
    private String courseName;
    private int creditHours;
    private double degree;
    private double totalDegree;
    Course(String name, double grade, int totalGrade, int creditHours){
        this.courseName = name;
        this.creditHours = creditHours;
        this.degree = grade;
        this.totalDegree = totalGrade;
    }
    void setCourseName(String newName){
        this.courseName = newName;
    }
    void setCreditHours(int newCreditHours){
        this.creditHours = newCreditHours;
    }
    void setDegree(double newDegree){
        this.degree = newDegree;
    }
    void setTotalDegree(double newTotalDegree){
        this.totalDegree = newTotalDegree;
    }

    double getDegree(){
        return degree;
    }
    double getTotalDegree(){
        return totalDegree;
    }
    String getCourseName(){
        return courseName;
    }
    int getCreditHours(){
        return creditHours;
    }
    double getGrade(){
        return degree / totalDegree * 100;
    }

}
