import type { Result } from "@/models/api";
import type { Hardware, HardwareDTO } from "@/models/hardware";
import { handleError, parseData } from ".";

const BASE_URL = import.meta.env.VITE_API_URL;

export const getAllHardware = (): Result<HardwareDTO[]> =>
  fetch(`${BASE_URL}/hardware`).then(parseData).catch(handleError);

export const getHardwareByCode = (code: string): Result<Hardware> =>
  fetch(`${BASE_URL}/hardware/${code}`).then(parseData).catch(handleError);
