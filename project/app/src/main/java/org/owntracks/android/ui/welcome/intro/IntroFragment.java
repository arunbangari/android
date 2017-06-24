package org.owntracks.android.ui.welcome.intro;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.owntracks.android.R;
import org.owntracks.android.databinding.UiWelcomeIntroBinding;
import org.owntracks.android.ui.base.BaseFragment;
import org.owntracks.android.ui.welcome.WelcomeMvvm;

public class IntroFragment extends BaseFragment<UiWelcomeIntroBinding, IntroFragmentMvvm.ViewModel> implements IntroFragmentMvvm.View {
    public static final int ID = 1;

    private static IntroFragment instance;
    public static Fragment getInstance() {
        if(instance == null)
            instance = new IntroFragment();
        return instance;
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(viewModel == null) { fragmentComponent().inject(this); }
        return setAndBindContentView(inflater, container, R.layout.ui_welcome_intro, savedInstanceState);
    }

    @Override
    public IntroFragmentMvvm.ViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public void setActivityViewModel() {
        WelcomeMvvm.View.class.cast(getActivity()).setFragmentViewModel(viewModel);
    }
}
