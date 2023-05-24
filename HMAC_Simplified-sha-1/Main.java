public class Main {
    public static void main(String[] args) {
        HMAC_SSHA_1 S = new HMAC_SSHA_1();
        boolean[] k = {false,false};
        System.out.println(S.hmac_ssha_1(k, "ne jemi grupi aaa"));
    }
}
