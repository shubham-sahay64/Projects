import java.util.*;

public class PasswordGenerator {
    private final String Lowercase_Character = "abcdefghijklmnopqrstuvwxyz";
    private final String Uppercase_Character = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String Number = "1234567890";
    private final String Special_characters = "!@#$%^&*()_+=-{}[]<>,.?/;:'";

    private final Random random;

    public PasswordGenerator() {
        random = new Random();
    }

    public String generatePassword(int Length, boolean isUpperCase, boolean isLowercase, boolean isNumber, boolean isSymbol) {
        StringBuilder passwordBuilder = new StringBuilder();
        String validCharacters = "";

        if (isLowercase) {
            validCharacters += Lowercase_Character;
        }
        if (isUpperCase) {
            validCharacters += Uppercase_Character;
        }
        if (isNumber) {
            validCharacters += Number;
        }
        if (isSymbol) {
            validCharacters += Special_characters;
        }

        for (int i = 0; i < Length; i++) {
            int randomIndex = random.nextInt(validCharacters.length());
            char randomChar = validCharacters.charAt(randomIndex);
            passwordBuilder.append(randomChar);
        }

        return passwordBuilder.toString();
    }
}
