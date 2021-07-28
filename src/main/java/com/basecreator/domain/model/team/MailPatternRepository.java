package com.basecreator.domain.model.team;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailPatternRepository extends JpaRepository<MailPattern, Long> {
}
