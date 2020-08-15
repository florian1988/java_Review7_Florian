public class Teacher {

    int idTeacher;
    String firstName;
    String lastName;
    String email;


    Teacher(int id, String first, String last, String email){
        this.idTeacher = id;
        this.firstName = first;
        this.lastName = last;
        this.email = email;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
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
