package com.example.android.tamilapp;

public class Word {

    private String mTamilTranslation;
    private String mDefaultTranslation;
    private int mImageResourceID;

    public Word (String mdefaultTranslation, String mtamilTranslation, int mImageResourceID) {
        this.mTamilTranslation = mtamilTranslation;
        this.mDefaultTranslation = mdefaultTranslation;
        this.mImageResourceID = mImageResourceID;
    }

    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the Tamil translation of the word.
     */
    public String getTamilTranslation() {
        return mTamilTranslation;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return mImageResourceID;
    }
}
