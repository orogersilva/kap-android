package com.orogersilva.kap.domain.model;

/**
 * Created by orogersilva on 12/28/2016.
 */

public class LatLng {

    // region FIELDS

    private double lat;
    private double lng;

    private final double ERROR_MARGIN = 0.00001;

    // endregion

    // region CONSTRUCTORS

    public LatLng(double lat, double lng) {

        this.lat = lat;
        this.lng = lng;
    }

    // endregion

    // region GETTERS AND SETTERS

    public double getLat() {

        return lat;
    }

    public double getLng() {

        return lng;
    }

    // endregion

    // region OVERRIDED METHODS


    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LatLng latLng = (LatLng) o;

        return Math.abs(lat - latLng.getLat()) < ERROR_MARGIN &&
                Math.abs(lng - latLng.getLng()) < ERROR_MARGIN;
    }

    // endregion
}
