package com.money.controller;

import com.money.comom.RspMsg;
import com.money.entity.User;
import com.money.server.UserServer;
import com.money.utils.impl.CacheUtil;
import com.omney.query.Login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version V1.0
 * @Package com.money.controller
 * @ClassName ExternalController
 * @Description TODO
 * @Author 王振鹏
 * @date 2020/12/20 22:35
 **/
@RestController
@RequestMapping("/")
public class ExternalController {

    private Logger log = LoggerFactory.getLogger(ExternalController.class);

    @Autowired
    private UserServer userServer;


    @RequestMapping(value = "/login.po",method = {RequestMethod.POST})
    public RspMsg Login(@RequestBody Login login) throws Exception{
        return this.userServer.Login(login);
    }

    @RequestMapping(value = "/one.po",method = {RequestMethod.GET})
    public RspMsg one() throws Exception{
        return this.userServer.listObjects();
    }

    @RequestMapping(value = "/two.po",method = {RequestMethod.GET})
    public void three() throws Exception{
        CacheUtil.put("eyJhbGciOiJSUzI1NiIsImtpZCI6IjA5ZmFlMmNjZDk3ODRhZTk4MTA1ZDczODhlMDE4NWMzIn0.eyJqdGkiOiJBd1I3ZVRhejFTSm00eUZHaFNZZm53IiwiaWF0IjoxNjA4NDgxNTMyLCJleHAiOjE2MDg0ODUxMzIsIm5iZiI6MTYwODQ4MTQ3MiwiYWNjb3VudCI6IlVzZXJ7aWQ9MSwgbmFtZT0nMjMnLCBudW1iZXI9JzEyMycsIGFnZT0zMiwgc2V4PScxJywgcHdkPSc0NTYnLCBwaG9uZT0nMzIxMycsIGhlYWRfaW1nPScxMjMxMicsIGlkZW50aXR5PScxMicsIGF1dG9ueW09MzMsIHBheV9wd2Q9MTIzLCBjcmVhdF90aW1lPVdlZCBEZWMgMDkgMDc6MTc6MjEgQ1NUIDIwMjB9In0.CIPXO8pjqBH2odVhYnSoK3gkn5PtO6gRsDNLps2mEwCY216VHelCC2LL2gLVao1i17c2O_D3vfR7BMRtShvHNtk0qFtlIdB3cnpeoiESUjzlIx7iMJP1Br3zpvw39dezOnjSwOsOvL75ttbfsAPROtD_tGC2rwF4MKgx10yao-kbDwClgUCRKDKZGI5nIzcOLc_xCJxIiqBJiyGX8VFymnLZNoay6xcS8RFb_Rv9LiQSSIkyWW2Kn7HapCMHy2tS-W3jk5IZXqEw-hvdgayIorqldVcfHUNIcCuk2NMnNU_jVebmr1VX9BUOA-cAsddxWPZKKo58aObHkrjPjSdEzQ","123456");
    }

    @RequestMapping(value = "/three.po",method = {RequestMethod.GET})
    public void two() throws Exception{

        log.info(CacheUtil.get("eyJhbGciOiJSUzI1NiIsImtpZCI6IjA5ZmFlMmNjZDk3ODRhZTk4MTA1ZDczODhlMDE4NWMzIn0.eyJqdGkiOiJBd1I3ZVRhejFTSm00eUZHaFNZZm53IiwiaWF0IjoxNjA4NDgxNTMyLCJleHAiOjE2MDg0ODUxMzIsIm5iZiI6MTYwODQ4MTQ3MiwiYWNjb3VudCI6IlVzZXJ7aWQ9MSwgbmFtZT0nMjMnLCBudW1iZXI9JzEyMycsIGFnZT0zMiwgc2V4PScxJywgcHdkPSc0NTYnLCBwaG9uZT0nMzIxMycsIGhlYWRfaW1nPScxMjMxMicsIGlkZW50aXR5PScxMicsIGF1dG9ueW09MzMsIHBheV9wd2Q9MTIzLCBjcmVhdF90aW1lPVdlZCBEZWMgMDkgMDc6MTc6MjEgQ1NUIDIwMjB9In0.CIPXO8pjqBH2odVhYnSoK3gkn5PtO6gRsDNLps2mEwCY216VHelCC2LL2gLVao1i17c2O_D3vfR7BMRtShvHNtk0qFtlIdB3cnpeoiESUjzlIx7iMJP1Br3zpvw39dezOnjSwOsOvL75ttbfsAPROtD_tGC2rwF4MKgx10yao-kbDwClgUCRKDKZGI5nIzcOLc_xCJxIiqBJiyGX8VFymnLZNoay6xcS8RFb_Rv9LiQSSIkyWW2Kn7HapCMHy2tS-W3jk5IZXqEw-hvdgayIorqldVcfHUNIcCuk2NMnNU_jVebmr1VX9BUOA-cAsddxWPZKKo58aObHkrjPjSdEzQ"));
    }


}
