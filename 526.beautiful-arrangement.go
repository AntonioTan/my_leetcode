/*
 * @lc app=leetcode id=526 lang=golang
 *
 * [526] Beautiful Arrangement
 */

// @lc code=start
func countArrangement(n int) int {
	/*
		init an array containing numbers from 1 to n
	*/
	var nums []int
	for i := 1; i <= n; i++ {
		nums = append(nums, i)
	}
	rst := 0
	traverse(n, 1, nums, &rst)
	return rst

}
func traverse(n int, index int, nums []int, rst *int) {
	/*
		description:
			recursive function used to find beautiful arrangement
		n: count of numbers for use
		index: position of number on which we are deciding (1 based)
		nums: array of numbers
		rst: signal the result
	*/
	if index == n+1 {
		*rst += 1
		return
	}
	for i := 0; i < n; i++ {
		num := nums[i]
		if num < 0 {
			continue
		}
		if num%index == 0 || index%num == 0 {
			nums[i] *= -1
			traverse(n, index+1, nums, rst)
			nums[i] *= -1

		}
	}
}

// @lc code=end

