import java.sql.*;
import java.util.ArrayList;

public class Db_Conn {

    private Connection connect(){

        Connection conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            conn = DriverManager.getConnection(new Secret().getUrl(), new Secret().getUser(), new Secret().getPassword() );

        }catch(SQLException e){
            e.printStackTrace();
        }
        return conn;

    }

    public void deConn() throws SQLException {

        if(connect() != null) connect().close();
        System.out.println("Connection closed!");


    }

    private ArrayList <Student> students = new ArrayList<>();
    private ArrayList <Classes> classes = new ArrayList<>();
    private ArrayList <Teacher> teachers = new ArrayList<>();
    private ArrayList <String> classesOfTeachers = new ArrayList<>();
    private Object t = null;

    public void studentList(){
        try{
            Connection con = connect();
            String sql = "Select * from students";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while( resultSet.next()){
                Integer idStudent = resultSet.getInt("students.id_students");
                String firstName = resultSet.getString("students.firstname");
                String lastName = resultSet.getString("students.lastname");
                String email = resultSet.getString("students.email");

                students.add(new Student(idStudent, firstName, lastName, email));
            }
            if(statement!= null) statement.close();
            //System.out.println(students.size());

        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void techerList(){
        try{
            Connection con = connect();
            String sql = "Select * from teachers";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while( resultSet.next()){
                Integer idTeacher = resultSet.getInt("teachers.id_teachers");
                String firstName = resultSet.getString("teachers.firstname");
                String lastName = resultSet.getString("teachers.lastname");
                String email = resultSet.getString("teachers.email");

                teachers.add(new Teacher(idTeacher, firstName, lastName, email));
            }
            if(statement!= null) statement.close();
            //System.out.println(teachers.size());

        }catch(SQLException e){
            e.printStackTrace();
        }

    }


    public void classesList(){
        try{
            Connection con = connect();
            String sql = "Select * from classes";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while( resultSet.next()){
                Integer idClasses = resultSet.getInt("classes.id_classes");
                String name = resultSet.getString("classes.name");

                classes.add(new Classes(idClasses, name));
            }
            if(statement!= null) statement.close();
            //System.out.println(classes.size());

        }catch(SQLException e){
            e.printStackTrace();
        }

    }


    public void displayClassesOfTeacher(int teacher){
        try{
            Connection con = connect();
            String sql = "select Classes.name, Teachers.firstName, Teachers.lastName from teacherPlan inner join Teachers on teacherPlan.fk_teacher = Teachers.Id_Teachers inner join Classes on teacherPlan.fk_class = Classes.Id_Classes where Teachers.Id_Teachers like "+teacher;
            PreparedStatement statement = con.prepareStatement(sql);

                //statement.setInt(1,teacher);

                ResultSet resultSet = statement.executeQuery();
                while( resultSet.next()){
                    String name = resultSet.getString("classes.name");
                    String firstName = resultSet.getString("Teachers.firstName");
                    String lastName = resultSet.getString("Teachers.lastName");

                    classesOfTeachers.add(name);
                    t = firstName + " " + lastName;

                }

            if(statement!= null) statement.close();
            //System.out.println(classesOfTeachers.size());

        }catch(SQLException e){
            e.printStackTrace();
        }

    }


    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Classes> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Classes> classes) {
        this.classes = classes;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public ArrayList<String> getClassesOfTeachers() {
        return classesOfTeachers;
    }

    public void setClassesOfTeachers(ArrayList<String> classesOfTeachers) {
        this.classesOfTeachers = classesOfTeachers;
    }

    public Object getT() {
        return t;
    }

    public void setT(Object t) {
        this.t = t;
    }
}


