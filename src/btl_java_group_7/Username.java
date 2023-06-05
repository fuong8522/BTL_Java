package btl_java_group_7;

import java.io.Serializable;

/**
 *
 * @author fuong
 */
public class Username implements Serializable{
    public String username;
    public String password;

    public Username() {
    }

    public Username(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
}
