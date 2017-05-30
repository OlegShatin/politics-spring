package ru.kpfu.itis.group11501.shatin.politics_web_project.form.community;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Oleg Shatin
 * Date: 4/23/17 7:24 PM
 */
public class WallCommentForm {

    @NotEmpty
    private String text;

    //todo image

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
