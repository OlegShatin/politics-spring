package ru.kpfu.itis.group11501.shatin.politics_web_project.controller.ajax_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.group11501.shatin.politics_web_project.entity.User;
import ru.kpfu.itis.group11501.shatin.politics_web_project.form.ChangePasswordForm;
import ru.kpfu.itis.group11501.shatin.politics_web_project.service.UserService;
import ru.kpfu.itis.group11501.shatin.politics_web_project.misc.Helpers;
import ru.kpfu.itis.group11501.shatin.politics_web_project.validator.NewPasswordFormValidator;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@PreAuthorize("isFullyAuthenticated()")
public class PasswordAjaxController {

    private UserService userService;
    private NewPasswordFormValidator validator;

    @ModelAttribute("passwordForm")
    public ChangePasswordForm changePasswordForm() {
        return new ChangePasswordForm();
    }

    @Autowired
    public PasswordAjaxController(UserService userService, NewPasswordFormValidator validator) {
        this.userService = userService;
        this.validator = validator;
    }

    @PostMapping("ajax/profile/edit/change_password")
     public Map<String, Object> doPost(@ModelAttribute("passwordForm") @Valid ChangePasswordForm form,
                                       BindingResult bindingResult) {
        validator.validate(form, bindingResult);
        Map<String, Object> map = new HashMap<>();
        if(bindingResult.hasErrors()) {
            //put list of names of fields with errors
            map.put("errors_fields"
                    , bindingResult
                            .getFieldErrors()
                            .stream()
                            .map(FieldError::getField)
                            .collect(Collectors.toList())
            );
            return map;
        }

        User currentUser = Helpers.getCurrentUser();
        currentUser.setPasswordRaw(form.getNew_password());
        userService.save(currentUser);
        //empty map is flag that all right.
        return map;
    }

}
