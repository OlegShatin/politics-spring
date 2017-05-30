package ru.kpfu.itis.group11501.shatin.politics_web_project.misc;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Oleg Shatin
 * Date: 4/17/17 11:30 AM
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RuntimeException {

    private int entityId;

    public EntityNotFoundException(int entityId) {
        this.entityId = entityId;
    }
}
