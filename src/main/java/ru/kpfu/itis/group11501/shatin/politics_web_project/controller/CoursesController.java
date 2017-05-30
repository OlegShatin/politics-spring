package ru.kpfu.itis.group11501.shatin.politics_web_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.group11501.shatin.politics_web_project.entity.User;
import ru.kpfu.itis.group11501.shatin.politics_web_project.service.UserService;
import ru.kpfu.itis.group11501.shatin.politics_web_project.entity.Community;
import ru.kpfu.itis.group11501.shatin.politics_web_project.entity.Course;
import ru.kpfu.itis.group11501.shatin.politics_web_project.form.community.CommunityCreateForm;
import ru.kpfu.itis.group11501.shatin.politics_web_project.form.community.CourseCreateForm;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by 1 on 29.03.2017.
 */
@Controller
@RequestMapping(path = "/courses")
public class CoursesController extends BaseCommunitiesController<Course> {
    private UserService userService;

    @Autowired
    public CoursesController(UserService userService) {
        super(Community.CommunityType.COURSE);
        this.userService = userService;
    }

    @ModelAttribute("names")
    public List<User> getAllWorkers() {
        return userService.findAllWorkers();
    }

    @Override
    public CourseCreateForm newCreateForm() {
        return new CourseCreateForm();
    }

    //override methods to add more annotations
    @Override
    @PreAuthorize("hasAuthority('CREATE_COURSE')")
    public String doCreateGet() {
        return super.doCreateGet();
    }

    @Override
    @PreAuthorize("hasAuthority('CREATE_COURSE')")
    public String doCreatePost(@ModelAttribute @Valid CommunityCreateForm<Course> form, BindingResult result, ModelMap map) {
        return super.doCreatePost(form, result, map);
    }

    @Override
    protected Course getNewEntity() {
        return new Course();
    }

}
