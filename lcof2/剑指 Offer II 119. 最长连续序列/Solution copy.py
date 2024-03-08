class SolutionCopy:
    # [100,4,200,1,102,3,101,2]
    def longestConsecutive(self, nums: List[int]) -> int:
        ans = 0
        s = set(nums)
        for x in s:
            if x - 1 not in s:
                y = x + 1
                while y in s:
                    y += 1
                ans = max(ans, y - x)

        return ans


def longestConsecutive(nums: List[int]) -> int:
    ans = 0
    s = set(nums)
    for x in s:
        if x - 1 not in s:
            y = x + 1
            while y in s:
                y += 1
            ans = max(ans, y - x)

    return ans
