package btl_java_group_7;

import java.io.Serializable;

/**
 *
 * @author fuong
 */
public class Username implements Serializable{
    private String quen;
    private String username;
    private String password;

    public Username() {
    }

    public Username(String quen, String username, String password) {
        this.quen = quen;
        this.username = username;
        this.password = password;
    }

    public String getQuen() {
        return quen;
    }

    public void setQuen(String magv) {
        this.quen = magv;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    
}
