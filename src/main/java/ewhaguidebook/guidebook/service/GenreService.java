package ewhaguidebook.guidebook.service;

import ewhaguidebook.guidebook.dto.GenreDTO;
import ewhaguidebook.guidebook.entity.GenreEntity;
import ewhaguidebook.guidebook.repository.GenreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GenreService {
    private final GenreRepository genreRepository;

    public void save(GenreDTO genreDTO) {
        /*
            1. dto -> entity 변환
            2. repository의 save 메서드 호출
         */
        GenreEntity genreEntity = GenreEntity.toGenreEntity(genreDTO);
        genreRepository.save(genreEntity);
        // repository의 save 메서드 호출 (조건 - entity 객체를 넘겨줘야 함)
    }

    public GenreEntity findByGenreName(String genreName) {
        return genreRepository.findByGenreName(genreName);
    }

}
