package int222.project.Dora.Models;

public class JwtResponse {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private String roll;
    private Long userId;

    public JwtResponse(String jwttoken,  String roll, Long userId) {
        this.jwttoken = jwttoken;
        this.roll = roll;
        this.userId = userId;
    }

    public String getToken() {
        return this.jwttoken;
    }

    public String getRoll() {
        return roll;
    }

    public Long getUserId() {
        return userId;
    }
}
