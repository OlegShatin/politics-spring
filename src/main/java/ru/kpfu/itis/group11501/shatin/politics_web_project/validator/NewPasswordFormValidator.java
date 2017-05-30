package ru.kpfu.itis.group11501.shatin.politics_web_project.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.kpfu.itis.group11501.shatin.politics_web_project.entity.User;
import ru.kpfu.itis.group11501.shatin.politics_web_project.form.ChangePasswordForm;
import ru.kpfu.itis.group11501.shatin.politics_web_project.service.UserService;
import ru.kpfu.itis.group11501.shatin.politics_web_project.misc.Helpers;
import org.springframework.validation.Validator;
import org.springframework.validation.Errors;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
/**
 * Created by volkov on 29.04.2017.
 */
@Component
public class NewPasswordFormValidator implements Validator {

    private UserService userService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public NewPasswordFormValidator(UserService userService,BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return ChangePasswordForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ChangePasswordForm form = (ChangePasswordForm) target;



        //check old_password
        User currentUser = Helpers.getCurrentUser();
        if (!bCryptPasswordEncoder.matches(form.getOld_password(),currentUser.getPasswordHash())){
            errors.rejectValue("old_password", "Wrong password");
        }
    }
}
