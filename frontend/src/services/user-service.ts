import { AxiosRequestConfig } from "axios";
import { requestBackend } from "../utils/request";

export function findUserLogged() {
    const config : AxiosRequestConfig = {
        url: "/user/logged", 
        withCredentials : true
    }

    return requestBackend(config)
}
