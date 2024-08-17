package com.embarkx.firstjobapp.job;

import java.util.List;


// This is the interface that defines the contract for jobService.

// This interface is implemented by the JobServiceImpl.

public interface JobService {
//    This method return all the jobs in the list.
    List<Job> findAll();

//    This method adds a new job to the list.
    void createJob(Job job);

//    This method get job by id.
    Job getJobById(Long id);

//    This method delete job by id.
    boolean deleteJobById(Long id);

//    This method update job by id.
    boolean updateJob(Long id, Job updatedJob);
}
