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
import javax.persistence.OneToMany;

/**
 * @author anand.hemadri
 *
 */
@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany
    @JoinColumn(name = "publisher_id")
    private Set<Book> books = new HashSet<>();

    /**
     * 
     */
    public Publisher() {

    }

    /**
     * @param name
     */
    public Publisher(String name) {
	super();
	this.name = name;
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
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
	this.name = name;
    }

    /**
     * @return the books
     */
    public Set<Book> getBooks() {
	return books;
    }

    /**
     * @param books the books to set
     */
    public void setBooks(Set<Book> books) {
	this.books = books;
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
	if (!(obj instanceof Publisher)) {
	    return false;
	}
	final Publisher other = (Publisher) obj;
	return Objects.equals(id, other.id);
    }

    @Override
    public String toString() {
	final StringBuilder builder = new StringBuilder();
	builder.append("Publisher [id=").append(id).append(", name=").append(name).append("]");
	return builder.toString();
    }
}
