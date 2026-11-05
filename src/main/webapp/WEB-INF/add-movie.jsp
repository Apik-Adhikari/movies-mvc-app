<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Add Movie</title>
</head>
<body>
    <h2>Add New Movie</h2>

    <!-- modelAttribute must match "movie" from controller -->
    <form:form modelAttribute="movie" action="/movies/add" method="POST">
        
        <div>
            <label>Title:</label>
            <form:input path="title" />
            <!-- यहाँ एरर देखाउँछ -->
            <form:errors path="title" style="color: red;" />
        </div>
        <br>

        <div>
            <label>Director:</label>
            <form:input path="director" />
            <form:errors path="director" style="color: red;" />
        </div>
        <br>

        <div>
            <label>Release Year:</label>
            <form:input path="releaseYear" />
            <form:errors path="releaseYear" style="color: red;" />
        </div>
        <br>

        <div>
            <label>Genre:</label>
            <form:input path="genre" />
            <form:errors path="genre" style="color: red;" />
        </div>
        <br>

        <button type="submit">Save Movie</button>
    </form:form>

    <br>
    <a href="/movies">Back to Movie List</a>
</body>
</html>