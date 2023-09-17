package ILearn.word.entity;

import ILearn.chapter.entity.Chapter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class WordDescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    private String category;
    @JoinColumn(name = "description")
    @ElementCollection
    @CollectionTable(name = "descriptionArray")
    private List<String> descriptions;

    @ManyToOne
    @JoinColumn(name = "WORDID")
    @JsonIgnore
    private Word word;

    public WordDescription(List<String> descriptions) {
        this.descriptions = descriptions;
    }
}
