package ewhaguidebook.guidebook.entity;

import ewhaguidebook.guidebook.dto.GenreDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
public class GenreEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = false)
    private String genreName;

    @ManyToMany
    @JoinTable(
            name = "member_genres",
            joinColumns = @JoinColumn(name = "genre_id"),
            inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private List<MemberEntity> members;

    public static GenreEntity toGenreEntity(GenreDTO genreDTO) {
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setId(genreDTO.getId());
        genreEntity.setGenreName(genreDTO.getGenreName());
        return genreEntity;
    }

    public static GenreEntity toUpdateGenreEntity(GenreDTO genreDTO) {
        GenreEntity genreEntity = new GenreEntity();
        genreEntity.setId(genreDTO.getId());
        genreEntity.setGenreName(genreDTO.getGenreName());
        return genreEntity;
    }
}
