package entity;

import exception.NotFoundException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Towns {

    private List<String> towns = Arrays.asList("Paris", "Valencienne", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver", "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok", "Hong Kong", "Dubaï", "Rome", "Istanbul") ;


    public List<String> townSearch(String search){

        if (search.equals("*")) return towns;

        if (search.length() < 2) throw new NotFoundException();

        List<String> ret = towns.stream().filter(ville -> ville.toUpperCase().contains(search.toUpperCase())).collect(Collectors.toList());

        return ret;

    }



}
