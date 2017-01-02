package com.ibm.org.vidyasagar.models;

/**
 * Created by Vidyasagar MSC on 28/12/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Context {

    @SerializedName("system")
    @Expose
    private System system;
    @SerializedName("lname")
    @Expose
    private String lname;
    @SerializedName("procedureList")
    @Expose
    private String procedureList;
    @SerializedName("services")
    @Expose
    private List<String> services = null;
    @SerializedName("fname")
    @Expose
    private String fname;
    @SerializedName("procedure_details")
    @Expose
    private ProcedureDetails procedureDetails;
    @SerializedName("conversation_id")
    @Expose
    private String conversationId;
    @SerializedName("procedures")
    @Expose
    private List<List<String>> procedures = null;
    @SerializedName("chosen_service")
    @Expose
    private String chosenService;
    @SerializedName("chosen_procedure")
    @Expose
    private String chosenProcedure;

    public System getSystem() {
        return system;
    }

    public void setSystem(System system) {
        this.system = system;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getProcedureList() {
        return procedureList;
    }

    public void setProcedureList(String procedureList) {
        this.procedureList = procedureList;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public ProcedureDetails getProcedureDetails() {
        return procedureDetails;
    }

    public void setProcedureDetails(ProcedureDetails procedureDetails) {
        this.procedureDetails = procedureDetails;
    }

    public String getConversationId() {
        return conversationId;
    }

    public void setConversationId(String conversationId) {
        this.conversationId = conversationId;
    }

    public List<List<String>> getProcedures() {
        return procedures;
    }

    public void setProcedures(List<List<String>> procedures) {
        this.procedures = procedures;
    }

    public String getChosenService() {
        return chosenService;
    }

    public void setChosenService(String chosenService) {
        this.chosenService = chosenService;
    }

    public String getChosenProcedure() {
        return chosenProcedure;
    }

    public void setChosenProcedure(String chosenProcedure) {
        this.chosenProcedure = chosenProcedure;
    }

}