package com.service;

import com.aircrafts.Aircraft;
import com.aircrafts.aircraftType.planes.CargoAirplane;
import com.aircrafts.aircraftType.planes.PassengerAirplane;
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
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:application-context-test.xml")
public class AircraftCreationServiceTest {

    @Autowired
    private AircraftCreationService aircraftCreationService;

    private Aircraft aircraft;
    private AircraftLoadTemplate aircraftLoad;

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

        aircraftLoad = new AircraftLoadTemplate();
        aircraftLoad.setCargoVolume(99.9);
        aircraftLoad.setMaxLoadWeight(999);
        aircraftLoad.setPassengerQuantity(90);
        aircraft.fillAircraftFromAircraftLoad(aircraft, aircraftLoad);
    }

    @Test
    public void createPassengerAircraft() throws Exception {
        Aircraft createdAircraft = aircraftCreationService.createPassengerAircraft(aircraft.getName(),
                String.valueOf(aircraftLoad.getCargoVolume()), String.valueOf(aircraftLoad.getPassengerQuantity()),
                aircraft.getFuelCapacity(), aircraft.getRange(), aircraft.getSerialNumber(),
                aircraft.getFuelConsumption(), String.valueOf(aircraftLoad.getMaxLoadWeight()),
                aircraft.getCompanyId());

        Assert.assertEquals(aircraft.getName(), createdAircraft.getName());
        Assert.assertEquals(aircraft.getType(), createdAircraft.getType());

    }
}