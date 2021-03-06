package com.example.jackmiras.placeholderj.library;

/**
 * Created by jackson on 12/12/15.
 */
public class PlaceHolderManager {

    public int viewErrorBackgroundColor;
    public int viewErrorBackgroundResource;
    public int viewErrorText;
    public int viewErrorTextSize;
    public int viewErrorTextColor;
    public int viewErrorTryAgainButtonText;
    public int viewErrorTryAgainButtonBackgroundResource;
    public int viewErrorImage;
    public int viewLoadingBackgroundColor;
    public int viewLoadingBackgroundResource;
    public int viewEmptyBackgroundColor;
    public int viewEmptyBackgroundResource;
    public int viewEmptyText;
    public int viewEmptyTextSize;
    public int viewEmptyTextColor;
    public int viewEmptyTryAgainButtonText;
    public int viewEmptyTryAgainButtonBackgroundResource;
    public int viewEmptyImage;

    public PlaceHolderManager(int viewErrorBackgroundColor, int viewErrorBackgroundResource, int viewErrorText, int viewErrorTextSize, int viewErrorTextColor, int viewErrorTryAgainButtonText, int viewErrorTryAgainButtonBackgroundResource, int viewErrorImage, int viewLoadingBackgroundColor, int viewLoadingBackgroundResource, int viewEmptyBackgroundColor, int viewEmptyBackgroundResource, int viewEmptyText, int viewEmptyTextSize, int viewEmptyTextColor, int viewEmptyTryAgainButtonText, int viewEmptyTryAgainButtonBackgroundResource, int viewEmptyImage) {
        this.viewErrorBackgroundColor = viewErrorBackgroundColor;
        this.viewErrorBackgroundResource = viewErrorBackgroundResource;
        this.viewErrorText = viewErrorText;
        this.viewErrorTextSize = viewErrorTextSize;
        this.viewErrorTextColor = viewErrorTextColor;
        this.viewErrorTryAgainButtonText = viewErrorTryAgainButtonText;
        this.viewErrorTryAgainButtonBackgroundResource = viewErrorTryAgainButtonBackgroundResource;
        this.viewErrorImage = viewErrorImage;
        this.viewLoadingBackgroundColor = viewLoadingBackgroundColor;
        this.viewLoadingBackgroundResource = viewLoadingBackgroundResource;
        this.viewEmptyBackgroundColor = viewEmptyBackgroundColor;
        this.viewEmptyBackgroundResource = viewEmptyBackgroundResource;
        this.viewEmptyText = viewEmptyText;
        this.viewEmptyTextSize = viewEmptyTextSize;
        this.viewEmptyTextColor = viewEmptyTextColor;
        this.viewEmptyTryAgainButtonText = viewEmptyTryAgainButtonText;
        this.viewEmptyTryAgainButtonBackgroundResource = viewEmptyTryAgainButtonBackgroundResource;
        this.viewEmptyImage = viewEmptyImage;
    }


    public static class Configurator {
        private static int viewErrorBackgroundColor;
        private static int viewErrorBackgroundResource;
        private static int viewErrorText;
        private static int viewErrorTextSize;
        private static int viewErrorTextColor;
        private static int viewErrorTryAgainButtonText;
        private static int viewErrorTryAgainButtonBackgroundResource;
        private static int viewErrorImage;
        private static int viewLoadingBackgroundColor;
        private static int viewLoadingBackgroundResource;
        private static int viewEmptyBackgroundColor;
        private static int viewEmptyBackgroundResource;
        private static int viewEmptyText;
        private static int viewEmptyTextSize;
        private static int viewEmptyTextColor;
        private static int viewEmptyTryAgainButtonText;
        private static int viewEmptyTryAgainButtonBackgroundResource;
        private static int viewEmptyImage;

        /**
         * Customize the error view background color.
         *
         * @param color The id of the color to be applied to the background.
         */
        public Configurator errorBackgroundColor(int color) {
            viewErrorBackgroundColor = color;
            return this;
        }

