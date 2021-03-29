package com.example.newsappdemo;

public class News {
    private final String mSection;
    private final String mTitle;
    private final String mDate;
    private final String mNewsUrl;
    private final String mAuthor;
    private final String mThumbnail;

    public News(String section, String title, String date, String newsUrl,
                String author, String thumbnail) {
        this.mSection = section;
        this.mTitle = title;
        this.mDate = date;
        this.mNewsUrl = newsUrl;
        this.mAuthor = author;
        this.mThumbnail = thumbnail;
    }
    /**
     * @return the string of the section's name.
     */
    public String getSection() {
        return mSection;
    }
    /**
     * @return the string of the mTitle's name.
     */
    public String getTitle() {
        return mTitle;
    }
    /**
     * @return the string of the News's date
     */
    public String getDate() {
        return mDate;
    }
    /**
     * @return the string of the mNewsUrl's name.
     */
    public String getNewsUrl() {
        return mNewsUrl;
    }
    /**
     * @return the string of the mAuthor's name
     */
    public String getAuthor() {
        return mAuthor;
    }
    /**
     * @return the string of the mThumbnail's url
     */
    public String getThumbnail() {
        return mThumbnail;
    }
}
