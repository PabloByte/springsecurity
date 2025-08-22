package com.querywithapi.querywithapiexercice.security.filter;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.querywithapi.querywithapiexercice.model.UserAccount;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static com.querywithapi.querywithapiexercice.security.TokenJwtConfig.*;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

  private final  AuthenticationManager authenticationManager;

  public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
    super.setFilterProcessesUrl("/apiUserAccount/login");
    this.authenticationManager = authenticationManager;
   
  }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        
      UserAccount userAccount = null;
      String userName = null;
      String password = null;

      try {
        userAccount = new ObjectMapper().readValue(request.getInputStream(), UserAccount.class);
        userName = userAccount.getEmail();
        password = userAccount.getPassword();

      } catch (StreamReadException e) {
      
        e.printStackTrace();
      } catch (DatabindException e) {
       
        e.printStackTrace();
      } catch (IOException e) {
       
        e.printStackTrace();
      }
UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userName,password);

return authenticationManager.authenticate(authenticationToken);

    }


  
  
  
  
  
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

                  //CASTEO AL USER DE SPRINGSECURITY
      User user = (User) authResult.getPrincipal();

      String username = user.getUsername();

      java.util.Collection <? extends GrantedAuthority> roles = authResult.getAuthorities();


      Claims claims = Jwts.claims().add("authorities", roles)
      .add("userName",username)
      .build();
    

      

      String token = Jwts.builder()
      .subject(username)
      .expiration(new Date(System.currentTimeMillis() + 3600000)) // tiempo que sera valido el token
      .issuedAt(new Date())
      .signWith(SECR_KEY)
      .compact();

      response.addHeader(HEADER_AUTHORIZATION, PREFIX_TOKEN+ token);

      Map<String,String> body = new HashMap<>();

      body.put("token", token);
      body.put("userName", username);
      body.put("message", String.format("Hola %s has iniciado sesion con exito", username));

      response.getWriter().write(new ObjectMapper().writeValueAsString(body));
      response.setContentType(CONTENT_TYPE);
      response.setStatus(200);

      
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {

        Map<String,String> body = new HashMap<>();

        body.put("message", "ERROR EN LA AUTENTICACION E INGRESO DE LA CUENTA");
        body.put("error" ,failed.getMessage());

               response.getWriter().write(new ObjectMapper().writeValueAsString(body));
      response.setContentType(CONTENT_TYPE);
      response.setStatus(400);



        
    }

    

  

  
  




}
