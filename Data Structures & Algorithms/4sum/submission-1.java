class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int l = j + 1;
                int r = nums.length - 1;

                while (l < r) {
                    long sum = (long) nums[i] + nums[j] + nums[l] + nums[r];

                    if (sum > target) {
                        r--;
                    } 
                    else if (sum < target) {
                        l++;
                    }
                    else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l++;
                        r--;

                        while (l < r && nums[l-1] == nums[l]) {
                            l++;
                        }
                        
                    }
                }

            }
            

        }

        return res;
        
    }
}