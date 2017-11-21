package org.hitado.model.book;

import java.math.BigInteger;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class Book {

    private Author author;
    private String title;
    private String isbn;
    private BigInteger id;

    @Override
    public boolean equals(Object obj) {
        if (this == null || obj == null) {
            return false;
        }
        if (!(obj instanceof Book)) {
            return false;
        }
        if (this == obj) {
            return true;
        }

        return getId().equals(((Book) obj).getId());
    }

    @ManyToOne
    public Author getAuthor() {
        return author;
    }

    @Id
    public BigInteger getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int hashCode() {
        return (id == null ? BigInteger.ZERO : getId()).hashCode();
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return getIsbn() + "-" + getTitle();
    }

}
