package alien_dict

// WARNING: this has bugs

/*
Input：	words = ["wrt","wrf","er","ett","ettt","etta","rftt"]
Output："wertf"

	  [ t, f ] -> t f
		[ w, e ] -> -> w e r t f
		[ r, t ] -> r t f
		[ t, a ] -> -> ?
		[ q, r ] -> -> ?
		[ e, r ] -> e r t f
		// [ t, a ]

		[ w, e, r, t, f ]
*/
func Solution(words *[]string) string {
	pairs := [][2]rune{}

	for i, w := range *words {
		if i == len(*words)-1 {
			break
		}

		w2Runes := []rune((*words)[i+1])
		for j, c := range w {
			if j > len(w2Runes)-1 {
				break
			}
			c2 := w2Runes[j]
			if c != c2 {
				pairs = append(pairs, [2]rune{c, c2})
				break
			}
		}
	}

	alphabets := pairs[0][0:]
	pairs = pairs[1:]
	for {
		leftPairs := [][2]rune{}
		hasMatch := false
		for i := 0; i < len(pairs); i++ {
			pair := pairs[i]
			if alphabets[0] == pair[1] {
				alphabets = append(pair[0:1], alphabets...)
				hasMatch = true
			} else if alphabets[len(alphabets)-1] == pair[0] {
				alphabets = append(alphabets, pair[1])
				hasMatch = true
			} else {
				leftPairs = append(leftPairs, pair)
			}
		}
		pairs = leftPairs

		if len(leftPairs) == 0 {
			return string(alphabets)
		}
		if !hasMatch {
			return ""
		}
	}
}
