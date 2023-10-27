
class PaymentMethod{
	
}

class PayByDebitCard extends PaymentMethod{
	
}

class PayByNetBanking extends PaymentMethod{
	
}

class PayByUPI extends PaymentMethod{
	
}

class AmazonPay{
	
	PaymentMethod selectPaymentMethod(int option) {
		
		PaymentMethod method = null;
		
		if(option == 1) {

		}else if(option == 2) {

		}else if(option == 3) {

		}else {
			System.err.println("Select the Payment Method First");
		}
		
		
		return method;
		
	}
	
}

public class PracticalExercise2 {

	public static void main(String[] args) {
		
		AmazonPay pay = new AmazonPay();
		
		PaymentMethod method = pay.selectPaymentMethod(0);

	}

}
