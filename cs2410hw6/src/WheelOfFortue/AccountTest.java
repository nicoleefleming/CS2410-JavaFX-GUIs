package WheelOfFortue;

    public class AccountTest {

        public static void main(String[] args) {

            Account a = new Account(0);
            System.out.println(a.credit(100)); // 100
            System.out.println(a.debit(50)); // --> 50
            System.out.println(a.debit(100)); // --> -50
            System.out.println(a.amount()); // -50
            System.out.println(a);
        }

    } // AccountTest

