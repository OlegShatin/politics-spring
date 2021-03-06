package ru.kpfu.itis.group11501.shatin.politics_web_project.form.community;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Oleg Shatin
 * Date: 4/21/17 2:16 PM
 */
public class PostCreateForm {

    @NotEmpty
    private String text;

    private MultipartFile image;

    private String videoLink;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
