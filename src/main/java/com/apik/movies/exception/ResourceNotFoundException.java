package com.apik.movies.exception;

// RuntimeException बाट extend गर्नु पर्छ
public class ResourceNotFoundException extends RuntimeException {
    
    // कन्स्ट्रक्टर जसले एरर मेसेज लिन्छ
    public ResourceNotFoundException(String message) {
        super(message);
    }
}