<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Error</title>
    <style>
        body { font-family: Arial, sans-serif; text-align: center; margin-top: 50px; color: #d9534f; }
    </style>
</head>
<body>
    <h1>Oops! केही गडबडी भयो।</h1>
    
    <!-- कन्ट्रोलरबाट पठाएको errorMessage यहाँ प्रिन्ट हुन्छ -->
    <p><strong>${errorMessage}</strong></p>
    
    <br>
    <a href="/movies">मुभी लिस्टमा फर्किनुहोस्</a>
</body>
</html>