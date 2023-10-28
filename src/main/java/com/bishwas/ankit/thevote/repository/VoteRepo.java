package com.bishwas.ankit.thevote.repository;

import com.bishwas.ankit.thevote.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Component
public interface VoteRepo extends JpaRepository<Vote,Long> {
}
