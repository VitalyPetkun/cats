package services;

public enum TestDataVariables {

    LAB_GROUP("labGroup"),
    LECTURE_GROUP("lectureGroup"),
    LAB_DATE("labDate"),
    LECTURE_DATE("lectureDate"),
    LAB_TRUANCY("labTruancy"),
    LECTURE_TRUANCY("lectureTruancy"),
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
