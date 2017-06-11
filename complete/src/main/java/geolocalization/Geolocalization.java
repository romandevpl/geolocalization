package geolocalization;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Geolocalization {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private double altitude;
    private double latitude;

    protected Geolocalization() {}

    public Geolocalization(double altitude, double latitude) {
        this.altitude = altitude;
        this.latitude = latitude;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return String.format(
                "Geolocalization[id=%d, altitude='%.6f', latitude='%.6f']",
                id, altitude, latitude);
    }
}
