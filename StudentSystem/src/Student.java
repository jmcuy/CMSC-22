import java.io.Serializable;

/**
 * Created by Jhessa from Arvin's code on 10/15/2016.
 */
public class Student implements Serializable{
    private String studentNumber;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private String course;
    private int yearLevel;
    private String crushName;
    private Course faveSubject;
    public Student(){

    }

    public Student(String sn, String fn, char mi, String ln, String c, int yl, String crush, Course subject) {
        studentNumber = sn;
        firstName = fn;
        middleInitial = mi;
        lastName = ln;
        course = c;
        yearLevel = yl;
        crushName = crush;
        faveSubject =   subject;
    }

    public String getStudentNumber(){
        return studentNumber;
    }

    public String getFirstName(){
        return firstName;
    }

    public char getMiddleInitial(){
        return middleInitial;
    }

    public String getLastName(){
        return lastName;
    }

    public String getCourse(){
        return course;
    }

    public int getYearLevel(){
        return yearLevel;
    }

    public void setStudentNumber(String sn){
        studentNumber = sn;
    }

    public void setFirstName(String fn){
        firstName = fn;
    }

    public void setMiddleInitial(char mi){
        middleInitial = mi;
    }

    public void setLastName(String ln){
        lastName = ln;
    }

    public void setCourse(String c){
        course = c;
    }

    public void setYearLevel(int yl){
        yearLevel = yl;
    }

    public String getCrushName() {
        return crushName;
    }

    public void setCrushName(String crushName) {
        this.crushName = crushName;
    }
    public Course getFaveSubject(){
        return faveSubject;
    }

    public String toString(){
        String x = String.format("Student Number: %s\nName: %s, %s %c.\nProgram: %s\nYear Level: %d\n Crush's Name: %s\n Favorite Subject: %s",
                                  studentNumber, lastName, firstName, middleInitial, course, yearLevel, crushName, faveSubject.toString());
        return x;
    }

}
