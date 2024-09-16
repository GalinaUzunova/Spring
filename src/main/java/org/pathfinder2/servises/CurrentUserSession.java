package org.pathfinder2.servises;


import org.pathfinder2.model.User;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;


@Component
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CurrentUserSession {


    private String fullName;

    public boolean isLoggIn(){
        return this.getFullName()!=null;
    }





    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;

    }



//this.user.getRoles().stream().anyMatch(u->u.getName().equals("ADMIN"))


public void clean() {
    this.fullName=null;


}
}