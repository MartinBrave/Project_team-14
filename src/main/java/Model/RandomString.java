package Model;

public abstract class RandomString {
    public static String getRandomString() {
        return null;
    }

    public static String createID(String type) {
        String result = "";
        result += type;
        result += "---";
        result += getRandomString();
        return result;
    }
}
