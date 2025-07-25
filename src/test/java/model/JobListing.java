package model;

public class JobListing {
    private String title;
    private String contractType;
    private String category;
    private String location;
    private String jobId;
    private String jobType;

    // Constructor
    public JobListing(String title, String contractType, String category, String location, String jobId, String jobType) {
        this.title = title;
        this.contractType = contractType;
        this.category = category;
        this.location = location;
        this.jobId = jobId;
        this.jobType = jobType;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    @Override
    public String toString() {
        return "model.JobListing{" +
                "title='" + title + '\'' +
                ", contractType='" + contractType + '\'' +
                ", category='" + category + '\'' +
                ", location='" + location + '\'' +
                ", jobId='" + jobId + '\'' +
                ", jobType='" + jobType + '\'' +
                '}';
    }
}
