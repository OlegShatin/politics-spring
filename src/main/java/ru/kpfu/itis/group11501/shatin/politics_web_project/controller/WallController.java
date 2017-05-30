package ru.kpfu.itis.group11501.shatin.politics_web_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.group11501.shatin.politics_web_project.entity.User;
import ru.kpfu.itis.group11501.shatin.politics_web_project.entity.WallComment;
import ru.kpfu.itis.group11501.shatin.politics_web_project.entity.WallPost;
import ru.kpfu.itis.group11501.shatin.politics_web_project.form.community.WallCommentForm;
import ru.kpfu.itis.group11501.shatin.politics_web_project.service.CommunityService;
import ru.kpfu.itis.group11501.shatin.politics_web_project.form.community.PostCreateForm;
import ru.kpfu.itis.group11501.shatin.politics_web_project.misc.Helpers;
import ru.kpfu.itis.group11501.shatin.politics_web_project.service.WallService;

import javax.validation.Valid;

/**
 * @author Oleg Shatin
 * Date: 4/21/17 2:18 PM
 */

@Controller
@RequestMapping(path = {"/group/{id}/wall", "/community/{id}/wall"}) //todo
@SessionAttributes("form")
public class WallController {

    private CommunityService communityService;
    private WallService wallService;

    @Autowired
    public WallController(CommunityService communityService, WallService wallService) {
        this.communityService = communityService;
        this.wallService = wallService;
    }

    @ModelAttribute("group_id")
    public int groupId(@PathVariable int id) {
        return id;
    }

    @ModelAttribute("form")
    public PostCreateForm form() {
        return new PostCreateForm();
    }

    @GetMapping(path = "/new")
    @PreAuthorize("hasPermission(#group_id, 'Community', 'post')")
    public String newPostGet(@ModelAttribute("group_id") int group_id) {
        return "communities_newpost";
    }

    @PostMapping(path = "/new")
    @PreAuthorize("hasPermission(#group_id, 'Community', 'post')")
    public String newPostPost(@ModelAttribute("form") @Valid PostCreateForm form, BindingResult result,
                              /* Parameter group_id is needed here for security expression evaluation */
                              @ModelAttribute("group_id") int group_id,
                              ModelMap map) {
        User currentUser = Helpers.getCurrentUser();
        if(result.hasErrors()) {
            return "communities_newpost";
        }
        
        WallPost post = new WallPost(currentUser, form.getText(), form.getVideoLink());
        if(form.getImage() != null || form.getImage().getSize() > 0)
            post.setImageLink(Helpers.uploadImage(form.getImage()));

        communityService.addPost(group_id, post);
        // to do that redirect work  also with courses,events,labs
        return "redirect:/group/" + group_id + "/";
    }

    @PostMapping(path = "/{post_id}/comments/new")
    @PreAuthorize("hasPermission(#group_id, 'Community', 'comment')")
    public String newCommentPost(@ModelAttribute @Valid WallCommentForm form, BindingResult result,
                                 @ModelAttribute("group_id") int group_id,
                                 @PathVariable int post_id) {
        if(result.hasErrors()) {
            //todo redirect to group page
            return "redirect:../../../";
        }
        User author = Helpers.getCurrentUser();
        wallService.addComment(group_id, post_id, new WallComment(author, form.getText()));
        return "redirect:../../../";
    }
}