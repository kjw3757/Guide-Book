package ewhaguidebook.guidebook.repository;

import ewhaguidebook.guidebook.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {
}
