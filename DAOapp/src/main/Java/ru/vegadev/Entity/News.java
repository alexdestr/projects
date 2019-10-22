package ru.vegadev.Entity;

import java.sql.Date;
import java.util.Objects;

public class News {

    private long news_id;
    private long author_id;
    private String tittle;
    private String news_text;
    private Date public_date;

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

    public Date getPublic_date() {
        return public_date;
    }

    public void setPublic_date(Date public_date) {
        this.public_date = public_date;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return news_id == news.news_id &&
                author_id == news.author_id &&
                Objects.equals(tittle, news.tittle) &&
                Objects.equals(news_text, news.news_text) &&
                Objects.equals(public_date, news.public_date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(news_id, author_id, tittle, news_text, public_date);
    }

    @Override
    public String toString() {
        return "News{" +
                "news_id=" + news_id +
                ", author_id=" + author_id +
                ", tittle='" + tittle + '\'' +
                ", news_text='" + news_text + '\'' +
                ", public_date=" + public_date +
                '}';
    }
}
