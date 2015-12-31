package fenghuang.bookbot.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Status implements Serializable {
	public enum STATUS {
		UNTOUCHED(1), STARTED(2), STOPPED(3), FINISHED(4), ABANDONED(5);
		int level;

		private STATUS(int level) {
			this.level = level;
		}
	}

	private static final long serialVersionUID = -6015081214454199899L;
	@Id
	@GeneratedValue
	private int id;
	private String text;
	@ManyToMany(mappedBy = "statuses")
	private Collection<Book> books;

	public Status() {
	}

	public Status(int id, String text, Collection<Book> books) {
		super();
		this.id = id;
		this.text = text;
		this.books = books;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Collection<Book> getBooks() {
		return books;
	}

	public void setBooks(Collection<Book> books) {
		this.books = books;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((text == null) ? 0 : text.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Status))
			return false;
		Status other = (Status) obj;
		if (id != other.id)
			return false;
		if (text == null) {
			if (other.text != null)
				return false;
		} else if (!text.equals(other.text))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Status [id=").append(id).append(", text=").append(text).append("]");
		return builder.toString();
	}

}
