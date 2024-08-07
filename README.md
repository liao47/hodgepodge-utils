# hodgepodge-utils
> A hodgepodge of utils  
> 大杂烩工具类
# utils-parent
> 父pom
# common
> 公共包
# apt-utils
> annotation processing tool utils  
> 注解处理器，在编译期修改语法树的工具类  
> 此功能在编译期生成代码，所以本模块应先编译好以jar包形式引入到使用的工程中才会起作用
> ## ToString
>> 生成toString，使用后会替换lombok或者手写的toString，  
>> 可配合@Mask做掩码操作，可配合@Format格式化
>> * includeFieldNames 是否包含字段名
>> * exclude 排除字段，如果of与exclude同时不为空，则以of为准，exclude不生效
>> * of 使用的字段
>> * callSuper 是否调用super的toString
>> * doNotUseGetters 是否不使用getter获取值
>> * layer 是否分层
>> * brackets 括号
>> * orders 排序字段  
layer = true 分层的情况下，只对本类字段进行排序，不会影响父类toString；  
com.liao47.common.constants.OrderConstants常量指定不在列表内其他字段的排序位置和排序方式，填写多个常量以第一个为准，其他忽略，例：  
类中包含字段：c, a, b, y, x，则：orders =  
{"x", OrderConstants.DEFAULT, "y"} → {"x", "c", "a", "b", "y"}  
{OrderConstants.ASC, "x", "y"} → {"a", "b", "c", "x", "y"}  
{"x", "y", OrderConstants.DESC} → {"x", "y", "c", "b", "a"}  
OrderConstants.ASC → {"a", "b", "c", "x", "y"}
# custom-validator
> 自定义验证器
> * BytesLength 字节长度校验
> * EnumValue 枚举值校验
# common-utils
> 常用工具类
> * DateUtils 日期工具
> * HandyUtils | Handy 便利工具
> * Delays 延时任务处理器
> * EnumUtils 枚举工具
> * ImgUtils 图片工具
# extra-utils
> 外部依赖工具类
> * FtpUtils
> * EmailUtils
> * ZipUtils
# unionpay-sdk
> 基于Spring Boot开发的银联在线网关支付SDK  
> 使用用例详见：https://github.com/liao47/springboot-test  
> * com.liao47.controller.UnionPayController  
> * src/test/java/com/liao47/unionpay.http