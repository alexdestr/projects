package ru.vegd.entity;

import org.springframework.stereotype.Component;

import java.util.Objects;
@Component("tags")
public class Tag {

    private long news_ID;
    private String tags;

    public Tag(long news_ID, String tags) {
        this.news_ID = news_ID;
        this.tags = tags;
    }

    public Tag () {}

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
        Tag tag1 = (Tag) o;
        return news_ID == tag1.news_ID &&
                Objects.equals(tags, tag1.tags);
    }

    @Override
    public int hashCode() {

        return Objects.hash(news_ID, tags);
    }

    @Override
    public String toString() {
        return "Tag{" +
                "news_ID=" + news_ID +
                ", tags='" + tags + '\'' +
                '}';
    }
}
