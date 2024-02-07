package edu.hogwarts.data;

public abstract class TeachingMaterial {
    private String name;
    private boolean onShoppingList;

    private boolean required;

    private boolean provided;

    private String notes;

    public TeachingMaterial(String name, boolean onShoppingList, boolean required, boolean provided, String notes) {
        this.name = name;
        this.onShoppingList = onShoppingList;
        this.required = required;
        this.provided = provided;
        this.notes = notes;
    }

    public TeachingMaterial(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOnShoppingList() {
        return onShoppingList;
    }

    public void setOnShoppingList(boolean onShoppingList) {
        this.onShoppingList = onShoppingList;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isProvided() {
        return provided;
    }

    public void setProvided(boolean provided) {
        this.provided = provided;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "edu.hogwarts.data.TeachingMaterial{" +
                "name='" + name + '\'' +
                ", onShoppingList=" + onShoppingList +
                ", required=" + required +
                ", provided=" + provided +
                ", notes='" + notes + '\'' +
                '}';
    }
}
