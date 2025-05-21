package com.example.tvseries.converter;

import com.example.tvseries.dto.TVSeriesListItem;
import com.example.tvseries.dto.TVSeriesRead;
import com.example.tvseries.dto.TVSeriesSave;
import com.example.tvseries.model.TVSeries;

import java.util.ArrayList;
import java.util.List;

public class TVSeriesConverter {
    public static TVSeriesRead convertModelToRead(TVSeries tvSeries){
        TVSeriesRead tvSeriesRead = new TVSeriesRead();
        tvSeriesRead.setId(tvSeries.getId());
        tvSeriesRead.setTitle(tvSeries.getTitle());
        tvSeriesRead.setGenre(tvSeries.getGenre());
        tvSeriesRead.setPremiere(tvSeries.getPremiere());
        tvSeriesRead.setImdbRating(tvSeries.getImdbRating());
        return tvSeriesRead;

    }
    public static TVSeries convertSaveToModel(TVSeriesSave tvSeriesSave){
        TVSeries tvSeries = new TVSeries();
        tvSeries.setTitle(tvSeriesSave.getTitle());
        tvSeries.setGenre(tvSeriesSave.getGenre());
        tvSeries.setPremiere(tvSeriesSave.getPremiere());
        tvSeries.setImdbRating(tvSeriesSave.getImdbRating());
        return tvSeries;
    }
    public static TVSeries convertSaveToModel(Integer id, TVSeriesSave tvSeriesSave) {
        TVSeries tvSeries = new TVSeries();
        tvSeries.setId(id);
        tvSeries.setTitle(tvSeriesSave.getTitle());
        tvSeries.setGenre(tvSeriesSave.getGenre());
        tvSeries.setPremiere(tvSeriesSave.getPremiere());
        tvSeries.setImdbRating(tvSeriesSave.getImdbRating());
        return tvSeries;

    }
    public static TVSeriesListItem convertModelToListItem(TVSeries tvSeries){
        TVSeriesListItem tvSeriesListItem = new TVSeriesListItem();
        tvSeriesListItem.setId(tvSeries.getId());
        tvSeriesListItem.setTitle(tvSeries.getTitle());
        tvSeriesListItem.setImdbRating(tvSeries.getImdbRating());
        return tvSeriesListItem;
    }
    public static List<TVSeriesListItem> convertModelsToListItems(List<TVSeries> tvSeriesList){
        List<TVSeriesListItem> tvSeriesListItems = new ArrayList<>();
        for (TVSeries tvSeries : tvSeriesList) {
            tvSeriesListItems.add(convertModelToListItem(tvSeries));
        }
        return tvSeriesListItems;
    }
}
