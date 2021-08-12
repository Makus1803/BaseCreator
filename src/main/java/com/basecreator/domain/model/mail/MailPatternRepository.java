package com.basecreator.domain.model.mail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailPatternRepository extends JpaRepository<MailPattern, Long> {
}
