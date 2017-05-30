package ru.kpfu.itis.group11501.shatin.politics_web_project.form;

import java.util.List;

/**
 * @author Oleg Shatin
 * Date: 5/2/17 4:51 PM
 */
public class TimetableClassCreateForm {

    private int subjectId;
    private int teacherId;
    private List<String> academicGroups;

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public List<String> getAcademicGroups() {
        return academicGroups;
    }

    public void setAcademicGroups(List<String> academicGroups) {
        this.academicGroups = academicGroups;
    }
}
