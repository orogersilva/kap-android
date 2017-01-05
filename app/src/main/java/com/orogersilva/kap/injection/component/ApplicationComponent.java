package com.orogersilva.kap.injection.component;

import android.content.Context;

import com.orogersilva.kap.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by orogersilva on 1/2/2017.
 */
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    // region METHODS

    Context getContext();

    // endregion
}
