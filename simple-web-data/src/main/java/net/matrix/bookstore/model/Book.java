/**
 * 
 */
package net.matrix.bookstore.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 * @author anand.hemadri
 *
 */
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    /**
     * Constructs a new instance of {@link Book}.
     */
    public Book() {
	this("", "");
    }

    /**
     * @param title
     * @param isbn
     */
    public Book(String title, String isbn) {
	this.title = title;
	this.isbn = isbn;
    }

    /**
     * @return the id
     */
    public Long getId() {
	return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
	this.id = id;
    }

    /**
     * @return the title
     */
    public String getTitle() {
	return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
	this.title = title;
    }

    /**
     * @return the ISBN
     */
    public String getIsbn() {
	return isbn;
    }

    /**
     * @param isbn the ISBN to set
     */
    public void setIsbn(String isbn) {
	this.isbn = isbn;
    }

    /**
     * @return the publisher
     */
    public Publisher getPublisher() {
	return publisher;
    }

    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(Publisher publisher) {
	this.publisher = publisher;
    }

    /**
     * @return the authors
     */
    public Set<Author> getAuthors() {
	return authors;
    }

    /**
     * @param authors the authors to set
     */
    public void setAuthors(Set<Author> authors) {
	this.authors = authors;
    }

    @Override
    public int hashCode() {
	return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj) {
	    return true;
	}
	if (!(obj instanceof Book)) {
	    return false;
	}
	final Book other = (Book) obj;
	return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
	final StringBuilder builder = new StringBuilder();
	builder.append("Book [id=").append(id).append(", title=").append(title).append(", isbn=").append(isbn)
		.append(", publisher=").append(publisher).append("]");
	return builder.toString();
    }
}
