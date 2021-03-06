package com.alogic.remote.call;

import com.anysoft.util.Configurable;
import com.anysoft.util.Reportable;
import com.anysoft.util.XMLConfigurable;

/**
 * 远程服务调用
 * 
 * @author duanyy
 *
 * 
 * @since 1.2.9
 * 
 * @version 1.2.9.1 [20141017 duanyy] <br>
 * - 实现Reportable接口 <br>
 * 
 * @version 1.6.3.21 [20150507 duanyy] <br>
 * - 增加全局序列号的支持 <br>
 * 
 * @version 1.6.8.13 [duanyy 20170427] <br>
 * - 从alogic-remote中迁移过来 <br>
 * 
 * @version 1.6.8.15 [20170511 duanyy] <br>
 * - 增加绝对路径调用功能 <br>
 */
public interface Call extends AutoCloseable,XMLConfigurable,Reportable,Configurable{
	
	/**
	 * 创建参数实例
	 * @return 参数实例
	 */
	public Parameters createParameter();
	
	/**
	 * 执行运程调用
	 * @param paras 调用参数
	 * @return 调用结果
	 */
	public Result execute(Parameters paras) ;
	
	/**
	 * 执行运程调用
	 * @param path 调用路径
	 * @param paras 调用参数
	 * @return 调用结果
	 */
	public Result execute(String path,Parameters paras) ;
	
	/**
	 * 执行运程调用
	 * @param paras 调用参数
	 * @param sn 全局序列号
	 * @param order 调用序号
	 * @return 调用结果
	 */
	public Result execute(Parameters paras,String sn,String order);	
	
	/**
	 * 执行运程调用
	 * @param paras 调用路径
	 * @param sn 全局序列号
	 * @param order 调用序号
	 * @return 调用结果
	 */
	public Result execute(String path,Parameters paras,String sn,String order) ;
}
