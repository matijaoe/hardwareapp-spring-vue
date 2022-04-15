import type { HardwareDTO } from "@/models/hardware";
import * as hardwareService from "@/services/hardware";
import { set } from "@vueuse/core";

export const useHardwareStore = defineStore("hardware", () => {
  const hardware = ref<HardwareDTO[]>([]);

  const fetchHardware = async () => {
    try {
      const hardwareRes = await hardwareService.getAllHardware();

      if (!hardwareRes || (hardwareRes && "error" in hardwareRes)) {
        throw new Error("Error fetching hardware");
      }

      set(hardware, hardwareRes);
      return hardware;
    } catch (err: any) {
      console.error(err.message, err);
      return null;
    }
  };

  const fetchHardwareByCode = async (code: string) => {
    try {
      const hardwareRes = await hardwareService.getHardwareByCode(code);
      console.log("hardwareRes :>> ", hardwareRes);

      if (!hardwareRes || (hardwareRes && "error" in hardwareRes)) {
        throw new Error("Error fetching hardware");
      }

      return hardware;
    } catch (err: any) {
      console.error(err.message, err);
      return null;
    }
  };

  const getHardwareByCode = (code: string) =>
    hardware.value?.find((h) => h.code === code) || null;

  return {
    hardware,
    fetchHardware,
    fetchHardwareByCode,
    getHardwareByCode,
  };
});

if (import.meta.hot)
  import.meta.hot.accept(acceptHMRUpdate(useHardwareStore, import.meta.hot));
