package ru.vegadev.Entity;

import java.util.Objects;

public class Tags {

    private long news_ID;
    private String tags;

    public long getNews_ID() {
        return news_ID;
    }

    public void setNews_ID(long news_ID) {
        this.news_ID = news_ID;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tags tags1 = (Tags) o;
        return news_ID == tags1.news_ID &&
                Objects.equals(tags, tags1.tags);
    }

    @Override
    public int hashCode() {

        return Objects.hash(news_ID, tags);
    }

    @Override
    public String toString() {
        return "Tags{" +
                "news_ID=" + news_ID +
                ", tags='" + tags + '\'' +
                '}';
    }
}
