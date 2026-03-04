package com.ontariotechu.sofe3980U;

/**
 * Unsigned integer Binary variable
 *
 */
public class Binary
{
	private String number="0";  // string containing the binary value '0' or '1'
	/**
	* A constructor that generates a binary object.
	*
	* @param number a String of the binary values. It should contain only zeros or ones with any length and order. otherwise, the value of "0" will be stored.   Trailing zeros will be excluded and empty string will be considered as zero.
	*/
	public Binary(String number) {
		if (number == null || number.isEmpty()) {
			this.number = "0"; // Default to "0" for null or empty input
			return;
		}
	
		// Validate the binary string (only '0' or '1' allowed)
		for (int i = 0; i < number.length(); i++) {
			char ch = number.charAt(i);
			if (ch != '0' && ch != '1') {
				this.number = "0"; // Default to "0" for invalid input
				return;
			}
		}
	
		// Remove leading zeros
		int beg;
		for (beg = 0; beg < number.length(); beg++) {
			if (number.charAt(beg) != '0') {
				break;
			}
		}
	
		// If all digits are '0', ensure number is "0"
		this.number = (beg == number.length()) ? "0" : number.substring(beg);
	
		// uncomment the following code
		if (this.number.isEmpty()) { // replace empty strings with a single zero
			this.number = "0";
		}
	}
	/**
	* Return the binary value of the variable
	*
	* @return the binary value in a string format.
	*/
	public String getValue()
	{
		return this.number;
	}
	/**
	* Adding two binary variables. For more information, visit <a href="https://www.wikihow.com/Add-Binary-Numbers"> Add-Binary-Numbers </a>.
	*
	* @param num1 The first addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of <i>num1+num2</i>.
	*/
	public static Binary add(Binary num1,Binary num2)
	{
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;
		//initial variable
		int carry=0;
		String num3="";  // the binary value of the sum
		while(ind1>=0 ||  ind2>=0 || carry!=0) // loop until all digits are processed
		{
			int sum=carry; // previous carry
			if(ind1>=0){ // if num1 has a digit to add
				sum += (num1.number.charAt(ind1)=='1')? 1:0; // convert the digit to int and add it to sum
				ind1--; // update ind1
			}
			if(ind2>=0){ // if num2 has a digit to add
				sum += (num2.number.charAt(ind2)=='1')? 1:0; // convert the digit to int and add it to sum
				ind2--; //update ind2
			}
			carry=sum/2; // the new carry
			sum=sum%2;  // the resultant digit
			num3 =( (sum==0)? "0":"1")+num3; //convert sum to string and append it to num3
		}
		Binary result=new Binary(num3);  // create a binary object with the calculated value.
		return result;
	}

	/**
	* Applying Bitwise OR to two binary variables.
	*
	* @param num1 The first addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of <i>num1 OR num2</i>.
	*/
	public static Binary or(Binary num1, Binary num2) {
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;

		String num3="";  // the binary value of the result
		while(ind1>=0 || ind2>=0) // loop until all digits are processed
		{
			char b1 = (ind1 >= 0) ? num1.number.charAt(ind1) : '0'; // catching out of bounds indices and defaulting them to 0
			char b2 = (ind2 >= 0) ? num2.number.charAt(ind2) : '0';

			num3 = ((b1 == '1' || b2 == '1') ? "1" : "0") + num3;

			ind1--;
			ind2--;
		}
		Binary result=new Binary(num3);  // create a binary object with the calculated value
		return result;
	}

	/**
	* Applying Bitwise AND to two binary variables.
	*
	* @param num1 The first addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of <i>num1 AND num2</i>.
	*/
	public static Binary and(Binary num1, Binary num2) {
		// the index of the first digit of each number
		int ind1=num1.number.length()-1;
		int ind2=num2.number.length()-1;

		String num3="";  // the binary value of the result
		while(ind1>=0 || ind2>=0) // loop until all digits are processed
		{
			char b1 = (ind1 >= 0) ? num1.number.charAt(ind1) : '0'; // catching out of bounds indices and defaulting them to 0
			char b2 = (ind2 >= 0) ? num2.number.charAt(ind2) : '0';

			num3 = ((b1 == '1' && b2 == '1') ? "1" : "0") + num3;

			ind1--;
			ind2--;
		}
		Binary result=new Binary(num3);  // create a binary object with the calculated value
		return result;
	}

	/**
	* Multiplying two binary variables.
	*
	* @param num1 The first addend object
	* @param num2 The second addend object
	* @return A binary variable with a value of <i>num1 * num2</i>.
	*/
	public static Binary multiply(Binary num1, Binary num2) {
		// the index of the first digit of each number
		int ind1 = num1.number.length()-1;
		int ind2 = num2.number.length()-1;
		int counter = 0;

		Binary num3 = new Binary("0");  // the binary value of the result
		String sum = ""; // current sum
		for(int i = ind2; i >= 0; i--) { // outer loop: controls num2
			for(int j = ind1; j >= 0; j--) { // inner loop: controls num1
				sum = (Integer.parseInt(String.valueOf(num1.number.charAt(j))) * Integer.parseInt(String.valueOf(num2.number.charAt(i)))) + sum; // multiply
			}
			sum += "0".repeat(counter); // add padding like in actual multiplication
			counter++; // increment counter
			num3 = add(new Binary(num3.number), new Binary(sum)); // add the numbers as we go
			sum = ""; // reset our number
		}
		return num3; // return out result
	}
}	