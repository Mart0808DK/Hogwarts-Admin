package edu.hogwarts.data;

public class House implements HogwartsPerson {

    private String name;

    private String founder;

    private String[] colors;

    public House(String name, String founder, String... colors) {
        this.name = name;
        this.founder = founder;
        this.colors = colors;
    }

    public House() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String[] getColors() {
        return colors;
    }

    public void setColors(String[] colors) {
        this.colors = colors;
    }

    public String toString() {
        StringBuilder colorString = new StringBuilder();
        if(colors.length > 0){
            for(String color : colors){
                colorString.append(color).append(", ");
            }
            colorString.replace(colorString.lastIndexOf(", "), colorString.length()-1, ".");
        }
        return "edu.hogwarts.data.House{\n" +
                " name: " + name + "\n" +
                " founder: " + founder + "\n" +
                " colors: " + colorString + "\n" +
                "}";
    }

}
