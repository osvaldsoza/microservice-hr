package com.github.osvaldsoza.hrworker.repositories;

import com.github.osvaldsoza.hrworker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker,Long> {


}
