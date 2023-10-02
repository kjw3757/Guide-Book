package ewhaguidebook.guidebook.dto;

import ewhaguidebook.guidebook.entity.GenreEntity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class GenreDTO {
    private Long id;
    private String genreName;

    public static GenreDTO toGenreDTO(GenreEntity genreEntity) {
        GenreDTO genreDTO = new GenreDTO();
        genreDTO.setId(genreEntity.getId());
        genreDTO.setGenreName(genreEntity.getGenreName());
        return genreDTO;
    }

}
