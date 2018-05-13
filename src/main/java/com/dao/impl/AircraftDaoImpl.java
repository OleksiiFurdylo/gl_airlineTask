package com.dao.impl;

import com.aircrafts.Aircraft;
import com.aircrafts.aircraftType.planes.CargoAirplane;
import com.aircrafts.aircraftType.planes.PassengerAirplane;
import com.templates.AircraftLoadTemplate;
import com.dao.AircraftDao;
import com.exceptions.NoSuchAircraftType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by OleksiiF on 10.05.2018.
 */
@Repository
public class AircraftDaoImpl implements AircraftDao {
    private Connection conn;

    @Autowired
    public AircraftDaoImpl(DataSource dataSource) {
        try {
            this.conn = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String addAircraft(Aircraft aircraft) {
        int checkId = 0;

        try {
            AircraftLoadTemplate aircraftLoad = new AircraftLoadTemplate();
            aircraft.fillAircraftLoadFromAircraft(aircraft, aircraftLoad);


            PreparedStatement st = conn.prepareStatement(
                    "INSERT INTO airplane (name, cargo_volume, passenger_quantity, fuel_capacity, range, " +
                            "serial_number, fuel_consumption, load_weight, company_id, type) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            st.setString(1, aircraft.getName());
            st.setDouble(2, aircraftLoad.getCargoVolume());
            if(aircraftLoad.getPassengerQuantity() == 0) {
                st.setNull(3, 0);
            } else {
                st.setInt(3, aircraftLoad.getPassengerQuantity());
            }
            st.setInt(4, aircraft.getFuelCapacity());
            st.setInt(5, aircraft.getRange());
            st.setString(6, aircraft.getSerialNumber());
            st.setInt(7, aircraft.getFuelConsumption());
            if (aircraftLoad.getMaxLoadWeight()==0) {
                st.setNull(8, 0);
            } else {
                st.setInt(8, aircraftLoad.getMaxLoadWeight());
            }
            st.setInt(9, aircraft.getCompanyId());
            st.setString(10, aircraft.getType());

            st.executeUpdate();

            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM airplane WHERE serial_number = \""+aircraft.getSerialNumber()+"\"");
            checkId = rs.getInt("id");

            st.close();
            statement.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "inserted successfully with id: "+checkId+" (if 0 - unsuccessfully)";
    }

    @Override
    public void deleteAircraft(int id) {
        try {
            Statement st = conn.createStatement();
            st.execute("DELETE FROM airplane WHERE id = "+ id);

            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editAircraft(Aircraft aircraft) {
        try {
            AircraftLoadTemplate aircraftLoad = new AircraftLoadTemplate();
            aircraft.fillAircraftLoadFromAircraft(aircraft, aircraftLoad);

            PreparedStatement st = conn.prepareStatement("UPDATE airplane SET " +
                    "name = ?, cargo_volume = ?, passenger_quantity = ?, fuel_capacity = ?," +
                    "range = ?, serial_number = ?, fuel_consumption = ?, load_weight = ?, company_id = ?, type = ? " +
                    " WHERE serial_number =?");

            st.setString(1, aircraft.getName());
            System.out.println("---------------"+ aircraft.getName()+" in dao");
            st.setDouble(2, aircraftLoad.getCargoVolume());
            if(aircraftLoad.getPassengerQuantity() == 0) {
                st.setNull(3, 0);
            } else {
                st.setInt(3, aircraftLoad.getPassengerQuantity());
            }
            st.setInt(4, aircraft.getFuelCapacity());
            st.setInt(5, aircraft.getRange());
            st.setString(6, aircraft.getSerialNumber());
            st.setInt(7, aircraft.getFuelConsumption());
            if (aircraftLoad.getMaxLoadWeight()==0) {
                st.setNull(8, 0);
            } else {
                st.setInt(8, aircraftLoad.getMaxLoadWeight());
            }
            st.setInt(9, aircraft.getCompanyId());
            st.setString(10, aircraft.getType());
            st.setString(11, aircraft.getSerialNumber());


            st.executeUpdate();
            st.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Aircraft getAircraft(int id) {
        Aircraft airplane = null;

        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM airplane WHERE id="+id);
            ResultSet rs = st.executeQuery();

            airplane = chooseAndFillAircraft(rs);

            st.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAircraftType noSuchAircraftType) {
            noSuchAircraftType.printStackTrace();
        }

        return airplane;
    }

    private Aircraft chooseAndFillAircraft(ResultSet rs) throws SQLException, NoSuchAircraftType {

        Aircraft airplane;

        if(rs.getString("type").equals("Passenger Aircraft")){
            airplane = new PassengerAirplane();
            return fillAircraftDetails(airplane, rs);
        } else if (rs.getString("type").equals("Cargo Aircraft")){
            airplane = new CargoAirplane();
            return fillAircraftDetails(airplane, rs);
        } else throw new NoSuchAircraftType("no such aircraft type, or type not defined");
    }

    Aircraft fillAircraftDetails(Aircraft airplane, ResultSet rs){
        try {
            AircraftLoadTemplate aircraftLoad = new AircraftLoadTemplate();

            airplane.setId(rs.getInt("id"));
            airplane.setName(rs.getString("name"));

            aircraftLoad.setCargoVolume(rs.getDouble("cargo_volume"));
            aircraftLoad.setPassengerQuantity(rs.getInt("passenger_quantity"));
            aircraftLoad.setMaxLoadWeight(rs.getInt("load_weight"));
            airplane.fillAircraftFromAircraftLoad(airplane, aircraftLoad);

            airplane.setFuelCapacity(rs.getInt("fuel_capacity"));
            airplane.setRange(rs.getInt("range"));
            airplane.setSerialNumber(rs.getString("serial_number"));
            airplane.setFuelConsumption(rs.getInt("fuel_consumption"));
            airplane.setCompanyId(rs.getInt("company_id"));
            airplane.setType(rs.getString("type"));

    } catch (SQLException e) {
        e.printStackTrace();
    }
        return airplane;
    }

    @Override
    public Aircraft getAircraft(String serialNumber) {
        Aircraft airplane = null;

        try {
            PreparedStatement st = conn.prepareStatement("SELECT * FROM airplane WHERE serial_number="+serialNumber);
            ResultSet rs = st.executeQuery();

            airplane = chooseAndFillAircraft(rs);

            st.close();
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAircraftType noSuchAircraftType) {
            noSuchAircraftType.printStackTrace();
        }

        return airplane;
    }

    @Override
    public ArrayList<Aircraft> getAllAircrafts() {
        ArrayList<Aircraft> aircrafts = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM airplane");

           while (rs.next()){
               aircrafts.add(chooseAndFillAircraft(rs));
           }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAircraftType noSuchAircraftType) {
            noSuchAircraftType.printStackTrace();
        }

        return aircrafts;
    }

    @Override
    public ArrayList<Aircraft> getAllAircraftsInCompany(int companyId) {
        ArrayList<Aircraft> aircrafts = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM airplane WHERE company_id = "+ companyId);

            while (rs.next()){
                aircrafts.add(chooseAndFillAircraft(rs));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAircraftType noSuchAircraftType) {
            noSuchAircraftType.printStackTrace();
        }

        return aircrafts;
    }
}
