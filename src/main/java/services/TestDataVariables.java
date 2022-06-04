package services;

public enum TestDataVariables {

    GROUP("group"),
    LAB_DATE("labDate"),
    TRUANCY("truancy"),
    SCORE("score"),
    STUDENT_NAME("studentName");

    private String variable;

    TestDataVariables(String variable) {
        this.variable = variable;
    }

    public String getVariable() {
        return variable;
    }
}
