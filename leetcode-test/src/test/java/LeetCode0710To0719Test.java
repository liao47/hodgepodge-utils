import com.alibaba.fastjson.JSON;
import com.github.liao47.leetcode.P0714BestTimeToBuyAndSellStockWithTransactionFee;
import com.github.liao47.leetcode.P0715RangeModule;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author liao47
 * @date 2020/12/17 9:53
 */
public class LeetCode0710To0719Test {
    @Test
    public void test0714() {
        P0714BestTimeToBuyAndSellStockWithTransactionFee solver = new P0714BestTimeToBuyAndSellStockWithTransactionFee();

        int[] arr = {1, 3, 2, 8, 4, 9};
        assertEquals(8, solver.maxProfit(arr, 2));
        arr = new int[]{1, 5, 3, 6};
        assertEquals(3, solver.maxProfit(arr, 2));
        arr = new int[]{1, 3, 5, 4, 7, 9};
        assertEquals(6, solver.maxProfit(arr, 2));
        arr = new int[]{4, 5, 2, 4, 3, 3, 1, 2, 5, 4};
        assertEquals(4, solver.maxProfit(arr, 1));
        arr = new int[]{2, 2, 1, 1, 5, 5, 3, 1, 5, 4};
        assertEquals(4, solver.maxProfit(arr, 2));
        arr = new int[]{1, 5, 4, 3, 2, 7};
        assertEquals(5, solver.maxProfit(arr, 2));
        arr = new int[]{5, 9, 1, 4, 4, 3, 2, 3, 4};
        assertEquals(3, solver.maxProfit(arr, 2));
        arr = new int[]{3, 6, 10, 6, 5, 4, 11};
        assertEquals(4, solver.maxProfit(arr, 5));

        arr = new int[]{1036, 2413, 2776, 825, 2640, 31, 1560, 2917, 4282, 783, 3146, 2600, 1939, 694, 4284, 3881,
                554, 167, 372, 4620, 3037, 1175, 1075, 3845, 4981, 4495, 3406, 4228, 2807, 4774, 4526, 3914, 2633,
                3762, 1570, 2334, 616, 1648, 1914, 2900, 349, 2428, 4013, 1964, 4020, 1882, 629, 240, 2595, 2902,
                3419, 292, 224, 4437, 4918, 632, 3701, 3840, 3996, 2129, 3345, 3979, 1954, 781, 1576, 1084, 3250,
                4517, 3106, 2133, 309, 4520, 2225, 4366, 4628, 1303, 4373, 1266, 3181, 558, 3855, 3447, 4335, 2115,
                4603, 661, 1715, 3972, 2846, 342, 686, 787, 273, 2575, 100, 2860, 3587, 4236, 3862, 2238, 3471, 3123,
                431, 4489, 1551, 596, 4037, 4986, 594, 2386, 326, 628, 1363, 2377, 4986, 3780, 3853, 2670, 2852, 3519
                , 2998, 4083, 3392, 2394, 1083, 3958, 4082, 1506, 2322, 2715, 4901, 2555, 4097, 3748, 4717, 3901,
                3329, 4616, 3334, 2603, 3705, 631, 3541, 555, 508, 464, 4495, 4463, 3616, 31, 2177, 3307, 1011, 2759,
                751, 1537, 1000, 292, 3921, 1442, 2726, 4677, 792, 82, 2580, 609, 4758, 3190, 1958, 913, 955, 1259,
                1634, 4729, 2672, 1761, 1467, 2347, 4295, 2049, 4708, 1452, 3411, 1428, 4078, 2627, 3785, 2432, 2916,
                492, 1108, 1691, 972, 3823, 4086, 2115, 1925, 1454, 291, 3266, 300, 2539, 2681, 2084, 4633, 1084,
                1061, 1043, 1304, 2205, 410, 4332, 2567, 703, 529, 4273, 3684, 308, 3164, 4876, 3108, 4993, 4555,
                1237, 4753, 549, 2795, 3426, 819, 2897, 825, 2514, 3419, 1854, 3209, 3766, 2794, 4117, 4668, 2162,
                1571, 2446, 1480, 974, 1090, 3903, 4655, 4452, 1451, 2953, 1241, 842, 1750, 3847, 3053, 4395, 4338,
                1493, 1660, 1569, 3418, 3029, 4416, 2056, 2283, 3392, 2032, 4354, 803, 4959, 3630, 2080, 1553, 873,
                4050, 1986, 2328, 55, 4602, 1430, 4238, 4326, 3382, 4845, 4968, 1903, 423, 4717, 2427, 4618, 2644,
                4541, 380, 3404, 4880, 2577, 1640, 189, 2692, 3788, 818, 4091, 4730, 611, 1776, 3594, 4746, 580, 2083
                , 4183, 3355, 3063, 658, 4532, 3318, 3902, 556, 2249, 4653, 2118, 1529, 4793, 4935, 4259, 3542, 1705,
                2839, 1436, 3918, 564, 3277, 2988, 2460, 3213, 4445, 4238, 1954, 2213, 1748, 939, 1149, 1408, 2408,
                1781, 1618, 1457, 2123, 3366, 826, 2094, 16, 1161, 3337, 1864, 433, 1303, 4800, 4667, 4769, 1026,
                3440, 1072, 4725, 6, 1263, 4184, 2728, 1315, 2091, 3032, 2071, 2672, 4557, 1916, 638, 2133, 2687,
                2408, 1677, 344, 697, 1699, 8, 480, 655, 2656, 4983, 455, 1611, 1726, 692, 392, 1921, 2555, 3549,
                3740, 3840, 3062, 3420, 2428, 1169, 4570, 389, 3509, 2169, 3290, 1680, 1733, 1765, 2518, 3260, 3644,
                765, 4521, 269, 2501, 4014, 1743, 239, 4908, 1656, 4433, 3647, 2612, 4872, 387, 3091, 4011, 564, 4421
                , 810, 3623, 3451, 4108, 1428, 475, 3755, 4484, 3527, 3062, 4706, 3424, 2678, 2411, 4446, 2556, 4305,
                1305, 646, 1458, 4471, 1689, 4556, 3851, 1245, 1197, 3785, 1175, 2904, 302, 2422, 4302, 2148, 2338,
                4288, 375, 2824, 1623, 3717, 1142, 4254, 192, 783, 1963, 2225, 1209, 1746, 3072, 2737, 4640, 4919,
                3614, 804, 4029, 1751, 2360, 3789, 4445, 2283, 2769, 2833, 4452, 2978, 2809, 4532, 4365, 2124, 3541,
                2658, 2902, 4688, 3980, 1543, 4041, 1420, 1452, 1284, 66, 19, 947, 932, 3244, 3374, 1910, 2561, 3466,
                4104, 1667, 589, 3048, 730, 1770, 1241, 2270, 4016, 2835, 604, 4771, 514, 3854, 3427, 1875, 2038,
                3067, 3216, 4732, 3735, 4440, 2855, 4958, 4569, 1685, 3539, 4589, 3512, 3143, 898, 3004, 3072, 2573,
                3163, 2522, 3927, 330, 3874, 363, 1900, 1629, 1156, 4259, 2747, 3445, 4513, 2867, 52, 3870, 1761, 619
                , 3308, 4380, 1101, 2592, 4852, 4140, 174, 3997, 4617, 3500, 3028, 907, 2355, 759, 374, 2429, 412,
                2132, 3973, 3583, 3028, 2070, 2235, 2659, 1053, 2558, 753, 1221, 1185, 2225, 1593, 3554, 3703, 332,
                2843, 3349, 3871, 4389, 6, 2768, 4382, 902, 417, 191, 2107, 2838, 4958, 3905, 4966, 3937, 1105, 4150,
                2682, 3396, 818, 2297, 2077, 2032, 3340, 2478, 127, 4379, 954, 2593, 3454, 1230, 2308, 3694, 2179,
                4134, 653, 3808, 4043, 2069, 660, 4515, 4189, 4876, 1784, 4166, 342, 1766, 3305, 1980, 1909, 4115,
                4115, 1461, 2061, 838, 3112, 122, 656, 4856, 4822, 3468, 2111, 2700, 4124, 4663, 2948, 3029, 4182,
                3847, 4760, 1323, 1505, 308, 128, 874, 583, 2671, 1315, 747, 2682, 2841, 67, 2712, 2703, 4471, 2952,
                3081, 464, 655, 57, 1460, 1395, 682, 2447, 2590, 4624, 1578, 64, 4060, 2975, 1236, 831, 3313, 1432,
                2589, 3777, 1868, 1720, 45, 3311, 4532, 2672, 454, 752, 4839, 4717, 748, 4323, 2999, 3491, 631, 1407,
                1453, 4611, 4263, 3366, 584, 2014, 2396, 1902, 4569, 3002, 1938, 3998, 4093, 1899, 3071, 2815, 1974,
                302, 1641, 2836, 565, 264, 1332, 3319, 3689, 2181, 3873, 4883, 3849, 1991, 4633, 4556, 3866, 142,
                2903, 3181, 740, 3311, 2071, 280, 714, 2440, 3950, 290, 3580, 738, 1604, 3631, 1989, 1299, 836, 1913,
                224, 1066, 1741, 1551, 1735, 4601, 2024, 4570, 4192, 1723, 3949, 3696, 1419, 1760, 697, 4764, 3405,
                4443, 199, 717, 4568, 3252, 2016, 2151, 1741, 2613, 2736, 4053, 814, 4282, 3392, 615, 1998, 3294,
                3663, 559, 4278, 4626, 55, 1418, 2056, 3191, 3181, 1732, 1887, 2517, 3180, 2154, 2166, 3096, 3930, 2721,
                4332, 427, 4332, 4237, 3928, 2262, 4657, 2202, 922, 3711, 1921, 4728, 2236, 2441, 622, 233, 293, 1466,
                1891, 1222, 3693, 3261, 2605, 3486, 102, 3612, 1897, 2698, 3524, 3567, 613, 3834, 1583, 1482, 4734,
                2339, 752, 1428, 4121, 3267, 3518, 4652, 3119, 1818, 4596, 3181, 3159, 4069, 3375, 3762, 1386, 3054,
                3052, 67, 2246, 1493, 2738, 2835, 4906, 303, 1107, 3111, 1525, 1739, 437, 2941, 545, 1458, 993, 1871, 640, 4047, 2017, 4971, 4917, 701, 4811, 4335, 3221, 4187, 4414, 756, 3069, 3052, 812, 3135, 928, 1264, 3356, 4518, 2136, 2691, 2638, 3156, 4909, 2944, 3920, 4609, 1856, 654, 4643, 2932, 309, 3613, 4479, 4173, 1848, 165, 1171, 592, 3233, 3151, 4009, 3952, 2624, 38, 2616, 2056, 841, 1764, 4667, 1526, 125, 3963, 933, 3951, 2151, 2110, 4666, 1000, 1985, 3868, 2735, 635, 277, 1129, 572, 2136, 980, 2731, 556, 3012, 2900, 2180, 1912, 2799, 1771, 4441, 2666, 3958, 4381, 3677, 4218, 1276, 3512, 4868, 4579, 2307, 3952, 3544, 651, 1300, 218, 489, 2837, 3737, 509, 3421, 879, 4353, 4695};
        assertEquals(595352, solver.maxProfit(arr, 655));
    }

