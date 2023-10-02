package ewhaguidebook.guidebook.repository;

import ewhaguidebook.guidebook.entity.AnswerOfTestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<AnswerOfTestEntity, Integer> {
}