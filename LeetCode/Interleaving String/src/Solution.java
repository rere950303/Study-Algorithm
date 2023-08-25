// https://leetcode.com/problems/interleaving-string/

class Solution {
	public boolean isInterleave(String s1, String s2, String s3) {
		int s1Length = s1.length();
		int s2Length = s2.length();
		int s3Length = s3.length();

		if (s1Length + s2Length != s3Length) {
			return false;
		}

		boolean[] dp = new boolean[s2Length + 1];

		dp[0] = true;

		for (int i = 1; i <= s2Length; i++) {
			dp[i] = dp[i - 1] && s2.charAt(i - 1) == s3.charAt(i - 1);
		}

		for (int i = 1; i <= s1Length; i++) {
			dp[0] = dp[0] && s1.charAt(i - 1) == s3.charAt(i - 1);

			for (int j = 1; j <= s2Length; j++) {
				dp[j] = (dp[j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1)) || (dp[j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
			}
		}

		return dp[s2Length];
	}
}
