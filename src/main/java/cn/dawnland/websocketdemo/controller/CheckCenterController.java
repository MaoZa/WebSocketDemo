package cn.dawnland.websocketdemo.controller;

import cn.dawnland.websocketdemo.model.ReturnData;
import cn.dawnland.websocketdemo.websocket.WebSocketServer;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Cap_Sub
 */
@RestController
@RequestMapping("/checkcenter")
public class CheckCenterController {

    /**
     * 页面请求
     * @param cid
     * @return
     */
    @GetMapping("/socket/{cid}")
    @ApiOperation("页面请求")
    public ReturnData socket(@PathVariable String cid) {
        Map data = new HashMap();
        data.put("cid", cid);
        return ReturnData.isOk().data(data);
    }

    /**
     * 推送数据接口
     * @param cid
     * @param message
     * @return
     * @throws IOException
     */
    @PostMapping("/socket/push/{cid}")
    @ApiOperation("推送数据接口")
    public ReturnData pushToWeb(@PathVariable String cid, String message) {
        try {
            WebSocketServer.sendInfo(message,cid);
        } catch (Exception e) {
            e.printStackTrace();
            return ReturnData.isFail(cid + "#" + e.getMessage());
        }
        return ReturnData.isOk(cid);
    }
}