package ru.kpfu.itis.group11501.shatin.politics_web_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.group11501.shatin.politics_web_project.entity.Group;
import ru.kpfu.itis.group11501.shatin.politics_web_project.form.community.CommunityCreateForm;
import ru.kpfu.itis.group11501.shatin.politics_web_project.service.GroupService;
import ru.kpfu.itis.group11501.shatin.politics_web_project.form.community.GroupCreateForm;

/**
 * Created by 1 on 30.03.2017.
 */
@Controller
@RequestMapping(path = "/group/{id}/")
public class GroupController extends CommunityController<Group> {

    @Autowired
    public GroupController(GroupService groupService) {
        super(groupService);
    }

    @Override
    protected CommunityCreateForm<Group> editForm(Group community) {
        return new GroupCreateForm().fromEntity(community);
    }
}
