package com.orogersilva.kap.shared.data;

import com.orogersilva.kap.domain.model.LatLng;

import java.util.List;

/**
 * Created by orogersilva on 12/30/2016.
 */

public interface RouteDataSource {

    // region CALLBACKS

    interface LoadRouteCallback {

        void onRoutesLoaded(List<List<LatLng>> routes);
        void onDataNotAvailable();
    }

    // endregion

    // region METHODS

    void getRoutes(LoadRouteCallback callback);

    void saveRoutes(List<List<LatLng>> routes);

    int deleteAllRoutes();

    // endregion
}
