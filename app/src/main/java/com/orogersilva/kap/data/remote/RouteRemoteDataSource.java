package com.orogersilva.kap.data.remote;

import com.orogersilva.kap.domain.model.LatLng;
import com.orogersilva.kap.shared.data.RouteDataSource;

import java.util.List;

import javax.inject.Singleton;

/**
 * Created by orogersilva on 1/2/2017.
 */

@Singleton
public class RouteRemoteDataSource implements RouteDataSource {

    // region CONSTRUCTORS

    public RouteRemoteDataSource() {}

    // endregion

    // region OVERRIDED METHODS

    @Override
    public void getRoutes(LoadRouteCallback callback) {


    }

    @Override
    public void saveRoutes(List<List<LatLng>> routes) {

    }

    @Override
    public int deleteAllRoutes() {
        return 0;
    }

    // endregion
}
