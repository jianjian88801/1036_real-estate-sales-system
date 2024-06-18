package com.entity.view;

import com.entity.FangzihuxingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 房子户型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-13 12:37:12
 */
@TableName("fangzihuxing")
public class FangzihuxingView  extends FangzihuxingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FangzihuxingView(){
	}
 
 	public FangzihuxingView(FangzihuxingEntity fangzihuxingEntity){
 	try {
			BeanUtils.copyProperties(this, fangzihuxingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
