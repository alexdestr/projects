package ru.vegadev.Entity;

import java.sql.Date;
import java.util.Objects;

public class Comments {

    private long comment_id;
    private long news_id;
    private long author_id;
    private String comment_text;
    private Date sending_date;

    public long getComment_id() {
        return comment_id;
    }

    public void setComment_id(long comment_id) {
        this.comment_id = comment_id;
    }

    public long getNews_id() {
        return news_id;
    }

    public void setNews_id(long news_id) {
        this.news_id = news_id;
    }

    public long getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(long aithor_id) {
        this.author_id = author_id;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public Date getSending_date() {
        return sending_date;
    }

    public void setSending_date(Date sending_date) {
        this.sending_date = sending_date;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comments comments = (Comments) o;
        return comment_id == comments.comment_id &&
                news_id == comments.news_id &&
                Objects.equals(author_id, comments.author_id) &&
                Objects.equals(comment_text, comments.comment_text) &&
                Objects.equals(sending_date, comments.sending_date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(comment_id, news_id, author_id, comment_text, sending_date);
    }

    @Override
    public String toString() {
        return "Comments{" +
                "comment_id=" + comment_id +
                ", news_id=" + news_id +
                ", aithor_id='" + author_id + '\'' +
                ", comment_text='" + comment_text + '\'' +
                ", sending_date=" + sending_date +
                '}';
    }
}
