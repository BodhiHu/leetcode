package solution

func twoSum(numbers []int, target int) *[2]int {
	for i, j := 0, len(numbers)-1; ; {
		if numbers[i]+numbers[j] < target {
			i++
		} else if numbers[i]+numbers[j] > target {
			j--
		} else {
			return &[2]int{i, j}
		}
	}

	return nil
}
