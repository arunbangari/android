package org.owntracks.android.ui.welcome.mode;

import android.databinding.Bindable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.owntracks.android.App;
import org.owntracks.android.R;
import org.owntracks.android.injection.scopes.PerFragment;
import org.owntracks.android.support.Preferences;
import org.owntracks.android.ui.base.viewmodel.BaseViewModel;

import javax.inject.Inject;


@PerFragment
public class ModeFragmentViewModel extends BaseViewModel<ModeFragmentMvvm.View> implements ModeFragmentMvvm.ViewModel<ModeFragmentMvvm.View> {


    private final Preferences preferences;

    private int checkedButtonId = R.id.radioModeMqttPublic;

    @Inject
    public ModeFragmentViewModel(Preferences preferences) {
        this.preferences = preferences; 
    }

    public void attachView(@NonNull ModeFragmentMvvm.View view, @Nullable Bundle savedInstanceState) {
        super.attachView(view, savedInstanceState);
    }

    @Override
    @Bindable
    public int getCheckedButton() {
        return checkedButtonId;
    }

    @Override
    @Bindable
    public void setCheckedButton(int buttonId) {
        this.checkedButtonId = buttonId;
        notifyChange();
    }

    @Override
    public void onNextClicked() {
        switch (this.checkedButtonId) {
            case R.id.radioModeHttpPrivate:
                preferences.setMode(App.MODE_ID_HTTP_PRIVATE, true);
                break;
            case R.id.radioModeMqttPrivate:
                preferences.setMode(App.MODE_ID_MQTT_PRIVATE, true);
                break;
            case R.id.radioModeMqttPublic:
                preferences.setMode(App.MODE_ID_MQTT_PUBLIC, true);
                break;
        }
        preferences.setSetupCompleted();
    }

    @Override
    @Bindable
    public boolean isNextEnabled() {
        return true;
    }

    @Override
    public void setNextEnabled(boolean enabled) {

    }


}
