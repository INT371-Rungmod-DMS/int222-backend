package int222.project.Dora.Models;

public class JwtResponse {
    private static final long serialVersionUID = -8091879091924046844L;
    private final String jwttoken;
    private String roll;

    public JwtResponse(String jwttoken,  String roll) {
        this.jwttoken = jwttoken;
        this.roll = roll;
    }

    public String getToken() {
        return this.jwttoken;
    }

    public String getRoll() {
        return roll;
    }
}
