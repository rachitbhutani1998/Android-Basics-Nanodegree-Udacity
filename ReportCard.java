package com.example.android.reportcard;

/**
 * Created by Rachit on 10/20/2016.
 */
public class ReportCard {

    /**
     * Declaring private variables
     * */
    private String mId;
    private String mCourse;
    private float mPercentage;
    private String mCourseGrade;
    private String mRemarks;

    /**
     * Getting the input for the construtor
     * */
    public ReportCard(String Course,float percentage){
        mCourse = Course;
        mPercentage = percentage;
        if(mPercentage>90&&mPercentage<=100){
            mCourseGrade="A+";
        }
        else if(mPercentage>80&&mPercentage<=90){
            mCourseGrade="A";
        }
        else if(mPercentage>70&&mPercentage<=80){
            mCourseGrade="B+";
        }
        else if(mPercentage>60&&mPercentage<=70){
            mCourseGrade="B";
        }
        else if(mPercentage>50&&mPercentage<=60){
            mCourseGrade="C";
        }
        else if(mPercentage>40&&mPercentage<=50){
            mCourseGrade="D";
        }
        else if(mPercentage>33&&mPercentage<=40){
            mCourseGrade="E";
        }
        else if(mPercentage<=33){
            mCourseGrade="F";
        }
    }

    /**
     *returning the values
     */
    public String getCourse(){
        return mCourse;
    }

    public void setCourse(String Course){
        this.mCourse=Course;
    }
    public float getPercentage(){
        return mPercentage;
    }

    public void setPercentage(float percentage){
        this.mPercentage=percentage;
    }
    public String getCourseGrade(){
        return mCourseGrade;
    }

    public void setCourseGrade(String CourseGrade){
        this.mCourseGrade=CourseGrade;
    }

    public String getRemarks(){
        return mRemarks;
    }

    public void setRemarks(String comment){
        this.mRemarks=comment;
    }
    @Override
    public String toString(){
        return "You have scored "+mPercentage+"\nEquivalent to "+mCourseGrade+" in subject: "+mCourse;
    }

}