    @Test
    public void test0715() {
        P0715RangeModule.RangeModule rangeModule = new P0715RangeModule.RangeModule();
        rangeModule.addRange(10, 20);
        rangeModule.removeRange(14, 16);
        Assert.assertTrue(rangeModule.queryRange(10, 14));
        Assert.assertFalse(rangeModule.queryRange(13, 15));
        Assert.assertTrue(rangeModule.queryRange(16,17));
        rangeModule.addRange(13, 15);
        Assert.assertTrue(rangeModule.queryRange(11, 15));
        Assert.assertFalse(rangeModule.queryRange(11, 16));

        rangeModule = new P0715RangeModule.RangeModule();
        rangeModule.addRange(10, 180);
        rangeModule.addRange(150, 200);
        rangeModule.addRange(250, 500);
        Assert.assertTrue(rangeModule.queryRange(50, 100));
        Assert.assertFalse(rangeModule.queryRange(180, 300));
        Assert.assertFalse(rangeModule.queryRange(600, 1000));
        rangeModule.removeRange(50, 150);
        Assert.assertFalse(rangeModule.queryRange(50, 100));

        rangeModule = new P0715RangeModule.RangeModule();
        rangeModule.addRange(5, 8);
        Assert.assertFalse(rangeModule.queryRange(3, 4));
        rangeModule.removeRange(5, 6);
        rangeModule.removeRange(3, 6);
        rangeModule.addRange(1, 3);
        Assert.assertTrue(rangeModule.queryRange(2, 3));
        rangeModule.addRange(4, 8);
        Assert.assertTrue(rangeModule.queryRange(2, 3));
        rangeModule.removeRange(4, 9);

        rangeModule = new P0715RangeModule.RangeModule();
        rangeModule.addRange(1, 3);
        rangeModule.addRange(5, 8);
        Assert.assertFalse(rangeModule.queryRange(4, 5));

        rangeModule = new P0715RangeModule.RangeModule();
        rangeModule.addRange(8, 9);
        Assert.assertFalse(rangeModule.queryRange(1, 8));
        rangeModule.removeRange(1, 8);
        Assert.assertFalse(rangeModule.queryRange(5, 8));
        rangeModule.removeRange(3, 9);
        rangeModule.addRange(8, 9);
        Assert.assertFalse(rangeModule.queryRange(4, 5));
        rangeModule.removeRange(2, 9);
        rangeModule.addRange(5, 6);

        String optStr = "[\"RangeModule\",\"queryRange\",\"queryRange\",\"addRange\",\"addRange\",\"queryRange\"," +
                "\"queryRange\",\"queryRange\",\"removeRange\",\"addRange\",\"removeRange\",\"addRange\"," +
                "\"removeRange\",\"removeRange\",\"queryRange\",\"queryRange\",\"queryRange\",\"queryRange\"," +
                "\"removeRange\",\"addRange\",\"removeRange\",\"queryRange\",\"addRange\",\"addRange\"," +
                "\"removeRange\",\"queryRange\",\"removeRange\",\"removeRange\",\"removeRange\",\"addRange\"," +
                "\"removeRange\",\"addRange\",\"queryRange\",\"queryRange\",\"queryRange\",\"queryRange\"," +
                "\"queryRange\",\"addRange\",\"removeRange\",\"addRange\",\"addRange\",\"addRange\",\"queryRange\"," +
                "\"removeRange\",\"addRange\",\"queryRange\",\"addRange\",\"queryRange\",\"removeRange\"," +
                "\"removeRange\",\"addRange\",\"addRange\",\"queryRange\",\"queryRange\",\"addRange\",\"addRange\"," +
                "\"removeRange\",\"removeRange\",\"removeRange\",\"queryRange\",\"removeRange\",\"removeRange\"," +
                "\"addRange\",\"queryRange\",\"removeRange\",\"addRange\",\"addRange\",\"queryRange\"," +
                "\"removeRange\",\"queryRange\",\"addRange\",\"addRange\",\"addRange\",\"addRange\",\"addRange\"," +
                "\"removeRange\",\"removeRange\",\"addRange\",\"queryRange\",\"queryRange\",\"removeRange\"," +
                "\"removeRange\",\"removeRange\",\"addRange\",\"queryRange\",\"removeRange\",\"queryRange\"," +
                "\"addRange\",\"removeRange\",\"removeRange\",\"queryRange\"]";
        String paramStr = "[[],[21,34],[27,87],[44,53],[69,89],[23,26],[80,84],[11,12],[86,91],[87,94],[34,52],[1," +
                "59],[62,96],[34,83],[11,59],[59,79],[1,13],[21,23],[9,61],[17,21],[4,8],[19,25],[71,98],[23,94],[58," +
                "95],[12,78],[46,47],[50,70],[84,91],[51,63],[26,64],[38,87],[41,84],[19,21],[18,56],[23,39],[29,95]," +
                "[79,100],[76,82],[37,55],[30,97],[1,36],[18,96],[45,86],[74,92],[27,78],[31,35],[87,91],[37,84],[26," +
                "57],[65,87],[76,91],[37,77],[18,66],[22,97],[2,91],[82,98],[41,46],[6,78],[44,80],[90,94],[37,88]," +
                "[75,90],[23,37],[18,80],[92,93],[3,80],[68,86],[68,92],[52,91],[43,53],[36,37],[60,74],[4,9],[44," +
                "80],[85,93],[56,83],[9,26],[59,64],[16,66],[29,36],[51,96],[56,80],[13,87],[42,72],[6,56],[24,53]," +
                "[43,71],[36,83],[15,45],[10,48]]";
        String resultStr = "[null,false,false,null,null,false,true,false,null,null,null,null,null,null,false,false," +
                "true,true,null,null,null,false,null,null,null,false,null,null,null,null,null,null,true,true,false," +
                "false,false,null,null,null,null,null,true,null,null,false,null,true,null,null,null,null,false,false," +
                "null,null,null,null,null,false,null,null,null,false,null,null,null,true,null,false,null,null,null," +
                "null,null,null,null,null,false,false,null,null,null,null,true,null,false,null,null,null,false]";
        test0715(optStr, paramStr, resultStr);

        optStr = "[\"RangeModule\",\"addRange\",\"removeRange\",\"removeRange\",\"addRange\",\"removeRange\"," +
                "\"addRange\",\"queryRange\",\"queryRange\",\"queryRange\"]";
        paramStr = "[[],[6,8],[7,8],[8,9],[8,9],[1,3],[1,8],[2,4],[2,9],[4,6]]";
        resultStr = "[null,null,null,null,null,null,null,true,true,true]";
        test0715(optStr, paramStr, resultStr);

        optStr = "[\"RangeModule\",\"addRange\",\"removeRange\",\"queryRange\",\"queryRange\",\"queryRange\"," +
                "\"removeRange\",\"removeRange\",\"removeRange\",\"addRange\",\"addRange\",\"addRange\"," +
                "\"removeRange\",\"addRange\",\"queryRange\",\"addRange\",\"addRange\",\"queryRange\",\"queryRange\"," +
                "\"addRange\",\"removeRange\",\"removeRange\",\"removeRange\",\"queryRange\",\"queryRange\"," +
                "\"addRange\",\"addRange\",\"queryRange\",\"addRange\",\"addRange\",\"removeRange\",\"addRange\"," +
                "\"addRange\",\"queryRange\",\"removeRange\",\"queryRange\",\"removeRange\",\"addRange\"," +
                "\"addRange\",\"queryRange\",\"removeRange\",\"removeRange\",\"addRange\",\"queryRange\"," +
                "\"queryRange\",\"removeRange\",\"removeRange\",\"removeRange\",\"queryRange\",\"addRange\"," +
                "\"removeRange\",\"removeRange\",\"queryRange\",\"removeRange\",\"removeRange\",\"queryRange\"," +
                "\"addRange\",\"addRange\",\"removeRange\",\"queryRange\",\"queryRange\",\"addRange\"," +
                "\"removeRange\",\"removeRange\",\"addRange\",\"addRange\",\"addRange\",\"addRange\",\"queryRange\"," +
                "\"removeRange\",\"addRange\",\"addRange\",\"addRange\",\"queryRange\",\"addRange\",\"removeRange\"," +
                "\"queryRange\",\"removeRange\",\"removeRange\",\"removeRange\",\"queryRange\",\"queryRange\"," +
                "\"queryRange\",\"queryRange\",\"queryRange\",\"removeRange\",\"queryRange\",\"removeRange\"," +
                "\"queryRange\",\"addRange\",\"queryRange\"]";
        paramStr = "[[],[14,100],[1,8],[77,80],[8,43],[4,13],[3,9],[45,49],[41,90],[58,79],[4,83],[34,39],[84,100]," +
                "[8,9],[32,56],[35,46],[9,100],[85,99],[23,33],[10,31],[15,45],[52,70],[26,42],[30,70],[60,69],[10," +
                "94],[2,89],[26,39],[46,93],[30,83],[42,48],[47,74],[39,45],[14,64],[3,97],[16,34],[28,100],[19,37]," +
                "[27,91],[55,62],[64,65],[2,48],[55,78],[21,89],[31,76],[13,32],[2,84],[21,88],[12,31],[89,97],[56," +
                "72],[16,75],[18,90],[46,60],[20,62],[28,77],[5,78],[58,61],[38,70],[24,73],[72,96],[5,24],[43,49]," +
                "[2,20],[4,69],[18,98],[26,42],[14,18],[46,58],[16,90],[32,47],[19,36],[26,78],[7,58],[42,54],[42," +
                "83],[3,83],[54,82],[71,91],[22,37],[38,94],[20,44],[37,89],[15,54],[1,64],[63,65],[55,58],[23,44]," +
                "[25,87],[38,85],[27,71]]";
        resultStr = "[null,null,null,true,false,false,null,null,null,null,null,null,null,null,true,null,null,true," +
                "true,null,null,null,null,false,false,null,null,true,null,null,null,null,null,false,null,false,null," +
                "null,null,true,null,null,null,false,false,null,null,null,false,null,null,null,false,null,null,false," +
                "null,null,null,false,false,null,null,null,null,null,null,null,true,null,null,null,null,false,null," +
                "null,false,null,null,null,false,false,false,false,false,null,false,null,false,null,false]";
        test0715(optStr, paramStr, resultStr);
    }

    private void test0715(String optStr, String paramStr, String resultStr) {
        List<String> opts = JSON.parseArray(optStr, String.class);
        List<int[]> params = JSON.parseArray(paramStr, int[].class);
        List<Boolean> results = JSON.parseArray(resultStr, Boolean.class);

        P0715RangeModule.RangeModule rangeModule = new P0715RangeModule.RangeModule();
        for (int i = 0; i < opts.size(); i++) {
            String opt = opts.get(i);
            int[] param = params.get(i);
            System.out.printf("%s:%d:%s%n", opt, i, Arrays.toString(param));
            switch (opt) {
                case "RangeModule":
                    rangeModule = new P0715RangeModule.RangeModule();
                    break;
                case "queryRange":
                    Assert.assertEquals(rangeModule.queryRange(param[0], param[1]), results.get(i));
                    break;
                case "addRange":
                    rangeModule.addRange(param[0], param[1]);
                    break;
                case "removeRange":
                    rangeModule.removeRange(param[0], param[1]);
                    break;
                default:
            }
        }
    }
}
