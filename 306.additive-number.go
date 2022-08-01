/*
 * @lc app=leetcode id=306 lang=golang
 *
 * [306] Additive Number
 */

// @lc code=start
import (
	"strconv"
)

func isAdditiveNumber(num string) bool {
	if len(num) < 3 {
		return false
	}
	// start from the first 2 numbers
	// special case: number starting with 0 is invalid in this problem
	for i := 0; i < len(num)-2; i++ {
		if num[0] == '0' && i > 0 {
			break
		}
		cur, _ := strconv.Atoi(num[:i+1])
		for j := i + 1; j < len(num)-1; j++ {
			if num[i+1] == '0' && j > i+1 {
				break
			}
			next, _ := strconv.Atoi(num[i+1 : j+1])
			if find(cur, next, num[j+1:len(num)]) {
				
				// fmt.Printf("%v %v", cur, next)
				return true
			}
		}

	}
	return false
}

func find(first int, second int, num string) bool {
	/*
		description
			find the third number which will make the whole string an additive number
		first: the first number
		second: the second number
		num: the given string
	*/
	if len(num) == 0 {
		return true
	}
	third := first + second
	third_str := strconv.Itoa(third)
	if strings.HasPrefix(num, third_str) {
		if find(second, third, num[len(third_str):len(num)]) {
			return true
		}
	}
	return false

}

// @lc code=end

