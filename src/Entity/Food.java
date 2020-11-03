package Entity;

public class Food {

    private int id;
    private String foodName;
    private int foodType_id;
    private double price;
    private double memberprice;
    private String introduce;
    private String img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodType_id() {
        return foodType_id;
    }

    public void setFoodType_id(int foodType_id) {
        this.foodType_id = foodType_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMemberprice() {
        return memberprice;
    }

    public void setMemberprice(double memberprice) {
        this.memberprice = memberprice;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
