package com.service;

import com.aircrafts.Aircraft;
import com.aircrafts.aircraftType.planes.CargoAirplane;
import com.aircrafts.aircraftType.planes.PassengerAirplane;
import com.dao.AircraftDao;
import com.dao.impl.AircraftDaoImpl;
import com.templates.AircraftLoadTemplate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by OleksiiF on 14.05.2018.
 */
@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AircraftServiceTest {

    private Aircraft aircraft;

    @Autowired
    private AircraftService aircraftService;

    @Autowired
    private AircraftDao aircraftDao;

    @Before
    public void init(){
        aircraft = new CargoAirplane();
        aircraft.setName("Boeing Test");
        aircraft.setCompanyId(9);
        aircraft.setFuelCapacity(9090);
        aircraft.setSerialNumber("9TEST");
        aircraft.setRange(9000);
        aircraft.setFuelConsumption(990);
        aircraft.setType("Cargo Aircraft");

        AircraftLoadTemplate aircraftLoad = new AircraftLoadTemplate();
        aircraftLoad.setCargoVolume(99.9);
        aircraftLoad.setMaxLoadWeight(999);
        aircraftLoad.setPassengerQuantity(90);
        aircraft.fillAircraftFromAircraftLoad(aircraft, aircraftLoad);
    }


    @Test
    public void addAircraft() throws Exception {
        String actual = aircraftService.addAircraft(aircraft);
        String expected = "inserted successfully with id: " +
                aircraftDao.getAircraft("9TEST").getId()+" (if 0 - unsuccessfully)";

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void findAircratfByFuelConsumption() throws Exception {
        int actual = aircraftService.findAircratfByFuelConsumption(500, 5000).size();
        int expected = 2;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void findAircraftWhithSpecifiedPassengerCapacityAndFlightRange() throws Exception {
        int actual =  aircraftService.findAircraftWhithSpecifiedPassengerCapacityAndFlightRange(200, 600, 15000, 20000).size();
        int expected = 1;

        Assert.assertEquals(expected, actual);
    }

}