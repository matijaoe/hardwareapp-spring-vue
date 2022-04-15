import axios from "axios";
import { resHandler } from "./interceptors";

const http = axios.create({
  baseURL: import.meta.env.VITE_API_URL as string,
});

http.interceptors.response.use(resHandler);

export default http;
