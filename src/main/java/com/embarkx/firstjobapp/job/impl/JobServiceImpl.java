package com.embarkx.firstjobapp.job.impl;

import com.embarkx.firstjobapp.job.Job;
import com.embarkx.firstjobapp.job.JobRepository;
import com.embarkx.firstjobapp.job.JobService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;


// This class implements the JobService interface.

@Service
public class JobServiceImpl implements JobService {

    // Job Repository Implementation

    JobRepository jobRepository;

//    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    //    This method return all the jobs in the list.
    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

//    This method adds a new job to the list.
    @Override
    public void createJob(Job job) {
         jobRepository.save(job);
    }

//    This method get job by id.
    @Override
    public Job getJobById(Long id) {
//        for (Job job : jobs) {
//            if (job.getId() == id) {
//                return job;
//            }
//        }
//        return null;
        return jobRepository.findById(id).orElse(null);
    }


//    This method delete job by id.
    @Override
    public boolean deleteJobById(Long id) {
//        Iterator<Job> iterator = jobs.iterator();
//        while(iterator.hasNext()){
//            Job job= iterator.next();
//            if(job.getId() == id) {
//                iterator.remove();
//                return true;
//            }
//        }
//        return false;

        try {
            jobRepository.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

//    This method is used to update job by id.
    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if (jobOptional.isPresent()) {
            Job job1 = jobOptional.get();
            job1.setTitle(updatedJob.getTitle());
            job1.setDescription(updatedJob.getDescription());
            job1.setMinSalary(updatedJob.getMinSalary());
            job1.setMaxSalary(updatedJob.getMaxSalary());
            job1.setLocation(updatedJob.getLocation());
            jobRepository.save(job1);
            return true;
        }

        return false;
    }
}
