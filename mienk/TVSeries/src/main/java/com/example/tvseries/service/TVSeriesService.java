package com.example.tvseries.service;

import com.example.tvseries.converter.TVSeriesConverter;
import com.example.tvseries.dto.TVSeriesListItem;
import com.example.tvseries.dto.TVSeriesRead;
import com.example.tvseries.dto.TVSeriesSave;
import com.example.tvseries.model.TVSeries;
import com.example.tvseries.repository.TVSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TVSeriesService {
    @Autowired
    private TVSeriesRepository tvSeriesRepository;


    public List<TVSeriesListItem> getAllSeries() {
        List<TVSeries> list = tvSeriesRepository.findAll();
        return TVSeriesConverter.convertModelsToListItems(list);
    }

    public TVSeriesRead getTVSeries(Integer id) {
        TVSeries tvSeries = tvSeriesRepository.getReferenceById(id);
        return TVSeriesConverter.convertModelToRead(tvSeries);
    }

    public TVSeriesRead createTVSeries(TVSeriesSave tvSeriesSave) {
        TVSeries tvSeries = TVSeriesConverter.convertSaveToModel(tvSeriesSave);
        tvSeriesRepository.save(tvSeries);
        return TVSeriesConverter.convertModelToRead(tvSeries);
    }

    public TVSeriesRead updateTVSeries(Integer id, TVSeriesSave tvSeriesSave) {
        TVSeries tvSeries = tvSeriesRepository.getReferenceById(id);
        tvSeries = TVSeriesConverter.convertSaveToModel(id, tvSeriesSave);
        tvSeriesRepository.save(tvSeries);
        return TVSeriesConverter.convertModelToRead(tvSeries);
    }

    public TVSeriesRead deleteTVSeries(Integer id) {
        TVSeries tvSeries = tvSeriesRepository.getReferenceById(id);
        tvSeriesRepository.deleteById(id);
        return TVSeriesConverter.convertModelToRead(tvSeries);
    }
}
