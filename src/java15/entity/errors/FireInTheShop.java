package java15.entity.errors;

public class FireInTheShop extends Error { // Runtime
    private String message; // = "Fire"
    public FireInTheShop(String message)
    {
        this.message = message;
    }
    public void message ()
    {
        System.out.println(message);
    }
}
