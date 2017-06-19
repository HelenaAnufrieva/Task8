package java15.entity.errors;

public class FireInTheShop extends Error {
    private String message;
    public FireInTheShop(String message)
    {
        this.message = message;
    }
    public void message ()
    {
        System.out.println(message);
    }
}
