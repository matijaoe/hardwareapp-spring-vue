import type { HardwareDTO } from "@/models/hardware";
import { parseData } from ".";
import http from "./http";

export const getAllHardware = () =>
  http.get<HardwareDTO[]>("/hardware").then(parseData);

export const getHardwareByCode = (code: string) =>
  http.get<HardwareDTO>(`/hardware/${code}`).then(parseData);
