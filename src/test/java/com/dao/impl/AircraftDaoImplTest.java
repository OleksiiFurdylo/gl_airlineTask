package com.dao.impl;

import com.aircrafts.Aircraft;
import com.aircrafts.aircraftType.planes.PassengerAirplane;
import com.templates.AircraftLoadTemplate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by OleksiiF on 13.05.2018.
 */
@ContextConfiguration(locations = "classpath:application-context-test.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class AircraftDaoImplTest {

    private Aircraft aircraft;

    @Autowired
    private AircraftDaoImpl aircraftDao;

    @Before
    public void init(){
        aircraft = new PassengerAirplane();
        aircraft.setName("Boeing Test");
        aircraft.setCompanyId(9);
        aircraft.setFuelCapacity(9090);
        aircraft.setSerialNumber("9TEST");
        aircraft.setRange(9000);
        aircraft.setFuelConsumption(990);
        aircraft.setType("Passenger Aircraft");

        AircraftLoadTemplate aircraftLoad = new AircraftLoadTemplate();
        aircraftLoad.setCargoVolume(99.9);
        aircraftLoad.setMaxLoadWeight(999);
        aircraftLoad.setPassengerQuantity(90);
        aircraft.fillAircraftFromAircraftLoad(aircraft, aircraftLoad);
    }

    @Test
    public void addAircraft() throws Exception {

        int aircraftId = aircraftDao.addAircraft(aircraft);
        String expected = aircraft.getName();
        String actual = aircraftDao.getAircraft(aircraftId).getName();


        Assert.assertEquals(expected, actual);
        Assert.assertEquals(aircraft.getFuelCapacity(), aircraftDao.getAircraft(aircraftId).getFuelCapacity());
        Assert.assertEquals(aircraft.getSerialNumber(), aircraftDao.getAircraft(aircraftId).getSerialNumber());

        aircraftDao.deleteAircraft(aircraftId);

    }

    @Test(expected = java.lang.AssertionError.class)
    public void deleteAircraft() throws Exception {

        int aircraftId = aircraftDao.addAircraft(aircraft);
        aircraftDao.deleteAircraft(aircraftId);

        aircraftDao.getAircraft(aircraftId);
        Assert.fail();
    }


    @Test
    public void editAircraft() throws Exception {
        int aircraftId = aircraftDao.addAircraft(aircraft);
        aircraft.setName("changedName");
        aircraftDao.editAircraft(aircraft);

        Assert.assertEquals(aircraft.getName(), aircraftDao.getAircraft(aircraftId).getName());

    }

    @Test
    public void getAircraft() throws Exception {
       int aircraftId = aircraftDao.addAircraft(aircraft);

        String expected = aircraft.getName();
        String actual = aircraftDao.getAircraft(aircraftId).getName();

       Assert.assertEquals(expected, actual);
       Assert.assertEquals(aircraft.getSerialNumber(), aircraftDao.getAircraft(aircraftId).getSerialNumber());
       Assert.assertEquals(aircraft.getFuelConsumption(), aircraftDao.getAircraft(aircraftId).getFuelConsumption());
    }

    @Test
    public void getAllAircrafts() throws Exception {
        int actualSize = aircraftDao.getAllAircrafts().size();
        int expectedSize = 6;

        Assert.assertEquals(actualSize, expectedSize);
    }

    @Test
    public void getAllAircraftsInCompany() throws Exception {
        int actualSize = aircraftDao.getAllAircraftsInCompany(1).size();
        int expectedSize = 6;

        Assert.assertEquals(actualSize, expectedSize);
    }

}