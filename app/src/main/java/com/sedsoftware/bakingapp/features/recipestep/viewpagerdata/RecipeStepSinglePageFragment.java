package com.sedsoftware.bakingapp.features.recipestep.viewpagerdata;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import com.sedsoftware.bakingapp.R;

public class RecipeStepSinglePageFragment extends Fragment {

  private static final String EXTRA_SHORT_DESCRIPTION_ID = "EXTRA_SHORT_DESCRIPTION_ID";
  private static final String EXTRA_DESCRIPTION_ID = "EXTRA_DESCRIPTION_ID";
  private static final String EXTRA_VIDEO_URL_ID = "EXTRA_VIDEO_URL_ID";

  @BindView(R.id.recipe_step_short_desc)
  TextView shortDescTextView;
  @BindView(R.id.recipe_step_desc)
  TextView descTextView;
  @BindView(R.id.recipe_step_video)
  TextView videoTextView;
  Unbinder unbinder;

  public static RecipeStepSinglePageFragment newInstance(String shortDescription,
      String description, String videoUrl) {
    Bundle arguments = new Bundle();
    arguments.putString(EXTRA_SHORT_DESCRIPTION_ID, shortDescription);
    arguments.putString(EXTRA_DESCRIPTION_ID, description);
    arguments.putString(EXTRA_VIDEO_URL_ID, videoUrl);
    RecipeStepSinglePageFragment fragment = new RecipeStepSinglePageFragment();
    fragment.setArguments(arguments);
    return fragment;
  }

  public RecipeStepSinglePageFragment() {
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_recipe_step_page, container, false);
    unbinder = ButterKnife.bind(this, view);
    return view;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    String shortDescription = getArguments().getString(EXTRA_SHORT_DESCRIPTION_ID);
    String description = getArguments().getString(EXTRA_DESCRIPTION_ID);
    String video = getArguments().getString(EXTRA_VIDEO_URL_ID);

    shortDescTextView.setText(shortDescription);
    descTextView.setText(description);
    videoTextView.setText(video);
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    unbinder.unbind();
  }
}
