import java.sql.*;
class Jdbc{
    public static void main(String[] args) throws Exception{
        String url="jdbc:postgresql://localhost:5432/Demo";
        String user="postgres";
        String pswd="test123";
        String query="select * from student";
        Connection con=DriverManager.getConnection(url,user ,pswd);
        System.out.println("Connection Established");
        Statement st=con.createStatement();
        ResultSet res=st.executeQuery(query);
        while(res.next()){
            System.out.print(res.getInt("s_id")  + " - ");
            System.out.print(res.getInt("marks") + " - ");
            System.out.print(res.getString("sname"));
            System.out.println();

        }
        con.close();
        System.out.println("Connection over");
    }
}