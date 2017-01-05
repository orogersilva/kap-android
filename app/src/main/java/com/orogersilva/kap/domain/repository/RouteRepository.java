package com.orogersilva.kap.domain.repository;

import com.orogersilva.kap.domain.model.LatLng;
import com.orogersilva.kap.injection.Local;
import com.orogersilva.kap.injection.Remote;
import com.orogersilva.kap.shared.data.RouteDataSource;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by orogersilva on 12/30/2016.
 */

@Singleton
public class RouteRepository implements RouteDataSource {

    // region FIELDS

    private RouteDataSource mRouteLocalDataSource;
    private RouteDataSource mRouteRemoteDataSource;

    // endregion

    // region CONSTRUCTORS

    @Inject
    public RouteRepository(@Local RouteDataSource routeLocalDataSource,
                           @Remote RouteDataSource routeRemoteDataSource) {

        mRouteLocalDataSource = routeLocalDataSource;
        mRouteRemoteDataSource = routeRemoteDataSource;
    }

    // endregion

    // region OVERRIDED METHODS

    @Override
    public void getRoutes(final LoadRouteCallback callback) {

        mRouteLocalDataSource.getRoutes(new LoadRouteCallback() {

            @Override
            public void onRoutesLoaded(List<List<LatLng>> routes) {

                callback.onRoutesLoaded(routes);
            }

            @Override
            public void onDataNotAvailable() {

                getRoutesFromRemoteDataSource(callback);
            }
        });
    }

    @Override
    public void saveRoutes(List<List<LatLng>> routes) {

    }

    @Override
    public int deleteAllRoutes() {
        return 0;
    }

    // endregion

    // region UTILITY METHODS

    private void refreshLocalDataSource(List<List<LatLng>> routes) {

        mRouteLocalDataSource.deleteAllRoutes();
        mRouteLocalDataSource.saveRoutes(routes);
    }

    private void getRoutesFromRemoteDataSource(final LoadRouteCallback callback) {

        mRouteRemoteDataSource.getRoutes(new LoadRouteCallback() {

            @Override
            public void onRoutesLoaded(List<List<LatLng>> routes) {

                // refresh

                refreshLocalDataSource(routes);

                callback.onRoutesLoaded(routes);
            }

            @Override
            public void onDataNotAvailable() {

                callback.onDataNotAvailable();
            }
        });
    }

    // endregion
}
