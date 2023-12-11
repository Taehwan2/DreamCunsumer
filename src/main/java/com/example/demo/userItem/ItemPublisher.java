package com.example.demo.userItem;

import com.example.demo.userItem.db.UserItem;
import org.springframework.context.ApplicationEvent;


public class ItemPublisher extends ApplicationEvent {
    private final UserItem userItem;

    public ItemPublisher(Object source) {
        super(source);
        this.userItem = (UserItem) source;
    }

    public UserItem getUserItem() {
        return userItem;
    }
}
