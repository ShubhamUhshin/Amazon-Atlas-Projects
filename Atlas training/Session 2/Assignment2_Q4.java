public class Assignment2_Q4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String names = "Sarah Jane Taylor, Jhulan Nishit Goswami, Katherine Helen Brunt, Meghann Lanning, Mithali Dorai Raj";
		
		String[] array = names.split(", ");
		char ch;
		int count;
		String temp;
		String midname;
		for(String name: array) {
			count = 0;
			temp="";
			midname = "";
			for(int j=0;j<name.length();j++) {
				ch=name.charAt(j);
				if(ch==' ') {
					count++;
					if(count == 2) {
						//count = 0;
						midname = temp;
						break;
					}
					temp="";
					midname = "";
				}
				else {
					temp = temp+ch;
				}
			}
			if(count==2) {
				System.out.println("midname is: "+midname);
			}
			else {
				System.out.println("midname is: NULL");
			}
		}
	}

}