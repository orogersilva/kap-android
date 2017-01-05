package com.orogersilva.kap.domain.repository;

import android.os.Build;

import com.orogersilva.kap.BuildConfig;
import com.orogersilva.kap.injection.Local;
import com.orogersilva.kap.injection.Remote;
import com.orogersilva.kap.injection.component.ApplicationComponent;
import com.orogersilva.kap.injection.component.RouteRepositoryComponent;
import com.orogersilva.kap.injection.module.ApplicationModule;
import com.orogersilva.kap.injection.module.RouteRepositoryModule;
import com.orogersilva.kap.shared.data.RouteDataSource;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import it.cosenonjaviste.daggermock.DaggerMockRule;
import it.cosenonjaviste.daggermock.InjectFromComponent;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

/**
 * Created by orogersilva on 1/2/2017.
 */

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class RouteRepositoryTest {

    // region FIELDS

    @Rule
    public DaggerMockRule<RouteRepositoryComponent> daggerMockRule = new DaggerMockRule<>(RouteRepositoryComponent.class, new RouteRepositoryModule())
            .addComponentDependency(ApplicationComponent.class, new ApplicationModule(RuntimeEnvironment.application));

    @Mock
    @Local
    RouteDataSource mRouteLocalDataSource;

    @Mock
    @Remote
    RouteDataSource mRouteRemoteDataSource;

    @Mock
    RouteDataSource.LoadRouteCallback mLoadRouteCallback;

    @InjectFromComponent
    RouteRepository mRouteRepository;

    // endregion

    // region TEST METHODS

    @Test
    public void getRoutes_verifyGetRoutesIsCalledFromLocalDataSource() {

        // ARRANGE

        // ACT

        mRouteRepository.getRoutes(mLoadRouteCallback);

        // ASSERT

        verify(mRouteLocalDataSource).getRoutes(any(RouteDataSource.LoadRouteCallback.class));
    }

    // endregion
}
