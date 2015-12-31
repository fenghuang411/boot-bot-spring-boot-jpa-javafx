package fenghuang.bookbot.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import fenghuang.bookbot.model.Status.STATUS;

@Entity
public class Book implements Serializable {
	private static final long serialVersionUID = -5514434053309802794L;
	@Id
	@GeneratedValue
	private int id;
	private String title;
	private String path;
	private STATUS status;
	@ManyToMany()
	@JoinTable(name = "book_tag",
	           joinColumns = { @JoinColumn(name = "bid") },
	           inverseJoinColumns = { @JoinColumn(name = "tid") })
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<Tag> tags;
	@ManyToMany()
	@JoinTable(name = "book_status",
	           joinColumns = { @JoinColumn(name = "bid") },
	           inverseJoinColumns = { @JoinColumn(name = "sid") })
	@LazyCollection(LazyCollectionOption.FALSE)
	private Collection<Status> statuses;

	public Book() {
	}

	public Book(int id, String title, String path, STATUS status, Collection<Tag> tags, Collection<Status> statuses) {
		super();
		this.id = id;
		this.title = title;
		this.path = path;
		this.status = status;
		this.tags = tags;
		this.statuses = statuses;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}

	public Collection<Tag> getTags() {
		return tags;
	}

	public void setTags(Collection<Tag> tags) {
		this.tags = tags;
	}

	public Collection<Status> getStatuses() {
		return statuses;
	}

	public void setStatuses(Collection<Status> statuses) {
		this.statuses = statuses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((path == null) ? 0 : path.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Book))
			return false;
		Book other = (Book) obj;
		if (id != other.id)
			return false;
		if (path == null) {
			if (other.path != null)
				return false;
		} else if (!path.equals(other.path))
			return false;
		if (status != other.status)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Book [id=").append(id).append(", title=").append(title).append(", path=").append(path)
		        .append(", status=").append(status).append("]");
		return builder.toString();
	}

}
