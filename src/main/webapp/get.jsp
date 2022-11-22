<%@page import="java.util.List"%>
<%@page import="net.javaguides.hibernate.dao.StudentDao"%>
<%@page import="net.javaguides.hibernate.model.Student"%>
<%@page import="org.hibernate.Session"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%

StudentDao studentdao = new StudentDao();
final Student student = new Student(1,"Nisar","Ahmed","nisar@abc.com");
studentdao.SaveStudent(student);

//test get all students
List<Student> students = studentdao.getAllStudent();

//students.forEach(System.out.println(student.getId()));

%>
<h2>Your Record:</h2>
<table>
  <tr>
    <th>id</th>
    <th>first_name</th>
    <th>last_name</th>
    <th>email</th>
  </tr>
  <tr>
    <td><input type="text" value="<%=student.getId()%>"></td>
    <td><input type="text" value="<%=student.getFirstName()%>"></td>
    <td><input type="text" value="<%=student.getLastName()%>"></td>
    <td><input type="text" value="<%=student.getEmail()%>"></td>
  </tr>
</table>


