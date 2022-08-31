class Solution {
   public void sortColors(int[] nums) {
        // record the number of 0, 1, 2
        int zero = 0;
        int one = 0;
        int two = 0;
        for (int num : nums){
            if (num == 0){
                zero++;
            } else if (num == 1){
                one++; 
            } else {
                two++;
            }
        }

        // three pointers point to start of 0, 1, 2 area in the array
        int p0 = 0, p1 = zero, p2 = zero + one;
        int p0End = zero - 1, p1End = zero + one - 1, p2End = nums.length - 1;
        // first we clear the area of 1, make sure 1 area swap all 0 with 0 area
            while(p0 < zero){
            if(nums[p0] == 0){
                p0++;
                continue;
            }
            else if (nums[p0] == 1){
                p1 = find(nums, 0, p1, p1End);
                if (p1 == -1){
                    p2 = find(nums, 0, p2, p2End);
                    swap(nums, p0, p2);
                } else {
                    swap(nums, p0, p1);
                }
            }
            // p0 location is a 2
            else {
                p2 = find(nums, 0, p2, p2End);
                if (p2 == -1){
                    p1 = find(nums, 0, p1, p1End);
                    swap(nums, p0, p1);
                }
                else {
                    swap(nums, p0, p2);
                }
            }
        }
        p1 = zero; p2 = zero + one;
        while(p1 <= p1End && p2 <= p2End){
            while(p1 <= p1End && nums[p1] == 1){
                p1++;
            }
            while(p2 <= p2End && nums[p2] == 2){
                p2++;
            }
            if (p1 <= p1End && p2 <= p2End){
                swap(nums, p1, p2);
                p1++; p2++;
            }
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public int find(int[] nums, int target, int currPointer, int endPointer){
        if (currPointer == -1) return -1;
        
        while(currPointer <= endPointer){
            if (nums[currPointer] == target){
                return currPointer;
            }
            currPointer++;
        }
        return -1;
    }
}