package com.embarkx.firstjobapp.job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


// controller for handling all job related requests

@RestController
@RequestMapping("/jobs")
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }


//    // Get all jobs using @GetMapping("/jobs")
//
//
//    @GetMapping("/jobs")
//    public List<Job> findAll() {
//        return jobService.findAll();
//    }

    // Get all jobs using @GetMapping("/jobs") and responseEntity


    @GetMapping
    public ResponseEntity<List<Job>> findAll() {
        return ResponseEntity.ok(jobService.findAll());
    }
//********************************************************************************************
//  Create a new job using @PostMapping("/jobs")

//
//    @PostMapping("/jobs")
//    public String createJob(@RequestBody Job job) {
//        jobService.createJob(job);
//        return "Job added successfully";
//    }

    //  Create a new job using @PostMapping("/jobs") and responseEntity.


    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("Job added successfully", HttpStatus.CREATED);
    }

//*******************************************************************************************
//  Get a job by id using @GetMapping("/jobs/{id}")

//    @GetMapping("/jobs/{id}")
//    public Job getJobById(@PathVariable Long id) {
//        Job job = jobService.getJobById(id);
//        return job;
//    }

    //  Get a job by id using @GetMapping("/jobs/{id}") and responseEntity.

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id) {
        Job job = jobService.getJobById(id);
        if(job != null)
            return new ResponseEntity<>(job, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    //*******************************************************************************************

//    Delete a job by id using @DeleteMapping("/jobs/{id}") and responseEntity.

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJob(@PathVariable Long id) {
        boolean job = jobService.deleteJobById(id);

        if(job) {
            return  new ResponseEntity<>( "Job deleted successfully ", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    Update a job by id using @PutMapping("/jobs/{id}") and responseEntity.

    @PutMapping("/{id}")
//  @RequestMapping(value = "/jobs/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updateJob(@PathVariable Long id, @RequestBody Job updatedJob) {
        boolean updated = jobService.updateJob(id, updatedJob);

        if(updated)
            return new ResponseEntity<>("Job updated successfully", HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}