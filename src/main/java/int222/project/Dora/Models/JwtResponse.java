package int222.project.Dora.Models;

public class JwtResponse {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private String role;
    private Long userId;

    public JwtResponse(String jwttoken,  String role, Long userId) {
        this.jwttoken = jwttoken;
        this.role = role;
        this.userId = userId;
    }

    public String getToken() {
        return this.jwttoken;
    }

    public String getRole() {
        return role;
    }

    public Long getUserId() {
        return userId;
    }
}
