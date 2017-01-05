package com.orogersilva.kap.injection.module;

import android.content.Context;

import com.orogersilva.kap.data.local.RouteLocalDataSource;
import com.orogersilva.kap.data.remote.RouteRemoteDataSource;
import com.orogersilva.kap.injection.Local;
import com.orogersilva.kap.injection.Remote;
import com.orogersilva.kap.shared.data.RouteDataSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by orogersilva on 1/2/2017.
 */

@Module
public class RouteRepositoryModule {

    // region PROVIDERS

    @Local
    @Singleton
    @Provides public RouteDataSource provideRouteLocalDataSource(Context context) {

        return new RouteLocalDataSource(context);
    }

    @Remote
    @Singleton
    @Provides public RouteDataSource provideRouteRemoteDataSource() {

        return new RouteRemoteDataSource();
    }

    // endregion
}
