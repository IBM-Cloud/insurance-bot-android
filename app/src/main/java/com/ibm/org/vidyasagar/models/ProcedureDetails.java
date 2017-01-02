package com.ibm.org.vidyasagar.models;

/**
 * Created by Vidyasagar Machupalli on 28/12/16.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class ProcedureDetails {

    @SerializedName("end")
    @Expose
    private String end;
    @SerializedName("claims")
    @Expose
    private List<Object> claims = null;
    @SerializedName("start")
    @Expose
    private String start;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("limit")
    @Expose
    private String limit;
    @SerializedName("claimed")
    @Expose
    private String claimed;
    @SerializedName("coverage")
    @Expose
    private String coverage;
    @SerializedName("term")
    @Expose
    private String term;

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public List<Object> getClaims() {
        return claims;
    }

    public void setClaims(List<Object> claims) {
        this.claims = claims;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getClaimed() {
        return claimed;
    }

    public void setClaimed(String claimed) {
        this.claimed = claimed;
    }

    public String getCoverage() {
        return coverage;
    }

    public void setCoverage(String coverage) {
        this.coverage = coverage;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

}