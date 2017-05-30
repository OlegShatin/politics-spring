package ru.kpfu.itis.group11501.shatin.politics_web_project.form;

import java.util.Date;

/**
 * @author Oleg Shatin
 * Date: 5/2/17 4:54 PM
 */
public class TimetableDateForm {

    private int id;

    private int classId;

    private String place;
    private Date date;

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
