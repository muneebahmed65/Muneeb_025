package com.Muneeb.fypregistrationapplication;

import android.app.Application;

public class MainParent extends Application {

    private int FormID;
    private String StuName;
    private String FatName;
    private String Major;
    private String Email;


    public int getFormID() {
        return FormID;
    }

    public void setFormID(int formID) {
        FormID = formID;
    }

    public String getStuName() {
        return StuName;
    }

    public String setStuName(String stuName) {
        StuName = stuName;
        return StuName;
    }

    public String getFatName() {
        return FatName;
    }

    public String setFatName(String fatName) {
        FatName = fatName;
        return FatName;
    }

    public String getMajor() {
        return Major;
    }

    public String setMajor(String major) {
        Major = major;
        return Major;
    }



    public String getEmail() {
        return Email;
    }

    public String setEmail(String email) {
        Email = email;
        return Email;
    }


    public MainParent(int formID, String stuName, String fatName, String major, String email) {
        FormID = formID;
        StuName = stuName;
        FatName = fatName;
        Major = major;
        Email = email;
    }

    public MainParent(){

    }

    @Override
    public String toString() {
        return "MainParent{" +
                "FormID=" + FormID +
                ", StuName='" + StuName + '\'' +
                ", FatName='" + FatName + '\'' +
                ", Major='" + Major + '\'' +
                ", Email='" + Email + '\'' +
                '}';
    }
}
