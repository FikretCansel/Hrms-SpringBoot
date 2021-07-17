package fikretcansel.hrms.core.utilities.results.concretes;


public class UserDataResult<T> extends DataResult<T>{
    private boolean emailVerified;

    public UserDataResult(boolean success, String message, T data) {
        super(success, message, data);
    }
    public UserDataResult(boolean success, String message, T data,boolean emailVerified) {
        super(success, message, data);
        this.emailVerified=emailVerified;
    }
    public UserDataResult(boolean success, T data,boolean emailVerified) {
        super(success, data);
        this.emailVerified=emailVerified;
    }

    public UserDataResult(boolean success, T data) {
        super(success, data);
    }
    public void setEmailVerified(boolean emailVerified){
        this.emailVerified=emailVerified;
    }
    public boolean getEmailVerified(){
       return emailVerified;
    }
}
