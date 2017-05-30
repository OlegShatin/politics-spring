package ru.kpfu.itis.group11501.shatin.politics_web_project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.group11501.shatin.politics_web_project.entity.Event;
import ru.kpfu.itis.group11501.shatin.politics_web_project.form.community.EventCreateForm;
import ru.kpfu.itis.group11501.shatin.politics_web_project.entity.Community;

/**
 * @author Oleg Shatin
 * Date: 4/21/17 10:41 PM
 *
 */
@Controller
@RequestMapping(path = "/events/")
public class EventsController extends BaseCommunitiesController<Event> {

    protected EventsController() {
        super(Community.CommunityType.EVENT);
    }

    @Override
    public EventCreateForm newCreateForm() {
        return new EventCreateForm();
    }

    @Override
    protected Event getNewEntity() {
        return new Event();
    }

}
