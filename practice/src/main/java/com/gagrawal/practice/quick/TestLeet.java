package com.gagrawal.practice.quick;

import java.util.*;

/**
 * @author Gaurav
 * 28/05/21
 */
public class TestLeet {

//    public static List<List<Integer>> threeSum(int[] nums) {
//
//        Set<List<Integer>> output = new HashSet<>();
//        if(nums.length < 3) {
//            return new ArrayList<>(output);
//        }
//        Map<Integer, Integer> map = new HashMap<>();
//        for(int num : nums) {
//            map.put(num, map.getOrDefault(num, 0) + 1);
//        }
//        for(int i = 0; i < nums.length; i++) {
//            int key = nums[i];
//            int val = map.get(key);
//            if(val > 0) {
//                map.put(key, val - 1);
//                two_sums(nums, i+1, key, (-key), map, output);
//            }
//        }
//        return new ArrayList<>(output);
//    }

//    private static void two_sums(int[] nums, int startIdx, int selectedElem, int target, Map<Integer, Integer> map, Set<List<Integer>> output) {
//
//        for(int i = startIdx; i < nums.length; i++) {
//
//            int elem = nums[i];
//            if(map.get(elem) > 0) {
//
//                int revisedTarget = target - elem;
//                if(revisedTarget == elem && map.get(elem) < 2) {
//                    continue;
//                }
//                if(map.containsKey(revisedTarget) && map.get(revisedTarget) > 0) {
//
//                    map.put(elem, map.get(elem) - 1);
//                    map.put(revisedTarget, map.get(revisedTarget) - 1);
//                    output.add(Arrays.asList(selectedElem, elem, revisedTarget));
//                }
//            }
//        }
//    }

