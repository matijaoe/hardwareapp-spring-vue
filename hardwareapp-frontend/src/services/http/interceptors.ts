import type { AxiosResponse } from "axios";

export const resHandler = <T>(response: AxiosResponse<T>) => response;
