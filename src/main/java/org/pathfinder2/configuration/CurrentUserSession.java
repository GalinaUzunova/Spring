package org.pathfinder2.configuration;


import org.pathfinder2.model.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;


@Component
@SessionScope
public class CurrentUserSession {


    private User user;


    public boolean isLoggIn(){
        return this.user !=null;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



//this.user.getRoles().stream().anyMatch(u->u.getName().equals("ADMIN"))


public void clean() {
    this.user=null;


}
}