package com.basecreator.domain.model.mail;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MessagePatternRepository extends JpaRepository<MessagePattern, Long> {

    MessagePattern findByName(String name);

}
