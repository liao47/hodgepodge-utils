import com.github.liao47.leetcode.P1161MaximumLevelSumOfABinaryTree;
import com.github.liao47.leetcode.P1163;
import com.github.liao47.leetcode.bo.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author liaoshiqing
 * @date 2022/8/5 15:01
 */
public class LeetCode1160To1169Test {
    @Test
    public void test1161() {
        P1161MaximumLevelSumOfABinaryTree solver = new P1161MaximumLevelSumOfABinaryTree();
        TreeNode root = TreeNode.of(new Integer[]{1, 7, 0, 7, -8, null, null});
        Assert.assertEquals(2, solver.maxLevelSum(root));
        root = TreeNode.of(new Integer[]{989, null, 10250, 98693, -89388, null, null, null, -32127});
        Assert.assertEquals(2, solver.maxLevelSum(root));
        root = TreeNode.of(new Integer[]{-100, -200, -300, -20, -5, -10, null});
        Assert.assertEquals(3, solver.maxLevelSum(root));
        root = TreeNode.of(new Integer[]{13171, -81515, -73398, 77600, -72355, -3202, -21053, -63874, 72224, -82579,
                -48889, 23608, -97350, 36271, 37192, -73110, -91952, null, 83521, null, null, -9705, 59939, -73253,
                -33787, -63122, 70517, -59000, 10129, 56083, 39890, -52298, -65880, null, null, 83418, null, 23583,
                null, null, null, -57126, 75376, -7445, -7248, 2489, 76565, -32310, 10674, 90604, -72537, null, 22668
                , null, null, 95352, -21874, 22232, null, -5294, 80407, -67171, null, 31704, null, 91308, -7594,
                -78604, 19025, 67267, -77291, 76304, 42538, null, null, 52266, 28963, 10548, -83680, -73993, -34973,
                92486, 24962, -38957, 60112, 16387, -65336, -69019, 61043, -38651, 66701, null, null, null, -38904,
                -39798, null, null, null, null, null, 7854, 78521, 83159, -62627, 64476, 82722, 76621, 97881, null,
                97927, null, -61198, -79412, -63423, 63063, null, 59234, 1941, -58826, 66997, 9541, null, 18868,
                -4682, 29163, -23111, 4536, 14103, -89206, -46618, null, -24742, null, null, 24968, 5176, null,
                -81531, -97962, -23289, -26577, 26409, 62828, -12789, -48569, -79984, -36342, -94631, null, null,
                null, null, -2589, 10547, 16959, null, -43452, -17191, null, 10161, -32741, null, -12, -14284, 62759,
                20293, -26963, 88006, null, null, 89410, -80809, null, null, null, -8806, 85814, 46323, -21735, 29370
                , -42661, 94181, 31482, 13775, 64839, 83715, null, -99517, null, null, null, null, -46453, -45443,
                -66624, null, -24067, -34714, null, 15683, 8745, null, null, null, 61847, -67707, null, null, -57063,
                -37962, null, 43954, null, null, null, null, 49491, null, 55456, 38728, 8832, -5824, 82110, 96962,
                -80251, -15089, -27394, null, null, null, -23701, null, 17725, 33256, -61809, 72757, null, -7054,
                66355, null, 53755, null, null, null, 6973, -87875, -19888, 80216, -92101, -70538, 7689, null, -82798
                , null, -1280, -93539, null, -9124, null, 53718, -4108, 57801, null, 65548, null, 13006, null, null,
                null, null, null, 91916, -92677, null, null, 97031, -1321, -99937, 9534, null, null, null, 48376,
                null, -94614, 60372, -51044, -6843, 85461, -67410, null, null, -8468, -25880, -91277, null, null,
                null, null, 94601, null, null, null, null, null, null, 39782, -40576, null, null, null, null, null,
                null, 54943, -84214, null, -12438, 11203, -72399, null, 45019, -90707, 21113, -93304, null, null,
                1802, -23123, -70262, null, null, 62197, null, 6248, -72395, -65392, null, null, null, 9373, -24523,
                null, -53363, -10770, null, -23316, 95502, 95703, 46699, -22982, -29201, 30187, 17254, null, null,
                8957, -20717, null, null, null, null, 38984, null, null, -48612, 26691, 65879, null, -17144, null,
                null, -65213, 37405, null, null, 97977, null, null, null, null, null, -45248, null, null, -22739,
                -2593, 86112, null, null, null, null, null, null, null, 17104, null, null, -51384, -84834, null, null
                , 37914, 2114, 58557, null, -77325, null, null, null, 3870, null, 40356, 23440, null, -42850, 26177,
                null, 30463, -61485, -45971, -54194, -90581, null, null, 23440, -89991, -29136, 52467, 24091, -68407,
                null, -6834, -31191, 79940, 64867, null, null, -62438, null, null, -79574, null, null, null, -7186,
                50169, 65678, 73852, -2362, null, null, null, null, null, null, 29898, -78669, 54947, -62702, 75179,
                -99153, 10044, 75240, -55893, -2534, 22470, -87671, null, -15939, null, 59687, 705, -66680, null,
                null, null, 15152, null, null, null, 90888, null, 36054, null, null, 80065, -85444, 83108, null,
                -13442, null, null, null, null, null, -7523, 32934, null, -43383, null, -77835, null, null, -20622,
                null, null, -92299, null, 81344, null, null, null, -98117, -63063, null, null, null, null, null, null
                , 3577, null, null, -24059, null, 42923, null, null, null, -33053, -88298, 87070, 94216, null, 7118,
                null, null, null, -68182, null, 87785, null, null, null, null, null, null, null, null, null, null,
                null, null, null, null, 579, -46316, -89371, null, null, 11665, null, null, -86947, 9248, null, null,
                null, null, null, null, null, 23906, -50982, 37287, null, null, -86263, 12011, 74721, -25710, null,
                null, 11769, -69996, -81564, 64400, 99752, 28151, 83236, 42494, null, 98342, null, null, null, null,
                10639, -9444, 67870, 95812, null, null, null, null, -85061, null, -31317, null, 50465, null, null,
                94360, -42287, -99020, 65141, -22315, -77972, -59065, -54552, null, null, null, null, 9319, null,
                null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null,
                58740, null, null, null, null, null, null, -60320, -44877, null, null, 16604, 7777, null, null, null,
                null, null, null, null, 36331, 86121, null, null, -11431, -90778, 509, 1366, -64763, -41590, 56392,
                57603, null, null, -78817, -51754, 99252, null, 1861, null, null, 69870, -76131, 48958, 37117, -5041,
                49227, 28534, 94815, 96999, null, null, null, -68325, -75738, null, 34248, 15963, null, null, null,
                null, null, null, null, null, null, null, 65983, 84069, 44382, null, null, null, -82150, -23388, null
                , null, null, null, null, null, -51781, null, -51026, null, null, 27445, -33781, null, null, -21309,
                -33295, null, -69552, null, null, null, null, null, null, null, 99753, null, 66976, -66125, 56840,
                null, -49877, -10900, null, null, null, -21518, null, -14935, 39296, -60319, null, -50422, 79908,
                -98317, null, -3235, -21630, -61334, -70599, 80739, 67065, null, -91490, 28930, -6532, -97791, -59662
                , null, null, 38104, null, 91221, -71528, -51404, 97818, null, null, null, null, null, -12179, null,
                null, null, null, null, -97388, 78921, null, 84791, -68136, null, null, null, null, null, null, null,
                -62563, null, null, null, null, null, null, -46526, 96077, 84181, -37361, 4445, -59048, 68030, null,
                null, null, null, 65756, null, null, null, null, null, null, null, null, null, 94498, null, -75496, -39578, null, null, null, null, -19322, null, null, 3232, -94333, null, null, null, null, null, null, -45480, null, null, null, null, 8817, 85150, -13311, null, null, null, null, null, null, null, null, null, -94698, null, -39088, -22305, null, -16576, null, null, null, null, null, null, null, null, 697, 2767, null, 70129, -38771, null, 16543, null, null, -67679, null, null, null, null, null, 32869, 16545, null, -84230, null, -99934, null, -50068, null, null, null, 49893, null, null, null, null, null, null, null, null, null, null, -93013, null, null, null, -22006, null, -19965, 1618, null, null, 16424, null, null, 56923, -35000, null, null, 65704, null, null, null, null, null, null, null, -62806, null, null, null, null, -83506, null, null, null, null, null, 20820, 60564, -70903, null, null, null, 65692, null, null, 19398, null, null, null, null, null, -77650, null, null, -25440, 5752, null, -89520, -77808, 77780, 21224, null, null, null, null, null, null, null, null, 70932});
        Assert.assertEquals(9, solver.maxLevelSum(root));
    }

    @Test
    public void test1163() {
        P1163 solver = new P1163();
        Assert.assertEquals("bab", solver.lastSubstring("abab"));
        Assert.assertEquals("tcode", solver.lastSubstring("leetcode"));
        Assert.assertEquals("xxbx", solver.lastSubstring("xxbbxxbx"));
        Assert.assertEquals("caacaacaa", solver.lastSubstring("caacaacaa"));
    }
}
