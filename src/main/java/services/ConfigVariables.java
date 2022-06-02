package services;

public enum ConfigVariables {

    LECTURER_LOGIN("lecturerLogin"),
    LECTURER_PASSWORD("lecturerPassword"),
    STUDENT_LOGIN("studentLogin"),
    STUDENT_PASSWORD("studentPassword");

    private String variables;

    private ConfigVariables(String variables) {
        this.variables = variables;
    }

    public String getVariables() {
        return variables;
    }
}
