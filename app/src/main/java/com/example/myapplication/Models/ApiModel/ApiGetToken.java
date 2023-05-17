package com.example.myapplication.Models.ApiModel;

public class ApiGetToken {
   public String[] Messages;
   public boolean IsSuccess;
  public   TokenData Data;
   public class TokenData
    {
       public int UserId;
       public String TokenValue;
    }
}
