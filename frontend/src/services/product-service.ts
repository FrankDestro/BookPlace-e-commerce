import axios, { AxiosRequestConfig } from "axios";
import { BASE_URL } from "../utils/system";
import { requestBackend } from "../utils/request";

export function findAll()  {
    return axios.get(`${BASE_URL}/products?size=12`)
}

export function findPageRequest(page : number, name: string, size = 15, sort = 'name')  {
    const config : AxiosRequestConfig = {
      method : "GET",
      url : '/products',
      params : {
        page,
        name,
        size,
        sort
      }

    }
    return requestBackend(config);
}

export function findById(id: number)  {
    return requestBackend({ url : `/products/${id}` }) 
}

