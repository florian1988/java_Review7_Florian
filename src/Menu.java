import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    static Db_Conn db_conn;

    public void menu(){

        Scanner scan = new Scanner(System.in);
        boolean mainLoop = true;
        int choice;

        do{
            System.out.println("Main Menu\n");
            System.out.println("1)  Display all Students.");
            System.out.println("2) Display all Teachers.");
            System.out.println("3) Display all Classes.");
            System.out.println("4) Display Classes of Teacher.");
            System.out.println("5) Print a Report from Students, Teachers and Classes");
            System.out.println("6) Exit");
            System.out.println("Enter your Menu Choice");

            choice = scan.nextInt();

        }while(choice > 6);


        switch(choice){
            case 1:
                printAllStudents();
                    menu();
                break;

            case 2:
                printAllTeachers();
                    menu();
                break;

            case 3:
                printAllClasses();
                    menu();
                break;

            case 4:
                menuPoint4();
                    menu();
                break;

            case 5:
                printStuff();
                menu();
                break;

            case 6:
                System.out.println("Exit Program");
                try{
                    db_conn = new Db_Conn();
                    db_conn.deConn();
                }catch(SQLException e){
                    e.printStackTrace();
                }

                System.exit(0);
                //break;
        }

        if( choice > 6 || choice < 1){
            System.out.println("This is no Menu Option");

                menu();

        }
    }



    private void menuPoint4(){

        Scanner scan = new Scanner(System.in);
        System.out.println("Write in a Teacher ID:");
        int input = scan.nextInt();
        if(input < 0 || input > 5){
            System.out.print("invalid Number we just have 5 teachers");
        }else{
            printTeachersClasses(input);
        }
    }



    private void printTeachersClasses(int teacher){
        db_conn = new Db_Conn();

        db_conn.displayClassesOfTeacher(teacher);

        System.out.println("Teacher: " + db_conn.getT() + " teaches:");
        for(String classOfTeacher :db_conn.getClassesOfTeachers()){
            System.out.printf("%s %10s \n","Class: ",classOfTeacher);
        }
    }

    private void printAllStudents(){
        db_conn = new Db_Conn();
        db_conn.studentList();
        System.out.println(" *** Students ***");
        System.out.printf("%s %15s %15s %15s", "ID","FirstName", "LastName", "email \n" );
        for(Student student : db_conn.getStudents()){
            //System.out.println(student);
            String inmate = String.format("%d %15s %15s %15s", student.getIdStudent(), student.getFirstName(), student.getLastName(), student.getEmail());
            System.out.println(inmate);
        }
        System.out.println("***************************************************************");
    }

    private void printAllTeachers(){
        db_conn = new Db_Conn();
        db_conn.techerList();
        System.out.println(" *** Teachers ***");
        System.out.printf("%s %15s %15s %15s", "ID","FirstName", "LastName", "email \n" );
        for(Teacher teacher : db_conn.getTeachers()){

            String warder = String.format("%d %15s %15s %15s", teacher.getIdTeacher(), teacher.getFirstName(), teacher.getLastName(), teacher.getEmail());
            System.out.println(warder);
        }
        System.out.println("***************************************************************");
    }

    private void printAllClasses(){
        db_conn = new Db_Conn();
        db_conn.classesList();
        System.out.println(" *** Classes ***");
        System.out.printf("%s %15s", "ID","name \n" );
        for(Classes classes : db_conn.getClasses()){

            String prison = String.format("%d %15s", classes.getIdClass(), classes.getNameClasses());
            System.out.println(prison);
        }
        System.out.println("***************************************************************");
    }

    private void printStuff(){
        db_conn = new Db_Conn();
        db_conn.studentList();
        db_conn.techerList();
        db_conn.classesList();
        try{
            FileWriter file = new FileWriter("file.txt");
            file.write("*** Report ***\n");


            file.write("Students:\n");
            String headS = String.format("%s %15s %15s %15s", "ID","FirstName", "LastName", "email \n" );
            file.write(headS);
            for(Student student : db_conn.getStudents()){
                //System.out.println(student);
                String inmate = String.format("%d %15s %15s %15s \n", student.getIdStudent(), student.getFirstName(), student.getLastName(), student.getEmail());
                file.write(inmate);
            }
            file.write("\n");

            file.write("Teachers:\n");
            String headT = String.format("%s %15s %15s %15s", "ID","FirstName", "LastName", "email \n" );
            file.write(headT);
            for(Teacher teacher : db_conn.getTeachers()){

                String warder = String.format("%d %15s %15s %15s\n", teacher.getIdTeacher(), teacher.getFirstName(), teacher.getLastName(), teacher.getEmail());
                file.write(warder);
            }
            file.write("\n");


            file.write("Classes:\n");
            String headC = String.format("%s %15s", "ID","name \n" );
            file.write(headC);
            for(Classes classes : db_conn.getClasses()){

                String prison = String.format("%d %15s \n", classes.getIdClass(), classes.getNameClasses());
               file.write(prison);
            }

            file.close();
            System.out.println("Text file is printed it appears after closing the program. ");
        }catch(IOException e){
            e.printStackTrace();
        }


    }






}


