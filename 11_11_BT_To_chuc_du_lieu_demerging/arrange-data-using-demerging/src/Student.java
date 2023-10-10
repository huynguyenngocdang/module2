import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Student {
    private String name;
    private String gender;
    private int age;
    private String dob;

    private Date dobDate;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private LocalDate today =LocalDate.now();



    public Student(String name, String gender, String dob) throws ParseException {

        this.name = name;
        this.gender = gender.toLowerCase();

        this.dob = dob;
        this.dobDate = dateFormat.parse(dob);
        this.age = today.getYear() -  dobDate.getYear() - 1900 ;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Date getDobDate() {
        return dobDate;
    }

    public void setDobDate(Date dobDate) {
        this.dobDate = dobDate;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", dob='" + dob + '\'' +
                '}';
    }
}
