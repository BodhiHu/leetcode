class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        s = set(nums)
        ans = 0
        for x in nums:
            if x - 1 not in s:
                y = x + 1
                while y in s:
                    y += 1
                ans = max(ans, y - x)
        return ans

    # [ 5, 100, 4, 200, 1, 3, 2 ]
    def longestConsecutive2(self, nums: List[int]) -> int:
        pass
