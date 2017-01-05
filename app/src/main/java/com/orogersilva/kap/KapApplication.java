package com.orogersilva.kap;

import android.app.Application;

import com.orogersilva.kap.injection.component.ApplicationComponent;
import com.orogersilva.kap.injection.component.DaggerApplicationComponent;
import com.orogersilva.kap.injection.module.ApplicationModule;

/**
 * Created by orogersilva on 12/28/2016.
 */

public class KapApplication extends Application {

    // region FIELDS

    private ApplicationComponent mApplicationComponent;

    // endregion

    // region APPLICATION LIFECYCLE METHODS

    @Override
    public void onCreate() {

        super.onCreate();

        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    // endregion

    // region PUBLIC METHODS

    public ApplicationComponent getComponent() {

        return mApplicationComponent;
    }

    // endregion
}
