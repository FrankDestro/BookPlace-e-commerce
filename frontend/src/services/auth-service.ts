/* eslint-disable @typescript-eslint/no-unused-vars */
import QueryString from "qs";
import {
  AccessTokenPayLoadDTO,
  CredentialsDTO,
  RoleEnum,
} from "../models/auth";
import { CLIENT_ID, CLIENT_SECRET } from "../utils/system";
import { AxiosRequestConfig } from "axios";
import { requestBackend } from "../utils/request";
import * as accessTokenRepository from "../repository/access-token-repository"
import jwtDecode from "jwt-decode";


// Função para Requisição de Login
export function LoginRequest(loginData: CredentialsDTO) {
  const headers = {
    "Content-Type": "application/x-www-form-urlencoded",
    Authorization: "BASIC " + window.btoa(CLIENT_ID + ":" + CLIENT_SECRET),
  };

  const requestBody = QueryString.stringify({
    ...loginData,
    grant_type: "password",
  });

  const config: AxiosRequestConfig = {
    method: "POST",
    url: "/oauth2/token",
    data: requestBody,
    headers,
  };

  return requestBackend(config);
}

// Funções para manipular Token no LocalStorage
export function Logout() {
  accessTokenRepository.removeToken();
}

export function saveAccessToken(token: string) {
  accessTokenRepository.saveToken(token);
}

export function getAccessToken() {
  return accessTokenRepository.getToken();
}



// FUNÇÃO PARA PEGAR AS INFORMAÇÕES DO PAYLOAD DO TOKEN.
export function getAccessTokenPayload(): AccessTokenPayLoadDTO | undefined {
  try {
    const token = accessTokenRepository.getToken();
    return token == null
      ? undefined
      : (jwtDecode(token) as AccessTokenPayLoadDTO)
  } catch (error) {
    return undefined;
  }
}


// Função para saber se usuario esta autenticado verificando se o token não esta expirado. 
export function isAuthenticated(): boolean {
  let tokenPayload = getAccessTokenPayload();

  if (tokenPayload && tokenPayload.exp * 1000 > Date.now()) {
    return true
  } else {
    return false
  }
  // return tokenPayload && tokenPayload.exp * 1000 > Date.now() ? true : false;
}


// Função para saber se usuário possui Roles especificas 
export function hasAnyRoles(roles: RoleEnum[]): boolean {
  if (roles.length === 0) {
    return true;
  }

  const tokenPayload = getAccessTokenPayload();

  if (tokenPayload !== undefined) {
    for (var i = 0; i < roles.length; i++) {
      if (tokenPayload.authorities.includes(roles[i])) {
        return true;
      }
    }
    //return roles.some(role => tokenData.authorities.includes(role));
  }
  return false;
}
