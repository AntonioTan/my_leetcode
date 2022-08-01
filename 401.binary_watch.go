/*
 * @lc app=leetcode id=401 lang=golang
 *
 * [401] Binary Watch
 */
 
// @lc code=start
import "strconv"

func convertNumberToTime(hourMin bool, cur int) string {
	/*
	description: turn the number to hour or minute as in this problem the length of 
				 minute should be 2 using 0 to make it up like 01, 03
	*/
	time := strconv.Itoa(cur)
	if hourMin {
		return time
	} else {
		if cur<10 {
			time = "0"+time
		}
	}
	return time
}

func generateArr(turnedOn int, bit int, arr *[]string, hourMin bool, cur int) {
	/*
	description: 
		generate time based on the given number of turned on 
	turnedOn: the number of lights that are turned on
	bit: on which position we are working now (from right to left)
	arr: the result array
	hourMin: calculating hour or minute
	cur: current number for hour or minute
	*/ 
	if hourMin && bit>3 && turnedOn!=0 {
		return ;
	}
	if !hourMin && bit>5 && turnedOn!=0 {
		return ;
	}
	if turnedOn==0 {
		if (hourMin && cur>11) || (!hourMin && cur>59) {
			return ;
		}
		*arr = append(*arr, convertNumberToTime(hourMin, cur))
	} else {
		generateArr(turnedOn-1, bit+1, arr, hourMin, cur+int(math.Pow(2, float64(bit))))
		generateArr(turnedOn, bit+1, arr, hourMin, cur)
	} 

}

func readBinaryWatch(turnedOn int) []string {
    // split the turnedOn number to two numbers, 
	// one representing turned on lights for hour
	// one representing turned on lights for minute
	var rst []string
	for light_hour_num:=0; light_hour_num<=turnedOn; light_hour_num++ {
		var hourArr []string
		var minArr []string
		generateArr(light_hour_num, 0, &hourArr, true, 0)
		generateArr(turnedOn-light_hour_num, 0, &minArr, false, 0)
		for _, hour := range hourArr {
			for _, minute := range minArr {
				rst = append(rst, hour+":"+minute)
			}
		}
	}
	return rst
}

// @lc code=end

