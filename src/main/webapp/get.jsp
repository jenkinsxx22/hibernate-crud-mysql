
<%@page import="net.javaguides.hibernate.dao.StudentDao"%>
<%@page import="net.javaguides.hibernate.model.Student"%>

<%
	StudentDao studentdao = new StudentDao();
	Student student = new Student(request.getparameter("txt_firstname"),request.getparameter("txt_lastname"),request.getparameter("txt_email"));
	studentdao.SaveStudent(student);
%>
<html>
<body>
 <h3>Saved</h3>

  </body>
</html>
