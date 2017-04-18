import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Gize on 4/13/2017.
 */
public class Try {
    public Try() {
    }

   static Connection con = DBConnector.getConnection();
   public static void main(String[] args) {
       try {

           Statement st;
           ResultSet rs;

           st = con.createStatement();
           PreparedStatement preparedStmt = con
                   .prepareStatement("select idAddress, zip,street , city, state from Address where idAddress = ?");
           preparedStmt.setString(1, "0001");
           rs = preparedStmt.executeQuery();

           // Employee emp;
           ArrayList<String> record;
           while (rs.next()) {
               // record = new ArrayList<String>();

             //  car.setCarId(rs.getString(1));
             //  car.setModel(rs.getString(2));
              // car.setNoOfSeat(rs.getString(3));
               //car.setIsAvailable(rs.getString(4));
              // car.setRentPricePerDay(rs.getString(5));

               // data.add(record);
               System.out.println(rs.getString(2));
           }
           con.close();


       } catch (Exception e) {
           e.printStackTrace();


       }
    }
}
