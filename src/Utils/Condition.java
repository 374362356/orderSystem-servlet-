package Utils;

public class Condition {
    //菜类别作为条件
    private int foodType_id;
    //菜名称作为条件
    private String foodName;

    public int getFoodType_id() {
        return foodType_id;
    }

    public void setFoodType_id(int foodType_id) {
        this.foodType_id = foodType_id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
}
