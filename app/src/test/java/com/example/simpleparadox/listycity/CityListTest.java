package com.example.simpleparadox.listycity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CityListTest {
    
    

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();

        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testRemove() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getSize());
        City city1 = new City("Gazipur", "Dhaka");
        cityList.add(city1);
        City city2 = new City("Jashore", "Khulna");
        cityList.add(city2);
        assertEquals(3, cityList.getSize());

        cityList.remove(city2);
        assertEquals(2, cityList.getSize());
        assertFalse(cityList.getCities().contains(city2));

    }

    @Test
    void testRemoveException() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getSize());
        City city1 = new City("Banderban", "Chattogram");
        cityList.add(city1);
        City city2 = new City("Pabna", "Rajshahi");
        cityList.add(city2);

        assertEquals(3, cityList.getSize());

        cityList.remove(city1);
        assertEquals(2, cityList.getSize());

        assertThrows(IllegalArgumentException.class, ()-> {
            cityList.remove(city1);
        });

    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }


    @Test
    void testGetSize() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getSize());

        City city1 = new City("Banderban", "Chattogram");
        cityList.add(city1);
        City city2 = new City("Pabna", "Rajshahi");
        cityList.add(city2);

        assertEquals(3, cityList.getSize());

    }
}