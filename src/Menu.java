import java.util.Scanner;

public class Menu {

    public void menu(){

        Scanner scan = new Scanner(System.in);
        boolean mainLoop = true;
        int choice;

        do{
            System.out.println("Main Menu\n");
            System.out.println("1)  Display all students.");
            System.out.println("2) Display all teachers.");
            System.out.println("3) Display all classes.");
            System.out.println("4) Display classes of teacher.");
            System.out.println("5) Exit");
            System.out.println("Enter your Menu Choice");

            choice = scan.nextInt();

        }while(choice>6);


        switch(choice){
            case 1:
                //Students;
                    menu();
                break;

            case 2:
                //teachers;
                    menu();
                break;

            case 3:
                //classes;
                    menu();
                break;

            case 4:
                //classes of techer;
                    menu();
                break;

            case 5:
                System.out.println("Exit Program");
                System.exit(0);
                break;
        }

        if( choice > 5 || choice < 1){
            System.out.println("This is no Menu Option");
            do{
                choice = scan.nextInt();
            }while(choice < 6);
        }
    }
}


