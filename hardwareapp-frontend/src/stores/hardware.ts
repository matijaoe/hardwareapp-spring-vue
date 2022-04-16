import type { HardwareDTO } from "@/models/hardware";
import { getAllHardware } from "@/services/hardware";
import { shuffleArray } from "@/utils";
import { set } from "@vueuse/core";

export const useHardwareStore = defineStore("hardware", () => {
  const hardware = ref<HardwareDTO[]>([]);
  const loading = ref(false);

  const hasHardware = computed(() => hardware.value?.length > 0);

  const fetchHardware = async () => {
    try {
      set(loading, true);
      const data = await getAllHardware();
      set(hardware, data ?? []);
    } catch (err: any) {
      console.error(err.message, err);
      set(hardware, []);
    } finally {
      set(loading, false);
    }
  };

  const shuffleHardware = () => shuffleArray(hardware.value);

  return {
    hardware,
    hasHardware,
    fetchHardware,
    shuffleHardware,
    loading,
  };
});

if (import.meta.hot)
  import.meta.hot.accept(acceptHMRUpdate(useHardwareStore, import.meta.hot));
