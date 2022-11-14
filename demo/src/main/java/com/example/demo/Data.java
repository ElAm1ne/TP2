package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;


@NoArgsConstructor
public class Data {
    @JsonProperty("competition")
    public String competition;
    @JsonProperty("year")
    public int year;
    @JsonProperty("round")
    public String round;
    @JsonProperty("team1")
    public String team1;
    @JsonProperty("team2")
    public String team2;
    @JsonProperty("team1goals")
    public String team1goals;
    @JsonProperty("team2goals")
    public String team2goals;



}
