package web.models;

public class Car {

    private Long id;
    private String model;
    private Integer year;

    public Car() {
    }

    public Car(Long id, String model, Integer year) {
        this.id = id;
        this.model = model;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
