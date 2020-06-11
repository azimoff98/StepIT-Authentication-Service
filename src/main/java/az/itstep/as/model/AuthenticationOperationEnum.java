package az.itstep.as.model;

public enum AuthenticationOperationEnum {
    SIGN_IN("SIGN_IN"),
    SIGN_UP("SIGN_UP"),
    PASSWORD_CHANGE("PASSWORD_CHANGE");

    private String operation;

    AuthenticationOperationEnum(String operation){
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }
}
