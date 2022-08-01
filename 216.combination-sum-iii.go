/*
 * @lc app=leetcode id=216 lang=golang
 *
 * [216] Combination Sum III
 */

// @lc code=start
<<<<<<< HEAD
func combinationSum3(k int, n int) [][]int {
	// C
    
}
=======

// package main
// import "fmt"

func combinationSum3(k int, n int) [][]int {
	var rst = make([][]int, 0)
	var temp []int = make([]int, 0)
	find(k, 1, n, temp, &rst)
	return rst
}

func find(cnt int, cur int, target int, arr []int, rst *[][]int) {
	/*
		cnt: the number of numbers needed to be added to the list
		cur: the number start from which to iterate -> like cur to 9
		target: the remaining target number
		arr: array of numbers used to backtrack
		rst: final answer
	*/
	if cnt == 0 || cur > target || cur > 9 {
		return
	}
	var boundary int
	if target < 9 {
		boundary = target
	} else {
		boundary = 9
	}
	for next := cur; next <= boundary; next++ {
		if next == target {
			if cnt == 1 {
				tempArr := make([]int, len(arr))
				copy(tempArr, arr)
				*rst = append(*rst, append(tempArr, next))
				// fmt.Println(arr, rst)
			}
		} else {
			nextArr := append(arr, next)
			// fmt.Println(nextArr)
			find(cnt-1, next+1, target-next, nextArr, rst)
			// fmt.Println(cnt, next, boundary, nextArr, rst)
		}
	}

}

// func main() {
// 	fmt.Println(combinationSum3(8, 36))
// }


// @lc code=end

