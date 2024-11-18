package studentdao;
import java.sql.*;
public class StudentDao {
public void registerStudent(Student student)throws ClassNotFoundException{
	String INSERT_USERS_SQL = "INSERT INTO students(first_name, last_name,email) VALUES (?, ?, ?);";
	Class.forName("com.mysql.cj.jdbc.Driver");
	try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "Ankamma@143");
			PreparedStatement ps = connection.prepareStatement(INSERT_USERS_SQL)){
		ps.setString(1, student.getFirstName());
		ps.setString(2, student.getLastName());
		ps.setString(3, student.getEmail());
		ps.executeUpdate();
	}catch (SQLException e) {
		// TODO: handle exception
		e.printStackTrace();
	}
}
 
}
