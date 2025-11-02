public class AgeVerification {
    public String ageValidator(int age) {
        String message = "";

        if (age >= 18) {
            message = "You're access grant";
        }

        return message;
    }

    public static void main(String[] args) {

    }
}
