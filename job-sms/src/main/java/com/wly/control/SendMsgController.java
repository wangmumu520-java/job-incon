package com.wly.control;

import com.wly.constant.CaptchaCst;
import com.wly.dto.ResponseDTO;
import com.wly.exception.IllegalCaptchaException;
import com.wly.utils.SMSUtils;
import com.wly.vo.MsgVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@SuppressWarnings("all")
@RestController
@Slf4j
@RequestMapping("captcha")
public class SendMsgController {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private SMSUtils smsUtils;

    @PostMapping("captchas")
    public ResponseDTO sendCaptchas(@RequestBody MsgVO msgVO){
        //1.获取接收到的手机号
        String phone = msgVO.getPhone();
        log.info("发送短信的手机号为: {}", phone);
        //判断该手机验证码是否重复发送
        String timeoutKey = CaptchaCst.TIMEOUT_KEY+phone;
        if (stringRedisTemplate.hasKey(timeoutKey)){
            throw new IllegalCaptchaException("提示: 不允许重复发送!");
        }
        try {
            //3.生成4位随机字符
            String code = RandomStringUtils.randomNumeric(4);
            log.info("发送的验证码: {}", code);
            //4.根据接收手机号以及生成随机字符 发送验证码
            smsUtils.sendMsg(phone,code);
            //5.将验证码放入redis并设置过期时间 60s有效
            stringRedisTemplate.opsForValue().set(CaptchaCst.PHONE_KEY+phone,code,60, TimeUnit.SECONDS);
            //6.验证码在60s内,不允许重新发送
            stringRedisTemplate.opsForValue().set(timeoutKey,"true",60,TimeUnit.SECONDS);
            ResponseDTO response = new ResponseDTO();
            response.setSuccess(true);
            response.setMessage("短信发送成功");
            return response;
        }catch (Exception e){
            e.printStackTrace();
            throw new IllegalCaptchaException("提示: 短信发送失败!");
        }
    }

    @GetMapping("test")
    public String test() {
        return "test is ok";
    }

}
