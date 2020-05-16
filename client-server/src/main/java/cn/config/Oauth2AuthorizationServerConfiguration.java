package cn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import javax.annotation.Resource;
import javax.sql.DataSource;
@Configuration
@EnableAuthorizationServer
public class Oauth2AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
    @Resource
    private DataSource dataSource;
    @Bean
    public TokenStore tokenStore(){
        return  new JdbcTokenStore(dataSource);
    }
    @Bean
    public ClientDetailsService jdbcClientDetailsService(){
        return new JdbcClientDetailsService(dataSource);
    }
    @Override
    public void configure(ClientDetailsServiceConfigurer clients)
            throws Exception {
        //从数据库中的第三方应用信息表中查询相应的记录,如果不是已经登记在数据中的应用,不允许使用oauth授权登录
                                   // 数据库管理client
        clients.withClientDetails(jdbcClientDetailsService());
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints)
            throws Exception {

        // 用户信息查询服务
        //endpoints.userDetailsService(userDetailsService);

        // 数据库管理access_token和refresh_token
     /*   TokenStore tokenStore = new JdbcTokenStore(dataSource);*/

        endpoints.tokenStore(tokenStore());

      //  ClientDetailsService clientService = new JdbcClientDetailsService(
               // dataSource);

       // DefaultTokenServices tokenServices = new DefaultTokenServices();
       // tokenServices.setTokenStore(tokenStore);
       // tokenServices.setSupportRefreshToken(true);
       // tokenServices.setClientDetailsService(clientService);
        // tokenServices.setAccessTokenValiditySeconds(180);
        // tokenServices.setRefreshTokenValiditySeconds(180);

        //endpoints.tokenServices(tokenServices);

       // endpoints.authenticationManager(authenticationManager);

        // 数据库管理授权码
       // endpoints.authorizationCodeServices(new JdbcAuthorizationCodeServices(
                //dataSource));
        // 数据库管理授权信息
        //ApprovalStore approvalStore = new JdbcApprovalStore(dataSource);
       // endpoints.approvalStore(approvalStore);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //允许第三方应用通过表单传递client——id，client_secret来登录
        security.tokenKeyAccess("permitAll()")
                .allowFormAuthenticationForClients();
    }
    class CustomTokenServices extends DefaultTokenServices {
        /**
         * 方案一 设置数据库隔离级别为串行
         * @param authentication
         * @return
         * @throws AuthenticationException
         */
       /* @Transactional(rollbackFor = Exception.class, isolation = Isolation.SERIALIZABLE)
        @Override
        public OAuth2AccessToken createAccessToken(
                OAuth2Authentication authentication) throws AuthenticationException {
            return super.createAccessToken(authentication);
        }*/

        /**
         * 方案二 同步方法
         * @param authentication
         * @return
         * @throws AuthenticationException
         */
        @Override
        public synchronized OAuth2AccessToken createAccessToken(
                OAuth2Authentication authentication) throws AuthenticationException {
            return super.createAccessToken(authentication);
        }
    }
}
