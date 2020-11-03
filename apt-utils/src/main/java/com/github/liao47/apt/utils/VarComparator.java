package com.github.liao47.apt.utils;

import com.github.liao47.common.constants.OrderConstants;
import com.sun.tools.javac.tree.JCTree;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 成员变量排序比较器
 * @author liaoshiqing
 * @date 2020/10/27 11:46
 */
public class VarComparator implements Comparator<JCTree.JCVariableDecl> {

    /**
     * 排序字段权值集合
     */
    private final Map<String, Integer> orderMap;

    /**
     * 排序标识：0-默认，1-正序，-1-倒序
     */
    private int order;

    public VarComparator(String[] orders) {
        if (orders == null || orders.length == 0) {
            this.orderMap = null;
            return;
        }

        this.orderMap = new HashMap<>(orders.length);
        //使排序权值在指定常量之前小于0，之后大于0，从小到大
        int flag = -orders.length;
        for (int i = 0; i < orders.length; i++) {
            int orderTmp;
            if (OrderConstants.DEFAULT.equals(orders[i])) {
                orderTmp = 0;
            } else if (OrderConstants.ASC.equals(orders[i])) {
                orderTmp = 1;
            } else if (OrderConstants.DESC.equals(orders[i])) {
                orderTmp = -1;
            } else {
                this.orderMap.put(orders[i], flag + i);
                continue;
            }
            if (flag != 0) {
                //以第一个出现的常量为准，填写多个常量忽略后续的
                flag = 0;
                this.order = orderTmp;
            }
        }
    }

    @Override
    public int compare(JCTree.JCVariableDecl o1, JCTree.JCVariableDecl o2) {
        int result = this.getOrderVal(o1.getName().toString()).compareTo(this.getOrderVal(o2.getName().toString()));
        if (result == 0 && this.order != 0) {
            return this.order * o1.getName().toString().compareTo(o2.getName().toString());
        }
        return result;
    }

    /**
     * 获取排序权值
     * @param key
     * @return
     */
    private Integer getOrderVal(String key) {
        if (this.orderMap == null || this.orderMap.isEmpty()) {
            return 0;
        }
        Integer val = this.orderMap.get(key);
        return val == null ? 0 : val;
    }
}
