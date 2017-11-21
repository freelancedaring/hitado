package org.hitado.model.book;

import java.math.BigInteger;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Author {

    private BigInteger id;
    private String name;
    private Set<Book> books;

    @Override
    public boolean equals(Object obj) {
        if (this == null || obj == null) {
            return false;
        }
        if (!(obj instanceof Author)) {
            return false;
        }
        if (this == obj) {
            return true;
        }

        return getId().equals(((Author) obj).getId());

    }

    @OneToMany(mappedBy = "author")
    public Set<Book> getBooks() {
        return books;
    }

    @Id
    public BigInteger getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return (id == null ? BigInteger.ZERO : getId()).hashCode();
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return getId() + "-" + getName();
    }
}
