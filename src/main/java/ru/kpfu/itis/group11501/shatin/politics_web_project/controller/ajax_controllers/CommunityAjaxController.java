package ru.kpfu.itis.group11501.shatin.politics_web_project.controller.ajax_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.group11501.shatin.politics_web_project.dto.GroupDto;
import ru.kpfu.itis.group11501.shatin.politics_web_project.dto.InterestDto;
import ru.kpfu.itis.group11501.shatin.politics_web_project.entity.Group;
import ru.kpfu.itis.group11501.shatin.politics_web_project.entity.Interest;
import ru.kpfu.itis.group11501.shatin.politics_web_project.service.GroupService;
import ru.kpfu.itis.group11501.shatin.politics_web_project.service.UserService;
import ru.kpfu.itis.group11501.shatin.politics_web_project.misc.Helpers;
import ru.kpfu.itis.group11501.shatin.politics_web_project.service.InterestService;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Oleg Shatin
 * Date: 4/18/17 11:02 AM
 */

@RestController
@RequestMapping(path = "/ajax/groups")
public class CommunityAjaxController {

    private GroupService groupService;
    private UserService userService;
    private InterestService interestService;

    @Autowired
    public CommunityAjaxController(GroupService groupService, UserService userService, InterestService interestService) {
        this.groupService = groupService;
        this.userService = userService;
        this.interestService = interestService;
    }

/*

TODO
    @GetMapping(path = "/")
    public Map<String, Object> listAll() {
        List<Group> allGroups = groupService.getAll(); //returns all groups and child entities as well

        User user = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser();
        //todo lazy init
        //user is stored in http session and hence is detached from db session
        user = userService.findByEmail(user.getEmail());

        Collection<Group> myGroups = user.getGroups(); //returns all groups and child entities as well

        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("all_groups", toDtoList(allGroups, Group.class, GroupDto::new));
        returnMap.put("all_courses", toDtoList(allGroups, Course.class, CourseDto::new));
        returnMap.put("all_labs", toDtoList(allGroups, Lab.class, LabDto::new));

        returnMap.put("my_groups", toDtoList(myGroups, Group.class, GroupDto::new));
        returnMap.put("my_courses", toDtoList(myGroups, Course.class, CourseDto::new));
        returnMap.put("my_labs", toDtoList(myGroups, Lab.class, LabDto::new));

        List<Interest> tags = interestService.getAll();
        returnMap.put("tags", toInterestDtoList(tags, Interest.class, InterestDto::new));
        returnMap.put("user_role", user.getRole());
        return returnMap;
    }
*/

    private <T extends Group, D extends GroupDto> List<D> toDtoList(Collection<Group> allGroups, Class<T> clazz,
                                                                    Function<T, D> dtoMapper) {
        return Helpers.filterByType(allGroups, clazz).stream()
                .map(dtoMapper)
                .collect(Collectors.toList());
    }

    private <T extends Interest, D extends InterestDto> List<D> toInterestDtoList(Collection<Interest> interests, Class<T> clazz,
                                                                                  Function<T, D> dtoMapper) {
        return Helpers.filterByType(interests, clazz).stream()
                .map(dtoMapper)
                .collect(Collectors.toList());
    }
}
