/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vnb.ooppro;import java.sql.*;//for create database

/**
 *
 * @author sspmcoe
 */
public class Mydb {
    Connection connection;//for connection object
    PreparedStatement st;
    ResultSet rs1,rs2;
    
    Mydb()//data connection code
    {
        try {       
             Class.forName("com.mysql.jdbc.Driver"); //data base used mysql
                    connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant",
                        "root", ""); //initialization
               System.out.println("Connected");
            } catch (Exception e) {
                    System.out.println(e);
                }
            
    }
    public void insert(String RFID,String NAME,String DEPT,String mno,float CREDIT,String food,int Active)
    {
        try {
            st = (PreparedStatement) connection
                        .prepareStatement("INSERT INTO `consumers`  VALUES ('"+RFID + "', '" + NAME + "', '" +DEPT+ "', '" +mno+ "', '+CREDIT+', '"+food+ "',+Active)");//query
            System.out.println(st.execute());//query execute
            /*if(st.execute())
            {
                System.out.print("Insert");
                //JOptionPane.showMessageDialog(Mydb, "You have successfully inserted");
            } else {
                        //JOptionPane.showMessageDialog(Mydb, "Wrong input");
                        System.out.print("Insert failed");
                    }*/
        }
        catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
    }
    public static void main(String args[])
    {
        Mydb d =new Mydb();
        d.insert("1293847", "suyash sathe","SECOMP","9829384753",3500,"VEG",1);
    }
    
}
