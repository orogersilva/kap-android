package com.orogersilva.kap.injection.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by orogersilva on 1/2/2017.
 */
@Module
public class ApplicationModule {

    // region FIELDS

    private final Context mContext;

    // endregion

    // region CONSTRUCTORS

    public ApplicationModule(Context context) {

        mContext = context;
    }

    // endregion

    // region PROVIDERS

    @Provides public Context provideContext() {

        return mContext;
    }

    // endregion
}
