package com.orogersilva.kap.data.local;

import android.content.Context;
import android.support.annotation.NonNull;

import com.orogersilva.kap.domain.model.LatLng;
import com.orogersilva.kap.shared.data.RouteDataSource;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by orogersilva on 1/2/2017.
 */

@Singleton
public class RouteLocalDataSource implements RouteDataSource {

    // region FIELDS

    private Context mContext;

    // endregion

    // region CONSTRUCTORS

    @Inject
    public RouteLocalDataSource(@NonNull Context context) {

        mContext = context;
    }

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
