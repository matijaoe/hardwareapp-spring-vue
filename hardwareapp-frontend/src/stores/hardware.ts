import type { HardwareDTO } from "@/models/hardware";
import { getAllHardware, getHardwareByCode } from "@/services/hardware";
import { set } from "@vueuse/core";

export const useHardwareStore = defineStore("hardware", () => {
  const hardware = ref<HardwareDTO[]>([]);

  const fetchHardware = async () => {
    try {
      const data = await getAllHardware();
      if (data) {
        set(hardware, data);
        return hardware.value;
      }
      return null;
    } catch (err: any) {
      console.error(err.message, err);
      return null;
    }
  };

  const fetchHardwareByCode = async (code: string) => {
    try {
      const data = await getHardwareByCode(code);
      if (data) {
        return data;
      }
      return null;
    } catch (err: any) {
      console.error(err.message, err);
      return null;
    }
  };

  const getStoredHardware = (code: string) =>
    hardware.value?.find((h) => h.code === code) || null;

  return {
    hardware,
    fetchHardware,
    fetchHardwareByCode,
    getHardwareByCode,
    getStoredHardware,
  };
});

if (import.meta.hot)
  import.meta.hot.accept(acceptHMRUpdate(useHardwareStore, import.meta.hot));
