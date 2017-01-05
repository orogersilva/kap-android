package com.orogersilva.kap.domain.usecase.impl;

import com.orogersilva.kap.domain.executor.Executor;
import com.orogersilva.kap.domain.executor.MainThread;
import com.orogersilva.kap.domain.model.LatLng;
import com.orogersilva.kap.domain.repository.RouteRepository;
import com.orogersilva.kap.domain.usecase.GetRoutesUseCase;
import com.orogersilva.kap.domain.usecase.base.AbstractUseCase;
import com.orogersilva.kap.shared.data.RouteDataSource;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by orogersilva on 12/28/2016.
 */

public class GetRoutesImpl extends AbstractUseCase implements GetRoutesUseCase {

    // region FIELDS

    private RouteRepository mRouteRepository;
    private GetRoutesUseCase.Callback mCallback;

    // endregion

    // region CONSTRUCTORS

    @Inject
    public GetRoutesImpl(Executor threadExecutor, MainThread mainThread,
                         RouteRepository routeRepository, Callback callback) {

        super(threadExecutor, mainThread);

        mRouteRepository = routeRepository;
        mCallback = callback;
    }

    // endregion

    // region OVERRIDED METHODS

    @Override
    public void run() {

        mRouteRepository.getRoutes(new RouteDataSource.LoadRouteCallback() {

            @Override
            public void onRoutesLoaded(final List<List<LatLng>> routes) {

                mMainThread.post(new Runnable() {

                    @Override
                    public void run() {

                        mCallback.onRoutesLoaded(routes);
                    }
                });
            }

            @Override
            public void onDataNotAvailable() {

                mMainThread.post(new Runnable() {

                    @Override
                    public void run() {

                        mCallback.onDataNotAvailable();
                    }
                });
            }
        });
    }

    // endregion
}
