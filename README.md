# hodgepodge-utils
> A hodgepodge of utils  
> 大杂烩工具类
# utils-parent
> 父pom
# apt-utils
> annotation processing tool utils  
> 注解处理器，在编译期修改语法树的工具类
> ## ToString
>> 生成toString，使用后会替换lombok或者手写的toString，可配合@Mask做掩码操作
>> * includeFieldNames 是否包含字段名
>> * exclude 排除字段，如果of与exclude同时不为空，则以of为准，exclude不生效
>> * of 使用的字段
>> * callSuper 是否调用super的toString
>> * doNotUseGetters 是否不使用getter获取值
>> * layer 是否分层
>> * brackets 括号
>> * orders 排序字段  
layer = true 分层的情况下，只对本类字段进行排序，不会影响父类toString；  
com.liao47.constants.OrderConstants常量指定不在列表内其他字段的排序位置和排序方式，填写多个常量以第一个为准，其他忽略，例：  
类中包含字段：c, a, b, y, x，则：orders =  
{"x", OrderConstants.DEFAULT, "y"} → {"x", "c", "a", "b", "y"}  
{OrderConstants.ASC, "x", "y"} → {"a", "b", "c", "x", "y"}  
{"x", "y", OrderConstants.DESC} → {"x", "y", "c", "b", "a"}  
OrderConstants.ASC → {"a", "b", "c", "x", "y"}
# custom-validator
> 自定义验证器
> * BytesLength 字节长度校验
> * EnumPattern 枚举限制校验
# common-utils
> 常用工具类
> * FtpUtil
> * EmailUtil
