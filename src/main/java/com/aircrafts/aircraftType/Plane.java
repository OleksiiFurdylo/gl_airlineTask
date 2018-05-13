package com.aircrafts.aircraftType;

import com.aircrafts.Aircraft;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by OleksiiF on 09.05.2018.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Plane extends Aircraft {
    private int runwayLength;

    public int getRunwayLength() {
        return runwayLength;
    }

    public void setRunwayLength(int runwayLength) {
        this.runwayLength = runwayLength;
    }
}
