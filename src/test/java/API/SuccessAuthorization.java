package API;

public class SuccessAuthorization {
    private String token;

    public SuccessAuthorization(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
