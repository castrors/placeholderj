package com.example.jackmiras.placeholderj.library;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import retrofit.RetrofitError;

/**
 * Created by jackmiras on 03/10/15.
 */
public class PlaceHolderJ {

    private final View view;

    private PlaceHolderManager placeHolderManager;
    private Context context;

    private View viewContainer = null;
    public View viewLoading = null;
    public ViewGroup viewEmpty = null;
    public ImageView viewEmptyImage = null;
    public TextView viewEmptyMessage = null;
    public Button viewEmptyTryAgainButton = null;
    public ViewGroup viewError = null;
    public ImageView viewErrorImage = null;
    public TextView viewErrorMessage = null;
    public Button viewErrorTryAgainButton = null;
    private boolean isLoadingViewBeingShown;
    private boolean isErrorViewBeingShown;
    private boolean isEmptyViewBeingShown;
    private boolean viewsAreCustomized;

    /**
     * @param activity           The activity used to find the view with the viewId and the placeholders in the init method
     * @param viewId             The view that will have the placeholders
     * @param placeHolderManager The instance of PlaceHolderManager that will be used to customize PlaceHolderJ views
     */
    public PlaceHolderJ(Activity activity, int viewId, PlaceHolderManager placeHolderManager) {
        this(activity.getWindow().getDecorView(), viewId, placeHolderManager);
    }

    /**
     * @param view               The view used to find the view with the viewId and the placeholders in the init method
     * @param viewId             The view that will have the placeholders
     * @param placeHolderManager The instance of PlaceHolderManager that will be used to customize PlaceHolderJ views
     */
    public PlaceHolderJ(View view, int viewId, PlaceHolderManager placeHolderManager) {
        this(view, viewId);
        this.placeHolderManager = placeHolderManager;
    }

    /**
     * @param activity The activity used to find the view with the viewId and the placeholders in the init method
     * @param viewId   The view that will have the placeholders
     */
    public PlaceHolderJ(Activity activity, int viewId) {
        this(activity.getWindow().getDecorView(), viewId);
    }

    /**
     * @param view   The view used to find the view with the viewId and the placeholders in the init method
     * @param viewId The view that will have the placeholders
     */
    public PlaceHolderJ(View view, int viewId) {
        this.view = view;
        findContainerView(viewId);
    }

    private void findContainerView(int viewId) {
        viewContainer = view.findViewById(viewId);
        if (viewContainer == null) {
            throw new NullPointerException("Unable to access Container View. You should pass the view that will be replaced by PlaceHolderJ views");
        }
    }


    /**
     * Called when a instance of this class is created and needs to be initialized. The init method will get all views with
     * ids in viewsId using the Activity/View passed in the constructor
     * @param viewsId ids of the placeholder views
     */
    public void init(int... viewsId) {
        context = view.getContext();
        for (int aViewsId : viewsId) {
            if (aViewsId == R.id.view_loading) {
                viewLoading = view.findViewById(R.id.view_loading);
            } else if (aViewsId == R.id.view_empty) {
                viewEmpty = (ViewGroup) view.findViewById(R.id.view_empty);
                viewEmptyImage = (ImageView) view.findViewById(R.id.imageview_empty_icon);
                viewEmptyMessage = (TextView) view.findViewById(R.id.textview_empty_message);
                viewEmptyTryAgainButton = (Button) view.findViewById(R.id.button_empty_try_again);
            } else if (aViewsId == R.id.view_error) {
                viewError = (ViewGroup) view.findViewById(R.id.view_error);
                viewErrorImage = (ImageView) view.findViewById(R.id.imageview_error_icon);
                viewErrorMessage = (TextView) view.findViewById(R.id.textview_error_message);
                viewErrorTryAgainButton = (Button) view.findViewById(R.id.button_error_try_again);
            }
        }
        if (viewEmpty == null && viewError == null && viewLoading == null) {
            throw new NullPointerException("Unable to access Empty View, Error View or Loading View. You should pass at least one placeholder view to init PlaceHolderJ");
        }
        customizeViews();
    }

    private void customizeViews() {
        if (placeHolderManager != null && !viewsAreCustomized) {
            CustomizeViews customizeViews = new CustomizeViews(placeHolderManager);
            customizeViews.customize(context, viewLoading, viewEmpty, viewEmptyImage, viewEmptyMessage, viewEmptyTryAgainButton, viewError, viewErrorImage, viewErrorMessage, viewErrorTryAgainButton);
            viewsAreCustomized = true;
        }
    }

    private void setViewVisibility(View view, int visibility) {
        if (view != null) {
            view.setVisibility(visibility);
        }
    }

