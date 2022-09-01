package com.Muneeb.fypregistrationapplication;

public class FYPReg extends MainParent {

    private String Project;
    private String Supervisor;
    private String GitHub;


    public String getProject() {
        return Project;
    }

    public String setProject(String project) {
        Project = project;
        return Project;
    }

    public String getSupervisor() {
        return Supervisor;
    }

    public String setSupervisor(String supervisor) {
        Supervisor = supervisor;
        return Supervisor;
    }

    public String getGitHub() {
        return GitHub;
    }

    public String setGitHub(String gitHub) {
        GitHub = gitHub;
        return GitHub;
    }

    public FYPReg(int formID, String stuName, String fatName, String major, String email, String project, String supervisor, String gitHub) {
        super(formID, stuName, fatName, major, email);
        Project = project;
        Supervisor = supervisor;
        GitHub = gitHub;
    }

    public FYPReg(){

    }

    @Override
    public String toString() {
        return "FYPReg{" +
                "Project='" + Project + '\'' +
                ", Supervisor='" + Supervisor + '\'' +
                ", GitHub='" + GitHub + '\'' +
                '}';
    }
}
