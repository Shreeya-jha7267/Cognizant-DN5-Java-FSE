public class DecoratorTest {

    public static void main(String[] args) {

        Notifier notifier = new EmailNotifier();

        System.out.println("Email Only:");
        notifier.send();

        System.out.println();

        System.out.println("Email + SMS:");
        Notifier smsNotifier = new SMSNotifierDecorator(new EmailNotifier());
        smsNotifier.send();

        System.out.println();

        System.out.println("Email + SMS + Slack:");
        Notifier allNotifier =
                new SlackNotifierDecorator(
                        new SMSNotifierDecorator(
                                new EmailNotifier()));

        allNotifier.send();
    }
}