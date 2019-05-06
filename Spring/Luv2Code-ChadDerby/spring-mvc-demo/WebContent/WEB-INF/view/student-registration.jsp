<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Student Registration</title>
</head>
<body>
	<form:form action="student-confirmation" modelAttribute="student">
	First Name: <form:input path="firstName" />
		<br>
		<br>
	Last Name: <form:input path="lastName" />
		<br>
		<br>
	Country:
		<form:select path="country">
			<form:options items="${student.countryOptions}"/>
		</form:select>
		<br>
		<br>
	Favourite Language:
		Java <form:radiobutton path="favouriteLanguage" value="Java" />
		C# <form:radiobutton path="favouriteLanguage" value="C#" />
		Python <form:radiobutton path="favouriteLanguage" value="Python" />
		PHP <form:radiobutton path="favouriteLanguage" value="PHP" />
		<br>
		<br>
	Operating Systems:
		Linux<form:checkbox path="operatingSystems" value="Linux"/>
		Mac<form:checkbox path="operatingSystems" value="Mac"/>
		Windows<form:checkbox path="operatingSystems" value="Windows"/>
		<br>
		<br>	
		<input type="submit" value="Submit" />
	</form:form>

</body>
</html>