    private static List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> output = new HashSet<>();
        if(nums.length < 3) {
            return new ArrayList<>(output);
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            List<Integer> indices = map.get(nums[i]);
            if(indices == null) {
                indices = new ArrayList<>();
                map.put(nums[i], indices);
            }
            indices.add(i);
        }
        for(int i = 0; i < nums.length; i++) {
            int key = nums[i];
            two_sums(nums, i, -key, map, output);
            map.get(key).remove(new Integer(i));
        }
        return new ArrayList<>(output);
    }

    private static void two_sums(int[] nums, int iIdx,int target, Map<Integer, List<Integer>> map, Set<List<Integer>> output) {

        Set<Integer> visitedIdx = new HashSet<>();
        for(int j = iIdx + 1; j < nums.length; j++) {

            if(visitedIdx.contains(j)) {
                continue;
            }
            int elem = nums[j];
            int revisedTarget = target - elem;
            if(map.containsKey(revisedTarget)) {
                Integer kIdx = null;
                for(int idx : map.get(revisedTarget)) {
                    if(idx != j && idx != iIdx && !visitedIdx.contains(idx)) {
                        kIdx = idx;
                        visitedIdx.add(kIdx);
                        visitedIdx.add(j);
                        break;
                    }
                }
                if(kIdx != null) {
                    List<Integer> arrs = Arrays.asList(nums[iIdx], nums[j], nums[kIdx]);
                    Collections.sort(arrs);
                    output.add(arrs);
                }
            }
        }
    }

    private static int lengthOfLongestSubstring(String s) {

        int[] chars = new int[128];
        int j = 0;
        int res = 0;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(chars[c] > 0) {
                while(j<i) {
                    chars[s.charAt(j)] = 0;
                    if(s.charAt(j) == c) {
                        j++;
                        break;
                    }
                    j++;
                }
            }
            chars[c]++;
            res = Math.max(res, i-j+1);
        }
        return res;
    }

    private static int[] maxSlidingWindow(int[] nums, int k) {
        if(k==1) {
            return nums;
        }
        int len = nums.length;
        int[] res = new int[len-k+1];
        int left = 0;
        int max = nums[0];
        int maxIdx = 0;
        for(int right = 0; right < len; right++) {
            //max = Math.max(max, nums[right]);
            if(nums[right] >= max) {
                max = nums[right];
                maxIdx = right;
            }
            if(right >= k-1) {
                res[left] = max;
                left++;
            }
            boolean cond = (right-left) == k-1;
            boolean originalCond = left >= k-1 && left < len-k+1;
            if(cond) {
                if(maxIdx >= left && maxIdx <= right) {
                    if(nums[left] > nums[right]) {
                        if(nums[left] > max) {
                            max = nums[left];
                            maxIdx = left;
                        }
                    }
                    else {
                        if(nums[right] > max) {
                            max = nums[right];
                            maxIdx = right;
                        }
                    }
                }
                else {
                    if(nums[left] > nums[right]) {
                        max = nums[left];
                        maxIdx = left;
                    }
                    else {
                        max = nums[right];
                        maxIdx = right;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
//        String s1 = "abce";
//        String s2 = "abcdfgh";
//        System.out.println(s2.indexOf(s1));
////        int[] prices = new int[]{3,0,-2,-1,1,2};
////        System.out.println(threeSum(prices));
////        String s = "tmmzuxt";
////        System.out.println(lengthOfLongestSubstring(s));
////        int[] nums = {9,10,9,-7,-4,-8,2,-6};
////        int k = 5;
////
////        //ip1:[1,3,-1,-3,5,3,6,7], 3
////        //op1 : [3,3,5,5,6,7]
////
////        //ip2:[1], 1
////        //op2: [1]
////
////        //ip3:[1,-1], 1
////        //op3: [1,-1]
////
////        //ip4:[9,11], 2
////        //op4:[11]
////
////        //ip5:[4,-2], 2
////        //op5:[4]
////
////        //ip6:[1,3,-1,-2,-5,-9,8],2
////        //op6: [3,3,-1,-2,-5,8]
////
////        //ip7:[1,2,3,1,-3,-1],2
////        //op7: [2,3,3,1,-1]
////
////        //ip8: [9,10,9,-7,-4,-8,2,-6], 5
////        //op8: [10,10,9,2]
////        System.out.println(Arrays.toString(maxSlidingWindow(nums,k)));
//        System.out.println(longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
//        int[] nums = {-1,1,0,-3,3};
//        int[] productOfArray = productExceptSelf(nums);
//        System.out.println(Arrays.toString(productOfArray));
//        int[][] mat = {
//                {1,2,3,4,5},
//                {6,7,8,9,10},
//                {11,12,13,14,15}
//        };
//        System.out.println(spiralMatrix(mat));
        int[] nums = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(nums));
    }

    private static int maxArea(int[] height) {
        int n = height.length - 1;
        int i = 0;
        int j = n-1;
        int area = Integer.MIN_VALUE;
        while(i < j) {
            area = Math.max(area, (j-i) * Math.min(height[i], height[j]));
            if(j-i == 1) {
                i++;
                j = n-1;
            }
            else {
                j--;
            }
        }
        return area;
    }

    private static List<Integer> spiralMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> out = new ArrayList<>(m*n);
        int rows = m - 1;
        int cols = n - 1;
        int i = 0;
        int j = 0;
        while(i < rows && j < cols) {
            f_row(matrix, i, j, cols-j, out);
            f_col(matrix, i+1, rows-(i+1), cols-j, out);
            if(rows-i != i) {
                r_row(matrix, rows-i, cols-j, j, out);
            }
            if(cols-j != j) {
                r_col(matrix, rows-(i+1), i+1, j, out);
            }
            i++;
            j++;
        }
        return out;
    }

    private static void f_row(int[][] matrix, int row, int start, int end, List<Integer> out) {
        for(int i = start; i <= end; i++) {
            out.add(matrix[row][i]);
        }
    }

    private static void r_row(int[][] matrix, int row,  int start, int end, List<Integer> out) {
        for(int i = start; i >= end; i--) {
            out.add(matrix[row][i]);
        }
    }

    private static void f_col(int[][] matrix, int start, int end, int col, List<Integer> out) {
        for(int i = start; i <= end; i++) {
            out.add(matrix[i][col]);
        }
    }

    private static void r_col(int[][] matrix, int start, int end, int col, List<Integer> out) {
        for(int i = start; i >= end; i--) {
            out.add(matrix[i][col]);
        }
    }

    private static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] prev_prod = new int[len];
        int[] fw_prod = new int[len];
        prev_prod[0] = 1;
        fw_prod[len-1] = 1;
        int i = 1;
        int j = len - 2;
        while(i<len && j >= 0) {
            prev_prod[i] = prev_prod[i-1] * nums[i-1];
            fw_prod[j] = fw_prod[j+1] * nums[j+1];
            i++;
            j--;
        }
        int[] out = new int[len];
        for(int k = 0; k < len; k++) {
            out[k] = prev_prod[k] * fw_prod[k];
        }
        return out;
    }

    private static String longestPalindrome(String s) {
        Set<String> hashSet = new HashSet<>();
        int len = s.length();
        for(int i = 0; i < len; i++) {
            StringBuilder st = new StringBuilder();
            st.append(s.charAt(i));
            for(int j = i+1; j <= len; j++) {
                hashSet.add(st.toString());
                if(j < len) {
                    st.append(s.charAt(j));
                }
            }
        }
        String max = "";
        for(String str : hashSet) {
            if(isPalindrome(str) && str.length() > max.length()) {
                max = str;
            }
        }
        return max;
    }

    private static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
