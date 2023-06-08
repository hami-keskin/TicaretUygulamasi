package net.app.category;

public class Category {
    protected int categoryID;
    protected String categoryName;

    public Category() {
    }

    public Category(String categoryName) {
        super();
        this.categoryName = categoryName;
    }

    public Category(int categoryID, String categoryName) {
        super();
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}