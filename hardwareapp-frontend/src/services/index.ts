import type { AxiosResponse } from "axios";

export const parseData = <T>(response: AxiosResponse<T>) => response.data;
