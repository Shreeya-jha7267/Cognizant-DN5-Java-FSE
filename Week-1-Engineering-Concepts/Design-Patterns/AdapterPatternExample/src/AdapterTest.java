public class AdapterTest {

    public static void main(String[] args) {

        PaymentProcessor payPal = new PayPalAdapter();
        payPal.processPayment(2500);

        PaymentProcessor stripe = new StripeAdapter();
        stripe.processPayment(4500);

    }
}