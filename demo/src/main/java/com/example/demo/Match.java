package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.List;

public class Match {
    public static void main(String[] args){
        getLast();

    }
    public static void getLast(){
        System.out.println(getAllMatchesTeam("Barcelona", 2011));

    }

    public static int getAllMatchesTeam(String Team, int Year){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Page> response = restTemplate.getForEntity("https://jsonmock.hackerrank.com/api/football_matches?year=2011&team1="+Team+"&page=1", Page.class);

        ResponseEntity<Page> response2 = restTemplate.getForEntity("https://jsonmock.hackerrank.com/api/football_matches?year=2011&team2="+Team+"&page=1", Page.class);

        Page result1 = response.getBody();
        Page result2 = response2.getBody();

        int n_goals = 0;
        for (int p = 1; p < Math.max(result1.total_pages +1, result2.total_pages +1); p++){
            response = restTemplate.getForEntity("https://jsonmock.hackerrank.com/api/football_matches?year="+Year+"&team1="+Team+"&page="+p, Page.class);
            response2 = restTemplate.getForEntity("https://jsonmock.hackerrank.com/api/football_matches?year="+Year+"&team2="+Team+"&page="+p, Page.class);
            result1 = response.getBody();
            result2 = response2.getBody();
            for (int i = 0; i < Math.max(result1.data.size(),result2.data.size()); i++){
                if (i < result1.data.size()){
                    n_goals += Integer.parseInt(result1.data.get(i).team1goals);
                }

                if (i < result2.data.size()){
                    n_goals += Integer.parseInt(result2.data.get(i).team2goals);
                }
            }

        }

        return n_goals;



    }



}
