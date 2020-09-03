package com.jurini.controller;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jurini.alarm_info.service.Alarm_InfoService;
import com.jurini.alarm_info.vo.Alarm_InfoVO;

@Controller
public class Alarm_InfoController {

	@Resource(name = "Alarm_InfoService")
    private Alarm_InfoService alarm_infoService;
    
    @RequestMapping(value ="alarmInfoList.do" , method = RequestMethod.POST)
    public @ResponseBody List<Alarm_InfoVO> alarmInfoList(@RequestParam(value="client_id") String client_id) throws ClassNotFoundException, SQLException{
          
          return alarm_infoService.Alarm_InfoList(client_id);
    }
    
    @RequestMapping(value ="insertAlarmData.do" , method = RequestMethod.POST)
    public @ResponseBody int  insertAlarmData(@RequestBody Alarm_InfoVO alarm_InfoVO) throws ClassNotFoundException, SQLException{
          
    	return alarm_infoService.insertAlarm_Data(alarm_InfoVO);
    }
    
    @RequestMapping(value ="updateAlarmData.do" , method = RequestMethod.POST)
    public @ResponseBody int  updateAlarmData(@RequestBody Alarm_InfoVO alarm_InfoVO) throws ClassNotFoundException, SQLException{
          
    	return alarm_infoService.updateAlarm_Data(alarm_InfoVO);
    }
    
    @RequestMapping(value ="deleteAlarmData.do" , method = RequestMethod.POST)
    public @ResponseBody int  deleteAlarmData(@RequestBody Alarm_InfoVO alarm_InfoVO) throws ClassNotFoundException, SQLException{
          
    	return alarm_infoService.deleteAlarm_Data(alarm_InfoVO);
    }
}
