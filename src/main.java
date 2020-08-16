import java.sql.SQLException;

public class main {
    public static void main(String[] args)  {

    Menu menu = new Menu();
        menu.menu();
    }
    static public void deconect(){

        try{
            Db_Conn conn = new Db_Conn();
            conn.deConn();
            System.out.println("Connection closed");

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
