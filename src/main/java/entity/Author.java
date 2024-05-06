package entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "author")
@Table(name = "author")
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor(force = true)
@Entity
@EqualsAndHashCode
public class Author {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @XmlElement(name = "id", required = true)
    private long id;

    @Column(name = "first_name")
    @XmlElement(name = "first_name", required = true)
    private String firstName;

    @Column(name = "family_name")
    @XmlElement(name = "family_name", required = true)
    private String familyName;

    @Column(name = "second_name")
    @XmlElement(name = "second_name", required = true)
    private String secondName;

    @Column(name = "birth_date")
    @XmlElement(name = "birth_date", required = false)
    private String birthDate;

    public Author(long authorID) {
        this.id = authorID;
    }
}
