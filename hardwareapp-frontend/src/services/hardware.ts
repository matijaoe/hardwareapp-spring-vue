import type { Hardware, HardwareDTO } from "@/models/hardware";
import { parseData } from ".";
import http from "./http";

export const getAllHardware = () =>
  http.get<HardwareDTO[]>("/hardware").then(parseData);

export const getHardwareByCode = (code: string) =>
  http.get<HardwareDTO>(`/hardware/${code}`).then(parseData);

export const addHardware = (hardware: Hardware) =>
  http.post<HardwareDTO>(`/hardware`, hardware).then(parseData);

export const deleteHardware = (code: string) =>
  http.delete<HardwareDTO>(`/hardware/${code}`).then(parseData);
