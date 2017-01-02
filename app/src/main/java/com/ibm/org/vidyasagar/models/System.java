package com.ibm.org.vidyasagar.models;

/**
 * Created by Vidyasagar Machupalli on 28/12/16.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class System {

    @SerializedName("dialog_stack")
    @Expose
    private List<String> dialogStack = null;
    @SerializedName("dialog_turn_counter")
    @Expose
    private Integer dialogTurnCounter;
    @SerializedName("dialog_request_counter")
    @Expose
    private Integer dialogRequestCounter;

    public List<String> getDialogStack() {
        return dialogStack;
    }

    public void setDialogStack(List<String> dialogStack) {
        this.dialogStack = dialogStack;
    }

    public Integer getDialogTurnCounter() {
        return dialogTurnCounter;
    }

    public void setDialogTurnCounter(Integer dialogTurnCounter) {
        this.dialogTurnCounter = dialogTurnCounter;
    }

    public Integer getDialogRequestCounter() {
        return dialogRequestCounter;
    }

    public void setDialogRequestCounter(Integer dialogRequestCounter) {
        this.dialogRequestCounter = dialogRequestCounter;
    }

}