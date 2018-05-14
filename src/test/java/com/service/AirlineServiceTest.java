package com.service;

import com.aircrafts.Aircraft;
import com.templates.TotalCapacityTemplate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by OleksiiF on 14.05.2018.
 */
@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AirlineServiceTest {

    @Autowired
    private AirlineService airlineService;

    @Test
    public void getAllAircraftsInCompany() throws Exception {
        int actual = airlineService.getAllAircraftsInCompany(1).size();
        int expected = 6;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calculateTotalAndCarryingCapacity() throws Exception {
        TotalCapacityTemplate totalCapacityTemplate = airlineService.calculateTotalAndCarryingCapacity(1);

        Assert.assertEquals(1233.0, totalCapacityTemplate.getTotalCargoVolumeInCargoA(), 0.1);
        Assert.assertEquals(415.4, totalCapacityTemplate.getTotalCargoVolumeInPassanger(), 0.1);
        Assert.assertEquals(772331.0, totalCapacityTemplate.getTotalFuelCapacity(), 0.1);
        Assert.assertEquals(367125.0, totalCapacityTemplate.getTotalMaxLoadWeight(), 0.1);
        Assert.assertEquals(1149.0, totalCapacityTemplate.getTotalPassengerQuantity(), 0.1);


    }

    @Test
    public void sortAircraftsByRange() throws Exception {
        ArrayList<Aircraft> aircrafts = airlineService.sortAircraftsByRange(1);

        Assert.assertEquals("Cessna CitationJet", aircrafts.get(0).getName());
        Assert.assertEquals("Airbus A320", aircrafts.get(1).getName());
        Assert.assertEquals("McDonnell Douglas MD-11", aircrafts.get(2).getName());
        Assert.assertEquals("Boeing 777 Freighter", aircrafts.get(3).getName());
        Assert.assertEquals("Boeing 787-8", aircrafts.get(4).getName());

    }

}