<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %> <!-- <-- THIS LINE IS CRITICAL -->
<!DOCTYPE html>
<html>
<head>
    <title>Movie List</title>
</head>
<body>
    <h2>Movies Collection</h2>
    
    <a href="${pageContext.request.contextPath}/movies/add">+ Add New Movie</a>
    <br><br>

    <table border="1" cellpadding="10">
        <thead>
            <tr>
                <th>Title</th>
                <th>Director</th>
                <th>Release Year</th>
                <th>Genre</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="movie" items="${movies}">
                <tr>
                    <td>${movie.title}</td>
                    <td>${movie.director}</td>
                    <td>${movie.releaseYear}</td>
                    <td>${movie.genre}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/movies/edit/${movie.id}">Edit</a> | 
                        <a href="${pageContext.request.contextPath}/movies/delete/${movie.id}" onclick="return confirm('Are you sure?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <br>
    <a href="${pageContext.request.contextPath}/">Back to Home</a>
</body>
</html>