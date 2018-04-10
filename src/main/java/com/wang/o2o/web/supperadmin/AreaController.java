package com.wang.o2o.web.supperadmin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wang.o2o.entity.Area;
import com.wang.o2o.service.AreaService;

@Controller
@RequestMapping("/supperadmin")
public class AreaController {
	@Autowired
	private AreaService areaService;
	@RequestMapping(value="/listarea",method=RequestMethod.GET)
	//自动转化为json返回前端 
	@ResponseBody
	private Map<String,Object> listArea(){
		Map<String,Object> modelMap=new HashMap<String,Object>();
		List<Area> list=new ArrayList<Area>();
		try{
			list=areaService.getAreaList();
			modelMap.put("rows",list);
			modelMap.put("total",list.size());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			modelMap.put("success",false);
			modelMap.put("errMsg",e.toString());
		}
		return modelMap;
		
	}
}
