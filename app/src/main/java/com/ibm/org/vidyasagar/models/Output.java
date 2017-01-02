package com.ibm.org.vidyasagar.models;

/**
 * Created by Vidyasagar Machupalli on 28/12/16.
 */
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Output {

    @SerializedName("log_messages")
    @Expose
    private List<Object> logMessages = null;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("nodes_visited")
    @Expose
    private List<String> nodesVisited = null;

    public List<Object> getLogMessages() {
        return logMessages;
    }

    public void setLogMessages(List<Object> logMessages) {
        this.logMessages = logMessages;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<String> getNodesVisited() {
        return nodesVisited;
    }

    public void setNodesVisited(List<String> nodesVisited) {
        this.nodesVisited = nodesVisited;
    }

}