package ru.vegd.entity;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Objects;
@Component("news")
public class New {

    private long news_id;
    private long author_id;
    private String tittle;
    private String news_text;
    private Timestamp public_date;

    public New(long news_id, long author_id, String tittle, String news_text, Timestamp public_date) {
        this.news_id = news_id;
        this.author_id = author_id;
        this.tittle = tittle;
        this.news_text = news_text;
        this.public_date = public_date;
    }

    public New() {}

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

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getNews_text() {
        return news_text;
    }

    public void setNews_text(String news_text) {
        this.news_text = news_text;
    }

    public Timestamp getPublic_date() {
        return public_date;
    }

    public void setPublic_date(Timestamp public_date) {
        this.public_date = public_date;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        New aNew = (New) o;
        return news_id == aNew.news_id &&
                author_id == aNew.author_id &&
                Objects.equals(tittle, aNew.tittle) &&
                Objects.equals(news_text, aNew.news_text) &&
                Objects.equals(public_date, aNew.public_date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(news_id, author_id, tittle, news_text, public_date);
    }

    @Override
    public String toString() {
        return "New{" +
                "news_id=" + news_id +
                ", author_id=" + author_id +
                ", tittle='" + tittle + '\'' +
                ", news_text='" + news_text + '\'' +
                ", public_date=" + public_date +
                '}';
    }
}
