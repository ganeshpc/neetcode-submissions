class Solution {
    public int lengthOfLIS(int[] nums) {
        int len = 0; 
        int n = nums.length;
        int[] endings = new int[n];

        for (int i=0; i<n; i++) {
            int lower = lowerBound(endings, len, nums[i]);
            endings[lower] = nums[i];

            len = Math.max(len, lower+1);
        }

        System.out.println(Arrays.toString(endings));
        
        return len;
    }

    int lowerBound(int[] arr, int len, int target) {

        for (int i=0; i<len; i++) {
            if (arr[i] >= target) {
                return i;
            }
        }

        return len;
    }
}
