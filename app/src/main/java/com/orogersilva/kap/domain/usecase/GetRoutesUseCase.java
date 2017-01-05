package com.orogersilva.kap.domain.usecase;

import com.orogersilva.kap.domain.model.LatLng;
import com.orogersilva.kap.domain.usecase.base.UseCase;

import java.util.List;

/**
 * Created by orogersilva on 12/28/2016.
 */

public interface GetRoutesUseCase extends UseCase {

    // region CALLBACK

    interface Callback {

        void onRoutesLoaded(List<List<LatLng>> routes);
        void onDataNotAvailable();
    }

    // endregion
}
