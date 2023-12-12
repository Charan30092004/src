import java.sql.*;
import java.util.*;

public class jdbc{
    Connection con;
    Statement stmt;
    ResultSet rs;
    Scanner sc=new Scanner(System.in);
    jdbc()
    {
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/python","root","Charan@2023");  
            stmt=con.createStatement();  
            }catch(Exception e){ System.out.println(e);}  
    }
    ResultSet get()
    {
        try {
            rs=stmt.executeQuery("select * from userdetails");
            return rs;
   
        } catch (SQLException e) {
        
            e.printStackTrace();
        }
        return rs;
        
    }
    ResultSet mainContent(String code)
    {
        try{
            rs=stmt.executeQuery("select * from maintable");
            return rs;
        }
        catch(Exception e)
        {

        }
        return rs;
    }

    ResultSet getOffical()
    {
        try{
            rs=stmt.executeQuery("select * from offical_details");
            return rs;
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return rs;
    }

    ResultSet vehicledetails()
    {
         try {
            rs=stmt.executeQuery("select * from maintable");
            return rs;
   
        } catch (SQLException e) {
        
            e.printStackTrace();
        }
        return rs;

    }
    void userdetails(String x[])
    {
        String y="INSERT INTO userdetails (`Name`, `Phone Number`, `User Id`, `Date of Birth`, `Password`) VALUES ('"+x[0]+"', '"+x[3]+"', '"+x[1]+"', '"+x[4]+"', '"+x[2]+"');";
        try {
            int result=stmt.executeUpdate(y);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

    void updatamaindata(String x[])
    {
        String y="UPDATE maintable SET `Name` = '"+x[0]+"', `Vehicle Model` = '"+x[2]+"', `Number of Owner` = '"+x[3]+"', `Previous Owner` = '"+x[4]+"', `Fuel` = '"+x[5]+"', `Type` = '"+x[6]+"', `Insurance` = '"+x[7]+"', `Owner Mobile Number` = '"+x[8]+"', `Owner Address` = '"+x[9]+"' WHERE (`VehicleNumber` = '"+x[1]+"');";
        try {
            int result=stmt.executeUpdate(y);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    void addmainTable(String x[])
    {
        String y="INSERT INTO maintable (Name, VehicleNumber, Vehicle Model, Number of Owner, Previous Owner, Fuel, Type, Insurance, Owner Mobile Number, Owner Address) VALUES ('"+x[0]+"', '"+x[1]+"', '"+x[2]+"', '"+x[3]+"', '"+x[4]+"', '"+x[5]+"', '"+x[6]+"', '"+x[7]+"', '"+x[8]+"', '"+x[9]+"');";
        try{
            int result=stmt.executeUpdate(y);
        }
        catch(Exception e)
        {

        }
    }

}