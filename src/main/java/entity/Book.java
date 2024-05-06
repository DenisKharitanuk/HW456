package entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;


@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "book")
public class Book implements Serializable {

    @jakarta.persistence.Id
    @jakarta.persistence.Column(name = "id")
    private long id;

    @jakarta.persistence.Column(name = "book_title")
    private String bookTitle;

    @jakarta.persistence.Column(name = "author_id")
    private long authorId;

    @Column(name = "updated")
    private Date updated;
}
