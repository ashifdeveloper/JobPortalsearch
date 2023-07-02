package com.geekster.Job.Search.Portal.repository;

import com.geekster.Job.Search.Portal.model.Job;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IJobRepo extends CrudRepository<Job,Long> {


    //find job By title using Custom finder Method

    List<Job> findByTitle(String title);


    //find job By title using Custom Query Method
    @Transactional
    @Query(value="SELECT * FROM Job j WHERE j.title = :title",nativeQuery = true)
    List<Job> findJobsByTitle(String title);







    //find job by title and description using Custom finder Method

    List<Job> findByTitleAndDescription(String title,String description);

//update title by id using custom query
    @Transactional
    @Modifying
    @Query(value="UPDATE Job j SET j.title = :title WHERE j.id = :id", nativeQuery = true)
    void updateTitleById(Long id, String title);

//Delete by Id using custom query
    @Transactional
    @Modifying
    @Query(value="DELETE FROM Job j WHERE j.id = :id",nativeQuery = true)
    void deleteJobById(Long id);
}
