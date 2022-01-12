package com.example.simpleparadox.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if the city does not exist
     * @param city
     *      This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This removes a city from the list if it exists
     * @param city
     *      This is the city that needs to be removed
     */
    public void remove(City city){
        if(cities.contains(city)){
            cities.remove(city);
        }
        else{
            throw new IllegalArgumentException();
        }
    }

    /**
     * This returns a sorted list of cities
     * @return
     *      Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }


    /**
     * This returns the size of the list
     * @return
     *      Return the size of the list
     */
    public int getSize() {
        return cities.size();
    }

}
