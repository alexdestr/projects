package ru.vegd.entity;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Objects;
@Component("comments")
public class Comment {

    private long comment_id;
    private long news_id;
    private long author_id;
    private String comment_text;
    private Timestamp sending_date;

    public Comment(long comment_id, long news_id, long author_id, String comment_text, Timestamp sending_date) {
        this.comment_id = comment_id;
        this.news_id = news_id;
        this.author_id = author_id;
        this.comment_text = comment_text;
        this.sending_date = sending_date;
    }

    public Comment() {}

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

    public void setAuthor_id(long author_id) {
        this.author_id = author_id;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public Timestamp getSending_date() {
        return sending_date;
    }

    public void setSending_date(Timestamp sending_date) {
        this.sending_date = sending_date;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return comment_id == comment.comment_id &&
                news_id == comment.news_id &&
                Objects.equals(author_id, comment.author_id) &&
                Objects.equals(comment_text, comment.comment_text) &&
                Objects.equals(sending_date, comment.sending_date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(comment_id, news_id, author_id, comment_text, sending_date);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "comment_id=" + comment_id +
                ", news_id=" + news_id +
                ", author_id='" + author_id + '\'' +
                ", comment_text='" + comment_text + '\'' +
                ", sending_date=" + sending_date +
                '}';
    }
}
