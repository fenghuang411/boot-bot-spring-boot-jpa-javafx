package fenghuang.bookbot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fenghuang.bookbot.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {

}
