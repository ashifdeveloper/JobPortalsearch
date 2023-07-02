package com.geekster.Job.Search.Portal.controller;

import com.geekster.Job.Search.Portal.model.Job;
import com.geekster.Job.Search.Portal.model.Type;
import com.geekster.Job.Search.Portal.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    @Autowired
    JobService jobService;




    //get all jobs using CrudRepo Method
   @GetMapping("jobs")
    public Iterable<Job> getAllJobs(){
        return jobService.getAllJobs();

    }





//add a job using inbuilt CrudRepo Method
    @PostMapping("job")

    public String addJob(@RequestBody Job job){
       return jobService.addJob(job);
    }

//addMultiple Job using inbuilt CrudRepo Method

    @PostMapping("jobs")
    public String addMultipleJobs(@RequestBody List<Job> jobs){
       return jobService.addJobs(jobs);
    }


//    Delete a Job Using Inbuilt crudRepo Method

    @DeleteMapping("jobs/{id}")
    public String deleteJobWithId(@PathVariable Long id){
       return jobService.deleteJobWithId(id);
    }


//    Delete a Job Using Custom Query Method

    @DeleteMapping("jobs/customquery/{id}")
    public String deleteJobById(@PathVariable Long id){
        return jobService.deleteJobById(id);
    }

    //Update Job Type By Id Using Inbuilt crudRepo Method

    @PutMapping("job/{id}/{type}")
    public String updateJobTypeById(@PathVariable Long id,@PathVariable Type type){
       return jobService.updateJobTypeById(id,type);
    }


    //find job By title using Custom finder Method

    @GetMapping("jobs/title/{title}")
    public List<Job> getJobsByTitle(@PathVariable String title){
       return jobService.getJobsByTitle(title);
    }

    //find job By title using Custom Query Method
    @GetMapping("jobs/customquery/title/{title}")

    public List<Job> findJobsByTitle(@PathVariable String title){

       return jobService.findJobsByTitle(title);
    }




    //find job by title and description using Custom finder Method

    @GetMapping("jobs/title/{title}/description/{description}")
    public List<Job> getJobsByTitleAndDescription(@PathVariable String title,@PathVariable String description){
       return jobService.getJobsByTitleAndDescription(title,description);
    }


    //update title by id using custom query

    @PutMapping("jobs/{id}/title/{title}")
    public String updateTitleById(@PathVariable Long id,@PathVariable String title){
       return jobService.updateTitleById(id,title);
    }


}
