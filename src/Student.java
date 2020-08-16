public class Student {

    private int idStudent;
    private String firstName;
    private String lastName;
    private String email;

    Student(int id, String first, String last, String email){
        this.idStudent = id;
        this.firstName = first;
        this.lastName = last;
        this.email = email;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
