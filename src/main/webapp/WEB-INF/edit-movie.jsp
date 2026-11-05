<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Movie</title>
</head>
<body>
    <h2>Edit Movie Details</h2>
    
    <form action="${pageContext.request.contextPath}/movies/update/${movie.id}" method="post">
        <label>Title:</label><br>
        <input type="text" name="title" value="${movie.title}" required /><br><br>
        
        <label>Director:</label><br>
        <input type="text" name="director" value="${movie.director}" required /><br><br>
        
        <label>Release Year:</label><br>
        <input type="number" name="releaseYear" value="${movie.releaseYear}" required /><br><br>
        
        <label>Genre:</label><br>
        <input type="text" name="genre" value="${movie.genre}" required /><br><br>
        
        <button type="submit">Update Movie</button>
    </form>
    <br>
    <a href="${pageContext.request.contextPath}/movies">Cancel</a>
</body>
</html>