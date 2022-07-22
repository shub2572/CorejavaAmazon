<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:forEach var="i" begin="1" end="5" step="1">
		<c:forEach var="j" begin="1" end="${i }" step="1">
			<c:out value="*"></c:out>

		</c:forEach>
		<div></div>
	</c:forEach> 


<br><br>
<c:forEach begin="1" end="5" var="i" step="1">
<c:forEach begin="1" end="${5-i+1}" var="j" step="1">
<c:set var="x" value="*"></c:set>
${x}
</c:forEach><br>
</c:forEach>

</body>
</html>