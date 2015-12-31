package fenghuang.bookbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fenghuang.bookbot.model.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {

    Tag findByText(String text);

}
