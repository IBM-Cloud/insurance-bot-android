package com.ibm.org.vidyasagar.models;

import java.io.Serializable;

/**
 * Created by Vidyasagar MSC on 27/12/16.
 */

public class Message implements Serializable {
    String id, message;


    public Message() {
    }

    public Message(String id, String message, String createdAt) {
        this.id = id;
        this.message = message;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
