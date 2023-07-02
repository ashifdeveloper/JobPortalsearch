package com.geekster.Job.Search.Portal.service;

import com.geekster.Job.Search.Portal.model.Job;
import com.geekster.Job.Search.Portal.model.Type;
import com.geekster.Job.Search.Portal.repository.IJobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {
    @Autowired
    IJobRepo jobRepo;
//Inbuilt Method
    public Iterable<Job> getAllJobs() {
        return jobRepo.findAll();
    }


////Using Custom Finder
//    public List<Job> getAllJobsUsingCustomFinder() {
//        return jobRepo.findAllJobs();
//    }

//Adding a Job Using Inbuilt CrudRepo Method
    public String addJob(Job job) {
        jobRepo.save(job);
        return "Added";
    }
//Adding Multiple Jobs Using Inbuilt CrudRepo Method

    public String addJobs(List<Job> jobs) {
        jobRepo.saveAll(jobs);
        return "Jobs Added";
    }
//    Delete a Job Using Inbuilt crudRepo Method

    public String deleteJobWithId(Long id) {
        Optional<Job> myJobOpt = jobRepo.findById(id);
        Job myJob = null;
        if(myJobOpt.isPresent()){
            myJob=myJobOpt.get();
        }
        else{
            return "Id Not Found";
        }

        jobRepo.deleteById(id);
        return "Deleted for id "+id;
    }
//Update jobType using Inbuilt crudRepo Method
    public String updateJobTypeById(Long id, Type type) {
        Optional<Job> myJobOpt = jobRepo.findById(id);
        Job myJob = null;
        if(myJobOpt.isPresent()){
            myJob=myJobOpt.get();
        }
        else{
            return "Id Not Found";
        }

        myJob.setJobType(type);
        jobRepo.save(myJob);
        return "Updated for id "+id;

    }

    public List<Job> getJobsByTitle(String title) {
        return jobRepo.findByTitle(title);
    }

    //find job By title using Custom Query Method

    public List<Job> findJobsByTitle(String title) {

        return jobRepo.findJobsByTitle(title);
    }

    public List<Job> getJobsByTitleAndDescription(String title, String description) {
        return jobRepo.findByTitleAndDescription(title,description);
    }

    public String updateTitleById(long id, String title) {

        Optional<Job> myJobOpt = jobRepo.findById(id);
        Job myJob = null;
        if(myJobOpt.isPresent()){
            myJob=myJobOpt.get();
        }
        else{
            return "Id Not Found";
        }

        myJob.setTitle(title);
        jobRepo.updateTitleById(id,title);
        return "Updated title for id "+id;


    }

    //    Delete a Job Using Inbuilt crudRepo Method

    public String deleteJobById(Long id) {
        Optional<Job> myJobOpt = jobRepo.findById(id);
        Job myJob = null;
        if(myJobOpt.isPresent()){
            myJob=myJobOpt.get();
        }
        else{
            return "Id Not Found";
        }

        jobRepo.deleteJobById(id);
        return "Deleted for id "+id;
    }

}
