package transactions;

import user.User;

public abstract class transaction {
    private final User user;
    public transaction(User user){
        this.user=user;
    }
    public User getUserTransaction(){return user;}


}
