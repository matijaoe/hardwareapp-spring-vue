import type { HardwareDTO } from "@/models/hardware";
import { getHardwareByCode } from "@/services/hardware";
import { set } from "@vueuse/core";

export const useItemFetch = () => {
  const loading = ref(false);
  const item = ref<HardwareDTO | null>();

  const fetchItem = async (code: string) => {
    set(loading, true);
    try {
      const hardware = await getHardwareByCode(code);
      set(item, hardware ?? null);
    } catch (err: any) {
      console.error("Error fetching item", err);
      set(item, null);
    } finally {
      set(loading, false);
    }
  };

  return {
    loading,
    item,
    fetchItem,
  };
};
