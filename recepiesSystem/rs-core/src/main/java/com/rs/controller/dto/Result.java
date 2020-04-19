package com.rs.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Result {

    @JsonProperty("result")
    RecipeResult result;

    public Result(RecipeResult result) {
        this.result = result;
    }

    public Result(){
        this.result = new RecipeResult();
    }

    public Object getResult() {
        return result;
    }

    public void setResult(RecipeResult result) {
        this.result = result;
    }
}
