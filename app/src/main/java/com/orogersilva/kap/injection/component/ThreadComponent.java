package com.orogersilva.kap.injection.component;

import com.orogersilva.kap.injection.module.ThreadModule;

import dagger.Component;

/**
 * Created by orogersilva on 12/28/2016.
 */

@Component(modules = {ThreadModule.class})
public interface ThreadComponent {

    // region INJECTORS METHODS



    // endregion
}
