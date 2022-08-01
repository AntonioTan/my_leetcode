/*
 * @lc app=leetcode id=357 lang=golang
 *
 * [357] Count Numbers with Unique Digits
 */

// @lc code=start
func cal_C(bot int, top int) int {
	/*
		description:
			calculate the value of C_n_k
			bot: n
			top: k
	*/
	sum := 1
	for i := bot; i >= bot+1-top; i-- {
		sum *= i
	}
	return sum/factorial(top)
}
func factorial(n int) int {
	rst := 1
	for i := n; i >= 1; i-- {
		rst *= i
	}
	return rst
}
func countNumbersWithUniqueDigits(n int) int {
	// Here is the mathematics formula
	// C_10_n*n!-C_9_n-1*(n-1)! if n>1
	// n==1 10
	if n == 0 {
		return 1
	}
	if n == 1 {
		return 10
	}
	sum := 10
	for i:=2; i<=n; i++ {
		sum += cal_C(10, i)*factorial(i) - cal_C(9, i-1)*factorial(i-1)
	} 
	return sum

}

// @lc code=end

