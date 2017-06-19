package java15.entity.errors;

public class ShopRobbery extends Error {
    private String message;
    public ShopRobbery(String message)
    {
        this.message = message;
    }
    public void message ()
    {
        System.out.println(message);
    }
}
