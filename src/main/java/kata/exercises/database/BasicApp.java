package kata.exercises.database;


// STEP 1. Import required packages
import java.sql.*;

public class BasicApp
{

    public static void main( String[] argv )
    {

        System.out.println( "-------- MySQL JDBC Connection Testing ------------" );

//        try
//        {
//            //STEP 2: Register JDBC driver
//            Class.forName( "com.mysql.jdbc.Driver" );
// //            Class.forName( "com.mysql.cj.jdbc.Driver" );
//        }
//        catch ( ClassNotFoundException e )
//        {
//            System.out.println( "Where is your MySQL JDBC Driver?" );
//            e.printStackTrace();
//            return;
//        }

       System.out.println( "MySQL JDBC Driver Registered!" );
        Connection connection = null;

        try
        {
            //STEP 3: Open a connection
            connection = DriverManager
                    .getConnection( "jdbc:mysql://localhost:8889/exampleDB", "root", "root" );

        }
        catch ( SQLException e )
        {
            System.out.println( "Connection Failed! Check output console" );
            e.printStackTrace();
            return;
        }

        if ( connection != null )
        {
            System.out.println( "You made it, take control your database now!" );
        } else
        {
            System.out.println( "Failed to make connection!" );
        }

        // ......Query goes here.....
       try
       {
            //STEP 4: Execute a query
            System.out.println( "Creating statement..." );
            Statement stmt = connection.createStatement();

            String   sql = "SELECT id, first, last, age FROM employee";
            ResultSet rs = stmt.executeQuery( sql );

            while ( rs.next() )
            {
                //Retrieve by column name
                int id       = rs.getInt( "id" );
                int age      = rs.getInt( "age" );
                String first = rs.getString( "first" );
                String last  = rs.getString( "last" );

                //Display values
                System.out.print( "ID: " + id );
                System.out.print( ", Age: " + age );
                System.out.print( ", First: " + first );
                System.out.println( ", Last: " + last );
            }
       }
       catch (SQLException sqlex )
       {
           sqlex.printStackTrace();
       }


        String f = "ffff";

        {
            String s = "sssss";

            {
                String r = "rrrrrr";
                f = r;
            }
        }

        System.out.println( "f=[" + f + "]");

    } // end of main()





}