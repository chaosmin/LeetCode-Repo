package tech.chaosmin.leetcode


/**
 * 837. 新21点 | 难度：中等
 *
 * 爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：
 * 爱丽丝以 0 分开始，并在她的得分少于 K 分时抽取数字。 抽取时，她从 [1, W] 的范围中随机获得一个整数作为分数进行累计，其中 W 是整数。 每次抽取都是独立的，其结果具有相同的概率。
 * 当爱丽丝获得不少于 K 分时，她就停止抽取数字。 爱丽丝的分数不超过 N 的概率是多少？
 *
 * ************************************
 *
 * 执行用时 :176 ms, 在所有 Kotlin 提交中击败了100.00%的用户
 * 内存消耗 :33.6 MB, 在所有 Kotlin 提交中击败了100.00%的用户
 *
 * @author romani min
 * @since 2020/6/3
 */
object T0837New21Game {
    fun new21Game(N: Int, K: Int, W: Int): Double {
        if (K == 0) {
            return 1.0
        }
        val dp = DoubleArray(K + W)
        {
            if (it <= N && it < K + W) 1.0
            else 0.0
        }
        dp[K - 1] = 1.0 * Math.min(N - K + 1, W) / W
        for (i in K - 2 downTo 0) {
            dp[i] = dp[i + 1] - (dp[i + W + 1] - dp[i + 1]) / W
        }
        return dp[0]
    }
}