package ru.kpfu.itis.group11501.shatin.politics_web_project.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.group11501.shatin.politics_web_project.entity.Group;
import ru.kpfu.itis.group11501.shatin.politics_web_project.repository.GroupRepository;

/**
 * @author Oleg Shatin
 * Date: 4/14/17 9:49 AM
 */
@Controller
@RequestMapping(path = "/admin/groups/")
public class GroupAdminController extends BaseAdminController<Group> {

    @Autowired
    public GroupAdminController(GroupRepository repository) {
        super(repository);
    }

}
