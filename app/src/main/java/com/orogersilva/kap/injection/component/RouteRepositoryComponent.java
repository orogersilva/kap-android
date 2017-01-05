package com.orogersilva.kap.injection.component;

import com.orogersilva.kap.domain.repository.RouteRepository;
import com.orogersilva.kap.injection.module.ApplicationModule;
import com.orogersilva.kap.injection.module.RouteRepositoryModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by orogersilva on 1/2/2017.
 */
@Singleton
@Component(modules = RouteRepositoryModule.class, dependencies = ApplicationComponent.class)
public interface RouteRepositoryComponent {

    // region METHODS

    RouteRepository getRouteRepository();

    // endregion
}
