import java.util.*;

class Solution {
    public int uniqueXorTriplets(int[] nums) {
        // Step 1: Collect unique values from nums
        boolean[] hasU = new boolean[2048];
        int uniqueCount = 0;
        for (int num : nums) {
            if (!hasU[num]) {
                hasU[num] = true;
                uniqueCount++;
            }
        }
        
        int[] U = new int[uniqueCount];
        int idx = 0;
        for (int i = 0; i < 2048; i++) {
            if (hasU[i]) {
                U[idx++] = i;
            }
        }

        // Step 2: Compute all unique pair XOR results
        boolean[] hasP = new boolean[2048];
        List<Integer> P = new ArrayList<>();
        for (int i = 0; i < U.length; i++) {
            for (int j = i; j < U.length; j++) {
                int pairXor = U[i] ^ U[j];
                if (!hasP[pairXor]) {
                    hasP[pairXor] = true;
                    P.add(pairXor);
                }
            }
        }

        // Step 3: Compute all unique triplet XOR results
        boolean[] hasT = new boolean[2048];
        int ans = 0;
        for (int p : P) {
            for (int u : U) {
                int tripletXor = p ^ u;
                if (!hasT[tripletXor]) {
                    hasT[tripletXor] = true;
                    ans++;
                }
            }
        }

        return ans;
    }
}