import java.io.Serializable;

/**
 * Created by thegi on 04/11/2016.
 */
public class Course implements Serializable{
    private String courseCode;
    private String courseDescription;

    public Course(String code, String desc){
        courseCode = code;
        courseDescription = desc;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String toString(){
        return String.format("%s,%s", courseCode,courseDescription);
    }
}
