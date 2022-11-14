package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.util.List;
@NoArgsConstructor
public class Page {
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public List<Data> data;




}
