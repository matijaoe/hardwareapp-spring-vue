import type { HardwareDTO } from "@/models/hardware";
import { shuffleArray } from "@/utils";
import { set } from "@vueuse/core";

export const useHardwareStore = defineStore("hardware", () => {
  const hardware = ref<HardwareDTO[]>([]);

  const hasHardware = computed(() => hardware.value?.length > 0);

  const shuffleHardware = () => shuffleArray(hardware.value);

  const setHardware = (data: HardwareDTO[]) => set(hardware, data);

  return {
    hardware,
    setHardware,
    hasHardware,
    shuffleHardware,
  };
});

if (import.meta.hot)
  import.meta.hot.accept(acceptHMRUpdate(useHardwareStore, import.meta.hot));
