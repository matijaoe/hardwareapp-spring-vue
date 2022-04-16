import type { HardwareDTO } from "@/models/hardware";
import { getAllHardware } from "@/services/hardware";
import { shuffleArray } from "@/utils";
import { set } from "@vueuse/core";

export const useHardwareStore = defineStore("hardware", () => {
  const hardware = ref<HardwareDTO[]>([]);

  const hasHardware = computed(() => hardware.value?.length > 0);

  const fetchHardware = async () => {
    try {
      const data = await getAllHardware();
      set(hardware, data ?? []);
      return hardware.value;
    } catch (err: any) {
      console.error(err.message, err);
      set(hardware, []);
    }
  };

  const shuffleHardware = () => shuffleArray(hardware.value);

  return {
    hardware,
    hasHardware,
    fetchHardware,
    shuffleHardware,
  };
});

if (import.meta.hot)
  import.meta.hot.accept(acceptHMRUpdate(useHardwareStore, import.meta.hot));