    /**
     * Makes the loading view visible if the loading view was added to your layout.
     */
    public void showLoading() {
        if (viewLoading == null) {
            throw new NullPointerException("Unable to access Loading View, check if the loading view was initialized");
        } else {
            isLoadingViewBeingShown = true;
            changeViewsVisibility();
            setViewVisibility(viewLoading, View.VISIBLE);
        }
    }

    /**
     * Makes the empty view visible if the empty view was added to your layout.
     *
     * @param messageRes      The message that will be shown in the empty view.
     * @param onClickListener The action that will be performed by the try again button present in empty view layout.
     */
    public void showEmpty(int messageRes, View.OnClickListener onClickListener) {
        if (viewLoading == null) {
            throw new NullPointerException("Unable to access Empty View, check if the empty view was initialized.");
        } else {
            if (!viewsAreCustomized) {
                viewEmptyMessage.setText(messageRes);
            }
            showEmpty(onClickListener);
        }
    }

    /**
     * Makes the empty view visible if the empty view was added to your layout.
     *
     * @param onClickListener The action that will be performed by the try again button present in empty view layout.
     */
    public void showEmpty(View.OnClickListener onClickListener) {
        isEmptyViewBeingShown = true;
        changeViewsVisibility();
        if (onClickListener == null) {
            viewEmptyTryAgainButton.setVisibility(View.GONE);
        } else {
            viewEmptyTryAgainButton.setVisibility(View.VISIBLE);
            viewEmptyTryAgainButton.setOnClickListener(onClickListener);
        }
        setViewVisibility(viewEmpty, View.VISIBLE);
    }

    /**
     * Makes the error view visible if the error view was added to your layout.
     *
     * @param error           The retrofit error from one of your application requests.
     * @param onClickListener The action that will be performed by the try again button present in error view layout.
     */
    public void showError(RetrofitError error, View.OnClickListener onClickListener) {
        if (viewLoading == null) {
            throw new NullPointerException("Unable to access Error View, check if the error view was initialized.");
        } else {
            isErrorViewBeingShown = true;
            changeViewsVisibility();
            if (!viewsAreCustomized) {
                boolean isNetworkError = (error != null && error.getKind() == RetrofitError.Kind.NETWORK);
                viewErrorImage.setImageResource(isNetworkError ? R.drawable.icon_error_network : R.drawable.icon_error_unknown);
                viewErrorMessage.setText(isNetworkError ? R.string.global_network_error : R.string.global_unknown_error);
            }
            viewErrorTryAgainButton.setOnClickListener(onClickListener);
            setViewVisibility(viewError, View.VISIBLE);
        }
    }

    /**
     * Makes the loading view invisible if the loading view was added to your layout.
     */
    public void hideLoading() {
        if (viewLoading == null) {
            throw new NullPointerException("Unable to access Loading View, check if the loading view was initialized");
        } else {
            isLoadingViewBeingShown = false;
            changeViewsVisibility();
            setViewVisibility(viewLoading, View.GONE);
        }
    }

    /**
     * Makes the empty view invisible if the loading view was added to your layout.
     */
    public void hideEmpty() {
        if (viewLoading == null) {
            throw new NullPointerException("Unable to access Empty View, check if the empty view was initialized.");
        } else {
            isEmptyViewBeingShown = false;
            changeViewsVisibility();
            setViewVisibility(viewEmpty, View.GONE);
        }
    }

    /**
     * Makes the empty view invisible if the loading view was added to your layout.
     */
    public void hideError() {
        if (viewLoading == null) {
            throw new NullPointerException("Unable to access Error View, check if the error view was initialized.");
        } else {
            isErrorViewBeingShown = false;
            changeViewsVisibility();
            setViewVisibility(viewError, View.GONE);
        }
    }

    private void changeViewsVisibility() {
        if (!isLoadingViewBeingShown && viewLoading.getVisibility() == View.VISIBLE) {
            setViewVisibility(viewLoading, View.GONE);
        }
        if (!isEmptyViewBeingShown && viewEmpty.getVisibility() == View.VISIBLE) {
            setViewVisibility(viewEmpty, View.GONE);
        }
        if (!isEmptyViewBeingShown && viewError.getVisibility() == View.VISIBLE) {
            setViewVisibility(viewError, View.GONE);
        }
        if (isLoadingViewBeingShown || isEmptyViewBeingShown || isErrorViewBeingShown) {
            setViewVisibility(viewContainer, View.GONE);
        }
        if (!isLoadingViewBeingShown && !isEmptyViewBeingShown && !isErrorViewBeingShown) {
            setViewVisibility(viewContainer, View.VISIBLE);
        }
    }
}