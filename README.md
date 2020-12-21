# SpringBoot
2020/11/30
问题点：
 1.商品没有加表示默认地址的字段
 2.POST接口使用json传Int或者String数据接收不到,只能使用实体类接收 需要解决
完成点：
 1.收货地址的新建 修改 删除 查询接口，也测试完成！


优化建议：
1.MsgConst 可以使用interface
2.lombok 技术
3.jwt加自己拦截器
4.输出用log.info
5.命名规范
6.sql异常使用统一的全局异常类进行接收以及@transitional处理事务 exceptionHanlder
7.参数校验 @noBlank  @notEmpty  判断list是否为空使用Collection.isEmpty  实体类传参 使用@Validated 或者@valid   这些注解需要了解使用@NotBlank @NotNull @JsonFormat  
8.Service 单个bean对象的时候 没有必要加this
9.反射，jdk代码 jdk代理，cglib代理  jpa  mybatis plus
