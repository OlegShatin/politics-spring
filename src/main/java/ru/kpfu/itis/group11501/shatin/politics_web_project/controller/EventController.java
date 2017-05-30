package ru.kpfu.itis.group11501.shatin.politics_web_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.itis.group11501.shatin.politics_web_project.entity.Event;
import ru.kpfu.itis.group11501.shatin.politics_web_project.form.community.CommunityCreateForm;
import ru.kpfu.itis.group11501.shatin.politics_web_project.form.community.EventCreateForm;
import ru.kpfu.itis.group11501.shatin.politics_web_project.service.EventService;

/**
 * Created by volkov on 28.04.2017.
 */
@Controller
@RequestMapping(path = "/event/{id}/")
public class EventController extends CommunityController<Event> {
    @Autowired
    public EventController(EventService eventService) {
        super(eventService);
    }
    //to do that user cant registred when members.size = maxMember


    @Override
    protected CommunityCreateForm<Event> editForm(Event community) {
        return new EventCreateForm().fromEntity(community);
    }
}
