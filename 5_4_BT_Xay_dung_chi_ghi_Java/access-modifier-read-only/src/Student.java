public class Student {
    private String name = "John";
    private String classes = "C02";

    Student() {

    }
    Student(String name, String classes) {
        this.name = name;
        this.classes = classes;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getName() {
        return this.name;
    }

    public String getClasses() {
        return this.classes;
    }

}
