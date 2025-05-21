package com.example.tvseries.controller;

import com.example.tvseries.dto.TVSeriesListItem;
import com.example.tvseries.dto.TVSeriesRead;
import com.example.tvseries.dto.TVSeriesSave;
import com.example.tvseries.service.TVSeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tvseries")
public class TVSeriesController {
    @Autowired
    private TVSeriesService tvSeriesService;

    @GetMapping("/list-all")
    public List<TVSeriesListItem> getAllSeries(){
        return tvSeriesService.getAllSeries();
    }

    @GetMapping("/{id})")
    public TVSeriesRead getTVSeries(@PathVariable Integer id){
        return tvSeriesService.getTVSeries(id);
    }

    @PostMapping("/")
    public TVSeriesRead createTVSeries(@RequestBody TVSeriesSave tvSeriesSave){
        return tvSeriesService.createTVSeries(tvSeriesSave);
    }

    @PutMapping("/{id}")
    public TVSeriesRead updateTVSeries(@PathVariable Integer id, @RequestBody TVSeriesSave tvSeriesSave){
        return tvSeriesService.updateTVSeries(id, tvSeriesSave);
    }

    @DeleteMapping("/{id}")
    public TVSeriesRead deleteTVSeries(@PathVariable Integer id){
        return tvSeriesService.deleteTVSeries(id);
    }
}
