public class StrategyTest {

    public static void main(String[] args) {

        PaymentContext creditCard =
                new PaymentContext(new CreditCardPayment());

        creditCard.executePayment(5000);

        PaymentContext payPal =
                new PaymentContext(new PayPalPayment());

        payPal.executePayment(2500);
    }
}