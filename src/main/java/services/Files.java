package services;

public enum Files {

    CONFIG("config.properties"),
    TEST_DATA("testData.properties");

    private String file;

    Files(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }
}
