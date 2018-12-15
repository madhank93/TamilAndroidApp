package com.madhank93.android.tamilapp;

public class Word {

    private String mTamilTranslation;
    private String mDefaultTranslation;
    private int mImageResourceID = HAS_NO_IMAGE;
    private int mAudioResourceID = HAS_NO_AUDIO;
    private static final int HAS_NO_IMAGE = -1;
    private static final int HAS_NO_AUDIO = -1;

    public Word (String mdefaultTranslation, String mtamilTranslation, int mImageResourceID) {
        this.mTamilTranslation = mtamilTranslation;
        this.mDefaultTranslation = mdefaultTranslation;
        this.mImageResourceID = mImageResourceID;
    }

    public Word (String mdefaultTranslation, String mtamilTranslation, int mImageResourceID, int mAudioResourceID) {
        this.mTamilTranslation = mtamilTranslation;
        this.mDefaultTranslation = mdefaultTranslation;
        this.mImageResourceID = mImageResourceID;
        this.mAudioResourceID = mAudioResourceID;
    }

    public Word (String mdefaultTranslation, String mtamilTranslation) {
        this.mTamilTranslation = mtamilTranslation;
        this.mDefaultTranslation = mdefaultTranslation;
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

    public boolean hasImage(){
        return mImageResourceID != HAS_NO_IMAGE;
    }

    public int getmAudioResourceID() {
        return mAudioResourceID;
    }

    public boolean hasAudio() {
        return mAudioResourceID != HAS_NO_AUDIO;
    }

}
