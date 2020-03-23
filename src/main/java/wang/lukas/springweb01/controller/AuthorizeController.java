package wang.lukas.springweb01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import wang.lukas.springweb01.dto.AccessTokenDto;
import wang.lukas.springweb01.dto.GithubUser;
import wang.lukas.springweb01.provider.GithubProvider;

/**
 * @Author: CoffeeChicken
 * @date: 2020/3/14 15:26
 */
@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String clientId;

    @Value("${github.client.secret}")
    private String clientSecret;

    @Value("${github.redirect.uri}")
    private String redirectUri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state){
        AccessTokenDto accessTokenDto = new AccessTokenDto();
        accessTokenDto.setCode(code);
        //accessTokenDto.setClient_id("Iv1.a02d2877c0c6185d");
        //accessTokenDto.setClient_secret("f4c1a2c625563a63b1487e5d74a11ec579f995c3");
        //accessTokenDto.setRedirect_uri("http://localhost:8887/callback");
        accessTokenDto.setClient_id(clientId);
        accessTokenDto.setClient_secret(clientSecret);
        accessTokenDto.setRedirect_uri(redirectUri);
        accessTokenDto.setState(state);
        String accessToken = githubProvider.getAccessToken(accessTokenDto);

        GithubUser user = githubProvider.getUser(accessToken);
        System.out.println(user.getName());
        return "index";
    }
}