        /**
         * Customize the error view background.
         *
         * @param backgroundRes The id of the resource to be applied to the background.
         */
        public Configurator errorBackgroundResource(int backgroundRes) {
            viewErrorBackgroundResource = backgroundRes;
            return this;
        }

        /**
         * Customize the error view text.
         *
         * @param text      Id of the text to be applied.
         * @param textSize  Text size to be applied (in sp).
         * @param textColor The id of the color to be applied to the text.
         */
        public Configurator errorText(int text, int textSize, int textColor) {
            viewErrorText = text;
            viewErrorTextSize = textSize;
            viewErrorTextColor = textColor;
            return this;
        }

        /**
         * Customize the error view button.
         *
         * @param text          Id of the text to be applied.
         * @param backgroundRes Id of the resource to be applied to the background
         */
        public Configurator errorButton(int text, int backgroundRes) {
            viewErrorTryAgainButtonText = text;
            viewErrorTryAgainButtonBackgroundResource = backgroundRes;
            return this;
        }

        /**
         * Customize the error view image.
         *
         * @param imageRes Id of the image to be applied on the error view.
         */
        public Configurator errorImage(int imageRes) {
            viewErrorImage = imageRes;
            return this;
        }

        /**
         * Customize the loading view background.
         *
         * @param color The id of the color to be applied to the background.
         */
        public Configurator loadingBackground(int color) {
            viewLoadingBackgroundColor = color;
            return this;
        }

        /**
         * Customize the loading view background.
         *
         * @param backgroundRes The id of the resource to be applied to the background.
         */
        public Configurator loadingBackgroundResource(int backgroundRes) {
            viewLoadingBackgroundResource = backgroundRes;
            return this;
        }

        /**
         * Customize the empty view background.
         *
         * @param color The id of the color to be applied to the background.
         */
        public Configurator emptyBackground(int color) {
            viewEmptyBackgroundColor = color;
            return this;
        }

        /**
         * Customize the empty view background.
         *
         * @param backgroundRes The id of the resource to be applied to the background.
         */
        public Configurator emptyBackgroundResource(int backgroundRes) {
            viewEmptyBackgroundResource = backgroundRes;
            return this;
        }

        /**
         * Customize the error view text.
         *
         * @param text      Id of the text to be applied.
         * @param textSize  Text size to be applied (in sp).
         * @param textColor The id of the color to be applied to the text.
         */
        public Configurator emptyText(int text, int textSize, int textColor) {
            viewEmptyText = text;
            viewEmptyTextSize = textSize;
            viewEmptyTextColor = textColor;
            return this;
        }

        /**
         * Customize the empty view button.
         *
         * @param text          Id of the text to be applied.
         * @param backgroundRes Id of the resource to be applied to the background
         */
        public Configurator emptyButton(int text, int backgroundRes) {
            viewEmptyTryAgainButtonText = text;
            viewEmptyTryAgainButtonBackgroundResource = backgroundRes;
            return this;
        }

        /**
         * Customize the empty view image.
         *
         * @param imageRes Id of the image to be applied on the empty view.
         */
        public Configurator emptyImage(int imageRes) {
            viewEmptyImage = imageRes;
            return this;
        }

        public PlaceHolderManager config() {
            return new PlaceHolderManager(viewErrorBackgroundColor, viewErrorBackgroundResource, viewErrorText, viewErrorTextSize, viewErrorTextColor, viewErrorTryAgainButtonText, viewErrorTryAgainButtonBackgroundResource, viewErrorImage, viewLoadingBackgroundColor, viewLoadingBackgroundResource, viewEmptyBackgroundColor, viewEmptyBackgroundResource, viewEmptyText, viewEmptyTextSize, viewEmptyTextColor, viewEmptyTryAgainButtonText, viewEmptyTryAgainButtonBackgroundResource, viewEmptyImage);
        }
    }
}
